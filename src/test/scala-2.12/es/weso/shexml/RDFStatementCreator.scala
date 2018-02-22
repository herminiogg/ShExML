package es.weso.shexml

import org.apache.jena.datatypes.RDFDatatype
import org.apache.jena.rdf.model.{ResourceFactory, Statement}

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

}
