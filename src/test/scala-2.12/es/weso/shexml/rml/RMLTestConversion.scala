package es.weso.shexml.rml

import java.io.ByteArrayInputStream

import be.ugent.rml.{DataFetcher, Executor}
import be.ugent.rml.records.RecordsFactory
import be.ugent.rml.store.RDF4JStore
import org.apache.jena.rdf.model.{Model, ModelFactory}
import org.eclipse.rdf4j.rio.{RDFFormat, Rio}

trait RMLTestConversion {

  def doTranslation(inputRML: String, prefix: String): Model = {
    val inputStream = new ByteArrayInputStream(inputRML.getBytes("UTF-8"))
    val model = Rio.parse(inputStream, "", RDFFormat.TURTLE)
    val rmlStore = new RDF4JStore(model)
    val rmlOutput = new Executor(rmlStore, new RecordsFactory(new DataFetcher("", rmlStore)), prefix).execute(null)
    ModelFactory.createDefaultModel().read(new ByteArrayInputStream(
      rmlOutput.toString.replace("null", ".").getBytes("UTF-8")), null, "N3")
  }

}
