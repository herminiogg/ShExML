package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast._

/**
  * Created by herminio on 22/12/17.
  */
abstract class DefaultVisitor[A, B] {

  def visit(ast: AST, optionalArgument: A): B = ast match {

    case ShExML(declarations, graphs, shapes) => {
      declarations.foreach(doVisit(_, optionalArgument))
      val firstGraph = graphs.map(doVisit(_, optionalArgument)).headOption
      val firstShape = shapes.map(doVisit(_, optionalArgument)).headOption
      if(firstGraph.isEmpty) firstShape.get else firstGraph.get
    }

    case Declaration(declarationStatement) => doVisit(declarationStatement, optionalArgument)

    case Shape(shapeName, action, predicateObjects, _) => {
      doVisit(shapeName, optionalArgument)
      predicateObjects.foreach(doVisit(_, optionalArgument))
      doVisit(action, optionalArgument)
    }

    case Query(_, queryClause) => doVisit(queryClause, optionalArgument)

    case Expression(_, exp) => doVisit(exp, optionalArgument)

    case Union(left, right) => {
      doVisit(left, optionalArgument)
      doVisit(right, optionalArgument)
    }

    case Substitution(leftUnion, rightUnion, joinClause) => {
      doVisit(leftUnion, optionalArgument)
      doVisit(rightUnion, optionalArgument)
      doVisit(joinClause, optionalArgument)
    }

    case Join(leftUnion, rightUnion, leftJoinClause, rightJoinClause) => {
      doVisit(leftUnion, optionalArgument)
      doVisit(rightUnion, optionalArgument)
      doVisit(leftJoinClause, optionalArgument)
      doVisit(rightJoinClause, optionalArgument)
    }

    case StringOperation(left, right, _) => {
      doVisit(left, optionalArgument)
      doVisit(right, optionalArgument)
    }

    case PredicateObject(objectOrShapeLink, predicate) => {
      doVisit(objectOrShapeLink, optionalArgument)
      doVisit(predicate, optionalArgument)
    }

    case ObjectElement(_, action, _, _, _, _, _, _) => action match { case Some(value) => doVisit(value, optionalArgument) }

    case _ => doVisitDefault()

    //case _ => optionalArgument // do nothing

  }

  def doVisit(ast: AST, optionalArgument: A): B

  def doVisitDefault(): B

}
