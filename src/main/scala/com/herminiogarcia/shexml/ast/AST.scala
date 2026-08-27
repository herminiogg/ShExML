package com.herminiogarcia.shexml.ast

/**
  * Created by herminio on 20/12/17.
  */
sealed trait AST {
  val parserInfo: ParserInfo
}

case class ShExML(declaration: List[Declaration], graph: List[Graph], shape: List[Shape], parserInfo: ParserInfo) extends AST
case class Declaration(declarationStatement: DeclarationStatement, parserInfo: ParserInfo) extends AST
case class Graph(graphName: GraphVar, shapes: List[Shape], parserInfo: ParserInfo) extends VarResult
case class Shape(shapeName: ShapeVar, action: ActionOrLiteral, predicateObjects: List[PredicateObject], holdingGraph: Option[Graph], parserInfo: ParserInfo) extends VarResult

sealed trait ActionOrLiteral extends AST
case class Action(shapePrefix: Var, action: ExpOrVar, condition: Option[ExpOrVar], parserInfo: ParserInfo) extends ActionOrLiteral
case class LiteralSubject(prefix: Var, value: String, parserInfo: ParserInfo) extends ActionOrLiteral

sealed trait DeclarationStatement extends AST

case class Prefix(name: Var, url: URL, parserInfo: ParserInfo) extends DeclarationStatement
case class Source(name: Var, path: FilePathOrStdin, parserInfo: ParserInfo) extends DeclarationStatement
case class Query(name: Var, query: QueryOrURL, parserInfo: ParserInfo) extends DeclarationStatement
case class Functions(name: Var, query: FilePath, parserInfo: ParserInfo) extends DeclarationStatement
case class Iterator(name: Var, queryClause: QueryOrVar, fields: List[Field], iterators: List[NestedIterator], parserInfo: ParserInfo) extends Iterators with DeclarationStatement with VarResult
case class NestedIterator(name: Var, queryClause: QueryClause, fields: List[Field], iterators: List[NestedIterator], parserInfo: ParserInfo) extends Iterators with DeclarationStatement with VarResult
case class Field(name: Var, queryClause: QueryClause, pushed: Boolean, popped: Boolean, parserInfo: ParserInfo) extends AST
case class Expression(name: Var, exp: Exp, parserInfo: ParserInfo) extends DeclarationStatement
case class Matcher(replacedStrings: ReplacedStrings, replacement: String, parserInfo: ParserInfo) extends AST
case class Matchers(name: Var, matchers: MatcherList, parserInfo: ParserInfo) extends DeclarationStatement with VarResult
case class AutoIncrement(name: Var, from: Int, to: Int, by: Int, precedentString: Option[String], closingString: Option[String], parserInfo: ParserInfo) extends Iterable[Int] with DeclarationStatement with VarResult {
  override val iterator: scala.Iterator[Int] = scala.Iterator.range(from, to, by)
}

sealed trait QueryClause extends QueryOrURL with QueryOrVar {
  val query: String
  val pushed: Boolean = false
  val popped: Boolean = false
}

case class JsonPath(query: String, parserInfo: ParserInfo) extends QueryClause
case class XmlPath(query: String, parserInfo: ParserInfo) extends QueryClause
case class CSVPerRow(query: String, parserInfo: ParserInfo) extends QueryClause
sealed trait Sql extends QueryClause
case class SqlQuery(query: String, parserInfo: ParserInfo) extends Sql
case class SqlColumn(query: String, column: String, parserInfo: ParserInfo) extends Sql
sealed trait Sparql extends QueryClause
case class SparqlQuery(query: String, parserInfo: ParserInfo) extends Sparql
case class SparqlColumn(query: String, column: String, parserInfo: ParserInfo) extends Sparql
case class FieldQuery(query: String, override val pushed: Boolean = false, override val popped: Boolean = false, parserInfo: ParserInfo) extends QueryClause

sealed trait Exp extends ExpOrVar with VarResult
sealed trait LeftUnion extends Exp
sealed trait RightUnion extends Exp

case class Union(left: LeftUnion, right: RightUnion, parserInfo: ParserInfo) extends RightUnion
case class StringOperation(left: IteratorQuery, right: IteratorQuery, unionString: String, parserInfo: ParserInfo) extends LeftUnion with RightUnion
case class Substitution(leftUnion: IteratorQuery, rightUnion: IteratorQuery, joinClause: IteratorQuery, parserInfo: ParserInfo) extends Exp
case class Join(leftUnion: IteratorQuery, rightUnion: IteratorQuery, leftJoinClause: IteratorQuery, rightJoinClause: IteratorQuery, parserInfo: ParserInfo) extends Exp
case class IteratorQuery(firstVar: Var, composedVar: VarOrIteratorQuery, builtinFunction: Option[BuiltinFunction] = None, parserInfo: ParserInfo) extends LeftUnion with RightUnion with VarOrIteratorQuery

sealed trait VarOrIteratorQuery extends AST
sealed trait ExpOrVar extends AST
sealed trait QueryOrURL extends VarResult
sealed trait QueryOrVar extends VarResult

sealed trait Variable extends ExpOrVar
case class Var(name: String, parserInfo: ParserInfo = UnknownParserInfo) extends Variable with VarOrIteratorQuery with QueryOrVar {
  override def equals(obj: Any): Boolean = obj match {
    case v: Var => v.name == name
    case _ => false
  }
  override def hashCode(): Int = name.hashCode
}
case class ShapeVar(name: String, parserInfo: ParserInfo) extends Variable {
  override def equals(obj: Any): Boolean = obj match {
    case v: ShapeVar => v.name == name
    case _ => false
  }
  override def hashCode(): Int = name.hashCode
}
case class GraphVar(prefix: String, name: String, parserInfo: ParserInfo) extends Variable {
  override def equals(obj: Any): Boolean = obj match {
    case v: GraphVar => v.prefix == prefix && v.name == name
    case _ => false
  }
  override def hashCode(): Int = (prefix, name).hashCode
}

case class LiteralObject(prefix: Var, value: String, parserInfo: ParserInfo) extends ObjectOrShapeLink
case class LiteralObjectValue(value: String, parserInfo: ParserInfo) extends ObjectOrShapeLink

case class PredicateObject(predicate: Predicate, objectOrShapeLink: ObjectOrShapeLink, parserInfo: ParserInfo) extends AST
case class Predicate(prefix: String, extension: String, parserInfo: ParserInfo) extends AST

case class FunctionCalling(functionHub: Var, functionName: Var, arguments: Arguments, parserInfo: ParserInfo) extends ExpOrVar
case class Arguments(arguments: List[ExpOrVar], parserInfo: ParserInfo) extends AST

sealed trait ObjectOrShapeLink extends AST

case class ObjectElement(prefix: Option[Var], action: Option[ExpOrVar], literalValue: Option[LiteralObjectValue], matcher: Option[Var], filter: Option[ExpOrVar],
                         dataType: Option[DataType], langTag: Option[LangTag], rdfCollection: Option[RDFCollection], parserInfo: ParserInfo) extends ObjectOrShapeLink
case class ShapeLink(shape: ShapeVar, parserInfo: ParserInfo) extends ObjectOrShapeLink

sealed trait DataType extends AST
case class DataTypeGeneration(prefix: Option[Var], action: ExpOrVar, matcher: Option[Var], parserInfo: ParserInfo) extends DataType
case class DataTypeLiteral(prefix: Var, value: String, parserInfo: ParserInfo) extends DataType

sealed trait LangTag extends AST
case class LangTagGeneration(action: ExpOrVar, matcher: Option[Var], parserInfo: ParserInfo) extends LangTag
case class LangTagLiteral(value: String, parserInfo: ParserInfo) extends LangTag

sealed trait VarResult extends AST
sealed trait Iterators extends AST {
  def name: Var
  def queryClause: QueryOrVar
  def fields: List[Field]
  def iterators: List[NestedIterator]
}

sealed trait FilePathOrStdin extends VarResult

sealed trait FilePath extends FilePathOrStdin {
  def value: String
}
case class URL(value: String, parserInfo: ParserInfo) extends FilePath with QueryOrURL
case class JdbcURL(value: String, parserInfo: ParserInfo) extends FilePath
case class RelativePath(value: String, parserInfo: ParserInfo) extends FilePath
case class Stdin(parserInfo: ParserInfo) extends FilePathOrStdin
case class ReplacedStrings(strings: List[String], parserInfo: ParserInfo) extends AST
case class ComposedVariable(variables: List[Var], parserInfo: ParserInfo) extends AST
case class MatcherList(matchers: List[Matcher], parserInfo: ParserInfo) extends AST

sealed trait RDFCollection extends AST
case class RDFList(parserInfo: ParserInfo) extends RDFCollection
case class RDFBag(parserInfo: ParserInfo) extends RDFCollection
case class RDFAlt(parserInfo: ParserInfo) extends RDFCollection
case class RDFSeq(parserInfo: ParserInfo) extends RDFCollection

sealed trait BuiltinFunction extends AST
case class Index(parserInfo: ParserInfo) extends BuiltinFunction

class ParserInfo(val startLine: Option[Int], val startColumn: Option[Int], val endLine: Option[Int], val endColumn: Option[Int])
object UnknownParserInfo extends ParserInfo(startLine = None, startColumn = None, endLine = None, endColumn = None)
