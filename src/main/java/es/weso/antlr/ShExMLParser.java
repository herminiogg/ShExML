// Generated from ShExML.g4 by ANTLR 4.7.1

package es.weso.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShExMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, PREFIX=2, SOURCE=3, QUERY=4, ITERATOR=5, FIELD=6, EXPRESSION=7, 
		UNION=8, JOIN=9, MATCHER=10, AS=11, MATCHING=12, QUERY_SET=13, EXPRESSION_SET=14, 
		LESS_SYMBOL=15, GREATER_SYMBOL=16, BRACKET_LEFT=17, BRACKET_RIGHT=18, 
		PAREN_LEFT=19, PAREN_RIGHT=20, BRACE_LEFT=21, BRACE_RIGHT=22, SEMICOLON=23, 
		DOT=24, AT=25, ADD=26, COMMA=27, QUOTE=28, STRING_OR_VAR=29, URI_VAR=30, 
		URL=31, STRINGOPERATOR=32, JSONPATH=33, XMLPATH=34, COMMENT=35, WS=36;
	public static final int
		RULE_shExML = 0, RULE_decl = 1, RULE_prefix = 2, RULE_source = 3, RULE_iterator = 4, 
		RULE_field = 5, RULE_query = 6, RULE_querySet = 7, RULE_expression = 8, 
		RULE_expressionSet = 9, RULE_matcher = 10, RULE_replacedStrings = 11, 
		RULE_exp = 12, RULE_stringOperation = 13, RULE_sourceQuery = 14, RULE_iteratorQuery = 15, 
		RULE_queryAlternative = 16, RULE_queryClause = 17, RULE_join = 18, RULE_union = 19, 
		RULE_leftUnionOption = 20, RULE_rightUnionOption = 21, RULE_shape = 22, 
		RULE_predicateObject = 23, RULE_objectElement = 24, RULE_shapeLink = 25, 
		RULE_predicate = 26, RULE_tripleElement = 27, RULE_prefixVar = 28, RULE_variable = 29, 
		RULE_variables = 30, RULE_queryParts = 31;
	public static final String[] ruleNames = {
		"shExML", "decl", "prefix", "source", "iterator", "field", "query", "querySet", 
		"expression", "expressionSet", "matcher", "replacedStrings", "exp", "stringOperation", 
		"sourceQuery", "iteratorQuery", "queryAlternative", "queryClause", "join", 
		"union", "leftUnionOption", "rightUnionOption", "shape", "predicateObject", 
		"objectElement", "shapeLink", "predicate", "tripleElement", "prefixVar", 
		"variable", "variables", "queryParts"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'/'", "'PREFIX'", "'SOURCE'", "'QUERY'", "'ITERATOR'", "'FIELD'", 
		"'EXPRESSION'", "'UNION'", "'JOIN'", "'MATCHER'", "'AS'", "'MATCHING'", 
		"'QUERY_SET'", "'EXPRESSION_SET'", "'<'", "'>'", "'['", "']'", "'('", 
		"')'", "'{'", "'}'", "';'", "'.'", "'@'", "'+'", "','", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "EXPRESSION", 
		"UNION", "JOIN", "MATCHER", "AS", "MATCHING", "QUERY_SET", "EXPRESSION_SET", 
		"LESS_SYMBOL", "GREATER_SYMBOL", "BRACKET_LEFT", "BRACKET_RIGHT", "PAREN_LEFT", 
		"PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "AT", 
		"ADD", "COMMA", "QUOTE", "STRING_OR_VAR", "URI_VAR", "URL", "STRINGOPERATOR", 
		"JSONPATH", "XMLPATH", "COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ShExML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShExMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ShExMLContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<ShapeContext> shape() {
			return getRuleContexts(ShapeContext.class);
		}
		public ShapeContext shape(int i) {
			return getRuleContext(ShapeContext.class,i);
		}
		public ShExMLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shExML; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterShExML(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitShExML(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitShExML(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShExMLContext shExML() throws RecognitionException {
		ShExMLContext _localctx = new ShExMLContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_shExML);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFIX) | (1L << SOURCE) | (1L << QUERY) | (1L << ITERATOR) | (1L << FIELD) | (1L << EXPRESSION) | (1L << MATCHER) | (1L << QUERY_SET) | (1L << EXPRESSION_SET))) != 0)) {
				{
				{
				setState(64);
				decl();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS_SYMBOL) | (1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL))) != 0)) {
				{
				{
				setState(70);
				shape();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public QuerySetContext querySet() {
			return getRuleContext(QuerySetContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionSetContext expressionSet() {
			return getRuleContext(ExpressionSetContext.class,0);
		}
		public MatcherContext matcher() {
			return getRuleContext(MatcherContext.class,0);
		}
		public IteratorContext iterator() {
			return getRuleContext(IteratorContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SOURCE:
				{
				setState(76);
				source();
				}
				break;
			case PREFIX:
				{
				setState(77);
				prefix();
				}
				break;
			case QUERY:
				{
				setState(78);
				query();
				}
				break;
			case QUERY_SET:
				{
				setState(79);
				querySet();
				}
				break;
			case EXPRESSION:
				{
				setState(80);
				expression();
				}
				break;
			case EXPRESSION_SET:
				{
				setState(81);
				expressionSet();
				}
				break;
			case MATCHER:
				{
				setState(82);
				matcher();
				}
				break;
			case ITERATOR:
				{
				setState(83);
				iterator();
				}
				break;
			case FIELD:
				{
				setState(84);
				field();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixContext extends ParserRuleContext {
		public TerminalNode PREFIX() { return getToken(ShExMLParser.PREFIX, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode URL() { return getToken(ShExMLParser.URL, 0); }
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(PREFIX);
			setState(88);
			variable();
			setState(89);
			match(LESS_SYMBOL);
			setState(90);
			match(URL);
			setState(91);
			match(GREATER_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceContext extends ParserRuleContext {
		public TerminalNode SOURCE() { return getToken(ShExMLParser.SOURCE, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode URL() { return getToken(ShExMLParser.URL, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitSource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(SOURCE);
			setState(94);
			variable();
			setState(95);
			match(LESS_SYMBOL);
			setState(96);
			match(URL);
			setState(97);
			match(GREATER_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IteratorContext extends ParserRuleContext {
		public TerminalNode ITERATOR() { return getToken(ShExMLParser.ITERATOR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public QueryClauseContext queryClause() {
			return getRuleContext(QueryClauseContext.class,0);
		}
		public IteratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterIterator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitIterator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitIterator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteratorContext iterator() throws RecognitionException {
		IteratorContext _localctx = new IteratorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_iterator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(ITERATOR);
			setState(100);
			variable();
			setState(101);
			match(LESS_SYMBOL);
			setState(102);
			queryClause();
			setState(103);
			match(GREATER_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode FIELD() { return getToken(ShExMLParser.FIELD, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public QueryPartsContext queryParts() {
			return getRuleContext(QueryPartsContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(FIELD);
			setState(106);
			variable();
			setState(107);
			match(LESS_SYMBOL);
			setState(108);
			queryParts();
			setState(109);
			match(GREATER_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public TerminalNode QUERY() { return getToken(ShExMLParser.QUERY, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public QueryClauseContext queryClause() {
			return getRuleContext(QueryClauseContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(QUERY);
			setState(112);
			variable();
			setState(113);
			match(LESS_SYMBOL);
			setState(114);
			queryClause();
			setState(115);
			match(GREATER_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySetContext extends ParserRuleContext {
		public TerminalNode QUERY_SET() { return getToken(ShExMLParser.QUERY_SET, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public QueryClauseContext queryClause() {
			return getRuleContext(QueryClauseContext.class,0);
		}
		public QuerySetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterQuerySet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitQuerySet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitQuerySet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuerySetContext querySet() throws RecognitionException {
		QuerySetContext _localctx = new QuerySetContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_querySet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(QUERY_SET);
			setState(118);
			variable();
			setState(119);
			match(LESS_SYMBOL);
			setState(120);
			queryClause();
			setState(121);
			match(GREATER_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode EXPRESSION() { return getToken(ShExMLParser.EXPRESSION, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(EXPRESSION);
			setState(124);
			variable();
			setState(125);
			match(LESS_SYMBOL);
			setState(126);
			exp();
			setState(127);
			match(GREATER_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionSetContext extends ParserRuleContext {
		public TerminalNode EXPRESSION_SET() { return getToken(ShExMLParser.EXPRESSION_SET, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpressionSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterExpressionSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitExpressionSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitExpressionSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionSetContext expressionSet() throws RecognitionException {
		ExpressionSetContext _localctx = new ExpressionSetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expressionSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(EXPRESSION_SET);
			setState(130);
			variable();
			setState(131);
			match(PAREN_LEFT);
			setState(132);
			variables();
			setState(133);
			match(PAREN_RIGHT);
			setState(134);
			match(LESS_SYMBOL);
			setState(135);
			exp();
			setState(136);
			match(GREATER_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatcherContext extends ParserRuleContext {
		public TerminalNode MATCHER() { return getToken(ShExMLParser.MATCHER, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ReplacedStringsContext replacedStrings() {
			return getRuleContext(ReplacedStringsContext.class,0);
		}
		public TerminalNode AS() { return getToken(ShExMLParser.AS, 0); }
		public TerminalNode STRING_OR_VAR() { return getToken(ShExMLParser.STRING_OR_VAR, 0); }
		public MatcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matcher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterMatcher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitMatcher(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitMatcher(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatcherContext matcher() throws RecognitionException {
		MatcherContext _localctx = new MatcherContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_matcher);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(MATCHER);
			setState(139);
			variable();
			setState(140);
			match(LESS_SYMBOL);
			setState(141);
			replacedStrings();
			setState(142);
			match(AS);
			setState(143);
			match(STRING_OR_VAR);
			setState(144);
			match(GREATER_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReplacedStringsContext extends ParserRuleContext {
		public TerminalNode STRING_OR_VAR() { return getToken(ShExMLParser.STRING_OR_VAR, 0); }
		public ReplacedStringsContext replacedStrings() {
			return getRuleContext(ReplacedStringsContext.class,0);
		}
		public ReplacedStringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_replacedStrings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterReplacedStrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitReplacedStrings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitReplacedStrings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReplacedStringsContext replacedStrings() throws RecognitionException {
		ReplacedStringsContext _localctx = new ReplacedStringsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_replacedStrings);
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(STRING_OR_VAR);
				setState(147);
				match(COMMA);
				setState(148);
				replacedStrings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(STRING_OR_VAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public SourceQueryContext sourceQuery() {
			return getRuleContext(SourceQueryContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public JoinContext join() {
			return getRuleContext(JoinContext.class,0);
		}
		public StringOperationContext stringOperation() {
			return getRuleContext(StringOperationContext.class,0);
		}
		public IteratorQueryContext iteratorQuery() {
			return getRuleContext(IteratorQueryContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exp);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				sourceQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				join();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				stringOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				iteratorQuery();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringOperationContext extends ParserRuleContext {
		public List<QueryAlternativeContext> queryAlternative() {
			return getRuleContexts(QueryAlternativeContext.class);
		}
		public QueryAlternativeContext queryAlternative(int i) {
			return getRuleContext(QueryAlternativeContext.class,i);
		}
		public TerminalNode STRINGOPERATOR() { return getToken(ShExMLParser.STRINGOPERATOR, 0); }
		public StringOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterStringOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitStringOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitStringOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringOperationContext stringOperation() throws RecognitionException {
		StringOperationContext _localctx = new StringOperationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stringOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			queryAlternative();
			setState(160);
			match(ADD);
			setState(161);
			match(STRINGOPERATOR);
			setState(162);
			match(ADD);
			setState(163);
			queryAlternative();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceQueryContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public SourceQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterSourceQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitSourceQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitSourceQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceQueryContext sourceQuery() throws RecognitionException {
		SourceQueryContext _localctx = new SourceQueryContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sourceQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			variable();
			setState(166);
			match(DOT);
			setState(167);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IteratorQueryContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public IteratorQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteratorQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterIteratorQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitIteratorQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitIteratorQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteratorQueryContext iteratorQuery() throws RecognitionException {
		IteratorQueryContext _localctx = new IteratorQueryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_iteratorQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			variable();
			setState(170);
			match(DOT);
			setState(171);
			variable();
			setState(172);
			match(DOT);
			setState(173);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryAlternativeContext extends ParserRuleContext {
		public SourceQueryContext sourceQuery() {
			return getRuleContext(SourceQueryContext.class,0);
		}
		public IteratorQueryContext iteratorQuery() {
			return getRuleContext(IteratorQueryContext.class,0);
		}
		public QueryAlternativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryAlternative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterQueryAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitQueryAlternative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitQueryAlternative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryAlternativeContext queryAlternative() throws RecognitionException {
		QueryAlternativeContext _localctx = new QueryAlternativeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_queryAlternative);
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				sourceQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				iteratorQuery();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryClauseContext extends ParserRuleContext {
		public TerminalNode JSONPATH() { return getToken(ShExMLParser.JSONPATH, 0); }
		public TerminalNode XMLPATH() { return getToken(ShExMLParser.XMLPATH, 0); }
		public QueryClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterQueryClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitQueryClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitQueryClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryClauseContext queryClause() throws RecognitionException {
		QueryClauseContext _localctx = new QueryClauseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_queryClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_la = _input.LA(1);
			if ( !(_la==JSONPATH || _la==XMLPATH) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinContext extends ParserRuleContext {
		public List<QueryAlternativeContext> queryAlternative() {
			return getRuleContexts(QueryAlternativeContext.class);
		}
		public QueryAlternativeContext queryAlternative(int i) {
			return getRuleContext(QueryAlternativeContext.class,i);
		}
		public TerminalNode UNION() { return getToken(ShExMLParser.UNION, 0); }
		public TerminalNode JOIN() { return getToken(ShExMLParser.JOIN, 0); }
		public JoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitJoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinContext join() throws RecognitionException {
		JoinContext _localctx = new JoinContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			queryAlternative();
			setState(182);
			match(UNION);
			setState(183);
			queryAlternative();
			setState(184);
			match(JOIN);
			setState(185);
			queryAlternative();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionContext extends ParserRuleContext {
		public LeftUnionOptionContext leftUnionOption() {
			return getRuleContext(LeftUnionOptionContext.class,0);
		}
		public TerminalNode UNION() { return getToken(ShExMLParser.UNION, 0); }
		public RightUnionOptionContext rightUnionOption() {
			return getRuleContext(RightUnionOptionContext.class,0);
		}
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			leftUnionOption();
			setState(188);
			match(UNION);
			setState(189);
			rightUnionOption();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeftUnionOptionContext extends ParserRuleContext {
		public QueryAlternativeContext queryAlternative() {
			return getRuleContext(QueryAlternativeContext.class,0);
		}
		public StringOperationContext stringOperation() {
			return getRuleContext(StringOperationContext.class,0);
		}
		public LeftUnionOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftUnionOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterLeftUnionOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitLeftUnionOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitLeftUnionOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftUnionOptionContext leftUnionOption() throws RecognitionException {
		LeftUnionOptionContext _localctx = new LeftUnionOptionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_leftUnionOption);
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				queryAlternative();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				stringOperation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RightUnionOptionContext extends ParserRuleContext {
		public QueryAlternativeContext queryAlternative() {
			return getRuleContext(QueryAlternativeContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public StringOperationContext stringOperation() {
			return getRuleContext(StringOperationContext.class,0);
		}
		public RightUnionOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightUnionOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterRightUnionOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitRightUnionOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitRightUnionOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightUnionOptionContext rightUnionOption() throws RecognitionException {
		RightUnionOptionContext _localctx = new RightUnionOptionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_rightUnionOption);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				queryAlternative();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				stringOperation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShapeContext extends ParserRuleContext {
		public TripleElementContext tripleElement() {
			return getRuleContext(TripleElementContext.class,0);
		}
		public PrefixVarContext prefixVar() {
			return getRuleContext(PrefixVarContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<PredicateObjectContext> predicateObject() {
			return getRuleContexts(PredicateObjectContext.class);
		}
		public PredicateObjectContext predicateObject(int i) {
			return getRuleContext(PredicateObjectContext.class,i);
		}
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitShape(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitShape(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeContext shape() throws RecognitionException {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_shape);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			tripleElement();
			setState(201);
			prefixVar();
			setState(202);
			match(BRACKET_LEFT);
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(203);
				exp();
				}
				break;
			case 2:
				{
				setState(204);
				variable();
				}
				break;
			}
			setState(207);
			match(BRACKET_RIGHT);
			setState(208);
			match(BRACE_LEFT);
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(209);
					predicateObject();
					setState(210);
					match(SEMICOLON);
					}
					} 
				}
				setState(216);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL))) != 0)) {
				{
				setState(217);
				predicateObject();
				}
			}

			setState(220);
			match(BRACE_RIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateObjectContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ObjectElementContext objectElement() {
			return getRuleContext(ObjectElementContext.class,0);
		}
		public ShapeLinkContext shapeLink() {
			return getRuleContext(ShapeLinkContext.class,0);
		}
		public PredicateObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterPredicateObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitPredicateObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitPredicateObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateObjectContext predicateObject() throws RecognitionException {
		PredicateObjectContext _localctx = new PredicateObjectContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_predicateObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			predicate();
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT:
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
				{
				setState(223);
				objectElement();
				}
				break;
			case AT:
				{
				setState(224);
				shapeLink();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectElementContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public PrefixVarContext prefixVar() {
			return getRuleContext(PrefixVarContext.class,0);
		}
		public TerminalNode MATCHING() { return getToken(ShExMLParser.MATCHING, 0); }
		public ObjectElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterObjectElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitObjectElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitObjectElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectElementContext objectElement() throws RecognitionException {
		ObjectElementContext _localctx = new ObjectElementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_objectElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL))) != 0)) {
				{
				setState(227);
				prefixVar();
				}
			}

			setState(230);
			match(BRACKET_LEFT);
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(231);
				exp();
				}
				break;
			case 2:
				{
				setState(232);
				variable();
				}
				break;
			}
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MATCHING) {
				{
				setState(235);
				match(MATCHING);
				setState(236);
				variable();
				}
			}

			setState(239);
			match(BRACKET_RIGHT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShapeLinkContext extends ParserRuleContext {
		public TripleElementContext tripleElement() {
			return getRuleContext(TripleElementContext.class,0);
		}
		public ShapeLinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shapeLink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterShapeLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitShapeLink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitShapeLink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeLinkContext shapeLink() throws RecognitionException {
		ShapeLinkContext _localctx = new ShapeLinkContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_shapeLink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(AT);
			setState(242);
			tripleElement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public PrefixVarContext prefixVar() {
			return getRuleContext(PrefixVarContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			prefixVar();
			setState(245);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TripleElementContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TripleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tripleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterTripleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitTripleElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitTripleElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TripleElementContext tripleElement() throws RecognitionException {
		TripleElementContext _localctx = new TripleElementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_tripleElement);
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				predicate();
				}
				break;
			case LESS_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				match(LESS_SYMBOL);
				setState(249);
				variable();
				setState(250);
				match(GREATER_SYMBOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixVarContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode URL() { return getToken(ShExMLParser.URL, 0); }
		public PrefixVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterPrefixVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitPrefixVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitPrefixVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixVarContext prefixVar() throws RecognitionException {
		PrefixVarContext _localctx = new PrefixVarContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_prefixVar);
		try {
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				variable();
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(URL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode STRING_OR_VAR() { return getToken(ShExMLParser.STRING_OR_VAR, 0); }
		public TerminalNode URI_VAR() { return getToken(ShExMLParser.URI_VAR, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			_la = _input.LA(1);
			if ( !(_la==STRING_OR_VAR || _la==URI_VAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariablesContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VariablesContext variables() {
			return getRuleContext(VariablesContext.class,0);
		}
		public VariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariablesContext variables() throws RecognitionException {
		VariablesContext _localctx = new VariablesContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_variables);
		try {
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				variable();
				setState(262);
				match(COMMA);
				setState(263);
				variables();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryPartsContext extends ParserRuleContext {
		public TerminalNode STRING_OR_VAR() { return getToken(ShExMLParser.STRING_OR_VAR, 0); }
		public QueryPartsContext queryParts() {
			return getRuleContext(QueryPartsContext.class,0);
		}
		public QueryPartsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryParts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterQueryParts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitQueryParts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitQueryParts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryPartsContext queryParts() throws RecognitionException {
		QueryPartsContext _localctx = new QueryPartsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_queryParts);
		int _la;
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(267);
					match(AT);
					}
				}

				setState(270);
				match(STRING_OR_VAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(271);
					match(AT);
					}
				}

				setState(274);
				match(STRING_OR_VAR);
				setState(275);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==DOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(276);
				queryParts();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u011a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\7\2D\n\2\f\2\16\2G\13\2\3\2\7\2J\n\2\f\2\16\2M\13\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3X\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\5\r\u0099\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u00a0\n"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\5\22\u00b4\n\22\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\5\26\u00c4\n\26\3\27\3\27\3\27"+
		"\5\27\u00c9\n\27\3\30\3\30\3\30\3\30\3\30\5\30\u00d0\n\30\3\30\3\30\3"+
		"\30\3\30\3\30\7\30\u00d7\n\30\f\30\16\30\u00da\13\30\3\30\5\30\u00dd\n"+
		"\30\3\30\3\30\3\31\3\31\3\31\5\31\u00e4\n\31\3\32\5\32\u00e7\n\32\3\32"+
		"\3\32\3\32\5\32\u00ec\n\32\3\32\3\32\5\32\u00f0\n\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5\35\u00ff\n\35\3\36"+
		"\3\36\5\36\u0103\n\36\3\37\3\37\3 \3 \3 \3 \3 \5 \u010c\n \3!\5!\u010f"+
		"\n!\3!\3!\5!\u0113\n!\3!\3!\3!\5!\u0118\n!\3!\2\2\"\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\5\3\2#$\3\2\37 \4\2"+
		"\3\3\32\32\2\u0119\2E\3\2\2\2\4W\3\2\2\2\6Y\3\2\2\2\b_\3\2\2\2\ne\3\2"+
		"\2\2\fk\3\2\2\2\16q\3\2\2\2\20w\3\2\2\2\22}\3\2\2\2\24\u0083\3\2\2\2\26"+
		"\u008c\3\2\2\2\30\u0098\3\2\2\2\32\u009f\3\2\2\2\34\u00a1\3\2\2\2\36\u00a7"+
		"\3\2\2\2 \u00ab\3\2\2\2\"\u00b3\3\2\2\2$\u00b5\3\2\2\2&\u00b7\3\2\2\2"+
		"(\u00bd\3\2\2\2*\u00c3\3\2\2\2,\u00c8\3\2\2\2.\u00ca\3\2\2\2\60\u00e0"+
		"\3\2\2\2\62\u00e6\3\2\2\2\64\u00f3\3\2\2\2\66\u00f6\3\2\2\28\u00fe\3\2"+
		"\2\2:\u0102\3\2\2\2<\u0104\3\2\2\2>\u010b\3\2\2\2@\u0117\3\2\2\2BD\5\4"+
		"\3\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FK\3\2\2\2GE\3\2\2\2HJ\5."+
		"\30\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\3\3\2\2\2MK\3\2\2\2NX\5"+
		"\b\5\2OX\5\6\4\2PX\5\16\b\2QX\5\20\t\2RX\5\22\n\2SX\5\24\13\2TX\5\26\f"+
		"\2UX\5\n\6\2VX\5\f\7\2WN\3\2\2\2WO\3\2\2\2WP\3\2\2\2WQ\3\2\2\2WR\3\2\2"+
		"\2WS\3\2\2\2WT\3\2\2\2WU\3\2\2\2WV\3\2\2\2X\5\3\2\2\2YZ\7\4\2\2Z[\5<\37"+
		"\2[\\\7\21\2\2\\]\7!\2\2]^\7\22\2\2^\7\3\2\2\2_`\7\5\2\2`a\5<\37\2ab\7"+
		"\21\2\2bc\7!\2\2cd\7\22\2\2d\t\3\2\2\2ef\7\7\2\2fg\5<\37\2gh\7\21\2\2"+
		"hi\5$\23\2ij\7\22\2\2j\13\3\2\2\2kl\7\b\2\2lm\5<\37\2mn\7\21\2\2no\5@"+
		"!\2op\7\22\2\2p\r\3\2\2\2qr\7\6\2\2rs\5<\37\2st\7\21\2\2tu\5$\23\2uv\7"+
		"\22\2\2v\17\3\2\2\2wx\7\17\2\2xy\5<\37\2yz\7\21\2\2z{\5$\23\2{|\7\22\2"+
		"\2|\21\3\2\2\2}~\7\t\2\2~\177\5<\37\2\177\u0080\7\21\2\2\u0080\u0081\5"+
		"\32\16\2\u0081\u0082\7\22\2\2\u0082\23\3\2\2\2\u0083\u0084\7\20\2\2\u0084"+
		"\u0085\5<\37\2\u0085\u0086\7\25\2\2\u0086\u0087\5> \2\u0087\u0088\7\26"+
		"\2\2\u0088\u0089\7\21\2\2\u0089\u008a\5\32\16\2\u008a\u008b\7\22\2\2\u008b"+
		"\25\3\2\2\2\u008c\u008d\7\f\2\2\u008d\u008e\5<\37\2\u008e\u008f\7\21\2"+
		"\2\u008f\u0090\5\30\r\2\u0090\u0091\7\r\2\2\u0091\u0092\7\37\2\2\u0092"+
		"\u0093\7\22\2\2\u0093\27\3\2\2\2\u0094\u0095\7\37\2\2\u0095\u0096\7\35"+
		"\2\2\u0096\u0099\5\30\r\2\u0097\u0099\7\37\2\2\u0098\u0094\3\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\31\3\2\2\2\u009a\u00a0\5\36\20\2\u009b\u00a0\5(\25"+
		"\2\u009c\u00a0\5&\24\2\u009d\u00a0\5\34\17\2\u009e\u00a0\5 \21\2\u009f"+
		"\u009a\3\2\2\2\u009f\u009b\3\2\2\2\u009f\u009c\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u009e\3\2\2\2\u00a0\33\3\2\2\2\u00a1\u00a2\5\"\22\2\u00a2\u00a3"+
		"\7\34\2\2\u00a3\u00a4\7\"\2\2\u00a4\u00a5\7\34\2\2\u00a5\u00a6\5\"\22"+
		"\2\u00a6\35\3\2\2\2\u00a7\u00a8\5<\37\2\u00a8\u00a9\7\32\2\2\u00a9\u00aa"+
		"\5<\37\2\u00aa\37\3\2\2\2\u00ab\u00ac\5<\37\2\u00ac\u00ad\7\32\2\2\u00ad"+
		"\u00ae\5<\37\2\u00ae\u00af\7\32\2\2\u00af\u00b0\5<\37\2\u00b0!\3\2\2\2"+
		"\u00b1\u00b4\5\36\20\2\u00b2\u00b4\5 \21\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2"+
		"\3\2\2\2\u00b4#\3\2\2\2\u00b5\u00b6\t\2\2\2\u00b6%\3\2\2\2\u00b7\u00b8"+
		"\5\"\22\2\u00b8\u00b9\7\n\2\2\u00b9\u00ba\5\"\22\2\u00ba\u00bb\7\13\2"+
		"\2\u00bb\u00bc\5\"\22\2\u00bc\'\3\2\2\2\u00bd\u00be\5*\26\2\u00be\u00bf"+
		"\7\n\2\2\u00bf\u00c0\5,\27\2\u00c0)\3\2\2\2\u00c1\u00c4\5\"\22\2\u00c2"+
		"\u00c4\5\34\17\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4+\3\2\2"+
		"\2\u00c5\u00c9\5\"\22\2\u00c6\u00c9\5(\25\2\u00c7\u00c9\5\34\17\2\u00c8"+
		"\u00c5\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9-\3\2\2\2"+
		"\u00ca\u00cb\58\35\2\u00cb\u00cc\5:\36\2\u00cc\u00cf\7\23\2\2\u00cd\u00d0"+
		"\5\32\16\2\u00ce\u00d0\5<\37\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2"+
		"\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7\24\2\2\u00d2\u00d8\7\27\2\2\u00d3\u00d4"+
		"\5\60\31\2\u00d4\u00d5\7\31\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d3\3\2\2"+
		"\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00dc"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dd\5\60\31\2\u00dc\u00db\3\2\2\2"+
		"\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\7\30\2\2\u00df/\3"+
		"\2\2\2\u00e0\u00e3\5\66\34\2\u00e1\u00e4\5\62\32\2\u00e2\u00e4\5\64\33"+
		"\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\61\3\2\2\2\u00e5\u00e7"+
		"\5:\36\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00eb\7\23\2\2\u00e9\u00ec\5\32\16\2\u00ea\u00ec\5<\37\2\u00eb\u00e9"+
		"\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00ee\7\16\2\2"+
		"\u00ee\u00f0\5<\37\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1"+
		"\3\2\2\2\u00f1\u00f2\7\24\2\2\u00f2\63\3\2\2\2\u00f3\u00f4\7\33\2\2\u00f4"+
		"\u00f5\58\35\2\u00f5\65\3\2\2\2\u00f6\u00f7\5:\36\2\u00f7\u00f8\5<\37"+
		"\2\u00f8\67\3\2\2\2\u00f9\u00ff\5\66\34\2\u00fa\u00fb\7\21\2\2\u00fb\u00fc"+
		"\5<\37\2\u00fc\u00fd\7\22\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00f9\3\2\2\2"+
		"\u00fe\u00fa\3\2\2\2\u00ff9\3\2\2\2\u0100\u0103\5<\37\2\u0101\u0103\7"+
		"!\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103;\3\2\2\2\u0104\u0105"+
		"\t\3\2\2\u0105=\3\2\2\2\u0106\u010c\5<\37\2\u0107\u0108\5<\37\2\u0108"+
		"\u0109\7\35\2\2\u0109\u010a\5> \2\u010a\u010c\3\2\2\2\u010b\u0106\3\2"+
		"\2\2\u010b\u0107\3\2\2\2\u010c?\3\2\2\2\u010d\u010f\7\33\2\2\u010e\u010d"+
		"\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0118\7\37\2\2"+
		"\u0111\u0113\7\33\2\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114"+
		"\3\2\2\2\u0114\u0115\7\37\2\2\u0115\u0116\t\4\2\2\u0116\u0118\5@!\2\u0117"+
		"\u010e\3\2\2\2\u0117\u0112\3\2\2\2\u0118A\3\2\2\2\27EKW\u0098\u009f\u00b3"+
		"\u00c3\u00c8\u00cf\u00d8\u00dc\u00e3\u00e6\u00eb\u00ef\u00fe\u0102\u010b"+
		"\u010e\u0112\u0117";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}