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
		PREFIX=1, SOURCE=2, QUERY=3, EXPRESSION=4, UNION=5, JOIN=6, MATCHER=7, 
		AS=8, MATCHING=9, QUERY_SET=10, EXPRESSION_SET=11, LESS_SYMBOL=12, GREATER_SYMBOL=13, 
		DOLLAR=14, BRACKET_LEFT=15, BRACKET_RIGHT=16, PAREN_LEFT=17, PAREN_RIGHT=18, 
		BRACE_LEFT=19, BRACE_RIGHT=20, SEMICOLON=21, DOT=22, AT=23, ADD=24, COMMA=25, 
		QUOTE=26, STRING_OR_VAR=27, URI_VAR=28, JSONPATH=29, XMLPATH=30, URL=31, 
		STRINGOPERATOR=32, COMMENT=33, WS=34;
	public static final int
		RULE_shExML = 0, RULE_decl = 1, RULE_prefix = 2, RULE_source = 3, RULE_query = 4, 
		RULE_querySet = 5, RULE_expression = 6, RULE_expressionSet = 7, RULE_matcher = 8, 
		RULE_replacedStrings = 9, RULE_exp = 10, RULE_stringOperation = 11, RULE_sourceQuery = 12, 
		RULE_join = 13, RULE_union = 14, RULE_leftUnionOption = 15, RULE_rightUnionOption = 16, 
		RULE_shape = 17, RULE_predicateObject = 18, RULE_objectElement = 19, RULE_shapeLink = 20, 
		RULE_predicate = 21, RULE_fileSource = 22, RULE_queryClause = 23, RULE_tripleElement = 24, 
		RULE_prefixVar = 25, RULE_variable = 26, RULE_variables = 27;
	public static final String[] ruleNames = {
		"shExML", "decl", "prefix", "source", "query", "querySet", "expression", 
		"expressionSet", "matcher", "replacedStrings", "exp", "stringOperation", 
		"sourceQuery", "join", "union", "leftUnionOption", "rightUnionOption", 
		"shape", "predicateObject", "objectElement", "shapeLink", "predicate", 
		"fileSource", "queryClause", "tripleElement", "prefixVar", "variable", 
		"variables"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'PREFIX'", "'SOURCE'", "'QUERY'", "'EXPRESSION'", "'UNION'", "'JOIN'", 
		"'MATCHER'", "'AS'", "'MATCHING'", "'QUERY_SET'", "'EXPRESSION_SET'", 
		"'<'", "'>'", "'$'", "'['", "']'", "'('", "')'", "'{'", "'}'", "';'", 
		"'.'", "'@'", "'+'", "','", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PREFIX", "SOURCE", "QUERY", "EXPRESSION", "UNION", "JOIN", "MATCHER", 
		"AS", "MATCHING", "QUERY_SET", "EXPRESSION_SET", "LESS_SYMBOL", "GREATER_SYMBOL", 
		"DOLLAR", "BRACKET_LEFT", "BRACKET_RIGHT", "PAREN_LEFT", "PAREN_RIGHT", 
		"BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "AT", "ADD", "COMMA", 
		"QUOTE", "STRING_OR_VAR", "URI_VAR", "JSONPATH", "XMLPATH", "URL", "STRINGOPERATOR", 
		"COMMENT", "WS"
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFIX) | (1L << SOURCE) | (1L << QUERY) | (1L << EXPRESSION) | (1L << MATCHER) | (1L << QUERY_SET) | (1L << EXPRESSION_SET))) != 0)) {
				{
				{
				setState(56);
				decl();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS_SYMBOL) | (1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL))) != 0)) {
				{
				{
				setState(62);
				shape();
				}
				}
				setState(67);
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
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SOURCE:
				{
				setState(68);
				source();
				}
				break;
			case PREFIX:
				{
				setState(69);
				prefix();
				}
				break;
			case QUERY:
				{
				setState(70);
				query();
				}
				break;
			case QUERY_SET:
				{
				setState(71);
				querySet();
				}
				break;
			case EXPRESSION:
				{
				setState(72);
				expression();
				}
				break;
			case EXPRESSION_SET:
				{
				setState(73);
				expressionSet();
				}
				break;
			case MATCHER:
				{
				setState(74);
				matcher();
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
			setState(77);
			match(PREFIX);
			setState(78);
			variable();
			setState(79);
			match(LESS_SYMBOL);
			setState(80);
			match(URL);
			setState(81);
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
		public FileSourceContext fileSource() {
			return getRuleContext(FileSourceContext.class,0);
		}
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
			setState(83);
			match(SOURCE);
			setState(84);
			variable();
			setState(85);
			match(LESS_SYMBOL);
			setState(86);
			fileSource();
			setState(87);
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
		enterRule(_localctx, 8, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(QUERY);
			setState(90);
			variable();
			setState(91);
			match(LESS_SYMBOL);
			setState(92);
			queryClause();
			setState(93);
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
		enterRule(_localctx, 10, RULE_querySet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(QUERY_SET);
			setState(96);
			variable();
			setState(97);
			match(LESS_SYMBOL);
			setState(98);
			queryClause();
			setState(99);
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
		enterRule(_localctx, 12, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(EXPRESSION);
			setState(102);
			variable();
			setState(103);
			match(LESS_SYMBOL);
			setState(104);
			exp();
			setState(105);
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
		enterRule(_localctx, 14, RULE_expressionSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(EXPRESSION_SET);
			setState(108);
			variable();
			setState(109);
			match(PAREN_LEFT);
			setState(110);
			variables();
			setState(111);
			match(PAREN_RIGHT);
			setState(112);
			match(LESS_SYMBOL);
			setState(113);
			exp();
			setState(114);
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
		enterRule(_localctx, 16, RULE_matcher);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(MATCHER);
			setState(117);
			variable();
			setState(118);
			match(LESS_SYMBOL);
			setState(119);
			replacedStrings();
			setState(120);
			match(AS);
			setState(121);
			match(STRING_OR_VAR);
			setState(122);
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
		enterRule(_localctx, 18, RULE_replacedStrings);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(STRING_OR_VAR);
				setState(125);
				match(COMMA);
				setState(126);
				replacedStrings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
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
		enterRule(_localctx, 20, RULE_exp);
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				sourceQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				join();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
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

	public static class StringOperationContext extends ParserRuleContext {
		public List<SourceQueryContext> sourceQuery() {
			return getRuleContexts(SourceQueryContext.class);
		}
		public SourceQueryContext sourceQuery(int i) {
			return getRuleContext(SourceQueryContext.class,i);
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
		enterRule(_localctx, 22, RULE_stringOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			sourceQuery();
			setState(137);
			match(ADD);
			setState(138);
			match(STRINGOPERATOR);
			setState(139);
			match(ADD);
			setState(140);
			sourceQuery();
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
		enterRule(_localctx, 24, RULE_sourceQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(DOLLAR);
			setState(143);
			variable();
			setState(144);
			match(DOT);
			setState(145);
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

	public static class JoinContext extends ParserRuleContext {
		public List<SourceQueryContext> sourceQuery() {
			return getRuleContexts(SourceQueryContext.class);
		}
		public SourceQueryContext sourceQuery(int i) {
			return getRuleContext(SourceQueryContext.class,i);
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
		enterRule(_localctx, 26, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			sourceQuery();
			setState(148);
			match(UNION);
			setState(149);
			sourceQuery();
			setState(150);
			match(JOIN);
			setState(151);
			sourceQuery();
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
		enterRule(_localctx, 28, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			leftUnionOption();
			setState(154);
			match(UNION);
			setState(155);
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
		public SourceQueryContext sourceQuery() {
			return getRuleContext(SourceQueryContext.class,0);
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
		enterRule(_localctx, 30, RULE_leftUnionOption);
		try {
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				sourceQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
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
		public SourceQueryContext sourceQuery() {
			return getRuleContext(SourceQueryContext.class,0);
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
		enterRule(_localctx, 32, RULE_rightUnionOption);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				sourceQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
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
		enterRule(_localctx, 34, RULE_shape);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			tripleElement();
			setState(167);
			prefixVar();
			setState(168);
			match(BRACKET_LEFT);
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				setState(169);
				exp();
				}
				break;
			case STRING_OR_VAR:
			case URI_VAR:
				{
				setState(170);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(173);
			match(BRACKET_RIGHT);
			setState(174);
			match(BRACE_LEFT);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(175);
					predicateObject();
					setState(176);
					match(SEMICOLON);
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL))) != 0)) {
				{
				setState(183);
				predicateObject();
				}
			}

			setState(186);
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
		enterRule(_localctx, 36, RULE_predicateObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			predicate();
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT:
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
				{
				setState(189);
				objectElement();
				}
				break;
			case AT:
				{
				setState(190);
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
		enterRule(_localctx, 38, RULE_objectElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL))) != 0)) {
				{
				setState(193);
				prefixVar();
				}
			}

			setState(196);
			match(BRACKET_LEFT);
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				setState(197);
				exp();
				}
				break;
			case STRING_OR_VAR:
			case URI_VAR:
				{
				setState(198);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MATCHING) {
				{
				setState(201);
				match(MATCHING);
				setState(202);
				variable();
				}
			}

			setState(205);
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
		enterRule(_localctx, 40, RULE_shapeLink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(AT);
			setState(208);
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
		enterRule(_localctx, 42, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			prefixVar();
			setState(211);
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

	public static class FileSourceContext extends ParserRuleContext {
		public TerminalNode URL() { return getToken(ShExMLParser.URL, 0); }
		public FileSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).enterFileSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLListener ) ((ShExMLListener)listener).exitFileSource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLVisitor ) return ((ShExMLVisitor<? extends T>)visitor).visitFileSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileSourceContext fileSource() throws RecognitionException {
		FileSourceContext _localctx = new FileSourceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_fileSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(URL);
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
		enterRule(_localctx, 46, RULE_queryClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
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
		enterRule(_localctx, 48, RULE_tripleElement);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				predicate();
				}
				break;
			case LESS_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(LESS_SYMBOL);
				setState(219);
				variable();
				setState(220);
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
		enterRule(_localctx, 50, RULE_prefixVar);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				variable();
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
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
		enterRule(_localctx, 52, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
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
		enterRule(_localctx, 54, RULE_variables);
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				variable();
				setState(232);
				match(COMMA);
				setState(233);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00f0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\2\7\2B\n\2\f\2\16\2E\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3N\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u0083"+
		"\n\13\3\f\3\f\3\f\3\f\5\f\u0089\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\5\21\u00a2\n\21\3\22\3\22\3\22\5\22\u00a7\n\22\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u00ae\n\23\3\23\3\23\3\23\3\23\3\23\7\23\u00b5\n\23\f\23"+
		"\16\23\u00b8\13\23\3\23\5\23\u00bb\n\23\3\23\3\23\3\24\3\24\3\24\5\24"+
		"\u00c2\n\24\3\25\5\25\u00c5\n\25\3\25\3\25\3\25\5\25\u00ca\n\25\3\25\3"+
		"\25\5\25\u00ce\n\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\5\32\u00e1\n\32\3\33\3\33\5\33\u00e5"+
		"\n\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5\35\u00ee\n\35\3\35\2\2\36\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\4\3\2\37"+
		" \3\2\35\36\2\u00ec\2=\3\2\2\2\4M\3\2\2\2\6O\3\2\2\2\bU\3\2\2\2\n[\3\2"+
		"\2\2\fa\3\2\2\2\16g\3\2\2\2\20m\3\2\2\2\22v\3\2\2\2\24\u0082\3\2\2\2\26"+
		"\u0088\3\2\2\2\30\u008a\3\2\2\2\32\u0090\3\2\2\2\34\u0095\3\2\2\2\36\u009b"+
		"\3\2\2\2 \u00a1\3\2\2\2\"\u00a6\3\2\2\2$\u00a8\3\2\2\2&\u00be\3\2\2\2"+
		"(\u00c4\3\2\2\2*\u00d1\3\2\2\2,\u00d4\3\2\2\2.\u00d7\3\2\2\2\60\u00d9"+
		"\3\2\2\2\62\u00e0\3\2\2\2\64\u00e4\3\2\2\2\66\u00e6\3\2\2\28\u00ed\3\2"+
		"\2\2:<\5\4\3\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>C\3\2\2\2?=\3\2"+
		"\2\2@B\5$\23\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\3\3\2\2\2EC\3"+
		"\2\2\2FN\5\b\5\2GN\5\6\4\2HN\5\n\6\2IN\5\f\7\2JN\5\16\b\2KN\5\20\t\2L"+
		"N\5\22\n\2MF\3\2\2\2MG\3\2\2\2MH\3\2\2\2MI\3\2\2\2MJ\3\2\2\2MK\3\2\2\2"+
		"ML\3\2\2\2N\5\3\2\2\2OP\7\3\2\2PQ\5\66\34\2QR\7\16\2\2RS\7!\2\2ST\7\17"+
		"\2\2T\7\3\2\2\2UV\7\4\2\2VW\5\66\34\2WX\7\16\2\2XY\5.\30\2YZ\7\17\2\2"+
		"Z\t\3\2\2\2[\\\7\5\2\2\\]\5\66\34\2]^\7\16\2\2^_\5\60\31\2_`\7\17\2\2"+
		"`\13\3\2\2\2ab\7\f\2\2bc\5\66\34\2cd\7\16\2\2de\5\60\31\2ef\7\17\2\2f"+
		"\r\3\2\2\2gh\7\6\2\2hi\5\66\34\2ij\7\16\2\2jk\5\26\f\2kl\7\17\2\2l\17"+
		"\3\2\2\2mn\7\r\2\2no\5\66\34\2op\7\23\2\2pq\58\35\2qr\7\24\2\2rs\7\16"+
		"\2\2st\5\26\f\2tu\7\17\2\2u\21\3\2\2\2vw\7\t\2\2wx\5\66\34\2xy\7\16\2"+
		"\2yz\5\24\13\2z{\7\n\2\2{|\7\35\2\2|}\7\17\2\2}\23\3\2\2\2~\177\7\35\2"+
		"\2\177\u0080\7\33\2\2\u0080\u0083\5\24\13\2\u0081\u0083\7\35\2\2\u0082"+
		"~\3\2\2\2\u0082\u0081\3\2\2\2\u0083\25\3\2\2\2\u0084\u0089\5\32\16\2\u0085"+
		"\u0089\5\36\20\2\u0086\u0089\5\34\17\2\u0087\u0089\5\30\r\2\u0088\u0084"+
		"\3\2\2\2\u0088\u0085\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089"+
		"\27\3\2\2\2\u008a\u008b\5\32\16\2\u008b\u008c\7\32\2\2\u008c\u008d\7\""+
		"\2\2\u008d\u008e\7\32\2\2\u008e\u008f\5\32\16\2\u008f\31\3\2\2\2\u0090"+
		"\u0091\7\20\2\2\u0091\u0092\5\66\34\2\u0092\u0093\7\30\2\2\u0093\u0094"+
		"\5\66\34\2\u0094\33\3\2\2\2\u0095\u0096\5\32\16\2\u0096\u0097\7\7\2\2"+
		"\u0097\u0098\5\32\16\2\u0098\u0099\7\b\2\2\u0099\u009a\5\32\16\2\u009a"+
		"\35\3\2\2\2\u009b\u009c\5 \21\2\u009c\u009d\7\7\2\2\u009d\u009e\5\"\22"+
		"\2\u009e\37\3\2\2\2\u009f\u00a2\5\32\16\2\u00a0\u00a2\5\30\r\2\u00a1\u009f"+
		"\3\2\2\2\u00a1\u00a0\3\2\2\2\u00a2!\3\2\2\2\u00a3\u00a7\5\32\16\2\u00a4"+
		"\u00a7\5\36\20\2\u00a5\u00a7\5\30\r\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7#\3\2\2\2\u00a8\u00a9\5\62\32\2\u00a9"+
		"\u00aa\5\64\33\2\u00aa\u00ad\7\21\2\2\u00ab\u00ae\5\26\f\2\u00ac\u00ae"+
		"\5\66\34\2\u00ad\u00ab\3\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2"+
		"\u00af\u00b0\7\22\2\2\u00b0\u00b6\7\25\2\2\u00b1\u00b2\5&\24\2\u00b2\u00b3"+
		"\7\27\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b5\u00b8\3\2\2\2"+
		"\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6"+
		"\3\2\2\2\u00b9\u00bb\5&\24\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00bd\7\26\2\2\u00bd%\3\2\2\2\u00be\u00c1\5,\27\2"+
		"\u00bf\u00c2\5(\25\2\u00c0\u00c2\5*\26\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0"+
		"\3\2\2\2\u00c2\'\3\2\2\2\u00c3\u00c5\5\64\33\2\u00c4\u00c3\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c9\7\21\2\2\u00c7\u00ca\5"+
		"\26\f\2\u00c8\u00ca\5\66\34\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2"+
		"\u00ca\u00cd\3\2\2\2\u00cb\u00cc\7\13\2\2\u00cc\u00ce\5\66\34\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\7\22"+
		"\2\2\u00d0)\3\2\2\2\u00d1\u00d2\7\31\2\2\u00d2\u00d3\5\62\32\2\u00d3+"+
		"\3\2\2\2\u00d4\u00d5\5\64\33\2\u00d5\u00d6\5\66\34\2\u00d6-\3\2\2\2\u00d7"+
		"\u00d8\7!\2\2\u00d8/\3\2\2\2\u00d9\u00da\t\2\2\2\u00da\61\3\2\2\2\u00db"+
		"\u00e1\5,\27\2\u00dc\u00dd\7\16\2\2\u00dd\u00de\5\66\34\2\u00de\u00df"+
		"\7\17\2\2\u00df\u00e1\3\2\2\2\u00e0\u00db\3\2\2\2\u00e0\u00dc\3\2\2\2"+
		"\u00e1\63\3\2\2\2\u00e2\u00e5\5\66\34\2\u00e3\u00e5\7!\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\65\3\2\2\2\u00e6\u00e7\t\3\2\2\u00e7"+
		"\67\3\2\2\2\u00e8\u00ee\5\66\34\2\u00e9\u00ea\5\66\34\2\u00ea\u00eb\7"+
		"\33\2\2\u00eb\u00ec\58\35\2\u00ec\u00ee\3\2\2\2\u00ed\u00e8\3\2\2\2\u00ed"+
		"\u00e9\3\2\2\2\u00ee9\3\2\2\2\23=CM\u0082\u0088\u00a1\u00a6\u00ad\u00b6"+
		"\u00ba\u00c1\u00c4\u00c9\u00cd\u00e0\u00e4\u00ed";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}