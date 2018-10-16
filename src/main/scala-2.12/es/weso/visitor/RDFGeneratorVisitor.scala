package es.weso.visitor
import com.fasterxml.jackson.databind.ObjectMapper
import es.weso.ast._
import es.weso.helper.SourceHelper
import kantan.xpath.XPathCompiler

import scala.collection.mutable
import kantan.xpath.implicits._
import org.apache.commons.text.similarity.{LevenshteinDistance, LongestCommonSubsequence}
import org.apache.jena.datatypes.RDFDatatype
import org.apache.jena.datatypes.xsd.XSDDatatype
import org.apache.jena.rdf.model.{Model, ResourceFactory, Statement}

import scala.util.Try

/**
  * Created by herminio on 26/12/17.
  */
class RDFGeneratorVisitor(output: Model, varTable: mutable.HashMap[Variable, VarResult]) extends DefaultVisitor[Any, Any] {

  private val prefixTable = mutable.HashMap[String, String]()

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
      val flattenActions = actions.flatMap(_.results).map(String.valueOf)
      val idQueries = getQueriesFromAction(action)
      val arguments =
        if(optionalArgument == null) Map("ids" -> flattenActions, "idQueries" -> idQueries)
        else optionalArgument
      val predicateObjectsList = predicateObjects.map(doVisit(_, arguments)).asInstanceOf[List[List[Result]]]
      for(a <- flattenActions) {
        val finalPredicateObjectsList =
          if(optionalArgument == null) predicateObjectsList.flatten.filter(_.id == a)
          else {
            val id = actions.filter(_.results.contains(a)).head.id
            predicateObjectsList.flatten.filter(_.id == id)
          }
        for(result <- finalPredicateObjectsList) {
          val predicateObjects = result.results.map(_.toString.split(" ", 2))
          val action = normaliseURI(a)
          for(predicateObject <- predicateObjects) {
            if (predicateObject(1).contains("http://") || predicateObject(1).contains("https://"))
              output.add(createStatement(prefixTable(shapePrefix) + action, predicateObject(0), normaliseURI(predicateObject(1))))
            else
              output.add(createStatementWithLiteral(prefixTable(shapePrefix) + action, predicateObject(0), predicateObject(1)))
          }
        }
      }
      actions.map(r => Result(r.id, r.results.map(prefixTable(shapePrefix) + _)))
    }

    case PredicateObject(predicate, objectOrShapeLink) => {
      val predicateResult = doVisit(predicate, optionalArgument)
      val objectResult = doVisit(objectOrShapeLink, optionalArgument).asInstanceOf[List[Result]]
      if(predicateResult != null && objectResult != null)
        objectResult.map(result => {
          val results = result.results.map(predicateResult.toString + " " + _)
          Result(result.id, results)
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
        Result(result.id, newResults)
      })
    }

    case Union(left, right) => {
      val leftList = doVisit(left, optionalArgument).asInstanceOf[List[Result]]
      val rightList = doVisit(right, optionalArgument).asInstanceOf[List[Result]]
      leftList.union(rightList)
    }

    case Join(left, right, join) => {
      val leftList = doVisit(left, optionalArgument).asInstanceOf[List[Result]]
      val rightList = doVisit(right, optionalArgument).asInstanceOf[List[Result]]
      val joinList = doVisit(join, optionalArgument).asInstanceOf[List[Result]]
      val joinUnionList = for(r <- rightList) yield {
        val join = joinList.filter(j => j.results.nonEmpty && j.results == r.results)
        if(join.nonEmpty)
          Result(r.id, leftList.filter(l => l.id == join.head.id && l.results.nonEmpty).head.results)
        else r
      }
      leftList.union(joinUnionList)
    }

    case SourceQuery(fileVar, expressionVar) => {
      val arguments = Option(optionalArgument.asInstanceOf[Map[String, Any]])
      val file = doVisit(fileVar, optionalArgument).asInstanceOf[String]
      val fileMap = Map("fileContent" -> file)
      val finalArguments = arguments.map(_.++(fileMap)).getOrElse(fileMap)
      doVisit(expressionVar, finalArguments)
    }

    case StringOperation(left, right, unionString) => {
      val leftList = doVisit(left, optionalArgument).asInstanceOf[List[Result]]
      val rightList = doVisit(right, optionalArgument).asInstanceOf[List[Result]]
      for ((l, r) <- leftList zip rightList) yield {
        val results = for (i <- l.results) yield {
          for (j <- r.results) yield {
            i + unionString + j
          }
        }
        Result(l.id, results.flatten)
      }
    }

    case v: Var => {
      doVisit(varTable(v), optionalArgument)
    }

    case sv: ShapeVar => {
      doVisit(varTable(sv), optionalArgument)
    }

    case JsonPath(query) => {
      val arguments = optionalArgument.asInstanceOf[Map[String, Any]]
      val fileContent = arguments.getOrElse("fileContent", null).asInstanceOf[String]
      val idQueries = arguments.getOrElse("idQueries", Nil).asInstanceOf[List[String]]
      val ids = arguments.getOrElse("ids", Nil).asInstanceOf[List[String]]
      val finalQueries =
        if(ids.nonEmpty) composeJsonPathQueryById(query, idQueries, ids)
        else List(QueryByID(query.hashCode.toString, query))
      finalQueries.map(finalQuery => {
        val jsonContent = new ObjectMapper().readValue(fileContent, classOf[Object])
        val verificationQuery = finalQuery.query.splitAt(finalQuery.query.lastIndexOf("."))._1
        val verificationResult = io.gatling.jsonpath.JsonPath.query(verificationQuery, jsonContent)
        val finalResult = verificationResult match {
          case Left(_) => Nil
          case Right(vr) => {
            if(vr.nonEmpty) {
              val result = io.gatling.jsonpath.JsonPath.query(finalQuery.query, jsonContent)
              result match {
                case Left(l) => throw new Exception(l.reason)
                case Right(r) => if (r.isEmpty) Nil else r.flatMap(e => {
                  if (e.toString.contains("[") && e.toString.contains("]"))
                    e.toString.substring(1, e.toString.length - 1).split(",").toList.map(_.trim)
                  else
                    List(e)
                })
              }
            } else Nil
          }.toList
        }
        Result(finalQuery.id, finalResult.map(String.valueOf))
      })
    }

    case XmlPath(query) => {
      val arguments = optionalArgument.asInstanceOf[Map[String, Any]]
      val fileContent = arguments.getOrElse("fileContent", null).asInstanceOf[String]
      val idQueries = arguments.getOrElse("idQueries", Nil).asInstanceOf[List[String]]
      val ids = arguments.getOrElse("ids", Nil).asInstanceOf[List[String]]
      val finalQueries =
        if(ids.nonEmpty) composeXPathQueryById(query, idQueries, ids)
        else List(QueryByID(query.hashCode.toString, query))
      finalQueries.map(finalQuery => {
        val queries = finalQuery.query.splitAt(finalQuery.query.lastIndexOf("/"))
        val compilationResult = XPathCompiler.builtIn.compile(queries._1)
        compilationResult.toOption match {
          case Some(xPathQuery) => {
            val count = fileContent.evalXPath[List[String]](xPathQuery).getOrElse(Nil).size
            val results = (1 to count).flatMap(i => {
              XPathCompiler.builtIn.compile("(" + queries._1 + ")[" + i + "]" + queries._2).toOption match {
                case Some(xPathFullQuery) => fileContent.evalXPath[List[String]](xPathFullQuery).getOrElse(Nil)
                case None => throw new Exception("Bad xPath query")
              }
            }).toList
            Result(finalQuery.id, results)
          }
          case None => throw new Exception("Bad xPath query")
        }
      })
    }

    case Matcher(_, replacedStrings, replacement) => {
      val listToMatch = optionalArgument.asInstanceOf[List[Result]]
      listToMatch.map(r => Result(r.id, r.results.map(s => {
        if(replacedStrings.strings.contains(s)) replacement else s
      })))
    }

    case ShapeLink(shapeVar) => {
      doVisit(shapeVar, optionalArgument)
    }

    case URL(url) => new SourceHelper().getURLContent(url)

    case default => visit(default, optionalArgument)
  }

  private def createStatement(s: String, p: String, o: String): Statement = {
    val subject = ResourceFactory.createResource(s)
    val predicate = ResourceFactory.createProperty(p)
    val obj = ResourceFactory.createResource(o)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  private def createStatementWithLiteral(s: String, p: String, o: String): Statement = {
    val subject = ResourceFactory.createResource(s)
    val predicate = ResourceFactory.createProperty(p)
    val xsdType = searchForXSDType(o)
    val obj = ResourceFactory.createTypedLiteral(o, xsdType)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  private def searchForXSDType(o: String): RDFDatatype = {
    if(Try(o.toInt).isSuccess)
      XSDDatatype.XSDinteger
    else if(Try(o.toDouble).isSuccess)
      XSDDatatype.XSDdecimal
    else if(Try(o.toBoolean).isSuccess)
      XSDDatatype.XSDboolean
    else
      XSDDatatype.XSDstring
  }

  private def normaliseURI(uri: String): String = {
    uri.replaceAll("[\\s,_()']", "_")
      .replace("&quot;", "")
      .replace("&#209;", "N").replace("&#241;", "n")
      .replace("&#220;", "U").replace("&#252;", "u")
  }

  private def composeXPathQueryById(query: String, idQueries: List[String], ids: List[String]): List[QueryByID] = {
    val idQuery = getBetterQueryCandidate(query, idQueries)
    val commonQuery = getCommonQuery(query, idQuery)
    val queryIdAttribute = idQuery.replace(commonQuery, "")
    val queryString = commonQuery.subSequence(0, commonQuery.toString.lastIndexOf("/")).toString
    val queryAttribute = query.replace(queryString, "")
    ids.map(id => {
      val query = queryString + "[" + queryIdAttribute + "= \"" + id + "\"]" + queryAttribute
      QueryByID(id, query)
    })
  }

  private def composeJsonPathQueryById(query: String, idQueries: List[String], ids: List[String]): List[QueryByID] = {
    val idQuery = getBetterQueryCandidate(query, idQueries)
    val commonQuery = getCommonQuery(query, idQuery)
    val queryIdAttribute = idQuery.replace(commonQuery, "")
    val queryStringToReplace = commonQuery.subSequence(0, commonQuery.toString.lastIndexOf(".")).toString
    val queryString = queryStringToReplace.replace("[*]", "")
    val queryAttribute = query.replace(queryStringToReplace, "")
    val queriesWithQuotes = ids.map(id => {
      val query = queryString + "[?(@." + queryIdAttribute + "==" + id + ")]" + queryAttribute
      QueryByID(id, query)
    })
    val queriesWithoutQuotes = ids.map(id => {
      val query = queryString + "[?(@." + queryIdAttribute + "==\"" + id + "\")]" + queryAttribute
      QueryByID(id, query)
    })
    queriesWithQuotes ::: queriesWithoutQuotes
  }

  private def getBetterQueryCandidate(query: String, idQueries: List[String]): String = {
    idQueries.maxBy(idQuery => {
      val chars = idQuery.getBytes.zip(query.getBytes)
      chars.indexWhere {case (a, b) => a != b}
    })
  }

  private def getCommonQuery(query: String, bestQueryCandidate: String): String = {
    val chars = bestQueryCandidate.getBytes.zip(query.getBytes)
    val index = chars.indexWhere {case (a, b) => a != b}
    bestQueryCandidate.splitAt(index)._1
  }

  private def getQueriesFromAction(action: ExpOrVar): List[String] = action match {
    case SourceQuery(_, expressionVar) => getQueriesFromVarResult(varTable(expressionVar))
    case Union(leftUnion, rightUnion) => getQueriesFromAction(leftUnion) ::: getQueriesFromAction(rightUnion)
    case StringOperation(left, right, _) => getQueriesFromAction(left) ::: getQueriesFromAction(right)
    case Join(left, right, join) => getQueriesFromAction(left) ::: getQueriesFromAction(right) ::: getQueriesFromAction(join)
    case variable: Var => getQueriesFromVarResult(varTable(variable))
    case _ => Nil
  }

  private def getQueriesFromVarResult(varResult: VarResult): List[String] = varResult match {
    case JsonPath(query) => List(query)
    case XmlPath(query) => List(query)
    case e: Exp => getQueriesFromAction(e)
    case _ => Nil
  }

  override def doVisitDefault(): Any = Nil

}

case class Result(id: String, results: List[String])
case class QueryByID(id: String, query: String)
