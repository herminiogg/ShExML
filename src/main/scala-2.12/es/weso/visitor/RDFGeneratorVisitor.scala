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
class RDFGeneratorVisitor(output: Model, varTable: mutable.HashMap[Variable, VarResult]) extends DefaultVisitor[Any] {

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
      val actions = doVisit(action, optionalArgument).asInstanceOf[List[String]]
      val predicateObjectsList = predicateObjects.map(doVisit(_, optionalArgument)).asInstanceOf[List[List[String]]]
      val zipped = predicateObjectsList.map((_, actions))
      zipped.foreach {
        case (p, a) => {
          if(a != null && p!= null && a.length <= p.length) {
            for (i <- a.indices) {
              val predicateObject = p(i).split(" ", 2)
              val action = a(i).replace(" ", "_")
              if(predicateObject(1).contains("http://") || predicateObject(1).contains("https://"))
                output.add(createStatement(prefixTable(shapePrefix) + action, predicateObject(0), predicateObject(1).replace(" ", "_")))
              else
                output.add(createStatementWithLiteral(prefixTable(shapePrefix) + action, predicateObject(0), predicateObject(1)))
            }
          }
        }
      }
      actions.map(prefixTable(shapePrefix) + _)
    }

    case PredicateObject(predicate, objectOrShapeLink) => {
      val predicateResult = doVisit(predicate, optionalArgument)
      val objectResult = doVisit(objectOrShapeLink, optionalArgument)
      if(predicateResult != null && objectResult != null)
        objectResult.asInstanceOf[List[String]].map(predicateResult.toString + " " + _)
      else Nil
    }

    case Predicate(prefix, extension) => {
      prefixTable(prefix) + extension
    }

    case ObjectElement(prefix, action) => {
      val result = doVisit(action, optionalArgument)
      result.asInstanceOf[List[String]].map(prefixTable.getOrElse(prefix, "") + _)
    }

    case Union(left, right) => {
      val leftList = doVisit(left, optionalArgument).asInstanceOf[List[String]]
      val rightList = doVisit(right, optionalArgument).asInstanceOf[List[String]]
      leftList.union(rightList)
    }

    case Join(left, right, join) => {
      val leftList = doVisit(left, optionalArgument).asInstanceOf[List[String]]
      val rightList = doVisit(right, optionalArgument).asInstanceOf[List[String]]
      val joinList = doVisit(join, optionalArgument).asInstanceOf[List[String]]
      val joinUnionList = leftList.indices.map(i => {
        if(rightList(i) == joinList(i)) leftList(i) else rightList(i)
      })
      leftList.union(joinUnionList)
    }

    case SourceQuery(fileVar, expressionVar) => {
      val file = doVisit(fileVar, optionalArgument).asInstanceOf[String]
      doVisit(expressionVar, file)
    }

    case StringOperation(left, right, unionString) => {
      val leftList = doVisit(left, optionalArgument).asInstanceOf[List[String]]
      val rightList = doVisit(right, optionalArgument).asInstanceOf[List[String]]
      for ((l, r) <- leftList zip rightList) yield l + unionString + r
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
        case Right(r) => r.toList
      }
    }

    case XmlPath(query) => {
      val fileContent = optionalArgument.asInstanceOf[String]
      val compilationResult = XPathCompiler.builtIn.compile(query)
      compilationResult.toOption match {
        case Some(xPathQuery) => fileContent.evalXPath[List[String]](xPathQuery).getOrElse(Nil)
        case None => throw new Exception("Bad xPath query")
      }
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

}
