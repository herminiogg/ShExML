package es.weso.shexml.rml

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import be.ugent.rml.functions.FunctionLoader
import be.ugent.rml.records.RecordsFactory
import be.ugent.rml.store.{QuadStoreFactory, RDF4JStore}
import be.ugent.rml.{Executor, Utils}
import org.apache.jena.query.{Dataset, DatasetFactory}
import org.apache.jena.riot.{RDFDataMgr, RDFLanguages}

import scala.reflect.io.File

trait RMLTestConversion {

  def doTranslation(inputRML: String, prefix: String): Dataset = {
    val inputStream = new ByteArrayInputStream(inputRML.getBytes("UTF-8"))
    val rmlStore = QuadStoreFactory.read(inputStream)
    val outputStore = new RDF4JStore()
    val factory = new RecordsFactory(File(".").toAbsolute.path)
    val functionLoader = new FunctionLoader()
    val executor = new Executor(rmlStore, factory, functionLoader, outputStore, Utils.getBaseDirectiveTurtle(inputStream))
    val rmlOutput = executor.execute(null)
    val dataset = DatasetFactory.create()
    val stream = new ByteArrayOutputStream()
    rmlOutput.write(stream, "trig")
    RDFDataMgr.read(dataset, new ByteArrayInputStream(stream.toByteArray), RDFLanguages.TRIG)
    dataset
  }

}
