package es.weso.shexml

import java.io.{File, PrintWriter}
import java.util.concurrent.Callable

import picocli.CommandLine
import picocli.CommandLine.{Command, Option}

/**
  * Created by herminio on 22/12/17.
  */
object Main {

  def main(args: Array[String]): Unit = {
    System.exit(new CommandLine(new Main()).execute(args: _*))
  }

}

@Command(name = "ShExML", version = Array("v0.2.4"),
  mixinStandardHelpOptions = true,
  description = Array("Map and merge heterogeneous data sources with a Shape Expressions based syntax"))
class Main extends Callable[Int] {

  @Option(names = Array("-r", "--rml"), description = Array("Generate RML output"))
  private var rmlOutput: Boolean = false

  @Option(names = Array("-s", "--shex"), description = Array("Generate ShEx validation"))
  private var shexOutput: Boolean = false

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

  override def call(): Int = {
    val fileHandler = scala.io.Source.fromFile(file)
    try {
      val fileContent = fileHandler.mkString
      val mappingLauncher = new MappingLauncher(username, password)
      val outputContent = if(rmlOutput) {
        mappingLauncher.launchRMLTranslation(fileContent)
      } else if(shexOutput) {
        mappingLauncher.launchShExGeneration(fileContent)
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
