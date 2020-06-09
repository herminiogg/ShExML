package es.weso.main

import java.io.{File, PrintWriter}
import java.util.concurrent.Callable

import es.weso.shexml.MappingLauncher
import picocli.CommandLine
import picocli.CommandLine.{Command, Option, Parameters}

/**
  * Created by herminio on 22/12/17.
  */
object Main {

  def main(args: Array[String]): Unit = {
    System.exit(new CommandLine(new Main()).execute(args: _*))
  }

}

@Command(name = "ShExML", version = Array("v0.2.1"),
  mixinStandardHelpOptions = true,
  description = Array("Map and merge heterogeneous data sources with a Shape Expressions based syntax"))
class Main extends Callable[Int] {

  @Option(names = Array("-r", "--rml"), description = Array("Generate RML output"))
  private var rmlOutput: Boolean = false

  @Option(names = Array("-f", "--format"), description = Array("Output format for RDF graph. Turtle, RDF/XML, N-Triples, ..."))
  private var format: String = "Turtle"

  @Option(names = Array("-o", "--output"), description = Array("Path where the output file should be created"))
  private var output: String = ""

  @Option(names = Array("-m", "--mapping"), required = true, description = Array("Path to the file with the mappings"))
  private var file: String = ""

  override def call(): Int = {
    val fileHandler = scala.io.Source.fromFile(file)
    try {
      val fileContent = fileHandler.mkString
      val outputContent = if(rmlOutput) {
        val mappingLauncher = new MappingLauncher()
        mappingLauncher.launchRMLTranslation(fileContent)
      } else {
        val mappingLauncher = new MappingLauncher()
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
