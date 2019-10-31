package es.weso.parser

import es.weso.antlr.ShExMLParserBaseVisitor
import es.weso.antlr.ShExMLParser._
import es.weso.ast._
import es.weso.ast.URL
import org.antlr.v4.runtime.tree.TerminalNode

import scala.collection.JavaConverters._
import scala.util.Try


/**
  * Created by herminio on 20/12/17.
  */
class ASTCreatorVisitor extends ShExMLParserBaseVisitor[AST] {

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
    if(ctx.JSONPATH() != null) JsonPath(ctx.QUERY_PART().getText)
    else if(ctx.XMLPATH() != null) XmlPath(ctx.QUERY_PART().getText)
    else CSVPerRow("")
  }

  override def visitExpression(ctx: ExpressionContext): AST = {
    val exp = visit(ctx.exp()).asInstanceOf[Exp]
    val name = createVar(ctx.variable())
    Expression(name, exp)
  }

  override def visitMatcher(ctx: MatcherContext): AST = {
    val matcherVar = createVar(ctx.variable())
    val matchers = visit(ctx.matchers()).asInstanceOf[MatcherList]
    Matchers(matcherVar, matchers)
  }

  override def visitMatchers(ctx: MatchersContext): AST = {
    val otherMatchers =
      if(ctx.matchers() != null)
        visitMatchers(ctx.matchers()).asInstanceOf[MatcherList].matchers
      else
        Nil
    val replacedStrings = visit(ctx.replacedStrings()).asInstanceOf[ReplacedStrings]
    val replacementString =
      if(ctx.STRING_OR_VAR() != null ) ctx.STRING_OR_VAR().getText
      else ctx.STRINGOPERATOR().getText.replaceAll("\"", "")
    MatcherList(otherMatchers.::(Matcher(replacedStrings, replacementString)))
  }

  override def visitReplacedStrings(ctx: ReplacedStringsContext): AST = {
    val replacedStrings =
      if(ctx.replacedStrings() != null)
        visit(ctx.replacedStrings()).asInstanceOf[ReplacedStrings].strings
      else
        Nil
    val string =
      if(ctx.STRING_OR_VAR() != null ) ctx.STRING_OR_VAR().getText
      else ctx.STRINGOPERATOR().getText.replaceAll("\"", "")
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
    val iterators = ctx.nestedIterator().listIterator().asScala.map(visit(_).asInstanceOf[NestedIterator])
    Iterator(variable, query, fields.toList, iterators.toList)
  }

  override def visitNestedIterator(ctx: NestedIteratorContext): AST = {
    val query = FieldQuery(ctx.QUERY_PART().getText)
    val variable = createVar(ctx.variable())
    val fields = ctx.field().listIterator().asScala.map(visit(_).asInstanceOf[Field])
    val iterators = ctx.nestedIterator().listIterator().asScala.map(visit(_).asInstanceOf[NestedIterator])
    NestedIterator(variable, query, fields.toList, iterators.toList)
  }

  override def visitField(ctx: FieldContext): AST = {
    val fieldQuery = FieldQuery(ctx.QUERY_PART().getText)
    val variable = createVar(ctx.variable())
    Field(variable, fieldQuery)
  }

  override def visitIteratorQuery(ctx: IteratorQueryContext): AST = {
    val firstVar = createVar(ctx.variable())
    val varOrIteratorQuery = visit(ctx.composedVariable()).asInstanceOf[VarOrIteratorQuery]
    IteratorQuery(firstVar, varOrIteratorQuery)
  }

  override def visitComposedVariable(ctx: ComposedVariableContext): AST = {
    val variable = createVar(ctx.variable())
    //val fileVar = Var(ctx.getParent.start.getText.split(".")(0))
    val otherVariables = if(ctx.composedVariable() != null)
      visit(ctx.composedVariable()).asInstanceOf[VarOrIteratorQuery]
    else null
    if(otherVariables != null) IteratorQuery(variable, otherVariables) else variable
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
    val objectElementOrShapeLink = if(ctx.objectElement() == null && ctx.literalValue() == null)
      visit(ctx.shapeLink()).asInstanceOf[ShapeLink]
    else if(ctx.shapeLink() == null && ctx.literalValue() == null)
      visit(ctx.objectElement()).asInstanceOf[ObjectElement]
    else visit(ctx.literalValue()).asInstanceOf[LiteralObject]
    PredicateObject(predicate, objectElementOrShapeLink)
  }

  override def visitPredicate(ctx: PredicateContext): AST = {
    if(ctx.A() != null) {
      Predicate("rdf:", "type")
    } else {
      val prefix = ctx.literalValue().prefixVar().getText
      val name = ctx.literalValue().variable().getText
      Predicate(prefix, name)
    }
  }

  override def visitLiteralValue(ctx: LiteralValueContext): AST = {
    val prefix = Var(ctx.prefixVar().getText)
    val value = ctx.variable().getText
    LiteralObject(prefix, value)
  }

  override def visitObjectElement(ctx: ObjectElementContext): AST = {
    val prefix = if(ctx.prefixVar() != null) ctx.prefixVar().getText else ""
    val expOrVar = if(ctx.variable().size() == 2 || (ctx.variable().size() == 1 && ctx.exp() == null)) createVar(ctx.variable(0)) else visit(ctx.exp()).asInstanceOf[ExpOrVar]
    val matcherVar = if(ctx.variable(1) == null && ctx.exp() != null) Option(ctx.variable(0)).map(createVar) else Option(ctx.variable(1)).map(createVar)
    val dataType = if(ctx.XMLSCHEMADATATYPE() != null) Some(ctx.XMLSCHEMADATATYPE().getText) else None
    val langTag = if(ctx.LANGTAG() != null) Some(ctx.LANGTAG().getText.replace("@", "")) else None
    ObjectElement(prefix, expOrVar, matcherVar, dataType, langTag)
  }

  override def visitShapeLink(ctx: ShapeLinkContext): AST = {
    val shapeName = ShapeVar(ctx.getText.replace("@", ""))
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
