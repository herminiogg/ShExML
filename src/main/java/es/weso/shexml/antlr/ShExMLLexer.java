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
		PREFIX=1, SOURCE=2, QUERY=3, ITERATOR=4, FIELD=5, AUTOINCREMENT=6, EXPRESSION=7, 
		UNION=8, JOIN=9, MATCHER=10, AS=11, MATCHING=12, LESS_SYMBOL=13, GREATER_SYMBOL=14, 
		BRACKET_LEFT=15, DOUBLE_BRACKET_LEFT=16, BRACKET_RIGHT=17, DOUBLE_BRACKET_RIGHT=18, 
		PAREN_LEFT=19, PAREN_RIGHT=20, BRACE_LEFT=21, BRACE_RIGHT=22, SEMICOLON=23, 
		DOT=24, ADD=25, COMMA=26, QUOTE=27, AND=28, A=29, STRING_OR_VAR=30, URI_VAR=31, 
		STRINGOPERATOR=32, XMLSCHEMADATATYPE=33, SHAPELINK=34, LANGTAG=35, COMMENT=36, 
		WS=37, URL=38, JDBC_URL=39, JSONPATH=40, XMLPATH=41, CSVPERROW=42, SQL=43, 
		QUERY_PART=44, GREATER_SYMBOL_QUERY=45, WS_QUERY=46, LESS_SYMBOL_QUERY=47, 
		STRING_OR_VAR_QUERY=48, URI_VAR_QUERY=49, WS_DECLARATION=50, LESS_SYMBOL_AUTOINCREMENT=51, 
		TO=52, BY=53, ADD_AUTOINCREMENT=54, DIGITS=55, STRING_OR_VAR_AUTOINCREMENT=56, 
		STRINGOPERATOR_AUTOINCREMENT=57, GREATER_SYMBOL_AUTOINCREMENT=58, WS_AUTOINCREMENT=59;
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
			"PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "AUTOINCREMENT", "EXPRESSION", 
			"UNION", "JOIN", "MATCHER", "AS", "MATCHING", "LESS_SYMBOL", "GREATER_SYMBOL", 
			"BRACKET_LEFT", "DOUBLE_BRACKET_LEFT", "BRACKET_RIGHT", "DOUBLE_BRACKET_RIGHT", 
			"PAREN_LEFT", "PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", 
			"DOT", "ADD", "COMMA", "QUOTE", "AND", "A", "STRING_OR_VAR", "URI_VAR", 
			"STRINGOPERATOR", "XMLSCHEMADATATYPE", "SHAPELINK", "LANGTAG", "COMMENT", 
			"WS", "URL", "JDBC_URL", "JSONPATH", "XMLPATH", "CSVPERROW", "SQL", "QUERY_PART", 
			"GREATER_SYMBOL_QUERY", "WS_QUERY", "LESS_SYMBOL_QUERY", "STRING_OR_VAR_QUERY", 
			"URI_VAR_QUERY", "WS_DECLARATION", "LESS_SYMBOL_AUTOINCREMENT", "TO", 
			"BY", "ADD_AUTOINCREMENT", "DIGITS", "STRING_OR_VAR_AUTOINCREMENT", "STRINGOPERATOR_AUTOINCREMENT", 
			"GREATER_SYMBOL_AUTOINCREMENT", "WS_AUTOINCREMENT", "LETTER", "DIGIT", 
			"XMLSCHEMADATATYPEPREFIX", "ALLOWEDTYPES", "ALLOWED_CHARACTERS", "B", 
			"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
			"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "'['", "'[['", "']'", "']]'", "'('", "')'", "'{'", 
			"'}'", "';'", "'.'", null, "','", "'\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "AUTOINCREMENT", 
			"EXPRESSION", "UNION", "JOIN", "MATCHER", "AS", "MATCHING", "LESS_SYMBOL", 
			"GREATER_SYMBOL", "BRACKET_LEFT", "DOUBLE_BRACKET_LEFT", "BRACKET_RIGHT", 
			"DOUBLE_BRACKET_RIGHT", "PAREN_LEFT", "PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", 
			"SEMICOLON", "DOT", "ADD", "COMMA", "QUOTE", "AND", "A", "STRING_OR_VAR", 
			"URI_VAR", "STRINGOPERATOR", "XMLSCHEMADATATYPE", "SHAPELINK", "LANGTAG", 
			"COMMENT", "WS", "URL", "JDBC_URL", "JSONPATH", "XMLPATH", "CSVPERROW", 
			"SQL", "QUERY_PART", "GREATER_SYMBOL_QUERY", "WS_QUERY", "LESS_SYMBOL_QUERY", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u03d7\b\1\b\1\b"+
		"\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t"+
		"\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30"+
		"\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37"+
		"\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)"+
		"\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63"+
		"\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;"+
		"\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G"+
		"\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR"+
		"\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\35\3\35\5\35\u0142\n\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\6\37\u014e\n\37\r\37\16\37\u014f\3 \3 \3 \3 \3 \3 \3 \3 \7 \u015a"+
		"\n \f \16 \u015d\13 \3 \3 \3!\3!\3!\3!\3!\6!\u0166\n!\r!\16!\u0167\3!"+
		"\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0178\n#\3$\3$\6$\u017c"+
		"\n$\r$\16$\u017d\3$\3$\3$\6$\u0183\n$\r$\16$\u0184\7$\u0187\n$\f$\16$"+
		"\u018a\13$\3%\3%\7%\u018e\n%\f%\16%\u0191\13%\3%\3%\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u01a6\n\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\7\'\u01af\n\'\f\'\16\'\u01b2\13\'\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\6(\u01bc\n(\r(\16(\u01bd\3(\3(\3(\3(\7(\u01c4\n(\f(\16(\u01c7"+
		"\13(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\6-\u01ec\n-\r-\16-\u01ed\3.\3"+
		".\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0200"+
		"\n\61\f\61\16\61\u0203\13\61\3\62\3\62\3\62\7\62\u0208\n\62\f\62\16\62"+
		"\u020b\13\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3"+
		"\66\3\66\3\66\3\67\3\67\38\68\u021e\n8\r8\168\u021f\39\39\39\39\79\u0226"+
		"\n9\f9\169\u0229\139\3:\3:\3:\3:\3:\6:\u0230\n:\r:\16:\u0231\3:\3:\3;"+
		"\3;\3;\3;\3<\3<\3<\3<\3=\5=\u023f\n=\3>\3>\3?\3?\3?\3?\3?\5?\u0248\n?"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@"+
		"\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@"+
		"\u03a2\n@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J"+
		"\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V"+
		"\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\2\2[\6\3\b\4\n\5\f\6\16\7\20\b\22\t\24\n\26"+
		"\13\30\f\32\r\34\16\36\17 \20\"\21$\22&\23(\24*\25,\26.\27\60\30\62\31"+
		"\64\32\66\338\34:\35<\36>\37@ B!D\"F#H$J%L&N\'P(R)T*V+X,Z-\\.^/`\60b\61"+
		"d\62f\63h\64j\65l\66n\67p8r9t:v;x<z=|\2~\2\u0080\2\u0082\2\u0084\2\u0086"+
		"\2\u0088\2\u008a\2\u008c\2\u008e\2\u0090\2\u0092\2\u0094\2\u0096\2\u0098"+
		"\2\u009a\2\u009c\2\u009e\2\u00a0\2\u00a2\2\u00a4\2\u00a6\2\u00a8\2\u00aa"+
		"\2\u00ac\2\u00ae\2\u00b0\2\u00b2\2\u00b4\2\u00b6\2\6\2\3\4\5\"\4\2CCc"+
		"c\4\2//aa\4\2\f\f\17\17\5\2\13\f\17\17\"\"\7\2C\\c|\u00c2\u00d8\u00da"+
		"\u00f8\u00fa\u0101\3\2\62;\b\2%,.\61<=??AB]a\4\2DDdd\4\2EEee\4\2FFff\4"+
		"\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOo"+
		"o\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2"+
		"XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u040c\2\6\3\2\2\2\2\b\3\2\2\2"+
		"\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3"+
		"\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2"+
		"\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2"+
		"\2,\3\2\2\2\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\2\64\3\2\2\2\2\66\3\2"+
		"\2\2\28\3\2\2\2\2:\3\2\2\2\2<\3\2\2\2\2>\3\2\2\2\2@\3\2\2\2\2B\3\2\2\2"+
		"\2D\3\2\2\2\2F\3\2\2\2\2H\3\2\2\2\2J\3\2\2\2\2L\3\2\2\2\2N\3\2\2\2\3P"+
		"\3\2\2\2\3R\3\2\2\2\3T\3\2\2\2\3V\3\2\2\2\3X\3\2\2\2\3Z\3\2\2\2\3\\\3"+
		"\2\2\2\3^\3\2\2\2\3`\3\2\2\2\4b\3\2\2\2\4d\3\2\2\2\4f\3\2\2\2\4h\3\2\2"+
		"\2\5j\3\2\2\2\5l\3\2\2\2\5n\3\2\2\2\5p\3\2\2\2\5r\3\2\2\2\5t\3\2\2\2\5"+
		"v\3\2\2\2\5x\3\2\2\2\5z\3\2\2\2\6\u00b8\3\2\2\2\b\u00c1\3\2\2\2\n\u00ca"+
		"\3\2\2\2\f\u00d0\3\2\2\2\16\u00db\3\2\2\2\20\u00e3\3\2\2\2\22\u00f3\3"+
		"\2\2\2\24\u00fe\3\2\2\2\26\u0104\3\2\2\2\30\u0109\3\2\2\2\32\u0111\3\2"+
		"\2\2\34\u0114\3\2\2\2\36\u011d\3\2\2\2 \u011f\3\2\2\2\"\u0121\3\2\2\2"+
		"$\u0123\3\2\2\2&\u0126\3\2\2\2(\u0128\3\2\2\2*\u012b\3\2\2\2,\u012d\3"+
		"\2\2\2.\u012f\3\2\2\2\60\u0131\3\2\2\2\62\u0133\3\2\2\2\64\u0135\3\2\2"+
		"\2\66\u0137\3\2\2\28\u0139\3\2\2\2:\u013b\3\2\2\2<\u0141\3\2\2\2>\u0143"+
		"\3\2\2\2@\u014d\3\2\2\2B\u015b\3\2\2\2D\u0160\3\2\2\2F\u016b\3\2\2\2H"+
		"\u016f\3\2\2\2J\u0179\3\2\2\2L\u018b\3\2\2\2N\u0194\3\2\2\2P\u01a5\3\2"+
		"\2\2R\u01b3\3\2\2\2T\u01c8\3\2\2\2V\u01d2\3\2\2\2X\u01d9\3\2\2\2Z\u01e3"+
		"\3\2\2\2\\\u01eb\3\2\2\2^\u01ef\3\2\2\2`\u01f3\3\2\2\2b\u01f7\3\2\2\2"+
		"d\u01fb\3\2\2\2f\u0209\3\2\2\2h\u020e\3\2\2\2j\u0212\3\2\2\2l\u0214\3"+
		"\2\2\2n\u0217\3\2\2\2p\u021a\3\2\2\2r\u021d\3\2\2\2t\u0221\3\2\2\2v\u022a"+
		"\3\2\2\2x\u0235\3\2\2\2z\u0239\3\2\2\2|\u023e\3\2\2\2~\u0240\3\2\2\2\u0080"+
		"\u0247\3\2\2\2\u0082\u03a1\3\2\2\2\u0084\u03a3\3\2\2\2\u0086\u03a5\3\2"+
		"\2\2\u0088\u03a7\3\2\2\2\u008a\u03a9\3\2\2\2\u008c\u03ab\3\2\2\2\u008e"+
		"\u03ad\3\2\2\2\u0090\u03af\3\2\2\2\u0092\u03b1\3\2\2\2\u0094\u03b3\3\2"+
		"\2\2\u0096\u03b5\3\2\2\2\u0098\u03b7\3\2\2\2\u009a\u03b9\3\2\2\2\u009c"+
		"\u03bb\3\2\2\2\u009e\u03bd\3\2\2\2\u00a0\u03bf\3\2\2\2\u00a2\u03c1\3\2"+
		"\2\2\u00a4\u03c3\3\2\2\2\u00a6\u03c5\3\2\2\2\u00a8\u03c7\3\2\2\2\u00aa"+
		"\u03c9\3\2\2\2\u00ac\u03cb\3\2\2\2\u00ae\u03cd\3\2\2\2\u00b0\u03cf\3\2"+
		"\2\2\u00b2\u03d1\3\2\2\2\u00b4\u03d3\3\2\2\2\u00b6\u03d5\3\2\2\2\u00b8"+
		"\u00b9\5\u00a2P\2\u00b9\u00ba\5\u00a6R\2\u00ba\u00bb\5\u008cE\2\u00bb"+
		"\u00bc\5\u008eF\2\u00bc\u00bd\5\u0094I\2\u00bd\u00be\5\u00b2X\2\u00be"+
		"\u00bf\3\2\2\2\u00bf\u00c0\b\2\2\2\u00c0\7\3\2\2\2\u00c1\u00c2\5\u00a8"+
		"S\2\u00c2\u00c3\5\u00a0O\2\u00c3\u00c4\5\u00acU\2\u00c4\u00c5\5\u00a6"+
		"R\2\u00c5\u00c6\5\u0088C\2\u00c6\u00c7\5\u008cE\2\u00c7\u00c8\3\2\2\2"+
		"\u00c8\u00c9\b\3\2\2\u00c9\t\3\2\2\2\u00ca\u00cb\5\u00a4Q\2\u00cb\u00cc"+
		"\5\u00acU\2\u00cc\u00cd\5\u008cE\2\u00cd\u00ce\5\u00a6R\2\u00ce\u00cf"+
		"\5\u00b4Y\2\u00cf\13\3\2\2\2\u00d0\u00d1\5\u0094I\2\u00d1\u00d2\5\u00aa"+
		"T\2\u00d2\u00d3\5\u008cE\2\u00d3\u00d4\5\u00a6R\2\u00d4\u00d5\5>\36\2"+
		"\u00d5\u00d6\5\u00aaT\2\u00d6\u00d7\5\u00a0O\2\u00d7\u00d8\5\u00a6R\2"+
		"\u00d8\u00d9\3\2\2\2\u00d9\u00da\b\5\2\2\u00da\r\3\2\2\2\u00db\u00dc\5"+
		"\u008eF\2\u00dc\u00dd\5\u0094I\2\u00dd\u00de\5\u008cE\2\u00de\u00df\5"+
		"\u009aL\2\u00df\u00e0\5\u008aD\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\b\6\2"+
		"\2\u00e2\17\3\2\2\2\u00e3\u00e4\5>\36\2\u00e4\u00e5\5\u00acU\2\u00e5\u00e6"+
		"\5\u00aaT\2\u00e6\u00e7\5\u00a0O\2\u00e7\u00e8\5\u0094I\2\u00e8\u00e9"+
		"\5\u009eN\2\u00e9\u00ea\5\u0088C\2\u00ea\u00eb\5\u00a6R\2\u00eb\u00ec"+
		"\5\u008cE\2\u00ec\u00ed\5\u009cM\2\u00ed\u00ee\5\u008cE\2\u00ee\u00ef"+
		"\5\u009eN\2\u00ef\u00f0\5\u00aaT\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\b\7"+
		"\3\2\u00f2\21\3\2\2\2\u00f3\u00f4\5\u008cE\2\u00f4\u00f5\5\u00b2X\2\u00f5"+
		"\u00f6\5\u00a2P\2\u00f6\u00f7\5\u00a6R\2\u00f7\u00f8\5\u008cE\2\u00f8"+
		"\u00f9\5\u00a8S\2\u00f9\u00fa\5\u00a8S\2\u00fa\u00fb\5\u0094I\2\u00fb"+
		"\u00fc\5\u00a0O\2\u00fc\u00fd\5\u009eN\2\u00fd\23\3\2\2\2\u00fe\u00ff"+
		"\5\u00acU\2\u00ff\u0100\5\u009eN\2\u0100\u0101\5\u0094I\2\u0101\u0102"+
		"\5\u00a0O\2\u0102\u0103\5\u009eN\2\u0103\25\3\2\2\2\u0104\u0105\5\u0096"+
		"J\2\u0105\u0106\5\u00a0O\2\u0106\u0107\5\u0094I\2\u0107\u0108\5\u009e"+
		"N\2\u0108\27\3\2\2\2\u0109\u010a\5\u009cM\2\u010a\u010b\5>\36\2\u010b"+
		"\u010c\5\u00aaT\2\u010c\u010d\5\u0088C\2\u010d\u010e\5\u0092H\2\u010e"+
		"\u010f\5\u008cE\2\u010f\u0110\5\u00a6R\2\u0110\31\3\2\2\2\u0111\u0112"+
		"\5>\36\2\u0112\u0113\5\u00a8S\2\u0113\33\3\2\2\2\u0114\u0115\5\u009cM"+
		"\2\u0115\u0116\5>\36\2\u0116\u0117\5\u00aaT\2\u0117\u0118\5\u0088C\2\u0118"+
		"\u0119\5\u0092H\2\u0119\u011a\5\u0094I\2\u011a\u011b\5\u009eN\2\u011b"+
		"\u011c\5\u0090G\2\u011c\35\3\2\2\2\u011d\u011e\7>\2\2\u011e\37\3\2\2\2"+
		"\u011f\u0120\7@\2\2\u0120!\3\2\2\2\u0121\u0122\7]\2\2\u0122#\3\2\2\2\u0123"+
		"\u0124\7]\2\2\u0124\u0125\7]\2\2\u0125%\3\2\2\2\u0126\u0127\7_\2\2\u0127"+
		"\'\3\2\2\2\u0128\u0129\7_\2\2\u0129\u012a\7_\2\2\u012a)\3\2\2\2\u012b"+
		"\u012c\7*\2\2\u012c+\3\2\2\2\u012d\u012e\7+\2\2\u012e-\3\2\2\2\u012f\u0130"+
		"\7}\2\2\u0130/\3\2\2\2\u0131\u0132\7\177\2\2\u0132\61\3\2\2\2\u0133\u0134"+
		"\7=\2\2\u0134\63\3\2\2\2\u0135\u0136\7\60\2\2\u0136\65\3\2\2\2\u0137\u0138"+
		"\7-\2\2\u0138\67\3\2\2\2\u0139\u013a\7.\2\2\u013a9\3\2\2\2\u013b\u013c"+
		"\7$\2\2\u013c;\3\2\2\2\u013d\u0142\7(\2\2\u013e\u013f\7C\2\2\u013f\u0140"+
		"\7P\2\2\u0140\u0142\7F\2\2\u0141\u013d\3\2\2\2\u0141\u013e\3\2\2\2\u0142"+
		"=\3\2\2\2\u0143\u0144\t\2\2\2\u0144?\3\2\2\2\u0145\u014e\5|=\2\u0146\u014e"+
		"\5~>\2\u0147\u014e\t\3\2\2\u0148\u0149\7^\2\2\u0149\u014e\7\60\2\2\u014a"+
		"\u014b\7\'\2\2\u014b\u014c\7\64\2\2\u014c\u014e\7G\2\2\u014d\u0145\3\2"+
		"\2\2\u014d\u0146\3\2\2\2\u014d\u0147\3\2\2\2\u014d\u0148\3\2\2\2\u014d"+
		"\u014a\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2"+
		"\2\2\u0150A\3\2\2\2\u0151\u015a\5|=\2\u0152\u015a\5~>\2\u0153\u015a\7"+
		"a\2\2\u0154\u0155\7^\2\2\u0155\u015a\7\60\2\2\u0156\u0157\7\'\2\2\u0157"+
		"\u0158\7\64\2\2\u0158\u015a\7G\2\2\u0159\u0151\3\2\2\2\u0159\u0152\3\2"+
		"\2\2\u0159\u0153\3\2\2\2\u0159\u0154\3\2\2\2\u0159\u0156\3\2\2\2\u015a"+
		"\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2"+
		"\2\2\u015d\u015b\3\2\2\2\u015e\u015f\7<\2\2\u015fC\3\2\2\2\u0160\u0165"+
		"\7$\2\2\u0161\u0166\5|=\2\u0162\u0166\5~>\2\u0163\u0166\5\u0084A\2\u0164"+
		"\u0166\7\"\2\2\u0165\u0161\3\2\2\2\u0165\u0162\3\2\2\2\u0165\u0163\3\2"+
		"\2\2\u0165\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0165\3\2\2\2\u0167"+
		"\u0168\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\7$\2\2\u016aE\3\2\2\2\u016b"+
		"\u016c\5\u0080?\2\u016c\u016d\7<\2\2\u016d\u016e\5\u0082@\2\u016eG\3\2"+
		"\2\2\u016f\u0177\7B\2\2\u0170\u0171\5B \2\u0171\u0172\5@\37\2\u0172\u0178"+
		"\3\2\2\2\u0173\u0174\7>\2\2\u0174\u0175\5@\37\2\u0175\u0176\7@\2\2\u0176"+
		"\u0178\3\2\2\2\u0177\u0170\3\2\2\2\u0177\u0173\3\2\2\2\u0178I\3\2\2\2"+
		"\u0179\u017b\7B\2\2\u017a\u017c\5|=\2\u017b\u017a\3\2\2\2\u017c\u017d"+
		"\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0188\3\2\2\2\u017f"+
		"\u0182\7/\2\2\u0180\u0183\5|=\2\u0181\u0183\5~>\2\u0182\u0180\3\2\2\2"+
		"\u0182\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185"+
		"\3\2\2\2\u0185\u0187\3\2\2\2\u0186\u017f\3\2\2\2\u0187\u018a\3\2\2\2\u0188"+
		"\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189K\3\2\2\2\u018a\u0188\3\2\2\2"+
		"\u018b\u018f\7%\2\2\u018c\u018e\n\4\2\2\u018d\u018c\3\2\2\2\u018e\u0191"+
		"\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0192\3\2\2\2\u0191"+
		"\u018f\3\2\2\2\u0192\u0193\b%\4\2\u0193M\3\2\2\2\u0194\u0195\t\5\2\2\u0195"+
		"\u0196\3\2\2\2\u0196\u0197\b&\4\2\u0197O\3\2\2\2\u0198\u0199\7j\2\2\u0199"+
		"\u019a\7v\2\2\u019a\u019b\7v\2\2\u019b\u01a6\7r\2\2\u019c\u019d\7j\2\2"+
		"\u019d\u019e\7v\2\2\u019e\u019f\7v\2\2\u019f\u01a0\7r\2\2\u01a0\u01a6"+
		"\7u\2\2\u01a1\u01a2\7h\2\2\u01a2\u01a3\7k\2\2\u01a3\u01a4\7n\2\2\u01a4"+
		"\u01a6\7g\2\2\u01a5\u0198\3\2\2\2\u01a5\u019c\3\2\2\2\u01a5\u01a1\3\2"+
		"\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\7<\2\2\u01a8\u01a9\7\61\2\2\u01a9"+
		"\u01aa\7\61\2\2\u01aa\u01b0\3\2\2\2\u01ab\u01af\5|=\2\u01ac\u01af\5~>"+
		"\2\u01ad\u01af\5\u0084A\2\u01ae\u01ab\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01ad\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b0\u01b1\3\2"+
		"\2\2\u01b1Q\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4\7l\2\2\u01b4\u01b5"+
		"\7f\2\2\u01b5\u01b6\7d\2\2\u01b6\u01b7\7e\2\2\u01b7\u01b8\7<\2\2\u01b8"+
		"\u01bb\3\2\2\2\u01b9\u01bc\5|=\2\u01ba\u01bc\5~>\2\u01bb\u01b9\3\2\2\2"+
		"\u01bb\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bb\3\2\2\2\u01bd\u01be"+
		"\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c5\7<\2\2\u01c0\u01c4\5|=\2\u01c1"+
		"\u01c4\5~>\2\u01c2\u01c4\5\u0084A\2\u01c3\u01c0\3\2\2\2\u01c3\u01c1\3"+
		"\2\2\2\u01c3\u01c2\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5"+
		"\u01c6\3\2\2\2\u01c6S\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01c9\5\u0096"+
		"J\2\u01c9\u01ca\5\u00a8S\2\u01ca\u01cb\5\u00a0O\2\u01cb\u01cc\5\u009e"+
		"N\2\u01cc\u01cd\5\u00a2P\2\u01cd\u01ce\5>\36\2\u01ce\u01cf\5\u00aaT\2"+
		"\u01cf\u01d0\5\u0092H\2\u01d0\u01d1\7<\2\2\u01d1U\3\2\2\2\u01d2\u01d3"+
		"\5\u00b2X\2\u01d3\u01d4\5\u00a2P\2\u01d4\u01d5\5>\36\2\u01d5\u01d6\5\u00aa"+
		"T\2\u01d6\u01d7\5\u0092H\2\u01d7\u01d8\7<\2\2\u01d8W\3\2\2\2\u01d9\u01da"+
		"\5\u0088C\2\u01da\u01db\5\u00a8S\2\u01db\u01dc\5\u00aeV\2\u01dc\u01dd"+
		"\5\u00a2P\2\u01dd\u01de\5\u008cE\2\u01de\u01df\5\u00a6R\2\u01df\u01e0"+
		"\5\u00a6R\2\u01e0\u01e1\5\u00a0O\2\u01e1\u01e2\5\u00b0W\2\u01e2Y\3\2\2"+
		"\2\u01e3\u01e4\5\u00a8S\2\u01e4\u01e5\5\u00a4Q\2\u01e5\u01e6\5\u009aL"+
		"\2\u01e6\u01e7\7<\2\2\u01e7[\3\2\2\2\u01e8\u01ec\5|=\2\u01e9\u01ec\5~"+
		">\2\u01ea\u01ec\5\u0084A\2\u01eb\u01e8\3\2\2\2\u01eb\u01e9\3\2\2\2\u01eb"+
		"\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed\u01ee\3\2"+
		"\2\2\u01ee]\3\2\2\2\u01ef\u01f0\7@\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f2"+
		"\b.\5\2\u01f2_\3\2\2\2\u01f3\u01f4\t\5\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f6"+
		"\b/\4\2\u01f6a\3\2\2\2\u01f7\u01f8\7>\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fa"+
		"\b\60\6\2\u01fac\3\2\2\2\u01fb\u0201\5|=\2\u01fc\u0200\5|=\2\u01fd\u0200"+
		"\5~>\2\u01fe\u0200\7a\2\2\u01ff\u01fc\3\2\2\2\u01ff\u01fd\3\2\2\2\u01ff"+
		"\u01fe\3\2\2\2\u0200\u0203\3\2\2\2\u0201\u01ff\3\2\2\2\u0201\u0202\3\2"+
		"\2\2\u0202e\3\2\2\2\u0203\u0201\3\2\2\2\u0204\u0208\5|=\2\u0205\u0208"+
		"\5~>\2\u0206\u0208\7a\2\2\u0207\u0204\3\2\2\2\u0207\u0205\3\2\2\2\u0207"+
		"\u0206\3\2\2\2\u0208\u020b\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2"+
		"\2\2\u020a\u020c\3\2\2\2\u020b\u0209\3\2\2\2\u020c\u020d\7<\2\2\u020d"+
		"g\3\2\2\2\u020e\u020f\t\5\2\2\u020f\u0210\3\2\2\2\u0210\u0211\b\63\4\2"+
		"\u0211i\3\2\2\2\u0212\u0213\7>\2\2\u0213k\3\2\2\2\u0214\u0215\5\u00aa"+
		"T\2\u0215\u0216\5\u00a0O\2\u0216m\3\2\2\2\u0217\u0218\5\u0086B\2\u0218"+
		"\u0219\5\u00b4Y\2\u0219o\3\2\2\2\u021a\u021b\7-\2\2\u021bq\3\2\2\2\u021c"+
		"\u021e\5~>\2\u021d\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f\u021d\3\2\2"+
		"\2\u021f\u0220\3\2\2\2\u0220s\3\2\2\2\u0221\u0227\5|=\2\u0222\u0226\5"+
		"|=\2\u0223\u0226\5~>\2\u0224\u0226\7a\2\2\u0225\u0222\3\2\2\2\u0225\u0223"+
		"\3\2\2\2\u0225\u0224\3\2\2\2\u0226\u0229\3\2\2\2\u0227\u0225\3\2\2\2\u0227"+
		"\u0228\3\2\2\2\u0228u\3\2\2\2\u0229\u0227\3\2\2\2\u022a\u022f\7$\2\2\u022b"+
		"\u0230\5|=\2\u022c\u0230\5~>\2\u022d\u0230\5\u0084A\2\u022e\u0230\7\""+
		"\2\2\u022f\u022b\3\2\2\2\u022f\u022c\3\2\2\2\u022f\u022d\3\2\2\2\u022f"+
		"\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u022f\3\2\2\2\u0231\u0232\3\2"+
		"\2\2\u0232\u0233\3\2\2\2\u0233\u0234\7$\2\2\u0234w\3\2\2\2\u0235\u0236"+
		"\7@\2\2\u0236\u0237\3\2\2\2\u0237\u0238\b;\5\2\u0238y\3\2\2\2\u0239\u023a"+
		"\t\5\2\2\u023a\u023b\3\2\2\2\u023b\u023c\b<\4\2\u023c{\3\2\2\2\u023d\u023f"+
		"\t\6\2\2\u023e\u023d\3\2\2\2\u023f}\3\2\2\2\u0240\u0241\t\7\2\2\u0241"+
		"\177\3\2\2\2\u0242\u0243\7z\2\2\u0243\u0248\7u\2\2\u0244\u0245\7z\2\2"+
		"\u0245\u0246\7u\2\2\u0246\u0248\7f\2\2\u0247\u0242\3\2\2\2\u0247\u0244"+
		"\3\2\2\2\u0248\u0081\3\2\2\2\u0249\u024a\7u\2\2\u024a\u024b\7v\2\2\u024b"+
		"\u024c\7t\2\2\u024c\u024d\7k\2\2\u024d\u024e\7p\2\2\u024e\u03a2\7i\2\2"+
		"\u024f\u0250\7d\2\2\u0250\u0251\7q\2\2\u0251\u0252\7q\2\2\u0252\u0253"+
		"\7n\2\2\u0253\u0254\7g\2\2\u0254\u0255\7c\2\2\u0255\u03a2\7p\2\2\u0256"+
		"\u0257\7f\2\2\u0257\u0258\7g\2\2\u0258\u0259\7e\2\2\u0259\u025a\7k\2\2"+
		"\u025a\u025b\7o\2\2\u025b\u025c\7c\2\2\u025c\u03a2\7n\2\2\u025d\u025e"+
		"\7k\2\2\u025e\u025f\7p\2\2\u025f\u0260\7v\2\2\u0260\u0261\7g\2\2\u0261"+
		"\u0262\7i\2\2\u0262\u0263\7g\2\2\u0263\u03a2\7t\2\2\u0264\u0265\7f\2\2"+
		"\u0265\u0266\7q\2\2\u0266\u0267\7w\2\2\u0267\u0268\7d\2\2\u0268\u0269"+
		"\7n\2\2\u0269\u03a2\7g\2\2\u026a\u026b\7h\2\2\u026b\u026c\7n\2\2\u026c"+
		"\u026d\7q\2\2\u026d\u026e\7c\2\2\u026e\u03a2\7v\2\2\u026f\u0270\7f\2\2"+
		"\u0270\u0271\7c\2\2\u0271\u0272\7v\2\2\u0272\u03a2\7g\2\2\u0273\u0274"+
		"\7v\2\2\u0274\u0275\7k\2\2\u0275\u0276\7o\2\2\u0276\u03a2\7g\2\2\u0277"+
		"\u0278\7f\2\2\u0278\u0279\7c\2\2\u0279\u027a\7v\2\2\u027a\u027b\7g\2\2"+
		"\u027b\u027c\7V\2\2\u027c\u027d\7k\2\2\u027d\u027e\7o\2\2\u027e\u03a2"+
		"\7g\2\2\u027f\u0280\7f\2\2\u0280\u0281\7c\2\2\u0281\u0282\7v\2\2\u0282"+
		"\u0283\7g\2\2\u0283\u0284\7V\2\2\u0284\u0285\7k\2\2\u0285\u0286\7o\2\2"+
		"\u0286\u0287\7g\2\2\u0287\u0288\7U\2\2\u0288\u0289\7v\2\2\u0289\u028a"+
		"\7c\2\2\u028a\u028b\7o\2\2\u028b\u03a2\7r\2\2\u028c\u028d\7i\2\2\u028d"+
		"\u028e\7[\2\2\u028e\u028f\7g\2\2\u028f\u0290\7c\2\2\u0290\u03a2\7t\2\2"+
		"\u0291\u0292\7i\2\2\u0292\u0293\7O\2\2\u0293\u0294\7q\2\2\u0294\u0295"+
		"\7p\2\2\u0295\u0296\7v\2\2\u0296\u03a2\7j\2\2\u0297\u0298\7i\2\2\u0298"+
		"\u0299\7F\2\2\u0299\u029a\7c\2\2\u029a\u03a2\7{\2\2\u029b\u029c\7i\2\2"+
		"\u029c\u029d\7[\2\2\u029d\u029e\7g\2\2\u029e\u029f\7c\2\2\u029f\u02a0"+
		"\7t\2\2\u02a0\u02a1\7O\2\2\u02a1\u02a2\7q\2\2\u02a2\u02a3\7p\2\2\u02a3"+
		"\u02a4\7v\2\2\u02a4\u03a2\7j\2\2\u02a5\u02a6\7i\2\2\u02a6\u02a7\7O\2\2"+
		"\u02a7\u02a8\7q\2\2\u02a8\u02a9\7p\2\2\u02a9\u02aa\7v\2\2\u02aa\u02ab"+
		"\7j\2\2\u02ab\u02ac\7F\2\2\u02ac\u02ad\7c\2\2\u02ad\u03a2\7{\2\2\u02ae"+
		"\u02af\7f\2\2\u02af\u02b0\7w\2\2\u02b0\u02b1\7t\2\2\u02b1\u02b2\7c\2\2"+
		"\u02b2\u02b3\7v\2\2\u02b3\u02b4\7k\2\2\u02b4\u02b5\7q\2\2\u02b5\u03a2"+
		"\7p\2\2\u02b6\u02b7\7{\2\2\u02b7\u02b8\7g\2\2\u02b8\u02b9\7c\2\2\u02b9"+
		"\u02ba\7t\2\2\u02ba\u02bb\7O\2\2\u02bb\u02bc\7q\2\2\u02bc\u02bd\7p\2\2"+
		"\u02bd\u02be\7v\2\2\u02be\u02bf\7j\2\2\u02bf\u02c0\7F\2\2\u02c0\u02c1"+
		"\7w\2\2\u02c1\u02c2\7t\2\2\u02c2\u02c3\7c\2\2\u02c3\u02c4\7v\2\2\u02c4"+
		"\u02c5\7k\2\2\u02c5\u02c6\7q\2\2\u02c6\u03a2\7p\2\2\u02c7\u02c8\7f\2\2"+
		"\u02c8\u02c9\7c\2\2\u02c9\u02ca\7{\2\2\u02ca\u02cb\7V\2\2\u02cb\u02cc"+
		"\7k\2\2\u02cc\u02cd\7o\2\2\u02cd\u02ce\7g\2\2\u02ce\u02cf\7F\2\2\u02cf"+
		"\u02d0\7w\2\2\u02d0\u02d1\7t\2\2\u02d1\u02d2\7c\2\2\u02d2\u02d3\7v\2\2"+
		"\u02d3\u02d4\7k\2\2\u02d4\u02d5\7q\2\2\u02d5\u03a2\7p\2\2\u02d6\u02d7"+
		"\7d\2\2\u02d7\u02d8\7{\2\2\u02d8\u02d9\7v\2\2\u02d9\u03a2\7g\2\2\u02da"+
		"\u02db\7u\2\2\u02db\u02dc\7j\2\2\u02dc\u02dd\7q\2\2\u02dd\u02de\7t\2\2"+
		"\u02de\u03a2\7v\2\2\u02df\u02e0\7k\2\2\u02e0\u02e1\7p\2\2\u02e1\u03a2"+
		"\7v\2\2\u02e2\u02e3\7n\2\2\u02e3\u02e4\7q\2\2\u02e4\u02e5\7p\2\2\u02e5"+
		"\u03a2\7i\2\2\u02e6\u02e7\7w\2\2\u02e7\u02e8\7p\2\2\u02e8\u02e9\7u\2\2"+
		"\u02e9\u02ea\7k\2\2\u02ea\u02eb\7i\2\2\u02eb\u02ec\7p\2\2\u02ec\u02ed"+
		"\7g\2\2\u02ed\u02ee\7f\2\2\u02ee\u02ef\7D\2\2\u02ef\u02f0\7{\2\2\u02f0"+
		"\u02f1\7v\2\2\u02f1\u03a2\7g\2\2\u02f2\u02f3\7w\2\2\u02f3\u02f4\7p\2\2"+
		"\u02f4\u02f5\7u\2\2\u02f5\u02f6\7k\2\2\u02f6\u02f7\7i\2\2\u02f7\u02f8"+
		"\7p\2\2\u02f8\u02f9\7g\2\2\u02f9\u02fa\7f\2\2\u02fa\u02fb\7U\2\2\u02fb"+
		"\u02fc\7j\2\2\u02fc\u02fd\7q\2\2\u02fd\u02fe\7t\2\2\u02fe\u03a2\7v\2\2"+
		"\u02ff\u0300\7w\2\2\u0300\u0301\7p\2\2\u0301\u0302\7u\2\2\u0302\u0303"+
		"\7k\2\2\u0303\u0304\7i\2\2\u0304\u0305\7p\2\2\u0305\u0306\7g\2\2\u0306"+
		"\u0307\7f\2\2\u0307\u0308\7K\2\2\u0308\u0309\7p\2\2\u0309\u03a2\7v\2\2"+
		"\u030a\u030b\7w\2\2\u030b\u030c\7p\2\2\u030c\u030d\7u\2\2\u030d\u030e"+
		"\7k\2\2\u030e\u030f\7i\2\2\u030f\u0310\7p\2\2\u0310\u0311\7g\2\2\u0311"+
		"\u0312\7f\2\2\u0312\u0313\7N\2\2\u0313\u0314\7q\2\2\u0314\u0315\7p\2\2"+
		"\u0315\u03a2\7i\2\2\u0316\u0317\7r\2\2\u0317\u0318\7q\2\2\u0318\u0319"+
		"\7u\2\2\u0319\u031a\7k\2\2\u031a\u031b\7v\2\2\u031b\u031c\7k\2\2\u031c"+
		"\u031d\7x\2\2\u031d\u031e\7g\2\2\u031e\u031f\7K\2\2\u031f\u0320\7p\2\2"+
		"\u0320\u0321\7v\2\2\u0321\u0322\7g\2\2\u0322\u0323\7i\2\2\u0323\u0324"+
		"\7g\2\2\u0324\u03a2\7t\2\2\u0325\u0326\7p\2\2\u0326\u0327\7q\2\2\u0327"+
		"\u0328\7p\2\2\u0328\u0329\7P\2\2\u0329\u032a\7g\2\2\u032a\u032b\7i\2\2"+
		"\u032b\u032c\7c\2\2\u032c\u032d\7v\2\2\u032d\u032e\7k\2\2\u032e\u032f"+
		"\7x\2\2\u032f\u0330\7g\2\2\u0330\u0331\7K\2\2\u0331\u0332\7p\2\2\u0332"+
		"\u0333\7v\2\2\u0333\u0334\7g\2\2\u0334\u0335\7i\2\2\u0335\u0336\7g\2\2"+
		"\u0336\u03a2\7t\2\2\u0337\u0338\7p\2\2\u0338\u0339\7g\2\2\u0339\u033a"+
		"\7i\2\2\u033a\u033b\7c\2\2\u033b\u033c\7v\2\2\u033c\u033d\7k\2\2\u033d"+
		"\u033e\7x\2\2\u033e\u033f\7g\2\2\u033f\u0340\7K\2\2\u0340\u0341\7p\2\2"+
		"\u0341\u0342\7v\2\2\u0342\u0343\7g\2\2\u0343\u0344\7i\2\2\u0344\u0345"+
		"\7g\2\2\u0345\u03a2\7t\2\2\u0346\u0347\7p\2\2\u0347\u0348\7q\2\2\u0348"+
		"\u0349\7p\2\2\u0349\u034a\7R\2\2\u034a\u034b\7q\2\2\u034b\u034c\7u\2\2"+
		"\u034c\u034d\7k\2\2\u034d\u034e\7v\2\2\u034e\u034f\7k\2\2\u034f\u0350"+
		"\7x\2\2\u0350\u0351\7g\2\2\u0351\u0352\7K\2\2\u0352\u0353\7p\2\2\u0353"+
		"\u0354\7v\2\2\u0354\u0355\7g\2\2\u0355\u0356\7i\2\2\u0356\u0357\7g\2\2"+
		"\u0357\u03a2\7t\2\2\u0358\u0359\7j\2\2\u0359\u035a\7g\2\2\u035a\u035b"+
		"\7z\2\2\u035b\u035c\7D\2\2\u035c\u035d\7k\2\2\u035d\u035e\7p\2\2\u035e"+
		"\u035f\7c\2\2\u035f\u0360\7t\2\2\u0360\u03a2\7{\2\2\u0361\u0362\7d\2\2"+
		"\u0362\u0363\7c\2\2\u0363\u0364\7u\2\2\u0364\u0365\7g\2\2\u0365\u0366"+
		"\78\2\2\u0366\u0367\7\66\2\2\u0367\u0368\7D\2\2\u0368\u0369\7k\2\2\u0369"+
		"\u036a\7p\2\2\u036a\u036b\7c\2\2\u036b\u036c\7t\2\2\u036c\u03a2\7{\2\2"+
		"\u036d\u036e\7c\2\2\u036e\u036f\7p\2\2\u036f\u0370\7{\2\2\u0370\u0371"+
		"\7W\2\2\u0371\u0372\7T\2\2\u0372\u03a2\7K\2\2\u0373\u0374\7n\2\2\u0374"+
		"\u0375\7c\2\2\u0375\u0376\7p\2\2\u0376\u0377\7i\2\2\u0377\u0378\7w\2\2"+
		"\u0378\u0379\7c\2\2\u0379\u037a\7i\2\2\u037a\u03a2\7g\2\2\u037b\u037c"+
		"\7p\2\2\u037c\u037d\7q\2\2\u037d\u037e\7t\2\2\u037e\u037f\7o\2\2\u037f"+
		"\u0380\7c\2\2\u0380\u0381\7n\2\2\u0381\u0382\7k\2\2\u0382\u0383\7|\2\2"+
		"\u0383\u0384\7g\2\2\u0384\u0385\7f\2\2\u0385\u0386\7U\2\2\u0386\u0387"+
		"\7v\2\2\u0387\u0388\7t\2\2\u0388\u0389\7k\2\2\u0389\u038a\7p\2\2\u038a"+
		"\u03a2\7i\2\2\u038b\u038c\7v\2\2\u038c\u038d\7q\2\2\u038d\u038e\7m\2\2"+
		"\u038e\u038f\7g\2\2\u038f\u03a2\7p\2\2\u0390\u0391\7P\2\2\u0391\u0392"+
		"\7O\2\2\u0392\u0393\7V\2\2\u0393\u0394\7Q\2\2\u0394\u0395\7M\2\2\u0395"+
		"\u0396\7G\2\2\u0396\u03a2\7P\2\2\u0397\u0398\7P\2\2\u0398\u0399\7c\2\2"+
		"\u0399\u039a\7o\2\2\u039a\u03a2\7g\2\2\u039b\u039c\7P\2\2\u039c\u039d"+
		"\7E\2\2\u039d\u039e\7P\2\2\u039e\u039f\7c\2\2\u039f\u03a0\7o\2\2\u03a0"+
		"\u03a2\7g\2\2\u03a1\u0249\3\2\2\2\u03a1\u024f\3\2\2\2\u03a1\u0256\3\2"+
		"\2\2\u03a1\u025d\3\2\2\2\u03a1\u0264\3\2\2\2\u03a1\u026a\3\2\2\2\u03a1"+
		"\u026f\3\2\2\2\u03a1\u0273\3\2\2\2\u03a1\u0277\3\2\2\2\u03a1\u027f\3\2"+
		"\2\2\u03a1\u028c\3\2\2\2\u03a1\u0291\3\2\2\2\u03a1\u0297\3\2\2\2\u03a1"+
		"\u029b\3\2\2\2\u03a1\u02a5\3\2\2\2\u03a1\u02ae\3\2\2\2\u03a1\u02b6\3\2"+
		"\2\2\u03a1\u02c7\3\2\2\2\u03a1\u02d6\3\2\2\2\u03a1\u02da\3\2\2\2\u03a1"+
		"\u02df\3\2\2\2\u03a1\u02e2\3\2\2\2\u03a1\u02e6\3\2\2\2\u03a1\u02f2\3\2"+
		"\2\2\u03a1\u02ff\3\2\2\2\u03a1\u030a\3\2\2\2\u03a1\u0316\3\2\2\2\u03a1"+
		"\u0325\3\2\2\2\u03a1\u0337\3\2\2\2\u03a1\u0346\3\2\2\2\u03a1\u0358\3\2"+
		"\2\2\u03a1\u0361\3\2\2\2\u03a1\u036d\3\2\2\2\u03a1\u0373\3\2\2\2\u03a1"+
		"\u037b\3\2\2\2\u03a1\u038b\3\2\2\2\u03a1\u0390\3\2\2\2\u03a1\u0397\3\2"+
		"\2\2\u03a1\u039b\3\2\2\2\u03a2\u0083\3\2\2\2\u03a3\u03a4\t\b\2\2\u03a4"+
		"\u0085\3\2\2\2\u03a5\u03a6\t\t\2\2\u03a6\u0087\3\2\2\2\u03a7\u03a8\t\n"+
		"\2\2\u03a8\u0089\3\2\2\2\u03a9\u03aa\t\13\2\2\u03aa\u008b\3\2\2\2\u03ab"+
		"\u03ac\t\f\2\2\u03ac\u008d\3\2\2\2\u03ad\u03ae\t\r\2\2\u03ae\u008f\3\2"+
		"\2\2\u03af\u03b0\t\16\2\2\u03b0\u0091\3\2\2\2\u03b1\u03b2\t\17\2\2\u03b2"+
		"\u0093\3\2\2\2\u03b3\u03b4\t\20\2\2\u03b4\u0095\3\2\2\2\u03b5\u03b6\t"+
		"\21\2\2\u03b6\u0097\3\2\2\2\u03b7\u03b8\t\22\2\2\u03b8\u0099\3\2\2\2\u03b9"+
		"\u03ba\t\23\2\2\u03ba\u009b\3\2\2\2\u03bb\u03bc\t\24\2\2\u03bc\u009d\3"+
		"\2\2\2\u03bd\u03be\t\25\2\2\u03be\u009f\3\2\2\2\u03bf\u03c0\t\26\2\2\u03c0"+
		"\u00a1\3\2\2\2\u03c1\u03c2\t\27\2\2\u03c2\u00a3\3\2\2\2\u03c3\u03c4\t"+
		"\30\2\2\u03c4\u00a5\3\2\2\2\u03c5\u03c6\t\31\2\2\u03c6\u00a7\3\2\2\2\u03c7"+
		"\u03c8\t\32\2\2\u03c8\u00a9\3\2\2\2\u03c9\u03ca\t\33\2\2\u03ca\u00ab\3"+
		"\2\2\2\u03cb\u03cc\t\34\2\2\u03cc\u00ad\3\2\2\2\u03cd\u03ce\t\35\2\2\u03ce"+
		"\u00af\3\2\2\2\u03cf\u03d0\t\36\2\2\u03d0\u00b1\3\2\2\2\u03d1\u03d2\t"+
		"\37\2\2\u03d2\u00b3\3\2\2\2\u03d3\u03d4\t \2\2\u03d4\u00b5\3\2\2\2\u03d5"+
		"\u03d6\t!\2\2\u03d6\u00b7\3\2\2\2(\2\3\4\5\u0141\u014d\u014f\u0159\u015b"+
		"\u0165\u0167\u0177\u017d\u0182\u0184\u0188\u018f\u01a5\u01ae\u01b0\u01bb"+
		"\u01bd\u01c3\u01c5\u01eb\u01ed\u01ff\u0201\u0207\u0209\u021f\u0225\u0227"+
		"\u022f\u0231\u023e\u0247\u03a1\7\4\4\2\4\5\2\b\2\2\4\2\2\4\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}