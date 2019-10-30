package es.weso.shexml

import org.apache.jena.datatypes.RDFDatatype
import org.apache.jena.rdf.model.{AnonId, Model, ResourceFactory, Statement}

/**
  * Created by herminio on 21/2/18.
  */
trait RDFStatementCreator {

  def createStatement(prefix: String, s: String, p: String, o: String): Statement = {
    val subject = ResourceFactory.createResource(prefix + s)
    val predicate = ResourceFactory.createProperty(prefix + p)
    val obj = ResourceFactory.createResource(prefix + o)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  def createStatementWithLiteral(prefix: String, s: String, p: String, o: String, xsdType: RDFDatatype): Statement = {
    val subject = ResourceFactory.createResource(prefix + s)
    val predicate = ResourceFactory.createProperty(prefix + p)
    val obj = ResourceFactory.createTypedLiteral(o, xsdType)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  def createStatementWithLiteral(prefix: String, s: String, p: String, o: String, langTag: String): Statement = {
    val subject = ResourceFactory.createResource(prefix + s)
    val predicate = ResourceFactory.createProperty(prefix + p)
    val obj = ResourceFactory.createLangLiteral(o, langTag)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  def createStatementWithBNodeSubject(model: Model, prefix: String, s: String, p: String, o: String): Statement = {
    val subject = model.createResource(new AnonId(s))
    val predicate = ResourceFactory.createProperty(prefix + p)
    val obj = ResourceFactory.createResource(prefix + o)
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  def createStatementWithBNodeObject(model: Model, prefix: String, s: String, p: String, o: String): Statement = {
    val subject = ResourceFactory.createResource(prefix + s)
    val predicate = ResourceFactory.createProperty(prefix + p)
    val obj = model.createResource(new AnonId(o))
    ResourceFactory.createStatement(subject, predicate, obj)
  }

  def createStatementWithLiteralAndBNodeSubject(model: Model, prefix: String, s: String, p: String, o: String, xsdType: RDFDatatype): Statement = {
    val subject = model.createResource(new AnonId(s))
    val predicate = ResourceFactory.createProperty(prefix + p)
    val obj = ResourceFactory.createTypedLiteral(o, xsdType)
    ResourceFactory.createStatement(subject, predicate, obj)
  }


}
