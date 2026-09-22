package com.herminiogarcia.shexml.helper

import com.github.vickumar1981.stringdistance.StringConverter._
import com.herminiogarcia.shexml.ast.ParserInfo
import com.typesafe.scalalogging.Logger

import java.io.{ByteArrayOutputStream, File}
import java.net.{URL, URLClassLoader}
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.util.regex.Pattern
import javax.tools.ToolProvider
import scala.tools.reflect.ToolBox
import scala.reflect.runtime._

sealed trait FunctionHubExecutor {

  val functionsCode: LoadedSource
  val parserInfo: ParserInfo
  protected def theClass: Class[_]
  private val logger = Logger[FunctionHubExecutor]

  def callFunction(name: String, args: String*): List[String] = {
    logger.debug(s"Executing function $name in source code ${functionsCode.filepath}")
    val instance = theClass.getConstructors()(0).newInstance().asInstanceOf[AnyRef]
    val method = theClass.getMethods.toList.filter(_.getName.matches(".*" + name + ".*"))
      .sortWith((a, b) => {
        name.levenshteinDist(a.getName) < name.levenshteinDist(b.getName)
        //Levenshtein.distance(name, a.getName)(LevenshteinDistance) < Levenshtein.distance(name, b.getName)
      })
      .headOption.getOrElse(
        throw RDFGenerationError(s"Function $name was not found in source code ${functionsCode.filepath}", parserInfo)
      )
    val parameterTypes = method.getParameterTypes.toSeq
    val finalArgs = for((arg, theType) <- args zip parameterTypes) yield {
      val typeName =
        if(theType.isPrimitive) theType.getTypeName.capitalize else theType.getTypeName
      val typeClass = convertPrimitiveToClass(typeName)
      if(typeClass != classOf[String]) {
        val valueOfMethod = typeClass.getDeclaredMethods.filter(m => m.getName.matches(".*valueOf.*") &&
          m.getParameterTypes.contains(classOf[String]) && m.getParameterCount == 1).head
        valueOfMethod.invoke(null, arg)
      } else arg.asInstanceOf[AnyRef]
    }
    val result = method.invoke(instance, finalArgs: _*)
    result match {
      case a: Array[_] => a.toList.map(_.toString)
      case l: List[_] => l.map(_.toString)
      case c: java.util.Collection[_] => c.toArray.toList.map(_.toString)
      case default => List(default.toString)
    }
  }

  private def convertPrimitiveToClass(typeName: String): Class[_] = {
    if(typeName == "Int" || typeName == "Integer") classOf[Integer]
    else if(typeName == "Boolean") classOf[Boolean]
    else if(typeName == "Char") classOf[Char]
    else if(typeName == "Double") classOf[Double]
    else if(typeName == "Float") classOf[Float]
    else if(typeName == "Long") classOf[Long]
    else if(typeName == "Short") classOf[Short]
    else if(typeName == "Byte") classOf[Byte]
    else if(typeName == "java.lang.String") classOf[String]
    else throw FunctionExecutionError(typeName + "is not a supported type")
  }

}

case class ScalaFunctionHubExecutor(functionsCode: LoadedSource, parserInfo: ParserInfo) extends FunctionHubExecutor {

  private val toolBox = ToolBoxSingleton.toolBox
  private val tree = toolBox.parse(functionsCode.fileContent)
  private val symbol = toolBox.define(tree.asInstanceOf[toolBox.u.ImplDef])

  protected val theClass: Class[_] = toolBox.synchronized {
    toolBox.eval(toolBox.parse(functionsCode.fileContent + s"\nscala.reflect.classTag[${symbol.name}].runtimeClass")).asInstanceOf[Class[_]]
  }
}

object ToolBoxSingleton {
  private lazy val cm = universe.runtimeMirror(getClass.getClassLoader)
  lazy val toolBox: ToolBox[universe.type] = cm.mkToolBox()
}

case class JavaFunctionHubExecutor(functionsCode: LoadedSource, parserInfo: ParserInfo) extends FunctionHubExecutor {

  protected val theClass: Class[_] = {
    val matches = Pattern.compile("(public)\\s*(class)\\s*([a-zA-Z0-9]+)([\\s\\w])*[{]").matcher(functionsCode.fileContent)
    val className =
      if(matches.find()) matches.group(3)
      else throw FunctionExecutionError(s"Impossible to find main class in ${functionsCode.filepath}", parserInfo)

    val tempDir = Files.createTempDirectory("java").toFile
    val sourceFile = new File(tempDir, s"$className.java")
    sourceFile.getParentFile.mkdirs()
    Files.write(sourceFile.toPath, functionsCode.fileContent.getBytes(StandardCharsets.UTF_8))
    tempDir.deleteOnExit()

    val compiler = ToolProvider.getSystemJavaCompiler
    val classpath = System.getProperty("java.class.path")
    val errors = new ByteArrayOutputStream()
    val result = compiler.run(null, null, errors, "-classpath", classpath, sourceFile.getPath)
    Option(tempDir.listFiles()).map(_.toList).getOrElse(List.empty).foreach(_.deleteOnExit())
    if(result != 0)
      throw FunctionExecutionError(s"The Java source code ${functionsCode.filepath} could not be compiled:\n" +
        new String(errors.toByteArray, StandardCharsets.UTF_8), parserInfo)

    val classLoader = URLClassLoader.newInstance(Array[URL](tempDir.toURI.toURL))
    Class.forName(className, true, classLoader)
  }

}