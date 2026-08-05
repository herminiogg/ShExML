package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast._

/**
  * Created by herminio on 22/12/17.
  */
abstract class DefaultUnitVisitor {

  def visit(ast: AST): Unit = ast match {

    case ShExML(declarations, graphs, shapes, _) => {
      declarations.foreach(doVisit)
      graphs.foreach(doVisit)
      shapes.foreach(doVisit)
    }

    case Declaration(declarationStatement, _) => doVisit(declarationStatement)

    case Graph(_, shapes, _) => shapes.foreach(doVisit)

    case Shape(shapeName, action, predicateObjects, _, _) => {
      doVisit(shapeName)
      doVisit(action)
      predicateObjects.foreach(doVisit)
    }

    case Query(_, queryClause, _) => doVisit(queryClause)

    case Expression(_, exp, _) => doVisit(exp)

    case Union(left, right, _) => {
      doVisit(left)
      doVisit(right)
    }

    case Substitution(leftUnion, rightUnion, joinClause, _) => {
      doVisit(leftUnion)
      doVisit(rightUnion)
      doVisit(joinClause)
    }

    case Join(leftUnion, rightUnion, leftJoinClause, rightJoinClause, _) => {
      doVisit(leftUnion)
      doVisit(rightUnion)
      doVisit(leftJoinClause)
      doVisit(rightJoinClause)
    }

    case StringOperation(left, right, _, _) => {
      doVisit(left)
      doVisit(right)
    }

    case PredicateObject(objectOrShapeLink, predicate, _) => {
      doVisit(objectOrShapeLink)
      doVisit(predicate)
    }

    case ObjectElement(_, action, _, _, _, _, _, _, _) => action match { case Some(value) => doVisit(value) }

    case _ => // do nothing
  }

  def doVisit(ast: AST): Unit

}
