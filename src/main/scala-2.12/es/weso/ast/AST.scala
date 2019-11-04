package es.weso.ast


/**
  * Created by herminio on 20/12/17.
  */
sealed trait AST

case class ShExML(declaration: List[Declaration], shape: List[Shape]) extends AST
case class Declaration(declarationStatement: DeclarationStatement) extends AST
case class Shape(shapeName: ShapeVar, shapePrefix: String, action: ExpOrVar, predicateObjects: List[PredicateObject]) extends VarResult


sealed trait DeclarationStatement extends AST

case class Prefix(name: Var, url: URL) extends DeclarationStatement
case class Source(name: Var, filePath: URL) extends DeclarationStatement
case class Query(name: Var, queryClause: QueryClause) extends DeclarationStatement
case class Iterator(name: Var, queryClause: QueryClause, fields: List[Field], iterators: List[NestedIterator]) extends Iterators with DeclarationStatement with VarResult
case class NestedIterator(name: Var, queryClause: QueryClause, fields: List[Field], iterators: List[NestedIterator]) extends Iterators with DeclarationStatement with VarResult
case class Field(name: Var, queryClause: QueryClause) extends AST
case class Expression(name: Var, exp: Exp) extends DeclarationStatement
case class Matcher(replacedStrings: ReplacedStrings, replacement: String) extends AST
case class Matchers(name: Var, matchers: MatcherList) extends DeclarationStatement with VarResult
case class AutoIncrement(name: Var, from: Int, to: Int, by: Int) extends Iterable[Int] with DeclarationStatement with VarResult {
  override val iterator: scala.Iterator[Int] = scala.Iterator.range(from, to, by)
}


sealed trait QueryClause extends VarResult {
  val query: String
}

case class JsonPath(query: String) extends QueryClause
case class XmlPath(query: String) extends QueryClause
case class CSVPerRow(query: String) extends QueryClause
case class FieldQuery(query: String) extends QueryClause


sealed trait Exp extends ExpOrVar with VarResult
sealed trait LeftUnion extends Exp
sealed trait RightUnion extends Exp

case class Union(left: LeftUnion, right: RightUnion) extends RightUnion
case class StringOperation(left: IteratorQuery, right: IteratorQuery, unionString: String) extends LeftUnion with RightUnion
case class Join(leftUnion: IteratorQuery, rightUnion: IteratorQuery, joinClause: IteratorQuery) extends Exp
case class IteratorQuery(firstVar: Var, composedVar: VarOrIteratorQuery) extends LeftUnion with RightUnion with VarOrIteratorQuery

sealed trait VarOrIteratorQuery extends AST
sealed trait ExpOrVar extends AST

sealed trait Variable extends ExpOrVar
case class Var(name: String) extends Variable with VarOrIteratorQuery
case class ShapeVar(name: String) extends Variable

case class LiteralObject(prefix: Var, value: String) extends ObjectOrShapeLink

case class PredicateObject(predicate: Predicate, objectOrShapeLink: ObjectOrShapeLink) extends AST
case class Predicate(prefix: String, extension: String) extends AST


sealed trait ObjectOrShapeLink extends AST

case class ObjectElement(prefix: String, action: ExpOrVar, matcher: Option[Var],
                         dataType: Option[String], langTag: Option[String]) extends ObjectOrShapeLink
case class ShapeLink(shape: ShapeVar) extends ObjectOrShapeLink

sealed trait VarResult extends AST
sealed trait Iterators extends AST {
  def name: Var
  def queryClause: QueryClause
  def fields: List[Field]
  def iterators: List[NestedIterator]
}

case class URL(url: String) extends VarResult
case class ReplacedStrings(strings: List[String]) extends AST
case class ComposedVariable(variables: List[Var]) extends AST
case class MatcherList(matchers: List[Matcher]) extends AST