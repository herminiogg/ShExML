package es.weso.shexml.visitor

import es.weso.shexml.ast.{AST, Declaration, Expression, Graph, Join, ObjectElement, PredicateObject, Query, ShExML, Shape, StringOperation, Union}

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

    case Shape(shapeName, _, action, predicateObjects, _) => {
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

    case Join(leftUnion, rightUnion, joinClause) => {
      doVisit(leftUnion)
      doVisit(rightUnion)
      doVisit(joinClause)
    }

    case StringOperation(left, right, _) => {
      doVisit(left)
      doVisit(right)
    }

    case PredicateObject(objectOrShapeLink, predicate) => {
      doVisit(objectOrShapeLink)
      doVisit(predicate)
    }

    case ObjectElement(_, action, _, _, _, _) => action match { case Some(value) => doVisit(value) }

    case _ => // do nothing
  }

  def doVisit(ast: AST): Unit

}
