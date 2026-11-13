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
		SCALA=57, JAVA=58, SPARQL=59, STDIN=60, QUERY_PART=61, GREATER_SYMBOL_QUERY=62, 
		WS_QUERY=63, LESS_SYMBOL_QUERY=64, STRING_OR_VAR_QUERY=65, URI_VAR_QUERY=66, 
		WS_DECLARATION=67, LESS_SYMBOL_AUTOINCREMENT=68, TO=69, BY=70, ADD_AUTOINCREMENT=71, 
		DIGITS=72, STRING_OR_VAR_AUTOINCREMENT=73, STRINGOPERATOR_AUTOINCREMENT=74, 
		GREATER_SYMBOL_AUTOINCREMENT=75, WS_AUTOINCREMENT=76;
	public static final int
		RULE_shExML = 0, RULE_decl = 1, RULE_prefix = 2, RULE_source = 3, RULE_query = 4, 
		RULE_functions = 5, RULE_iterator = 6, RULE_nestedIterator = 7, RULE_field = 8, 
		RULE_autoincrement = 9, RULE_expression = 10, RULE_matcher = 11, RULE_matchers = 12, 
		RULE_replacedStrings = 13, RULE_exp = 14, RULE_stringOperation = 15, RULE_composedStringOperation = 16, 
		RULE_iteratorQuery = 17, RULE_composedVariable = 18, RULE_builtinFunction = 19, 
		RULE_queryClause = 20, RULE_substitution = 21, RULE_join = 22, RULE_union = 23, 
		RULE_leftUnionOption = 24, RULE_rightUnionOption = 25, RULE_graph = 26, 
		RULE_shape = 27, RULE_actionOrLiteral = 28, RULE_literalSubject = 29, 
		RULE_action = 30, RULE_predicateObject = 31, RULE_objectElement = 32, 
		RULE_firstPartObjectElement = 33, RULE_valueRetriever = 34, RULE_expOrVarOrFunctionCallign = 35, 
		RULE_functionCalling = 36, RULE_functionArguments = 37, RULE_rdfCollection = 38, 
		RULE_datatype = 39, RULE_langtag = 40, RULE_shapeLink = 41, RULE_predicate = 42, 
		RULE_literalValue = 43, RULE_tripleElement = 44, RULE_prefixVar = 45, 
		RULE_variable = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"shExML", "decl", "prefix", "source", "query", "functions", "iterator", 
			"nestedIterator", "field", "autoincrement", "expression", "matcher", 
			"matchers", "replacedStrings", "exp", "stringOperation", "composedStringOperation", 
			"iteratorQuery", "composedVariable", "builtinFunction", "queryClause", 
			"substitution", "join", "union", "leftUnionOption", "rightUnionOption", 
			"graph", "shape", "actionOrLiteral", "literalSubject", "action", "predicateObject", 
			"objectElement", "firstPartObjectElement", "valueRetriever", "expOrVarOrFunctionCallign", 
			"functionCalling", "functionArguments", "rdfCollection", "datatype", 
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
			"SQL", "SCALA", "JAVA", "SPARQL", "STDIN", "QUERY_PART", "GREATER_SYMBOL_QUERY", 
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
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFIX) | (1L << SOURCE) | (1L << QUERY) | (1L << ITERATOR) | (1L << FUNCTIONS) | (1L << AUTOINCREMENT) | (1L << EXPRESSION) | (1L << MATCHER))) != 0)) {
				{
				{
				setState(94);
				decl();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (LESS_SYMBOL - 23)) | (1L << (A - 23)) | (1L << (STRING_OR_VAR - 23)) | (1L << (URI_VAR - 23)) | (1L << (URL - 23)) | (1L << (STRING_OR_VAR_QUERY - 23)) | (1L << (URI_VAR_QUERY - 23)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 23)))) != 0)) {
				{
				setState(102);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(100);
					shape();
					}
					break;
				case 2:
					{
					setState(101);
					graph();
					}
					break;
				}
				}
				setState(106);
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
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SOURCE:
				{
				setState(107);
				source();
				}
				break;
			case PREFIX:
				{
				setState(108);
				prefix();
				}
				break;
			case QUERY:
				{
				setState(109);
				query();
				}
				break;
			case EXPRESSION:
				{
				setState(110);
				expression();
				}
				break;
			case MATCHER:
				{
				setState(111);
				matcher();
				}
				break;
			case ITERATOR:
				{
				setState(112);
				iterator();
				}
				break;
			case AUTOINCREMENT:
				{
				setState(113);
				autoincrement();
				}
				break;
			case FUNCTIONS:
				{
				setState(114);
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
			setState(117);
			match(PREFIX);
			setState(118);
			variable();
			setState(119);
			match(LESS_SYMBOL_QUERY);
			setState(120);
			match(URL);
			setState(121);
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
			setState(123);
			match(SOURCE);
			setState(124);
			variable();
			setState(125);
			match(LESS_SYMBOL_QUERY);
			setState(126);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << URL) | (1L << JDBC_URL) | (1L << STDIN) | (1L << QUERY_PART))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(127);
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
			setState(129);
			match(QUERY);
			setState(130);
			variable();
			setState(131);
			match(LESS_SYMBOL_QUERY);
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case URL:
				{
				setState(132);
				match(URL);
				}
				break;
			case JSONPATH:
			case XMLPATH:
			case CSVPERROW:
			case SQL:
			case SPARQL:
				{
				setState(133);
				queryClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(136);
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
		public TerminalNode GREATER_SYMBOL_QUERY() { return getToken(ShExMLParser.GREATER_SYMBOL_QUERY, 0); }
		public TerminalNode SCALA() { return getToken(ShExMLParser.SCALA, 0); }
		public TerminalNode JAVA() { return getToken(ShExMLParser.JAVA, 0); }
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
			setState(138);
			match(FUNCTIONS);
			setState(139);
			variable();
			setState(140);
			match(LESS_SYMBOL_QUERY);
			setState(141);
			_la = _input.LA(1);
			if ( !(_la==SCALA || _la==JAVA) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(142);
			_la = _input.LA(1);
			if ( !(_la==URL || _la==QUERY_PART) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
			setState(145);
			match(ITERATOR);
			setState(146);
			variable();
			setState(147);
			match(LESS_SYMBOL_QUERY);
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONPATH:
			case XMLPATH:
			case CSVPERROW:
			case SQL:
			case SPARQL:
				{
				setState(148);
				queryClause();
				}
				break;
			case QUERY_PART:
				{
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(149);
					match(QUERY_PART);
					}
					}
					setState(152); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(156);
			match(GREATER_SYMBOL_QUERY);
			setState(157);
			match(BRACE_LEFT);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ITERATOR) | (1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0)) {
				{
				setState(160);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FIELD:
				case PUSHED_FIELD:
				case POPPED_FIELD:
					{
					setState(158);
					field();
					}
					break;
				case ITERATOR:
					{
					setState(159);
					nestedIterator();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
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
			setState(167);
			match(ITERATOR);
			setState(168);
			variable();
			setState(169);
			match(LESS_SYMBOL_QUERY);
			setState(171); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(170);
				match(QUERY_PART);
				}
				}
				setState(173); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUERY_PART );
			setState(175);
			match(GREATER_SYMBOL_QUERY);
			setState(176);
			match(BRACE_LEFT);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ITERATOR) | (1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0)) {
				{
				setState(179);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FIELD:
				case PUSHED_FIELD:
				case POPPED_FIELD:
					{
					setState(177);
					field();
					}
					break;
				case ITERATOR:
					{
					setState(178);
					nestedIterator();
					}
					break;
				default:
					throw new NoViableAltException(this);
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
			setState(257);
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
				substitution();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(255);
				stringOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(256);
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
		public ComposedStringOperationContext composedStringOperation() {
			return getRuleContext(ComposedStringOperationContext.class,0);
		}
		public IteratorQueryContext iteratorQuery() {
			return getRuleContext(IteratorQueryContext.class,0);
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
			setState(261);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				{
				setState(259);
				iteratorQuery();
				}
				break;
			case STRINGOPERATOR:
				{
				setState(260);
				match(STRINGOPERATOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(263);
			composedStringOperation();
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

	public static class ComposedStringOperationContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(ShExMLParser.ADD, 0); }
		public IteratorQueryContext iteratorQuery() {
			return getRuleContext(IteratorQueryContext.class,0);
		}
		public TerminalNode STRINGOPERATOR() { return getToken(ShExMLParser.STRINGOPERATOR, 0); }
		public StringOperationContext stringOperation() {
			return getRuleContext(StringOperationContext.class,0);
		}
		public ComposedStringOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_composedStringOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterComposedStringOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitComposedStringOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitComposedStringOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComposedStringOperationContext composedStringOperation() throws RecognitionException {
		ComposedStringOperationContext _localctx = new ComposedStringOperationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_composedStringOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(ADD);
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(266);
				iteratorQuery();
				}
				break;
			case 2:
				{
				setState(267);
				match(STRINGOPERATOR);
				}
				break;
			case 3:
				{
				setState(268);
				stringOperation();
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
		enterRule(_localctx, 34, RULE_iteratorQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			variable();
			setState(272);
			match(DOT);
			setState(273);
			composedVariable();
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(274);
				match(DOT);
				setState(275);
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
		enterRule(_localctx, 36, RULE_composedVariable);
		try {
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				variable();
				setState(280);
				match(DOT);
				setState(281);
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
		enterRule(_localctx, 38, RULE_builtinFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
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
		enterRule(_localctx, 40, RULE_queryClause);
		int _la;
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONPATH:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				match(JSONPATH);
				setState(289); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(288);
					match(QUERY_PART);
					}
					}
					setState(291); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case XMLPATH:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				match(XMLPATH);
				setState(295); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(294);
					match(QUERY_PART);
					}
					}
					setState(297); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case CSVPERROW:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				match(CSVPERROW);
				}
				break;
			case SQL:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				match(SQL);
				setState(302); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(301);
					match(QUERY_PART);
					}
					}
					setState(304); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case SPARQL:
				enterOuterAlt(_localctx, 5);
				{
				setState(306);
				match(SPARQL);
				setState(308); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(307);
					match(QUERY_PART);
					}
					}
					setState(310); 
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
		enterRule(_localctx, 42, RULE_substitution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			iteratorQuery();
			setState(315);
			match(UNION);
			setState(316);
			iteratorQuery();
			setState(317);
			match(SUBSTITUTING);
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
		enterRule(_localctx, 44, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			iteratorQuery();
			setState(321);
			match(JOIN);
			setState(322);
			iteratorQuery();
			setState(323);
			match(ON);
			setState(324);
			iteratorQuery();
			setState(325);
			match(EQUAL);
			setState(326);
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
		enterRule(_localctx, 46, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			leftUnionOption();
			setState(329);
			match(UNION);
			setState(330);
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
		enterRule(_localctx, 48, RULE_leftUnionOption);
		try {
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
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
		enterRule(_localctx, 50, RULE_rightUnionOption);
		try {
			setState(339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
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
		enterRule(_localctx, 52, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			literalValue();
			setState(342);
			match(DOUBLE_BRACKET_LEFT);
			setState(344); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(343);
				shape();
				}
				}
				setState(346); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (LESS_SYMBOL - 23)) | (1L << (A - 23)) | (1L << (STRING_OR_VAR - 23)) | (1L << (URI_VAR - 23)) | (1L << (URL - 23)) | (1L << (STRING_OR_VAR_QUERY - 23)) | (1L << (URI_VAR_QUERY - 23)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 23)))) != 0) );
			setState(348);
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
		enterRule(_localctx, 54, RULE_shape);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			tripleElement();
			setState(351);
			actionOrLiteral();
			setState(352);
			match(BRACE_LEFT);
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(353);
					predicateObject();
					setState(354);
					match(SEMICOLON);
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 39)) & ~0x3f) == 0 && ((1L << (_la - 39)) & ((1L << (A - 39)) | (1L << (STRING_OR_VAR - 39)) | (1L << (URI_VAR - 39)) | (1L << (URL - 39)) | (1L << (STRING_OR_VAR_QUERY - 39)) | (1L << (URI_VAR_QUERY - 39)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 39)))) != 0)) {
				{
				setState(361);
				predicateObject();
				}
			}

			setState(364);
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
		enterRule(_localctx, 56, RULE_actionOrLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(366);
				action();
				}
				break;
			case 2:
				{
				setState(367);
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
		enterRule(_localctx, 58, RULE_literalSubject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			prefixVar();
			setState(371);
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
		enterRule(_localctx, 60, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			prefixVar();
			setState(374);
			match(BRACKET_LEFT);
			setState(375);
			expOrVarOrFunctionCallign();
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(376);
				match(IF);
				setState(377);
				expOrVarOrFunctionCallign();
				}
			}

			setState(380);
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
		enterRule(_localctx, 62, RULE_predicateObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			predicate();
			setState(386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(383);
				objectElement();
				}
				break;
			case 2:
				{
				setState(384);
				shapeLink();
				}
				break;
			case 3:
				{
				setState(385);
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
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
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
		enterRule(_localctx, 64, RULE_objectElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			firstPartObjectElement();
			setState(391);
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
				setState(389);
				datatype();
				}
				break;
			case AT:
			case LANGTAG:
				{
				setState(390);
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
		enterRule(_localctx, 66, RULE_firstPartObjectElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & ((1L << (STRING_OR_VAR - 43)) | (1L << (URI_VAR - 43)) | (1L << (URL - 43)) | (1L << (STRING_OR_VAR_QUERY - 43)) | (1L << (URI_VAR_QUERY - 43)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 43)))) != 0)) {
				{
				setState(393);
				prefixVar();
				}
			}

			setState(396);
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
		enterRule(_localctx, 68, RULE_valueRetriever);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT:
				{
				setState(398);
				match(BRACKET_LEFT);
				setState(399);
				expOrVarOrFunctionCallign();
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MATCHING) {
					{
					setState(400);
					match(MATCHING);
					setState(401);
					variable();
					}
				}

				setState(406);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(404);
					match(IF);
					setState(405);
					expOrVarOrFunctionCallign();
					}
				}

				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(408);
					match(AS);
					setState(409);
					rdfCollection();
					}
				}

				setState(412);
				match(BRACKET_RIGHT);
				}
				break;
			case STRINGOPERATOR:
				{
				setState(414);
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
		enterRule(_localctx, 70, RULE_expOrVarOrFunctionCallign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				{
				setState(417);
				exp();
				}
				break;
			case 2:
				{
				setState(418);
				variable();
				}
				break;
			case 3:
				{
				setState(419);
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
		enterRule(_localctx, 72, RULE_functionCalling);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			variable();
			setState(423);
			match(DOT);
			setState(424);
			variable();
			setState(425);
			match(PAREN_LEFT);
			setState(426);
			functionArguments();
			setState(427);
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
		enterRule(_localctx, 74, RULE_functionArguments);
		try {
			setState(440);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(429);
					exp();
					}
					break;
				case 2:
					{
					setState(430);
					variable();
					}
					break;
				}
				setState(433);
				match(COMMA);
				setState(434);
				functionArguments();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(438);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(436);
					exp();
					}
					break;
				case 2:
					{
					setState(437);
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
		enterRule(_localctx, 76, RULE_rdfCollection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
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

	public static class DatatypeContext extends ParserRuleContext {
		public TerminalNode XMLSCHEMADATATYPE() { return getToken(ShExMLParser.XMLSCHEMADATATYPE, 0); }
		public FirstPartObjectElementContext firstPartObjectElement() {
			return getRuleContext(FirstPartObjectElementContext.class,0);
		}
		public LiteralSubjectContext literalSubject() {
			return getRuleContext(LiteralSubjectContext.class,0);
		}
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).enterDatatype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShExMLParserListener ) ((ShExMLParserListener)listener).exitDatatype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ShExMLParserVisitor ) return ((ShExMLParserVisitor<? extends T>)visitor).visitDatatype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_datatype);
		try {
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				match(XMLSCHEMADATATYPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
				firstPartObjectElement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(446);
				literalSubject();
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
		enterRule(_localctx, 80, RULE_langtag);
		try {
			setState(452);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LANGTAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				match(LANGTAG);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
				match(AT);
				setState(451);
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
		enterRule(_localctx, 82, RULE_shapeLink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
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
		enterRule(_localctx, 84, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				{
				setState(456);
				literalValue();
				}
				break;
			case A:
				{
				setState(457);
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
		enterRule(_localctx, 86, RULE_literalValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			prefixVar();
			setState(461);
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
		enterRule(_localctx, 88, RULE_tripleElement);
		try {
			setState(468);
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
				setState(463);
				predicate();
				}
				break;
			case LESS_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(464);
				match(LESS_SYMBOL);
				setState(465);
				variable();
				setState(466);
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
		enterRule(_localctx, 90, RULE_prefixVar);
		try {
			setState(472);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				variable();
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(471);
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
		enterRule(_localctx, 92, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3N\u01df\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\7\2b\n\2\f\2\16\2e\13\2\3\2\3\2\7"+
		"\2i\n\2\f\2\16\2l\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3v\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6\u0089"+
		"\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\6\b\u0099"+
		"\n\b\r\b\16\b\u009a\5\b\u009d\n\b\3\b\3\b\3\b\3\b\7\b\u00a3\n\b\f\b\16"+
		"\b\u00a6\13\b\3\b\3\b\3\t\3\t\3\t\3\t\6\t\u00ae\n\t\r\t\16\t\u00af\3\t"+
		"\3\t\3\t\3\t\7\t\u00b6\n\t\f\t\16\t\u00b9\13\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\6\n\u00c1\n\n\r\n\16\n\u00c2\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u00cc"+
		"\n\13\3\13\3\13\3\13\5\13\u00d1\n\13\3\13\3\13\5\13\u00d5\n\13\3\13\3"+
		"\13\5\13\u00d9\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00f4"+
		"\n\16\f\16\16\16\u00f7\13\16\3\17\3\17\3\17\3\17\5\17\u00fd\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\5\20\u0104\n\20\3\21\3\21\5\21\u0108\n\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\5\22\u0110\n\22\3\23\3\23\3\23\3\23\3\23\5\23"+
		"\u0117\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u011e\n\24\3\25\3\25\3\26\3"+
		"\26\6\26\u0124\n\26\r\26\16\26\u0125\3\26\3\26\6\26\u012a\n\26\r\26\16"+
		"\26\u012b\3\26\3\26\3\26\6\26\u0131\n\26\r\26\16\26\u0132\3\26\3\26\6"+
		"\26\u0137\n\26\r\26\16\26\u0138\5\26\u013b\n\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\32\3\32\5\32\u0151\n\32\3\33\3\33\3\33\5\33\u0156\n\33\3\34\3\34\3\34"+
		"\6\34\u015b\n\34\r\34\16\34\u015c\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\7\35\u0167\n\35\f\35\16\35\u016a\13\35\3\35\5\35\u016d\n\35\3\35\3"+
		"\35\3\36\3\36\5\36\u0173\n\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \5 \u017d\n"+
		" \3 \3 \3!\3!\3!\3!\5!\u0185\n!\3\"\3\"\3\"\5\"\u018a\n\"\3#\5#\u018d"+
		"\n#\3#\3#\3$\3$\3$\3$\5$\u0195\n$\3$\3$\5$\u0199\n$\3$\3$\5$\u019d\n$"+
		"\3$\3$\3$\5$\u01a2\n$\3%\3%\3%\5%\u01a7\n%\3&\3&\3&\3&\3&\3&\3&\3\'\3"+
		"\'\5\'\u01b2\n\'\3\'\3\'\3\'\3\'\3\'\5\'\u01b9\n\'\5\'\u01bb\n\'\3(\3"+
		"(\3)\3)\3)\5)\u01c2\n)\3*\3*\3*\5*\u01c7\n*\3+\3+\3,\3,\5,\u01cd\n,\3"+
		"-\3-\3-\3.\3.\3.\3.\3.\5.\u01d7\n.\3/\3/\5/\u01db\n/\3\60\3\60\3\60\2"+
		"\3\32\61\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@BDFHJLNPRTVXZ\\^\2\t\4\2\65\66>?\3\2;<\4\2\65\65??\3\2\b\n\4\2--/"+
		"/\3\2\25\30\5\2-.CDKK\2\u01f5\2c\3\2\2\2\4u\3\2\2\2\6w\3\2\2\2\b}\3\2"+
		"\2\2\n\u0083\3\2\2\2\f\u008c\3\2\2\2\16\u0093\3\2\2\2\20\u00a9\3\2\2\2"+
		"\22\u00bc\3\2\2\2\24\u00c6\3\2\2\2\26\u00dc\3\2\2\2\30\u00e2\3\2\2\2\32"+
		"\u00e8\3\2\2\2\34\u00fc\3\2\2\2\36\u0103\3\2\2\2 \u0107\3\2\2\2\"\u010b"+
		"\3\2\2\2$\u0111\3\2\2\2&\u011d\3\2\2\2(\u011f\3\2\2\2*\u013a\3\2\2\2,"+
		"\u013c\3\2\2\2.\u0142\3\2\2\2\60\u014a\3\2\2\2\62\u0150\3\2\2\2\64\u0155"+
		"\3\2\2\2\66\u0157\3\2\2\28\u0160\3\2\2\2:\u0172\3\2\2\2<\u0174\3\2\2\2"+
		">\u0177\3\2\2\2@\u0180\3\2\2\2B\u0186\3\2\2\2D\u018c\3\2\2\2F\u01a1\3"+
		"\2\2\2H\u01a6\3\2\2\2J\u01a8\3\2\2\2L\u01ba\3\2\2\2N\u01bc\3\2\2\2P\u01c1"+
		"\3\2\2\2R\u01c6\3\2\2\2T\u01c8\3\2\2\2V\u01cc\3\2\2\2X\u01ce\3\2\2\2Z"+
		"\u01d6\3\2\2\2\\\u01da\3\2\2\2^\u01dc\3\2\2\2`b\5\4\3\2a`\3\2\2\2be\3"+
		"\2\2\2ca\3\2\2\2cd\3\2\2\2dj\3\2\2\2ec\3\2\2\2fi\58\35\2gi\5\66\34\2h"+
		"f\3\2\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\3\3\2\2\2lj\3\2\2\2"+
		"mv\5\b\5\2nv\5\6\4\2ov\5\n\6\2pv\5\26\f\2qv\5\30\r\2rv\5\16\b\2sv\5\24"+
		"\13\2tv\5\f\7\2um\3\2\2\2un\3\2\2\2uo\3\2\2\2up\3\2\2\2uq\3\2\2\2ur\3"+
		"\2\2\2us\3\2\2\2ut\3\2\2\2v\5\3\2\2\2wx\7\3\2\2xy\5^\60\2yz\7B\2\2z{\7"+
		"\65\2\2{|\7@\2\2|\7\3\2\2\2}~\7\4\2\2~\177\5^\60\2\177\u0080\7B\2\2\u0080"+
		"\u0081\t\2\2\2\u0081\u0082\7@\2\2\u0082\t\3\2\2\2\u0083\u0084\7\5\2\2"+
		"\u0084\u0085\5^\60\2\u0085\u0088\7B\2\2\u0086\u0089\7\65\2\2\u0087\u0089"+
		"\5*\26\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"\u008b\7@\2\2\u008b\13\3\2\2\2\u008c\u008d\7\7\2\2\u008d\u008e\5^\60\2"+
		"\u008e\u008f\7B\2\2\u008f\u0090\t\3\2\2\u0090\u0091\t\4\2\2\u0091\u0092"+
		"\7@\2\2\u0092\r\3\2\2\2\u0093\u0094\7\6\2\2\u0094\u0095\5^\60\2\u0095"+
		"\u009c\7B\2\2\u0096\u009d\5*\26\2\u0097\u0099\7?\2\2\u0098\u0097\3\2\2"+
		"\2\u0099\u009a\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d"+
		"\3\2\2\2\u009c\u0096\3\2\2\2\u009c\u0098\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009f\7@\2\2\u009f\u00a4\7!\2\2\u00a0\u00a3\5\22\n\2\u00a1\u00a3\5\20"+
		"\t\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a7\u00a8\7\"\2\2\u00a8\17\3\2\2\2\u00a9\u00aa\7\6\2\2\u00aa\u00ab"+
		"\5^\60\2\u00ab\u00ad\7B\2\2\u00ac\u00ae\7?\2\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2"+
		"\2\2\u00b1\u00b2\7@\2\2\u00b2\u00b7\7!\2\2\u00b3\u00b6\5\22\n\2\u00b4"+
		"\u00b6\5\20\t\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3"+
		"\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bb\7\"\2\2\u00bb\21\3\2\2\2\u00bc\u00bd\t\5\2"+
		"\2\u00bd\u00be\5^\60\2\u00be\u00c0\7B\2\2\u00bf\u00c1\7?\2\2\u00c0\u00bf"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\7@\2\2\u00c5\23\3\2\2\2\u00c6\u00c7\7\13\2"+
		"\2\u00c7\u00c8\5^\60\2\u00c8\u00cb\7F\2\2\u00c9\u00ca\7L\2\2\u00ca\u00cc"+
		"\7I\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00d0\7J\2\2\u00ce\u00cf\7G\2\2\u00cf\u00d1\7J\2\2\u00d0\u00ce\3\2\2"+
		"\2\u00d0\u00d1\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d3\7H\2\2\u00d3\u00d5"+
		"\7J\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d7\7I\2\2\u00d7\u00d9\7L\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2"+
		"\2\u00d9\u00da\3\2\2\2\u00da\u00db\7M\2\2\u00db\25\3\2\2\2\u00dc\u00dd"+
		"\7\f\2\2\u00dd\u00de\5^\60\2\u00de\u00df\7\31\2\2\u00df\u00e0\5\36\20"+
		"\2\u00e0\u00e1\7\32\2\2\u00e1\27\3\2\2\2\u00e2\u00e3\7\20\2\2\u00e3\u00e4"+
		"\5^\60\2\u00e4\u00e5\7\31\2\2\u00e5\u00e6\5\32\16\2\u00e6\u00e7\7\32\2"+
		"\2\u00e7\31\3\2\2\2\u00e8\u00e9\b\16\1\2\u00e9\u00ea\5\34\17\2\u00ea\u00eb"+
		"\7\21\2\2\u00eb\u00ec\t\6\2\2\u00ec\u00f5\3\2\2\2\u00ed\u00ee\f\3\2\2"+
		"\u00ee\u00ef\7(\2\2\u00ef\u00f0\5\34\17\2\u00f0\u00f1\7\21\2\2\u00f1\u00f2"+
		"\t\6\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00ed\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5"+
		"\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\33\3\2\2\2\u00f7\u00f5\3\2\2"+
		"\2\u00f8\u00f9\t\6\2\2\u00f9\u00fa\7&\2\2\u00fa\u00fd\5\34\17\2\u00fb"+
		"\u00fd\t\6\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\35\3\2\2"+
		"\2\u00fe\u0104\5\60\31\2\u00ff\u0104\5.\30\2\u0100\u0104\5,\27\2\u0101"+
		"\u0104\5 \21\2\u0102\u0104\5$\23\2\u0103\u00fe\3\2\2\2\u0103\u00ff\3\2"+
		"\2\2\u0103\u0100\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104"+
		"\37\3\2\2\2\u0105\u0108\5$\23\2\u0106\u0108\7/\2\2\u0107\u0105\3\2\2\2"+
		"\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a\5\"\22\2\u010a!\3"+
		"\2\2\2\u010b\u010f\7%\2\2\u010c\u0110\5$\23\2\u010d\u0110\7/\2\2\u010e"+
		"\u0110\5 \21\2\u010f\u010c\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2"+
		"\2\2\u0110#\3\2\2\2\u0111\u0112\5^\60\2\u0112\u0113\7$\2\2\u0113\u0116"+
		"\5&\24\2\u0114\u0115\7$\2\2\u0115\u0117\5(\25\2\u0116\u0114\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117%\3\2\2\2\u0118\u011e\5^\60\2\u0119\u011a\5^\60\2"+
		"\u011a\u011b\7$\2\2\u011b\u011c\5&\24\2\u011c\u011e\3\2\2\2\u011d\u0118"+
		"\3\2\2\2\u011d\u0119\3\2\2\2\u011e\'\3\2\2\2\u011f\u0120\7,\2\2\u0120"+
		")\3\2\2\2\u0121\u0123\7\67\2\2\u0122\u0124\7?\2\2\u0123\u0122\3\2\2\2"+
		"\u0124\u0125\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u013b"+
		"\3\2\2\2\u0127\u0129\78\2\2\u0128\u012a\7?\2\2\u0129\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u013b\3\2"+
		"\2\2\u012d\u013b\79\2\2\u012e\u0130\7:\2\2\u012f\u0131\7?\2\2\u0130\u012f"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133"+
		"\u013b\3\2\2\2\u0134\u0136\7=\2\2\u0135\u0137\7?\2\2\u0136\u0135\3\2\2"+
		"\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b"+
		"\3\2\2\2\u013a\u0121\3\2\2\2\u013a\u0127\3\2\2\2\u013a\u012d\3\2\2\2\u013a"+
		"\u012e\3\2\2\2\u013a\u0134\3\2\2\2\u013b+\3\2\2\2\u013c\u013d\5$\23\2"+
		"\u013d\u013e\7\r\2\2\u013e\u013f\5$\23\2\u013f\u0140\7\17\2\2\u0140\u0141"+
		"\5$\23\2\u0141-\3\2\2\2\u0142\u0143\5$\23\2\u0143\u0144\7\16\2\2\u0144"+
		"\u0145\5$\23\2\u0145\u0146\7\23\2\2\u0146\u0147\5$\23\2\u0147\u0148\7"+
		"+\2\2\u0148\u0149\5$\23\2\u0149/\3\2\2\2\u014a\u014b\5\62\32\2\u014b\u014c"+
		"\7\r\2\2\u014c\u014d\5\64\33\2\u014d\61\3\2\2\2\u014e\u0151\5$\23\2\u014f"+
		"\u0151\5 \21\2\u0150\u014e\3\2\2\2\u0150\u014f\3\2\2\2\u0151\63\3\2\2"+
		"\2\u0152\u0156\5$\23\2\u0153\u0156\5\60\31\2\u0154\u0156\5 \21\2\u0155"+
		"\u0152\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0154\3\2\2\2\u0156\65\3\2\2"+
		"\2\u0157\u0158\5X-\2\u0158\u015a\7\34\2\2\u0159\u015b\58\35\2\u015a\u0159"+
		"\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\7\36\2\2\u015f\67\3\2\2\2\u0160\u0161\5Z.\2"+
		"\u0161\u0162\5:\36\2\u0162\u0168\7!\2\2\u0163\u0164\5@!\2\u0164\u0165"+
		"\7#\2\2\u0165\u0167\3\2\2\2\u0166\u0163\3\2\2\2\u0167\u016a\3\2\2\2\u0168"+
		"\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2"+
		"\2\2\u016b\u016d\5@!\2\u016c\u016b\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016e"+
		"\3\2\2\2\u016e\u016f\7\"\2\2\u016f9\3\2\2\2\u0170\u0173\5> \2\u0171\u0173"+
		"\5<\37\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173;\3\2\2\2\u0174"+
		"\u0175\5\\/\2\u0175\u0176\5^\60\2\u0176=\3\2\2\2\u0177\u0178\5\\/\2\u0178"+
		"\u0179\7\33\2\2\u0179\u017c\5H%\2\u017a\u017b\7\22\2\2\u017b\u017d\5H"+
		"%\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u017f\7\35\2\2\u017f?\3\2\2\2\u0180\u0184\5V,\2\u0181\u0185\5B\"\2\u0182"+
		"\u0185\5T+\2\u0183\u0185\5X-\2\u0184\u0181\3\2\2\2\u0184\u0182\3\2\2\2"+
		"\u0184\u0183\3\2\2\2\u0185A\3\2\2\2\u0186\u0189\5D#\2\u0187\u018a\5P)"+
		"\2\u0188\u018a\5R*\2\u0189\u0187\3\2\2\2\u0189\u0188\3\2\2\2\u0189\u018a"+
		"\3\2\2\2\u018aC\3\2\2\2\u018b\u018d\5\\/\2\u018c\u018b\3\2\2\2\u018c\u018d"+
		"\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f\5F$\2\u018fE\3\2\2\2\u0190\u0191"+
		"\7\33\2\2\u0191\u0194\5H%\2\u0192\u0193\7\24\2\2\u0193\u0195\5^\60\2\u0194"+
		"\u0192\3\2\2\2\u0194\u0195\3\2\2\2\u0195\u0198\3\2\2\2\u0196\u0197\7\22"+
		"\2\2\u0197\u0199\5H%\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019c"+
		"\3\2\2\2\u019a\u019b\7\21\2\2\u019b\u019d\5N(\2\u019c\u019a\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\7\35\2\2\u019f\u01a2\3"+
		"\2\2\2\u01a0\u01a2\7/\2\2\u01a1\u0190\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2"+
		"G\3\2\2\2\u01a3\u01a7\5\36\20\2\u01a4\u01a7\5^\60\2\u01a5\u01a7\5J&\2"+
		"\u01a6\u01a3\3\2\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7I\3"+
		"\2\2\2\u01a8\u01a9\5^\60\2\u01a9\u01aa\7$\2\2\u01aa\u01ab\5^\60\2\u01ab"+
		"\u01ac\7\37\2\2\u01ac\u01ad\5L\'\2\u01ad\u01ae\7 \2\2\u01aeK\3\2\2\2\u01af"+
		"\u01b2\5\36\20\2\u01b0\u01b2\5^\60\2\u01b1\u01af\3\2\2\2\u01b1\u01b0\3"+
		"\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\7&\2\2\u01b4\u01b5\5L\'\2\u01b5"+
		"\u01bb\3\2\2\2\u01b6\u01b9\5\36\20\2\u01b7\u01b9\5^\60\2\u01b8\u01b6\3"+
		"\2\2\2\u01b8\u01b7\3\2\2\2\u01b9\u01bb\3\2\2\2\u01ba\u01b1\3\2\2\2\u01ba"+
		"\u01b8\3\2\2\2\u01bbM\3\2\2\2\u01bc\u01bd\t\7\2\2\u01bdO\3\2\2\2\u01be"+
		"\u01c2\7\60\2\2\u01bf\u01c2\5D#\2\u01c0\u01c2\5<\37\2\u01c1\u01be\3\2"+
		"\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2Q\3\2\2\2\u01c3\u01c7"+
		"\7\62\2\2\u01c4\u01c5\7*\2\2\u01c5\u01c7\5F$\2\u01c6\u01c3\3\2\2\2\u01c6"+
		"\u01c4\3\2\2\2\u01c7S\3\2\2\2\u01c8\u01c9\7\61\2\2\u01c9U\3\2\2\2\u01ca"+
		"\u01cd\5X-\2\u01cb\u01cd\7)\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cb\3\2\2"+
		"\2\u01cdW\3\2\2\2\u01ce\u01cf\5\\/\2\u01cf\u01d0\5^\60\2\u01d0Y\3\2\2"+
		"\2\u01d1\u01d7\5V,\2\u01d2\u01d3\7\31\2\2\u01d3\u01d4\5^\60\2\u01d4\u01d5"+
		"\7\32\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d1\3\2\2\2\u01d6\u01d2\3\2\2\2"+
		"\u01d7[\3\2\2\2\u01d8\u01db\5^\60\2\u01d9\u01db\7\65\2\2\u01da\u01d8\3"+
		"\2\2\2\u01da\u01d9\3\2\2\2\u01db]\3\2\2\2\u01dc\u01dd\t\b\2\2\u01dd_\3"+
		"\2\2\2\66chju\u0088\u009a\u009c\u00a2\u00a4\u00af\u00b5\u00b7\u00c2\u00cb"+
		"\u00d0\u00d4\u00d8\u00f5\u00fc\u0103\u0107\u010f\u0116\u011d\u0125\u012b"+
		"\u0132\u0138\u013a\u0150\u0155\u015c\u0168\u016c\u0172\u017c\u0184\u0189"+
		"\u018c\u0194\u0198\u019c\u01a1\u01a6\u01b1\u01b8\u01ba\u01c1\u01c6\u01cc"+
		"\u01d6\u01da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}