package es.weso.visitor

import es.weso.ast._

import scala.collection.mutable

/**
  * Created by herminio on 26/12/17.
  */
class VarTableBuilderVisitor(val variableMap: mutable.HashMap[Variable, VarResult]) extends DefaultUnitVisitor {

  override def doVisit(ast: AST): Unit = ast match {
    case Prefix(name, value) => variableMap += ((name, value))
    case Source(name, value) => variableMap += ((name, value))
    case Query(name, value) => variableMap += ((name, value))
    case Expression(name, value) => variableMap += ((name, value))
    case Iterator(name, value, fields) => {
      variableMap += ((name, value))
      fields.foreach(f => variableMap += ((Var(name.name + "." + f.name.name), f.queryClause)))
    }
    case m: Matcher => variableMap += ((m.name, m))
    case s: Shape => variableMap += ((s.shapeName, s))
    case default => super.visit(default)
  }

}
