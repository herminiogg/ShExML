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
      val predicateObjectsList = predicateObjects.map(doVisit(_, optionalArgument)).asInstanceOf[List[List[Result]]]
      for(a <- actions) {
        val finalPredicateObjectsList = predicateObjectsList.flatten.filter(_.id == a.id)
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

    case IteratorQuery(fileVar, iteratorVar, expressionVar) => {
      val arguments = Option(optionalArgument.asInstanceOf[Map[String, Any]])
      val fileContent = doVisit(fileVar, optionalArgument).asInstanceOf[String]
      val fileMap = Map("fileContent" -> fileContent)
      val middleArguments = arguments.map(_.++(fileMap)).getOrElse(fileMap)
      val iteratorQuery = doVisit(iteratorVar, middleArguments).asInstanceOf[Result]
      val finalArguments = middleArguments.++(Map("iteratorQuery" -> iteratorQuery))
      val fieldVar = Var(iteratorVar.name + "." + expressionVar.name)
      val queries = iteratorQuery.results.indices.map(i => {
        val queryClause = varTable(iteratorVar) match {
          case JsonPath(query) => JsonPath(query.replace("*", i.toString) + "." + varTable(fieldVar).asInstanceOf[FieldQuery].query)
          case XmlPath(query) => XmlPath(query + "[" + (i + 1) + "]/" + varTable(fieldVar).asInstanceOf[FieldQuery].query)
        }
        (i, queryClause)
      })
      queries.map(t => doVisit(t._2, finalArguments.+("index" -> t._1)).asInstanceOf[Result]).toList
    }

    case v: Var => {
      doVisit(varTable(v), optionalArgument)
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
      val jsonContent = new ObjectMapper().readValue(fileContent, classOf[Object])
      val result = io.gatling.jsonpath.JsonPath.query(query, jsonContent)
      result match {
        case Left(_) => Nil
        case Right(r) => {
          val finalList = r.toList.flatMap({
            case l: util.ArrayList[_] => l.toArray.map(_.toString)
            case default => List(default.toString)
          })
          Result(id, finalList)
        }
      }
    }

    case XmlPath(query) => {
      val arguments = optionalArgument.asInstanceOf[Map[String, Any]]
      val iteratorQuery = arguments.getOrElse("iteratorQuery", "").toString
      val index = arguments.getOrElse("index", "")
      val fileContent = arguments.getOrElse("fileContent", null).asInstanceOf[String]
      val id = (iteratorQuery + fileContent + index).hashCode.toString
      val compilationResult = XPathCompiler.builtIn.compile(query)
      compilationResult.toOption match {
        case Some(value) => Result(id, fileContent.evalXPath[List[String]](value).getOrElse(Nil))
        case None => throw new Exception("Bad iterator query: " + query)
      }
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

  override def doVisitDefault(): Any = Nil

}

case class Result(id: String, results: List[String])
case class QueryByID(id: String, query: String)
