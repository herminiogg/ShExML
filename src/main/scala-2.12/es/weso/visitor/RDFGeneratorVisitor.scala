package es.weso.visitor
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
      val actions = doVisit(action, optionalArgument).asInstanceOf[List[List[String]]]
      val predicateObjectsList = predicateObjects.map(doVisit(_, optionalArgument)).asInstanceOf[List[List[String]]]
      val zipped = predicateObjectsList.map((_, actions))
      zipped.foreach {
        case (p, a) => {
          if(a != null && p!= null && a.length <= p.length) {
            for (i <- a.indices) {
              val predicateObjects = p(i).asInstanceOf[List[String]].map(_.toString.split(" ", 2))
              val action = normaliseURI(a(i).head)
              for(predicateObject <- predicateObjects) {
                if (predicateObject(1).contains("http://") || predicateObject(1).contains("https://"))
                  output.add(createStatement(prefixTable(shapePrefix) + action, predicateObject(0), normaliseURI(predicateObject(1))))
                else
                  output.add(createStatementWithLiteral(prefixTable(shapePrefix) + action, predicateObject(0), predicateObject(1)))
              }
            }
          }
        }
      }
      actions.map(_.map(prefixTable(shapePrefix) + _))
    }

    case PredicateObject(predicate, objectOrShapeLink) => {
      val predicateResult = doVisit(predicate, optionalArgument)
      val objectResult = doVisit(objectOrShapeLink, optionalArgument)
      if(predicateResult != null && objectResult != null)
        objectResult.asInstanceOf[List[List[String]]].map(_.map(predicateResult.toString + " " + _))
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
      matchedResultList.asInstanceOf[List[List[_]]].map(_.map(_.toString)).map(_.map(prefixTable.getOrElse(prefix, "") + _))
    }

    case Union(left, right) => {
      val leftList = doVisit(left, optionalArgument).asInstanceOf[List[List[_]]].map(_.map(_.toString))
      val rightList = doVisit(right, optionalArgument).asInstanceOf[List[List[_]]].map(_.map(_.toString))
      leftList.union(rightList)
    }

    case Join(left, right, join) => {
      val leftList = doVisit(left, optionalArgument).asInstanceOf[List[List[_]]].map(_.map(_.toString))
      val rightList = doVisit(right, optionalArgument).asInstanceOf[List[List[_]]].map(_.map(_.toString))
      val joinList = doVisit(join, optionalArgument).asInstanceOf[List[List[_]]].map(_.map(_.toString))
      val joinUnionList = for (i <- rightList.indices) yield {
        val index = joinList.indexOf(rightList(i))
        if(index >= 0) leftList(index) else rightList(i)
      }
      leftList.union(joinUnionList)
    }

    case SourceQuery(fileVar, expressionVar) => {
      val file = doVisit(fileVar, optionalArgument).asInstanceOf[String]
      doVisit(expressionVar, file)
    }

    case StringOperation(left, right, unionString) => {
      val leftList = doVisit(left, optionalArgument).asInstanceOf[List[List[_]]].map(_.map(_.toString))
      val rightList = doVisit(right, optionalArgument).asInstanceOf[List[List[_]]].map(_.map(_.toString))
      for ((l, r) <- leftList zip rightList) yield {
        for (i <- l.indices) yield {
          l(i) + unionString + r(i)
        }
      }.toList
    }

    case v: Var => {
      doVisit(varTable(v), optionalArgument)
    }

    case sv: ShapeVar => {
      doVisit(varTable(sv), optionalArgument)
    }

    case JsonPath(query) => {
      val fileContent = optionalArgument.asInstanceOf[String]
      val jsonContent = new ObjectMapper().readValue(fileContent, classOf[Object])
      val result = io.gatling.jsonpath.JsonPath.query(query, jsonContent)
      result match {
        case Left(l) => throw new Exception(l.reason)
        case Right(r) => r.toList.map(e => {
          if(e.toString.contains("[") && e.toString.contains("]"))
            e.toString.substring(1, e.toString.length - 1).split(",").toList.map(_.trim)
          else
            List(e)
        })
      }
    }

    case XmlPath(query) => {
      val fileContent = optionalArgument.asInstanceOf[String]
      val queries = query.splitAt(query.lastIndexOf("/"))
      val compilationResult = XPathCompiler.builtIn.compile(queries._1)
      compilationResult.toOption match {
        case Some(xPathQuery) => {
          val count = fileContent.evalXPath[List[String]](xPathQuery).getOrElse(Nil).size
          (1 to count).map(i => {
            XPathCompiler.builtIn.compile("(" + queries._1 + ")[" + i + "]" + queries._2).toOption match {
              case Some(xPathFullQuery) => fileContent.evalXPath[List[String]](xPathFullQuery).getOrElse(Nil)
              case None => throw new Exception("Bad xPath query")
            }
          }).toList
        }
        case None => throw new Exception("Bad xPath query")
      }
    }

    case Matcher(_, replacedStrings, replacement) => {
      val listToMatch = optionalArgument.asInstanceOf[List[List[_]]].map(_.map(_.toString))
      listToMatch.map(_.map(s => if(replacedStrings.strings.contains(s)) replacement else s))
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
