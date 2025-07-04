package com.herminiogarcia.shexml.shex

import com.typesafe.scalalogging.Logger
import org.apache.jena.datatypes.TypeMapper
import org.apache.jena.query.Dataset
import org.apache.jena.rdf.model.{AnonId, ResourceFactory, Statement}
import scala.collection.JavaConverters._
import scala.collection.mutable

class SHACLGenerator(dataset: Dataset, closed: Boolean) {

  private val propertyIndex = (1 to Int.MaxValue).iterator

  private val rdfPrefix = "http://www.w3.org/1999/02/22-rdf-syntax-ns#"
  private val xsdPrefix = "http://www.w3.org/2001/XMLSchema#"
  private val shPrefix = "http://www.w3.org/ns/shacl#"

  val output = dataset.getDefaultModel
  output.setNsPrefix("rdf", rdfPrefix)
  output.setNsPrefix("xsd", xsdPrefix)
  output.setNsPrefix("sh", shPrefix)

  protected val prefixTable = mutable.HashMap[String, String](
    ("rdf:", rdfPrefix),
    ("xsd:", xsdPrefix),
    ("sh:", shPrefix)
  )

  private val logger = Logger[SHACLGenerator]

  def generate(shex: ShExSubsetAST, subjectId: Option[String] = None): Unit = shex match {
    case ShEx(prefixes, shapes, graphs) => {
      prefixes.foreach(generate(_))
      shapes.foreach(generate(_))
      graphs.foreach(generate(_))
    }

    case Prefix(name, url) => {
      prefixTable += (name -> url.value)
      output.setNsPrefix(name.replace(":", ""), url.value)
    }

    case Graph(name, shapes) => {
      // TO DO to check if it can validate graphs
      logger.info(s"Extracting SHACL for ${shapes.size} shapes within the graph $name")
      shapes.foreach(generate(_))
    }

    case Shape(name, partialFixedValue, predicateObjects) => {
      val shapePrefix = prefixTable(name.split(':')(0) + ":")
      val shapeName = name.split(':')(1)
      val shapeSubject = shapePrefix + shapeName
      output.add(createStatement(shapeSubject, rdfPrefix + "type", shPrefix + "NodeShape"))

      if(partialFixedValue.start == "_:")
        output.add(createStatement(shapeSubject, shPrefix + "nodeKind", shPrefix + "BlankNode"))
      else
        output.add(createStatement(shapeSubject, shPrefix + "nodeKind", shPrefix + "IRI"))

      val rdfType = predicateObjects
        .find(po => po.predicate.prefix == "rdf:" && po.predicate.localname == "type")
        .flatMap(_.objectElement match {
          case FixedValue(value) =>
            val targetClassPrefix = prefixTable(value.split(':')(0) + ":")
            val targetClassName = value.split(':')(1)
            Some(targetClassPrefix + targetClassName)
          case _ => None
        })

      output.add(createStatement(shapeSubject, shPrefix + "targetClass", rdfType.getOrElse(shapeSubject)))
      if(closed) {
        output.add(createStatementWithLiteral(shapeSubject, shPrefix + "closed", "true", xsdPrefix + "boolean"))
      }
      logger.info(s"Extracting shape $name with ${predicateObjects.size} predicate-object statements")
      predicateObjects.foreach(po => generate(po, Some(shapeSubject)))
    }

    case PredicateObject(predicate, objectElement) => {
      val shapeSubject = subjectId.get
      val propertySubject = "_:" + propertyIndex.next()

      generate(predicate, Some(propertySubject))
      generate(objectElement, Some(propertySubject))
      output.add(createStatement(shapeSubject, shPrefix + "property", propertySubject))
    }

    case Predicate(prefix, localname) => {
      val subject = subjectId.get
      val path = prefixTable(prefix) + localname
      output.add(createBNodeStatement(subject, shPrefix + "path", path))
    }

    case ShapeLink(linkedShape) => {
      val subject = subjectId.get
      val prefixLinkedShape = prefixTable(linkedShape.split(':')(0) + ":")
      val linkedShapeName = linkedShape.split(':')(1)
      val fullShapeName = prefixLinkedShape + linkedShapeName

      //output.add(createBNodeStatement(subject, shPrefix + "nodeKind", shPrefix + "IRI"))
      output.add(createBNodeStatement(subject, shPrefix + "node", fullShapeName))
    }

    case ObjectDefinition(datatype, cardinality) => {
      val subject = subjectId.get
      val theType = datatype.split(':')(1)
      output.add(createBNodeStatement(subject, shPrefix + "datatype", xsdPrefix + theType))

      generate(cardinality, subjectId)
    }

    case FixedValue(value) => {
      val subject = subjectId.get

      val objectValue =
        if(value.contains(":")) {
          val prefix = prefixTable(value.split(':')(0) + ":")
          output.add(createBNodeStatementWithList(subject, shPrefix + "in", prefix + value.split(':')(1)))
        } else {
          output.add(createBNodeStatementWithList(subject, shPrefix + "languageIn", value.replace("@", "")))
        }

    }

    case PartialFixedValue(start, cardinality) => {
      // to check if it is possible
      val subject = subjectId.get
      output.add(createBNodeStatement(subject, shPrefix + "nodeKind", shPrefix + "IRI"))
      generate(cardinality, subjectId)
    }

    case NumberCardinality(from, to) => {
      val subject = subjectId.get
      output.add(
        createBNodeStatementWithLiteral(subject, shPrefix + "minCount", from.toString, xsdPrefix + "integer"))
      output.add(
        createBNodeStatementWithLiteral(subject, shPrefix + "maxCount", to.toString, xsdPrefix + "integer"))
    }

    case OptionalCardinality() => {
      val subject = subjectId.get
      output.add(
        createBNodeStatementWithLiteral(subject, shPrefix + "minCount", "0", xsdPrefix + "integer"))
      output.add(
        createBNodeStatementWithLiteral(subject, shPrefix + "maxCount", "1", xsdPrefix + "integer"))
    }

    case ZeroOrMoreCardinality() => {
      val subject = subjectId.get
      output.add(
        createBNodeStatementWithLiteral(subject, shPrefix + "minCount", "0", xsdPrefix + "integer"))
    }

    case OneOrMoreCardinality() => {
      val subject = subjectId.get
      output.add(
        createBNodeStatementWithLiteral(subject, shPrefix + "minCount", "1", xsdPrefix + "integer"))
    }
  }

  protected def createStatement(s: String, p: String, o: String): Statement = {
    val subject = ResourceFactory.createResource(s)
    val predicate = ResourceFactory.createProperty(p)
    val obj = if(o.contains("_:"))
      dataset.getDefaultModel.createResource(new AnonId(o.replace("_:", "")))
    else ResourceFactory.createResource(o)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  protected def createBNodeStatement(s: String, p: String, o: String): Statement = {
    val anonID = new AnonId(s.replace("_:", ""))
    val subject = dataset.getDefaultModel.createResource(anonID)
    val predicate = ResourceFactory.createProperty(p)
    val obj = if(o.contains("_:"))
      dataset.getDefaultModel.createResource(new AnonId(o.replace("_:", "")))
    else ResourceFactory.createResource(o)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  protected def createBNodeStatementWithList(s: String, p: String, o: String): Statement = {
    val anonID = new AnonId(s.replace("_:", ""))
    val subject = dataset.getDefaultModel.createResource(anonID)
    val predicate = ResourceFactory.createProperty(p)
    val obj =
      if(o.contains("://")) {
        ResourceFactory.createResource(o)
      } else {
        ResourceFactory.createPlainLiteral(o)
      }
    val list = output.createList(List(obj).toIterator.asJava)
    ResourceFactory.createStatement(subject, predicate, list)
  }

  protected def createStatementWithLiteral(s: String, p: String, o: String, dataType: String): Statement = {
    val subject = ResourceFactory.createResource(s)
    val predicate = ResourceFactory.createProperty(p)
    val obj = ResourceFactory.createTypedLiteral(o, TypeMapper.getInstance().getSafeTypeByName(dataType))
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  protected def createBNodeStatementWithLiteral(s: String, p: String, o: String, dataType: String): Statement = {
    val anonID = new AnonId(s.replace("_:", ""))
    val subject = dataset.getDefaultModel.createResource(anonID)
    val predicate = ResourceFactory.createProperty(p)
    val obj = ResourceFactory.createTypedLiteral(o, TypeMapper.getInstance().getSafeTypeByName(dataType))
    ResourceFactory.createStatement(subject, predicate, obj)
  }

}
