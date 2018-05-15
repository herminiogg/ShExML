// Generated from ShExML.g4 by ANTLR 4.7.1

package es.weso.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ShExMLParser}.
 */
public interface ShExMLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#shExML}.
	 * @param ctx the parse tree
	 */
	void enterShExML(ShExMLParser.ShExMLContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#shExML}.
	 * @param ctx the parse tree
	 */
	void exitShExML(ShExMLParser.ShExMLContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(ShExMLParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(ShExMLParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(ShExMLParser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(ShExMLParser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(ShExMLParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(ShExMLParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(ShExMLParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(ShExMLParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ShExMLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ShExMLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#matcher}.
	 * @param ctx the parse tree
	 */
	void enterMatcher(ShExMLParser.MatcherContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#matcher}.
	 * @param ctx the parse tree
	 */
	void exitMatcher(ShExMLParser.MatcherContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#replacedStrings}.
	 * @param ctx the parse tree
	 */
	void enterReplacedStrings(ShExMLParser.ReplacedStringsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#replacedStrings}.
	 * @param ctx the parse tree
	 */
	void exitReplacedStrings(ShExMLParser.ReplacedStringsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(ShExMLParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(ShExMLParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#stringOperation}.
	 * @param ctx the parse tree
	 */
	void enterStringOperation(ShExMLParser.StringOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#stringOperation}.
	 * @param ctx the parse tree
	 */
	void exitStringOperation(ShExMLParser.StringOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#sourceQuery}.
	 * @param ctx the parse tree
	 */
	void enterSourceQuery(ShExMLParser.SourceQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#sourceQuery}.
	 * @param ctx the parse tree
	 */
	void exitSourceQuery(ShExMLParser.SourceQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#join}.
	 * @param ctx the parse tree
	 */
	void enterJoin(ShExMLParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#join}.
	 * @param ctx the parse tree
	 */
	void exitJoin(ShExMLParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(ShExMLParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(ShExMLParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#leftUnionOption}.
	 * @param ctx the parse tree
	 */
	void enterLeftUnionOption(ShExMLParser.LeftUnionOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#leftUnionOption}.
	 * @param ctx the parse tree
	 */
	void exitLeftUnionOption(ShExMLParser.LeftUnionOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#rightUnionOption}.
	 * @param ctx the parse tree
	 */
	void enterRightUnionOption(ShExMLParser.RightUnionOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#rightUnionOption}.
	 * @param ctx the parse tree
	 */
	void exitRightUnionOption(ShExMLParser.RightUnionOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#shape}.
	 * @param ctx the parse tree
	 */
	void enterShape(ShExMLParser.ShapeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#shape}.
	 * @param ctx the parse tree
	 */
	void exitShape(ShExMLParser.ShapeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#predicateObject}.
	 * @param ctx the parse tree
	 */
	void enterPredicateObject(ShExMLParser.PredicateObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#predicateObject}.
	 * @param ctx the parse tree
	 */
	void exitPredicateObject(ShExMLParser.PredicateObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#objectElement}.
	 * @param ctx the parse tree
	 */
	void enterObjectElement(ShExMLParser.ObjectElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#objectElement}.
	 * @param ctx the parse tree
	 */
	void exitObjectElement(ShExMLParser.ObjectElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#shapeLink}.
	 * @param ctx the parse tree
	 */
	void enterShapeLink(ShExMLParser.ShapeLinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#shapeLink}.
	 * @param ctx the parse tree
	 */
	void exitShapeLink(ShExMLParser.ShapeLinkContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(ShExMLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(ShExMLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#fileSource}.
	 * @param ctx the parse tree
	 */
	void enterFileSource(ShExMLParser.FileSourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#fileSource}.
	 * @param ctx the parse tree
	 */
	void exitFileSource(ShExMLParser.FileSourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#queryClause}.
	 * @param ctx the parse tree
	 */
	void enterQueryClause(ShExMLParser.QueryClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#queryClause}.
	 * @param ctx the parse tree
	 */
	void exitQueryClause(ShExMLParser.QueryClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#tripleElement}.
	 * @param ctx the parse tree
	 */
	void enterTripleElement(ShExMLParser.TripleElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#tripleElement}.
	 * @param ctx the parse tree
	 */
	void exitTripleElement(ShExMLParser.TripleElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#prefixVar}.
	 * @param ctx the parse tree
	 */
	void enterPrefixVar(ShExMLParser.PrefixVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#prefixVar}.
	 * @param ctx the parse tree
	 */
	void exitPrefixVar(ShExMLParser.PrefixVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ShExMLParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ShExMLParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ShExMLParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ShExMLParser.VariableContext ctx);
}