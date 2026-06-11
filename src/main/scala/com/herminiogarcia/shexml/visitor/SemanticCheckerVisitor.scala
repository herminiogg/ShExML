package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast._
import com.herminiogarcia.shexml.helper.SemanticCheckerError

class SemanticCheckerVisitor(varTable: Map[Variable, VarResult]) extends DefaultVisitor[Any, Unit] {

  override def doVisit(ast: AST, optionalArgument: Any): Unit = ast match {

    case i: IteratorQuery => {
      checkVar(i.firstVar, i.parserInfo) //file var or existing expression
      varTable(i.firstVar) match {
        case e: Exp => doVisit(e, optionalArgument)
        case _ =>
          val fullName = iteratorQueryToList(i.composedVar).map(_.name).mkString(".")
          varTable.getOrElse(Var(fullName), throw SemanticCheckerError(s"Variable $fullName is not defined", i.parserInfo))
      }
    }

    case LiteralObject(prefix, _, parserInfo) => checkVar(prefix, parserInfo)

    case PredicateObject(predicate, objectOrShapeLink, _) => {
      doVisit(predicate, optionalArgument)
      doVisit(objectOrShapeLink, optionalArgument)
    }

    case Predicate(prefix, _, parserInfo) => checkPrefix(prefix, parserInfo)

    case FunctionCalling(functionHub, _, arguments, parserInfo) => {
      checkVar(functionHub, parserInfo)
      doVisit(arguments, optionalArgument)
    }

    case Arguments(arguments, _) => arguments.foreach(checkExpOrVar(_, optionalArgument))

    case Action(shapePrefix, action, condition, parserInfo) => {
      if(shapePrefix != "_:") checkPrefix(shapePrefix, parserInfo)
      doVisit(action, optionalArgument)
      condition.foreach(doVisit(_, optionalArgument))
    }

    case ObjectElement(prefix, action, _, matcher, filter, dataType, langTag, _, parserInfo) => {
      if(prefix.nonEmpty) checkPrefix(prefix, parserInfo)
      action.foreach(checkExpOrVar(_, optionalArgument))
      matcher.foreach(checkVar(_, parserInfo))
      filter.foreach(checkExpOrVar(_, optionalArgument))
      dataType.foreach(doVisit(_, optionalArgument))
      langTag.foreach(doVisit(_, optionalArgument))
    }

    case ShapeLink(shape, parserInfo) => checkVar(shape, parserInfo)

    case DataTypeGeneration(prefix, action, matcher, parserInfo) => {
      if(prefix.nonEmpty) checkPrefix(prefix, parserInfo)
      checkExpOrVar(action, optionalArgument)
      matcher.foreach(checkVar(_, parserInfo))
    }

    case LangTagGeneration(action, matcher, parserInfo) => {
      checkExpOrVar(action, optionalArgument)
      matcher.foreach(checkVar(_, parserInfo))
    }

    case default => super.visit(default, optionalArgument)
  }

  private def checkVar(variable: Variable, parserInfo: ParserInfo): Unit = {
    varTable.getOrElse(variable, throw SemanticCheckerError(s"Variable ${nameOf(variable)} is not defined", parserInfo))
  }

  private def checkPrefix(prefix: String, parserInfo: ParserInfo): Unit = {
    varTable.getOrElse(Var(prefix), throw SemanticCheckerError(s"Prefix $prefix is not defined", parserInfo))
  }

  private def checkExpOrVar(exp: ExpOrVar, optionalArgument: Any): Unit = exp match {
    case v: Var => checkVar(v, v.parserInfo)
    case default => doVisit(default, optionalArgument)
  }

  private def nameOf(variable: Variable): String = variable match {
    case v: Var => v.name
    case sv: ShapeVar => sv.name
    case gv: GraphVar => gv.prefix + gv.name
  }

  private def iteratorQueryToList(varOrIteratorQuery: VarOrIteratorQuery): List[Var] = varOrIteratorQuery match {
    case v: Var => List(v)
    case c: IteratorQuery => List(c.firstVar) ::: iteratorQueryToList(c.composedVar)
  }

  override def doVisitDefault(): Unit = ()

}
