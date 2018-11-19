package es.weso.main

import es.weso.shexml.MappingLauncher

/**
  * Created by herminio on 22/12/17.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val file = if(args(0).contains("://"))
      scala.io.Source.fromURL(args(0)).mkString
    else
      scala.io.Source.fromFile(args(0)).mkString
    val mappingLauncher = new MappingLauncher()
    val output = mappingLauncher.launchMapping(file, "TURTLE")
    println(output)
  }

}
