package com.herminiogarcia.shexml.shex

import com.herminiogarcia.shexml.ast.URL

sealed trait ShExSubsetAST

case class ShEx(prefixes: List[Prefix], shapes: List[Shape], graphs: List[Graph]) extends ShExSubsetAST
case class Prefix(name: String, url: URL) extends ShExSubsetAST
case class Shape(name: String, partialFixedValue: PartialFixedValue, predicateObjets: List[PredicateObject]) extends ShExSubsetAST
case class Graph(name: String, shapes: List[Shape]) extends ShExSubsetAST
case class PredicateObject(predicate: Predicate, objectElement: ObjectElement) extends ShExSubsetAST
case class Predicate(prefix: String, localname: String) extends ShExSubsetAST

sealed trait ObjectElement extends ShExSubsetAST
case class ShapeLink(linkedShape: String) extends ObjectElement
case class ObjectDefinition(datatype: String, cardinality: Cardinality = NumberCardinality(1, 1)) extends ObjectElement
case class FixedValue(value: String) extends ObjectElement
case class PartialFixedValue(start: String, cardinality: Cardinality = NumberCardinality(1, 1)) extends ObjectElement

sealed trait Cardinality extends ShExSubsetAST
case class OptionalCardinality() extends Cardinality
case class ZeroOrMoreCardinality() extends Cardinality
case class OneOrMoreCardinality() extends Cardinality
case class NumberCardinality(from: Int, to: Int) extends Cardinality
