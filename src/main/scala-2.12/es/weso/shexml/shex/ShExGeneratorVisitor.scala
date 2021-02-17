package es.weso.shexml.shex

import es.weso.shexml.ast.{DataTypeLiteral, Declaration, LangTagGeneration, LangTagLiteral, ShExML}
import es.weso.shexml.visitor.DefaultVisitor

import scala.collection.immutable.HashMap
import scala.collection.mutable
import scala.util.Try

class ShExGeneratorVisitor(inferences: List[ShExMLInferredCardinalitiesAndDatatypes]) extends DefaultVisitor[HashMap[String, String], ShExSubsetAST] {

  val prefixTable = mutable.HashMap[String, String]()

  override def doVisit(ast: es.weso.shexml.ast.AST, optionalArgument: HashMap[String, String]): ShExSubsetAST = ast match {
    case ShExML(declarations, graphs, shapes) => {
      val prefixes = declarations.filter(_.declarationStatement.isInstanceOf[es.weso.shexml.ast.Prefix])
        .map(doVisit(_, optionalArgument).asInstanceOf[Prefix])
      val shexGraphs = graphs.map(doVisit(_, optionalArgument).asInstanceOf[Graph])
      val shexShapes = shapes.map(doVisit(_, optionalArgument).asInstanceOf[Shape])
      ShEx(prefixes, shexShapes, shexGraphs)
    }

    case Declaration(declarationStatement) => {
      doVisit(declarationStatement, optionalArgument)
    }

    case es.weso.shexml.ast.Prefix(name, url) => {
      prefixTable += (name.name -> url.url)
      Prefix(name.name, url)
    }

    case es.weso.shexml.ast.Graph(graphName, shapes) => {
      val shexShapes = shapes.map(doVisit(_, optionalArgument).asInstanceOf[Shape])
      Graph(graphName.prefix + graphName.name, shexShapes)
    }

    case es.weso.shexml.ast.Shape(shapeName, shapePrefix, _, predicateObjects, _) => {
      val arguments = HashMap("shapeName" -> shapeName.name)
      val name = shapeName.name
      val iriStart = PartialFixedValue(shapePrefix)
      val shexPredicateObjects = predicateObjects.map(doVisit(_, arguments).asInstanceOf[PredicateObject])
      Shape(name, iriStart, shexPredicateObjects)
    }

    case es.weso.shexml.ast.PredicateObject(predicate, objectOrShapeLink) => {
      val fullPrefix = prefixTable.getOrElse(predicate.prefix, "")
      val arguments = optionalArgument + ("predicateIRI" -> (fullPrefix + predicate.`extension`))
      val shexPredicate = doVisit(predicate, optionalArgument).asInstanceOf[Predicate]
      val objectElement = doVisit(objectOrShapeLink, arguments).asInstanceOf[ObjectElement]
      PredicateObject(shexPredicate, objectElement)
    }

    case es.weso.shexml.ast.Predicate(prefix, localname) => {
      Predicate(prefix, localname)
    }

    case es.weso.shexml.ast.ObjectElement(prefix, _, literalValue, _, dataType, langTag, _) => {
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

    case es.weso.shexml.ast.ShapeLink(shapeVar) => {
      ShapeLink(shapeVar.name)
    }

    case es.weso.shexml.ast.LiteralObject(prefix, value) => {
      FixedValue(prefix.name + value)
    }

    case es.weso.shexml.ast.LiteralObjectValue(value) => {
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

  override def doVisitDefault(): ShExSubsetAST = ???
}
