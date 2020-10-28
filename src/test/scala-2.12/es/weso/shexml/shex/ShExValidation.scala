package es.weso.shexml.shex

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}

import es.weso.rdf.rdf4j.RDFAsRDF4jModel
import es.weso.shapeMaps.ShapeMap
import es.weso.shex.{ResolvedSchema, Schema}
import es.weso.shex.validator.Validator
import es.weso.shexml.MappingLauncher
import org.eclipse.rdf4j.model.impl.DynamicModelFactory
import org.eclipse.rdf4j.rio.{RDFFormat, Rio}

trait ShExValidation {

  def validate(shexml: String, shapemap: String): Boolean = {
    val mappingLauncher = new MappingLauncher()
    val output = mappingLauncher.launchMapping(shexml).getDefaultModel
    val outputStream = new ByteArrayOutputStream()
    output.write(outputStream, "Turtle")
    val inputStream = new ByteArrayInputStream(outputStream.toByteArray)
    val model = Rio.parse(inputStream, "", RDFFormat.TURTLE)
    val rdf = RDFAsRDF4jModel(model)
    val rdfBuilder = RDFAsRDF4jModel(new DynamicModelFactory().createEmptyModel()).asRDFBuilder.unsafeRunSync()
    val shexString = mappingLauncher.launchShExGeneration(shexml)
    val shexSchema = Schema.fromString(shexString, "ShexC").unsafeRunSync()
    val shapeMap = ShapeMap.fromString(shapemap,
      ShapeMap.defaultFormat,
      None,
      rdf.getPrefixMap.unsafeRunSync(),
      shexSchema.prefixMap)
    shapeMap match {
      case Right(value) => {
        val fixedShapeMap = ShapeMap.fixShapeMap(value, rdf, rdf.getPrefixMap.unsafeRunSync(), shexSchema.prefixMap).unsafeRunSync()
        val resolvedSchema = ResolvedSchema.resolve(shexSchema, None).unsafeRunSync()
        Validator.validate(resolvedSchema, fixedShapeMap, rdf, rdfBuilder).unsafeRunSync().toResultShapeMap.attempt.unsafeRunSync().isRight
      }
      case Left(l) => throw new Exception(l)
    }
  }

}
