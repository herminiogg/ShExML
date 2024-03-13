package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast._

/**
  * Created by herminio on 22/12/17.
  */
abstract class DefaultUnitVisitor {

  def visit(ast: AST): Unit = ast match {

    case ShExML(declarations, graphs, shapes) => {
      declarations.foreach(doVisit)
      graphs.foreach(doVisit)
      shapes.foreach(doVisit)
    }

    case Declaration(declarationStatement) => doVisit(declarationStatement)

    case Graph(_, shapes) => shapes.foreach(doVisit)

    case Shape(shapeName, action, predicateObjects, _) => {
      doVisit(shapeName)
      doVisit(action)
      predicateObjects.foreach(doVisit)
    }

    case Query(_, queryClause) => doVisit(queryClause)

    case Expression(_, exp) => doVisit(exp)

    case Union(left, right) => {
      doVisit(left)
      doVisit(right)
    }

    case Substitution(leftUnion, rightUnion, joinClause) => {
      doVisit(leftUnion)
      doVisit(rightUnion)
      doVisit(joinClause)
    }

    case Join(leftUnion, rightUnion, leftJoinClause, rightJoinClause) => {
      doVisit(leftUnion)
      doVisit(rightUnion)
      doVisit(leftJoinClause)
      doVisit(rightJoinClause)
    }

    case StringOperation(left, right, _) => {
      doVisit(left)
      doVisit(right)
    }

    case PredicateObject(objectOrShapeLink, predicate) => {
      doVisit(objectOrShapeLink)
      doVisit(predicate)
    }

    case ObjectElement(_, action, _, _, _, _, _, _) => action match { case Some(value) => doVisit(value) }

    case _ => // do nothing
  }

  def doVisit(ast: AST): Unit

}
