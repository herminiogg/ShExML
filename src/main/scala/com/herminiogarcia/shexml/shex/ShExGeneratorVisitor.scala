package com.herminiogarcia.shexml.shex

import com.herminiogarcia.shexml.ast._
import com.herminiogarcia.shexml.visitor.DefaultVisitor
import com.typesafe.scalalogging.Logger

import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.util.Try

class ShExGeneratorVisitor(inferences: List[ShExMLInferredCardinalitiesAndDatatypes]) extends DefaultVisitor[HashMap[String, String], ShExSubsetAST] {

  private val logger = Logger[ShExGeneratorVisitor]

  val prefixTable = mutable.HashMap[String, String]()

  override def doVisit(ast: com.herminiogarcia.shexml.ast.AST, optionalArgument: HashMap[String, String]): ShExSubsetAST = ast match {
    case ShExML(declarations, graphs, shapes) => {
      val prefixes = declarations.filter(_.declarationStatement.isInstanceOf[com.herminiogarcia.shexml.ast.Prefix])
        .map(doVisit(_, optionalArgument).asInstanceOf[com.herminiogarcia.shexml.shex.Prefix])
      val shexGraphs = graphs.map(doVisit(_, optionalArgument).asInstanceOf[com.herminiogarcia.shexml.shex.Graph])
      val shexShapes = shapes.map(doVisit(_, optionalArgument).asInstanceOf[com.herminiogarcia.shexml.shex.Shape])
      val result = com.herminiogarcia.shexml.shex.ShEx(prefixes, shexShapes, shexGraphs)
      val totalShapes = shexGraphs.map(_.shapes.size).sum + shexShapes.size
      logger.info(s"Extracted a total of $totalShapes shapes")
      result
    }

    case Declaration(declarationStatement) => {
      doVisit(declarationStatement, optionalArgument)
    }

    case com.herminiogarcia.shexml.ast.Prefix(name, url) => {
      prefixTable += (name.name -> url.url)
      com.herminiogarcia.shexml.shex.Prefix(name.name, url)
    }

    case com.herminiogarcia.shexml.ast.Graph(graphName, shapes) => {
      logger.info(s"Extracting ShEx for ${shapes.size} shapes within the graph ${graphName.prefix + graphName.name}")
      val shexShapes = shapes.map(doVisit(_, optionalArgument).asInstanceOf[com.herminiogarcia.shexml.shex.Shape])
      com.herminiogarcia.shexml.shex.Graph(graphName.prefix + graphName.name, shexShapes)
    }

    case com.herminiogarcia.shexml.ast.Shape(shapeName, action, predicateObjects, _) => {
      logger.info(s"Extracting shape ${shapeName.name} with ${predicateObjects.size} predicate-object statements")
      val shapePrefix = getShapePrefix(action)
      val arguments = HashMap("shapeName" -> shapeName.name)
      val name = shapeName.name
      val iriStart = PartialFixedValue(shapePrefix)
      val shexPredicateObjects = predicateObjects.map(doVisit(_, arguments).asInstanceOf[com.herminiogarcia.shexml.shex.PredicateObject])
      com.herminiogarcia.shexml.shex.Shape(name, iriStart, shexPredicateObjects)
    }

    case com.herminiogarcia.shexml.ast.PredicateObject(predicate, objectOrShapeLink) => {
      val fullPrefix = prefixTable.getOrElse(predicate.prefix, "")
      val arguments = optionalArgument + ("predicateIRI" -> (fullPrefix + predicate.`extension`))
      val shexPredicate = doVisit(predicate, optionalArgument).asInstanceOf[com.herminiogarcia.shexml.shex.Predicate]
      val objectElement = doVisit(objectOrShapeLink, arguments).asInstanceOf[com.herminiogarcia.shexml.shex.ObjectElement]
      com.herminiogarcia.shexml.shex.PredicateObject(shexPredicate, objectElement)
    }

    case com.herminiogarcia.shexml.ast.Predicate(prefix, localname) => {
      com.herminiogarcia.shexml.shex.Predicate(prefix, localname)
    }

    case com.herminiogarcia.shexml.ast.ObjectElement(prefix, _, literalValue, _, _, dataType, langTag, _) => {
      val shapeName = optionalArgument("shapeName")
      val predicateIRI = optionalArgument("predicateIRI")
      val cardinality = getInferredCardinality(shapeName, predicateIRI)

      val shexDatatype =
        if(literalValue.isDefined && langTag.isDefined) "rdf:langString"
        else { dataType match {
          case Some(value) => value match {
            case dt: DataTypeLiteral => dt.value
            case _ => "" //change for generated datatype
          }
          case None => getInferredDatatype(shapeName, predicateIRI).getOrElse("xsd:string")
         }
        }
      literalValue match {
        case Some(value) => FixedValue('"' + value.value + '"')
        case None =>
          if(prefix.isEmpty) {
            if(langTag.isDefined) langTag.get match {
              case LangTagLiteral(value) => FixedValue("@" + value)
              case LangTagGeneration(action, matcher) => throw new Exception("ShEx generation with dynamic langtag is not yet supported!")
            }
            else
              ObjectDefinition(shexDatatype, cardinality)
          }
          else PartialFixedValue(prefix, cardinality)
      }
    }

    case com.herminiogarcia.shexml.ast.ShapeLink(shapeVar) => {
      com.herminiogarcia.shexml.shex.ShapeLink(shapeVar.name)
    }

    case com.herminiogarcia.shexml.ast.LiteralObject(prefix, value) => {
      FixedValue(prefix.name + value)
    }

    case com.herminiogarcia.shexml.ast.LiteralObjectValue(value) => {
      FixedValue('"' + value + '"')
    }

  }

  private def getInferredCardinality(shapeName: String, predicateIRI: String): Cardinality = {
    val filteredInferences = inferences.filter(i => i.shapeName == shapeName && i.predicateIRI == predicateIRI)
    val max = Try(filteredInferences.map(_.observedCardinality).max).getOrElse(1)
    val min = Try(filteredInferences.map(_.observedCardinality).min).getOrElse(1)
    if(min == 0 && max == 1) OptionalCardinality()
    else if(min == 0 && max > 1) ZeroOrMoreCardinality()
    else if(min == 1 && max > 1) OneOrMoreCardinality()
    else NumberCardinality(min, max)
  }

  private def getInferredDatatype(shapeName: String, predicateIRI: String): Option[String] = {
    val filteredInferences = inferences.filter(i => i.shapeName == shapeName && i.predicateIRI == predicateIRI)
    filteredInferences.headOption.flatMap(_.observedDatatype)
  }

  protected def getShapePrefix(action: ActionOrLiteral): String = action match {
    case Action(shapePrefix, _, _) => shapePrefix
    case LiteralSubject(prefix, _) => prefix.name
  }

  override def doVisitDefault(): ShExSubsetAST = ???
}
