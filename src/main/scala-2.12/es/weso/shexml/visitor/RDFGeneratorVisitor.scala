package es.weso.shexml.visitor

import java.io.{File, StringReader}
import java.sql.DriverManager
import java.util

import collection.JavaConverters._
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tototoshi.csv.{CSVReader, DefaultCSVFormat}
import es.weso.shexml.ast.{AST, AutoIncrement, CSVPerRow, DataTypeGeneration, DataTypeLiteral, Declaration, Exp, ExpOrVar, FieldQuery, Graph, IRI, IteratorQuery, JdbcURL, Join, JsonPath, LangTagGeneration, LangTagLiteral, LiteralObject, LiteralObjectValue, Matcher, Matchers, ObjectElement, Predicate, PredicateObject, Prefix, QueryClause, RDFAlt, RDFBag, RDFCollection, RDFList, RDFSeq, ShExML, Shape, ShapeLink, ShapeVar, Sparql, SparqlColumn, SparqlQuery, Sql, SqlColumn, SqlQuery, StringOperation, URL, Union, Var, VarResult, Variable, XmlPath}
import es.weso.shexml.helper.SourceHelper
import es.weso.shexml.shex.ShExMLInferredCardinalitiesAndDatatypes
import es.weso.shexml.visitor
import kantan.xpath.XPathCompiler

import scala.collection.mutable
import kantan.xpath.implicits._
import org.apache.jena.datatypes.{RDFDatatype, TypeMapper}
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.query.{Dataset, QueryExecutionFactory, QueryFactory, ResultSet}
import org.apache.jena.rdf.model.{AnonId, Model, ModelFactory, RDFNode, Resource, ResourceFactory, Statement}
import org.apache.jena.riot.RDFDataMgr
import org.apache.jena.util.SplitIRI

import scala.util.Try

/**
  * Created by herminio on 26/12/17.
  */
class RDFGeneratorVisitor(dataset: Dataset, varTable: mutable.HashMap[Variable, VarResult], username: String, password: String,
                          shexInferredPropertiesTable: mutable.ListBuffer[ShExMLInferredCardinalitiesAndDatatypes] = mutable.ListBuffer.empty[ShExMLInferredCardinalitiesAndDatatypes])
  extends DefaultVisitor[Any, Any] with JdbcDriverRegistry {

  protected val prefixTable = mutable.HashMap[String, String](("rdf:", "http://www.w3.org/1999/02/22-rdf-syntax-ns#"))
  protected val iteratorsCombinations = mutable.HashMap[String, List[Result]]()
  protected val pushedQueries = mutable.HashMap[String, QueryClause]()
  protected val queryResultCache = new QueryResultsCache()
  protected val alreadyGeneratedCollections = mutable.ListBuffer[String]()

  override def doVisit(ast: AST, optionalArgument: Any): Any = ast match {

    case ShExML(declarations, graphs, shapes) => {
      declarations.foreach(doVisit(_, optionalArgument))
      val firstGraph = graphs.map(doVisit(_, optionalArgument)).headOption
      val linkedShapes = shapes.flatMap(_.predicateObjects.flatMap(_.objectOrShapeLink match {
        case ShapeLink(shapeVar) => List(shapeVar)
        case _ => List()
      }))
      val firstShape = shapes.filterNot(s => linkedShapes.contains(s.shapeName)).map(doVisit(_, optionalArgument)).headOption
      if(firstShape.isEmpty) firstGraph.get
    }

    case Declaration(declarationStatement) => {
      if(declarationStatement.isInstanceOf[Prefix])
        doVisit(declarationStatement, optionalArgument)
    }

    case Prefix(variable, url) => {
      prefixTable += ((variable.name, url.url))
      dataset.getDefaultModel.setNsPrefix(variable.name.replace(":", ""), url.url)
    }

    case Graph(graphName, shapes) => {
      shapes.map(doVisit(_, optionalArgument))
    }

    case Shape(shapeName, shapePrefix, action, predicateObjects, holdingGraph) => {
      val graphName = holdingGraph.map(g => prefixTable.getOrElse(g.graphName.prefix, "") + g.graphName.name).getOrElse("")
      val output = if(holdingGraph.isEmpty) dataset.getDefaultModel else dataset.getNamedModel(graphName)
      val predicateObjectsList = predicateObjects.map(doVisit(_, optionalArgument))
      val actions = visitAction(action, predicateObjectsList, optionalArgument)
      val finalActions = for(a <- actions) yield {
        val predicateObjectsWithAutoIncrements = solveAutoIncrementResults(predicateObjectsList, a)
        val finalPredicateObjectsList = predicateObjectsWithAutoIncrements.filter(i => i.rootIds.contains(a.id) ||
          i.id == a.id || (i.id.isEmpty && i.rootIds.isEmpty) || a.id.isEmpty)
        for(result <- finalPredicateObjectsList) {
          val predicateObjects = result.results.map(_.toString.split(" ", 2))
          val action = normaliseURI(a.results.head)
          result.rdfCollection match {
            case None => {
              for (predicateObject <- predicateObjects) {
                registerCardinalityAndDatatype(shapeName.name, predicateObject, result)
                createTriple(shapePrefix, action, predicateObject, result, output)
              }
            }
            case Some(rdfCollection) => {
              val predicateObjectsList = finalPredicateObjectsList.filter(_.rdfCollection.isDefined).flatMap(_.results).map(_.toString.split(" ", 2))
              val groupedPredicateObjects = predicateObjectsList.groupBy(i => i(0))
              val keys = groupedPredicateObjects.keys
              for (key <- keys) {
                if(!alreadyGeneratedCollections.contains(key + groupedPredicateObjects(key).map(_(1)).mkString(""))) {
                  alreadyGeneratedCollections += key + groupedPredicateObjects(key).map(_(1)).mkString("")
                  registerCardinalityAndDatatype(shapeName.name, groupedPredicateObjects(key).head, result)
                  createTripleWithCollection(shapePrefix, action, groupedPredicateObjects(key), result, output, rdfCollection)
                }
              }
            }
          }

        }
        a
      }
      finalActions.map(r => Result(r.id, r.rootIds, r.results.map(ir => {
        val namespace = if(ir.startsWith("_:")) "" else prefixTable.getOrElse(shapePrefix, "_:")
        namespace + ir
      }), r.dataType, r.langTag, r.rdfCollection))
    }

    case PredicateObject(predicate, objectOrShapeLink) => {
      val predicateResult = doVisit(predicate, optionalArgument)
      val objectResult = doVisit(objectOrShapeLink, optionalArgument)
      if(predicateResult != null && objectResult != null)
        objectResult match {
          case lr: List[Result] => lr.map(result => {
            val results = result.results.map(predicateResult.toString + " " + _)
            Result(result.id, result.rootIds, results, result.dataType, result.langTag, result.rdfCollection)
          })
          case ResultAutoIncrement(iterator, _, namespace, dataType, langTag) =>
            visitor.ResultAutoIncrement(iterator, predicateResult.toString, namespace, dataType, langTag)
        }
      else Nil
    }

    case Predicate(prefix, extension) => {
      prefixTable(prefix) + extension
    }

    case ObjectElement(prefix, action, literalValue, matcher, dataType, langTag, rdfCollection) => {
      val result = action match {
        case Some(value) => doVisit(value, optionalArgument)
        case None => literalValue match {
          case Some(literal) => doVisit(literal, optionalArgument)
          case None => throw new Exception("No generation clause given.")
        }
      }
      val matchedResultList = matcher match {
        case Some(matcherVar) => doVisit(matcherVar, result)
        case None => result
      }
      val dataTypeResult = dataType.map(doVisit(_, optionalArgument))
      val langTagResult = langTag.map(doVisit(_, optionalArgument))
      result match {
        case _: List[Result] =>
          matchedResultList.asInstanceOf[List[Result]].map(result => {
          val newResults = result.results.map(prefixTable.getOrElse(prefix, "") + _)
          val dataTypeValue = dataTypeResult.map({
            case dataTypeResults: List[Result] => dataTypeResults.filter(_.id == result.id).head.results.head
            case value: String => value
          })
          val langTagValue = langTagResult.map({
            case langTagResults: List[Result] => langTagResults.filter(_.id == result.id).head.results.head
            case value: String => value
          })
          Result(result.id, result.rootIds, newResults, normaliseDataType(dataTypeValue), langTagValue, rdfCollection)
        })
        case ResultAutoIncrement(iterator, predicate, _, _, _) =>
          val dataTypeValue = dataTypeResult.map({
            case _: List[Result] => throw new Exception("Autoincrement values cannot have a generated dataType")
            case value: String => value
          })
          val langTagValue = langTagResult.map({
            case _: List[Result] => throw new Exception("Autoincrement values cannot have a generated langTag")
            case value: String => value
          })
          visitor.ResultAutoIncrement(iterator, predicate, prefixTable.getOrElse(prefix, ""), normaliseDataType(dataTypeValue), langTagValue)
        case _ => result
      }
    }

    case Union(left, right) => {
      val expName = optionalArgument.asInstanceOf[Map[String, Any]].getOrElse("varName", "")
      val leftList = doVisit(left, optionalArgument)
      val rightList = doVisit(right, optionalArgument)
      leftList match {
        case ml: Map[String, List[Result]] => rightList match {
          case mr: Map[String, List[Result]] => ml.keySet.union(mr.keySet).map(k => {
            val leftResult = mr.getOrElse(k, Nil)
            val rightResult = ml.getOrElse(k, Nil)
            val value = expName + k -> leftResult.union(rightResult)
            iteratorsCombinations += value
            k -> leftResult.union(rightResult)
          }).toMap
          case _ => throw new Exception("Impossible to combine an iterator with a non iterator expression")
        }
        case l: List[Result] => l.union(rightList.asInstanceOf[List[Result]])
      }
    }

    case Join(left, right, join) => {
      val expName = optionalArgument.asInstanceOf[Map[String, Any]].getOrElse("varName", "")
      val leftList = doVisit(left, optionalArgument)
      val rightList = doVisit(right, optionalArgument)
      val joinList = doVisit(join, optionalArgument)
      leftList match {
        case ml: Map[String, List[Result]] => rightList match {
          case mr: Map[String, List[Result]] => joinList match {
            case mj: Map[String, List[Result]] => ml.keySet.union(mr.keySet).union(mj.keySet).foreach(k => {
              val leftResult = mr.getOrElse(k, Nil)
              val rightResult = ml.getOrElse(k, Nil)
              val joinResult = mj.getOrElse(k, Nil)
              val value = expName + k -> getJoinResults(leftResult, rightResult, joinResult)
              iteratorsCombinations += value
            })
            case _ => throw new Exception("Cannot join iterator with non iterator expression. Join clause is not an iterator expression")
          }
          case _ => throw new Exception("Cannot join iterator with non iterator expression. Right clause is not an iterator expression")
        }
        case left: List[Result] => getJoinResults(left, rightList.asInstanceOf[List[Result]], joinList.asInstanceOf[List[Result]])
      }
    }

    case StringOperation(left, right, unionString) => {
      val expName = optionalArgument.asInstanceOf[Map[String, Any]].getOrElse("varName", "")
      val leftList = doVisit(left, optionalArgument)
      val rightList = doVisit(right, optionalArgument)
      leftList match {
        case ml: Map[String, List[Result]] => rightList match {
          case mr: Map[String, List[Result]] => ml.keySet.union(mr.keySet).foreach(k => {
            val leftResult = mr.getOrElse(k, Nil)
            val rightResult = ml.getOrElse(k, Nil)
            val value = expName + k -> getStringOperationResults(leftResult, rightResult, unionString)
            iteratorsCombinations += value
          })
          case _ => throw new Exception("Cannot make string operation with left clause being an iterator expression and right clause a non iterator expression")
        }
        case left: List[Result] => getStringOperationResults(left, rightList.asInstanceOf[List[Result]], unionString)
      }
    }

    case i: IteratorQuery => {
      val expName = Option(optionalArgument).map(_.asInstanceOf[Map[String, Any]].getOrElse("varName", "")).getOrElse("")
      val arguments = Option(optionalArgument.asInstanceOf[Map[String, Any]])
      val fileContents = doVisit(i.firstVar, optionalArgument).asInstanceOf[List[Any]]
      val fileContentsToIterate = fileContents.head match {
        case _: String => fileContents
        case _ => List("")
      }
      fileContentsToIterate.map(_.toString).flatMap(fileContent => {
        val fileMap = Map("fileContent" -> fileContent)
        val middleArguments = arguments.map(_.++(fileMap)).getOrElse(fileMap)
        val varList = iteratorQueryToList(i)
        if (varTable(varList.head).isInstanceOf[IRI] && varList.size == 2) {
          val iteratorName = varList.tail.head.name
          val values = varTable.keys.filter {
            case Var(name) => name.contains(iteratorName)
            case _ => false
          }.map {
            case v: Var => v.name.replaceFirst(iteratorName, "") -> {
              val vars = v.name.split("[.]").map(Var).toList
              if (vars.size > 1)
                doIteratorQuery(vars, middleArguments, fileContent)
              else Nil
            }
          }.toMap
          values.foreach {
            case (k, v) => iteratorsCombinations.get(expName + k) match {
              case Some(previousValue) => iteratorsCombinations += expName + k -> (previousValue ::: v.filterNot(previousValue.contains(_)))
              case None => iteratorsCombinations += expName + k -> v
            }
          }
          values
        } else if (varTable(varList.head).isInstanceOf[Exp] && varList.size > 1) {
          iteratorsCombinations(varList.map(_.name).mkString("."))
        } else if (varList.size >= 3) {
          doIteratorQuery(varList.slice(1, varList.size), middleArguments, fileContent)
        } else {
          throw new Exception("Bad number of vars")
        }
      })
    }

    case v: Var => {
      val finalArguments =
        if(optionalArgument == null) Map("varName" -> v.name)
        else optionalArgument match {
          case m: Map[String, Any] => m.+("varName" -> v.name)
          case _ => optionalArgument
        }
      doVisit(varTable(v), finalArguments)
    }

    case sv: ShapeVar => {
      doVisit(varTable(sv), optionalArgument)
    }

    case JsonPath(query) => {
      val arguments = optionalArgument.asInstanceOf[Map[String, Any]]
      val iteratorQuery = arguments.getOrElse("iteratorQuery", "").toString
      val index = arguments.getOrElse("index", "")
      val fileContent = arguments.getOrElse("fileContent", null).asInstanceOf[String]
      val id = (iteratorQuery + fileContent + index).hashCode.toString
      val rootIds = arguments.getOrElse("rootIds", List(id)).asInstanceOf[List[String]]
      val jsonContent = new ObjectMapper().readValue(fileContent, classOf[Object])
      val result = io.gatling.jsonpath.JsonPath.query(query, jsonContent)
      result match {
        case Left(_) => Nil
        case Right(r) => {
          val finalList = r.toList.flatMap({
            case l: util.ArrayList[_] => l.toArray.map(_.toString)
            case default => List(default.toString)
          })
          Result(id, rootIds, finalList, None, None, None)
        }
      }
    }

    case XmlPath(query) => {
      val arguments = optionalArgument.asInstanceOf[Map[String, Any]]
      val iteratorQuery = arguments.getOrElse("iteratorQuery", "").toString
      val index = arguments.getOrElse("index", "")
      val fileContent = arguments.getOrElse("fileContent", null).asInstanceOf[String]
      val id = (iteratorQuery + fileContent + index).hashCode.toString
      val rootIds = arguments.getOrElse("rootIds", List(id)).asInstanceOf[List[String]]
      val compilationResult = XPathCompiler.builtIn.compile(query)
      compilationResult.toOption match {
        case Some(value) => Result(id, rootIds, fileContent.evalXPath[List[String]](value).getOrElse(Nil), None, None, None)
        case None => throw new Exception("Bad iterator query: " + query)
      }
    }

    case a: AutoIncrement => {
      ResultAutoIncrement(a, "", "", None, None)
    }

    case Matchers(_, matchers) => {
      val listToMatch = optionalArgument.asInstanceOf[List[Result]]
      listToMatch.map(r => visitor.Result(r.id, r.rootIds, r.results.map(s => {
        matchers.matchers.foldLeft(s)((value, matcher) => doVisit(matcher, value).asInstanceOf[String])
      }), r.dataType, r.langTag, r.rdfCollection))
    }

    case Matcher(replacedStrings, replacement) => {
      if(replacedStrings.strings.contains(optionalArgument.toString)) replacement else optionalArgument.toString
    }

    case LiteralObject(prefix, value) => {
      val prefixValue = prefixTable(prefix.name)
      List(Result("", Nil, List(prefixValue + value), None, None, None))
    }

    case LiteralObjectValue(value) => {
      List(Result("", Nil, List(value), None, None, None))
    }

    case DataTypeGeneration(prefix, action, matcher) => {
      val result = doVisit(action, optionalArgument)
      val matchedResultList = matcher match {
        case Some(matcherVar) => doVisit(matcherVar, result)
        case None => result
      }
      result match {
        case _: List[Result] =>
          matchedResultList.asInstanceOf[List[Result]].map(result => {
            val newResults = result.results.map(prefixTable.getOrElse(prefix, "") + _)
            Result(result.id, result.rootIds, newResults, None, None, None)
          })
        case _ => result
      }
    }

    case LangTagGeneration(action, matcher) => {
      val result = doVisit(action, optionalArgument)
      val matchedResultList = matcher match {
        case Some(matcherVar) => doVisit(matcherVar, result)
        case None => result
      }
      matchedResultList
    }

    case DataTypeLiteral(value) => {
      value
    }

    case LangTagLiteral(value) => {
      value
    }

    case ShapeLink(shapeVar) => {
      doVisit(shapeVar, optionalArgument)
    }

    case URL(url) => if(url.endsWith("/sparql") || url.endsWith(".ttl") || url.endsWith(".rdf")
      || url.endsWith(".nt") || url.endsWith(".jsonld") || url.endsWith(".owl") || url.endsWith(".trig")
      || url.endsWith(".nq") || url.endsWith(".trix") || url.endsWith(".trdf"))
      List(url)
    else if(url.contains('*') && url.startsWith("file://"))
      getAllFilesContents(url)
    else if(url.contains('*'))
      throw new Exception("* wildcard not allowed over remote files")
    else
      List(new SourceHelper().getURLContent(url))

    case JdbcURL(url) => List(url)

    case default => visit(default, optionalArgument)
  }

  protected def createGraph(statement: Statement): Resource = {
    ResourceFactory.createStmtResource(statement)
  }

  protected def createStatement(s: String, p: String, o: String): Statement = {
    val subject = ResourceFactory.createResource(s)
    val predicate = ResourceFactory.createProperty(p)
    val obj = if(o.contains("_:"))
      dataset.getDefaultModel.createResource(new AnonId(o.replace("_:", "")))
      else ResourceFactory.createResource(o)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  protected def createStatementWithCollection(s: String, p: String, o: Resource): Statement = {
    val subject = ResourceFactory.createResource(s)
    val predicate = ResourceFactory.createProperty(p)
    ResourceFactory.createStatement(subject, predicate, o)
  }

  protected def createBNodeStatement(s: String, p: String, o: String): Statement = {
    val anonID = new AnonId(s)
    val subject = dataset.getDefaultModel.createResource(anonID)
    val predicate = ResourceFactory.createProperty(p)
    val obj = if(o.contains("_:"))
      dataset.getDefaultModel.createResource(new AnonId(o.replace("_:", "")))
      else ResourceFactory.createResource(o)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  protected def createBNodeStatementWithCollection(s: String, p: String, o: Resource): Statement = {
    val anonID = new AnonId(s)
    val subject = dataset.getDefaultModel.createResource(anonID)
    val predicate = ResourceFactory.createProperty(p)
    ResourceFactory.createStatement(subject, predicate, o)
  }

  protected def createStatementWithLiteral(s: String, p: String, o: String, dataType: Option[String] = None, langTag: Option[String] = None): Statement = {
    val subject = ResourceFactory.createResource(s)
    val predicate = ResourceFactory.createProperty(p)
    val xsdType = dataType.map(d => prefixTable(d.split(":")(0) + ":") + d.split(":")(1))
      .map(TypeMapper.getInstance().getSafeTypeByName(_)).getOrElse(searchForXSDType(o))
    val obj = if(langTag.isDefined)
      ResourceFactory.createLangLiteral(o, langTag.get)
      else ResourceFactory.createTypedLiteral(o, xsdType)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  protected def createBNodeStatementWithLiteral(s: String, p: String, o: String, dataType: Option[String] = None, langTag: Option[String] = None): Statement = {
    val anonID = new AnonId(s)
    val subject = dataset.getDefaultModel.createResource(anonID)
    val predicate = ResourceFactory.createProperty(p)
    val xsdType = dataType.map(d => prefixTable(d.split(":")(0) + ":") + d.split(":")(1))
      .map(TypeMapper.getInstance().getSafeTypeByName(_)).getOrElse(searchForXSDType(o))
    val obj = if(langTag.isDefined)
      ResourceFactory.createLangLiteral(o, langTag.get)
    else ResourceFactory.createTypedLiteral(o, xsdType)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  protected def searchForXSDType(o: String): RDFDatatype = {
    if(Try(o.toInt).isSuccess)
      XSDDatatype.XSDinteger
    else if(Try(o.toDouble).isSuccess)
      XSDDatatype.XSDdecimal
    else if(Try(o.toBoolean).isSuccess)
      XSDDatatype.XSDboolean
    else
      XSDDatatype.XSDstring
  }

  protected def normaliseURI(uri: String): String = {
    uri.replaceAll("[\\s,_()']", "_")
      .replace("&quot;", "")
      .replace("&#209;", "N").replace("&#241;", "n")
      .replace("&#220;", "U").replace("&#252;", "u")
  }

  protected def doVisitIteratorQuery(nestedIterator: QueryClause, currentIterator: QueryClause, optionalArgument: Any): Result = nestedIterator match {
    case JsonPath(query) => doVisit(JsonPath(query + currentIterator.query), optionalArgument).asInstanceOf[Result]
    case XmlPath(query) => doVisit(XmlPath(query + currentIterator.query), optionalArgument).asInstanceOf[Result]
  }

  protected def iteratorQueryToList(i: IteratorQuery): List[Var] = i.composedVar match {
    case v: Var => List(i.firstVar, v)
    case c: IteratorQuery => List(i.firstVar) ::: iteratorQueryToList(c)
  }

  protected def iteratorResultsToQueries(iteratorQueries: List[Resultable], query: QueryClause, rootIds: List[String], fileContent: String): List[QueryWithIndex] = iteratorQueries.flatMap({
    case r: ResultWithIteratorQuery => r.results.indices.map(i => query match {
      case XmlPath(xpathQuery) => {
        val composedQuery = XmlPath(xpathQuery.replaceFirst("[*]", (i + 1).toString))
        val rootId = (r.iteratorQuery + fileContent + i.toString).hashCode.toString
        QueryWithIndex(i.toString, rootIds.::(rootId), composedQuery, r.iteratorQuery)
      }
      case JsonPath(jsonpathQuery) => {
        val composedQuery = JsonPath(jsonpathQuery.replaceFirst("[*]", i.toString))
        val rootId = (r.iteratorQuery + fileContent + i.toString).hashCode.toString
        QueryWithIndex(i.toString, rootIds.::(rootId), composedQuery, r.iteratorQuery)
      }
    }).toList
    case r: ResultWithNested => r.results.indices.flatMap(i => query match {
      case XmlPath(xpathQuery) => {
        val indicedQuery = XmlPath(xpathQuery.replaceFirst("[*]", (i + 1).toString))
        val rootId = (r.iteratorQuery + fileContent + i.toString).hashCode.toString
        iteratorResultsToQueries(List(r.nestedResults(i)), indicedQuery, rootIds.::(rootId), fileContent)
      }
      case JsonPath(jsonpathQuery) => {
        val indicedQuery =
          if(r.iteratorQuery.contains("[*]"))
            JsonPath(jsonpathQuery.replaceFirst("[*]", i.toString))
          else
            JsonPath(jsonpathQuery)
        val rootId = (r.iteratorQuery + fileContent + i.toString).hashCode.toString
        iteratorResultsToQueries(List(r.nestedResults(i)), indicedQuery, rootIds.::(rootId), fileContent)
      }
    }).toList
  })

  protected def generateFinalQuery(varList: List[Var], context: String, rootQuery: QueryClause): QueryClause = varList match {
    case x :: Nil => getQueryFromVarTable(Var(context + x.name))
    case x :: xs => getQueryFromVarTable(Var(context + x.name)) match {
      case j: JsonPath => {
        val constructedQuery = JsonPath(j.query + "." + generateFinalQuery(xs, context + x.name + ".", j).query)
        getQueryFromVarTable(Var(context + varList.map(_.name).mkString("."))) match {
          case f: FieldQuery => {
            if(f.pushed) {
              pushedQueries += ((varList.takeRight(1).head.name, constructedQuery))
            }
            if(f.popped) {
              pushedQueries.getOrElse(f.query, constructedQuery)
            } else {
              constructedQuery
            }
          }
          case _ => constructedQuery
        }
      }
      case xp: XmlPath => XmlPath(xp.query + "[*]/" + generateFinalQuery(xs, context + x.name + ".", xp).query)
      case csv: CSVPerRow => CSVPerRow(generateFinalQuery(xs, context + x.name + ".", csv).query)
      case sql: Sql => SqlColumn(sql.query, generateFinalQuery(xs, context + x.name + ".", sql).query)
      case sp: Sparql => SparqlColumn(sp.query, generateFinalQuery(xs, context + x.name + ".", sp).query)
      case FieldQuery(query, pushed, popped) => rootQuery match {
          case j: JsonPath => JsonPath(query + "." + generateFinalQuery(xs, context + x.name + ".", j).query)
          case xp: XmlPath => XmlPath(query + "[*]/" + generateFinalQuery(xs, context + x.name + ".", xp).query)
          case csv: CSVPerRow => CSVPerRow(query)
          case sql: Sql => SqlColumn(rootQuery.query, query)
          case sp: Sparql => SparqlColumn(rootQuery.query, query)
        }

    }
  }

  protected def doIteratorQueries(varList: List[Var], varContext: String, precedentQueries: List[String], arguments: Any, rootQuery: QueryClause): List[Resultable] = varList match {
    case x :: Nil => val results = {
      precedentQueries.map(q => {
        val optionalXPathEnd = if(q.isEmpty) "[*]" else ""
        getQueryFromVarTable(Var(varContext + x.name)) match {
          case JsonPath(query) => (doVisit(JsonPath(q + query), arguments).asInstanceOf[Result], q + query)
          case XmlPath(query) => (doVisit(XmlPath(q + query), arguments).asInstanceOf[Result], q + query + optionalXPathEnd)
          case FieldQuery(query, _, _) => rootQuery match {
            case JsonPath(_) => (doVisit(JsonPath(q + query), arguments).asInstanceOf[Result], q + query)
            case XmlPath(_) => (doVisit(XmlPath(q + query), arguments).asInstanceOf[Result], q + query + optionalXPathEnd)
          }
        }
      })
    }
    results.map(r => ResultWithIteratorQuery(r._1.id, r._1.rootIds, r._1.results, r._2))
    case x :: xs => {
      val queries = precedentQueries.map(q => getQueryFromVarTable(Var(varContext + x.name)) match {
        case JsonPath(query) => JsonPath(q + query)
        case XmlPath(query) => XmlPath(q + query + "[*]")
      })
      val results = queries.map(doVisit(_, arguments).asInstanceOf[Result])
      val newQueries = queries.indices.map(iq => {
        results(iq).results.indices.map(ir => queries(iq) match {
          case JsonPath(query)  => query.replaceFirst("[*]", ir.toString) + "."
          case XmlPath(query) => query.replaceFirst("[*]", (ir + 1).toString) + "/"
        })
      }).toList
      results.indices.map(r => ResultWithNested(results(r).id, results(r).rootIds, results(r).results,
        doIteratorQueries(xs, varContext + x.name + ".", newQueries(r).toList, arguments, queries.head), queries(r).query)).toList
    }
  }

  protected def doIteratorQuery(iteratorVars: List[Var], middleArguments: Map[String, Any], fileContentOrURL: String): List[Result] = {
    generateFinalQuery(iteratorVars, "", null) //to generate pushed vars, this can be improved for performance
    val query = generateFinalQuery(iteratorVars, "", null)
    query match {
      case c: CSVPerRow => doPerRowResults(c, fileContentOrURL)
      case s: SqlColumn => doSqlResults(s, fileContentOrURL)
      case sp: SparqlColumn => doSparqlResults(sp, fileContentOrURL)
      case _ => {
        val iteratorQueries = doIteratorQueries(iteratorVars.slice(0, iteratorVars.size - 1), "", List(""), middleArguments, null)
        val queries = iteratorResultsToQueries(iteratorQueries.filter(_.results.nonEmpty), query, List(), fileContentOrURL)
        queries.map(q => doVisit(q.query, middleArguments.+(
          "index" -> q.index, "rootIds" -> q.rootIds, "iteratorQuery" -> q.iteratorQuery)).asInstanceOf[Result])
          .filter(_.results.nonEmpty)
      }
    }
  }

  private def doSparqlResults(query: SparqlColumn, sparqlEndpointOrRDFLocation: String): List[Result] = {
    val resultMap = queryResultCache.search(query.query, sparqlEndpointOrRDFLocation) match {
      case Some(value) => value.asInstanceOf[Map[String, List[String]]]
      case None => {
        val jenaQuery = QueryFactory.create(query.query)
        val queryExecution = if((sparqlEndpointOrRDFLocation.startsWith("http://")
          || sparqlEndpointOrRDFLocation.startsWith("https://")
          || sparqlEndpointOrRDFLocation.startsWith("file://"))
          && !sparqlEndpointOrRDFLocation.endsWith("/sparql")) {
          val model = RDFDataMgr.loadModel(sparqlEndpointOrRDFLocation)
          QueryExecutionFactory.create(jenaQuery, model)
        } else {
          QueryExecutionFactory.sparqlService(sparqlEndpointOrRDFLocation, jenaQuery)
        }
        val resultSet = queryExecution.execSelect()
        queryResultCache.save(query.query, sparqlEndpointOrRDFLocation, resultSet)
        queryResultCache.search(query.query, sparqlEndpointOrRDFLocation).get.asInstanceOf[Map[String, List[String]]]
      }
    }
    val results = resultMap(query.column)
    val composedResults = for (i <- results.indices) yield {
      val id = (query.query + i).hashCode.toString
      Result(id, List(id), List(results(i)), None, None, None)
    }
    composedResults.toList

  }

  private def doSqlResults(query: SqlColumn, dbURLConnection: String): List[Result] = {
    val resultMap = queryResultCache.search(query.query, dbURLConnection) match {
      case Some(value) => value.asInstanceOf[Map[String, List[String]]]
      case None => {
        val connection = connectToDB(dbURLConnection)
        val statement = connection.prepareStatement(query.query)
        val resultSet = statement.executeQuery()
        queryResultCache.save(query.query, dbURLConnection, resultSet)
        connection.close()
        queryResultCache.search(query.query, dbURLConnection).get.asInstanceOf[Map[String, List[String]]]
      }
    }
    val results = resultMap(query.column)
    val composedResults = for (i <- results.indices) yield {
      val id = (query.query + i).hashCode.toString
      Result(id, List(id), List(results(i)), None, None, None)
    }
    composedResults.toList
  }

  private def connectToDB(dbURL: String) = {
    Class.forName(lookForJdbcDriver(dbURL))
    DriverManager.getConnection(dbURL, username, password)
  }

  private def doPerRowResults(query: QueryClause, fileContent: String): List[Result] = {
    val reader = new StringReader(fileContent)
    val fileDelimiter = inferCSVDelimiter(fileContent)
    implicit object MyCSVFormat extends DefaultCSVFormat {
      override val delimiter = fileDelimiter
    }
    val allLines = CSVReader.open(reader).allWithHeaders()
    val results = for (i <- allLines.indices) yield {
      allLines(i).get(query.query) match {
        case Some(result) => {
          val id = (fileContent + i).hashCode.toString
          Result(id, List(id), List(result), None, None, None)
        }
        case None => throw new Exception("Field not present")
      }
    }
    results.toList
  }

  private def inferCSVDelimiter(fileContent: String): Char = {
    val comma = fileContent.count(_.equals(','))
    val semicolon = fileContent.count(_.equals(';'))
    val dot = fileContent.count(_.equals('.'))
    val colon = fileContent.count(_.equals(':'))
    val at = fileContent.count(_.equals('@'))
    val sharp = fileContent.count(_.equals('#'))
    val tab = fileContent.count(_.equals('\t'))
    val map = Map(',' -> comma, ';' -> semicolon, '.' -> dot, ':' -> colon, '@' -> at, '#' -> sharp, '\t' -> tab)
    map.foldLeft(',')((greater, count) => if(map(greater) < count._2) count._1 else greater)
  }

  protected def getStringOperationResults(left: List[Result], right: List[Result], unionString: String): List[Result] = {
    for ((l, r) <- left zip right) yield {
      val results = for (i <- l.results) yield {
        for (j <- r.results) yield {
          i + unionString + j
        }
      }
      Result(l.id, l.rootIds, results.flatten, r.dataType, r.langTag, r.rdfCollection)
    }
  }

  protected def getJoinResults(left: List[Result], right: List[Result], join: List[Result]): List[Result] = {
    val joinUnionList = for(r <- right.asInstanceOf[List[Result]]) yield {
      val filteredJoin = join.asInstanceOf[List[Result]].filter(j => j.results.nonEmpty && j.results == r.results)
      if(filteredJoin.nonEmpty)
        Result(r.id, r.rootIds, left.filter(l => l.id == filteredJoin.head.id && l.results.nonEmpty).head.results, r.dataType, r.langTag, r.rdfCollection)
      else r
    }
    left.union(joinUnionList)
  }

  private def solveAutoIncrementResults(list: List[Any], action: Result): List[Result] = {
    val resultsAutoIncrement = list.filter(_.isInstanceOf[ResultAutoIncrement]).map(_.asInstanceOf[ResultAutoIncrement])
    val newResultsAutoIncrement = resultsAutoIncrement.map(r => Result(action.id, action.rootIds, r.results, r.dataType, r.langTag, None))
    list.filterNot(_.isInstanceOf[ResultAutoIncrement]).flatMap(_.asInstanceOf[List[Result]]) ::: newResultsAutoIncrement
  }

  private def getAllFilesContents(url: String): List[String] = {
    val slices = url.split("\\*")
    val windows = slices(0).lastIndexOf("/") < slices(0).lastIndexOf("\\")
    val path = if(windows)
      slices(0).splitAt(slices(0).lastIndexOf("\\"))._1.replace("file:///", "")
      else slices(0).splitAt(slices(0).lastIndexOf("/"))._1.replace("file://", "")
    val fileBeginning = if(windows)
      slices(0).splitAt(slices(0).lastIndexOf("\\"))._2.replace("\\", "")
      else slices(0).splitAt(slices(0).lastIndexOf("/"))._2.replace("/", "")
    val fileEnding = slices(1).splitAt(slices(1).lastIndexOf("."))._1
    val fileExtension = slices(1).splitAt(slices(1).lastIndexOf("."))._2
    val files = new File(path).listFiles().filter(_.isFile)
      .filter(_.getName.endsWith(fileEnding + fileExtension)).filter(_.getName.startsWith(fileBeginning))
    val fileProtocol = if(windows) "file:///" else "file://"
    files.map(file => new SourceHelper().getURLContent(fileProtocol + file.getAbsolutePath)).toList
  }

  private def visitAction(action: ExpOrVar, predicateObjectsList: List[Any], optionalArgument: Any): List[Result] = {
    if(action.isInstanceOf[Var] && varTable(action.asInstanceOf[Var]).isInstanceOf[AutoIncrement]) {
      getMaxOccurrencesPredicateObjectList(predicateObjectsList) match {
        case lr: List[Result] => lr.flatMap(r =>
          doVisit(action, optionalArgument).asInstanceOf[ResultAutoIncrement].results.map(re => Result(r.id, r.rootIds, List(re), None, None, None)))
        case ra: ResultAutoIncrement =>
          val id = ra.hashCode().toString
          val rootIds = List(id)
          doVisit(action, optionalArgument).asInstanceOf[ResultAutoIncrement].results.map(re => Result(id, rootIds, List(re), None, None, None))
      }
    } else doVisit(action, optionalArgument).asInstanceOf[List[Result]]
  }

  private def getMaxOccurrencesPredicateObjectList(list: List[Any]) = {
    val mostCommonSize = mutable.HashMap[Int, Int]()
    list.filter(_ != Nil).foreach {
      case lr: List[Result] if lr.nonEmpty => mostCommonSize += ((lr.size, mostCommonSize.getOrElse(lr.size, 0) + 1))
      case ra: ResultAutoIncrement if ra.results.nonEmpty =>
        mostCommonSize += ((ra.results.size, mostCommonSize.getOrElse(ra.results.size, 0) + 1))
    }
    val maxSize = if(mostCommonSize.isEmpty) (0, 0) else mostCommonSize.toList.sortBy(_._1)(Ordering[Int].reverse).maxBy(_._2)
    val filterList = list.filter {
      case lr: List[Result] => lr.size == maxSize._1
      case ra: ResultAutoIncrement => ra.results.size == maxSize._1
    }
    filterList.head
  }

  private def getQueryFromVarTable(variable: Var): QueryClause = {
    new QuerySearcher(varTable).getQueryFromVarTable(variable)
  }

  private def registerCardinalityAndDatatype(shapeName: String, predicateObject: Array[String], result: Result) {
    shexInferredPropertiesTable += ShExMLInferredCardinalitiesAndDatatypes(shapeName, predicateObject(0), result.results.size, result.dataType)
  }

  private def createTriple(shapePrefix: String, action: String, predicateObject: Array[String], result: Result, output: Model): Unit = {
    if(shapePrefix == "_:") {
      if (predicateObject(1).contains("http://") || predicateObject(1).contains("https://") || predicateObject(1).contains("_:"))
        output.add(createBNodeStatement(action, predicateObject(0), normaliseURI(predicateObject(1))))
      else
        output.add(createBNodeStatementWithLiteral(
          action, predicateObject(0), predicateObject(1), result.dataType, result.langTag))
    } else {
      if (predicateObject(1).contains("http://") || predicateObject(1).contains("https://") || predicateObject(1).contains("_:"))
        output.add(createStatement(prefixTable(shapePrefix) + action, predicateObject(0), normaliseURI(predicateObject(1))))
      else
        output.add(createStatementWithLiteral(
          prefixTable(shapePrefix) + action, predicateObject(0), predicateObject(1), result.dataType, result.langTag))
    }
  }

  private def createTripleWithCollection(shapePrefix: String, action: String, predicateObjects: List[Array[String]],
                                         result: Result, output: Model, rdfCollection: RDFCollection): Unit = {
    val predicateObject = predicateObjects.head
    if(shapePrefix == "_:") {
      if (predicateObject(1).contains("http://") || predicateObject(1).contains("https://") || predicateObject(1).contains("_:")) {
        val values = predicateObjects.map(i => output.createResource(normaliseURI(i(1))))
        val collection = collectionConstructor(output, values.toIterator, rdfCollection)
        output.add(createBNodeStatementWithCollection(action, predicateObject(0), collection))
      }
      else {
        val values = predicateObjects.map(i => {
          if(result.langTag.isDefined) output.createLiteral(i(1), result.langTag.get)
          else if(result.dataType.isDefined) {
            val xsdType = result.dataType.map(d => prefixTable(d.split(":")(0) + ":") + d.split(":")(1))
              .map(TypeMapper.getInstance().getSafeTypeByName(_)).getOrElse(searchForXSDType(i(1)))
            output.createTypedLiteral(i(1), xsdType)
          }
          else output.createTypedLiteral(i(1), searchForXSDType(i(1)))
        })
        val collection = collectionConstructor(output, values.toIterator, rdfCollection)
        output.add(createBNodeStatementWithCollection(action, predicateObject(0), collection))
      }
    } else {
      if (predicateObject(1).contains("http://") || predicateObject(1).contains("https://") || predicateObject(1).contains("_:")) {
        val values = predicateObjects.map(i => output.createResource(normaliseURI(i(1))))
        val collection = collectionConstructor(output, values.toIterator, rdfCollection)
        output.add(createStatementWithCollection(prefixTable(shapePrefix) + action, predicateObject(0), collection))
      }
      else {
        val values = predicateObjects.map(i => {
          if(result.langTag.isDefined) output.createLiteral(i(1), result.langTag.get)
          else if(result.dataType.isDefined) {
            val xsdType = result.dataType.map(d => prefixTable(d.split(":")(0) + ":") + d.split(":")(1))
              .map(TypeMapper.getInstance().getSafeTypeByName(_)).getOrElse(searchForXSDType(i(1)))
            output.createTypedLiteral(i(1), xsdType)
          }
          else output.createTypedLiteral(i(1), searchForXSDType(i(1)))
        })
        val collection = collectionConstructor(output, values.toIterator, rdfCollection)
        output.add(createStatementWithCollection(
          prefixTable(shapePrefix) + action, predicateObject(0), collection))
      }
    }
  }

  private def collectionConstructor(output: Model, nodes: Iterator[RDFNode],
        rdfCollection: RDFCollection): Resource =
    rdfCollection match {
      case RDFList() => output.createList(nodes.asJava)
      case RDFBag() =>
        val bag = output.createBag()
        nodes.foreach(n => bag.add(n))
        bag
      case RDFAlt() =>
        val alt = output.createAlt()
        nodes.foreach(n => alt.add(n))
        alt
      case RDFSeq() =>
        val seq = output.createSeq()
        nodes.foreach(n => seq.add(n))
        seq
      case _ => throw new Exception("Collection not supported")
  }

  private def normaliseDataType(datatype: Option[String]): Option[String] = datatype.map(dt => {
    val xsdURI = "http://www.w3.org/2001/XMLSchema#"
    if(dt.contains(xsdURI)) "xsd:" + dt.split('#').takeRight(1).head
    else dt
  })

  override def doVisitDefault(): Any = Nil

}

class QueryResultsCache() {
  private val table = mutable.HashMap[Int, Object]()

  def search(query: String, fileContent: String): Option[Object] = {
    table.get((query + fileContent).hashCode)
  }

  def save(query: String, fileContent: String, resultContainer: Object): Unit = {
    val id = (query + fileContent).hashCode
    table += ((id, resultContainer))
  }

  def save(query: String, fileContent: String, resultSet: java.sql.ResultSet): Unit = {
    val results = mutable.HashMap[String, List[String]]()
    val columns = resultSet.getMetaData.getColumnCount
    val columnsNames = (1 to columns).map(resultSet.getMetaData.getColumnName)
    while(resultSet.next()) {
      columnsNames.foreach(cn => {
        results.get(cn) match {
          case Some(oldValue) => results.update(cn, oldValue :+ resultSet.getString(cn))
          case None => results += (cn -> List(resultSet.getString(cn)))
        }
      })
    }
    save(query, fileContent, results.toMap)
  }

  def save(query: String, fileContent: String, resultSet: ResultSet): Unit = {
    val results = mutable.HashMap[String, List[String]]()
    val columnsNames = resultSet.getResultVars
    while(resultSet.hasNext) {
      val row = resultSet.next()
      columnsNames.forEach(cn => {
        val rowResult = row.get(cn)
        val value = if(rowResult.isLiteral) {
          rowResult.asLiteral().getString
        } else {
          SplitIRI.localname(rowResult.asResource().getURI)
        }
        results.get(cn) match {
          case Some(oldValue) => results.update(cn, oldValue :+ value)
          case None => results += (cn -> List(value))
        }
      })
      save(query, fileContent, results.toMap)
    }
  }
}

sealed trait Resultable {
  def results: List[String]
}
case class Result(id: String, rootIds: List[String], results: List[String], dataType: Option[String],
                  langTag: Option[String], rdfCollection: Option[RDFCollection]) extends Resultable {
  override def equals(that: Any): Boolean = {
    canEqual(that) && id == that.asInstanceOf[Result].id
  }
}
case class ResultWithIteratorQuery(id: String, rootIds: List[String], results: List[String], iteratorQuery: String) extends Resultable
case class ResultWithNested(id: String, rootIds: List[String], results: List[String], nestedResults: List[Resultable], iteratorQuery: String) extends Resultable
case class QueryByID(id: String, query: String)
case class QueryWithIndex(index: String, rootIds: List[String], query: QueryClause, iteratorQuery: String)
case class ResultAutoIncrement(iterator: AutoIncrement, predicate: String, namespace: String, dataType: Option[String], langTag: Option[String]) extends Resultable {
  def results: List[String] = {
    val precedentString = iterator.precedentString.getOrElse("")
    val closingString = iterator.closingString.getOrElse("")
    val predicateWithSpace = if(predicate.isEmpty) "" else predicate + " "
    List(predicateWithSpace + namespace + precedentString + iterator.iterator.next() + closingString)
  }
}