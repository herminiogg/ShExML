// Generated from ShExML.g4 by ANTLR 4.7.1

package es.weso.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ShExMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ShExMLVisitor<T> extends ParseTreeVisitor<T> {
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
	 * Visit a parse tree produced by {@link ShExMLParser#querySet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuerySet(ShExMLParser.QuerySetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ShExMLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#expressionSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSet(ShExMLParser.ExpressionSetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#matcher}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatcher(ShExMLParser.MatcherContext ctx);
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
	 * Visit a parse tree produced by {@link ShExMLParser#sourceQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceQuery(ShExMLParser.SourceQueryContext ctx);
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
	 * Visit a parse tree produced by {@link ShExMLParser#shape}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShape(ShExMLParser.ShapeContext ctx);
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
	 * Visit a parse tree produced by {@link ShExMLParser#fileSource}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileSource(ShExMLParser.FileSourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#queryClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQueryClause(ShExMLParser.QueryClauseContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link ShExMLParser#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(ShExMLParser.VariablesContext ctx);
}