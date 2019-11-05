// Generated from ShExMLParser.g4 by ANTLR 4.7.2

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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREFIX=1, SOURCE=2, QUERY=3, ITERATOR=4, FIELD=5, AUTOINCREMENT=6, EXPRESSION=7, 
		UNION=8, JOIN=9, MATCHER=10, AS=11, MATCHING=12, LESS_SYMBOL=13, GREATER_SYMBOL=14, 
		BRACKET_LEFT=15, BRACKET_RIGHT=16, PAREN_LEFT=17, PAREN_RIGHT=18, BRACE_LEFT=19, 
		BRACE_RIGHT=20, SEMICOLON=21, DOT=22, ADD=23, COMMA=24, QUOTE=25, AND=26, 
		A=27, STRING_OR_VAR=28, URI_VAR=29, STRINGOPERATOR=30, XMLSCHEMADATATYPE=31, 
		SHAPELINK=32, LANGTAG=33, COMMENT=34, WS=35, URL=36, JSONPATH=37, XMLPATH=38, 
		CSVPERROW=39, QUERY_PART=40, GREATER_SYMBOL_QUERY=41, WS_QUERY=42, LESS_SYMBOL_QUERY=43, 
		STRING_OR_VAR_QUERY=44, URI_VAR_QUERY=45, WS_DECLARATION=46, LESS_SYMBOL_AUTOINCREMENT=47, 
		TO=48, BY=49, ADD_AUTOINCREMENT=50, DIGITS=51, STRING_OR_VAR_AUTOINCREMENT=52, 
		STRINGOPERATOR_AUTOINCREMENT=53, GREATER_SYMBOL_AUTOINCREMENT=54, WS_AUTOINCREMENT=55;
	public static final int
		RULE_shExML = 0, RULE_decl = 1, RULE_prefix = 2, RULE_source = 3, RULE_iterator = 4, 
		RULE_nestedIterator = 5, RULE_field = 6, RULE_query = 7, RULE_autoincrement = 8, 
		RULE_expression = 9, RULE_matcher = 10, RULE_matchers = 11, RULE_replacedStrings = 12, 
		RULE_exp = 13, RULE_stringOperation = 14, RULE_iteratorQuery = 15, RULE_composedVariable = 16, 
		RULE_queryClause = 17, RULE_join = 18, RULE_union = 19, RULE_leftUnionOption = 20, 
		RULE_rightUnionOption = 21, RULE_shape = 22, RULE_predicateObject = 23, 
		RULE_objectElement = 24, RULE_shapeLink = 25, RULE_predicate = 26, RULE_literalValue = 27, 
		RULE_tripleElement = 28, RULE_prefixVar = 29, RULE_variable = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"shExML", "decl", "prefix", "source", "iterator", "nestedIterator", "field", 
			"query", "autoincrement", "expression", "matcher", "matchers", "replacedStrings", 
			"exp", "stringOperation", "iteratorQuery", "composedVariable", "queryClause", 
			"join", "union", "leftUnionOption", "rightUnionOption", "shape", "predicateObject", 
			"objectElement", "shapeLink", "predicate", "literalValue", "tripleElement", 
			"prefixVar", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "'['", "']'", "'('", "')'", "'{'", "'}'", "';'", "'.'", 
			null, "','", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "AUTOINCREMENT", 
			"EXPRESSION", "UNION", "JOIN", "MATCHER", "AS", "MATCHING", "LESS_SYMBOL", 
			"GREATER_SYMBOL", "BRACKET_LEFT", "BRACKET_RIGHT", "PAREN_LEFT", "PAREN_RIGHT", 
			"BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "ADD", "COMMA", "QUOTE", 
			"AND", "A", "STRING_OR_VAR", "URI_VAR", "STRINGOPERATOR", "XMLSCHEMADATATYPE", 
			"SHAPELINK", "LANGTAG", "COMMENT", "WS", "URL", "JSONPATH", "XMLPATH", 
			"CSVPERROW", "QUERY_PART", "GREATER_SYMBOL_QUERY", "WS_QUERY", "LESS_SYMBOL_QUERY", 
			"STRING_OR_VAR_QUERY", "URI_VAR_QUERY", "WS_DECLARATION", "LESS_SYMBOL_AUTOINCREMENT", 
			"TO", "BY", "ADD_AUTOINCREMENT", "DIGITS", "STRING_OR_VAR_AUTOINCREMENT", 
			"STRINGOPERATOR_AUTOINCREMENT", "GREATER_SYMBOL_AUTOINCREMENT", "WS_AUTOINCREMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "ShExMLParser.g4"; }

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
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterShExML(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitShExML(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitShExML(this);
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
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFIX) | (1L << SOURCE) | (1L << QUERY) | (1L << ITERATOR) | (1L << AUTOINCREMENT) | (1L << EXPRESSION) | (1L << MATCHER))) != 0)) {
				{
				{
				setState(62);
				decl();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS_SYMBOL) | (1L << A) | (1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL) | (1L << STRING_OR_VAR_QUERY) | (1L << URI_VAR_QUERY) | (1L << STRING_OR_VAR_AUTOINCREMENT))) != 0)) {
				{
				{
				setState(68);
				shape();
				}
				}
				setState(73);
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
		public IteratorContext iterator() {
			return getRuleContext(IteratorContext.class,0);
		}
		public AutoincrementContext autoincrement() {
			return getRuleContext(AutoincrementContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SOURCE:
				{
				setState(74);
				source();
				}
				break;
			case PREFIX:
				{
				setState(75);
				prefix();
				}
				break;
			case QUERY:
				{
				setState(76);
				query();
				}
				break;
			case EXPRESSION:
				{
				setState(77);
				expression();
				}
				break;
			case MATCHER:
				{
				setState(78);
				matcher();
				}
				break;
			case ITERATOR:
				{
				setState(79);
				iterator();
				}
				break;
			case AUTOINCREMENT:
				{
				setState(80);
				autoincrement();
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
		public TerminalNode LESS_SYMBOL_QUERY() { return getToken(ShExMLParser.LESS_SYMBOL_QUERY, 0); }
		public TerminalNode URL() { return getToken(ShExMLParser.URL, 0); }
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(PREFIX);
			setState(84);
			variable();
			setState(85);
			match(LESS_SYMBOL_QUERY);
			setState(86);
			match(URL);
			setState(87);
			match(GREATER_SYMBOL_QUERY);
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
		public TerminalNode LESS_SYMBOL_QUERY() { return getToken(ShExMLParser.LESS_SYMBOL_QUERY, 0); }
		public TerminalNode URL() { return getToken(ShExMLParser.URL, 0); }
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitSource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitSource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(SOURCE);
			setState(90);
			variable();
			setState(91);
			match(LESS_SYMBOL_QUERY);
			setState(92);
			match(URL);
			setState(93);
			match(GREATER_SYMBOL_QUERY);
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
		public TerminalNode LESS_SYMBOL_QUERY() { return getToken(ShExMLParser.LESS_SYMBOL_QUERY, 0); }
		public QueryClauseContext queryClause() {
			return getRuleContext(QueryClauseContext.class,0);
		}
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public TerminalNode BRACE_LEFT() { return getToken(ShExMLParser.BRACE_LEFT, 0); }
		public TerminalNode BRACE_RIGHT() { return getToken(ShExMLParser.BRACE_RIGHT, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<NestedIteratorContext> nestedIterator() {
			return getRuleContexts(NestedIteratorContext.class);
		}
		public NestedIteratorContext nestedIterator(int i) {
			return getRuleContext(NestedIteratorContext.class,i);
		}
		public IteratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterIterator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitIterator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitIterator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteratorContext iterator() throws RecognitionException {
		IteratorContext _localctx = new IteratorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_iterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(ITERATOR);
			setState(96);
			variable();
			setState(97);
			match(LESS_SYMBOL_QUERY);
			setState(98);
			queryClause();
			setState(99);
			match(GREATER_SYMBOL_QUERY);
			setState(100);
			match(BRACE_LEFT);
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				field();
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FIELD );
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ITERATOR) {
				{
				{
				setState(106);
				nestedIterator();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
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

	public static class NestedIteratorContext extends ParserRuleContext {
		public TerminalNode ITERATOR() { return getToken(ShExMLParser.ITERATOR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LESS_SYMBOL_QUERY() { return getToken(ShExMLParser.LESS_SYMBOL_QUERY, 0); }
		public TerminalNode QUERY_PART() { return getToken(ShExMLParser.QUERY_PART, 0); }
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public TerminalNode BRACE_LEFT() { return getToken(ShExMLParser.BRACE_LEFT, 0); }
		public TerminalNode BRACE_RIGHT() { return getToken(ShExMLParser.BRACE_RIGHT, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<NestedIteratorContext> nestedIterator() {
			return getRuleContexts(NestedIteratorContext.class);
		}
		public NestedIteratorContext nestedIterator(int i) {
			return getRuleContext(NestedIteratorContext.class,i);
		}
		public NestedIteratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedIterator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterNestedIterator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitNestedIterator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitNestedIterator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestedIteratorContext nestedIterator() throws RecognitionException {
		NestedIteratorContext _localctx = new NestedIteratorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_nestedIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ITERATOR);
			setState(115);
			variable();
			setState(116);
			match(LESS_SYMBOL_QUERY);
			setState(117);
			match(QUERY_PART);
			setState(118);
			match(GREATER_SYMBOL_QUERY);
			setState(119);
			match(BRACE_LEFT);
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				field();
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FIELD );
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ITERATOR) {
				{
				{
				setState(125);
				nestedIterator();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
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

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode FIELD() { return getToken(ShExMLParser.FIELD, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LESS_SYMBOL_QUERY() { return getToken(ShExMLParser.LESS_SYMBOL_QUERY, 0); }
		public TerminalNode QUERY_PART() { return getToken(ShExMLParser.QUERY_PART, 0); }
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_field);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(FIELD);
			setState(134);
			variable();
			setState(135);
			match(LESS_SYMBOL_QUERY);
			setState(136);
			match(QUERY_PART);
			setState(137);
			match(GREATER_SYMBOL_QUERY);
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
		public TerminalNode LESS_SYMBOL_QUERY() { return getToken(ShExMLParser.LESS_SYMBOL_QUERY, 0); }
		public QueryClauseContext queryClause() {
			return getRuleContext(QueryClauseContext.class,0);
		}
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(QUERY);
			setState(140);
			variable();
			setState(141);
			match(LESS_SYMBOL_QUERY);
			setState(142);
			queryClause();
			setState(143);
			match(GREATER_SYMBOL_QUERY);
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

	public static class AutoincrementContext extends ParserRuleContext {
		public TerminalNode AUTOINCREMENT() { return getToken(ShExMLParser.AUTOINCREMENT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LESS_SYMBOL_AUTOINCREMENT() { return getToken(ShExMLParser.LESS_SYMBOL_AUTOINCREMENT, 0); }
		public List<TerminalNode> DIGITS() { return getTokens(ShExMLParser.DIGITS); }
		public TerminalNode DIGITS(int i) {
			return getToken(ShExMLParser.DIGITS, i);
		}
		public TerminalNode GREATER_SYMBOL_AUTOINCREMENT() { return getToken(ShExMLParser.GREATER_SYMBOL_AUTOINCREMENT, 0); }
		public List<TerminalNode> STRINGOPERATOR_AUTOINCREMENT() { return getTokens(ShExMLParser.STRINGOPERATOR_AUTOINCREMENT); }
		public TerminalNode STRINGOPERATOR_AUTOINCREMENT(int i) {
			return getToken(ShExMLParser.STRINGOPERATOR_AUTOINCREMENT, i);
		}
		public List<TerminalNode> ADD_AUTOINCREMENT() { return getTokens(ShExMLParser.ADD_AUTOINCREMENT); }
		public TerminalNode ADD_AUTOINCREMENT(int i) {
			return getToken(ShExMLParser.ADD_AUTOINCREMENT, i);
		}
		public TerminalNode TO() { return getToken(ShExMLParser.TO, 0); }
		public TerminalNode BY() { return getToken(ShExMLParser.BY, 0); }
		public AutoincrementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_autoincrement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterAutoincrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitAutoincrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitAutoincrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AutoincrementContext autoincrement() throws RecognitionException {
		AutoincrementContext _localctx = new AutoincrementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_autoincrement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(AUTOINCREMENT);
			setState(146);
			variable();
			setState(147);
			match(LESS_SYMBOL_AUTOINCREMENT);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGOPERATOR_AUTOINCREMENT) {
				{
				setState(148);
				match(STRINGOPERATOR_AUTOINCREMENT);
				setState(149);
				match(ADD_AUTOINCREMENT);
				}
			}

			setState(152);
			match(DIGITS);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(153);
				match(TO);
				setState(154);
				match(DIGITS);
				}
			}

			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BY) {
				{
				setState(157);
				match(BY);
				setState(158);
				match(DIGITS);
				}
			}

			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD_AUTOINCREMENT) {
				{
				setState(161);
				match(ADD_AUTOINCREMENT);
				setState(162);
				match(STRINGOPERATOR_AUTOINCREMENT);
				}
			}

			setState(165);
			match(GREATER_SYMBOL_AUTOINCREMENT);
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
		public TerminalNode LESS_SYMBOL() { return getToken(ShExMLParser.LESS_SYMBOL, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode GREATER_SYMBOL() { return getToken(ShExMLParser.GREATER_SYMBOL, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(EXPRESSION);
			setState(168);
			variable();
			setState(169);
			match(LESS_SYMBOL);
			setState(170);
			exp();
			setState(171);
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
		public TerminalNode LESS_SYMBOL() { return getToken(ShExMLParser.LESS_SYMBOL, 0); }
		public MatchersContext matchers() {
			return getRuleContext(MatchersContext.class,0);
		}
		public TerminalNode GREATER_SYMBOL() { return getToken(ShExMLParser.GREATER_SYMBOL, 0); }
		public MatcherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matcher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterMatcher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitMatcher(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitMatcher(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatcherContext matcher() throws RecognitionException {
		MatcherContext _localctx = new MatcherContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_matcher);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(MATCHER);
			setState(174);
			variable();
			setState(175);
			match(LESS_SYMBOL);
			setState(176);
			matchers(0);
			setState(177);
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

	public static class MatchersContext extends ParserRuleContext {
		public ReplacedStringsContext replacedStrings() {
			return getRuleContext(ReplacedStringsContext.class,0);
		}
		public TerminalNode AS() { return getToken(ShExMLParser.AS, 0); }
		public TerminalNode STRING_OR_VAR() { return getToken(ShExMLParser.STRING_OR_VAR, 0); }
		public TerminalNode STRINGOPERATOR() { return getToken(ShExMLParser.STRINGOPERATOR, 0); }
		public MatchersContext matchers() {
			return getRuleContext(MatchersContext.class,0);
		}
		public TerminalNode AND() { return getToken(ShExMLParser.AND, 0); }
		public MatchersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterMatchers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitMatchers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitMatchers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatchersContext matchers() throws RecognitionException {
		return matchers(0);
	}

	private MatchersContext matchers(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MatchersContext _localctx = new MatchersContext(_ctx, _parentState);
		MatchersContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_matchers, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(180);
			replacedStrings();
			setState(181);
			match(AS);
			setState(182);
			_la = _input.LA(1);
			if ( !(_la==STRING_OR_VAR || _la==STRINGOPERATOR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MatchersContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_matchers);
					setState(184);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(185);
					match(AND);
					setState(186);
					replacedStrings();
					setState(187);
					match(AS);
					setState(188);
					_la = _input.LA(1);
					if ( !(_la==STRING_OR_VAR || _la==STRINGOPERATOR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ReplacedStringsContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(ShExMLParser.COMMA, 0); }
		public ReplacedStringsContext replacedStrings() {
			return getRuleContext(ReplacedStringsContext.class,0);
		}
		public TerminalNode STRING_OR_VAR() { return getToken(ShExMLParser.STRING_OR_VAR, 0); }
		public TerminalNode STRINGOPERATOR() { return getToken(ShExMLParser.STRINGOPERATOR, 0); }
		public ReplacedStringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_replacedStrings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterReplacedStrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitReplacedStrings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitReplacedStrings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReplacedStringsContext replacedStrings() throws RecognitionException {
		ReplacedStringsContext _localctx = new ReplacedStringsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_replacedStrings);
		int _la;
		try {
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				_la = _input.LA(1);
				if ( !(_la==STRING_OR_VAR || _la==STRINGOPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(196);
				match(COMMA);
				setState(197);
				replacedStrings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				_la = _input.LA(1);
				if ( !(_la==STRING_OR_VAR || _la==STRINGOPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exp);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				union();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				join();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				stringOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
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
		public List<IteratorQueryContext> iteratorQuery() {
			return getRuleContexts(IteratorQueryContext.class);
		}
		public IteratorQueryContext iteratorQuery(int i) {
			return getRuleContext(IteratorQueryContext.class,i);
		}
		public List<TerminalNode> ADD() { return getTokens(ShExMLParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(ShExMLParser.ADD, i);
		}
		public TerminalNode STRINGOPERATOR() { return getToken(ShExMLParser.STRINGOPERATOR, 0); }
		public StringOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterStringOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitStringOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitStringOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringOperationContext stringOperation() throws RecognitionException {
		StringOperationContext _localctx = new StringOperationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stringOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			iteratorQuery();
			setState(208);
			match(ADD);
			setState(209);
			match(STRINGOPERATOR);
			setState(210);
			match(ADD);
			setState(211);
			iteratorQuery();
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ShExMLParser.DOT, 0); }
		public ComposedVariableContext composedVariable() {
			return getRuleContext(ComposedVariableContext.class,0);
		}
		public IteratorQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteratorQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterIteratorQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitIteratorQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitIteratorQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IteratorQueryContext iteratorQuery() throws RecognitionException {
		IteratorQueryContext _localctx = new IteratorQueryContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_iteratorQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			variable();
			setState(214);
			match(DOT);
			setState(215);
			composedVariable();
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

	public static class ComposedVariableContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ShExMLParser.DOT, 0); }
		public ComposedVariableContext composedVariable() {
			return getRuleContext(ComposedVariableContext.class,0);
		}
		public ComposedVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composedVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterComposedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitComposedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitComposedVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComposedVariableContext composedVariable() throws RecognitionException {
		ComposedVariableContext _localctx = new ComposedVariableContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_composedVariable);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				variable();
				setState(219);
				match(DOT);
				setState(220);
				composedVariable();
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
		public TerminalNode QUERY_PART() { return getToken(ShExMLParser.QUERY_PART, 0); }
		public TerminalNode XMLPATH() { return getToken(ShExMLParser.XMLPATH, 0); }
		public TerminalNode CSVPERROW() { return getToken(ShExMLParser.CSVPERROW, 0); }
		public QueryClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterQueryClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitQueryClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitQueryClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryClauseContext queryClause() throws RecognitionException {
		QueryClauseContext _localctx = new QueryClauseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_queryClause);
		try {
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONPATH:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(JSONPATH);
				setState(225);
				match(QUERY_PART);
				}
				break;
			case XMLPATH:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(XMLPATH);
				setState(227);
				match(QUERY_PART);
				}
				break;
			case CSVPERROW:
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				match(CSVPERROW);
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

	public static class JoinContext extends ParserRuleContext {
		public List<IteratorQueryContext> iteratorQuery() {
			return getRuleContexts(IteratorQueryContext.class);
		}
		public IteratorQueryContext iteratorQuery(int i) {
			return getRuleContext(IteratorQueryContext.class,i);
		}
		public TerminalNode UNION() { return getToken(ShExMLParser.UNION, 0); }
		public TerminalNode JOIN() { return getToken(ShExMLParser.JOIN, 0); }
		public JoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitJoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinContext join() throws RecognitionException {
		JoinContext _localctx = new JoinContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			iteratorQuery();
			setState(232);
			match(UNION);
			setState(233);
			iteratorQuery();
			setState(234);
			match(JOIN);
			setState(235);
			iteratorQuery();
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
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			leftUnionOption();
			setState(238);
			match(UNION);
			setState(239);
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
		public IteratorQueryContext iteratorQuery() {
			return getRuleContext(IteratorQueryContext.class,0);
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
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterLeftUnionOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitLeftUnionOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitLeftUnionOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LeftUnionOptionContext leftUnionOption() throws RecognitionException {
		LeftUnionOptionContext _localctx = new LeftUnionOptionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_leftUnionOption);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
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
		public IteratorQueryContext iteratorQuery() {
			return getRuleContext(IteratorQueryContext.class,0);
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
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterRightUnionOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitRightUnionOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitRightUnionOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RightUnionOptionContext rightUnionOption() throws RecognitionException {
		RightUnionOptionContext _localctx = new RightUnionOptionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_rightUnionOption);
		try {
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
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
		public TerminalNode BRACKET_LEFT() { return getToken(ShExMLParser.BRACKET_LEFT, 0); }
		public TerminalNode BRACKET_RIGHT() { return getToken(ShExMLParser.BRACKET_RIGHT, 0); }
		public TerminalNode BRACE_LEFT() { return getToken(ShExMLParser.BRACE_LEFT, 0); }
		public TerminalNode BRACE_RIGHT() { return getToken(ShExMLParser.BRACE_RIGHT, 0); }
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
		public List<TerminalNode> SEMICOLON() { return getTokens(ShExMLParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(ShExMLParser.SEMICOLON, i);
		}
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitShape(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitShape(this);
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
			setState(250);
			tripleElement();
			setState(251);
			prefixVar();
			setState(252);
			match(BRACKET_LEFT);
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(253);
				exp();
				}
				break;
			case 2:
				{
				setState(254);
				variable();
				}
				break;
			}
			setState(257);
			match(BRACKET_RIGHT);
			setState(258);
			match(BRACE_LEFT);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(259);
					predicateObject();
					setState(260);
					match(SEMICOLON);
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << A) | (1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL) | (1L << STRING_OR_VAR_QUERY) | (1L << URI_VAR_QUERY) | (1L << STRING_OR_VAR_AUTOINCREMENT))) != 0)) {
				{
				setState(267);
				predicateObject();
				}
			}

			setState(270);
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
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public PredicateObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterPredicateObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitPredicateObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitPredicateObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateObjectContext predicateObject() throws RecognitionException {
		PredicateObjectContext _localctx = new PredicateObjectContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_predicateObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			predicate();
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(273);
				objectElement();
				}
				break;
			case 2:
				{
				setState(274);
				shapeLink();
				}
				break;
			case 3:
				{
				setState(275);
				literalValue();
				}
				break;
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
		public TerminalNode BRACKET_LEFT() { return getToken(ShExMLParser.BRACKET_LEFT, 0); }
		public TerminalNode BRACKET_RIGHT() { return getToken(ShExMLParser.BRACKET_RIGHT, 0); }
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
		public TerminalNode XMLSCHEMADATATYPE() { return getToken(ShExMLParser.XMLSCHEMADATATYPE, 0); }
		public TerminalNode LANGTAG() { return getToken(ShExMLParser.LANGTAG, 0); }
		public ObjectElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterObjectElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitObjectElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitObjectElement(this);
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
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << URL) | (1L << STRING_OR_VAR_QUERY) | (1L << URI_VAR_QUERY) | (1L << STRING_OR_VAR_AUTOINCREMENT))) != 0)) {
				{
				setState(278);
				prefixVar();
				}
			}

			setState(281);
			match(BRACKET_LEFT);
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(282);
				exp();
				}
				break;
			case 2:
				{
				setState(283);
				variable();
				}
				break;
			}
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MATCHING) {
				{
				setState(286);
				match(MATCHING);
				setState(287);
				variable();
				}
			}

			setState(290);
			match(BRACKET_RIGHT);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==XMLSCHEMADATATYPE || _la==LANGTAG) {
				{
				setState(291);
				_la = _input.LA(1);
				if ( !(_la==XMLSCHEMADATATYPE || _la==LANGTAG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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

	public static class ShapeLinkContext extends ParserRuleContext {
		public TerminalNode SHAPELINK() { return getToken(ShExMLParser.SHAPELINK, 0); }
		public ShapeLinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shapeLink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterShapeLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitShapeLink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitShapeLink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShapeLinkContext shapeLink() throws RecognitionException {
		ShapeLinkContext _localctx = new ShapeLinkContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_shapeLink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(SHAPELINK);
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
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public TerminalNode A() { return getToken(ShExMLParser.A, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				{
				setState(296);
				literalValue();
				}
				break;
			case A:
				{
				setState(297);
				match(A);
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

	public static class LiteralValueContext extends ParserRuleContext {
		public PrefixVarContext prefixVar() {
			return getRuleContext(PrefixVarContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public LiteralValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralValueContext literalValue() throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_literalValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			prefixVar();
			setState(301);
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
		public TerminalNode LESS_SYMBOL() { return getToken(ShExMLParser.LESS_SYMBOL, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode GREATER_SYMBOL() { return getToken(ShExMLParser.GREATER_SYMBOL, 0); }
		public TripleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tripleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterTripleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitTripleElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitTripleElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TripleElementContext tripleElement() throws RecognitionException {
		TripleElementContext _localctx = new TripleElementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_tripleElement);
		try {
			setState(308);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case A:
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				predicate();
				}
				break;
			case LESS_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				match(LESS_SYMBOL);
				setState(305);
				variable();
				setState(306);
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
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterPrefixVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitPrefixVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitPrefixVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixVarContext prefixVar() throws RecognitionException {
		PrefixVarContext _localctx = new PrefixVarContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_prefixVar);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(310);
				variable();
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
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
		public TerminalNode STRING_OR_VAR_QUERY() { return getToken(ShExMLParser.STRING_OR_VAR_QUERY, 0); }
		public TerminalNode URI_VAR_QUERY() { return getToken(ShExMLParser.URI_VAR_QUERY, 0); }
		public TerminalNode STRING_OR_VAR_AUTOINCREMENT() { return getToken(ShExMLParser.STRING_OR_VAR_AUTOINCREMENT, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_OR_VAR) | (1L << URI_VAR) | (1L << STRING_OR_VAR_QUERY) | (1L << URI_VAR_QUERY) | (1L << STRING_OR_VAR_AUTOINCREMENT))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return matchers_sempred((MatchersContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean matchers_sempred(MatchersContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u013f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\7\2B\n\2\f\2\16\2E\13\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3T\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6i\n\6\r\6\16\6j\3\6\7\6n\n\6\f\6\16\6q\13"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7|\n\7\r\7\16\7}\3\7\7\7\u0081"+
		"\n\7\f\7\16\7\u0084\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u0099\n\n\3\n\3\n\3\n\5\n\u009e\n\n"+
		"\3\n\3\n\5\n\u00a2\n\n\3\n\3\n\5\n\u00a6\n\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\7\r\u00c1\n\r\f\r\16\r\u00c4\13\r\3\16\3\16\3\16\3\16\5\16"+
		"\u00ca\n\16\3\17\3\17\3\17\3\17\5\17\u00d0\n\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u00e1\n\22"+
		"\3\23\3\23\3\23\3\23\3\23\5\23\u00e8\n\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\5\26\u00f6\n\26\3\27\3\27\3\27\5\27\u00fb"+
		"\n\27\3\30\3\30\3\30\3\30\3\30\5\30\u0102\n\30\3\30\3\30\3\30\3\30\3\30"+
		"\7\30\u0109\n\30\f\30\16\30\u010c\13\30\3\30\5\30\u010f\n\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\5\31\u0117\n\31\3\32\5\32\u011a\n\32\3\32\3\32\3"+
		"\32\5\32\u011f\n\32\3\32\3\32\5\32\u0123\n\32\3\32\3\32\5\32\u0127\n\32"+
		"\3\33\3\33\3\34\3\34\5\34\u012d\n\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0137\n\36\3\37\3\37\5\37\u013b\n\37\3 \3 \3 \2\3\30!\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\5\4\2\36"+
		"\36  \4\2!!##\5\2\36\37./\66\66\2\u0146\2C\3\2\2\2\4S\3\2\2\2\6U\3\2\2"+
		"\2\b[\3\2\2\2\na\3\2\2\2\ft\3\2\2\2\16\u0087\3\2\2\2\20\u008d\3\2\2\2"+
		"\22\u0093\3\2\2\2\24\u00a9\3\2\2\2\26\u00af\3\2\2\2\30\u00b5\3\2\2\2\32"+
		"\u00c9\3\2\2\2\34\u00cf\3\2\2\2\36\u00d1\3\2\2\2 \u00d7\3\2\2\2\"\u00e0"+
		"\3\2\2\2$\u00e7\3\2\2\2&\u00e9\3\2\2\2(\u00ef\3\2\2\2*\u00f5\3\2\2\2,"+
		"\u00fa\3\2\2\2.\u00fc\3\2\2\2\60\u0112\3\2\2\2\62\u0119\3\2\2\2\64\u0128"+
		"\3\2\2\2\66\u012c\3\2\2\28\u012e\3\2\2\2:\u0136\3\2\2\2<\u013a\3\2\2\2"+
		">\u013c\3\2\2\2@B\5\4\3\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DI\3"+
		"\2\2\2EC\3\2\2\2FH\5.\30\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\3"+
		"\3\2\2\2KI\3\2\2\2LT\5\b\5\2MT\5\6\4\2NT\5\20\t\2OT\5\24\13\2PT\5\26\f"+
		"\2QT\5\n\6\2RT\5\22\n\2SL\3\2\2\2SM\3\2\2\2SN\3\2\2\2SO\3\2\2\2SP\3\2"+
		"\2\2SQ\3\2\2\2SR\3\2\2\2T\5\3\2\2\2UV\7\3\2\2VW\5> \2WX\7-\2\2XY\7&\2"+
		"\2YZ\7+\2\2Z\7\3\2\2\2[\\\7\4\2\2\\]\5> \2]^\7-\2\2^_\7&\2\2_`\7+\2\2"+
		"`\t\3\2\2\2ab\7\6\2\2bc\5> \2cd\7-\2\2de\5$\23\2ef\7+\2\2fh\7\25\2\2g"+
		"i\5\16\b\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2ko\3\2\2\2ln\5\f\7\2"+
		"ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\26\2"+
		"\2s\13\3\2\2\2tu\7\6\2\2uv\5> \2vw\7-\2\2wx\7*\2\2xy\7+\2\2y{\7\25\2\2"+
		"z|\5\16\b\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0082\3\2\2\2\177"+
		"\u0081\5\f\7\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2"+
		"\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086"+
		"\7\26\2\2\u0086\r\3\2\2\2\u0087\u0088\7\7\2\2\u0088\u0089\5> \2\u0089"+
		"\u008a\7-\2\2\u008a\u008b\7*\2\2\u008b\u008c\7+\2\2\u008c\17\3\2\2\2\u008d"+
		"\u008e\7\5\2\2\u008e\u008f\5> \2\u008f\u0090\7-\2\2\u0090\u0091\5$\23"+
		"\2\u0091\u0092\7+\2\2\u0092\21\3\2\2\2\u0093\u0094\7\b\2\2\u0094\u0095"+
		"\5> \2\u0095\u0098\7\61\2\2\u0096\u0097\7\67\2\2\u0097\u0099\7\64\2\2"+
		"\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009d"+
		"\7\65\2\2\u009b\u009c\7\62\2\2\u009c\u009e\7\65\2\2\u009d\u009b\3\2\2"+
		"\2\u009d\u009e\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u00a0\7\63\2\2\u00a0"+
		"\u00a2\7\65\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a5\3"+
		"\2\2\2\u00a3\u00a4\7\64\2\2\u00a4\u00a6\7\67\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\78\2\2\u00a8\23\3\2\2\2"+
		"\u00a9\u00aa\7\t\2\2\u00aa\u00ab\5> \2\u00ab\u00ac\7\17\2\2\u00ac\u00ad"+
		"\5\34\17\2\u00ad\u00ae\7\20\2\2\u00ae\25\3\2\2\2\u00af\u00b0\7\f\2\2\u00b0"+
		"\u00b1\5> \2\u00b1\u00b2\7\17\2\2\u00b2\u00b3\5\30\r\2\u00b3\u00b4\7\20"+
		"\2\2\u00b4\27\3\2\2\2\u00b5\u00b6\b\r\1\2\u00b6\u00b7\5\32\16\2\u00b7"+
		"\u00b8\7\r\2\2\u00b8\u00b9\t\2\2\2\u00b9\u00c2\3\2\2\2\u00ba\u00bb\f\3"+
		"\2\2\u00bb\u00bc\7\34\2\2\u00bc\u00bd\5\32\16\2\u00bd\u00be\7\r\2\2\u00be"+
		"\u00bf\t\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00ba\3\2\2\2\u00c1\u00c4\3\2"+
		"\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\31\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c5\u00c6\t\2\2\2\u00c6\u00c7\7\32\2\2\u00c7\u00ca\5\32\16"+
		"\2\u00c8\u00ca\t\2\2\2\u00c9\u00c5\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\33"+
		"\3\2\2\2\u00cb\u00d0\5(\25\2\u00cc\u00d0\5&\24\2\u00cd\u00d0\5\36\20\2"+
		"\u00ce\u00d0\5 \21\2\u00cf\u00cb\3\2\2\2\u00cf\u00cc\3\2\2\2\u00cf\u00cd"+
		"\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\35\3\2\2\2\u00d1\u00d2\5 \21\2\u00d2"+
		"\u00d3\7\31\2\2\u00d3\u00d4\7 \2\2\u00d4\u00d5\7\31\2\2\u00d5\u00d6\5"+
		" \21\2\u00d6\37\3\2\2\2\u00d7\u00d8\5> \2\u00d8\u00d9\7\30\2\2\u00d9\u00da"+
		"\5\"\22\2\u00da!\3\2\2\2\u00db\u00e1\5> \2\u00dc\u00dd\5> \2\u00dd\u00de"+
		"\7\30\2\2\u00de\u00df\5\"\22\2\u00df\u00e1\3\2\2\2\u00e0\u00db\3\2\2\2"+
		"\u00e0\u00dc\3\2\2\2\u00e1#\3\2\2\2\u00e2\u00e3\7\'\2\2\u00e3\u00e8\7"+
		"*\2\2\u00e4\u00e5\7(\2\2\u00e5\u00e8\7*\2\2\u00e6\u00e8\7)\2\2\u00e7\u00e2"+
		"\3\2\2\2\u00e7\u00e4\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8%\3\2\2\2\u00e9"+
		"\u00ea\5 \21\2\u00ea\u00eb\7\n\2\2\u00eb\u00ec\5 \21\2\u00ec\u00ed\7\13"+
		"\2\2\u00ed\u00ee\5 \21\2\u00ee\'\3\2\2\2\u00ef\u00f0\5*\26\2\u00f0\u00f1"+
		"\7\n\2\2\u00f1\u00f2\5,\27\2\u00f2)\3\2\2\2\u00f3\u00f6\5 \21\2\u00f4"+
		"\u00f6\5\36\20\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6+\3\2\2"+
		"\2\u00f7\u00fb\5 \21\2\u00f8\u00fb\5(\25\2\u00f9\u00fb\5\36\20\2\u00fa"+
		"\u00f7\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb-\3\2\2\2"+
		"\u00fc\u00fd\5:\36\2\u00fd\u00fe\5<\37\2\u00fe\u0101\7\21\2\2\u00ff\u0102"+
		"\5\34\17\2\u0100\u0102\5> \2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u0104\7\22\2\2\u0104\u010a\7\25\2\2\u0105\u0106\5"+
		"\60\31\2\u0106\u0107\7\27\2\2\u0107\u0109\3\2\2\2\u0108\u0105\3\2\2\2"+
		"\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010e"+
		"\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010f\5\60\31\2\u010e\u010d\3\2\2\2"+
		"\u010e\u010f\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\7\26\2\2\u0111/\3"+
		"\2\2\2\u0112\u0116\5\66\34\2\u0113\u0117\5\62\32\2\u0114\u0117\5\64\33"+
		"\2\u0115\u0117\58\35\2\u0116\u0113\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0115"+
		"\3\2\2\2\u0117\61\3\2\2\2\u0118\u011a\5<\37\2\u0119\u0118\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011e\7\21\2\2\u011c\u011f\5"+
		"\34\17\2\u011d\u011f\5> \2\u011e\u011c\3\2\2\2\u011e\u011d\3\2\2\2\u011f"+
		"\u0122\3\2\2\2\u0120\u0121\7\16\2\2\u0121\u0123\5> \2\u0122\u0120\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126\7\22\2\2\u0125"+
		"\u0127\t\3\2\2\u0126\u0125\3\2\2\2\u0126\u0127\3\2\2\2\u0127\63\3\2\2"+
		"\2\u0128\u0129\7\"\2\2\u0129\65\3\2\2\2\u012a\u012d\58\35\2\u012b\u012d"+
		"\7\35\2\2\u012c\u012a\3\2\2\2\u012c\u012b\3\2\2\2\u012d\67\3\2\2\2\u012e"+
		"\u012f\5<\37\2\u012f\u0130\5> \2\u01309\3\2\2\2\u0131\u0137\5\66\34\2"+
		"\u0132\u0133\7\17\2\2\u0133\u0134\5> \2\u0134\u0135\7\20\2\2\u0135\u0137"+
		"\3\2\2\2\u0136\u0131\3\2\2\2\u0136\u0132\3\2\2\2\u0137;\3\2\2\2\u0138"+
		"\u013b\5> \2\u0139\u013b\7&\2\2\u013a\u0138\3\2\2\2\u013a\u0139\3\2\2"+
		"\2\u013b=\3\2\2\2\u013c\u013d\t\4\2\2\u013d?\3\2\2\2\37CISjo}\u0082\u0098"+
		"\u009d\u00a1\u00a5\u00c2\u00c9\u00cf\u00e0\u00e7\u00f5\u00fa\u0101\u010a"+
		"\u010e\u0116\u0119\u011e\u0122\u0126\u012c\u0136\u013a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}