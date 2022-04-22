// Generated from ShExMLParser.g4 by ANTLR 4.9.2

package com.herminiogarcia.shexml.antlr;

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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREFIX=1, SOURCE=2, QUERY=3, ITERATOR=4, FUNCTIONS=5, FIELD=6, PUSHED_FIELD=7, 
		POPPED_FIELD=8, AUTOINCREMENT=9, EXPRESSION=10, UNION=11, JOIN=12, MATCHER=13, 
		AS=14, MATCHING=15, RDFLIST=16, RDFBAG=17, RDFSEQ=18, RDFALT=19, LESS_SYMBOL=20, 
		GREATER_SYMBOL=21, BRACKET_LEFT=22, DOUBLE_BRACKET_LEFT=23, BRACKET_RIGHT=24, 
		DOUBLE_BRACKET_RIGHT=25, PAREN_LEFT=26, PAREN_RIGHT=27, BRACE_LEFT=28, 
		BRACE_RIGHT=29, SEMICOLON=30, DOT=31, ADD=32, COMMA=33, QUOTE=34, AND=35, 
		A=36, AT=37, STRING_OR_VAR=38, URI_VAR=39, STRINGOPERATOR=40, XMLSCHEMADATATYPE=41, 
		SHAPELINK=42, LANGTAG=43, COMMENT=44, WS=45, URL=46, JDBC_URL=47, JSONPATH=48, 
		XMLPATH=49, CSVPERROW=50, SQL=51, SCALA=52, SPARQL=53, QUERY_PART=54, 
		GREATER_SYMBOL_QUERY=55, WS_QUERY=56, LESS_SYMBOL_QUERY=57, STRING_OR_VAR_QUERY=58, 
		URI_VAR_QUERY=59, WS_DECLARATION=60, LESS_SYMBOL_AUTOINCREMENT=61, TO=62, 
		BY=63, ADD_AUTOINCREMENT=64, DIGITS=65, STRING_OR_VAR_AUTOINCREMENT=66, 
		STRINGOPERATOR_AUTOINCREMENT=67, GREATER_SYMBOL_AUTOINCREMENT=68, WS_AUTOINCREMENT=69;
	public static final int
		RULE_shExML = 0, RULE_decl = 1, RULE_prefix = 2, RULE_source = 3, RULE_query = 4, 
		RULE_functions = 5, RULE_iterator = 6, RULE_nestedIterator = 7, RULE_field = 8, 
		RULE_autoincrement = 9, RULE_expression = 10, RULE_matcher = 11, RULE_matchers = 12, 
		RULE_replacedStrings = 13, RULE_exp = 14, RULE_stringOperation = 15, RULE_iteratorQuery = 16, 
		RULE_composedVariable = 17, RULE_queryClause = 18, RULE_join = 19, RULE_union = 20, 
		RULE_leftUnionOption = 21, RULE_rightUnionOption = 22, RULE_graph = 23, 
		RULE_shape = 24, RULE_actionOrLiteral = 25, RULE_literalSubject = 26, 
		RULE_action = 27, RULE_predicateObject = 28, RULE_objectElement = 29, 
		RULE_firstPartObjectElement = 30, RULE_valueRetriever = 31, RULE_functionCalling = 32, 
		RULE_functionArguments = 33, RULE_rdfCollection = 34, RULE_xmlschemadatatype = 35, 
		RULE_langtag = 36, RULE_shapeLink = 37, RULE_predicate = 38, RULE_literalValue = 39, 
		RULE_tripleElement = 40, RULE_prefixVar = 41, RULE_variable = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"shExML", "decl", "prefix", "source", "query", "functions", "iterator", 
			"nestedIterator", "field", "autoincrement", "expression", "matcher", 
			"matchers", "replacedStrings", "exp", "stringOperation", "iteratorQuery", 
			"composedVariable", "queryClause", "join", "union", "leftUnionOption", 
			"rightUnionOption", "graph", "shape", "actionOrLiteral", "literalSubject", 
			"action", "predicateObject", "objectElement", "firstPartObjectElement", 
			"valueRetriever", "functionCalling", "functionArguments", "rdfCollection", 
			"xmlschemadatatype", "langtag", "shapeLink", "predicate", "literalValue", 
			"tripleElement", "prefixVar", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "'['", "'[['", 
			"']'", "']]'", "'('", "')'", "'{'", "'}'", "';'", "'.'", null, "','", 
			"'\"'", null, null, "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FUNCTIONS", "FIELD", 
			"PUSHED_FIELD", "POPPED_FIELD", "AUTOINCREMENT", "EXPRESSION", "UNION", 
			"JOIN", "MATCHER", "AS", "MATCHING", "RDFLIST", "RDFBAG", "RDFSEQ", "RDFALT", 
			"LESS_SYMBOL", "GREATER_SYMBOL", "BRACKET_LEFT", "DOUBLE_BRACKET_LEFT", 
			"BRACKET_RIGHT", "DOUBLE_BRACKET_RIGHT", "PAREN_LEFT", "PAREN_RIGHT", 
			"BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "ADD", "COMMA", "QUOTE", 
			"AND", "A", "AT", "STRING_OR_VAR", "URI_VAR", "STRINGOPERATOR", "XMLSCHEMADATATYPE", 
			"SHAPELINK", "LANGTAG", "COMMENT", "WS", "URL", "JDBC_URL", "JSONPATH", 
			"XMLPATH", "CSVPERROW", "SQL", "SCALA", "SPARQL", "QUERY_PART", "GREATER_SYMBOL_QUERY", 
			"WS_QUERY", "LESS_SYMBOL_QUERY", "STRING_OR_VAR_QUERY", "URI_VAR_QUERY", 
			"WS_DECLARATION", "LESS_SYMBOL_AUTOINCREMENT", "TO", "BY", "ADD_AUTOINCREMENT", 
			"DIGITS", "STRING_OR_VAR_AUTOINCREMENT", "STRINGOPERATOR_AUTOINCREMENT", 
			"GREATER_SYMBOL_AUTOINCREMENT", "WS_AUTOINCREMENT"
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
		public List<GraphContext> graph() {
			return getRuleContexts(GraphContext.class);
		}
		public GraphContext graph(int i) {
			return getRuleContext(GraphContext.class,i);
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
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFIX) | (1L << SOURCE) | (1L << QUERY) | (1L << ITERATOR) | (1L << FUNCTIONS) | (1L << AUTOINCREMENT) | (1L << EXPRESSION) | (1L << MATCHER))) != 0)) {
				{
				{
				setState(86);
				decl();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LESS_SYMBOL - 20)) | (1L << (A - 20)) | (1L << (STRING_OR_VAR - 20)) | (1L << (URI_VAR - 20)) | (1L << (URL - 20)) | (1L << (STRING_OR_VAR_QUERY - 20)) | (1L << (URI_VAR_QUERY - 20)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 20)))) != 0)) {
				{
				setState(94);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(92);
					shape();
					}
					break;
				case 2:
					{
					setState(93);
					graph();
					}
					break;
				}
				}
				setState(98);
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
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
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
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SOURCE:
				{
				setState(99);
				source();
				}
				break;
			case PREFIX:
				{
				setState(100);
				prefix();
				}
				break;
			case QUERY:
				{
				setState(101);
				query();
				}
				break;
			case EXPRESSION:
				{
				setState(102);
				expression();
				}
				break;
			case MATCHER:
				{
				setState(103);
				matcher();
				}
				break;
			case ITERATOR:
				{
				setState(104);
				iterator();
				}
				break;
			case AUTOINCREMENT:
				{
				setState(105);
				autoincrement();
				}
				break;
			case FUNCTIONS:
				{
				setState(106);
				functions();
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
			setState(109);
			match(PREFIX);
			setState(110);
			variable();
			setState(111);
			match(LESS_SYMBOL_QUERY);
			setState(112);
			match(URL);
			setState(113);
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
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public TerminalNode URL() { return getToken(ShExMLParser.URL, 0); }
		public TerminalNode JDBC_URL() { return getToken(ShExMLParser.JDBC_URL, 0); }
		public TerminalNode QUERY_PART() { return getToken(ShExMLParser.QUERY_PART, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(SOURCE);
			setState(116);
			variable();
			setState(117);
			match(LESS_SYMBOL_QUERY);
			setState(118);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << URL) | (1L << JDBC_URL) | (1L << QUERY_PART))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(119);
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
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public TerminalNode URL() { return getToken(ShExMLParser.URL, 0); }
		public QueryClauseContext queryClause() {
			return getRuleContext(QueryClauseContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(QUERY);
			setState(122);
			variable();
			setState(123);
			match(LESS_SYMBOL_QUERY);
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case URL:
				{
				setState(124);
				match(URL);
				}
				break;
			case JSONPATH:
			case XMLPATH:
			case CSVPERROW:
			case SQL:
			case SPARQL:
				{
				setState(125);
				queryClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(128);
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

	public static class FunctionsContext extends ParserRuleContext {
		public TerminalNode FUNCTIONS() { return getToken(ShExMLParser.FUNCTIONS, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LESS_SYMBOL_QUERY() { return getToken(ShExMLParser.LESS_SYMBOL_QUERY, 0); }
		public TerminalNode SCALA() { return getToken(ShExMLParser.SCALA, 0); }
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public TerminalNode URL() { return getToken(ShExMLParser.URL, 0); }
		public TerminalNode QUERY_PART() { return getToken(ShExMLParser.QUERY_PART, 0); }
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(FUNCTIONS);
			setState(131);
			variable();
			setState(132);
			match(LESS_SYMBOL_QUERY);
			setState(133);
			match(SCALA);
			setState(134);
			_la = _input.LA(1);
			if ( !(_la==URL || _la==QUERY_PART) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(135);
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
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public TerminalNode BRACE_LEFT() { return getToken(ShExMLParser.BRACE_LEFT, 0); }
		public TerminalNode BRACE_RIGHT() { return getToken(ShExMLParser.BRACE_RIGHT, 0); }
		public QueryClauseContext queryClause() {
			return getRuleContext(QueryClauseContext.class,0);
		}
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
		public List<TerminalNode> QUERY_PART() { return getTokens(ShExMLParser.QUERY_PART); }
		public TerminalNode QUERY_PART(int i) {
			return getToken(ShExMLParser.QUERY_PART, i);
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
		enterRule(_localctx, 12, RULE_iterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(ITERATOR);
			setState(138);
			variable();
			setState(139);
			match(LESS_SYMBOL_QUERY);
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONPATH:
			case XMLPATH:
			case CSVPERROW:
			case SQL:
			case SPARQL:
				{
				setState(140);
				queryClause();
				}
				break;
			case QUERY_PART:
				{
				setState(142); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(141);
					match(QUERY_PART);
					}
					}
					setState(144); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(148);
			match(GREATER_SYMBOL_QUERY);
			setState(149);
			match(BRACE_LEFT);
			setState(151); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(150);
				field();
				}
				}
				setState(153); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0) );
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ITERATOR) {
				{
				{
				setState(155);
				nestedIterator();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
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
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public TerminalNode BRACE_LEFT() { return getToken(ShExMLParser.BRACE_LEFT, 0); }
		public TerminalNode BRACE_RIGHT() { return getToken(ShExMLParser.BRACE_RIGHT, 0); }
		public List<TerminalNode> QUERY_PART() { return getTokens(ShExMLParser.QUERY_PART); }
		public TerminalNode QUERY_PART(int i) {
			return getToken(ShExMLParser.QUERY_PART, i);
		}
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
		enterRule(_localctx, 14, RULE_nestedIterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(ITERATOR);
			setState(164);
			variable();
			setState(165);
			match(LESS_SYMBOL_QUERY);
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				match(QUERY_PART);
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUERY_PART );
			setState(171);
			match(GREATER_SYMBOL_QUERY);
			setState(172);
			match(BRACE_LEFT);
			setState(174); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(173);
				field();
				}
				}
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0) );
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ITERATOR) {
				{
				{
				setState(178);
				nestedIterator();
				}
				}
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(184);
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
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LESS_SYMBOL_QUERY() { return getToken(ShExMLParser.LESS_SYMBOL_QUERY, 0); }
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public TerminalNode FIELD() { return getToken(ShExMLParser.FIELD, 0); }
		public TerminalNode PUSHED_FIELD() { return getToken(ShExMLParser.PUSHED_FIELD, 0); }
		public TerminalNode POPPED_FIELD() { return getToken(ShExMLParser.POPPED_FIELD, 0); }
		public List<TerminalNode> QUERY_PART() { return getTokens(ShExMLParser.QUERY_PART); }
		public TerminalNode QUERY_PART(int i) {
			return getToken(ShExMLParser.QUERY_PART, i);
		}
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
		enterRule(_localctx, 16, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(187);
			variable();
			setState(188);
			match(LESS_SYMBOL_QUERY);
			setState(190); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(189);
				match(QUERY_PART);
				}
				}
				setState(192); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUERY_PART );
			setState(194);
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
		enterRule(_localctx, 18, RULE_autoincrement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(AUTOINCREMENT);
			setState(197);
			variable();
			setState(198);
			match(LESS_SYMBOL_AUTOINCREMENT);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGOPERATOR_AUTOINCREMENT) {
				{
				setState(199);
				match(STRINGOPERATOR_AUTOINCREMENT);
				setState(200);
				match(ADD_AUTOINCREMENT);
				}
			}

			setState(203);
			match(DIGITS);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(204);
				match(TO);
				setState(205);
				match(DIGITS);
				}
			}

			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BY) {
				{
				setState(208);
				match(BY);
				setState(209);
				match(DIGITS);
				}
			}

			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD_AUTOINCREMENT) {
				{
				setState(212);
				match(ADD_AUTOINCREMENT);
				setState(213);
				match(STRINGOPERATOR_AUTOINCREMENT);
				}
			}

			setState(216);
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
		enterRule(_localctx, 20, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(EXPRESSION);
			setState(219);
			variable();
			setState(220);
			match(LESS_SYMBOL);
			setState(221);
			exp();
			setState(222);
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
		enterRule(_localctx, 22, RULE_matcher);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(MATCHER);
			setState(225);
			variable();
			setState(226);
			match(LESS_SYMBOL);
			setState(227);
			matchers(0);
			setState(228);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_matchers, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(231);
			replacedStrings();
			setState(232);
			match(AS);
			setState(233);
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
			setState(243);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MatchersContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_matchers);
					setState(235);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(236);
					match(AND);
					setState(237);
					replacedStrings();
					setState(238);
					match(AS);
					setState(239);
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
				setState(245);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		enterRule(_localctx, 26, RULE_replacedStrings);
		int _la;
		try {
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				_la = _input.LA(1);
				if ( !(_la==STRING_OR_VAR || _la==STRINGOPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(247);
				match(COMMA);
				setState(248);
				replacedStrings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
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
		enterRule(_localctx, 28, RULE_exp);
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				union();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				join();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				stringOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(255);
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
		enterRule(_localctx, 30, RULE_stringOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			iteratorQuery();
			setState(259);
			match(ADD);
			setState(260);
			match(STRINGOPERATOR);
			setState(261);
			match(ADD);
			setState(262);
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
		enterRule(_localctx, 32, RULE_iteratorQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			variable();
			setState(265);
			match(DOT);
			setState(266);
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
		enterRule(_localctx, 34, RULE_composedVariable);
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				variable();
				setState(270);
				match(DOT);
				setState(271);
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
		public List<TerminalNode> QUERY_PART() { return getTokens(ShExMLParser.QUERY_PART); }
		public TerminalNode QUERY_PART(int i) {
			return getToken(ShExMLParser.QUERY_PART, i);
		}
		public TerminalNode XMLPATH() { return getToken(ShExMLParser.XMLPATH, 0); }
		public TerminalNode CSVPERROW() { return getToken(ShExMLParser.CSVPERROW, 0); }
		public TerminalNode SQL() { return getToken(ShExMLParser.SQL, 0); }
		public TerminalNode SPARQL() { return getToken(ShExMLParser.SPARQL, 0); }
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
		enterRule(_localctx, 36, RULE_queryClause);
		int _la;
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONPATH:
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				match(JSONPATH);
				setState(277); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(276);
					match(QUERY_PART);
					}
					}
					setState(279); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case XMLPATH:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				match(XMLPATH);
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(282);
					match(QUERY_PART);
					}
					}
					setState(285); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case CSVPERROW:
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				match(CSVPERROW);
				}
				break;
			case SQL:
				enterOuterAlt(_localctx, 4);
				{
				setState(288);
				match(SQL);
				setState(290); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(289);
					match(QUERY_PART);
					}
					}
					setState(292); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case SPARQL:
				enterOuterAlt(_localctx, 5);
				{
				setState(294);
				match(SPARQL);
				setState(296); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(295);
					match(QUERY_PART);
					}
					}
					setState(298); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
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
		enterRule(_localctx, 38, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			iteratorQuery();
			setState(303);
			match(UNION);
			setState(304);
			iteratorQuery();
			setState(305);
			match(JOIN);
			setState(306);
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
		enterRule(_localctx, 40, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			leftUnionOption();
			setState(309);
			match(UNION);
			setState(310);
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
		enterRule(_localctx, 42, RULE_leftUnionOption);
		try {
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
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
		enterRule(_localctx, 44, RULE_rightUnionOption);
		try {
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(318);
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

	public static class GraphContext extends ParserRuleContext {
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public TerminalNode DOUBLE_BRACKET_LEFT() { return getToken(ShExMLParser.DOUBLE_BRACKET_LEFT, 0); }
		public TerminalNode DOUBLE_BRACKET_RIGHT() { return getToken(ShExMLParser.DOUBLE_BRACKET_RIGHT, 0); }
		public List<ShapeContext> shape() {
			return getRuleContexts(ShapeContext.class);
		}
		public ShapeContext shape(int i) {
			return getRuleContext(ShapeContext.class,i);
		}
		public GraphContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graph; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterGraph(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitGraph(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitGraph(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphContext graph() throws RecognitionException {
		GraphContext _localctx = new GraphContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			literalValue();
			setState(322);
			match(DOUBLE_BRACKET_LEFT);
			setState(324); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(323);
				shape();
				}
				}
				setState(326); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 20)) & ~0x3f) == 0 && ((1L << (_la - 20)) & ((1L << (LESS_SYMBOL - 20)) | (1L << (A - 20)) | (1L << (STRING_OR_VAR - 20)) | (1L << (URI_VAR - 20)) | (1L << (URL - 20)) | (1L << (STRING_OR_VAR_QUERY - 20)) | (1L << (URI_VAR_QUERY - 20)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 20)))) != 0) );
			setState(328);
			match(DOUBLE_BRACKET_RIGHT);
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
		public ActionOrLiteralContext actionOrLiteral() {
			return getRuleContext(ActionOrLiteralContext.class,0);
		}
		public TerminalNode BRACE_LEFT() { return getToken(ShExMLParser.BRACE_LEFT, 0); }
		public TerminalNode BRACE_RIGHT() { return getToken(ShExMLParser.BRACE_RIGHT, 0); }
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
		enterRule(_localctx, 48, RULE_shape);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			tripleElement();
			setState(331);
			actionOrLiteral();
			setState(332);
			match(BRACE_LEFT);
			setState(338);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(333);
					predicateObject();
					setState(334);
					match(SEMICOLON);
					}
					} 
				}
				setState(340);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 36)) & ~0x3f) == 0 && ((1L << (_la - 36)) & ((1L << (A - 36)) | (1L << (STRING_OR_VAR - 36)) | (1L << (URI_VAR - 36)) | (1L << (URL - 36)) | (1L << (STRING_OR_VAR_QUERY - 36)) | (1L << (URI_VAR_QUERY - 36)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 36)))) != 0)) {
				{
				setState(341);
				predicateObject();
				}
			}

			setState(344);
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

	public static class ActionOrLiteralContext extends ParserRuleContext {
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public LiteralSubjectContext literalSubject() {
			return getRuleContext(LiteralSubjectContext.class,0);
		}
		public ActionOrLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionOrLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterActionOrLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitActionOrLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitActionOrLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionOrLiteralContext actionOrLiteral() throws RecognitionException {
		ActionOrLiteralContext _localctx = new ActionOrLiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_actionOrLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(346);
				action();
				}
				break;
			case 2:
				{
				setState(347);
				literalSubject();
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

	public static class LiteralSubjectContext extends ParserRuleContext {
		public PrefixVarContext prefixVar() {
			return getRuleContext(PrefixVarContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public LiteralSubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalSubject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterLiteralSubject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitLiteralSubject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitLiteralSubject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralSubjectContext literalSubject() throws RecognitionException {
		LiteralSubjectContext _localctx = new LiteralSubjectContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_literalSubject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			prefixVar();
			setState(351);
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

	public static class ActionContext extends ParserRuleContext {
		public PrefixVarContext prefixVar() {
			return getRuleContext(PrefixVarContext.class,0);
		}
		public TerminalNode BRACKET_LEFT() { return getToken(ShExMLParser.BRACKET_LEFT, 0); }
		public TerminalNode BRACKET_RIGHT() { return getToken(ShExMLParser.BRACKET_RIGHT, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FunctionCallingContext functionCalling() {
			return getRuleContext(FunctionCallingContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			prefixVar();
			setState(354);
			match(BRACKET_LEFT);
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(355);
				exp();
				}
				break;
			case 2:
				{
				setState(356);
				variable();
				}
				break;
			case 3:
				{
				setState(357);
				functionCalling();
				}
				break;
			}
			setState(360);
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
		enterRule(_localctx, 56, RULE_predicateObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			predicate();
			setState(366);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(363);
				objectElement();
				}
				break;
			case 2:
				{
				setState(364);
				shapeLink();
				}
				break;
			case 3:
				{
				setState(365);
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
		public FirstPartObjectElementContext firstPartObjectElement() {
			return getRuleContext(FirstPartObjectElementContext.class,0);
		}
		public XmlschemadatatypeContext xmlschemadatatype() {
			return getRuleContext(XmlschemadatatypeContext.class,0);
		}
		public LangtagContext langtag() {
			return getRuleContext(LangtagContext.class,0);
		}
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
		enterRule(_localctx, 58, RULE_objectElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			firstPartObjectElement();
			setState(371);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT:
			case STRING_OR_VAR:
			case URI_VAR:
			case STRINGOPERATOR:
			case XMLSCHEMADATATYPE:
			case URL:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				{
				setState(369);
				xmlschemadatatype();
				}
				break;
			case AT:
			case LANGTAG:
				{
				setState(370);
				langtag();
				}
				break;
			case BRACE_RIGHT:
			case SEMICOLON:
				break;
			default:
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

	public static class FirstPartObjectElementContext extends ParserRuleContext {
		public ValueRetrieverContext valueRetriever() {
			return getRuleContext(ValueRetrieverContext.class,0);
		}
		public PrefixVarContext prefixVar() {
			return getRuleContext(PrefixVarContext.class,0);
		}
		public FirstPartObjectElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_firstPartObjectElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterFirstPartObjectElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitFirstPartObjectElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitFirstPartObjectElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FirstPartObjectElementContext firstPartObjectElement() throws RecognitionException {
		FirstPartObjectElementContext _localctx = new FirstPartObjectElementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_firstPartObjectElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & ((1L << (STRING_OR_VAR - 38)) | (1L << (URI_VAR - 38)) | (1L << (URL - 38)) | (1L << (STRING_OR_VAR_QUERY - 38)) | (1L << (URI_VAR_QUERY - 38)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 38)))) != 0)) {
				{
				setState(373);
				prefixVar();
				}
			}

			setState(376);
			valueRetriever();
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

	public static class ValueRetrieverContext extends ParserRuleContext {
		public TerminalNode BRACKET_LEFT() { return getToken(ShExMLParser.BRACKET_LEFT, 0); }
		public TerminalNode BRACKET_RIGHT() { return getToken(ShExMLParser.BRACKET_RIGHT, 0); }
		public TerminalNode STRINGOPERATOR() { return getToken(ShExMLParser.STRINGOPERATOR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public FunctionCallingContext functionCalling() {
			return getRuleContext(FunctionCallingContext.class,0);
		}
		public TerminalNode MATCHING() { return getToken(ShExMLParser.MATCHING, 0); }
		public TerminalNode AS() { return getToken(ShExMLParser.AS, 0); }
		public RdfCollectionContext rdfCollection() {
			return getRuleContext(RdfCollectionContext.class,0);
		}
		public ValueRetrieverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueRetriever; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterValueRetriever(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitValueRetriever(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitValueRetriever(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueRetrieverContext valueRetriever() throws RecognitionException {
		ValueRetrieverContext _localctx = new ValueRetrieverContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_valueRetriever);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT:
				{
				setState(378);
				match(BRACKET_LEFT);
				setState(382);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					setState(379);
					exp();
					}
					break;
				case 2:
					{
					setState(380);
					variable();
					}
					break;
				case 3:
					{
					setState(381);
					functionCalling();
					}
					break;
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MATCHING) {
					{
					setState(384);
					match(MATCHING);
					setState(385);
					variable();
					}
				}

				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(388);
					match(AS);
					setState(389);
					rdfCollection();
					}
				}

				setState(392);
				match(BRACKET_RIGHT);
				}
				break;
			case STRINGOPERATOR:
				{
				setState(394);
				match(STRINGOPERATOR);
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

	public static class FunctionCallingContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode DOT() { return getToken(ShExMLParser.DOT, 0); }
		public TerminalNode PAREN_LEFT() { return getToken(ShExMLParser.PAREN_LEFT, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public TerminalNode PAREN_RIGHT() { return getToken(ShExMLParser.PAREN_RIGHT, 0); }
		public FunctionCallingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCalling; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterFunctionCalling(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitFunctionCalling(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitFunctionCalling(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallingContext functionCalling() throws RecognitionException {
		FunctionCallingContext _localctx = new FunctionCallingContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_functionCalling);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			variable();
			setState(398);
			match(DOT);
			setState(399);
			variable();
			setState(400);
			match(PAREN_LEFT);
			setState(401);
			functionArguments();
			setState(402);
			match(PAREN_RIGHT);
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

	public static class FunctionArgumentsContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(ShExMLParser.COMMA, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitFunctionArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitFunctionArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_functionArguments);
		try {
			setState(415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(406);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(404);
					exp();
					}
					break;
				case 2:
					{
					setState(405);
					variable();
					}
					break;
				}
				setState(408);
				match(COMMA);
				setState(409);
				functionArguments();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(413);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
				case 1:
					{
					setState(411);
					exp();
					}
					break;
				case 2:
					{
					setState(412);
					variable();
					}
					break;
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

	public static class RdfCollectionContext extends ParserRuleContext {
		public TerminalNode RDFLIST() { return getToken(ShExMLParser.RDFLIST, 0); }
		public TerminalNode RDFBAG() { return getToken(ShExMLParser.RDFBAG, 0); }
		public TerminalNode RDFSEQ() { return getToken(ShExMLParser.RDFSEQ, 0); }
		public TerminalNode RDFALT() { return getToken(ShExMLParser.RDFALT, 0); }
		public RdfCollectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rdfCollection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterRdfCollection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitRdfCollection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitRdfCollection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RdfCollectionContext rdfCollection() throws RecognitionException {
		RdfCollectionContext _localctx = new RdfCollectionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_rdfCollection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RDFLIST) | (1L << RDFBAG) | (1L << RDFSEQ) | (1L << RDFALT))) != 0)) ) {
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

	public static class XmlschemadatatypeContext extends ParserRuleContext {
		public TerminalNode XMLSCHEMADATATYPE() { return getToken(ShExMLParser.XMLSCHEMADATATYPE, 0); }
		public FirstPartObjectElementContext firstPartObjectElement() {
			return getRuleContext(FirstPartObjectElementContext.class,0);
		}
		public XmlschemadatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xmlschemadatatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterXmlschemadatatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitXmlschemadatatype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitXmlschemadatatype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlschemadatatypeContext xmlschemadatatype() throws RecognitionException {
		XmlschemadatatypeContext _localctx = new XmlschemadatatypeContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_xmlschemadatatype);
		try {
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case XMLSCHEMADATATYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				match(XMLSCHEMADATATYPE);
				}
				break;
			case BRACKET_LEFT:
			case STRING_OR_VAR:
			case URI_VAR:
			case STRINGOPERATOR:
			case URL:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				firstPartObjectElement();
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

	public static class LangtagContext extends ParserRuleContext {
		public TerminalNode LANGTAG() { return getToken(ShExMLParser.LANGTAG, 0); }
		public TerminalNode AT() { return getToken(ShExMLParser.AT, 0); }
		public ValueRetrieverContext valueRetriever() {
			return getRuleContext(ValueRetrieverContext.class,0);
		}
		public LangtagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_langtag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterLangtag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitLangtag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitLangtag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LangtagContext langtag() throws RecognitionException {
		LangtagContext _localctx = new LangtagContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_langtag);
		try {
			setState(426);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LANGTAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				match(LANGTAG);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				match(AT);
				setState(425);
				valueRetriever();
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
		enterRule(_localctx, 74, RULE_shapeLink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
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
		enterRule(_localctx, 76, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				{
				setState(430);
				literalValue();
				}
				break;
			case A:
				{
				setState(431);
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
		enterRule(_localctx, 78, RULE_literalValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
			prefixVar();
			setState(435);
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
		enterRule(_localctx, 80, RULE_tripleElement);
		try {
			setState(442);
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
				setState(437);
				predicate();
				}
				break;
			case LESS_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				match(LESS_SYMBOL);
				setState(439);
				variable();
				setState(440);
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
		enterRule(_localctx, 82, RULE_prefixVar);
		try {
			setState(446);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				variable();
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
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
		enterRule(_localctx, 84, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			_la = _input.LA(1);
			if ( !(((((_la - 38)) & ~0x3f) == 0 && ((1L << (_la - 38)) & ((1L << (STRING_OR_VAR - 38)) | (1L << (URI_VAR - 38)) | (1L << (STRING_OR_VAR_QUERY - 38)) | (1L << (URI_VAR_QUERY - 38)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 38)))) != 0)) ) {
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
		case 12:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3G\u01c5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\7\2Z\n\2\f\2\16\2]\13\2\3\2\3\2\7\2a\n\2\f\2\16\2d\13\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3n\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\u0081\n\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\6\b\u0091\n\b\r\b\16\b\u0092\5\b\u0095"+
		"\n\b\3\b\3\b\3\b\6\b\u009a\n\b\r\b\16\b\u009b\3\b\7\b\u009f\n\b\f\b\16"+
		"\b\u00a2\13\b\3\b\3\b\3\t\3\t\3\t\3\t\6\t\u00aa\n\t\r\t\16\t\u00ab\3\t"+
		"\3\t\3\t\6\t\u00b1\n\t\r\t\16\t\u00b2\3\t\7\t\u00b6\n\t\f\t\16\t\u00b9"+
		"\13\t\3\t\3\t\3\n\3\n\3\n\3\n\6\n\u00c1\n\n\r\n\16\n\u00c2\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00cc\n\13\3\13\3\13\3\13\5\13\u00d1\n\13\3"+
		"\13\3\13\5\13\u00d5\n\13\3\13\3\13\5\13\u00d9\n\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16\u00f4\n\16\f\16\16\16\u00f7\13\16\3\17\3"+
		"\17\3\17\3\17\5\17\u00fd\n\17\3\20\3\20\3\20\3\20\5\20\u0103\n\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0114\n\23\3\24\3\24\6\24\u0118\n\24\r\24\16\24\u0119\3\24\3\24"+
		"\6\24\u011e\n\24\r\24\16\24\u011f\3\24\3\24\3\24\6\24\u0125\n\24\r\24"+
		"\16\24\u0126\3\24\3\24\6\24\u012b\n\24\r\24\16\24\u012c\5\24\u012f\n\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\5\27\u013d"+
		"\n\27\3\30\3\30\3\30\5\30\u0142\n\30\3\31\3\31\3\31\6\31\u0147\n\31\r"+
		"\31\16\31\u0148\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0153\n\32"+
		"\f\32\16\32\u0156\13\32\3\32\5\32\u0159\n\32\3\32\3\32\3\33\3\33\5\33"+
		"\u015f\n\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5\35\u0169\n\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\36\5\36\u0171\n\36\3\37\3\37\3\37\5\37\u0176"+
		"\n\37\3 \5 \u0179\n \3 \3 \3!\3!\3!\3!\5!\u0181\n!\3!\3!\5!\u0185\n!\3"+
		"!\3!\5!\u0189\n!\3!\3!\3!\5!\u018e\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3"+
		"#\5#\u0199\n#\3#\3#\3#\3#\3#\5#\u01a0\n#\5#\u01a2\n#\3$\3$\3%\3%\5%\u01a8"+
		"\n%\3&\3&\3&\5&\u01ad\n&\3\'\3\'\3(\3(\5(\u01b3\n(\3)\3)\3)\3*\3*\3*\3"+
		"*\3*\5*\u01bd\n*\3+\3+\5+\u01c1\n+\3,\3,\3,\2\3\32-\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTV\2\b\4\2\60"+
		"\6188\4\2\60\6088\3\2\b\n\4\2((**\3\2\22\25\5\2()<=DD\2\u01d9\2[\3\2\2"+
		"\2\4m\3\2\2\2\6o\3\2\2\2\bu\3\2\2\2\n{\3\2\2\2\f\u0084\3\2\2\2\16\u008b"+
		"\3\2\2\2\20\u00a5\3\2\2\2\22\u00bc\3\2\2\2\24\u00c6\3\2\2\2\26\u00dc\3"+
		"\2\2\2\30\u00e2\3\2\2\2\32\u00e8\3\2\2\2\34\u00fc\3\2\2\2\36\u0102\3\2"+
		"\2\2 \u0104\3\2\2\2\"\u010a\3\2\2\2$\u0113\3\2\2\2&\u012e\3\2\2\2(\u0130"+
		"\3\2\2\2*\u0136\3\2\2\2,\u013c\3\2\2\2.\u0141\3\2\2\2\60\u0143\3\2\2\2"+
		"\62\u014c\3\2\2\2\64\u015e\3\2\2\2\66\u0160\3\2\2\28\u0163\3\2\2\2:\u016c"+
		"\3\2\2\2<\u0172\3\2\2\2>\u0178\3\2\2\2@\u018d\3\2\2\2B\u018f\3\2\2\2D"+
		"\u01a1\3\2\2\2F\u01a3\3\2\2\2H\u01a7\3\2\2\2J\u01ac\3\2\2\2L\u01ae\3\2"+
		"\2\2N\u01b2\3\2\2\2P\u01b4\3\2\2\2R\u01bc\3\2\2\2T\u01c0\3\2\2\2V\u01c2"+
		"\3\2\2\2XZ\5\4\3\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\b\3\2\2\2"+
		"][\3\2\2\2^a\5\62\32\2_a\5\60\31\2`^\3\2\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2"+
		"\2\2bc\3\2\2\2c\3\3\2\2\2db\3\2\2\2en\5\b\5\2fn\5\6\4\2gn\5\n\6\2hn\5"+
		"\26\f\2in\5\30\r\2jn\5\16\b\2kn\5\24\13\2ln\5\f\7\2me\3\2\2\2mf\3\2\2"+
		"\2mg\3\2\2\2mh\3\2\2\2mi\3\2\2\2mj\3\2\2\2mk\3\2\2\2ml\3\2\2\2n\5\3\2"+
		"\2\2op\7\3\2\2pq\5V,\2qr\7;\2\2rs\7\60\2\2st\79\2\2t\7\3\2\2\2uv\7\4\2"+
		"\2vw\5V,\2wx\7;\2\2xy\t\2\2\2yz\79\2\2z\t\3\2\2\2{|\7\5\2\2|}\5V,\2}\u0080"+
		"\7;\2\2~\u0081\7\60\2\2\177\u0081\5&\24\2\u0080~\3\2\2\2\u0080\177\3\2"+
		"\2\2\u0081\u0082\3\2\2\2\u0082\u0083\79\2\2\u0083\13\3\2\2\2\u0084\u0085"+
		"\7\7\2\2\u0085\u0086\5V,\2\u0086\u0087\7;\2\2\u0087\u0088\7\66\2\2\u0088"+
		"\u0089\t\3\2\2\u0089\u008a\79\2\2\u008a\r\3\2\2\2\u008b\u008c\7\6\2\2"+
		"\u008c\u008d\5V,\2\u008d\u0094\7;\2\2\u008e\u0095\5&\24\2\u008f\u0091"+
		"\78\2\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u008e\3\2\2\2\u0094\u0090\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u0097\79\2\2\u0097\u0099\7\36\2\2\u0098"+
		"\u009a\5\22\n\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3"+
		"\2\2\2\u009b\u009c\3\2\2\2\u009c\u00a0\3\2\2\2\u009d\u009f\5\20\t\2\u009e"+
		"\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7\37\2\2\u00a4"+
		"\17\3\2\2\2\u00a5\u00a6\7\6\2\2\u00a6\u00a7\5V,\2\u00a7\u00a9\7;\2\2\u00a8"+
		"\u00aa\78\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\79\2\2\u00ae"+
		"\u00b0\7\36\2\2\u00af\u00b1\5\22\n\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3"+
		"\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b7\3\2\2\2\u00b4"+
		"\u00b6\5\20\t\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3"+
		"\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bb\7\37\2\2\u00bb\21\3\2\2\2\u00bc\u00bd\t\4\2\2\u00bd\u00be\5V,\2"+
		"\u00be\u00c0\7;\2\2\u00bf\u00c1\78\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\79\2\2\u00c5\23\3\2\2\2\u00c6\u00c7\7\13\2\2\u00c7\u00c8\5V,\2"+
		"\u00c8\u00cb\7?\2\2\u00c9\u00ca\7E\2\2\u00ca\u00cc\7B\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00d0\7C\2\2\u00ce"+
		"\u00cf\7@\2\2\u00cf\u00d1\7C\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2"+
		"\2\u00d1\u00d4\3\2\2\2\u00d2\u00d3\7A\2\2\u00d3\u00d5\7C\2\2\u00d4\u00d2"+
		"\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d7\7B\2\2\u00d7"+
		"\u00d9\7E\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da\u00db\7F\2\2\u00db\25\3\2\2\2\u00dc\u00dd\7\f\2\2\u00dd\u00de"+
		"\5V,\2\u00de\u00df\7\26\2\2\u00df\u00e0\5\36\20\2\u00e0\u00e1\7\27\2\2"+
		"\u00e1\27\3\2\2\2\u00e2\u00e3\7\17\2\2\u00e3\u00e4\5V,\2\u00e4\u00e5\7"+
		"\26\2\2\u00e5\u00e6\5\32\16\2\u00e6\u00e7\7\27\2\2\u00e7\31\3\2\2\2\u00e8"+
		"\u00e9\b\16\1\2\u00e9\u00ea\5\34\17\2\u00ea\u00eb\7\20\2\2\u00eb\u00ec"+
		"\t\5\2\2\u00ec\u00f5\3\2\2\2\u00ed\u00ee\f\3\2\2\u00ee\u00ef\7%\2\2\u00ef"+
		"\u00f0\5\34\17\2\u00f0\u00f1\7\20\2\2\u00f1\u00f2\t\5\2\2\u00f2\u00f4"+
		"\3\2\2\2\u00f3\u00ed\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f6\3\2\2\2\u00f6\33\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\t\5\2"+
		"\2\u00f9\u00fa\7#\2\2\u00fa\u00fd\5\34\17\2\u00fb\u00fd\t\5\2\2\u00fc"+
		"\u00f8\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\35\3\2\2\2\u00fe\u0103\5*\26"+
		"\2\u00ff\u0103\5(\25\2\u0100\u0103\5 \21\2\u0101\u0103\5\"\22\2\u0102"+
		"\u00fe\3\2\2\2\u0102\u00ff\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2"+
		"\2\2\u0103\37\3\2\2\2\u0104\u0105\5\"\22\2\u0105\u0106\7\"\2\2\u0106\u0107"+
		"\7*\2\2\u0107\u0108\7\"\2\2\u0108\u0109\5\"\22\2\u0109!\3\2\2\2\u010a"+
		"\u010b\5V,\2\u010b\u010c\7!\2\2\u010c\u010d\5$\23\2\u010d#\3\2\2\2\u010e"+
		"\u0114\5V,\2\u010f\u0110\5V,\2\u0110\u0111\7!\2\2\u0111\u0112\5$\23\2"+
		"\u0112\u0114\3\2\2\2\u0113\u010e\3\2\2\2\u0113\u010f\3\2\2\2\u0114%\3"+
		"\2\2\2\u0115\u0117\7\62\2\2\u0116\u0118\78\2\2\u0117\u0116\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u012f\3\2"+
		"\2\2\u011b\u011d\7\63\2\2\u011c\u011e\78\2\2\u011d\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u012f\3\2"+
		"\2\2\u0121\u012f\7\64\2\2\u0122\u0124\7\65\2\2\u0123\u0125\78\2\2\u0124"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2"+
		"\2\2\u0127\u012f\3\2\2\2\u0128\u012a\7\67\2\2\u0129\u012b\78\2\2\u012a"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2"+
		"\2\2\u012d\u012f\3\2\2\2\u012e\u0115\3\2\2\2\u012e\u011b\3\2\2\2\u012e"+
		"\u0121\3\2\2\2\u012e\u0122\3\2\2\2\u012e\u0128\3\2\2\2\u012f\'\3\2\2\2"+
		"\u0130\u0131\5\"\22\2\u0131\u0132\7\r\2\2\u0132\u0133\5\"\22\2\u0133\u0134"+
		"\7\16\2\2\u0134\u0135\5\"\22\2\u0135)\3\2\2\2\u0136\u0137\5,\27\2\u0137"+
		"\u0138\7\r\2\2\u0138\u0139\5.\30\2\u0139+\3\2\2\2\u013a\u013d\5\"\22\2"+
		"\u013b\u013d\5 \21\2\u013c\u013a\3\2\2\2\u013c\u013b\3\2\2\2\u013d-\3"+
		"\2\2\2\u013e\u0142\5\"\22\2\u013f\u0142\5*\26\2\u0140\u0142\5 \21\2\u0141"+
		"\u013e\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0140\3\2\2\2\u0142/\3\2\2\2"+
		"\u0143\u0144\5P)\2\u0144\u0146\7\31\2\2\u0145\u0147\5\62\32\2\u0146\u0145"+
		"\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014a\u014b\7\33\2\2\u014b\61\3\2\2\2\u014c\u014d\5R*\2"+
		"\u014d\u014e\5\64\33\2\u014e\u0154\7\36\2\2\u014f\u0150\5:\36\2\u0150"+
		"\u0151\7 \2\2\u0151\u0153\3\2\2\2\u0152\u014f\3\2\2\2\u0153\u0156\3\2"+
		"\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0158\3\2\2\2\u0156"+
		"\u0154\3\2\2\2\u0157\u0159\5:\36\2\u0158\u0157\3\2\2\2\u0158\u0159\3\2"+
		"\2\2\u0159\u015a\3\2\2\2\u015a\u015b\7\37\2\2\u015b\63\3\2\2\2\u015c\u015f"+
		"\58\35\2\u015d\u015f\5\66\34\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2"+
		"\u015f\65\3\2\2\2\u0160\u0161\5T+\2\u0161\u0162\5V,\2\u0162\67\3\2\2\2"+
		"\u0163\u0164\5T+\2\u0164\u0168\7\30\2\2\u0165\u0169\5\36\20\2\u0166\u0169"+
		"\5V,\2\u0167\u0169\5B\"\2\u0168\u0165\3\2\2\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\7\32\2\2\u016b9\3\2\2\2"+
		"\u016c\u0170\5N(\2\u016d\u0171\5<\37\2\u016e\u0171\5L\'\2\u016f\u0171"+
		"\5P)\2\u0170\u016d\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u016f\3\2\2\2\u0171"+
		";\3\2\2\2\u0172\u0175\5> \2\u0173\u0176\5H%\2\u0174\u0176\5J&\2\u0175"+
		"\u0173\3\2\2\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176=\3\2\2\2"+
		"\u0177\u0179\5T+\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a"+
		"\3\2\2\2\u017a\u017b\5@!\2\u017b?\3\2\2\2\u017c\u0180\7\30\2\2\u017d\u0181"+
		"\5\36\20\2\u017e\u0181\5V,\2\u017f\u0181\5B\"\2\u0180\u017d\3\2\2\2\u0180"+
		"\u017e\3\2\2\2\u0180\u017f\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0183\7\21"+
		"\2\2\u0183\u0185\5V,\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0188"+
		"\3\2\2\2\u0186\u0187\7\20\2\2\u0187\u0189\5F$\2\u0188\u0186\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\7\32\2\2\u018b\u018e\3"+
		"\2\2\2\u018c\u018e\7*\2\2\u018d\u017c\3\2\2\2\u018d\u018c\3\2\2\2\u018e"+
		"A\3\2\2\2\u018f\u0190\5V,\2\u0190\u0191\7!\2\2\u0191\u0192\5V,\2\u0192"+
		"\u0193\7\34\2\2\u0193\u0194\5D#\2\u0194\u0195\7\35\2\2\u0195C\3\2\2\2"+
		"\u0196\u0199\5\36\20\2\u0197\u0199\5V,\2\u0198\u0196\3\2\2\2\u0198\u0197"+
		"\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\7#\2\2\u019b\u019c\5D#\2\u019c"+
		"\u01a2\3\2\2\2\u019d\u01a0\5\36\20\2\u019e\u01a0\5V,\2\u019f\u019d\3\2"+
		"\2\2\u019f\u019e\3\2\2\2\u01a0\u01a2\3\2\2\2\u01a1\u0198\3\2\2\2\u01a1"+
		"\u019f\3\2\2\2\u01a2E\3\2\2\2\u01a3\u01a4\t\6\2\2\u01a4G\3\2\2\2\u01a5"+
		"\u01a8\7+\2\2\u01a6\u01a8\5> \2\u01a7\u01a5\3\2\2\2\u01a7\u01a6\3\2\2"+
		"\2\u01a8I\3\2\2\2\u01a9\u01ad\7-\2\2\u01aa\u01ab\7\'\2\2\u01ab\u01ad\5"+
		"@!\2\u01ac\u01a9\3\2\2\2\u01ac\u01aa\3\2\2\2\u01adK\3\2\2\2\u01ae\u01af"+
		"\7,\2\2\u01afM\3\2\2\2\u01b0\u01b3\5P)\2\u01b1\u01b3\7&\2\2\u01b2\u01b0"+
		"\3\2\2\2\u01b2\u01b1\3\2\2\2\u01b3O\3\2\2\2\u01b4\u01b5\5T+\2\u01b5\u01b6"+
		"\5V,\2\u01b6Q\3\2\2\2\u01b7\u01bd\5N(\2\u01b8\u01b9\7\26\2\2\u01b9\u01ba"+
		"\5V,\2\u01ba\u01bb\7\27\2\2\u01bb\u01bd\3\2\2\2\u01bc\u01b7\3\2\2\2\u01bc"+
		"\u01b8\3\2\2\2\u01bdS\3\2\2\2\u01be\u01c1\5V,\2\u01bf\u01c1\7\60\2\2\u01c0"+
		"\u01be\3\2\2\2\u01c0\u01bf\3\2\2\2\u01c1U\3\2\2\2\u01c2\u01c3\t\7\2\2"+
		"\u01c3W\3\2\2\2\62[`bm\u0080\u0092\u0094\u009b\u00a0\u00ab\u00b2\u00b7"+
		"\u00c2\u00cb\u00d0\u00d4\u00d8\u00f5\u00fc\u0102\u0113\u0119\u011f\u0126"+
		"\u012c\u012e\u013c\u0141\u0148\u0154\u0158\u015e\u0168\u0170\u0175\u0178"+
		"\u0180\u0184\u0188\u018d\u0198\u019f\u01a1\u01a7\u01ac\u01b2\u01bc\u01c0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}