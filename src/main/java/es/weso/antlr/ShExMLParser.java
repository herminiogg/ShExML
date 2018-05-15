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
		T__0=1, PREFIX=2, SOURCE=3, QUERY=4, EXPRESSION=5, UNION=6, JOIN=7, MATCHER=8, 
		AS=9, MATCHING=10, LESS_SYMBOL=11, GREATER_SYMBOL=12, DOLLAR=13, BRACKET_LEFT=14, 
		BRACKET_RIGHT=15, BRACE_LEFT=16, BRACE_RIGHT=17, SEMICOLON=18, DOT=19, 
		AT=20, ADD=21, QUOTE=22, STRING_OR_VAR=23, URI_VAR=24, JSONPATH=25, XMLPATH=26, 
		URL=27, STRINGOPERATOR=28, COMMENT=29, WS=30;
	public static final int
		RULE_shExML = 0, RULE_decl = 1, RULE_prefix = 2, RULE_source = 3, RULE_query = 4, 
		RULE_expression = 5, RULE_matcher = 6, RULE_replacedStrings = 7, RULE_exp = 8, 
		RULE_stringOperation = 9, RULE_sourceQuery = 10, RULE_join = 11, RULE_union = 12, 
		RULE_leftUnionOption = 13, RULE_rightUnionOption = 14, RULE_shape = 15, 
		RULE_predicateObject = 16, RULE_objectElement = 17, RULE_shapeLink = 18, 
		RULE_predicate = 19, RULE_fileSource = 20, RULE_queryClause = 21, RULE_tripleElement = 22, 
		RULE_prefixVar = 23, RULE_variable = 24;
	public static final String[] ruleNames = {
		"shExML", "decl", "prefix", "source", "query", "expression", "matcher", 
		"replacedStrings", "exp", "stringOperation", "sourceQuery", "join", "union", 
		"leftUnionOption", "rightUnionOption", "shape", "predicateObject", "objectElement", 
		"shapeLink", "predicate", "fileSource", "queryClause", "tripleElement", 
		"prefixVar", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'PREFIX'", "'SOURCE'", "'QUERY'", "'EXPRESSION'", "'UNION'", 
		"'JOIN'", "'MATCHER'", "'AS'", "'MATCHING'", "'<'", "'>'", "'$'", "'['", 
		"']'", "'{'", "'}'", "';'", "'.'", "'@'", "'+'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "PREFIX", "SOURCE", "QUERY", "EXPRESSION", "UNION", "JOIN", 
		"MATCHER", "AS", "MATCHING", "LESS_SYMBOL", "GREATER_SYMBOL", "DOLLAR", 
		"BRACKET_LEFT", "BRACKET_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", 
		"DOT", "AT", "ADD", "QUOTE", "STRING_OR_VAR", "URI_VAR", "JSONPATH", "XMLPATH", 
		"URL", "STRINGOPERATOR", "COMMENT", "WS"
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
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFIX) | (1L << SOURCE) | (1L << QUERY) | (1L << EXPRESSION) | (1L << MATCHER))) != 0)) {
				{
				{
				setState(50);
				decl();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS_SYMBOL) | (1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL))) != 0)) {
				{
				{
				setState(56);
				shape();
				}
				}
				setState(61);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SOURCE:
				{
				setState(62);
				source();
				}
				break;
			case PREFIX:
				{
				setState(63);
				prefix();
				}
				break;
			case QUERY:
				{
				setState(64);
				query();
				}
				break;
			case EXPRESSION:
				{
				setState(65);
				expression();
				}
				break;
			case MATCHER:
				{
				setState(66);
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
			setState(69);
			match(PREFIX);
			setState(70);
			variable();
			setState(71);
			match(LESS_SYMBOL);
			setState(72);
			match(URL);
			setState(73);
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
			setState(75);
			match(SOURCE);
			setState(76);
			variable();
			setState(77);
			match(LESS_SYMBOL);
			setState(78);
			fileSource();
			setState(79);
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
			setState(81);
			match(QUERY);
			setState(82);
			variable();
			setState(83);
			match(LESS_SYMBOL);
			setState(84);
			queryClause();
			setState(85);
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
		enterRule(_localctx, 10, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(EXPRESSION);
			setState(88);
			variable();
			setState(89);
			match(LESS_SYMBOL);
			setState(90);
			exp();
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
		enterRule(_localctx, 12, RULE_matcher);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(MATCHER);
			setState(94);
			variable();
			setState(95);
			match(LESS_SYMBOL);
			setState(96);
			replacedStrings();
			setState(97);
			match(AS);
			setState(98);
			match(STRING_OR_VAR);
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
		enterRule(_localctx, 14, RULE_replacedStrings);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(STRING_OR_VAR);
				setState(102);
				match(T__0);
				setState(103);
				replacedStrings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
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
		enterRule(_localctx, 16, RULE_exp);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				sourceQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				join();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
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
		enterRule(_localctx, 18, RULE_stringOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			sourceQuery();
			setState(114);
			match(ADD);
			setState(115);
			match(STRINGOPERATOR);
			setState(116);
			match(ADD);
			setState(117);
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
		enterRule(_localctx, 20, RULE_sourceQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(DOLLAR);
			setState(120);
			variable();
			setState(121);
			match(DOT);
			setState(122);
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
		enterRule(_localctx, 22, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			sourceQuery();
			setState(125);
			match(UNION);
			setState(126);
			sourceQuery();
			setState(127);
			match(JOIN);
			setState(128);
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
		enterRule(_localctx, 24, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			leftUnionOption();
			setState(131);
			match(UNION);
			setState(132);
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
		enterRule(_localctx, 26, RULE_leftUnionOption);
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				sourceQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
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
		enterRule(_localctx, 28, RULE_rightUnionOption);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				sourceQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
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
		enterRule(_localctx, 30, RULE_shape);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			tripleElement();
			setState(144);
			prefixVar();
			setState(145);
			match(BRACKET_LEFT);
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				setState(146);
				exp();
				}
				break;
			case STRING_OR_VAR:
			case URI_VAR:
				{
				setState(147);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(150);
			match(BRACKET_RIGHT);
			setState(151);
			match(BRACE_LEFT);
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(152);
					predicateObject();
					setState(153);
					match(SEMICOLON);
					}
					} 
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL))) != 0)) {
				{
				setState(160);
				predicateObject();
				}
			}

			setState(163);
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
		enterRule(_localctx, 32, RULE_predicateObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			predicate();
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT:
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
				{
				setState(166);
				objectElement();
				}
				break;
			case AT:
				{
				setState(167);
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
		enterRule(_localctx, 34, RULE_objectElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL))) != 0)) {
				{
				setState(170);
				prefixVar();
				}
			}

			setState(173);
			match(BRACKET_LEFT);
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOLLAR:
				{
				setState(174);
				exp();
				}
				break;
			case STRING_OR_VAR:
			case URI_VAR:
				{
				setState(175);
				variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MATCHING) {
				{
				setState(178);
				match(MATCHING);
				setState(179);
				variable();
				}
			}

			setState(182);
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
		enterRule(_localctx, 36, RULE_shapeLink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(AT);
			setState(185);
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
		enterRule(_localctx, 38, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			prefixVar();
			setState(188);
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
		enterRule(_localctx, 40, RULE_fileSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
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
		enterRule(_localctx, 42, RULE_queryClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
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
		enterRule(_localctx, 44, RULE_tripleElement);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				predicate();
				}
				break;
			case LESS_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(LESS_SYMBOL);
				setState(196);
				variable();
				setState(197);
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
		enterRule(_localctx, 46, RULE_prefixVar);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				variable();
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
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
		enterRule(_localctx, 48, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u00d2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\3\3\3\3\3\3\3\3\3\5\3F\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\5\tl\n\t\3\n\3\n\3\n\3\n\5\nr\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\5\17\u008b\n\17\3\20\3\20\3\20\5\20\u0090"+
		"\n\20\3\21\3\21\3\21\3\21\3\21\5\21\u0097\n\21\3\21\3\21\3\21\3\21\3\21"+
		"\7\21\u009e\n\21\f\21\16\21\u00a1\13\21\3\21\5\21\u00a4\n\21\3\21\3\21"+
		"\3\22\3\22\3\22\5\22\u00ab\n\22\3\23\5\23\u00ae\n\23\3\23\3\23\3\23\5"+
		"\23\u00b3\n\23\3\23\3\23\5\23\u00b7\n\23\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\5\30\u00ca\n\30"+
		"\3\31\3\31\5\31\u00ce\n\31\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\2\4\3\2\33\34\3\2\31\32\2\u00ce\2\67"+
		"\3\2\2\2\4E\3\2\2\2\6G\3\2\2\2\bM\3\2\2\2\nS\3\2\2\2\fY\3\2\2\2\16_\3"+
		"\2\2\2\20k\3\2\2\2\22q\3\2\2\2\24s\3\2\2\2\26y\3\2\2\2\30~\3\2\2\2\32"+
		"\u0084\3\2\2\2\34\u008a\3\2\2\2\36\u008f\3\2\2\2 \u0091\3\2\2\2\"\u00a7"+
		"\3\2\2\2$\u00ad\3\2\2\2&\u00ba\3\2\2\2(\u00bd\3\2\2\2*\u00c0\3\2\2\2,"+
		"\u00c2\3\2\2\2.\u00c9\3\2\2\2\60\u00cd\3\2\2\2\62\u00cf\3\2\2\2\64\66"+
		"\5\4\3\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28=\3\2\2\2"+
		"9\67\3\2\2\2:<\5 \21\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\3\3\2"+
		"\2\2?=\3\2\2\2@F\5\b\5\2AF\5\6\4\2BF\5\n\6\2CF\5\f\7\2DF\5\16\b\2E@\3"+
		"\2\2\2EA\3\2\2\2EB\3\2\2\2EC\3\2\2\2ED\3\2\2\2F\5\3\2\2\2GH\7\4\2\2HI"+
		"\5\62\32\2IJ\7\r\2\2JK\7\35\2\2KL\7\16\2\2L\7\3\2\2\2MN\7\5\2\2NO\5\62"+
		"\32\2OP\7\r\2\2PQ\5*\26\2QR\7\16\2\2R\t\3\2\2\2ST\7\6\2\2TU\5\62\32\2"+
		"UV\7\r\2\2VW\5,\27\2WX\7\16\2\2X\13\3\2\2\2YZ\7\7\2\2Z[\5\62\32\2[\\\7"+
		"\r\2\2\\]\5\22\n\2]^\7\16\2\2^\r\3\2\2\2_`\7\n\2\2`a\5\62\32\2ab\7\r\2"+
		"\2bc\5\20\t\2cd\7\13\2\2de\7\31\2\2ef\7\16\2\2f\17\3\2\2\2gh\7\31\2\2"+
		"hi\7\3\2\2il\5\20\t\2jl\7\31\2\2kg\3\2\2\2kj\3\2\2\2l\21\3\2\2\2mr\5\26"+
		"\f\2nr\5\32\16\2or\5\30\r\2pr\5\24\13\2qm\3\2\2\2qn\3\2\2\2qo\3\2\2\2"+
		"qp\3\2\2\2r\23\3\2\2\2st\5\26\f\2tu\7\27\2\2uv\7\36\2\2vw\7\27\2\2wx\5"+
		"\26\f\2x\25\3\2\2\2yz\7\17\2\2z{\5\62\32\2{|\7\25\2\2|}\5\62\32\2}\27"+
		"\3\2\2\2~\177\5\26\f\2\177\u0080\7\b\2\2\u0080\u0081\5\26\f\2\u0081\u0082"+
		"\7\t\2\2\u0082\u0083\5\26\f\2\u0083\31\3\2\2\2\u0084\u0085\5\34\17\2\u0085"+
		"\u0086\7\b\2\2\u0086\u0087\5\36\20\2\u0087\33\3\2\2\2\u0088\u008b\5\26"+
		"\f\2\u0089\u008b\5\24\13\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\35\3\2\2\2\u008c\u0090\5\26\f\2\u008d\u0090\5\32\16\2\u008e\u0090\5\24"+
		"\13\2\u008f\u008c\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\37\3\2\2\2\u0091\u0092\5.\30\2\u0092\u0093\5\60\31\2\u0093\u0096\7\20"+
		"\2\2\u0094\u0097\5\22\n\2\u0095\u0097\5\62\32\2\u0096\u0094\3\2\2\2\u0096"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\21\2\2\u0099\u009f\7"+
		"\22\2\2\u009a\u009b\5\"\22\2\u009b\u009c\7\24\2\2\u009c\u009e\3\2\2\2"+
		"\u009d\u009a\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\5\"\22\2"+
		"\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6"+
		"\7\23\2\2\u00a6!\3\2\2\2\u00a7\u00aa\5(\25\2\u00a8\u00ab\5$\23\2\u00a9"+
		"\u00ab\5&\24\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab#\3\2\2\2"+
		"\u00ac\u00ae\5\60\31\2\u00ad\u00ac\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b2\7\20\2\2\u00b0\u00b3\5\22\n\2\u00b1\u00b3\5\62\32"+
		"\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b5"+
		"\7\f\2\2\u00b5\u00b7\5\62\32\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2"+
		"\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\21\2\2\u00b9%\3\2\2\2\u00ba\u00bb\7"+
		"\26\2\2\u00bb\u00bc\5.\30\2\u00bc\'\3\2\2\2\u00bd\u00be\5\60\31\2\u00be"+
		"\u00bf\5\62\32\2\u00bf)\3\2\2\2\u00c0\u00c1\7\35\2\2\u00c1+\3\2\2\2\u00c2"+
		"\u00c3\t\2\2\2\u00c3-\3\2\2\2\u00c4\u00ca\5(\25\2\u00c5\u00c6\7\r\2\2"+
		"\u00c6\u00c7\5\62\32\2\u00c7\u00c8\7\16\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u00c4\3\2\2\2\u00c9\u00c5\3\2\2\2\u00ca/\3\2\2\2\u00cb\u00ce\5\62\32"+
		"\2\u00cc\u00ce\7\35\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce"+
		"\61\3\2\2\2\u00cf\u00d0\t\3\2\2\u00d0\63\3\2\2\2\22\67=Ekq\u008a\u008f"+
		"\u0096\u009f\u00a3\u00aa\u00ad\u00b2\u00b6\u00c9\u00cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}