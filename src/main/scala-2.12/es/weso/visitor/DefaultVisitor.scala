package es.weso.visitor

import es.weso.ast._

/**
  * Created by herminio on 22/12/17.
  */
abstract class DefaultVisitor[T] {

  def visit(ast: AST, optionalArgument: T): T = ast match {

    case ShExML(declarations, shapes) => {
      declarations.foreach(doVisit(_, optionalArgument))
      shapes.map(doVisit(_, optionalArgument)).head
    }

    case Declaration(declarationStatement) => doVisit(declarationStatement, optionalArgument)

    case Shape(shapeName, _, action, predicateObjects) => {
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

    case ObjectElement(_, action) => doVisit(action, optionalArgument)

    case _ => optionalArgument // do nothing

  }

  def doVisit(ast: AST, optionalArgument: T): T

}
