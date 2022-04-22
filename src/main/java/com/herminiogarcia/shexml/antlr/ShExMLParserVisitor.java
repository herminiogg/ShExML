// Generated from ShExMLParser.g4 by ANTLR 4.9.2

package com.herminiogarcia.shexml.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShExMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShExMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#shExML}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShExML(ShExMLParser.ShExMLContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(ShExMLParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(ShExMLParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(ShExMLParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(ShExMLParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions(ShExMLParser.FunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#iterator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterator(ShExMLParser.IteratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#nestedIterator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedIterator(ShExMLParser.NestedIteratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(ShExMLParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#autoincrement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAutoincrement(ShExMLParser.AutoincrementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ShExMLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#matcher}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatcher(ShExMLParser.MatcherContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#matchers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchers(ShExMLParser.MatchersContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#replacedStrings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReplacedStrings(ShExMLParser.ReplacedStringsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(ShExMLParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#stringOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringOperation(ShExMLParser.StringOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#iteratorQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteratorQuery(ShExMLParser.IteratorQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#composedVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposedVariable(ShExMLParser.ComposedVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#queryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryClause(ShExMLParser.QueryClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin(ShExMLParser.JoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(ShExMLParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#leftUnionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftUnionOption(ShExMLParser.LeftUnionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#rightUnionOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightUnionOption(ShExMLParser.RightUnionOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#graph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraph(ShExMLParser.GraphContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape(ShExMLParser.ShapeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#actionOrLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionOrLiteral(ShExMLParser.ActionOrLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#literalSubject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralSubject(ShExMLParser.LiteralSubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAction(ShExMLParser.ActionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#predicateObject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicateObject(ShExMLParser.PredicateObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#objectElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectElement(ShExMLParser.ObjectElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#firstPartObjectElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFirstPartObjectElement(ShExMLParser.FirstPartObjectElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#valueRetriever}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueRetriever(ShExMLParser.ValueRetrieverContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#functionCalling}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCalling(ShExMLParser.FunctionCallingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#functionArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArguments(ShExMLParser.FunctionArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#rdfCollection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRdfCollection(ShExMLParser.RdfCollectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#xmlschemadatatype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlschemadatatype(ShExMLParser.XmlschemadatatypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#langtag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLangtag(ShExMLParser.LangtagContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#shapeLink}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShapeLink(ShExMLParser.ShapeLinkContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(ShExMLParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#literalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralValue(ShExMLParser.LiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#tripleElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTripleElement(ShExMLParser.TripleElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#prefixVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixVar(ShExMLParser.PrefixVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ShExMLParser.VariableContext ctx);
}