package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast.{AST, Field, Iterator, NestedIterator, ShExML}

class PushedOrPoppedValueSearchVisitor extends DefaultVisitor[Any, Boolean] {

  override def doVisit(ast: AST, optionalArgument: Any): Boolean = ast match {

    case ShExML(declarations, graphs, shapes, _) => {
      declarations.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
    }

    case Iterator(_, _, fields, iterators, _) => {
      val resultInFields = fields.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
      val resultsInIterators = iterators.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
      resultInFields || resultsInIterators
    }

    case NestedIterator(_, _, fields, iterators, _) => {
      val resultInFields = fields.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
      val resultsInIterators = iterators.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
      resultInFields || resultsInIterators
    }

    case Field(_, _, pushed, popped, _) => pushed || popped

    case default => visit(default, optionalArgument)
  }

  override def doVisitDefault(): Boolean = false

}
