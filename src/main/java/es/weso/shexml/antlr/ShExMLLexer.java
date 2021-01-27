// Generated from ShExMLLexer.g4 by ANTLR 4.8

package es.weso.shexml.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShExMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

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
		QUERY_CONTENT=1, DECLARATION_CONTENT=2, AUTOINCREMENT_CONTENT=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "QUERY_CONTENT", "DECLARATION_CONTENT", "AUTOINCREMENT_CONTENT"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "PUSHED_FIELD", "POPPED_FIELD", 
			"AUTOINCREMENT", "EXPRESSION", "UNION", "JOIN", "MATCHER", "AS", "MATCHING", 
			"RDFLIST", "RDFBAG", "RDFSEQ", "RDFALT", "LESS_SYMBOL", "GREATER_SYMBOL", 
			"BRACKET_LEFT", "DOUBLE_BRACKET_LEFT", "BRACKET_RIGHT", "DOUBLE_BRACKET_RIGHT", 
			"PAREN_LEFT", "PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", 
			"DOT", "ADD", "COMMA", "QUOTE", "AND", "A", "AT", "STRING_OR_VAR", "URI_VAR", 
			"STRINGOPERATOR", "XMLSCHEMADATATYPE", "SHAPELINK", "LANGTAG", "COMMENT", 
			"WS", "URL", "JDBC_URL", "JSONPATH", "XMLPATH", "CSVPERROW", "SQL", "SPARQL", 
			"QUERY_PART", "GREATER_SYMBOL_QUERY", "WS_QUERY", "LESS_SYMBOL_QUERY", 
			"STRING_OR_VAR_QUERY", "URI_VAR_QUERY", "WS_DECLARATION", "LESS_SYMBOL_AUTOINCREMENT", 
			"TO", "BY", "ADD_AUTOINCREMENT", "DIGITS", "STRING_OR_VAR_AUTOINCREMENT", 
			"STRINGOPERATOR_AUTOINCREMENT", "GREATER_SYMBOL_AUTOINCREMENT", "WS_AUTOINCREMENT", 
			"LETTER", "DIGIT", "XMLSCHEMADATATYPEPREFIX", "ALLOWEDTYPES", "ALLOWED_CHARACTERS", 
			"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
			"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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


	public ShExMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ShExMLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2E\u0434\b\1\b\1\b"+
		"\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t"+
		"\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30"+
		"\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37"+
		"\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)"+
		"\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63"+
		"\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;"+
		"\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G"+
		"\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR"+
		"\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4"+
		"^\t^\4_\t_\4`\t`\4a\ta\4b\tb\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3"+
		"\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\5#\u018f\n#\3$\3$\3%\3%"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\6&\u019d\n&\r&\16&\u019e\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\7\'\u01a9\n\'\f\'\16\'\u01ac\13\'\3\'\3\'\3(\3(\3(\3(\3("+
		"\6(\u01b5\n(\r(\16(\u01b6\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\5"+
		"*\u01c7\n*\3+\3+\6+\u01cb\n+\r+\16+\u01cc\3+\3+\3+\6+\u01d2\n+\r+\16+"+
		"\u01d3\7+\u01d6\n+\f+\16+\u01d9\13+\3,\3,\7,\u01dd\n,\f,\16,\u01e0\13"+
		",\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\5.\u01f5\n"+
		".\3.\3.\3.\3.\3.\3.\3.\7.\u01fe\n.\f.\16.\u0201\13.\3/\3/\3/\3/\3/\3/"+
		"\3/\3/\6/\u020b\n/\r/\16/\u020c\3/\3/\3/\3/\7/\u0213\n/\f/\16/\u0216\13"+
		"/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\6\65\u0244\n\65\r\65\16\65\u0245\3\66\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\3\67\38\38\38\38\39\39\39\39\79\u0258\n9\f9\169\u025b\139\3:"+
		"\3:\3:\7:\u0260\n:\f:\16:\u0263\13:\3:\3:\3;\3;\3;\3;\3<\3<\3=\3=\3=\3"+
		">\3>\3>\3?\3?\3@\6@\u0276\n@\r@\16@\u0277\3A\3A\3A\3A\7A\u027e\nA\fA\16"+
		"A\u0281\13A\3B\3B\3B\3B\3B\6B\u0288\nB\rB\16B\u0289\3B\3B\3C\3C\3C\3C"+
		"\3D\3D\3D\3D\3E\5E\u0297\nE\3F\3F\3G\3G\3G\3G\3G\5G\u02a0\nG\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H"+
		"\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\3H\5H\u03fa\nH"+
		"\3I\3I\3I\3I\3I\5I\u0401\nI\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P"+
		"\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\"+
		"\3\\\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\3b\3b\2\2c\6\3\b\4\n\5\f\6\16\7\20"+
		"\b\22\t\24\n\26\13\30\f\32\r\34\16\36\17 \20\"\21$\22&\23(\24*\25,\26"+
		".\27\60\30\62\31\64\32\66\338\34:\35<\36>\37@ B!D\"F#H$J%L&N\'P(R)T*V"+
		"+X,Z-\\.^/`\60b\61d\62f\63h\64j\65l\66n\67p8r9t:v;x<z=|>~?\u0080@\u0082"+
		"A\u0084B\u0086C\u0088D\u008aE\u008c\2\u008e\2\u0090\2\u0092\2\u0094\2"+
		"\u0096\2\u0098\2\u009a\2\u009c\2\u009e\2\u00a0\2\u00a2\2\u00a4\2\u00a6"+
		"\2\u00a8\2\u00aa\2\u00ac\2\u00ae\2\u00b0\2\u00b2\2\u00b4\2\u00b6\2\u00b8"+
		"\2\u00ba\2\u00bc\2\u00be\2\u00c0\2\u00c2\2\u00c4\2\u00c6\2\6\2\3\4\5#"+
		"\4\2CCcc\4\2//aa\4\2\f\f\17\17\5\2\13\f\17\17\"\"\5\2$$}}\177\177\7\2"+
		"C\\c|\u00c2\u00d8\u00da\u00f8\u00fa\u0101\3\2\62;\b\2%,.\61<=??AB]a\4"+
		"\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLl"+
		"l\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2"+
		"UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u046c"+
		"\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2"+
		"\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2"+
		"\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2"+
		"\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2"+
		"\2\2\64\3\2\2\2\2\66\3\2\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2"+
		"\2\2@\3\2\2\2\2B\3\2\2\2\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2"+
		"L\3\2\2\2\2N\3\2\2\2\2P\3\2\2\2\2R\3\2\2\2\2T\3\2\2\2\2V\3\2\2\2\2X\3"+
		"\2\2\2\2Z\3\2\2\2\2\\\3\2\2\2\3^\3\2\2\2\3`\3\2\2\2\3b\3\2\2\2\3d\3\2"+
		"\2\2\3f\3\2\2\2\3h\3\2\2\2\3j\3\2\2\2\3l\3\2\2\2\3n\3\2\2\2\3p\3\2\2\2"+
		"\4r\3\2\2\2\4t\3\2\2\2\4v\3\2\2\2\4x\3\2\2\2\5z\3\2\2\2\5|\3\2\2\2\5~"+
		"\3\2\2\2\5\u0080\3\2\2\2\5\u0082\3\2\2\2\5\u0084\3\2\2\2\5\u0086\3\2\2"+
		"\2\5\u0088\3\2\2\2\5\u008a\3\2\2\2\6\u00c8\3\2\2\2\b\u00d1\3\2\2\2\n\u00da"+
		"\3\2\2\2\f\u00e2\3\2\2\2\16\u00ed\3\2\2\2\20\u00f5\3\2\2\2\22\u0104\3"+
		"\2\2\2\24\u0113\3\2\2\2\26\u0123\3\2\2\2\30\u012e\3\2\2\2\32\u0134\3\2"+
		"\2\2\34\u0139\3\2\2\2\36\u0141\3\2\2\2 \u0144\3\2\2\2\"\u014d\3\2\2\2"+
		"$\u0155\3\2\2\2&\u015c\3\2\2\2(\u0163\3\2\2\2*\u016a\3\2\2\2,\u016c\3"+
		"\2\2\2.\u016e\3\2\2\2\60\u0170\3\2\2\2\62\u0173\3\2\2\2\64\u0175\3\2\2"+
		"\2\66\u0178\3\2\2\28\u017a\3\2\2\2:\u017c\3\2\2\2<\u017e\3\2\2\2>\u0180"+
		"\3\2\2\2@\u0182\3\2\2\2B\u0184\3\2\2\2D\u0186\3\2\2\2F\u0188\3\2\2\2H"+
		"\u018e\3\2\2\2J\u0190\3\2\2\2L\u0192\3\2\2\2N\u019c\3\2\2\2P\u01aa\3\2"+
		"\2\2R\u01af\3\2\2\2T\u01ba\3\2\2\2V\u01be\3\2\2\2X\u01c8\3\2\2\2Z\u01da"+
		"\3\2\2\2\\\u01e3\3\2\2\2^\u01f4\3\2\2\2`\u0202\3\2\2\2b\u0217\3\2\2\2"+
		"d\u0221\3\2\2\2f\u0228\3\2\2\2h\u0232\3\2\2\2j\u0237\3\2\2\2l\u0243\3"+
		"\2\2\2n\u0247\3\2\2\2p\u024b\3\2\2\2r\u024f\3\2\2\2t\u0253\3\2\2\2v\u0261"+
		"\3\2\2\2x\u0266\3\2\2\2z\u026a\3\2\2\2|\u026c\3\2\2\2~\u026f\3\2\2\2\u0080"+
		"\u0272\3\2\2\2\u0082\u0275\3\2\2\2\u0084\u0279\3\2\2\2\u0086\u0282\3\2"+
		"\2\2\u0088\u028d\3\2\2\2\u008a\u0291\3\2\2\2\u008c\u0296\3\2\2\2\u008e"+
		"\u0298\3\2\2\2\u0090\u029f\3\2\2\2\u0092\u03f9\3\2\2\2\u0094\u0400\3\2"+
		"\2\2\u0096\u0402\3\2\2\2\u0098\u0404\3\2\2\2\u009a\u0406\3\2\2\2\u009c"+
		"\u0408\3\2\2\2\u009e\u040a\3\2\2\2\u00a0\u040c\3\2\2\2\u00a2\u040e\3\2"+
		"\2\2\u00a4\u0410\3\2\2\2\u00a6\u0412\3\2\2\2\u00a8\u0414\3\2\2\2\u00aa"+
		"\u0416\3\2\2\2\u00ac\u0418\3\2\2\2\u00ae\u041a\3\2\2\2\u00b0\u041c\3\2"+
		"\2\2\u00b2\u041e\3\2\2\2\u00b4\u0420\3\2\2\2\u00b6\u0422\3\2\2\2\u00b8"+
		"\u0424\3\2\2\2\u00ba\u0426\3\2\2\2\u00bc\u0428\3\2\2\2\u00be\u042a\3\2"+
		"\2\2\u00c0\u042c\3\2\2\2\u00c2\u042e\3\2\2\2\u00c4\u0430\3\2\2\2\u00c6"+
		"\u0432\3\2\2\2\u00c8\u00c9\5\u00b2X\2\u00c9\u00ca\5\u00b6Z\2\u00ca\u00cb"+
		"\5\u009cM\2\u00cb\u00cc\5\u009eN\2\u00cc\u00cd\5\u00a4Q\2\u00cd\u00ce"+
		"\5\u00c2`\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\b\2\2\2\u00d0\7\3\2\2\2\u00d1"+
		"\u00d2\5\u00b8[\2\u00d2\u00d3\5\u00b0W\2\u00d3\u00d4\5\u00bc]\2\u00d4"+
		"\u00d5\5\u00b6Z\2\u00d5\u00d6\5\u0098K\2\u00d6\u00d7\5\u009cM\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\b\3\2\2\u00d9\t\3\2\2\2\u00da\u00db\5\u00b4"+
		"Y\2\u00db\u00dc\5\u00bc]\2\u00dc\u00dd\5\u009cM\2\u00dd\u00de\5\u00b6"+
		"Z\2\u00de\u00df\5\u00c4a\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\b\4\2\2\u00e1"+
		"\13\3\2\2\2\u00e2\u00e3\5\u00a4Q\2\u00e3\u00e4\5\u00ba\\\2\u00e4\u00e5"+
		"\5\u009cM\2\u00e5\u00e6\5\u00b6Z\2\u00e6\u00e7\5J$\2\u00e7\u00e8\5\u00ba"+
		"\\\2\u00e8\u00e9\5\u00b0W\2\u00e9\u00ea\5\u00b6Z\2\u00ea\u00eb\3\2\2\2"+
		"\u00eb\u00ec\b\5\2\2\u00ec\r\3\2\2\2\u00ed\u00ee\5\u009eN\2\u00ee\u00ef"+
		"\5\u00a4Q\2\u00ef\u00f0\5\u009cM\2\u00f0\u00f1\5\u00aaT\2\u00f1\u00f2"+
		"\5\u009aL\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\b\6\2\2\u00f4\17\3\2\2\2\u00f5"+
		"\u00f6\5\u00b2X\2\u00f6\u00f7\5\u00bc]\2\u00f7\u00f8\5\u00b8[\2\u00f8"+
		"\u00f9\5\u00a2P\2\u00f9\u00fa\5\u009cM\2\u00fa\u00fb\5\u009aL\2\u00fb"+
		"\u00fc\7a\2\2\u00fc\u00fd\5\u009eN\2\u00fd\u00fe\5\u00a4Q\2\u00fe\u00ff"+
		"\5\u009cM\2\u00ff\u0100\5\u00aaT\2\u0100\u0101\5\u009aL\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0103\b\7\2\2\u0103\21\3\2\2\2\u0104\u0105\5\u00b2X\2\u0105"+
		"\u0106\5\u00b0W\2\u0106\u0107\5\u00b2X\2\u0107\u0108\5\u00b2X\2\u0108"+
		"\u0109\5\u009cM\2\u0109\u010a\5\u009aL\2\u010a\u010b\7a\2\2\u010b\u010c"+
		"\5\u009eN\2\u010c\u010d\5\u00a4Q\2\u010d\u010e\5\u009cM\2\u010e\u010f"+
		"\5\u00aaT\2\u010f\u0110\5\u009aL\2\u0110\u0111\3\2\2\2\u0111\u0112\b\b"+
		"\2\2\u0112\23\3\2\2\2\u0113\u0114\5J$\2\u0114\u0115\5\u00bc]\2\u0115\u0116"+
		"\5\u00ba\\\2\u0116\u0117\5\u00b0W\2\u0117\u0118\5\u00a4Q\2\u0118\u0119"+
		"\5\u00aeV\2\u0119\u011a\5\u0098K\2\u011a\u011b\5\u00b6Z\2\u011b\u011c"+
		"\5\u009cM\2\u011c\u011d\5\u00acU\2\u011d\u011e\5\u009cM\2\u011e\u011f"+
		"\5\u00aeV\2\u011f\u0120\5\u00ba\\\2\u0120\u0121\3\2\2\2\u0121\u0122\b"+
		"\t\3\2\u0122\25\3\2\2\2\u0123\u0124\5\u009cM\2\u0124\u0125\5\u00c2`\2"+
		"\u0125\u0126\5\u00b2X\2\u0126\u0127\5\u00b6Z\2\u0127\u0128\5\u009cM\2"+
		"\u0128\u0129\5\u00b8[\2\u0129\u012a\5\u00b8[\2\u012a\u012b\5\u00a4Q\2"+
		"\u012b\u012c\5\u00b0W\2\u012c\u012d\5\u00aeV\2\u012d\27\3\2\2\2\u012e"+
		"\u012f\5\u00bc]\2\u012f\u0130\5\u00aeV\2\u0130\u0131\5\u00a4Q\2\u0131"+
		"\u0132\5\u00b0W\2\u0132\u0133\5\u00aeV\2\u0133\31\3\2\2\2\u0134\u0135"+
		"\5\u00a6R\2\u0135\u0136\5\u00b0W\2\u0136\u0137\5\u00a4Q\2\u0137\u0138"+
		"\5\u00aeV\2\u0138\33\3\2\2\2\u0139\u013a\5\u00acU\2\u013a\u013b\5J$\2"+
		"\u013b\u013c\5\u00ba\\\2\u013c\u013d\5\u0098K\2\u013d\u013e\5\u00a2P\2"+
		"\u013e\u013f\5\u009cM\2\u013f\u0140\5\u00b6Z\2\u0140\35\3\2\2\2\u0141"+
		"\u0142\5J$\2\u0142\u0143\5\u00b8[\2\u0143\37\3\2\2\2\u0144\u0145\5\u00ac"+
		"U\2\u0145\u0146\5J$\2\u0146\u0147\5\u00ba\\\2\u0147\u0148\5\u0098K\2\u0148"+
		"\u0149\5\u00a2P\2\u0149\u014a\5\u00a4Q\2\u014a\u014b\5\u00aeV\2\u014b"+
		"\u014c\5\u00a0O\2\u014c!\3\2\2\2\u014d\u014e\5\u00b6Z\2\u014e\u014f\5"+
		"\u009aL\2\u014f\u0150\5\u009eN\2\u0150\u0151\5\u00aaT\2\u0151\u0152\5"+
		"\u00a4Q\2\u0152\u0153\5\u00b8[\2\u0153\u0154\5\u00ba\\\2\u0154#\3\2\2"+
		"\2\u0155\u0156\5\u00b6Z\2\u0156\u0157\5\u009aL\2\u0157\u0158\5\u009eN"+
		"\2\u0158\u0159\5\u0096J\2\u0159\u015a\5J$\2\u015a\u015b\5\u00a0O\2\u015b"+
		"%\3\2\2\2\u015c\u015d\5\u00b6Z\2\u015d\u015e\5\u009aL\2\u015e\u015f\5"+
		"\u009eN\2\u015f\u0160\5\u00b8[\2\u0160\u0161\5\u009cM\2\u0161\u0162\5"+
		"\u00b4Y\2\u0162\'\3\2\2\2\u0163\u0164\5\u00b6Z\2\u0164\u0165\5\u009aL"+
		"\2\u0165\u0166\5\u009eN\2\u0166\u0167\5J$\2\u0167\u0168\5\u00aaT\2\u0168"+
		"\u0169\5\u00ba\\\2\u0169)\3\2\2\2\u016a\u016b\7>\2\2\u016b+\3\2\2\2\u016c"+
		"\u016d\7@\2\2\u016d-\3\2\2\2\u016e\u016f\7]\2\2\u016f/\3\2\2\2\u0170\u0171"+
		"\7]\2\2\u0171\u0172\7]\2\2\u0172\61\3\2\2\2\u0173\u0174\7_\2\2\u0174\63"+
		"\3\2\2\2\u0175\u0176\7_\2\2\u0176\u0177\7_\2\2\u0177\65\3\2\2\2\u0178"+
		"\u0179\7*\2\2\u0179\67\3\2\2\2\u017a\u017b\7+\2\2\u017b9\3\2\2\2\u017c"+
		"\u017d\7}\2\2\u017d;\3\2\2\2\u017e\u017f\7\177\2\2\u017f=\3\2\2\2\u0180"+
		"\u0181\7=\2\2\u0181?\3\2\2\2\u0182\u0183\7\60\2\2\u0183A\3\2\2\2\u0184"+
		"\u0185\7-\2\2\u0185C\3\2\2\2\u0186\u0187\7.\2\2\u0187E\3\2\2\2\u0188\u0189"+
		"\7$\2\2\u0189G\3\2\2\2\u018a\u018f\7(\2\2\u018b\u018c\7C\2\2\u018c\u018d"+
		"\7P\2\2\u018d\u018f\7F\2\2\u018e\u018a\3\2\2\2\u018e\u018b\3\2\2\2\u018f"+
		"I\3\2\2\2\u0190\u0191\t\2\2\2\u0191K\3\2\2\2\u0192\u0193\7B\2\2\u0193"+
		"M\3\2\2\2\u0194\u019d\5\u008cE\2\u0195\u019d\5\u008eF\2\u0196\u019d\t"+
		"\3\2\2\u0197\u0198\7^\2\2\u0198\u019d\7\60\2\2\u0199\u019a\7\'\2\2\u019a"+
		"\u019b\7\64\2\2\u019b\u019d\7G\2\2\u019c\u0194\3\2\2\2\u019c\u0195\3\2"+
		"\2\2\u019c\u0196\3\2\2\2\u019c\u0197\3\2\2\2\u019c\u0199\3\2\2\2\u019d"+
		"\u019e\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019fO\3\2\2\2"+
		"\u01a0\u01a9\5\u008cE\2\u01a1\u01a9\5\u008eF\2\u01a2\u01a9\7a\2\2\u01a3"+
		"\u01a4\7^\2\2\u01a4\u01a9\7\60\2\2\u01a5\u01a6\7\'\2\2\u01a6\u01a7\7\64"+
		"\2\2\u01a7\u01a9\7G\2\2\u01a8\u01a0\3\2\2\2\u01a8\u01a1\3\2\2\2\u01a8"+
		"\u01a2\3\2\2\2\u01a8\u01a3\3\2\2\2\u01a8\u01a5\3\2\2\2\u01a9\u01ac\3\2"+
		"\2\2\u01aa\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ad\3\2\2\2\u01ac"+
		"\u01aa\3\2\2\2\u01ad\u01ae\7<\2\2\u01aeQ\3\2\2\2\u01af\u01b4\7$\2\2\u01b0"+
		"\u01b5\5\u008cE\2\u01b1\u01b5\5\u008eF\2\u01b2\u01b5\5\u0094I\2\u01b3"+
		"\u01b5\7\"\2\2\u01b4\u01b0\3\2\2\2\u01b4\u01b1\3\2\2\2\u01b4\u01b2\3\2"+
		"\2\2\u01b4\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\7$\2\2\u01b9S\3\2\2\2\u01ba"+
		"\u01bb\5\u0090G\2\u01bb\u01bc\7<\2\2\u01bc\u01bd\5\u0092H\2\u01bdU\3\2"+
		"\2\2\u01be\u01c6\7B\2\2\u01bf\u01c0\5P\'\2\u01c0\u01c1\5N&\2\u01c1\u01c7"+
		"\3\2\2\2\u01c2\u01c3\7>\2\2\u01c3\u01c4\5N&\2\u01c4\u01c5\7@\2\2\u01c5"+
		"\u01c7\3\2\2\2\u01c6\u01bf\3\2\2\2\u01c6\u01c2\3\2\2\2\u01c7W\3\2\2\2"+
		"\u01c8\u01ca\7B\2\2\u01c9\u01cb\5\u008cE\2\u01ca\u01c9\3\2\2\2\u01cb\u01cc"+
		"\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d7\3\2\2\2\u01ce"+
		"\u01d1\7/\2\2\u01cf\u01d2\5\u008cE\2\u01d0\u01d2\5\u008eF\2\u01d1\u01cf"+
		"\3\2\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3"+
		"\u01d4\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01ce\3\2\2\2\u01d6\u01d9\3\2"+
		"\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8Y\3\2\2\2\u01d9\u01d7"+
		"\3\2\2\2\u01da\u01de\7%\2\2\u01db\u01dd\n\4\2\2\u01dc\u01db\3\2\2\2\u01dd"+
		"\u01e0\3\2\2\2\u01de\u01dc\3\2\2\2\u01de\u01df\3\2\2\2\u01df\u01e1\3\2"+
		"\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e2\b,\4\2\u01e2[\3\2\2\2\u01e3\u01e4"+
		"\t\5\2\2\u01e4\u01e5\3\2\2\2\u01e5\u01e6\b-\4\2\u01e6]\3\2\2\2\u01e7\u01e8"+
		"\7j\2\2\u01e8\u01e9\7v\2\2\u01e9\u01ea\7v\2\2\u01ea\u01f5\7r\2\2\u01eb"+
		"\u01ec\7j\2\2\u01ec\u01ed\7v\2\2\u01ed\u01ee\7v\2\2\u01ee\u01ef\7r\2\2"+
		"\u01ef\u01f5\7u\2\2\u01f0\u01f1\7h\2\2\u01f1\u01f2\7k\2\2\u01f2\u01f3"+
		"\7n\2\2\u01f3\u01f5\7g\2\2\u01f4\u01e7\3\2\2\2\u01f4\u01eb\3\2\2\2\u01f4"+
		"\u01f0\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f7\7<\2\2\u01f7\u01f8\7\61"+
		"\2\2\u01f8\u01f9\7\61\2\2\u01f9\u01ff\3\2\2\2\u01fa\u01fe\5\u008cE\2\u01fb"+
		"\u01fe\5\u008eF\2\u01fc\u01fe\5\u0094I\2\u01fd\u01fa\3\2\2\2\u01fd\u01fb"+
		"\3\2\2\2\u01fd\u01fc\3\2\2\2\u01fe\u0201\3\2\2\2\u01ff\u01fd\3\2\2\2\u01ff"+
		"\u0200\3\2\2\2\u0200_\3\2\2\2\u0201\u01ff\3\2\2\2\u0202\u0203\7l\2\2\u0203"+
		"\u0204\7f\2\2\u0204\u0205\7d\2\2\u0205\u0206\7e\2\2\u0206\u0207\7<\2\2"+
		"\u0207\u020a\3\2\2\2\u0208\u020b\5\u008cE\2\u0209\u020b\5\u008eF\2\u020a"+
		"\u0208\3\2\2\2\u020a\u0209\3\2\2\2\u020b\u020c\3\2\2\2\u020c\u020a\3\2"+
		"\2\2\u020c\u020d\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u0214\7<\2\2\u020f"+
		"\u0213\5\u008cE\2\u0210\u0213\5\u008eF\2\u0211\u0213\5\u0094I\2\u0212"+
		"\u020f\3\2\2\2\u0212\u0210\3\2\2\2\u0212\u0211\3\2\2\2\u0213\u0216\3\2"+
		"\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215a\3\2\2\2\u0216\u0214"+
		"\3\2\2\2\u0217\u0218\5\u00a6R\2\u0218\u0219\5\u00b8[\2\u0219\u021a\5\u00b0"+
		"W\2\u021a\u021b\5\u00aeV\2\u021b\u021c\5\u00b2X\2\u021c\u021d\5J$\2\u021d"+
		"\u021e\5\u00ba\\\2\u021e\u021f\5\u00a2P\2\u021f\u0220\7<\2\2\u0220c\3"+
		"\2\2\2\u0221\u0222\5\u00c2`\2\u0222\u0223\5\u00b2X\2\u0223\u0224\5J$\2"+
		"\u0224\u0225\5\u00ba\\\2\u0225\u0226\5\u00a2P\2\u0226\u0227\7<\2\2\u0227"+
		"e\3\2\2\2\u0228\u0229\5\u0098K\2\u0229\u022a\5\u00b8[\2\u022a\u022b\5"+
		"\u00be^\2\u022b\u022c\5\u00b2X\2\u022c\u022d\5\u009cM\2\u022d\u022e\5"+
		"\u00b6Z\2\u022e\u022f\5\u00b6Z\2\u022f\u0230\5\u00b0W\2\u0230\u0231\5"+
		"\u00c0_\2\u0231g\3\2\2\2\u0232\u0233\5\u00b8[\2\u0233\u0234\5\u00b4Y\2"+
		"\u0234\u0235\5\u00aaT\2\u0235\u0236\7<\2\2\u0236i\3\2\2\2\u0237\u0238"+
		"\5\u00b8[\2\u0238\u0239\5\u00b2X\2\u0239\u023a\5J$\2\u023a\u023b\5\u00b6"+
		"Z\2\u023b\u023c\5\u00b4Y\2\u023c\u023d\5\u00aaT\2\u023d\u023e\7<\2\2\u023e"+
		"k\3\2\2\2\u023f\u0244\5\u008cE\2\u0240\u0244\5\u008eF\2\u0241\u0244\5"+
		"\u0094I\2\u0242\u0244\t\6\2\2\u0243\u023f\3\2\2\2\u0243\u0240\3\2\2\2"+
		"\u0243\u0241\3\2\2\2\u0243\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245\u0243"+
		"\3\2\2\2\u0245\u0246\3\2\2\2\u0246m\3\2\2\2\u0247\u0248\7@\2\2\u0248\u0249"+
		"\3\2\2\2\u0249\u024a\b\66\5\2\u024ao\3\2\2\2\u024b\u024c\t\5\2\2\u024c"+
		"\u024d\3\2\2\2\u024d\u024e\b\67\4\2\u024eq\3\2\2\2\u024f\u0250\7>\2\2"+
		"\u0250\u0251\3\2\2\2\u0251\u0252\b8\6\2\u0252s\3\2\2\2\u0253\u0259\5\u008c"+
		"E\2\u0254\u0258\5\u008cE\2\u0255\u0258\5\u008eF\2\u0256\u0258\7a\2\2\u0257"+
		"\u0254\3\2\2\2\u0257\u0255\3\2\2\2\u0257\u0256\3\2\2\2\u0258\u025b\3\2"+
		"\2\2\u0259\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025au\3\2\2\2\u025b\u0259"+
		"\3\2\2\2\u025c\u0260\5\u008cE\2\u025d\u0260\5\u008eF\2\u025e\u0260\7a"+
		"\2\2\u025f\u025c\3\2\2\2\u025f\u025d\3\2\2\2\u025f\u025e\3\2\2\2\u0260"+
		"\u0263\3\2\2\2\u0261\u025f\3\2\2\2\u0261\u0262\3\2\2\2\u0262\u0264\3\2"+
		"\2\2\u0263\u0261\3\2\2\2\u0264\u0265\7<\2\2\u0265w\3\2\2\2\u0266\u0267"+
		"\t\5\2\2\u0267\u0268\3\2\2\2\u0268\u0269\b;\4\2\u0269y\3\2\2\2\u026a\u026b"+
		"\7>\2\2\u026b{\3\2\2\2\u026c\u026d\5\u00ba\\\2\u026d\u026e\5\u00b0W\2"+
		"\u026e}\3\2\2\2\u026f\u0270\5\u0096J\2\u0270\u0271\5\u00c4a\2\u0271\177"+
		"\3\2\2\2\u0272\u0273\7-\2\2\u0273\u0081\3\2\2\2\u0274\u0276\5\u008eF\2"+
		"\u0275\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277\u0275\3\2\2\2\u0277\u0278"+
		"\3\2\2\2\u0278\u0083\3\2\2\2\u0279\u027f\5\u008cE\2\u027a\u027e\5\u008c"+
		"E\2\u027b\u027e\5\u008eF\2\u027c\u027e\7a\2\2\u027d\u027a\3\2\2\2\u027d"+
		"\u027b\3\2\2\2\u027d\u027c\3\2\2\2\u027e\u0281\3\2\2\2\u027f\u027d\3\2"+
		"\2\2\u027f\u0280\3\2\2\2\u0280\u0085\3\2\2\2\u0281\u027f\3\2\2\2\u0282"+
		"\u0287\7$\2\2\u0283\u0288\5\u008cE\2\u0284\u0288\5\u008eF\2\u0285\u0288"+
		"\5\u0094I\2\u0286\u0288\7\"\2\2\u0287\u0283\3\2\2\2\u0287\u0284\3\2\2"+
		"\2\u0287\u0285\3\2\2\2\u0287\u0286\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u0287"+
		"\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u028c\7$\2\2\u028c"+
		"\u0087\3\2\2\2\u028d\u028e\7@\2\2\u028e\u028f\3\2\2\2\u028f\u0290\bC\5"+
		"\2\u0290\u0089\3\2\2\2\u0291\u0292\t\5\2\2\u0292\u0293\3\2\2\2\u0293\u0294"+
		"\bD\4\2\u0294\u008b\3\2\2\2\u0295\u0297\t\7\2\2\u0296\u0295\3\2\2\2\u0297"+
		"\u008d\3\2\2\2\u0298\u0299\t\b\2\2\u0299\u008f\3\2\2\2\u029a\u029b\7z"+
		"\2\2\u029b\u02a0\7u\2\2\u029c\u029d\7z\2\2\u029d\u029e\7u\2\2\u029e\u02a0"+
		"\7f\2\2\u029f\u029a\3\2\2\2\u029f\u029c\3\2\2\2\u02a0\u0091\3\2\2\2\u02a1"+
		"\u02a2\7u\2\2\u02a2\u02a3\7v\2\2\u02a3\u02a4\7t\2\2\u02a4\u02a5\7k\2\2"+
		"\u02a5\u02a6\7p\2\2\u02a6\u03fa\7i\2\2\u02a7\u02a8\7d\2\2\u02a8\u02a9"+
		"\7q\2\2\u02a9\u02aa\7q\2\2\u02aa\u02ab\7n\2\2\u02ab\u02ac\7g\2\2\u02ac"+
		"\u02ad\7c\2\2\u02ad\u03fa\7p\2\2\u02ae\u02af\7f\2\2\u02af\u02b0\7g\2\2"+
		"\u02b0\u02b1\7e\2\2\u02b1\u02b2\7k\2\2\u02b2\u02b3\7o\2\2\u02b3\u02b4"+
		"\7c\2\2\u02b4\u03fa\7n\2\2\u02b5\u02b6\7k\2\2\u02b6\u02b7\7p\2\2\u02b7"+
		"\u02b8\7v\2\2\u02b8\u02b9\7g\2\2\u02b9\u02ba\7i\2\2\u02ba\u02bb\7g\2\2"+
		"\u02bb\u03fa\7t\2\2\u02bc\u02bd\7f\2\2\u02bd\u02be\7q\2\2\u02be\u02bf"+
		"\7w\2\2\u02bf\u02c0\7d\2\2\u02c0\u02c1\7n\2\2\u02c1\u03fa\7g\2\2\u02c2"+
		"\u02c3\7h\2\2\u02c3\u02c4\7n\2\2\u02c4\u02c5\7q\2\2\u02c5\u02c6\7c\2\2"+
		"\u02c6\u03fa\7v\2\2\u02c7\u02c8\7f\2\2\u02c8\u02c9\7c\2\2\u02c9\u02ca"+
		"\7v\2\2\u02ca\u03fa\7g\2\2\u02cb\u02cc\7v\2\2\u02cc\u02cd\7k\2\2\u02cd"+
		"\u02ce\7o\2\2\u02ce\u03fa\7g\2\2\u02cf\u02d0\7f\2\2\u02d0\u02d1\7c\2\2"+
		"\u02d1\u02d2\7v\2\2\u02d2\u02d3\7g\2\2\u02d3\u02d4\7V\2\2\u02d4\u02d5"+
		"\7k\2\2\u02d5\u02d6\7o\2\2\u02d6\u03fa\7g\2\2\u02d7\u02d8\7f\2\2\u02d8"+
		"\u02d9\7c\2\2\u02d9\u02da\7v\2\2\u02da\u02db\7g\2\2\u02db\u02dc\7V\2\2"+
		"\u02dc\u02dd\7k\2\2\u02dd\u02de\7o\2\2\u02de\u02df\7g\2\2\u02df\u02e0"+
		"\7U\2\2\u02e0\u02e1\7v\2\2\u02e1\u02e2\7c\2\2\u02e2\u02e3\7o\2\2\u02e3"+
		"\u03fa\7r\2\2\u02e4\u02e5\7i\2\2\u02e5\u02e6\7[\2\2\u02e6\u02e7\7g\2\2"+
		"\u02e7\u02e8\7c\2\2\u02e8\u03fa\7t\2\2\u02e9\u02ea\7i\2\2\u02ea\u02eb"+
		"\7O\2\2\u02eb\u02ec\7q\2\2\u02ec\u02ed\7p\2\2\u02ed\u02ee\7v\2\2\u02ee"+
		"\u03fa\7j\2\2\u02ef\u02f0\7i\2\2\u02f0\u02f1\7F\2\2\u02f1\u02f2\7c\2\2"+
		"\u02f2\u03fa\7{\2\2\u02f3\u02f4\7i\2\2\u02f4\u02f5\7[\2\2\u02f5\u02f6"+
		"\7g\2\2\u02f6\u02f7\7c\2\2\u02f7\u02f8\7t\2\2\u02f8\u02f9\7O\2\2\u02f9"+
		"\u02fa\7q\2\2\u02fa\u02fb\7p\2\2\u02fb\u02fc\7v\2\2\u02fc\u03fa\7j\2\2"+
		"\u02fd\u02fe\7i\2\2\u02fe\u02ff\7O\2\2\u02ff\u0300\7q\2\2\u0300\u0301"+
		"\7p\2\2\u0301\u0302\7v\2\2\u0302\u0303\7j\2\2\u0303\u0304\7F\2\2\u0304"+
		"\u0305\7c\2\2\u0305\u03fa\7{\2\2\u0306\u0307\7f\2\2\u0307\u0308\7w\2\2"+
		"\u0308\u0309\7t\2\2\u0309\u030a\7c\2\2\u030a\u030b\7v\2\2\u030b\u030c"+
		"\7k\2\2\u030c\u030d\7q\2\2\u030d\u03fa\7p\2\2\u030e\u030f\7{\2\2\u030f"+
		"\u0310\7g\2\2\u0310\u0311\7c\2\2\u0311\u0312\7t\2\2\u0312\u0313\7O\2\2"+
		"\u0313\u0314\7q\2\2\u0314\u0315\7p\2\2\u0315\u0316\7v\2\2\u0316\u0317"+
		"\7j\2\2\u0317\u0318\7F\2\2\u0318\u0319\7w\2\2\u0319\u031a\7t\2\2\u031a"+
		"\u031b\7c\2\2\u031b\u031c\7v\2\2\u031c\u031d\7k\2\2\u031d\u031e\7q\2\2"+
		"\u031e\u03fa\7p\2\2\u031f\u0320\7f\2\2\u0320\u0321\7c\2\2\u0321\u0322"+
		"\7{\2\2\u0322\u0323\7V\2\2\u0323\u0324\7k\2\2\u0324\u0325\7o\2\2\u0325"+
		"\u0326\7g\2\2\u0326\u0327\7F\2\2\u0327\u0328\7w\2\2\u0328\u0329\7t\2\2"+
		"\u0329\u032a\7c\2\2\u032a\u032b\7v\2\2\u032b\u032c\7k\2\2\u032c\u032d"+
		"\7q\2\2\u032d\u03fa\7p\2\2\u032e\u032f\7d\2\2\u032f\u0330\7{\2\2\u0330"+
		"\u0331\7v\2\2\u0331\u03fa\7g\2\2\u0332\u0333\7u\2\2\u0333\u0334\7j\2\2"+
		"\u0334\u0335\7q\2\2\u0335\u0336\7t\2\2\u0336\u03fa\7v\2\2\u0337\u0338"+
		"\7k\2\2\u0338\u0339\7p\2\2\u0339\u03fa\7v\2\2\u033a\u033b\7n\2\2\u033b"+
		"\u033c\7q\2\2\u033c\u033d\7p\2\2\u033d\u03fa\7i\2\2\u033e\u033f\7w\2\2"+
		"\u033f\u0340\7p\2\2\u0340\u0341\7u\2\2\u0341\u0342\7k\2\2\u0342\u0343"+
		"\7i\2\2\u0343\u0344\7p\2\2\u0344\u0345\7g\2\2\u0345\u0346\7f\2\2\u0346"+
		"\u0347\7D\2\2\u0347\u0348\7{\2\2\u0348\u0349\7v\2\2\u0349\u03fa\7g\2\2"+
		"\u034a\u034b\7w\2\2\u034b\u034c\7p\2\2\u034c\u034d\7u\2\2\u034d\u034e"+
		"\7k\2\2\u034e\u034f\7i\2\2\u034f\u0350\7p\2\2\u0350\u0351\7g\2\2\u0351"+
		"\u0352\7f\2\2\u0352\u0353\7U\2\2\u0353\u0354\7j\2\2\u0354\u0355\7q\2\2"+
		"\u0355\u0356\7t\2\2\u0356\u03fa\7v\2\2\u0357\u0358\7w\2\2\u0358\u0359"+
		"\7p\2\2\u0359\u035a\7u\2\2\u035a\u035b\7k\2\2\u035b\u035c\7i\2\2\u035c"+
		"\u035d\7p\2\2\u035d\u035e\7g\2\2\u035e\u035f\7f\2\2\u035f\u0360\7K\2\2"+
		"\u0360\u0361\7p\2\2\u0361\u03fa\7v\2\2\u0362\u0363\7w\2\2\u0363\u0364"+
		"\7p\2\2\u0364\u0365\7u\2\2\u0365\u0366\7k\2\2\u0366\u0367\7i\2\2\u0367"+
		"\u0368\7p\2\2\u0368\u0369\7g\2\2\u0369\u036a\7f\2\2\u036a\u036b\7N\2\2"+
		"\u036b\u036c\7q\2\2\u036c\u036d\7p\2\2\u036d\u03fa\7i\2\2\u036e\u036f"+
		"\7r\2\2\u036f\u0370\7q\2\2\u0370\u0371\7u\2\2\u0371\u0372\7k\2\2\u0372"+
		"\u0373\7v\2\2\u0373\u0374\7k\2\2\u0374\u0375\7x\2\2\u0375\u0376\7g\2\2"+
		"\u0376\u0377\7K\2\2\u0377\u0378\7p\2\2\u0378\u0379\7v\2\2\u0379\u037a"+
		"\7g\2\2\u037a\u037b\7i\2\2\u037b\u037c\7g\2\2\u037c\u03fa\7t\2\2\u037d"+
		"\u037e\7p\2\2\u037e\u037f\7q\2\2\u037f\u0380\7p\2\2\u0380\u0381\7P\2\2"+
		"\u0381\u0382\7g\2\2\u0382\u0383\7i\2\2\u0383\u0384\7c\2\2\u0384\u0385"+
		"\7v\2\2\u0385\u0386\7k\2\2\u0386\u0387\7x\2\2\u0387\u0388\7g\2\2\u0388"+
		"\u0389\7K\2\2\u0389\u038a\7p\2\2\u038a\u038b\7v\2\2\u038b\u038c\7g\2\2"+
		"\u038c\u038d\7i\2\2\u038d\u038e\7g\2\2\u038e\u03fa\7t\2\2\u038f\u0390"+
		"\7p\2\2\u0390\u0391\7g\2\2\u0391\u0392\7i\2\2\u0392\u0393\7c\2\2\u0393"+
		"\u0394\7v\2\2\u0394\u0395\7k\2\2\u0395\u0396\7x\2\2\u0396\u0397\7g\2\2"+
		"\u0397\u0398\7K\2\2\u0398\u0399\7p\2\2\u0399\u039a\7v\2\2\u039a\u039b"+
		"\7g\2\2\u039b\u039c\7i\2\2\u039c\u039d\7g\2\2\u039d\u03fa\7t\2\2\u039e"+
		"\u039f\7p\2\2\u039f\u03a0\7q\2\2\u03a0\u03a1\7p\2\2\u03a1\u03a2\7R\2\2"+
		"\u03a2\u03a3\7q\2\2\u03a3\u03a4\7u\2\2\u03a4\u03a5\7k\2\2\u03a5\u03a6"+
		"\7v\2\2\u03a6\u03a7\7k\2\2\u03a7\u03a8\7x\2\2\u03a8\u03a9\7g\2\2\u03a9"+
		"\u03aa\7K\2\2\u03aa\u03ab\7p\2\2\u03ab\u03ac\7v\2\2\u03ac\u03ad\7g\2\2"+
		"\u03ad\u03ae\7i\2\2\u03ae\u03af\7g\2\2\u03af\u03fa\7t\2\2\u03b0\u03b1"+
		"\7j\2\2\u03b1\u03b2\7g\2\2\u03b2\u03b3\7z\2\2\u03b3\u03b4\7D\2\2\u03b4"+
		"\u03b5\7k\2\2\u03b5\u03b6\7p\2\2\u03b6\u03b7\7c\2\2\u03b7\u03b8\7t\2\2"+
		"\u03b8\u03fa\7{\2\2\u03b9\u03ba\7d\2\2\u03ba\u03bb\7c\2\2\u03bb\u03bc"+
		"\7u\2\2\u03bc\u03bd\7g\2\2\u03bd\u03be\78\2\2\u03be\u03bf\7\66\2\2\u03bf"+
		"\u03c0\7D\2\2\u03c0\u03c1\7k\2\2\u03c1\u03c2\7p\2\2\u03c2\u03c3\7c\2\2"+
		"\u03c3\u03c4\7t\2\2\u03c4\u03fa\7{\2\2\u03c5\u03c6\7c\2\2\u03c6\u03c7"+
		"\7p\2\2\u03c7\u03c8\7{\2\2\u03c8\u03c9\7W\2\2\u03c9\u03ca\7T\2\2\u03ca"+
		"\u03fa\7K\2\2\u03cb\u03cc\7n\2\2\u03cc\u03cd\7c\2\2\u03cd\u03ce\7p\2\2"+
		"\u03ce\u03cf\7i\2\2\u03cf\u03d0\7w\2\2\u03d0\u03d1\7c\2\2\u03d1\u03d2"+
		"\7i\2\2\u03d2\u03fa\7g\2\2\u03d3\u03d4\7p\2\2\u03d4\u03d5\7q\2\2\u03d5"+
		"\u03d6\7t\2\2\u03d6\u03d7\7o\2\2\u03d7\u03d8\7c\2\2\u03d8\u03d9\7n\2\2"+
		"\u03d9\u03da\7k\2\2\u03da\u03db\7|\2\2\u03db\u03dc\7g\2\2\u03dc\u03dd"+
		"\7f\2\2\u03dd\u03de\7U\2\2\u03de\u03df\7v\2\2\u03df\u03e0\7t\2\2\u03e0"+
		"\u03e1\7k\2\2\u03e1\u03e2\7p\2\2\u03e2\u03fa\7i\2\2\u03e3\u03e4\7v\2\2"+
		"\u03e4\u03e5\7q\2\2\u03e5\u03e6\7m\2\2\u03e6\u03e7\7g\2\2\u03e7\u03fa"+
		"\7p\2\2\u03e8\u03e9\7P\2\2\u03e9\u03ea\7O\2\2\u03ea\u03eb\7V\2\2\u03eb"+
		"\u03ec\7Q\2\2\u03ec\u03ed\7M\2\2\u03ed\u03ee\7G\2\2\u03ee\u03fa\7P\2\2"+
		"\u03ef\u03f0\7P\2\2\u03f0\u03f1\7c\2\2\u03f1\u03f2\7o\2\2\u03f2\u03fa"+
		"\7g\2\2\u03f3\u03f4\7P\2\2\u03f4\u03f5\7E\2\2\u03f5\u03f6\7P\2\2\u03f6"+
		"\u03f7\7c\2\2\u03f7\u03f8\7o\2\2\u03f8\u03fa\7g\2\2\u03f9\u02a1\3\2\2"+
		"\2\u03f9\u02a7\3\2\2\2\u03f9\u02ae\3\2\2\2\u03f9\u02b5\3\2\2\2\u03f9\u02bc"+
		"\3\2\2\2\u03f9\u02c2\3\2\2\2\u03f9\u02c7\3\2\2\2\u03f9\u02cb\3\2\2\2\u03f9"+
		"\u02cf\3\2\2\2\u03f9\u02d7\3\2\2\2\u03f9\u02e4\3\2\2\2\u03f9\u02e9\3\2"+
		"\2\2\u03f9\u02ef\3\2\2\2\u03f9\u02f3\3\2\2\2\u03f9\u02fd\3\2\2\2\u03f9"+
		"\u0306\3\2\2\2\u03f9\u030e\3\2\2\2\u03f9\u031f\3\2\2\2\u03f9\u032e\3\2"+
		"\2\2\u03f9\u0332\3\2\2\2\u03f9\u0337\3\2\2\2\u03f9\u033a\3\2\2\2\u03f9"+
		"\u033e\3\2\2\2\u03f9\u034a\3\2\2\2\u03f9\u0357\3\2\2\2\u03f9\u0362\3\2"+
		"\2\2\u03f9\u036e\3\2\2\2\u03f9\u037d\3\2\2\2\u03f9\u038f\3\2\2\2\u03f9"+
		"\u039e\3\2\2\2\u03f9\u03b0\3\2\2\2\u03f9\u03b9\3\2\2\2\u03f9\u03c5\3\2"+
		"\2\2\u03f9\u03cb\3\2\2\2\u03f9\u03d3\3\2\2\2\u03f9\u03e3\3\2\2\2\u03f9"+
		"\u03e8\3\2\2\2\u03f9\u03ef\3\2\2\2\u03f9\u03f3\3\2\2\2\u03fa\u0093\3\2"+
		"\2\2\u03fb\u0401\t\t\2\2\u03fc\u03fd\7^\2\2\u03fd\u0401\7>\2\2\u03fe\u03ff"+
		"\7^\2\2\u03ff\u0401\7@\2\2\u0400\u03fb\3\2\2\2\u0400\u03fc\3\2\2\2\u0400"+
		"\u03fe\3\2\2\2\u0401\u0095\3\2\2\2\u0402\u0403\t\n\2\2\u0403\u0097\3\2"+
		"\2\2\u0404\u0405\t\13\2\2\u0405\u0099\3\2\2\2\u0406\u0407\t\f\2\2\u0407"+
		"\u009b\3\2\2\2\u0408\u0409\t\r\2\2\u0409\u009d\3\2\2\2\u040a\u040b\t\16"+
		"\2\2\u040b\u009f\3\2\2\2\u040c\u040d\t\17\2\2\u040d\u00a1\3\2\2\2\u040e"+
		"\u040f\t\20\2\2\u040f\u00a3\3\2\2\2\u0410\u0411\t\21\2\2\u0411\u00a5\3"+
		"\2\2\2\u0412\u0413\t\22\2\2\u0413\u00a7\3\2\2\2\u0414\u0415\t\23\2\2\u0415"+
		"\u00a9\3\2\2\2\u0416\u0417\t\24\2\2\u0417\u00ab\3\2\2\2\u0418\u0419\t"+
		"\25\2\2\u0419\u00ad\3\2\2\2\u041a\u041b\t\26\2\2\u041b\u00af\3\2\2\2\u041c"+
		"\u041d\t\27\2\2\u041d\u00b1\3\2\2\2\u041e\u041f\t\30\2\2\u041f\u00b3\3"+
		"\2\2\2\u0420\u0421\t\31\2\2\u0421\u00b5\3\2\2\2\u0422\u0423\t\32\2\2\u0423"+
		"\u00b7\3\2\2\2\u0424\u0425\t\33\2\2\u0425\u00b9\3\2\2\2\u0426\u0427\t"+
		"\34\2\2\u0427\u00bb\3\2\2\2\u0428\u0429\t\35\2\2\u0429\u00bd\3\2\2\2\u042a"+
		"\u042b\t\36\2\2\u042b\u00bf\3\2\2\2\u042c\u042d\t\37\2\2\u042d\u00c1\3"+
		"\2\2\2\u042e\u042f\t \2\2\u042f\u00c3\3\2\2\2\u0430\u0431\t!\2\2\u0431"+
		"\u00c5\3\2\2\2\u0432\u0433\t\"\2\2\u0433\u00c7\3\2\2\2)\2\3\4\5\u018e"+
		"\u019c\u019e\u01a8\u01aa\u01b4\u01b6\u01c6\u01cc\u01d1\u01d3\u01d7\u01de"+
		"\u01f4\u01fd\u01ff\u020a\u020c\u0212\u0214\u0243\u0245\u0257\u0259\u025f"+
		"\u0261\u0277\u027d\u027f\u0287\u0289\u0296\u029f\u03f9\u0400\7\4\4\2\4"+
		"\5\2\b\2\2\4\2\2\4\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}