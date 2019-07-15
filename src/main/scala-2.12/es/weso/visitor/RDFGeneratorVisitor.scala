package es.weso.visitor
import java.util
import com.fasterxml.jackson.databind.ObjectMapper
import es.weso.ast._
import es.weso.helper.SourceHelper
import kantan.xpath.XPathCompiler
import scala.collection.mutable
import kantan.xpath.implicits._
import org.apache.jena.datatypes.RDFDatatype
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.{Model, ResourceFactory, Statement}
import scala.util.Try

/**
  * Created by herminio on 26/12/17.
  */
class RDFGeneratorVisitor(output: Model, varTable: mutable.HashMap[Variable, VarResult]) extends DefaultVisitor[Any, Any] {

  protected val prefixTable = mutable.HashMap[String, String](("rdf:", "http://www.w3.org/1999/02/22-rdf-syntax-ns#"))
  protected val iteratorsCombinations = mutable.HashMap[String, List[Result]]()

  override def doVisit(ast: AST, optionalArgument: Any): Any = ast match {

    case Declaration(declarationStatement) => {
      if(declarationStatement.isInstanceOf[Prefix])
        doVisit(declarationStatement, optionalArgument)
    }

    case Prefix(variable, url) => {
      prefixTable += ((variable.name, url.url))
      output.setNsPrefix(variable.name.replace(":", ""), url.url)
    }

    case Shape(shapeName, shapePrefix, action, predicateObjects) => {
      val actions = doVisit(action, optionalArgument).asInstanceOf[List[Result]]
      val predicateObjectsList = predicateObjects.map(doVisit(_, optionalArgument)).asInstanceOf[List[List[Result]]]
      for(a <- actions) {
        val finalPredicateObjectsList = predicateObjectsList.flatten.filter(i => i.rootIds.contains(a.id) ||
          i.id == a.id || (i.id.isEmpty && i.rootIds.isEmpty))
        for(result <- finalPredicateObjectsList) {
          val predicateObjects = result.results.map(_.toString.split(" ", 2))
          val action = normaliseURI(a.results.head)
          for(predicateObject <- predicateObjects) {
            if (predicateObject(1).contains("http://") || predicateObject(1).contains("https://"))
              output.add(createStatement(prefixTable(shapePrefix) + action, predicateObject(0), normaliseURI(predicateObject(1))))
            else
              output.add(createStatementWithLiteral(prefixTable(shapePrefix) + action, predicateObject(0), predicateObject(1)))
          }
        }
      }
      actions.map(r => Result(r.id, r.rootIds, r.results.map(prefixTable(shapePrefix) + _)))
    }

    case PredicateObject(predicate, objectOrShapeLink) => {
      val predicateResult = doVisit(predicate, optionalArgument)
      val objectResult = doVisit(objectOrShapeLink, optionalArgument).asInstanceOf[List[Result]]
      if(predicateResult != null && objectResult != null)
        objectResult.map(result => {
          val results = result.results.map(predicateResult.toString + " " + _)
          Result(result.id, result.rootIds, results)
        })
      else Nil
    }

    case Predicate(prefix, extension) => {
      prefixTable(prefix) + extension
    }

    case ObjectElement(prefix, action, matcher) => {
      val result = doVisit(action, optionalArgument)
      val matchedResultList = matcher match {
        case Some(matcherVar) => doVisit(matcherVar, result)
        case None => result
      }
      matchedResultList.asInstanceOf[List[Result]].map(result => {
        val newResults = result.results.map(prefixTable.getOrElse(prefix, "") + _)
        Result(result.id, result.rootIds, newResults)
      })
    }

    case Union(left, right) => {
      val expName = optionalArgument.asInstanceOf[Map[String, Any]].getOrElse("varName", "")
      val leftList = doVisit(left, optionalArgument)
      val rightList = doVisit(right, optionalArgument)
      leftList match {
        case ml: Map[String, List[Result]] => rightList match {
          case mr: Map[String, List[Result]] => ml.keySet.union(mr.keySet).foreach(k => {
            val leftResult = mr.getOrElse(k, Nil)
            val rightResult = ml.getOrElse(k, Nil)
            val value = expName + k -> leftResult.union(rightResult)
            iteratorsCombinations += value
          })
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
      val fileContent = doVisit(i.firstVar, optionalArgument).toString
      val fileMap = Map("fileContent" -> fileContent)
      val middleArguments = arguments.map(_.++(fileMap)).getOrElse(fileMap)
      val varList = iteratorQueryToList(i)
      if(varTable(varList.head).isInstanceOf[URL] && varList.size == 2) {
        val iteratorName = varList.tail.head.name
        val values = varTable.keys.filter {
          case Var(name) => name.contains(iteratorName)
          case _ => false
        }.map {
          case v: Var => v.name.replace(iteratorName, "") -> {
            val vars = v.name.split("[.]").map(Var).toList
            if(vars.size > 1)
              doIteratorQuery(vars, middleArguments, fileContent)
            else Nil
          }
        }.toMap
        values.foreach {
          case (k, v) => iteratorsCombinations += expName + k -> v
        }
        values
      } else if(varTable(varList.head).isInstanceOf[Exp] && varList.size > 1) {
        iteratorsCombinations(varList.map(_.name).mkString("."))
      } else if(varList.size >= 3) {
        doIteratorQuery(varList.slice(1, varList.size), middleArguments, fileContent)
      } else {
        throw new Exception("Bad number of vars")
      }
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
          Result(id, rootIds, finalList)
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
        case Some(value) => Result(id, rootIds, fileContent.evalXPath[List[String]](value).getOrElse(Nil))
        case None => throw new Exception("Bad iterator query: " + query)
      }
    }

    case Matcher(_, replacedStrings, replacement) => {
      val listToMatch = optionalArgument.asInstanceOf[List[Result]]
      listToMatch.map(r => Result(r.id, r.rootIds, r.results.map(s => {
        if(replacedStrings.strings.contains(s)) replacement else s
      })))
    }

    case LiteralObject(prefix, value) => {
      val prefixValue = prefixTable(prefix.name)
      List(Result("", Nil, List(prefixValue + value)))
    }

    case ShapeLink(shapeVar) => {
      doVisit(shapeVar, optionalArgument)
    }

    case URL(url) => new SourceHelper().getURLContent(url)

    case default => visit(default, optionalArgument)
  }

  protected def createStatement(s: String, p: String, o: String): Statement = {
    val subject = ResourceFactory.createResource(s)
    val predicate = ResourceFactory.createProperty(p)
    val obj = ResourceFactory.createResource(o)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  protected def createStatementWithLiteral(s: String, p: String, o: String): Statement = {
    val subject = ResourceFactory.createResource(s)
    val predicate = ResourceFactory.createProperty(p)
    val xsdType = searchForXSDType(o)
    val obj = ResourceFactory.createTypedLiteral(o, xsdType)
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
        val indicedQuery = JsonPath(jsonpathQuery.replaceFirst("[*]", i.toString))
        val rootId = (r.iteratorQuery + fileContent + i.toString).hashCode.toString
        iteratorResultsToQueries(List(r.nestedResults(i)), indicedQuery, rootIds.::(rootId), fileContent)
      }
    }).toList
  })

  protected def generateFinalQuery(varList: List[Var], context: String, rootQuery: QueryClause): QueryClause = varList match {
    case x :: Nil => varTable(Var(context + x.name)).asInstanceOf[QueryClause]
    case x :: xs => varTable(Var(context + x.name)).asInstanceOf[QueryClause] match {
      case j: JsonPath => JsonPath(j.query + "." + generateFinalQuery(xs, context + x.name + ".", j).query)
      case xp: XmlPath => XmlPath(xp.query + "[*]/" + generateFinalQuery(xs, context + x.name + ".", xp).query)
      case FieldQuery(query) => rootQuery match {
        case j: JsonPath => JsonPath(query + "." + generateFinalQuery(xs, context + x.name + ".", j).query)
        case xp: XmlPath => XmlPath(query + "[*]/" + generateFinalQuery(xs, context + x.name + ".", xp).query)
      }
    }
  }

  protected def doIteratorQueries(varList: List[Var], varContext: String, precedentQueries: List[String], arguments: Any, rootQuery: QueryClause): List[Resultable] = varList match {
    case x :: Nil => val results = {
      precedentQueries.map(q => varTable(Var(varContext + x.name)) match {
        case JsonPath(query) => (doVisit(JsonPath(q + query), arguments).asInstanceOf[Result], q + query)
        case XmlPath(query) => (doVisit(XmlPath(q + query), arguments).asInstanceOf[Result], q + query)
        case FieldQuery(query) => rootQuery match {
          case JsonPath(_) => (doVisit(JsonPath(q + query), arguments).asInstanceOf[Result], q + query)
          case XmlPath(_) => (doVisit(XmlPath(q + query), arguments).asInstanceOf[Result], q + query)
        }
      })
    }
    results.map(r => ResultWithIteratorQuery(r._1.id, r._1.rootIds, r._1.results, r._2))
    case x :: xs => {
      val queries = precedentQueries.map(q => varTable(Var(varContext + x.name)) match {
        case JsonPath(query) => JsonPath(q + query)
        case XmlPath(query) => XmlPath(q + query + "[*]")
      })
      val results = queries.map(doVisit(_, arguments).asInstanceOf[Result])
      val newQueries = queries.indices.map(iq => {
        results(iq).results.indices.map(ir => queries(iq) match {
          case JsonPath(query) => query.replaceFirst("[*]", ir.toString) + "."
          case XmlPath(query) => query.replaceFirst("[*]", (ir + 1).toString) + "/"
        })
      }).toList
      results.indices.map(r => ResultWithNested(results(r).id, results(r).rootIds, results(r).results,
        doIteratorQueries(xs, varContext + x.name + ".", newQueries(r).toList, arguments, queries.head), queries(r).query)).toList
    }
  }

  protected def doIteratorQuery(iteratorVars: List[Var], middleArguments: Map[String, Any], fileContent: String): List[Result] = {
    val query = generateFinalQuery(iteratorVars, "", null)
    val iteratorQueries = doIteratorQueries(iteratorVars.slice(0, iteratorVars.size - 1), "", List(""), middleArguments, null)
    val queries = iteratorResultsToQueries(iteratorQueries.filter(_.results.nonEmpty), query, List(), fileContent)
    queries.map(q => doVisit(q.query, middleArguments.+(
      "index" -> q.index, "rootIds" -> q.rootIds, "iteratorQuery" -> q.iteratorQuery)).asInstanceOf[Result])
      .filter(_.results.nonEmpty)
  }

  protected def getStringOperationResults(left: List[Result], right: List[Result], unionString: String): List[Result] = {
    for ((l, r) <- left zip right) yield {
      val results = for (i <- l.results) yield {
        for (j <- r.results) yield {
          i + unionString + j
        }
      }
      Result(l.id, l.rootIds, results.flatten)
    }
  }

  protected def getJoinResults(left: List[Result], right: List[Result], join: List[Result]): List[Result] = {
    val joinUnionList = for(r <- right.asInstanceOf[List[Result]]) yield {
      val filteredJoin = join.asInstanceOf[List[Result]].filter(j => j.results.nonEmpty && j.results == r.results)
      if(filteredJoin.nonEmpty)
        Result(r.id, r.rootIds, left.filter(l => l.id == filteredJoin.head.id && l.results.nonEmpty).head.results)
      else r
    }
    left.union(joinUnionList)
  }

  override def doVisitDefault(): Any = Nil

}

sealed trait Resultable {
  def results: List[String]
}
case class Result(id: String, rootIds: List[String], results: List[String]) extends Resultable
case class ResultWithIteratorQuery(id: String, rootIds: List[String], results: List[String], iteratorQuery: String) extends Resultable
case class ResultWithNested(id: String, rootIds: List[String], results: List[String], nestedResults: List[Resultable], iteratorQuery: String) extends Resultable
case class QueryByID(id: String, query: String)
case class QueryWithIndex(index: String, rootIds: List[String], query: QueryClause, iteratorQuery: String)
