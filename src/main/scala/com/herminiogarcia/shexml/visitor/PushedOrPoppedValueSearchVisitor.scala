package com.herminiogarcia.shexml.visitor

import com.herminiogarcia.shexml.ast.{AST, Field, Iterator, NestedIterator, ShExML}

class PushedOrPoppedValueSearchVisitor extends DefaultVisitor[Any, Boolean] {

  override def doVisit(ast: AST, optionalArgument: Any): Boolean = ast match {

    case ShExML(declarations, graphs, shapes) => {
      declarations.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
    }

    case Iterator(_, _, fields, iterators) => {
      val resultInFields = fields.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
      val resultsInIterators = iterators.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
      resultInFields || resultsInIterators
    }

    case NestedIterator(_, _, fields, iterators) => {
      val resultInFields = fields.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
      val resultsInIterators = iterators.map(doVisit(_, optionalArgument)).find(_.self).getOrElse(false)
      resultInFields || resultsInIterators
    }

    case Field(_, _, pushed, popped) => pushed || popped

    case default => visit(default, optionalArgument)
  }

  override def doVisitDefault(): Boolean = false

}
