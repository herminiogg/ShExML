package es.weso.visitor

import es.weso.ast._

import scala.collection.mutable

/**
  * Created by herminio on 26/12/17.
  */
class VarTableBuilderVisitor(val variableMap: mutable.HashMap[Variable, VarResult]) extends DefaultVisitor[Map[String, String], Unit] {

  override def doVisit(ast: AST, optionalArgument: Map[String, String]): Unit = ast match {
    case Prefix(name, value) => variableMap += ((name, value))
    case Source(name, value) => variableMap += ((name, value))
    case Query(name, value) => variableMap += ((name, value))
    case Expression(name, value) => variableMap += ((name, value))
    case Iterator(name, value, fields, iterators) => {
      val iteratorName = if(optionalArgument("variable") == "") name.name else optionalArgument("variable") + "." + name.name
      variableMap += ((Var(iteratorName), value))
      val newOptionalArgument = Map(
        "variable" -> iteratorName
      )
      fields.foreach(doVisit(_, newOptionalArgument))
      iterators.foreach(doVisit(_, newOptionalArgument))
    }
    case Field(name, value) => {
      val fieldName = if(optionalArgument("variable") == "") name.name else optionalArgument("variable") + "." + name.name
      variableMap += ((Var(fieldName), value))
    }
    case m: Matcher => variableMap += ((m.name, m))
    case s: Shape => variableMap += ((s.shapeName, s))
    case default => super.visit(default, optionalArgument)
  }

  override def doVisitDefault(): Unit = ???

}
