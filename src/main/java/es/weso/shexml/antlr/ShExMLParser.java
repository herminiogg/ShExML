// Generated from ShExMLParser.g4 by ANTLR 4.9.2

package es.weso.shexml.antlr;

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
		PREFIX=1, SOURCE=2, QUERY=3, ITERATOR=4, FIELD=5, PUSHED_FIELD=6, POPPED_FIELD=7, 
		AUTOINCREMENT=8, EXPRESSION=9, UNION=10, JOIN=11, MATCHER=12, AS=13, MATCHING=14, 
		RDFLIST=15, RDFBAG=16, RDFSEQ=17, RDFALT=18, LESS_SYMBOL=19, GREATER_SYMBOL=20, 
		BRACKET_LEFT=21, DOUBLE_BRACKET_LEFT=22, BRACKET_RIGHT=23, DOUBLE_BRACKET_RIGHT=24, 
		PAREN_LEFT=25, PAREN_RIGHT=26, BRACE_LEFT=27, BRACE_RIGHT=28, SEMICOLON=29, 
		DOT=30, ADD=31, COMMA=32, QUOTE=33, AND=34, A=35, AT=36, STRING_OR_VAR=37, 
		URI_VAR=38, STRINGOPERATOR=39, XMLSCHEMADATATYPE=40, SHAPELINK=41, LANGTAG=42, 
		COMMENT=43, WS=44, URL=45, JDBC_URL=46, JSONPATH=47, XMLPATH=48, CSVPERROW=49, 
		SQL=50, SPARQL=51, QUERY_PART=52, GREATER_SYMBOL_QUERY=53, WS_QUERY=54, 
		LESS_SYMBOL_QUERY=55, STRING_OR_VAR_QUERY=56, URI_VAR_QUERY=57, WS_DECLARATION=58, 
		LESS_SYMBOL_AUTOINCREMENT=59, TO=60, BY=61, ADD_AUTOINCREMENT=62, DIGITS=63, 
		STRING_OR_VAR_AUTOINCREMENT=64, STRINGOPERATOR_AUTOINCREMENT=65, GREATER_SYMBOL_AUTOINCREMENT=66, 
		WS_AUTOINCREMENT=67;
	public static final int
		RULE_shExML = 0, RULE_decl = 1, RULE_prefix = 2, RULE_source = 3, RULE_query = 4, 
		RULE_iterator = 5, RULE_nestedIterator = 6, RULE_field = 7, RULE_autoincrement = 8, 
		RULE_expression = 9, RULE_matcher = 10, RULE_matchers = 11, RULE_replacedStrings = 12, 
		RULE_exp = 13, RULE_stringOperation = 14, RULE_iteratorQuery = 15, RULE_composedVariable = 16, 
		RULE_queryClause = 17, RULE_join = 18, RULE_union = 19, RULE_leftUnionOption = 20, 
		RULE_rightUnionOption = 21, RULE_graph = 22, RULE_shape = 23, RULE_predicateObject = 24, 
		RULE_objectElement = 25, RULE_firstPartObjectElement = 26, RULE_valueRetriever = 27, 
		RULE_rdfCollection = 28, RULE_xmlschemadatatype = 29, RULE_langtag = 30, 
		RULE_shapeLink = 31, RULE_predicate = 32, RULE_literalValue = 33, RULE_tripleElement = 34, 
		RULE_prefixVar = 35, RULE_variable = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"shExML", "decl", "prefix", "source", "query", "iterator", "nestedIterator", 
			"field", "autoincrement", "expression", "matcher", "matchers", "replacedStrings", 
			"exp", "stringOperation", "iteratorQuery", "composedVariable", "queryClause", 
			"join", "union", "leftUnionOption", "rightUnionOption", "graph", "shape", 
			"predicateObject", "objectElement", "firstPartObjectElement", "valueRetriever", 
			"rdfCollection", "xmlschemadatatype", "langtag", "shapeLink", "predicate", 
			"literalValue", "tripleElement", "prefixVar", "variable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "'['", "'[['", 
			"']'", "']]'", "'('", "')'", "'{'", "'}'", "';'", "'.'", null, "','", 
			"'\"'", null, null, "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "PUSHED_FIELD", 
			"POPPED_FIELD", "AUTOINCREMENT", "EXPRESSION", "UNION", "JOIN", "MATCHER", 
			"AS", "MATCHING", "RDFLIST", "RDFBAG", "RDFSEQ", "RDFALT", "LESS_SYMBOL", 
			"GREATER_SYMBOL", "BRACKET_LEFT", "DOUBLE_BRACKET_LEFT", "BRACKET_RIGHT", 
			"DOUBLE_BRACKET_RIGHT", "PAREN_LEFT", "PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", 
			"SEMICOLON", "DOT", "ADD", "COMMA", "QUOTE", "AND", "A", "AT", "STRING_OR_VAR", 
			"URI_VAR", "STRINGOPERATOR", "XMLSCHEMADATATYPE", "SHAPELINK", "LANGTAG", 
			"COMMENT", "WS", "URL", "JDBC_URL", "JSONPATH", "XMLPATH", "CSVPERROW", 
			"SQL", "SPARQL", "QUERY_PART", "GREATER_SYMBOL_QUERY", "WS_QUERY", "LESS_SYMBOL_QUERY", 
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
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PREFIX) | (1L << SOURCE) | (1L << QUERY) | (1L << ITERATOR) | (1L << AUTOINCREMENT) | (1L << EXPRESSION) | (1L << MATCHER))) != 0)) {
				{
				{
				setState(74);
				decl();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (LESS_SYMBOL - 19)) | (1L << (A - 19)) | (1L << (STRING_OR_VAR - 19)) | (1L << (URI_VAR - 19)) | (1L << (URL - 19)) | (1L << (STRING_OR_VAR_QUERY - 19)) | (1L << (URI_VAR_QUERY - 19)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 19)))) != 0)) {
				{
				setState(82);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(80);
					shape();
					}
					break;
				case 2:
					{
					setState(81);
					graph();
					}
					break;
				}
				}
				setState(86);
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
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SOURCE:
				{
				setState(87);
				source();
				}
				break;
			case PREFIX:
				{
				setState(88);
				prefix();
				}
				break;
			case QUERY:
				{
				setState(89);
				query();
				}
				break;
			case EXPRESSION:
				{
				setState(90);
				expression();
				}
				break;
			case MATCHER:
				{
				setState(91);
				matcher();
				}
				break;
			case ITERATOR:
				{
				setState(92);
				iterator();
				}
				break;
			case AUTOINCREMENT:
				{
				setState(93);
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
			setState(96);
			match(PREFIX);
			setState(97);
			variable();
			setState(98);
			match(LESS_SYMBOL_QUERY);
			setState(99);
			match(URL);
			setState(100);
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
			setState(102);
			match(SOURCE);
			setState(103);
			variable();
			setState(104);
			match(LESS_SYMBOL_QUERY);
			setState(105);
			_la = _input.LA(1);
			if ( !(_la==URL || _la==JDBC_URL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(106);
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
			setState(108);
			match(QUERY);
			setState(109);
			variable();
			setState(110);
			match(LESS_SYMBOL_QUERY);
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case URL:
				{
				setState(111);
				match(URL);
				}
				break;
			case JSONPATH:
			case XMLPATH:
			case CSVPERROW:
			case SQL:
			case SPARQL:
				{
				setState(112);
				queryClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(115);
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
		enterRule(_localctx, 10, RULE_iterator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(ITERATOR);
			setState(118);
			variable();
			setState(119);
			match(LESS_SYMBOL_QUERY);
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONPATH:
			case XMLPATH:
			case CSVPERROW:
			case SQL:
			case SPARQL:
				{
				setState(120);
				queryClause();
				}
				break;
			case QUERY_PART:
				{
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(121);
					match(QUERY_PART);
					}
					}
					setState(124); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(128);
			match(GREATER_SYMBOL_QUERY);
			setState(129);
			match(BRACE_LEFT);
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130);
				field();
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0) );
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ITERATOR) {
				{
				{
				setState(135);
				nestedIterator();
				}
				}
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(141);
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
		enterRule(_localctx, 12, RULE_nestedIterator);
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
			setState(147); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(146);
				match(QUERY_PART);
				}
				}
				setState(149); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUERY_PART );
			setState(151);
			match(GREATER_SYMBOL_QUERY);
			setState(152);
			match(BRACE_LEFT);
			setState(154); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153);
				field();
				}
				}
				setState(156); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0) );
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ITERATOR) {
				{
				{
				setState(158);
				nestedIterator();
				}
				}
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
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
		enterRule(_localctx, 14, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FIELD) | (1L << PUSHED_FIELD) | (1L << POPPED_FIELD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(167);
			variable();
			setState(168);
			match(LESS_SYMBOL_QUERY);
			setState(170); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(169);
				match(QUERY_PART);
				}
				}
				setState(172); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUERY_PART );
			setState(174);
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
			setState(176);
			match(AUTOINCREMENT);
			setState(177);
			variable();
			setState(178);
			match(LESS_SYMBOL_AUTOINCREMENT);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRINGOPERATOR_AUTOINCREMENT) {
				{
				setState(179);
				match(STRINGOPERATOR_AUTOINCREMENT);
				setState(180);
				match(ADD_AUTOINCREMENT);
				}
			}

			setState(183);
			match(DIGITS);
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TO) {
				{
				setState(184);
				match(TO);
				setState(185);
				match(DIGITS);
				}
			}

			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BY) {
				{
				setState(188);
				match(BY);
				setState(189);
				match(DIGITS);
				}
			}

			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ADD_AUTOINCREMENT) {
				{
				setState(192);
				match(ADD_AUTOINCREMENT);
				setState(193);
				match(STRINGOPERATOR_AUTOINCREMENT);
				}
			}

			setState(196);
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
			setState(198);
			match(EXPRESSION);
			setState(199);
			variable();
			setState(200);
			match(LESS_SYMBOL);
			setState(201);
			exp();
			setState(202);
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
			setState(204);
			match(MATCHER);
			setState(205);
			variable();
			setState(206);
			match(LESS_SYMBOL);
			setState(207);
			matchers(0);
			setState(208);
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
			setState(211);
			replacedStrings();
			setState(212);
			match(AS);
			setState(213);
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
			setState(223);
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
					setState(215);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(216);
					match(AND);
					setState(217);
					replacedStrings();
					setState(218);
					match(AS);
					setState(219);
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
				setState(225);
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
		enterRule(_localctx, 24, RULE_replacedStrings);
		int _la;
		try {
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				_la = _input.LA(1);
				if ( !(_la==STRING_OR_VAR || _la==STRINGOPERATOR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(227);
				match(COMMA);
				setState(228);
				replacedStrings();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
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
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				union();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				join();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				stringOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
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
			setState(238);
			iteratorQuery();
			setState(239);
			match(ADD);
			setState(240);
			match(STRINGOPERATOR);
			setState(241);
			match(ADD);
			setState(242);
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
			setState(244);
			variable();
			setState(245);
			match(DOT);
			setState(246);
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
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				variable();
				setState(250);
				match(DOT);
				setState(251);
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
		enterRule(_localctx, 34, RULE_queryClause);
		int _la;
		try {
			setState(280);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONPATH:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				match(JSONPATH);
				setState(257); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(256);
					match(QUERY_PART);
					}
					}
					setState(259); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case XMLPATH:
				enterOuterAlt(_localctx, 2);
				{
				setState(261);
				match(XMLPATH);
				setState(263); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(262);
					match(QUERY_PART);
					}
					}
					setState(265); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case CSVPERROW:
				enterOuterAlt(_localctx, 3);
				{
				setState(267);
				match(CSVPERROW);
				}
				break;
			case SQL:
				enterOuterAlt(_localctx, 4);
				{
				setState(268);
				match(SQL);
				setState(270); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(269);
					match(QUERY_PART);
					}
					}
					setState(272); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==QUERY_PART );
				}
				break;
			case SPARQL:
				enterOuterAlt(_localctx, 5);
				{
				setState(274);
				match(SPARQL);
				setState(276); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(275);
					match(QUERY_PART);
					}
					}
					setState(278); 
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
		enterRule(_localctx, 36, RULE_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			iteratorQuery();
			setState(283);
			match(UNION);
			setState(284);
			iteratorQuery();
			setState(285);
			match(JOIN);
			setState(286);
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
			setState(288);
			leftUnionOption();
			setState(289);
			match(UNION);
			setState(290);
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
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
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
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				iteratorQuery();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				union();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
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
		enterRule(_localctx, 44, RULE_graph);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			literalValue();
			setState(302);
			match(DOUBLE_BRACKET_LEFT);
			setState(304); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(303);
				shape();
				}
				}
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 19)) & ~0x3f) == 0 && ((1L << (_la - 19)) & ((1L << (LESS_SYMBOL - 19)) | (1L << (A - 19)) | (1L << (STRING_OR_VAR - 19)) | (1L << (URI_VAR - 19)) | (1L << (URL - 19)) | (1L << (STRING_OR_VAR_QUERY - 19)) | (1L << (URI_VAR_QUERY - 19)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 19)))) != 0) );
			setState(308);
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
		enterRule(_localctx, 46, RULE_shape);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			tripleElement();
			setState(311);
			prefixVar();
			setState(312);
			match(BRACKET_LEFT);
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(313);
				exp();
				}
				break;
			case 2:
				{
				setState(314);
				variable();
				}
				break;
			}
			setState(317);
			match(BRACKET_RIGHT);
			setState(318);
			match(BRACE_LEFT);
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(319);
					predicateObject();
					setState(320);
					match(SEMICOLON);
					}
					} 
				}
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & ((1L << (A - 35)) | (1L << (STRING_OR_VAR - 35)) | (1L << (URI_VAR - 35)) | (1L << (URL - 35)) | (1L << (STRING_OR_VAR_QUERY - 35)) | (1L << (URI_VAR_QUERY - 35)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 35)))) != 0)) {
				{
				setState(327);
				predicateObject();
				}
			}

			setState(330);
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
		enterRule(_localctx, 48, RULE_predicateObject);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			predicate();
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(333);
				objectElement();
				}
				break;
			case 2:
				{
				setState(334);
				shapeLink();
				}
				break;
			case 3:
				{
				setState(335);
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
		enterRule(_localctx, 50, RULE_objectElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			firstPartObjectElement();
			setState(341);
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
				setState(339);
				xmlschemadatatype();
				}
				break;
			case AT:
			case LANGTAG:
				{
				setState(340);
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
		enterRule(_localctx, 52, RULE_firstPartObjectElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (STRING_OR_VAR - 37)) | (1L << (URI_VAR - 37)) | (1L << (URL - 37)) | (1L << (STRING_OR_VAR_QUERY - 37)) | (1L << (URI_VAR_QUERY - 37)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 37)))) != 0)) {
				{
				setState(343);
				prefixVar();
				}
			}

			setState(346);
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
		enterRule(_localctx, 54, RULE_valueRetriever);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_LEFT:
				{
				setState(348);
				match(BRACKET_LEFT);
				setState(351);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(349);
					exp();
					}
					break;
				case 2:
					{
					setState(350);
					variable();
					}
					break;
				}
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MATCHING) {
					{
					setState(353);
					match(MATCHING);
					setState(354);
					variable();
					}
				}

				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(357);
					match(AS);
					setState(358);
					rdfCollection();
					}
				}

				setState(361);
				match(BRACKET_RIGHT);
				}
				break;
			case STRINGOPERATOR:
				{
				setState(363);
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
		enterRule(_localctx, 56, RULE_rdfCollection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
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
		enterRule(_localctx, 58, RULE_xmlschemadatatype);
		try {
			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case XMLSCHEMADATATYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
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
				setState(369);
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
		enterRule(_localctx, 60, RULE_langtag);
		try {
			setState(375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LANGTAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				match(LANGTAG);
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				match(AT);
				setState(374);
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
		enterRule(_localctx, 62, RULE_shapeLink);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
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
		enterRule(_localctx, 64, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case URL:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				{
				setState(379);
				literalValue();
				}
				break;
			case A:
				{
				setState(380);
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
		enterRule(_localctx, 66, RULE_literalValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			prefixVar();
			setState(384);
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
		enterRule(_localctx, 68, RULE_tripleElement);
		try {
			setState(391);
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
				setState(386);
				predicate();
				}
				break;
			case LESS_SYMBOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				match(LESS_SYMBOL);
				setState(388);
				variable();
				setState(389);
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
		enterRule(_localctx, 70, RULE_prefixVar);
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_OR_VAR:
			case URI_VAR:
			case STRING_OR_VAR_QUERY:
			case URI_VAR_QUERY:
			case STRING_OR_VAR_AUTOINCREMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				variable();
				}
				break;
			case URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
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
		enterRule(_localctx, 72, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			_la = _input.LA(1);
			if ( !(((((_la - 37)) & ~0x3f) == 0 && ((1L << (_la - 37)) & ((1L << (STRING_OR_VAR - 37)) | (1L << (URI_VAR - 37)) | (1L << (STRING_OR_VAR_QUERY - 37)) | (1L << (URI_VAR_QUERY - 37)) | (1L << (STRING_OR_VAR_AUTOINCREMENT - 37)))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3E\u0192\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\7\2N\n\2\f\2\16\2Q\13\2\3\2\3"+
		"\2\7\2U\n\2\f\2\16\2X\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3a\n\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6t\n"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\6\7}\n\7\r\7\16\7~\5\7\u0081\n\7\3\7\3"+
		"\7\3\7\6\7\u0086\n\7\r\7\16\7\u0087\3\7\7\7\u008b\n\7\f\7\16\7\u008e\13"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\6\b\u0096\n\b\r\b\16\b\u0097\3\b\3\b\3\b\6"+
		"\b\u009d\n\b\r\b\16\b\u009e\3\b\7\b\u00a2\n\b\f\b\16\b\u00a5\13\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\6\t\u00ad\n\t\r\t\16\t\u00ae\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00b8\n\n\3\n\3\n\3\n\5\n\u00bd\n\n\3\n\3\n\5\n\u00c1\n\n"+
		"\3\n\3\n\5\n\u00c5\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e0\n"+
		"\r\f\r\16\r\u00e3\13\r\3\16\3\16\3\16\3\16\5\16\u00e9\n\16\3\17\3\17\3"+
		"\17\3\17\5\17\u00ef\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u0100\n\22\3\23\3\23\6\23\u0104\n"+
		"\23\r\23\16\23\u0105\3\23\3\23\6\23\u010a\n\23\r\23\16\23\u010b\3\23\3"+
		"\23\3\23\6\23\u0111\n\23\r\23\16\23\u0112\3\23\3\23\6\23\u0117\n\23\r"+
		"\23\16\23\u0118\5\23\u011b\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\5\26\u0129\n\26\3\27\3\27\3\27\5\27\u012e\n\27\3"+
		"\30\3\30\3\30\6\30\u0133\n\30\r\30\16\30\u0134\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u013e\n\31\3\31\3\31\3\31\3\31\3\31\7\31\u0145\n\31\f"+
		"\31\16\31\u0148\13\31\3\31\5\31\u014b\n\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\32\5\32\u0153\n\32\3\33\3\33\3\33\5\33\u0158\n\33\3\34\5\34\u015b\n\34"+
		"\3\34\3\34\3\35\3\35\3\35\5\35\u0162\n\35\3\35\3\35\5\35\u0166\n\35\3"+
		"\35\3\35\5\35\u016a\n\35\3\35\3\35\3\35\5\35\u016f\n\35\3\36\3\36\3\37"+
		"\3\37\5\37\u0175\n\37\3 \3 \3 \5 \u017a\n \3!\3!\3\"\3\"\5\"\u0180\n\""+
		"\3#\3#\3#\3$\3$\3$\3$\3$\5$\u018a\n$\3%\3%\5%\u018e\n%\3&\3&\3&\2\3\30"+
		"\'\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD"+
		"FHJ\2\7\3\2/\60\3\2\7\t\4\2\'\'))\3\2\21\24\5\2\'(:;BB\2\u01a5\2O\3\2"+
		"\2\2\4`\3\2\2\2\6b\3\2\2\2\bh\3\2\2\2\nn\3\2\2\2\fw\3\2\2\2\16\u0091\3"+
		"\2\2\2\20\u00a8\3\2\2\2\22\u00b2\3\2\2\2\24\u00c8\3\2\2\2\26\u00ce\3\2"+
		"\2\2\30\u00d4\3\2\2\2\32\u00e8\3\2\2\2\34\u00ee\3\2\2\2\36\u00f0\3\2\2"+
		"\2 \u00f6\3\2\2\2\"\u00ff\3\2\2\2$\u011a\3\2\2\2&\u011c\3\2\2\2(\u0122"+
		"\3\2\2\2*\u0128\3\2\2\2,\u012d\3\2\2\2.\u012f\3\2\2\2\60\u0138\3\2\2\2"+
		"\62\u014e\3\2\2\2\64\u0154\3\2\2\2\66\u015a\3\2\2\28\u016e\3\2\2\2:\u0170"+
		"\3\2\2\2<\u0174\3\2\2\2>\u0179\3\2\2\2@\u017b\3\2\2\2B\u017f\3\2\2\2D"+
		"\u0181\3\2\2\2F\u0189\3\2\2\2H\u018d\3\2\2\2J\u018f\3\2\2\2LN\5\4\3\2"+
		"ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PV\3\2\2\2QO\3\2\2\2RU\5\60\31"+
		"\2SU\5.\30\2TR\3\2\2\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\3\3\2"+
		"\2\2XV\3\2\2\2Ya\5\b\5\2Za\5\6\4\2[a\5\n\6\2\\a\5\24\13\2]a\5\26\f\2^"+
		"a\5\f\7\2_a\5\22\n\2`Y\3\2\2\2`Z\3\2\2\2`[\3\2\2\2`\\\3\2\2\2`]\3\2\2"+
		"\2`^\3\2\2\2`_\3\2\2\2a\5\3\2\2\2bc\7\3\2\2cd\5J&\2de\79\2\2ef\7/\2\2"+
		"fg\7\67\2\2g\7\3\2\2\2hi\7\4\2\2ij\5J&\2jk\79\2\2kl\t\2\2\2lm\7\67\2\2"+
		"m\t\3\2\2\2no\7\5\2\2op\5J&\2ps\79\2\2qt\7/\2\2rt\5$\23\2sq\3\2\2\2sr"+
		"\3\2\2\2tu\3\2\2\2uv\7\67\2\2v\13\3\2\2\2wx\7\6\2\2xy\5J&\2y\u0080\79"+
		"\2\2z\u0081\5$\23\2{}\7\66\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2"+
		"\2\2\177\u0081\3\2\2\2\u0080z\3\2\2\2\u0080|\3\2\2\2\u0081\u0082\3\2\2"+
		"\2\u0082\u0083\7\67\2\2\u0083\u0085\7\35\2\2\u0084\u0086\5\20\t\2\u0085"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008c\3\2\2\2\u0089\u008b\5\16\b\2\u008a\u0089\3\2\2\2\u008b"+
		"\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2"+
		"\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\36\2\2\u0090\r\3\2\2\2\u0091\u0092"+
		"\7\6\2\2\u0092\u0093\5J&\2\u0093\u0095\79\2\2\u0094\u0096\7\66\2\2\u0095"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\67\2\2\u009a\u009c\7\35\2\2\u009b"+
		"\u009d\5\20\t\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a3\3\2\2\2\u00a0\u00a2\5\16\b\2\u00a1"+
		"\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2"+
		"\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\7\36\2\2\u00a7"+
		"\17\3\2\2\2\u00a8\u00a9\t\3\2\2\u00a9\u00aa\5J&\2\u00aa\u00ac\79\2\2\u00ab"+
		"\u00ad\7\66\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3"+
		"\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\67\2\2\u00b1"+
		"\21\3\2\2\2\u00b2\u00b3\7\n\2\2\u00b3\u00b4\5J&\2\u00b4\u00b7\7=\2\2\u00b5"+
		"\u00b6\7C\2\2\u00b6\u00b8\7@\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2"+
		"\2\u00b8\u00b9\3\2\2\2\u00b9\u00bc\7A\2\2\u00ba\u00bb\7>\2\2\u00bb\u00bd"+
		"\7A\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be"+
		"\u00bf\7?\2\2\u00bf\u00c1\7A\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2"+
		"\2\u00c1\u00c4\3\2\2\2\u00c2\u00c3\7@\2\2\u00c3\u00c5\7C\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\7D\2\2\u00c7"+
		"\23\3\2\2\2\u00c8\u00c9\7\13\2\2\u00c9\u00ca\5J&\2\u00ca\u00cb\7\25\2"+
		"\2\u00cb\u00cc\5\34\17\2\u00cc\u00cd\7\26\2\2\u00cd\25\3\2\2\2\u00ce\u00cf"+
		"\7\16\2\2\u00cf\u00d0\5J&\2\u00d0\u00d1\7\25\2\2\u00d1\u00d2\5\30\r\2"+
		"\u00d2\u00d3\7\26\2\2\u00d3\27\3\2\2\2\u00d4\u00d5\b\r\1\2\u00d5\u00d6"+
		"\5\32\16\2\u00d6\u00d7\7\17\2\2\u00d7\u00d8\t\4\2\2\u00d8\u00e1\3\2\2"+
		"\2\u00d9\u00da\f\3\2\2\u00da\u00db\7$\2\2\u00db\u00dc\5\32\16\2\u00dc"+
		"\u00dd\7\17\2\2\u00dd\u00de\t\4\2\2\u00de\u00e0\3\2\2\2\u00df\u00d9\3"+
		"\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\31\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\t\4\2\2\u00e5\u00e6\7\"\2"+
		"\2\u00e6\u00e9\5\32\16\2\u00e7\u00e9\t\4\2\2\u00e8\u00e4\3\2\2\2\u00e8"+
		"\u00e7\3\2\2\2\u00e9\33\3\2\2\2\u00ea\u00ef\5(\25\2\u00eb\u00ef\5&\24"+
		"\2\u00ec\u00ef\5\36\20\2\u00ed\u00ef\5 \21\2\u00ee\u00ea\3\2\2\2\u00ee"+
		"\u00eb\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\35\3\2\2"+
		"\2\u00f0\u00f1\5 \21\2\u00f1\u00f2\7!\2\2\u00f2\u00f3\7)\2\2\u00f3\u00f4"+
		"\7!\2\2\u00f4\u00f5\5 \21\2\u00f5\37\3\2\2\2\u00f6\u00f7\5J&\2\u00f7\u00f8"+
		"\7 \2\2\u00f8\u00f9\5\"\22\2\u00f9!\3\2\2\2\u00fa\u0100\5J&\2\u00fb\u00fc"+
		"\5J&\2\u00fc\u00fd\7 \2\2\u00fd\u00fe\5\"\22\2\u00fe\u0100\3\2\2\2\u00ff"+
		"\u00fa\3\2\2\2\u00ff\u00fb\3\2\2\2\u0100#\3\2\2\2\u0101\u0103\7\61\2\2"+
		"\u0102\u0104\7\66\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103"+
		"\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u011b\3\2\2\2\u0107\u0109\7\62\2\2"+
		"\u0108\u010a\7\66\2\2\u0109\u0108\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u0109"+
		"\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u011b\3\2\2\2\u010d\u011b\7\63\2\2"+
		"\u010e\u0110\7\64\2\2\u010f\u0111\7\66\2\2\u0110\u010f\3\2\2\2\u0111\u0112"+
		"\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u011b\3\2\2\2\u0114"+
		"\u0116\7\65\2\2\u0115\u0117\7\66\2\2\u0116\u0115\3\2\2\2\u0117\u0118\3"+
		"\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011b\3\2\2\2\u011a"+
		"\u0101\3\2\2\2\u011a\u0107\3\2\2\2\u011a\u010d\3\2\2\2\u011a\u010e\3\2"+
		"\2\2\u011a\u0114\3\2\2\2\u011b%\3\2\2\2\u011c\u011d\5 \21\2\u011d\u011e"+
		"\7\f\2\2\u011e\u011f\5 \21\2\u011f\u0120\7\r\2\2\u0120\u0121\5 \21\2\u0121"+
		"\'\3\2\2\2\u0122\u0123\5*\26\2\u0123\u0124\7\f\2\2\u0124\u0125\5,\27\2"+
		"\u0125)\3\2\2\2\u0126\u0129\5 \21\2\u0127\u0129\5\36\20\2\u0128\u0126"+
		"\3\2\2\2\u0128\u0127\3\2\2\2\u0129+\3\2\2\2\u012a\u012e\5 \21\2\u012b"+
		"\u012e\5(\25\2\u012c\u012e\5\36\20\2\u012d\u012a\3\2\2\2\u012d\u012b\3"+
		"\2\2\2\u012d\u012c\3\2\2\2\u012e-\3\2\2\2\u012f\u0130\5D#\2\u0130\u0132"+
		"\7\30\2\2\u0131\u0133\5\60\31\2\u0132\u0131\3\2\2\2\u0133\u0134\3\2\2"+
		"\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137"+
		"\7\32\2\2\u0137/\3\2\2\2\u0138\u0139\5F$\2\u0139\u013a\5H%\2\u013a\u013d"+
		"\7\27\2\2\u013b\u013e\5\34\17\2\u013c\u013e\5J&\2\u013d\u013b\3\2\2\2"+
		"\u013d\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\u0140\7\31\2\2\u0140\u0146"+
		"\7\35\2\2\u0141\u0142\5\62\32\2\u0142\u0143\7\37\2\2\u0143\u0145\3\2\2"+
		"\2\u0144\u0141\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147"+
		"\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014b\5\62\32\2"+
		"\u014a\u0149\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014d"+
		"\7\36\2\2\u014d\61\3\2\2\2\u014e\u0152\5B\"\2\u014f\u0153\5\64\33\2\u0150"+
		"\u0153\5@!\2\u0151\u0153\5D#\2\u0152\u014f\3\2\2\2\u0152\u0150\3\2\2\2"+
		"\u0152\u0151\3\2\2\2\u0153\63\3\2\2\2\u0154\u0157\5\66\34\2\u0155\u0158"+
		"\5<\37\2\u0156\u0158\5> \2\u0157\u0155\3\2\2\2\u0157\u0156\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\65\3\2\2\2\u0159\u015b\5H%\2\u015a\u0159\3\2\2\2"+
		"\u015a\u015b\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015d\58\35\2\u015d\67"+
		"\3\2\2\2\u015e\u0161\7\27\2\2\u015f\u0162\5\34\17\2\u0160\u0162\5J&\2"+
		"\u0161\u015f\3\2\2\2\u0161\u0160\3\2\2\2\u0162\u0165\3\2\2\2\u0163\u0164"+
		"\7\20\2\2\u0164\u0166\5J&\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"\u0169\3\2\2\2\u0167\u0168\7\17\2\2\u0168\u016a\5:\36\2\u0169\u0167\3"+
		"\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\7\31\2\2\u016c"+
		"\u016f\3\2\2\2\u016d\u016f\7)\2\2\u016e\u015e\3\2\2\2\u016e\u016d\3\2"+
		"\2\2\u016f9\3\2\2\2\u0170\u0171\t\5\2\2\u0171;\3\2\2\2\u0172\u0175\7*"+
		"\2\2\u0173\u0175\5\66\34\2\u0174\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u0175"+
		"=\3\2\2\2\u0176\u017a\7,\2\2\u0177\u0178\7&\2\2\u0178\u017a\58\35\2\u0179"+
		"\u0176\3\2\2\2\u0179\u0177\3\2\2\2\u017a?\3\2\2\2\u017b\u017c\7+\2\2\u017c"+
		"A\3\2\2\2\u017d\u0180\5D#\2\u017e\u0180\7%\2\2\u017f\u017d\3\2\2\2\u017f"+
		"\u017e\3\2\2\2\u0180C\3\2\2\2\u0181\u0182\5H%\2\u0182\u0183\5J&\2\u0183"+
		"E\3\2\2\2\u0184\u018a\5B\"\2\u0185\u0186\7\25\2\2\u0186\u0187\5J&\2\u0187"+
		"\u0188\7\26\2\2\u0188\u018a\3\2\2\2\u0189\u0184\3\2\2\2\u0189\u0185\3"+
		"\2\2\2\u018aG\3\2\2\2\u018b\u018e\5J&\2\u018c\u018e\7/\2\2\u018d\u018b"+
		"\3\2\2\2\u018d\u018c\3\2\2\2\u018eI\3\2\2\2\u018f\u0190\t\6\2\2\u0190"+
		"K\3\2\2\2.OTV`s~\u0080\u0087\u008c\u0097\u009e\u00a3\u00ae\u00b7\u00bc"+
		"\u00c0\u00c4\u00e1\u00e8\u00ee\u00ff\u0105\u010b\u0112\u0118\u011a\u0128"+
		"\u012d\u0134\u013d\u0146\u014a\u0152\u0157\u015a\u0161\u0165\u0169\u016e"+
		"\u0174\u0179\u017f\u0189\u018d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}