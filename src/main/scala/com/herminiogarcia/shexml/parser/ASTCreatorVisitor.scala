package com.herminiogarcia.shexml.parser

import com.herminiogarcia.shexml.antlr.ShExMLParser._
import com.herminiogarcia.shexml.antlr.ShExMLParserBaseVisitor
import com.herminiogarcia.shexml.ast._
import com.herminiogarcia.shexml.ast.URL
import org.antlr.v4.runtime.ParserRuleContext
import scala.collection.JavaConverters._
import scala.util.Try

/**
  * Created by herminio on 20/12/17.
  */
class ASTCreatorVisitor extends ShExMLParserBaseVisitor[AST] {

  override def visitShExML(ctx: ShExMLContext): AST = {
    val declarations = ctx.decl().asScala.map(visit(_).asInstanceOf[Declaration]).toList
    val graphs = ctx.graph().asScala.map(visit(_).asInstanceOf[Graph]).toList
    val shapes = ctx.shape().asScala.map(visit(_).asInstanceOf[Shape]).toList
    ShExML(declarations, graphs, shapes, createParserInfo(ctx))
  }

  override def visitDecl(ctx: DeclContext): AST = {
    val declarationStatement = super.visitDecl(ctx).asInstanceOf[DeclarationStatement]
    Declaration(declarationStatement, createParserInfo(ctx))
  }

  override def visitPrefix(ctx: PrefixContext): AST = {
    val url = URL(ctx.URL().getText, createParserInfo(ctx))
    val name = createVar(ctx.variable())
    Prefix(name, url, createParserInfo(ctx))
  }

  override def visitSource(ctx: SourceContext): AST = {
    val url =
      if(ctx.URL != null) URL(ctx.URL().getText, createParserInfo(ctx))
      else if(ctx.STDIN() != null) Stdin(createParserInfo(ctx))
      else if(ctx.QUERY_PART() != null) RelativePath(ctx.QUERY_PART().getText, createParserInfo(ctx))
      else JdbcURL(ctx.JDBC_URL().getText, createParserInfo(ctx))
    val name = createVar(ctx.variable())
    Source(name, url, createParserInfo(ctx))
  }

  override def visitFunctions(ctx: FunctionsContext): AST = {
    val url =
      if(ctx.URL != null) URL(ctx.URL().getText, createParserInfo(ctx))
      else RelativePath(ctx.QUERY_PART().getText, createParserInfo(ctx))
    val name = createVar(ctx.variable())
    Functions(name, url, createParserInfo(ctx))
  }

  override def visitQuery(ctx: QueryContext): AST = {
    val queryOrURL: QueryOrURL = if (ctx.URL() != null) {
      URL(ctx.URL().getText, createParserInfo(ctx))
    } else {
      visitQueryClause(ctx.queryClause()).asInstanceOf[QueryClause]
    }
    val name = createVar(ctx.variable())
    Query(name, queryOrURL, createParserInfo(ctx))
  }

  override def visitQueryClause(ctx: QueryClauseContext): AST = {
    if(ctx.JSONPATH() != null) JsonPath(ctx.QUERY_PART().asScala.map(_.getText).mkString(" "), createParserInfo(ctx, columnOffset = "jsonpath: ".length))
    else if(ctx.XMLPATH() != null) XmlPath(ctx.QUERY_PART().asScala.map(_.getText).mkString(" "), createParserInfo(ctx, columnOffset = "xpath: ".length))
    else if(ctx.SQL() != null) SqlQuery(ctx.QUERY_PART().asScala.map(_.getText).mkString(" "), createParserInfo(ctx, columnOffset = "csv: ".length))
    else if(ctx.SPARQL() != null) SparqlQuery(ctx.QUERY_PART().asScala.map(_.getText)
      .mkString(" ").replaceAll("\\\\<", "<").replaceAll("\\\\>", ">"), createParserInfo(ctx, columnOffset = "sparql: ".length))
    else CSVPerRow("", createParserInfo(ctx))
  }

  override def visitExpression(ctx: ExpressionContext): AST = {
    val exp = visit(ctx.exp()).asInstanceOf[Exp]
    val name = createVar(ctx.variable())
    Expression(name, exp, createParserInfo(ctx))
  }

  override def visitMatcher(ctx: MatcherContext): AST = {
    val matcherVar = createVar(ctx.variable())
    val matchers = visit(ctx.matchers()).asInstanceOf[MatcherList]
    Matchers(matcherVar, matchers, createParserInfo(ctx))
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
    MatcherList(otherMatchers.::(Matcher(replacedStrings, replacementString, createParserInfo(ctx))), createParserInfo(ctx))
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
    ReplacedStrings(replacedStrings.::(string), createParserInfo(ctx))
  }

  override def visitAutoincrement(ctx: AutoincrementContext): AST = {
    val name = createVar(ctx.variable())
    val from = ctx.DIGITS(0).getText.toInt
    val to = if(ctx.TO() != null) ctx.DIGITS(1).getText.toInt else Int.MaxValue
    val by = if(ctx.BY() != null && ctx.TO() == null) ctx.DIGITS(1).getText.toInt
    else if(ctx.BY() != null && ctx.TO() != null) ctx.DIGITS(2).getText.toInt
    else 1
    val precedentString = if((ctx.STRINGOPERATOR_AUTOINCREMENT(0) != null && ctx.STRINGOPERATOR_AUTOINCREMENT(1) != null)
      || (ctx.STRINGOPERATOR_AUTOINCREMENT(0) != null
          && ctx.STRINGOPERATOR_AUTOINCREMENT(0).getSourceInterval.startsBeforeDisjoint(ctx.ADD_AUTOINCREMENT(0).getSourceInterval)))
      Some(ctx.STRINGOPERATOR_AUTOINCREMENT(0).getText.replaceAll("\"", ""))
    else None
    val closingString = if(ctx.STRINGOPERATOR_AUTOINCREMENT(0) != null
      && ctx.STRINGOPERATOR_AUTOINCREMENT(1) == null
      && ctx.STRINGOPERATOR_AUTOINCREMENT(0).getSourceInterval.startsAfter(ctx.ADD_AUTOINCREMENT(0).getSourceInterval))
      Some(ctx.STRINGOPERATOR_AUTOINCREMENT(0).getText.replaceAll("\"", ""))
    else if(ctx.STRINGOPERATOR_AUTOINCREMENT(0) != null && ctx.STRINGOPERATOR_AUTOINCREMENT(1) != null)
      Some(ctx.STRINGOPERATOR_AUTOINCREMENT(1).getText.replaceAll("\"", ""))
    else None
    AutoIncrement(name, from, to, by, precedentString, closingString, createParserInfo(ctx))
  }

  override def visitUnion(ctx: UnionContext): AST = {
    val left = visit(ctx.leftUnionOption()).asInstanceOf[LeftUnion]
    val right = visit(ctx.rightUnionOption()).asInstanceOf[RightUnion]
    Union(left, right, createParserInfo(ctx))
  }

  override def visitStringOperation(ctx: StringOperationContext): AST = {
    val left = visit(ctx.iteratorQuery(0)).asInstanceOf[IteratorQuery]
    val right = visit(ctx.iteratorQuery(1)).asInstanceOf[IteratorQuery]
    val stringOperator = ctx.STRINGOPERATOR().getText.replace("\"", "")
    StringOperation(left, right, stringOperator, createParserInfo(ctx))
  }

  override def visitSubstitution(ctx: SubstitutionContext): AST = {
    val leftUnion = visit(ctx.iteratorQuery(0)).asInstanceOf[IteratorQuery]
    val rightUnion = visit(ctx.iteratorQuery(1)).asInstanceOf[IteratorQuery]
    val joinClause = visit(ctx.iteratorQuery(2)).asInstanceOf[IteratorQuery]
    Substitution(leftUnion, rightUnion, joinClause, createParserInfo(ctx))
  }

  override def visitJoin(ctx: JoinContext): AST = {
    val leftUnion = visit(ctx.iteratorQuery(0)).asInstanceOf[IteratorQuery]
    val rightUnion = visit(ctx.iteratorQuery(1)).asInstanceOf[IteratorQuery]
    val leftJoinClause = visit(ctx.iteratorQuery(2)).asInstanceOf[IteratorQuery]
    val rightJoinClause = visit(ctx.iteratorQuery(3)).asInstanceOf[IteratorQuery]
    Join(leftUnion, rightUnion, leftJoinClause, rightJoinClause, createParserInfo(ctx))
  }

  override def visitIterator(ctx: IteratorContext): AST = {
    val query: QueryOrVar = if(ctx.queryClause() != null) {
      visit(ctx.queryClause()).asInstanceOf[QueryClause]
    } else {
      Var(ctx.QUERY_PART().asScala.map(_.getText).mkString(" "), createParserInfo(ctx))
    }
    val variable = createVar(ctx.variable())
    val fields = ctx.field().listIterator().asScala.map(visit(_).asInstanceOf[Field])
    val iterators = ctx.nestedIterator().listIterator().asScala.map(visit(_).asInstanceOf[NestedIterator])
    Iterator(variable, query, fields.toList, iterators.toList, createParserInfo(ctx))
  }

  override def visitNestedIterator(ctx: NestedIteratorContext): AST = {
    val query = FieldQuery(ctx.QUERY_PART().asScala.map(_.getText).mkString(" "), parserInfo = createParserInfo(ctx))
    val variable = createVar(ctx.variable())
    val fields = ctx.field().listIterator().asScala.map(visit(_).asInstanceOf[Field])
    val iterators = ctx.nestedIterator().listIterator().asScala.map(visit(_).asInstanceOf[NestedIterator])
    NestedIterator(variable, query, fields.toList, iterators.toList, createParserInfo(ctx))
  }

  override def visitField(ctx: FieldContext): AST = {
    val pushed = ctx.PUSHED_FIELD() != null
    val popped = ctx.POPPED_FIELD() != null
    val fieldQuery = FieldQuery(ctx.QUERY_PART().asScala.map(_.getText).mkString(" "), pushed, popped, createParserInfo(ctx))
    val variable = createVar(ctx.variable())
    Field(variable, fieldQuery, pushed, popped, createParserInfo(ctx))
  }

  override def visitIteratorQuery(ctx: IteratorQueryContext): AST = {
    val firstVar = createVar(ctx.variable())
    val varOrIteratorQuery = visit(ctx.composedVariable()).asInstanceOf[VarOrIteratorQuery]
    val builtinFunction =
      if(ctx.builtinFunction() != null) Some(visit(ctx.builtinFunction()).asInstanceOf[BuiltinFunction])
      else None
    IteratorQuery(firstVar, varOrIteratorQuery, builtinFunction, createParserInfo(ctx))
  }

  override def visitComposedVariable(ctx: ComposedVariableContext): AST = {
    val variable = createVar(ctx.variable())
    //val fileVar = Var(ctx.getParent.start.getText.split(".")(0))
    val otherVariables = if(ctx.composedVariable() != null)
      visit(ctx.composedVariable()).asInstanceOf[VarOrIteratorQuery]
    else null
    if(otherVariables != null) IteratorQuery(variable, otherVariables, parserInfo = createParserInfo(ctx, considerFullContext = true)) else variable
  }

  override def visitBuiltinFunction(ctx: BuiltinFunctionContext): AST = {
    if(ctx.INDEX() != null) {
      Index(createParserInfo(ctx))
    } else null
  }

  override def visitGraph(ctx: GraphContext): AST = {
    val graphName = createGraphVar(ctx.literalValue)
    val shapes = ctx.shape().asScala.map(visit(_).asInstanceOf[Shape]).toList
    val dummyGraph = Graph(graphName, Nil, UnknownParserInfo)
    val graphShapes = shapes.map(s =>
      Shape(s.shapeName, s.action, s.predicateObjects, Some(dummyGraph), s.parserInfo))
    Graph(graphName, graphShapes, createParserInfo(ctx))
  }

  override def visitShape(ctx: ShapeContext): AST = {
    val shapeName = createShapeVar(ctx.tripleElement)
    val action = visit(ctx.actionOrLiteral()).asInstanceOf[ActionOrLiteral]
    val predicateObjects = ctx.predicateObject().asScala.map(visit(_).asInstanceOf[PredicateObject]).toList
    Shape(shapeName, action, predicateObjects, None, createParserInfo(ctx))
  }

  override def visitAction(ctx: ActionContext): AST = {
    val shapePrefix = createVar(ctx.prefixVar().variable())
    val action = visit(ctx.expOrVarOrFunctionCallign(0)).asInstanceOf[ExpOrVar]
    val condition = if(ctx.expOrVarOrFunctionCallign(1) != null)
      Some(visit(ctx.expOrVarOrFunctionCallign(1)).asInstanceOf[ExpOrVar])
    else None
    Action(shapePrefix, action, condition, createParserInfo(ctx))
  }

  override def visitLiteralSubject(ctx: LiteralSubjectContext): AST = {
    val prefix = Var(ctx.prefixVar().getText, createParserInfo(ctx))
    val value = ctx.variable().getText
    LiteralSubject(prefix, value, createParserInfo(ctx))
  }

  override def visitPredicateObject(ctx: PredicateObjectContext): AST = {
    val predicate = visit(ctx.predicate()).asInstanceOf[Predicate]
    val objectElementOrShapeLink = if(ctx.objectElement() == null && ctx.literalValue() == null)
      visit(ctx.shapeLink()).asInstanceOf[ShapeLink]
    else if(ctx.shapeLink() == null && ctx.literalValue() == null)
      visit(ctx.objectElement()).asInstanceOf[ObjectElement]
    else visit(ctx.literalValue()).asInstanceOf[LiteralObject]
    PredicateObject(predicate, objectElementOrShapeLink, createParserInfo(ctx))
  }

  override def visitPredicate(ctx: PredicateContext): AST = {
    if(ctx.A() != null) {
      Predicate("rdf:", "type", createParserInfo(ctx))
    } else {
      val prefix = ctx.literalValue().prefixVar().getText
      val name = ctx.literalValue().variable().getText.replaceAll("\\\\.|%2E", ".")
      Predicate(prefix, name, createParserInfo(ctx))
    }
  }

  override def visitLiteralValue(ctx: LiteralValueContext): AST = {
    val prefix = Var(ctx.prefixVar().getText, createParserInfo(ctx))
    val value = ctx.variable().getText
    LiteralObject(prefix, value, createParserInfo(ctx))
  }

  override def visitObjectElement(ctx: ObjectElementContext): AST = {
    val prefix =
      if(ctx.firstPartObjectElement().prefixVar() != null)
        Some(Var(ctx.firstPartObjectElement().prefixVar().getText, createParserInfo(ctx.firstPartObjectElement().prefixVar(), considerFullContext = true)))
      else None
    val mainExpOrVar = if(ctx.firstPartObjectElement().valueRetriever().expOrVarOrFunctionCallign(0) != null)
      Some(visit(ctx.firstPartObjectElement().valueRetriever().expOrVarOrFunctionCallign(0)).asInstanceOf[ExpOrVar])
    else None
    val literalValue = if(ctx.firstPartObjectElement().valueRetriever().STRINGOPERATOR() != null)
      Some(LiteralObjectValue(ctx.firstPartObjectElement().valueRetriever().STRINGOPERATOR().getText.replaceAll("\"", ""), createParserInfo(ctx)))
    else None
    val matcherVar = if(ctx.firstPartObjectElement().valueRetriever().variable() != null)
        Option(ctx.firstPartObjectElement().valueRetriever().variable()).map(createVar)
      else None
    val condition = if(ctx.firstPartObjectElement().valueRetriever().expOrVarOrFunctionCallign(1) != null)
        Some(visit(ctx.firstPartObjectElement().valueRetriever().expOrVarOrFunctionCallign(1)).asInstanceOf[ExpOrVar])
      else None
    val dataType = if(ctx.xmlschemadatatype() != null) Some(visit(ctx.xmlschemadatatype()).asInstanceOf[DataType]) else None
    val langTag = if(ctx.langtag() != null) Some(visit(ctx.langtag()).asInstanceOf[LangTag]) else None
    val rdfCollection = {
      if(ctx.firstPartObjectElement() == null || ctx.firstPartObjectElement().valueRetriever() == null
        || ctx.firstPartObjectElement().valueRetriever().rdfCollection() == null) None
      else if(ctx.firstPartObjectElement().valueRetriever().rdfCollection().RDFLIST() != null) Some(RDFList(createParserInfo(ctx)))
      else if(ctx.firstPartObjectElement().valueRetriever().rdfCollection().RDFSEQ() != null) Some(RDFSeq(createParserInfo(ctx)))
      else if(ctx.firstPartObjectElement().valueRetriever().rdfCollection().RDFALT() != null) Some(RDFAlt(createParserInfo(ctx)))
      else if(ctx.firstPartObjectElement().valueRetriever().rdfCollection().RDFBAG() != null) Some(RDFBag(createParserInfo(ctx)))
      else None
    }
    ObjectElement(prefix, mainExpOrVar, literalValue, matcherVar, condition, dataType, langTag, rdfCollection, createParserInfo(ctx))
  }

  override def visitExpOrVarOrFunctionCallign(ctx: ExpOrVarOrFunctionCallignContext): AST = {
    if(ctx.variable() != null) createVar(ctx.variable())
    else if(ctx.exp() != null) visit(ctx.exp())
    else visit(ctx.functionCalling())
  }

  override def visitXmlschemadatatype(ctx: XmlschemadatatypeContext): AST = {
    if(ctx.firstPartObjectElement() == null) {
      DataTypeLiteral(ctx.XMLSCHEMADATATYPE().getText, createParserInfo(ctx))
    } else {
      val prefix = if(ctx.firstPartObjectElement().prefixVar() != null) Some(createVar(ctx.firstPartObjectElement().prefixVar().variable())) else None
      val expOrVar = visit(ctx.firstPartObjectElement().valueRetriever().expOrVarOrFunctionCallign(0)).asInstanceOf[ExpOrVar]
      val matcherVar = if(ctx.firstPartObjectElement().valueRetriever().variable() != null)
        Option(ctx.firstPartObjectElement().valueRetriever().variable()).map(createVar)
      else None
      DataTypeGeneration(prefix, expOrVar, matcherVar, createParserInfo(ctx))
    }
  }

  override def visitLangtag(ctx: LangtagContext): AST = {
    if(ctx.valueRetriever() == null) {
      LangTagLiteral(ctx.LANGTAG().getText.replace("@", ""), createParserInfo(ctx))
    } else {
      val expOrVar = visit(ctx.valueRetriever().expOrVarOrFunctionCallign(0)).asInstanceOf[ExpOrVar]
      val matcherVar = if(ctx.valueRetriever().variable() != null)
        Option(ctx.valueRetriever().variable()).map(createVar)
      else None
      LangTagGeneration(expOrVar, matcherVar, createParserInfo(ctx))
    }
  }

  override def visitFunctionCalling(ctx: FunctionCallingContext): AST = {
    val functionHub = createVar(ctx.variable(0))
    val functionName = createVar(ctx.variable(1))
    val functionArguments = visit(ctx.functionArguments()).asInstanceOf[Arguments]
    FunctionCalling(functionHub, functionName, functionArguments, createParserInfo(ctx))
  }

  override def visitFunctionArguments(ctx: FunctionArgumentsContext): AST = {
    val argument =
      (if(ctx.exp() != null) visit(ctx.exp())
      else createVar(ctx.variable())).asInstanceOf[ExpOrVar]
    val arguments =
      if(ctx.functionArguments() != null) argument +: visit(ctx.functionArguments()).asInstanceOf[Arguments].arguments
      else List(argument)
    Arguments(arguments, createParserInfo(ctx))
  }

  override def visitShapeLink(ctx: ShapeLinkContext): AST = {
    val shapeName = ShapeVar(ctx.getText.replace("@", "").replaceAll("\\\\.|%2E", "."), createParserInfo(ctx))
    ShapeLink(shapeName, createParserInfo(ctx, considerFullContext = true))
  }

  def createVar(variable: VariableContext): Var = {
    Var(Try(variable.getText).getOrElse("").replaceAll("\\\\.|%2E", "."), createParserInfo(variable, considerFullContext = true))
  }

  def createShapeVar(tripleElementContext: TripleElementContext): ShapeVar = {
    ShapeVar(tripleElementContext.getText.replaceAll("\\\\.|%2E", "."), createParserInfo(tripleElementContext))
  }

  def createGraphVar(literalValueContext: LiteralValueContext): GraphVar = {
    GraphVar(literalValueContext.prefixVar().getText,
      literalValueContext.variable().getText.replaceAll("\\\\.|%2E", "."),
      createParserInfo(literalValueContext))
  }

  def getDeclarationContent(content: String): String = content.replaceAll("<>", "")

  def createQuery(query: String): QueryClause = {
    if(query.startsWith("$")) JsonPath(query, UnknownParserInfo)
    else if(query.startsWith("/")) XmlPath(query, UnknownParserInfo)
    else throw new Exception("Impossible to parse query: " + query)
  }

  def createParserInfo(context: ParserRuleContext, considerFullContext: Boolean = false, columnOffset: Int = 0): ParserInfo = {
    val start = context.getStart
    val end = context.getStop
    val endPosition = if(considerFullContext) Some(end.getCharPositionInLine + end.getText.length + columnOffset) else Some(end.getCharPositionInLine + columnOffset)
    new ParserInfo(Some(start.getLine), Some(start.getCharPositionInLine + columnOffset), Some(end.getLine), endPosition)
  }

}
