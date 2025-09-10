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
		POPPED_FIELD=8, AUTOINCREMENT=9, EXPRESSION=10, UNION=11, JOIN=12, SUBSTITUTING=13, 
		MATCHER=14, AS=15, IF=16, ON=17, MATCHING=18, RDFLIST=19, RDFBAG=20, RDFSEQ=21, 
		RDFALT=22, LESS_SYMBOL=23, GREATER_SYMBOL=24, BRACKET_LEFT=25, DOUBLE_BRACKET_LEFT=26, 
		BRACKET_RIGHT=27, DOUBLE_BRACKET_RIGHT=28, PAREN_LEFT=29, PAREN_RIGHT=30, 
		BRACE_LEFT=31, BRACE_RIGHT=32, SEMICOLON=33, DOT=34, ADD=35, COMMA=36, 
		QUOTE=37, AND=38, A=39, AT=40, EQUAL=41, INDEX=42, STRING_OR_VAR=43, URI_VAR=44, 
		STRINGOPERATOR=45, XMLSCHEMADATATYPE=46, SHAPELINK=47, LANGTAG=48, COMMENT=49, 
		WS=50, URL=51, JDBC_URL=52, JSONPATH=53, XMLPATH=54, CSVPERROW=55, SQL=56, 
		SCALA=57, SPARQL=58, STDIN=59, QUERY_PART=60, GREATER_SYMBOL_QUERY=61, 
		WS_QUERY=62, LESS_SYMBOL_QUERY=63, STRING_OR_VAR_QUERY=64, URI_VAR_QUERY=65, 
		WS_DECLARATION=66, LESS_SYMBOL_AUTOINCREMENT=67, TO=68, BY=69, ADD_AUTOINCREMENT=70, 
		DIGITS=71, STRING_OR_VAR_AUTOINCREMENT=72, STRINGOPERATOR_AUTOINCREMENT=73, 
		GREATER_SYMBOL_AUTOINCREMENT=74, WS_AUTOINCREMENT=75;
	public static final int
		RULE_shExML = 0, RULE_decl = 1, RULE_prefix = 2, RULE_source = 3, RULE_query = 4, 
		RULE_functions = 5, RULE_iterator = 6, RULE_nestedIterator = 7, RULE_field = 8, 
		RULE_autoincrement = 9, RULE_expression = 10, RULE_matcher = 11, RULE_matchers = 12, 
		RULE_replacedStrings = 13, RULE_exp = 14, RULE_stringOperation = 15, RULE_iteratorQuery = 16, 
		RULE_composedVariable = 17, RULE_builtinFunction = 18, RULE_queryClause = 19, 
		RULE_substitution = 20, RULE_join = 21, RULE_union = 22, RULE_leftUnionOption = 23, 
		RULE_rightUnionOption = 24, RULE_graph = 25, RULE_shape = 26, RULE_actionOrLiteral = 27, 
		RULE_literalSubject = 28, RULE_action = 29, RULE_predicateObject = 30, 
		RULE_objectElement = 31, RULE_firstPartObjectElement = 32, RULE_valueRetriever = 33, 
		RULE_expOrVarOrFunctionCallign = 34, RULE_functionCalling = 35, RULE_functionArguments = 36, 
		RULE_rdfCollection = 37, RULE_xmlschemadatatype = 38, RULE_langtag = 39, 
		RULE_shapeLink = 40, RULE_predicate = 41, RULE_literalValue = 42, RULE_tripleElement = 43, 
		RULE_prefixVar = 44, RULE_variable = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"shExML", "decl", "prefix", "source", "query", "functions", "iterator", 
			"nestedIterator", "field", "autoincrement", "expression", "matcher", 
			"matchers", "replacedStrings", "exp", "stringOperation", "iteratorQuery", 
			"composedVariable", "builtinFunction", "queryClause", "substitution", 
			"join", "union", "leftUnionOption", "rightUnionOption", "graph", "shape", 
			"actionOrLiteral", "literalSubject", "action", "predicateObject", "objectElement", 
			"firstPartObjectElement", "valueRetriever", "expOrVarOrFunctionCallign", 
			"functionCalling", "functionArguments", "rdfCollection", "xmlschemadatatype", 
			"langtag", "shapeLink", "predicate", "literalValue", "tripleElement", 
			"prefixVar", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'['", "'[['", "']'", "']]'", "'('", "')'", "'{'", "'}'", "';'", 
			"'.'", null, "','", "'\"'", null, null, "'@'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FUNCTIONS", "FIELD", 
			"PUSHED_FIELD", "POPPED_FIELD", "AUTOINCREMENT", "EXPRESSION", "UNION", 
			"JOIN", "SUBSTITUTING", "MATCHER", "AS", "IF", "ON", "MATCHING", "RDFLIST", 
			"RDFBAG", "RDFSEQ", "RDFALT", "LESS_SYMBOL", "GREATER_SYMBOL", "BRACKET_LEFT", 
			"DOUBLE_BRACKET_LEFT", "BRACKET_RIGHT", "DOUBLE_BRACKET_RIGHT", "PAREN_LEFT", 
			"PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "ADD", 
			"COMMA", "QUOTE", "AND", "A", "AT", "EQUAL", "INDEX", "STRING_OR_VAR", 
			"URI_VAR", "STRINGOPERATOR", "XMLSCHEMADATATYPE", "SHAPELINK", "LANGTAG", 
			"COMMENT", "WS", "URL", "JDBC_URL", "JSONPATH", "XMLPATH", "CSVPERROW", 
			"SQL", "SCALA", "SPARQL", "STDIN", "QUERY_PART", "GREATER_SYMBOL_QUERY", 
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
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFIX) | (1L << SOURCE) | (1L << QUERY) | (1L << ITERATOR) | (1L << FUNCTIONS) | (1L << AUTOINCREMENT) | (1L << EXPRESSION) | (1L << MATCHER))) != 0)) {
				{
				{
				setState(92);
				decl();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (LESS_SYMBOL - 23)) | (1L << (A - 23)) | (1L << (STRING_OR_VAR - 23)) | (1L << (URI_VAR - 23)) | (1L << (URL - 23)) | (1L << (STRING_OR_VAR_QUERY - 23)) | (1L << (URI_VAR_QUERY - 23)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 23)))) != 0)) {
				{
				setState(100);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(98);
					shape();
					}
					break;
				case 2:
					{
					setState(99);
					graph();
					}
					break;
				}
				}
				setState(104);
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
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SOURCE:
				{
				setState(105);
				source();
				}
				break;
			case PREFIX:
				{
				setState(106);
				prefix();
				}
				break;
			case QUERY:
				{
				setState(107);
				query();
				}
				break;
			case EXPRESSION:
				{
				setState(108);
				expression();
				}
				break;
			case MATCHER:
				{
				setState(109);
				matcher();
				}
				break;
			case ITERATOR:
				{
				setState(110);
				iterator();
				}
				break;
			case AUTOINCREMENT:
				{
				setState(111);
				autoincrement();
				}
				break;
			case FUNCTIONS:
				{
				setState(112);
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
			setState(115);
			match(PREFIX);
			setState(116);
			variable();
			setState(117);
			match(LESS_SYMBOL_QUERY);
			setState(118);
			match(URL);
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
		public TerminalNode STDIN() { return getToken(ShExMLParser.STDIN, 0); }
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
			setState(121);
			match(SOURCE);
			setState(122);
			variable();
			setState(123);
			match(LESS_SYMBOL_QUERY);
			setState(124);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << URL) | (1L << JDBC_URL) | (1L << STDIN) | (1L << QUERY_PART))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(125);
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
			setState(127);
			match(QUERY);
			setState(128);
			variable();
			setState(129);
			match(LESS_SYMBOL_QUERY);
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case URL:
				{
				setState(130);
				match(URL);
				}
				break;
			case JSONPATH:
			case XMLPATH:
			case CSVPERROW:
			case SQL:
			case SPARQL:
				{
				setState(131);
				queryClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(134);
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
			setState(136);
			match(FUNCTIONS);
			setState(137);
			variable();
			setState(138);
			match(LESS_SYMBOL_QUERY);
			setState(139);
			match(SCALA);
			setState(140);
			_la = _input.LA(1);
			if ( !(_la==URL || _la==QUERY_PART) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(141);
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
			setState(143);
			match(ITERATOR);
			setState(144);
			variable();
			setState(145);
			match(LESS_SYMBOL_QUERY);
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONPATH:
			case XMLPATH:
			case CSVPERROW:
			case SQL:
			case SPARQL:
				{
				setState(146);
				queryClause();
				}
				break;
			case QUERY_PART:
				{
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(147);
					match(QUERY_PART);
					}
					}
					setState(150); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(154);
			match(GREATER_SYMBOL_QUERY);
			setState(155);
			match(BRACE_LEFT);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ITERATOR) | (1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0)) {
				{
				setState(158);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FIELD:
				case PUSHED_FIELD:
				case POPPED_FIELD:
					{
					setState(156);
					field();
					}
					break;
				case ITERATOR:
					{
					setState(157);
					nestedIterator();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
			setState(165);
			match(ITERATOR);
			setState(166);
			variable();
			setState(167);
			match(LESS_SYMBOL_QUERY);
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				match(QUERY_PART);
				}
				}
				setState(171); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUERY_PART );
			setState(173);
			match(GREATER_SYMBOL_QUERY);
			setState(174);
			match(BRACE_LEFT);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ITERATOR) | (1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0)) {
				{
				setState(177);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FIELD:
				case PUSHED_FIELD:
				case POPPED_FIELD:
					{
					setState(175);
					field();
					}
					break;
				case ITERATOR:
					{
					setState(176);
					nestedIterator();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(182);
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
			setState(184);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(185);
			variable();
			setState(186);
			match(LESS_SYMBOL_QUERY);
			setState(188); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(187);
				match(QUERY_PART);
				}
				}
				setState(190); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUERY_PART );
			setState(192);
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
			setState(194);
			match(AUTOINCREMENT);
			setState(195);
			variable();
			setState(196);
			match(LESS_SYMBOL_AUTOINCREMENT);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGOPERATOR_AUTOINCREMENT) {
				{
				setState(197);
				match(STRINGOPERATOR_AUTOINCREMENT);
				setState(198);
				match(ADD_AUTOINCREMENT);
				}
			}

			setState(201);
			match(DIGITS);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(202);
				match(TO);
				setState(203);
				match(DIGITS);
				}
			}

			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BY) {
				{
				setState(206);
				match(BY);
				setState(207);
				match(DIGITS);
				}
			}

			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD_AUTOINCREMENT) {
				{
				setState(210);
				match(ADD_AUTOINCREMENT);
				setState(211);
				match(STRINGOPERATOR_AUTOINCREMENT);
				}
			}

			setState(214);
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
			setState(216);
			match(EXPRESSION);
			setState(217);
			variable();
			setState(218);
			match(LESS_SYMBOL);
			setState(219);
			exp();
			setState(220);
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
			setState(222);
			match(MATCHER);
			setState(223);
			variable();
			setState(224);
			match(LESS_SYMBOL);
			setState(225);
			matchers(0);
			setState(226);
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
			setState(229);
			replacedStrings();
			setState(230);
			match(AS);
			setState(231);
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
			setState(241);
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
					setState(233);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(234);
					match(AND);
					setState(235);
					replacedStrings();
					setState(236);
					match(AS);
					setState(237);
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
				setState(243);
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
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				_la = _input.LA(1);
				if ( !(_la==STRING_OR_VAR || _la==STRINGOPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(245);
				match(COMMA);
				setState(246);
				replacedStrings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
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
		public SubstitutionContext substitution() {
			return getRuleContext(SubstitutionContext.class,0);
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
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				union();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				join();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(252);
				substitution();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(253);
				stringOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(254);
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
			setState(257);
			iteratorQuery();
			setState(258);
			match(ADD);
			setState(259);
			match(STRINGOPERATOR);
			setState(260);
			match(ADD);
			setState(261);
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
		public List<TerminalNode> DOT() { return getTokens(ShExMLParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ShExMLParser.DOT, i);
		}
		public ComposedVariableContext composedVariable() {
			return getRuleContext(ComposedVariableContext.class,0);
		}
		public BuiltinFunctionContext builtinFunction() {
			return getRuleContext(BuiltinFunctionContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			variable();
			setState(264);
			match(DOT);
			setState(265);
			composedVariable();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(266);
				match(DOT);
				setState(267);
				builtinFunction();
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
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				variable();
				setState(272);
				match(DOT);
				setState(273);
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

	public static class BuiltinFunctionContext extends ParserRuleContext {
		public TerminalNode INDEX() { return getToken(ShExMLParser.INDEX, 0); }
		public BuiltinFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterBuiltinFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitBuiltinFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitBuiltinFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinFunctionContext builtinFunction() throws RecognitionException {
		BuiltinFunctionContext _localctx = new BuiltinFunctionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_builtinFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(INDEX);
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
		enterRule(_localctx, 38, RULE_queryClause);
		int _la;
		try {
			setState(304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONPATH:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(JSONPATH);
				setState(281); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(280);
					match(QUERY_PART);
					}
					}
					setState(283); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case XMLPATH:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(XMLPATH);
				setState(287); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(286);
					match(QUERY_PART);
					}
					}
					setState(289); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case CSVPERROW:
				enterOuterAlt(_localctx, 3);
				{
				setState(291);
				match(CSVPERROW);
				}
				break;
			case SQL:
				enterOuterAlt(_localctx, 4);
				{
				setState(292);
				match(SQL);
				setState(294); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(293);
					match(QUERY_PART);
					}
					}
					setState(296); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case SPARQL:
				enterOuterAlt(_localctx, 5);
				{
				setState(298);
				match(SPARQL);
				setState(300); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(299);
					match(QUERY_PART);
					}
					}
					setState(302); 
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

	public static class SubstitutionContext extends ParserRuleContext {
		public List<IteratorQueryContext> iteratorQuery() {
			return getRuleContexts(IteratorQueryContext.class);
		}
		public IteratorQueryContext iteratorQuery(int i) {
			return getRuleContext(IteratorQueryContext.class,i);
		}
		public TerminalNode UNION() { return getToken(ShExMLParser.UNION, 0); }
		public TerminalNode SUBSTITUTING() { return getToken(ShExMLParser.SUBSTITUTING, 0); }
		public SubstitutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substitution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterSubstitution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitSubstitution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitSubstitution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubstitutionContext substitution() throws RecognitionException {
		SubstitutionContext _localctx = new SubstitutionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_substitution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			iteratorQuery();
			setState(307);
			match(UNION);
			setState(308);
			iteratorQuery();
			setState(309);
			match(SUBSTITUTING);
			setState(310);
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

	public static class JoinContext extends ParserRuleContext {
		public List<IteratorQueryContext> iteratorQuery() {
			return getRuleContexts(IteratorQueryContext.class);
		}
		public IteratorQueryContext iteratorQuery(int i) {
			return getRuleContext(IteratorQueryContext.class,i);
		}
		public TerminalNode JOIN() { return getToken(ShExMLParser.JOIN, 0); }
		public TerminalNode ON() { return getToken(ShExMLParser.ON, 0); }
		public TerminalNode EQUAL() { return getToken(ShExMLParser.EQUAL, 0); }
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
		enterRule(_localctx, 42, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			iteratorQuery();
			setState(313);
			match(JOIN);
			setState(314);
			iteratorQuery();
			setState(315);
			match(ON);
			setState(316);
			iteratorQuery();
			setState(317);
			match(EQUAL);
			setState(318);
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
		enterRule(_localctx, 44, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			leftUnionOption();
			setState(321);
			match(UNION);
			setState(322);
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
		enterRule(_localctx, 46, RULE_leftUnionOption);
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(324);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(325);
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
		enterRule(_localctx, 48, RULE_rightUnionOption);
		try {
			setState(331);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(330);
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
		enterRule(_localctx, 50, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			literalValue();
			setState(334);
			match(DOUBLE_BRACKET_LEFT);
			setState(336); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(335);
				shape();
				}
				}
				setState(338); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (LESS_SYMBOL - 23)) | (1L << (A - 23)) | (1L << (STRING_OR_VAR - 23)) | (1L << (URI_VAR - 23)) | (1L << (URL - 23)) | (1L << (STRING_OR_VAR_QUERY - 23)) | (1L << (URI_VAR_QUERY - 23)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 23)))) != 0) );
			setState(340);
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
		enterRule(_localctx, 52, RULE_shape);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			tripleElement();
			setState(343);
			actionOrLiteral();
			setState(344);
			match(BRACE_LEFT);
			setState(350);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(345);
					predicateObject();
					setState(346);
					match(SEMICOLON);
					}
					} 
				}
				setState(352);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (A - 39)) | (1L << (STRING_OR_VAR - 39)) | (1L << (URI_VAR - 39)) | (1L << (URL - 39)) | (1L << (STRING_OR_VAR_QUERY - 39)) | (1L << (URI_VAR_QUERY - 39)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 39)))) != 0)) {
				{
				setState(353);
				predicateObject();
				}
			}

			setState(356);
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
		enterRule(_localctx, 54, RULE_actionOrLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(358);
				action();
				}
				break;
			case 2:
				{
				setState(359);
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
		enterRule(_localctx, 56, RULE_literalSubject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			prefixVar();
			setState(363);
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
		public List<ExpOrVarOrFunctionCallignContext> expOrVarOrFunctionCallign() {
			return getRuleContexts(ExpOrVarOrFunctionCallignContext.class);
		}
		public ExpOrVarOrFunctionCallignContext expOrVarOrFunctionCallign(int i) {
			return getRuleContext(ExpOrVarOrFunctionCallignContext.class,i);
		}
		public TerminalNode BRACKET_RIGHT() { return getToken(ShExMLParser.BRACKET_RIGHT, 0); }
		public TerminalNode IF() { return getToken(ShExMLParser.IF, 0); }
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
		enterRule(_localctx, 58, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			prefixVar();
			setState(366);
			match(BRACKET_LEFT);
			setState(367);
			expOrVarOrFunctionCallign();
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(368);
				match(IF);
				setState(369);
				expOrVarOrFunctionCallign();
				}
			}

			setState(372);
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
		enterRule(_localctx, 60, RULE_predicateObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			predicate();
			setState(378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(375);
				objectElement();
				}
				break;
			case 2:
				{
				setState(376);
				shapeLink();
				}
				break;
			case 3:
				{
				setState(377);
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
		enterRule(_localctx, 62, RULE_objectElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			firstPartObjectElement();
			setState(383);
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
				setState(381);
				xmlschemadatatype();
				}
				break;
			case AT:
			case LANGTAG:
				{
				setState(382);
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
		enterRule(_localctx, 64, RULE_firstPartObjectElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (STRING_OR_VAR - 43)) | (1L << (URI_VAR - 43)) | (1L << (URL - 43)) | (1L << (STRING_OR_VAR_QUERY - 43)) | (1L << (URI_VAR_QUERY - 43)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 43)))) != 0)) {
				{
				setState(385);
				prefixVar();
				}
			}

			setState(388);
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
		public List<ExpOrVarOrFunctionCallignContext> expOrVarOrFunctionCallign() {
			return getRuleContexts(ExpOrVarOrFunctionCallignContext.class);
		}
		public ExpOrVarOrFunctionCallignContext expOrVarOrFunctionCallign(int i) {
			return getRuleContext(ExpOrVarOrFunctionCallignContext.class,i);
		}
		public TerminalNode BRACKET_RIGHT() { return getToken(ShExMLParser.BRACKET_RIGHT, 0); }
		public TerminalNode STRINGOPERATOR() { return getToken(ShExMLParser.STRINGOPERATOR, 0); }
		public TerminalNode MATCHING() { return getToken(ShExMLParser.MATCHING, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode IF() { return getToken(ShExMLParser.IF, 0); }
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
		enterRule(_localctx, 66, RULE_valueRetriever);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT:
				{
				setState(390);
				match(BRACKET_LEFT);
				setState(391);
				expOrVarOrFunctionCallign();
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MATCHING) {
					{
					setState(392);
					match(MATCHING);
					setState(393);
					variable();
					}
				}

				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(396);
					match(IF);
					setState(397);
					expOrVarOrFunctionCallign();
					}
				}

				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(400);
					match(AS);
					setState(401);
					rdfCollection();
					}
				}

				setState(404);
				match(BRACKET_RIGHT);
				}
				break;
			case STRINGOPERATOR:
				{
				setState(406);
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

	public static class ExpOrVarOrFunctionCallignContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FunctionCallingContext functionCalling() {
			return getRuleContext(FunctionCallingContext.class,0);
		}
		public ExpOrVarOrFunctionCallignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expOrVarOrFunctionCallign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterExpOrVarOrFunctionCallign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitExpOrVarOrFunctionCallign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitExpOrVarOrFunctionCallign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpOrVarOrFunctionCallignContext expOrVarOrFunctionCallign() throws RecognitionException {
		ExpOrVarOrFunctionCallignContext _localctx = new ExpOrVarOrFunctionCallignContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_expOrVarOrFunctionCallign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(409);
				exp();
				}
				break;
			case 2:
				{
				setState(410);
				variable();
				}
				break;
			case 3:
				{
				setState(411);
				functionCalling();
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
		enterRule(_localctx, 70, RULE_functionCalling);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			variable();
			setState(415);
			match(DOT);
			setState(416);
			variable();
			setState(417);
			match(PAREN_LEFT);
			setState(418);
			functionArguments();
			setState(419);
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
		enterRule(_localctx, 72, RULE_functionArguments);
		try {
			setState(432);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(423);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
				case 1:
					{
					setState(421);
					exp();
					}
					break;
				case 2:
					{
					setState(422);
					variable();
					}
					break;
				}
				setState(425);
				match(COMMA);
				setState(426);
				functionArguments();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(430);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(428);
					exp();
					}
					break;
				case 2:
					{
					setState(429);
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
		enterRule(_localctx, 74, RULE_rdfCollection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(434);
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
		enterRule(_localctx, 76, RULE_xmlschemadatatype);
		try {
			setState(438);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case XMLSCHEMADATATYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
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
				setState(437);
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
		enterRule(_localctx, 78, RULE_langtag);
		try {
			setState(443);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LANGTAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(440);
				match(LANGTAG);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(441);
				match(AT);
				setState(442);
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
		enterRule(_localctx, 80, RULE_shapeLink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
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
		enterRule(_localctx, 82, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				{
				setState(447);
				literalValue();
				}
				break;
			case A:
				{
				setState(448);
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
		enterRule(_localctx, 84, RULE_literalValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			prefixVar();
			setState(452);
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
		enterRule(_localctx, 86, RULE_tripleElement);
		try {
			setState(459);
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
				setState(454);
				predicate();
				}
				break;
			case LESS_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				match(LESS_SYMBOL);
				setState(456);
				variable();
				setState(457);
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
		enterRule(_localctx, 88, RULE_prefixVar);
		try {
			setState(463);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(461);
				variable();
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(462);
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
		enterRule(_localctx, 90, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_la = _input.LA(1);
			if ( !(((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (STRING_OR_VAR - 43)) | (1L << (URI_VAR - 43)) | (1L << (STRING_OR_VAR_QUERY - 43)) | (1L << (URI_VAR_QUERY - 43)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 43)))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3M\u01d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\7\2`\n\2\f\2\16\2c\13\2\3\2\3\2\7\2g\n\2\f"+
		"\2\16\2j\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3t\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\u0087\n\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\6\b\u0097\n\b\r\b"+
		"\16\b\u0098\5\b\u009b\n\b\3\b\3\b\3\b\3\b\7\b\u00a1\n\b\f\b\16\b\u00a4"+
		"\13\b\3\b\3\b\3\t\3\t\3\t\3\t\6\t\u00ac\n\t\r\t\16\t\u00ad\3\t\3\t\3\t"+
		"\3\t\7\t\u00b4\n\t\f\t\16\t\u00b7\13\t\3\t\3\t\3\n\3\n\3\n\3\n\6\n\u00bf"+
		"\n\n\r\n\16\n\u00c0\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u00ca\n\13\3"+
		"\13\3\13\3\13\5\13\u00cf\n\13\3\13\3\13\5\13\u00d3\n\13\3\13\3\13\5\13"+
		"\u00d7\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00f2\n\16"+
		"\f\16\16\16\u00f5\13\16\3\17\3\17\3\17\3\17\5\17\u00fb\n\17\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0102\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\5\22\u010f\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u0116\n"+
		"\23\3\24\3\24\3\25\3\25\6\25\u011c\n\25\r\25\16\25\u011d\3\25\3\25\6\25"+
		"\u0122\n\25\r\25\16\25\u0123\3\25\3\25\3\25\6\25\u0129\n\25\r\25\16\25"+
		"\u012a\3\25\3\25\6\25\u012f\n\25\r\25\16\25\u0130\5\25\u0133\n\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\5\31\u0149\n\31\3\32\3\32\3\32\5\32\u014e\n"+
		"\32\3\33\3\33\3\33\6\33\u0153\n\33\r\33\16\33\u0154\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\7\34\u015f\n\34\f\34\16\34\u0162\13\34\3\34\5\34"+
		"\u0165\n\34\3\34\3\34\3\35\3\35\5\35\u016b\n\35\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\5\37\u0175\n\37\3\37\3\37\3 \3 \3 \3 \5 \u017d\n \3"+
		"!\3!\3!\5!\u0182\n!\3\"\5\"\u0185\n\"\3\"\3\"\3#\3#\3#\3#\5#\u018d\n#"+
		"\3#\3#\5#\u0191\n#\3#\3#\5#\u0195\n#\3#\3#\3#\5#\u019a\n#\3$\3$\3$\5$"+
		"\u019f\n$\3%\3%\3%\3%\3%\3%\3%\3&\3&\5&\u01aa\n&\3&\3&\3&\3&\3&\5&\u01b1"+
		"\n&\5&\u01b3\n&\3\'\3\'\3(\3(\5(\u01b9\n(\3)\3)\3)\5)\u01be\n)\3*\3*\3"+
		"+\3+\5+\u01c4\n+\3,\3,\3,\3-\3-\3-\3-\3-\5-\u01ce\n-\3.\3.\5.\u01d2\n"+
		".\3/\3/\3/\2\3\32\60\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\\2\b\4\2\65\66=>\4\2\65\65>>\3\2\b\n\4\2"+
		"--//\3\2\25\30\5\2-.BCJJ\2\u01e9\2a\3\2\2\2\4s\3\2\2\2\6u\3\2\2\2\b{\3"+
		"\2\2\2\n\u0081\3\2\2\2\f\u008a\3\2\2\2\16\u0091\3\2\2\2\20\u00a7\3\2\2"+
		"\2\22\u00ba\3\2\2\2\24\u00c4\3\2\2\2\26\u00da\3\2\2\2\30\u00e0\3\2\2\2"+
		"\32\u00e6\3\2\2\2\34\u00fa\3\2\2\2\36\u0101\3\2\2\2 \u0103\3\2\2\2\"\u0109"+
		"\3\2\2\2$\u0115\3\2\2\2&\u0117\3\2\2\2(\u0132\3\2\2\2*\u0134\3\2\2\2,"+
		"\u013a\3\2\2\2.\u0142\3\2\2\2\60\u0148\3\2\2\2\62\u014d\3\2\2\2\64\u014f"+
		"\3\2\2\2\66\u0158\3\2\2\28\u016a\3\2\2\2:\u016c\3\2\2\2<\u016f\3\2\2\2"+
		">\u0178\3\2\2\2@\u017e\3\2\2\2B\u0184\3\2\2\2D\u0199\3\2\2\2F\u019e\3"+
		"\2\2\2H\u01a0\3\2\2\2J\u01b2\3\2\2\2L\u01b4\3\2\2\2N\u01b8\3\2\2\2P\u01bd"+
		"\3\2\2\2R\u01bf\3\2\2\2T\u01c3\3\2\2\2V\u01c5\3\2\2\2X\u01cd\3\2\2\2Z"+
		"\u01d1\3\2\2\2\\\u01d3\3\2\2\2^`\5\4\3\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2"+
		"ab\3\2\2\2bh\3\2\2\2ca\3\2\2\2dg\5\66\34\2eg\5\64\33\2fd\3\2\2\2fe\3\2"+
		"\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\3\3\2\2\2jh\3\2\2\2kt\5\b\5\2lt\5"+
		"\6\4\2mt\5\n\6\2nt\5\26\f\2ot\5\30\r\2pt\5\16\b\2qt\5\24\13\2rt\5\f\7"+
		"\2sk\3\2\2\2sl\3\2\2\2sm\3\2\2\2sn\3\2\2\2so\3\2\2\2sp\3\2\2\2sq\3\2\2"+
		"\2sr\3\2\2\2t\5\3\2\2\2uv\7\3\2\2vw\5\\/\2wx\7A\2\2xy\7\65\2\2yz\7?\2"+
		"\2z\7\3\2\2\2{|\7\4\2\2|}\5\\/\2}~\7A\2\2~\177\t\2\2\2\177\u0080\7?\2"+
		"\2\u0080\t\3\2\2\2\u0081\u0082\7\5\2\2\u0082\u0083\5\\/\2\u0083\u0086"+
		"\7A\2\2\u0084\u0087\7\65\2\2\u0085\u0087\5(\25\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\7?\2\2\u0089\13\3\2\2\2"+
		"\u008a\u008b\7\7\2\2\u008b\u008c\5\\/\2\u008c\u008d\7A\2\2\u008d\u008e"+
		"\7;\2\2\u008e\u008f\t\3\2\2\u008f\u0090\7?\2\2\u0090\r\3\2\2\2\u0091\u0092"+
		"\7\6\2\2\u0092\u0093\5\\/\2\u0093\u009a\7A\2\2\u0094\u009b\5(\25\2\u0095"+
		"\u0097\7>\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0094\3\2\2\2\u009a"+
		"\u0096\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7?\2\2\u009d\u00a2\7!\2"+
		"\2\u009e\u00a1\5\22\n\2\u009f\u00a1\5\20\t\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2"+
		"\2\2\u00a3\u00a5\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\7\"\2\2\u00a6"+
		"\17\3\2\2\2\u00a7\u00a8\7\6\2\2\u00a8\u00a9\5\\/\2\u00a9\u00ab\7A\2\2"+
		"\u00aa\u00ac\7>\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\7?\2\2\u00b0"+
		"\u00b5\7!\2\2\u00b1\u00b4\5\22\n\2\u00b2\u00b4\5\20\t\2\u00b3\u00b1\3"+
		"\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7\""+
		"\2\2\u00b9\21\3\2\2\2\u00ba\u00bb\t\4\2\2\u00bb\u00bc\5\\/\2\u00bc\u00be"+
		"\7A\2\2\u00bd\u00bf\7>\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\7?"+
		"\2\2\u00c3\23\3\2\2\2\u00c4\u00c5\7\13\2\2\u00c5\u00c6\5\\/\2\u00c6\u00c9"+
		"\7E\2\2\u00c7\u00c8\7K\2\2\u00c8\u00ca\7H\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00ce\7I\2\2\u00cc\u00cd\7F\2"+
		"\2\u00cd\u00cf\7I\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2"+
		"\3\2\2\2\u00d0\u00d1\7G\2\2\u00d1\u00d3\7I\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d5\7H\2\2\u00d5\u00d7\7K\2"+
		"\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9"+
		"\7L\2\2\u00d9\25\3\2\2\2\u00da\u00db\7\f\2\2\u00db\u00dc\5\\/\2\u00dc"+
		"\u00dd\7\31\2\2\u00dd\u00de\5\36\20\2\u00de\u00df\7\32\2\2\u00df\27\3"+
		"\2\2\2\u00e0\u00e1\7\20\2\2\u00e1\u00e2\5\\/\2\u00e2\u00e3\7\31\2\2\u00e3"+
		"\u00e4\5\32\16\2\u00e4\u00e5\7\32\2\2\u00e5\31\3\2\2\2\u00e6\u00e7\b\16"+
		"\1\2\u00e7\u00e8\5\34\17\2\u00e8\u00e9\7\21\2\2\u00e9\u00ea\t\5\2\2\u00ea"+
		"\u00f3\3\2\2\2\u00eb\u00ec\f\3\2\2\u00ec\u00ed\7(\2\2\u00ed\u00ee\5\34"+
		"\17\2\u00ee\u00ef\7\21\2\2\u00ef\u00f0\t\5\2\2\u00f0\u00f2\3\2\2\2\u00f1"+
		"\u00eb\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2"+
		"\2\2\u00f4\33\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f7\t\5\2\2\u00f7\u00f8"+
		"\7&\2\2\u00f8\u00fb\5\34\17\2\u00f9\u00fb\t\5\2\2\u00fa\u00f6\3\2\2\2"+
		"\u00fa\u00f9\3\2\2\2\u00fb\35\3\2\2\2\u00fc\u0102\5.\30\2\u00fd\u0102"+
		"\5,\27\2\u00fe\u0102\5*\26\2\u00ff\u0102\5 \21\2\u0100\u0102\5\"\22\2"+
		"\u0101\u00fc\3\2\2\2\u0101\u00fd\3\2\2\2\u0101\u00fe\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0101\u0100\3\2\2\2\u0102\37\3\2\2\2\u0103\u0104\5\"\22\2\u0104"+
		"\u0105\7%\2\2\u0105\u0106\7/\2\2\u0106\u0107\7%\2\2\u0107\u0108\5\"\22"+
		"\2\u0108!\3\2\2\2\u0109\u010a\5\\/\2\u010a\u010b\7$\2\2\u010b\u010e\5"+
		"$\23\2\u010c\u010d\7$\2\2\u010d\u010f\5&\24\2\u010e\u010c\3\2\2\2\u010e"+
		"\u010f\3\2\2\2\u010f#\3\2\2\2\u0110\u0116\5\\/\2\u0111\u0112\5\\/\2\u0112"+
		"\u0113\7$\2\2\u0113\u0114\5$\23\2\u0114\u0116\3\2\2\2\u0115\u0110\3\2"+
		"\2\2\u0115\u0111\3\2\2\2\u0116%\3\2\2\2\u0117\u0118\7,\2\2\u0118\'\3\2"+
		"\2\2\u0119\u011b\7\67\2\2\u011a\u011c\7>\2\2\u011b\u011a\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0133\3\2"+
		"\2\2\u011f\u0121\78\2\2\u0120\u0122\7>\2\2\u0121\u0120\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0133\3\2\2\2\u0125"+
		"\u0133\79\2\2\u0126\u0128\7:\2\2\u0127\u0129\7>\2\2\u0128\u0127\3\2\2"+
		"\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0133"+
		"\3\2\2\2\u012c\u012e\7<\2\2\u012d\u012f\7>\2\2\u012e\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0133\3\2"+
		"\2\2\u0132\u0119\3\2\2\2\u0132\u011f\3\2\2\2\u0132\u0125\3\2\2\2\u0132"+
		"\u0126\3\2\2\2\u0132\u012c\3\2\2\2\u0133)\3\2\2\2\u0134\u0135\5\"\22\2"+
		"\u0135\u0136\7\r\2\2\u0136\u0137\5\"\22\2\u0137\u0138\7\17\2\2\u0138\u0139"+
		"\5\"\22\2\u0139+\3\2\2\2\u013a\u013b\5\"\22\2\u013b\u013c\7\16\2\2\u013c"+
		"\u013d\5\"\22\2\u013d\u013e\7\23\2\2\u013e\u013f\5\"\22\2\u013f\u0140"+
		"\7+\2\2\u0140\u0141\5\"\22\2\u0141-\3\2\2\2\u0142\u0143\5\60\31\2\u0143"+
		"\u0144\7\r\2\2\u0144\u0145\5\62\32\2\u0145/\3\2\2\2\u0146\u0149\5\"\22"+
		"\2\u0147\u0149\5 \21\2\u0148\u0146\3\2\2\2\u0148\u0147\3\2\2\2\u0149\61"+
		"\3\2\2\2\u014a\u014e\5\"\22\2\u014b\u014e\5.\30\2\u014c\u014e\5 \21\2"+
		"\u014d\u014a\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014c\3\2\2\2\u014e\63"+
		"\3\2\2\2\u014f\u0150\5V,\2\u0150\u0152\7\34\2\2\u0151\u0153\5\66\34\2"+
		"\u0152\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155"+
		"\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\7\36\2\2\u0157\65\3\2\2\2\u0158"+
		"\u0159\5X-\2\u0159\u015a\58\35\2\u015a\u0160\7!\2\2\u015b\u015c\5> \2"+
		"\u015c\u015d\7#\2\2\u015d\u015f\3\2\2\2\u015e\u015b\3\2\2\2\u015f\u0162"+
		"\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0164\3\2\2\2\u0162"+
		"\u0160\3\2\2\2\u0163\u0165\5> \2\u0164\u0163\3\2\2\2\u0164\u0165\3\2\2"+
		"\2\u0165\u0166\3\2\2\2\u0166\u0167\7\"\2\2\u0167\67\3\2\2\2\u0168\u016b"+
		"\5<\37\2\u0169\u016b\5:\36\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b"+
		"9\3\2\2\2\u016c\u016d\5Z.\2\u016d\u016e\5\\/\2\u016e;\3\2\2\2\u016f\u0170"+
		"\5Z.\2\u0170\u0171\7\33\2\2\u0171\u0174\5F$\2\u0172\u0173\7\22\2\2\u0173"+
		"\u0175\5F$\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176\3\2\2"+
		"\2\u0176\u0177\7\35\2\2\u0177=\3\2\2\2\u0178\u017c\5T+\2\u0179\u017d\5"+
		"@!\2\u017a\u017d\5R*\2\u017b\u017d\5V,\2\u017c\u0179\3\2\2\2\u017c\u017a"+
		"\3\2\2\2\u017c\u017b\3\2\2\2\u017d?\3\2\2\2\u017e\u0181\5B\"\2\u017f\u0182"+
		"\5N(\2\u0180\u0182\5P)\2\u0181\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182A\3\2\2\2\u0183\u0185\5Z.\2\u0184\u0183\3\2\2\2\u0184"+
		"\u0185\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\5D#\2\u0187C\3\2\2\2\u0188"+
		"\u0189\7\33\2\2\u0189\u018c\5F$\2\u018a\u018b\7\24\2\2\u018b\u018d\5\\"+
		"/\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u0190\3\2\2\2\u018e"+
		"\u018f\7\22\2\2\u018f\u0191\5F$\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2"+
		"\2\2\u0191\u0194\3\2\2\2\u0192\u0193\7\21\2\2\u0193\u0195\5L\'\2\u0194"+
		"\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\7\35"+
		"\2\2\u0197\u019a\3\2\2\2\u0198\u019a\7/\2\2\u0199\u0188\3\2\2\2\u0199"+
		"\u0198\3\2\2\2\u019aE\3\2\2\2\u019b\u019f\5\36\20\2\u019c\u019f\5\\/\2"+
		"\u019d\u019f\5H%\2\u019e\u019b\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019d"+
		"\3\2\2\2\u019fG\3\2\2\2\u01a0\u01a1\5\\/\2\u01a1\u01a2\7$\2\2\u01a2\u01a3"+
		"\5\\/\2\u01a3\u01a4\7\37\2\2\u01a4\u01a5\5J&\2\u01a5\u01a6\7 \2\2\u01a6"+
		"I\3\2\2\2\u01a7\u01aa\5\36\20\2\u01a8\u01aa\5\\/\2\u01a9\u01a7\3\2\2\2"+
		"\u01a9\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\7&\2\2\u01ac\u01ad"+
		"\5J&\2\u01ad\u01b3\3\2\2\2\u01ae\u01b1\5\36\20\2\u01af\u01b1\5\\/\2\u01b0"+
		"\u01ae\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01a9\3\2"+
		"\2\2\u01b2\u01b0\3\2\2\2\u01b3K\3\2\2\2\u01b4\u01b5\t\6\2\2\u01b5M\3\2"+
		"\2\2\u01b6\u01b9\7\60\2\2\u01b7\u01b9\5B\"\2\u01b8\u01b6\3\2\2\2\u01b8"+
		"\u01b7\3\2\2\2\u01b9O\3\2\2\2\u01ba\u01be\7\62\2\2\u01bb\u01bc\7*\2\2"+
		"\u01bc\u01be\5D#\2\u01bd\u01ba\3\2\2\2\u01bd\u01bb\3\2\2\2\u01beQ\3\2"+
		"\2\2\u01bf\u01c0\7\61\2\2\u01c0S\3\2\2\2\u01c1\u01c4\5V,\2\u01c2\u01c4"+
		"\7)\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4U\3\2\2\2\u01c5\u01c6"+
		"\5Z.\2\u01c6\u01c7\5\\/\2\u01c7W\3\2\2\2\u01c8\u01ce\5T+\2\u01c9\u01ca"+
		"\7\31\2\2\u01ca\u01cb\5\\/\2\u01cb\u01cc\7\32\2\2\u01cc\u01ce\3\2\2\2"+
		"\u01cd\u01c8\3\2\2\2\u01cd\u01c9\3\2\2\2\u01ceY\3\2\2\2\u01cf\u01d2\5"+
		"\\/\2\u01d0\u01d2\7\65\2\2\u01d1\u01cf\3\2\2\2\u01d1\u01d0\3\2\2\2\u01d2"+
		"[\3\2\2\2\u01d3\u01d4\t\7\2\2\u01d4]\3\2\2\2\64afhs\u0086\u0098\u009a"+
		"\u00a0\u00a2\u00ad\u00b3\u00b5\u00c0\u00c9\u00ce\u00d2\u00d6\u00f3\u00fa"+
		"\u0101\u010e\u0115\u011d\u0123\u012a\u0130\u0132\u0148\u014d\u0154\u0160"+
		"\u0164\u016a\u0174\u017c\u0181\u0184\u018c\u0190\u0194\u0199\u019e\u01a9"+
		"\u01b0\u01b2\u01b8\u01bd\u01c3\u01cd\u01d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}