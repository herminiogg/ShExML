package es.weso.parser

import es.weso.antlr.ShExMLBaseVisitor
import es.weso.antlr.ShExMLParser._
import es.weso.ast._
import es.weso.ast.URL
import org.antlr.v4.runtime.tree.TerminalNode

import scala.collection.JavaConverters._
import scala.util.Try


/**
  * Created by herminio on 20/12/17.
  */
class ASTCreatorVisitor extends ShExMLBaseVisitor[AST] {

  override def visitShExML(ctx: ShExMLContext): AST = {
    val declarations = ctx.decl().asScala.map(visit(_).asInstanceOf[Declaration]).toList
    val shapes = ctx.shape().asScala.map(visit(_).asInstanceOf[Shape]).toList
    ShExML(declarations, shapes)
  }

  override def visitDecl(ctx: DeclContext): AST = {
    val declarationStatement = super.visitDecl(ctx).asInstanceOf[DeclarationStatement]
    Declaration(declarationStatement)
  }

  override def visitPrefix(ctx: PrefixContext): AST = {
    val url = URL(ctx.URL().getText)
    val name = createVar(ctx.variable())
    Prefix(name, url)
  }

  override def visitSource(ctx: SourceContext): AST = {
    val url = URL(ctx.URL().getText)
    val name = createVar(ctx.variable())
    Source(name, url)
  }

  override def visitQuery(ctx: QueryContext): AST = {
    val queryClause = visit(ctx.queryClause()).asInstanceOf[QueryClause]
    val name = createVar(ctx.variable())
    Query(name, queryClause)
  }

  override def visitQueryClause(ctx: QueryClauseContext): AST = {
    if(ctx.JSONPATH() != null) JsonPath(ctx.JSONPATH().getText.replace("jsonpath:", ""))
    else XmlPath(ctx.XMLPATH().getText.replace("xpath:", ""))
  }

  override def visitExpression(ctx: ExpressionContext): AST = {
    val exp = visit(ctx.exp()).asInstanceOf[Exp]
    val name = createVar(ctx.variable())
    Expression(name, exp)
  }

  override def visitMatcher(ctx: MatcherContext): AST = {
    val matcherVar = createVar(ctx.variable())
    val replacedStrings = visit(ctx.replacedStrings()).asInstanceOf[ReplacedStrings]
    val replacementString = ctx.STRING_OR_VAR().getText
    Matcher(matcherVar, replacedStrings, replacementString)
  }

  override def visitReplacedStrings(ctx: ReplacedStringsContext): AST = {
    val replacedStrings =
      if(ctx.replacedStrings() != null)
        visit(ctx.replacedStrings()).asInstanceOf[ReplacedStrings].strings
      else
        Nil
    val string = ctx.STRING_OR_VAR().getText
    ReplacedStrings(replacedStrings.::(string))
  }

  override def visitUnion(ctx: UnionContext): AST = {
    val left = visit(ctx.leftUnionOption()).asInstanceOf[LeftUnion]
    val right = visit(ctx.rightUnionOption()).asInstanceOf[RightUnion]
    Union(left, right)
  }

  override def visitStringOperation(ctx: StringOperationContext): AST = {
    val left = visit(ctx.iteratorQuery(0)).asInstanceOf[IteratorQuery]
    val right = visit(ctx.iteratorQuery(1)).asInstanceOf[IteratorQuery]
    val stringOperator = ctx.STRINGOPERATOR().getText.replace("\"", "")
    StringOperation(left, right, stringOperator)
  }

  override def visitJoin(ctx: JoinContext): AST = {
    val leftUnion = visit(ctx.iteratorQuery(0)).asInstanceOf[IteratorQuery]
    val rightUnion = visit(ctx.iteratorQuery(1)).asInstanceOf[IteratorQuery]
    val joinClause = visit(ctx.iteratorQuery(2)).asInstanceOf[IteratorQuery]
    Join(leftUnion, rightUnion, joinClause)
  }

  override def visitIterator(ctx: IteratorContext): AST = {
    val query = visit(ctx.queryClause()).asInstanceOf[QueryClause]
    val variable = createVar(ctx.variable())
    val fields = ctx.field().listIterator().asScala.map(visit(_).asInstanceOf[Field])
    Iterator(variable, query, fields.toList)
  }

  override def visitField(ctx: FieldContext): AST = {
    val fieldQuery = visit(ctx.queryParts()).asInstanceOf[FieldQuery]
    val variable = createVar(ctx.variable())
    Field(variable, fieldQuery)
  }

  override def visitQueryParts(ctx: QueryPartsContext): AST = FieldQuery(ctx.getText)

  override def visitIteratorQuery(ctx: IteratorQueryContext): AST = {
    val fileVar = createVar(ctx.variable(0))
    val iteratorVar = createVar(ctx.variable(1))
    val fieldVar = createVar(ctx.variable(2))
    IteratorQuery(fileVar, iteratorVar, fieldVar)
  }

  override def visitShape(ctx: ShapeContext): AST = {
    val shapeName = createShapeVar(ctx.tripleElement)
    val shapePrefix = ctx.prefixVar().getText
    val action = if(ctx.exp() == null) createVar(ctx.variable()) else visit(ctx.exp()).asInstanceOf[Exp]
    val predicateObjects = ctx.predicateObject().asScala.map(visit(_).asInstanceOf[PredicateObject]).toList
    Shape(shapeName, shapePrefix, action, predicateObjects)
  }

  override def visitPredicateObject(ctx: PredicateObjectContext): AST = {
    val predicate = visit(ctx.predicate()).asInstanceOf[Predicate]
    val objectElementOrShapeLink = if(ctx.objectElement() == null)
      visit(ctx.shapeLink()).asInstanceOf[ShapeLink]
    else visit(ctx.objectElement()).asInstanceOf[ObjectElement]
    PredicateObject(predicate, objectElementOrShapeLink)
  }

  override def visitPredicate(ctx: PredicateContext): AST = {
    val prefix = ctx.prefixVar().getText
    val name = ctx.variable().getText
    Predicate(prefix, name)
  }

  override def visitObjectElement(ctx: ObjectElementContext): AST = {
    val prefix = if(ctx.prefixVar() != null) ctx.prefixVar().getText else ""
    val expOrVar = if(ctx.variable() != null) createVar(ctx.variable(0)) else visit(ctx.exp()).asInstanceOf[ExpOrVar]
    val matcherVar = Option(ctx.variable(1)).map(createVar)
    ObjectElement(prefix, expOrVar, matcherVar)
  }

  override def visitShapeLink(ctx: ShapeLinkContext): AST = {
    val shapeName = createShapeVar(ctx.tripleElement)
    ShapeLink(shapeName)
  }

  def createVar(variable: VariableContext): Var = {
    Var(Try(variable.getText).getOrElse(""))
  }

  def createShapeVar(tripleElementContext: TripleElementContext): ShapeVar = {
    ShapeVar(tripleElementContext.getText)
  }

  def getDeclarationContent(content: String): String = content.replaceAll("<>", "")

  def createQuery(query: String): QueryClause = {
    if(query.startsWith("$")) JsonPath(query)
    else if(query.startsWith("/")) XmlPath(query)
    else throw new Exception("Impossible to parse query: " + query)
  }

}
