package com.herminiogarcia.shexml.helper

import com.herminiogarcia.shexml.helper.SourceHelper.{saveFileResult, searchFileResult}

import scala.collection.mutable

/**
  * Created by herminio on 21/2/18.
  */
class SourceHelper {

  def getURLContent(url: String): String = searchFileResult(url) match {
    case Some(result) => result
    case None =>
      val file = scala.io.Source.fromURL(url, "UTF-8")
      try {
        val content = file.mkString
        saveFileResult(url, content)
        content
      } finally { file.close() }
  }

  def getContentFromRelativePath(path: String): String = searchFileResult(path) match {
    case Some(result) => result
    case None =>
      val file = scala.io.Source.fromFile(path, "UTF-8")
      try {
        val content = file.mkString
        saveFileResult(path, content)
        content
      } finally { file.close() }
  }

}

object SourceHelper {
  private val table = new mutable.HashMap[String, String]()

  def searchFileResult(path: String): Option[String] = table.get(path)

  def saveFileResult(path: String, result: String): Unit = table += ((path, result))
}
