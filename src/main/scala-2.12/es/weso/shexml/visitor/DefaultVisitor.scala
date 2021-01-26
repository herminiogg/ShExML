package es.weso.shexml.visitor

import es.weso.shexml.ast.{AST, Declaration, Expression, Join, ObjectElement, PredicateObject, Query, ShExML, Shape, StringOperation, Union}

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

    case Shape(shapeName, _, action, predicateObjects, _) => {
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

    case Join(leftUnion, rightUnion, joinClause) => {
      doVisit(leftUnion, optionalArgument)
      doVisit(rightUnion, optionalArgument)
      doVisit(joinClause, optionalArgument)
    }

    case StringOperation(left, right, _) => {
      doVisit(left, optionalArgument)
      doVisit(right, optionalArgument)
    }

    case PredicateObject(objectOrShapeLink, predicate) => {
      doVisit(objectOrShapeLink, optionalArgument)
      doVisit(predicate, optionalArgument)
    }

    case ObjectElement(_, action, _, _, _, _, _) => action match { case Some(value) => doVisit(value, optionalArgument) }

    case _ => doVisitDefault()

    //case _ => optionalArgument // do nothing

  }

  def doVisit(ast: AST, optionalArgument: A): B

  def doVisitDefault(): B

}
