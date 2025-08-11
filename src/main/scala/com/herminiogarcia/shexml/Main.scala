package com.herminiogarcia.shexml

import com.herminiogarcia.shexml.helper.{ParallelExecutionConfigurator, PicocliLeftAlignedLayout}
import picocli.CommandLine
import picocli.CommandLine.{ArgGroup, Command, Option}

import java.io.{File, PrintWriter}
import java.util.concurrent.Callable

/**
  * Created by herminio on 22/12/17.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val commandLine = new CommandLine(new Main())
      .setPosixClusteredShortOptionsAllowed(false)
      .setHelpFactory(PicocliLeftAlignedLayout.createCustomizedUsageHelp())
    System.exit(commandLine.execute(args: _*))
  }
}

@Command(name = "ShExML", version = Array("v0.5.4"),
  mixinStandardHelpOptions = true,
  sortOptions = false,
  description = Array("Map and merge heterogeneous data sources with a Shape Expressions based syntax"))
class Main extends Callable[Int] {

  @Option(names = Array("-m", "--mapping"), required = true, description = Array("Path to the file with the mappings"))
  private var file: String = ""

  @ArgGroup(validate = false, heading = "Options for the transformation to RDF%n")
  private var transformationModifiers: TransformationModifiers = new TransformationModifiers()

  @ArgGroup(exclusive = true, multiplicity = "0..1", heading = "Other transformation options%n")
  private var otherTransformations: OtherTransformations = new OtherTransformations()

  @ArgGroup(validate = false, heading = "General configuration options applying to all the available transformations%n")
  private var generalTransformationOptions: GeneralTransformationOptions = new GeneralTransformationOptions()

  override def call(): Int = {
    val fileHandler = scala.io.Source.fromFile(file)
    val parallelExecutionConfiguration =
      if(generalTransformationOptions.parallel) ParallelExecutionConfigurator(generalTransformationOptions.parallelAspects, generalTransformationOptions.numberOfThreads)
      else ParallelExecutionConfigurator.empty
    try {
      val fileContent = fileHandler.mkString
      val mappingLauncher = new MappingLauncher(
        generalTransformationOptions.username,
        generalTransformationOptions.password,
        generalTransformationOptions.drivers,
        transformationModifiers.inferenceDatatype,
        transformationModifiers.normaliseURIs,
        parallelExecutionConfiguration
      )
      val outputContent = if(otherTransformations.rmlOutput) {
        mappingLauncher.launchRMLTranslation(fileContent)
      } else if(otherTransformations.rmlPrettifyOutput) {
        mappingLauncher.launchRMLTranslation(fileContent, prettify = true)
      } else if(otherTransformations.shexOutput) {
        mappingLauncher.launchShExGeneration(fileContent)
      } else if(otherTransformations.shapeMapOutput) {
        mappingLauncher.launchShapeMapGeneration(fileContent)
      } else if(otherTransformations.shaclOutput) {
        mappingLauncher.launchSHACLGeneration(fileContent)
      } else if(otherTransformations.shaclClosedOutput) {
        mappingLauncher.launchSHACLGeneration(fileContent, closed = true)
      } else if(otherTransformations.preCompile) {
        mappingLauncher.precompile(fileContent)
      } else {
        mappingLauncher.launchMapping(fileContent, transformationModifiers.format)
      }
      if(generalTransformationOptions.output.isEmpty) println(outputContent) else {
        val pw = new PrintWriter(new File(generalTransformationOptions.output))
        pw.print(outputContent)
        pw.close()
      }
      0 // well finished
    } finally { fileHandler.close() }
  }
}

class TransformationModifiers {
  @Option(names = Array("-id", "--inferenceDatatypes"), description = Array("Use the inference system for choosing the best suited datatype for the generated literal. Without this option, and not declaring a datatype in the mapping rules, all the literals will be outputted as strings"))
  var inferenceDatatype: Boolean = false

  @Option(names = Array("-nu", "--normaliseURIs"), description = Array("Activate the URI normalisation system which allows to avoid malformed URIs when using strings for URI creation"))
  var normaliseURIs: Boolean = false

  @Option(names = Array("-f", "--format"), description = Array("Output format for RDF graph. Turtle, RDF/XML, N-Triples, ..."))
  var format: String = "Turtle"
}

class OtherTransformations {
  @Option(names = Array("-pc", "--precompile"), description = Array("Create a single version including all the imported files, useful for debugging purposes. Additionally it checks the input for syntactic and grammatical errors"))
  var preCompile: Boolean = false

  @Option(names = Array("-r", "--rml"), description = Array("Generate RML output"))
  var rmlOutput: Boolean = false

  @Option(names = Array("-rp", "--rmlPrettified"), description = Array("Generate RML output using Blank nodes for better readability"))
  var rmlPrettifyOutput: Boolean = false

  @Option(names = Array("-s", "--shex"), description = Array("Generate ShEx validation"))
  var shexOutput: Boolean = false

  @Option(names = Array("-sm", "--shapeMap"), description = Array("Generate Shape Map for ShEx validation"))
  var shapeMapOutput: Boolean = false

  @Option(names = Array("-sh", "--shacl"), description = Array("Generate SHACL validation"))
  var shaclOutput: Boolean = false

  @Option(names = Array("-shc", "--shaclClosed"), description = Array("Generate SHACL validation with closed shapes as default"))
  var shaclClosedOutput: Boolean = false
}

class GeneralTransformationOptions {
  @Option(names = Array("-o", "--output"), description = Array("Path where the output file should be created"))
  var output: String = ""

  @Option(names = Array("-u", "--username"), description = Array("Username in case of using a database"))
  var username: String = ""

  @Option(names = Array("-p", "--password"), description = Array("Password in case of using a database"))
  var password: String = ""

  @Option(names = Array("-d", "--drivers"), description = Array("Add more JDBC database drivers in the form of <startJDBCURL>%%<driver> and separating them with \";\". Example: jdbc:postgresql%%org.postgresql.Driver;jdbc:oracle%%oracle.jdbc.OracleDriver"))
  var drivers: String = ""

  @Option(names = Array("--parallel"), description = Array("EXPERIMENTAL: Enables the execution of the engine in concurrent mode"))
  var parallel: Boolean = false

  @Option(names = Array("--parallelAspects"), description = Array("EXPERIMENTAL: Allows to select the aspects that will be parallelised. The possible options are: \"queries\", \"shapes\", or \"all\"."))
  var parallelAspects: String = "all"

  @Option(names = Array("--nThreads"), description = Array("EXPERIMENTAL: The number of threads to use in the parallelisation. Default to the number of virtual threads of the processor."))
  var numberOfThreads: String = ""
}
