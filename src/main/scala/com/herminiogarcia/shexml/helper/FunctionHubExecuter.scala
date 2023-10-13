package com.herminiogarcia.shexml.helper

import com.github.vickumar1981.stringdistance
import com.github.vickumar1981.stringdistance.StringDistance.Levenshtein
import com.github.vickumar1981.stringdistance.implicits._
import com.github.vickumar1981.stringdistance.StringConverter._
import com.typesafe.scalalogging.Logger

import scala.tools.reflect.ToolBox
import scala.reflect.runtime._
import scala.reflect.runtime
import scala.reflect.runtime.universe._

class FunctionHubExecuter(val pathToFile: String) {

  private val logger = Logger[FunctionHubExecuter]

  def callFunction(name: String, args: String*): List[String] = {
    logger.debug(s"Executing function $name in source code $pathToFile")
    val functionsCode = new SourceHelper().getURLContent(pathToFile).fileContent
    val cm = universe.runtimeMirror(getClass.getClassLoader)
    val toolBox = cm.mkToolBox()
    val tree = toolBox.parse(functionsCode)
    val symbol = toolBox.define(tree.asInstanceOf[toolBox.u.ImplDef])
    val theClass = toolBox.eval(toolBox.parse(functionsCode + s"\nscala.reflect.classTag[${symbol.name}].runtimeClass")).asInstanceOf[Class[_]]
    val instance = theClass.getConstructors()(0).newInstance().asInstanceOf[AnyRef]
    val method = theClass.getMethods.toList.filter(_.getName.matches(".*" + name + ".*"))
      .sortWith((a, b) => {
        name.levenshteinDist(a.getName) < name.levenshteinDist(b.getName)
        //Levenshtein.distance(name, a.getName)(LevenshteinDistance) < Levenshtein.distance(name, b.getName)
      })
      .head
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
    else throw new Exception(typeName + "is not a supported type")
  }

}