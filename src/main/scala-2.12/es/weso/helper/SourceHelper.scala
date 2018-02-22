package es.weso.helper

/**
  * Created by herminio on 21/2/18.
  */
class SourceHelper {

  def getURLContent(url: String): String = {
    scala.io.Source.fromURL(url).mkString
  }

}
