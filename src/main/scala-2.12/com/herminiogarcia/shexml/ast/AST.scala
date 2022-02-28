package com.herminiogarcia.shexml.ast

/**
  * Created by herminio on 20/12/17.
  */
sealed trait AST

case class ShExML(declaration: List[Declaration], graph: List[Graph], shape: List[Shape]) extends AST
case class Declaration(declarationStatement: DeclarationStatement) extends AST
case class Graph(graphName: GraphVar, shapes: List[Shape]) extends VarResult
case class Shape(shapeName: ShapeVar, action: ActionOrLiteral, predicateObjects: List[PredicateObject], holdingGraph: Option[Graph]) extends VarResult

sealed trait ActionOrLiteral extends AST
case class Action(shapePrefix: String, action: ExpOrVar) extends ActionOrLiteral
case class LiteralSubject(prefix: Var, value: String) extends ActionOrLiteral

sealed trait DeclarationStatement extends AST

case class Prefix(name: Var, url: URL) extends DeclarationStatement
case class Source(name: Var, path: IRI) extends DeclarationStatement
case class Query(name: Var, query: QueryOrURL) extends DeclarationStatement
case class Iterator(name: Var, queryClause: QueryOrVar, fields: List[Field], iterators: List[NestedIterator]) extends Iterators with DeclarationStatement with VarResult
case class NestedIterator(name: Var, queryClause: QueryClause, fields: List[Field], iterators: List[NestedIterator]) extends Iterators with DeclarationStatement with VarResult
case class Field(name: Var, queryClause: QueryClause, pushed: Boolean, popped: Boolean) extends AST
case class Expression(name: Var, exp: Exp) extends DeclarationStatement
case class Matcher(replacedStrings: ReplacedStrings, replacement: String) extends AST
case class Matchers(name: Var, matchers: MatcherList) extends DeclarationStatement with VarResult
case class AutoIncrement(name: Var, from: Int, to: Int, by: Int, precedentString: Option[String], closingString: Option[String]) extends Iterable[Int] with DeclarationStatement with VarResult {
  override val iterator: scala.Iterator[Int] = scala.Iterator.range(from, to, by)
}

sealed trait QueryClause extends QueryOrURL with QueryOrVar {
  val query: String
  val pushed: Boolean = false
  val popped: Boolean = false
}

case class JsonPath(query: String) extends QueryClause
case class XmlPath(query: String) extends QueryClause
case class CSVPerRow(query: String) extends QueryClause
sealed trait Sql extends QueryClause
case class SqlQuery(query: String) extends Sql
case class SqlColumn(query: String, column: String) extends Sql
sealed trait Sparql extends QueryClause
case class SparqlQuery(query: String) extends Sparql
case class SparqlColumn(query: String, column: String) extends Sparql
case class FieldQuery(query: String, override val pushed: Boolean = false, override val popped: Boolean = false) extends QueryClause

sealed trait Exp extends ExpOrVar with VarResult
sealed trait LeftUnion extends Exp
sealed trait RightUnion extends Exp

case class Union(left: LeftUnion, right: RightUnion) extends RightUnion
case class StringOperation(left: IteratorQuery, right: IteratorQuery, unionString: String) extends LeftUnion with RightUnion
case class Join(leftUnion: IteratorQuery, rightUnion: IteratorQuery, joinClause: IteratorQuery) extends Exp
case class IteratorQuery(firstVar: Var, composedVar: VarOrIteratorQuery) extends LeftUnion with RightUnion with VarOrIteratorQuery

sealed trait VarOrIteratorQuery extends AST
sealed trait ExpOrVar extends AST
sealed trait QueryOrURL extends VarResult
sealed trait QueryOrVar extends VarResult

sealed trait Variable extends ExpOrVar
case class Var(name: String) extends Variable with VarOrIteratorQuery with QueryOrVar
case class ShapeVar(name: String) extends Variable
case class GraphVar(prefix: String, name: String) extends Variable

case class LiteralObject(prefix: Var, value: String) extends ObjectOrShapeLink
case class LiteralObjectValue(value: String) extends ObjectOrShapeLink

case class PredicateObject(predicate: Predicate, objectOrShapeLink: ObjectOrShapeLink) extends AST
case class Predicate(prefix: String, extension: String) extends AST


sealed trait ObjectOrShapeLink extends AST

case class ObjectElement(prefix: String, action: Option[ExpOrVar], literalValue: Option[LiteralObjectValue], matcher: Option[Var],
                         dataType: Option[DataType], langTag: Option[LangTag], rdfCollection: Option[RDFCollection]) extends ObjectOrShapeLink
case class ShapeLink(shape: ShapeVar) extends ObjectOrShapeLink

sealed trait DataType extends AST
case class DataTypeGeneration(prefix: String, action: ExpOrVar, matcher: Option[Var]) extends DataType
case class DataTypeLiteral(value: String) extends DataType

sealed trait LangTag extends AST
case class LangTagGeneration(action: ExpOrVar, matcher: Option[Var]) extends LangTag
case class LangTagLiteral(value: String) extends LangTag

sealed trait VarResult extends AST
sealed trait Iterators extends AST {
  def name: Var
  def queryClause: QueryOrVar
  def fields: List[Field]
  def iterators: List[NestedIterator]
}

sealed trait IRI extends VarResult
case class URL(url: String) extends IRI with QueryOrURL
case class JdbcURL(url: String) extends IRI
case class RelativePath(path: String) extends IRI
case class ReplacedStrings(strings: List[String]) extends AST
case class ComposedVariable(variables: List[Var]) extends AST
case class MatcherList(matchers: List[Matcher]) extends AST

sealed trait RDFCollection extends AST
case class RDFList() extends RDFCollection
case class RDFBag() extends RDFCollection
case class RDFAlt() extends RDFCollection
case class RDFSeq() extends RDFCollection