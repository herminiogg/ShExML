package com.herminiogarcia.shexml.helper

import com.herminiogarcia.shexml.helper.SourceHelper.{saveFileResult, searchFileResult}

import scala.collection.mutable

/**
  * Created by herminio on 21/2/18.
  */
class SourceHelper {

  def getURLContent(url: String): LoadedSource = searchFileResult(url) match {
    case Some(result) => result
    case None =>
      val parsedURL = new java.net.URL(url)
      val file = scala.io.Source.fromURL(parsedURL, "UTF-8")
      try {
        val content = LoadedSource(file.mkString, url)
        saveFileResult(url, content)
        content
      } finally { file.close() }
  }

  def getContentFromRelativePath(path: String): LoadedSource = searchFileResult(path) match {
    case Some(result) => result
    case None =>
      val file = scala.io.Source.fromFile(path, "UTF-8")
      try {
        val content = LoadedSource(file.mkString, path)
        saveFileResult(path, content)
        content
      } finally { file.close() }
  }

  def getStdinContents(): LoadedSource = {
    LoadedSource(scala.io.Source.stdin.getLines().mkString, "-")
  }

}

object SourceHelper {
  private val table = new mutable.HashMap[String, LoadedSource]()

  def searchFileResult(path: String): Option[LoadedSource] = table.get(path)

  def saveFileResult(path: String, result: LoadedSource): Unit = table += ((path, result))
}

case class LoadedSource(fileContent: String, filepath: String)
