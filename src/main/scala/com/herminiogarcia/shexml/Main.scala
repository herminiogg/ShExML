package com.herminiogarcia.shexml

import picocli.CommandLine
import picocli.CommandLine.{Command, Option}

import java.io.{File, PrintWriter}
import java.util.concurrent.Callable

/**
  * Created by herminio on 22/12/17.
  */
object Main {

  def main(args: Array[String]): Unit = {
    System.exit(new CommandLine(new Main()).execute(args: _*))
  }

}

@Command(name = "ShExML", version = Array("v0.5.3"),
  mixinStandardHelpOptions = true,
  description = Array("Map and merge heterogeneous data sources with a Shape Expressions based syntax"))
class Main extends Callable[Int] {

  @Option(names = Array("-r", "--rml"), description = Array("Generate RML output"))
  private var rmlOutput: Boolean = false

  @Option(names = Array("-rp", "--rmlPrettified"), description = Array("Generate RML output using Blank nodes for better readability"))
  private var rmlPrettifyOutput: Boolean = false

  @Option(names = Array("-s", "--shex"), description = Array("Generate ShEx validation"))
  private var shexOutput: Boolean = false

  @Option(names = Array("-sm", "--shapeMap"), description = Array("Generate Shape Map for ShEx validation"))
  private var shapeMapOutput: Boolean = false

  @Option(names = Array("-sh", "--shacl"), description = Array("Generate SHACL validation"))
  private var shaclOutput: Boolean = false

  @Option(names = Array("-shc", "--shaclClosed"), description = Array("Generate SHACL validation with closed shapes as default"))
  private var shaclClosedOutput: Boolean = false

  @Option(names = Array("-f", "--format"), description = Array("Output format for RDF graph. Turtle, RDF/XML, N-Triples, ..."))
  private var format: String = "Turtle"

  @Option(names = Array("-o", "--output"), description = Array("Path where the output file should be created"))
  private var output: String = ""

  @Option(names = Array("-m", "--mapping"), required = true, description = Array("Path to the file with the mappings"))
  private var file: String = ""

  @Option(names = Array("-u", "--username"), description = Array("Username in case of using a database"))
  private var username: String = ""

  @Option(names = Array("-p", "--password"), description = Array("Password in case of using a database"))
  private var password: String = ""

  @Option(names = Array("-d", "--drivers"), description = Array("Add more JDBC database drivers in the form of <startJDBCURL>%%<driver> and separating them with \";\". Example: jdbc:postgresql%%org.postgresql.Driver;jdbc:oracle%%oracle.jdbc.OracleDriver"))
  private var drivers: String = ""

  @Option(names = Array("-id", "--inferenceDatatypes"), description = Array("Use the inference system for choosing the best suited datatype for the generated literal. Without this option, and not declaring a datatype in the mapping rules, all the literals will be outputted as strings"))
  private var inferenceDatatype: Boolean = false

  @Option(names = Array("-nu", "--normaliseURIs"), description = Array("Activate the URI normalisation system which allows to avoid malformed URIs when using strings for URI creation"))
  private var normaliseURIs: Boolean = false

  @Option(names = Array("-pc", "--precompile"), description = Array("Create a single version including all the imported files, useful for debugging purposes"))
  private var preCompile: Boolean = false

  override def call(): Int = {
    val fileHandler = scala.io.Source.fromFile(file)
    try {
      val fileContent = fileHandler.mkString
      val mappingLauncher = new MappingLauncher(username, password, drivers, inferenceDatatype, normaliseURIs)
      val outputContent = if(rmlOutput) {
        mappingLauncher.launchRMLTranslation(fileContent, false)
      } else if(rmlPrettifyOutput) {
        mappingLauncher.launchRMLTranslation(fileContent, true)
      } else if(shexOutput) {
        mappingLauncher.launchShExGeneration(fileContent)
      } else if(shapeMapOutput) {
        mappingLauncher.launchShapeMapGeneration(fileContent)
      } else if(shaclOutput) {
        mappingLauncher.launchSHACLGeneration(fileContent)
      } else if(shaclClosedOutput) {
        mappingLauncher.launchSHACLGeneration(fileContent, true)
      } else if(preCompile) {
        mappingLauncher.precompile(fileContent)
      } else {
        mappingLauncher.launchMapping(fileContent, format)
      }
      if(output.isEmpty) println(outputContent) else {
        val pw = new PrintWriter(new File(output))
        pw.print(outputContent)
        pw.close()
      }
      1 // well finished
    } finally { fileHandler.close() }
  }
}
