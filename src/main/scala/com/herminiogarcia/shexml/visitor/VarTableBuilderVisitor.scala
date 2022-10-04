package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast._

import scala.collection.mutable

/**
  * Created by herminio on 26/12/17.
  */
class VarTableBuilderVisitor(val variableMap: mutable.HashMap[Variable, VarResult]) extends DefaultVisitor[Map[String, Any], Unit] {

  override def doVisit(ast: AST, optionalArgument: Map[String, Any]): Unit = ast match {
    case Prefix(name, value) => variableMap += ((name, value))
    case Source(name, value) => variableMap += ((name, value))
    case Query(name, value) => variableMap += ((name, value))
    case Functions(name, value) => variableMap += ((name, value))
    case Expression(name, value) => variableMap += ((name, value))
    case Iterator(name, value, fields, iterators) => registerIterator(name, value, fields, iterators, optionalArgument)
    case NestedIterator(name, value, fields, iterators) => registerIterator(name, value, fields, iterators, optionalArgument)
    case Field(name, value, _, _) => {
      val fieldName = if(optionalArgument("variable") == "") name.name else optionalArgument("variable").toString + "." + name.name
      variableMap += ((Var(fieldName), value))
    }
    case m: Matchers => variableMap += ((m.name, m))
    case a: AutoIncrement => variableMap += ((a.name, a))
    case s: Shape => variableMap += ((s.shapeName, s))
    case g: Graph => {
      g.shapes.foreach(doVisit(_, optionalArgument))
      variableMap += ((g.graphName, g))
    }
    case default => super.visit(default, optionalArgument)
  }

  def registerIterator(name: Var, value: QueryOrVar, fields: List[Field], iterators: List[NestedIterator], optionalArgument: Map[String, Any]) = {
    val iteratorName = if(optionalArgument("variable") == "") name.name else optionalArgument("variable").toString + "." + name.name
    val finalValue = value match {
      case FieldQuery(query, pushed, popped) => optionalArgument("type") match {
        case XmlPath(_) => XmlPath(query)
        case JsonPath(_) => JsonPath(query)
      }
      case _ => value
    }
    variableMap += ((Var(iteratorName), finalValue))
    val topIteratorType = value match {
      case FieldQuery(_, _, _) => optionalArgument("type").asInstanceOf[QueryClause]
      case x: XmlPath => x
      case j: JsonPath => j
      case c: CSVPerRow => c
      case s: Sql => s
      case v: Var => getQueryFromVarTable(v)
    }
    val newOptionalArgument = Map(
      "variable" -> iteratorName,
      "type" -> topIteratorType
    )
    fields.foreach(doVisit(_, newOptionalArgument))
    iterators.foreach(doVisit(_, newOptionalArgument))
  }

  private def getQueryFromVarTable(variable: Var): QueryClause = {
    new QuerySearcher(variableMap).getQueryFromVarTable(variable)
  }

  override def doVisitDefault(): Unit = ???

}
