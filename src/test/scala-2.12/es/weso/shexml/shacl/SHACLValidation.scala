package es.weso.shexml.shacl

import es.weso.shexml.MappingLauncher
import org.apache.jena.query.DatasetFactory
import org.apache.jena.riot.{Lang, RDFDataMgr}
import org.apache.jena.shacl.ShaclValidator
import java.io.ByteArrayInputStream

trait SHACLValidation {

  def validate(shexml: String, closed: Boolean = false): Boolean = {
    val mappingLauncher = new MappingLauncher()
    val dataGraph = mappingLauncher.launchMapping(shexml)

    val shaclString = mappingLauncher.launchSHACLGeneration(shexml, closed)
    val in = new ByteArrayInputStream(shaclString.getBytes)
    val shaclDataset = DatasetFactory.create()
    RDFDataMgr.read(shaclDataset, in, Lang.TURTLE)

    ShaclValidator.get
      .conforms(shaclDataset.getDefaultModel.getGraph, dataGraph.getDefaultModel.getGraph)
  }

}
