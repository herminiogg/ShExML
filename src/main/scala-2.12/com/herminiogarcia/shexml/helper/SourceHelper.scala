package com.herminiogarcia.shexml.helper

/**
  * Created by herminio on 21/2/18.
  */
class SourceHelper {

  def getURLContent(url: String): String = {
    val file = scala.io.Source.fromURL(url, "UTF-8")
    try { file.mkString } finally { file.close() }
  }

  def getContentFromRelativePath(path: String): String = {
    val file = scala.io.Source.fromFile(path, "UTF-8")
    try { file.mkString } finally { file.close() }
  }

}
