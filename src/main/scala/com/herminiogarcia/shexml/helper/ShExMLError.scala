package com.herminiogarcia.shexml.helper

import com.herminiogarcia.shexml.ast.{ParserInfo, UnknownParserInfo}
import scala.collection.JavaConverters._

trait ShExMLError extends Exception {
  val message: String
  val parserInfo: ParserInfo
  private val BOLD = "\u001B[1m"
  private val UNDERLINE = "\u001B[4m"
  private val RESET_BOLD = "\u001B[22m"
  private val RESET_UNDERLINE = "\u001B[24m"

  def getEnrichedErrorMessage: String = {
    s"$message between line ${parserInfo.startLine.getOrElse("unknown")} column ${parserInfo.endColumn.getOrElse("unknown")} and line ${parserInfo.endLine.getOrElse("unknown")} column ${parserInfo.endColumn.getOrElse("unknown")}"
  }

  def getEnrichedErrorMessage(input: String): String = {
    val inputLines = input.lines().toList.asScala.toList
    parserInfo.startLine match {
      case Some(sl) if sl > 0 =>
        parserInfo.endLine.flatMap(el => {
          if(el == sl) {
            val mainLine = inputLines(sl - 1)
            parserInfo.startColumn.map(sc => {
              val mainLineSplit = mainLine.splitAt(sc - 1)
              val endSplit = parserInfo.endColumn.map(ec => mainLineSplit._2.splitAt(ec))
              val highlightedLine = endSplit.map(es => generateHighlightedErrorExtract(sl, mainLineSplit._1, es._1, es._2))
              s"$message in line $sl between columns ${parserInfo.startColumn.getOrElse("unknown")} and ${parserInfo.endColumn.getOrElse("unknown")}\n\n${highlightedLine.getOrElse("")}\n"
            })
          } else {
            val mainLines = inputLines.slice(sl - 1 , el)
            parserInfo.startColumn.map(sc => {
              val firstLineSplit = mainLines.head.splitAt(sc - 1)
              val lastLineSplit = parserInfo.endColumn.map(ec => mainLines.last.splitAt(ec))
              val inBetweenLines = {
                val lines = mainLines.tail.dropRight(1).mkString("\n")
                if(lines.nonEmpty) lines + "\n"
                else lines
              }
              val highlightedLines = lastLineSplit.map(lls => generateHighlightedErrorExtract(sl, firstLineSplit._1, firstLineSplit._2 + "\n" + inBetweenLines + lls._1, lls._2))
              s"$message between line $sl column ${parserInfo.startColumn.getOrElse("unknown")} and line $el and column ${parserInfo.endColumn.getOrElse("unknown")}\n\n${highlightedLines.getOrElse("")}\n"
            })
          }
        }).getOrElse(s"$message near line $sl and column ${parserInfo.startColumn.getOrElse("unknown")}\n")
      case None =>
        this.getEnrichedErrorMessage
    }
  }

  private def generateHighlightedErrorExtract(firstLineNumber: Int, before: String, affectedFragment: String, after: String): String = {
    val lineCounter = Iterator.from(firstLineNumber)
    val output = before + BOLD + UNDERLINE + affectedFragment + RESET_BOLD + RESET_UNDERLINE + after
    output.lines().toList.asScala.map(ol => s"${lineCounter.next()}: ${resetBoldAndUnderline(ol)}").mkString("\n")
  }

  private def resetBoldAndUnderline(input: String): String = {
    if(input.contains(BOLD + UNDERLINE) && !input.contains(RESET_BOLD + RESET_UNDERLINE)) {
      input + RESET_BOLD + RESET_UNDERLINE
    } else if(!input.contains(BOLD + UNDERLINE) && input.contains(RESET_BOLD + RESET_UNDERLINE)) {
      BOLD + UNDERLINE + input
    } else input
  }
}

case class RDFGenerationError(message: String, parserInfo: ParserInfo) extends ShExMLError
case class RMLGenerationError(message: String, parserInfo: ParserInfo) extends ShExMLError
case class ShapesGenerationError(message: String, parserInfo: ParserInfo) extends ShExMLError
case class JDBCDriverError(message: String, parserInfo: ParserInfo) extends ShExMLError
case class QueryError(message: String, parserInfo: ParserInfo) extends ShExMLError
case class VarError(message: String, parserInfo: ParserInfo) extends ShExMLError
case class FileError(message: String, parserInfo: ParserInfo) extends ShExMLError
case class FunctionExecutionError(message: String, parserInfo: ParserInfo = UnknownParserInfo) extends ShExMLError
case class SemanticCheckerError(message: String, parserInfo: ParserInfo) extends ShExMLError
