// Generated from ShExMLLexer.g4 by ANTLR 4.7.2

package es.weso.antlr;

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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREFIX=1, SOURCE=2, QUERY=3, ITERATOR=4, FIELD=5, EXPRESSION=6, UNION=7, 
		JOIN=8, MATCHER=9, AS=10, MATCHING=11, QUERY_SET=12, EXPRESSION_SET=13, 
		LESS_SYMBOL=14, GREATER_SYMBOL=15, BRACKET_LEFT=16, BRACKET_RIGHT=17, 
		PAREN_LEFT=18, PAREN_RIGHT=19, BRACE_LEFT=20, BRACE_RIGHT=21, SEMICOLON=22, 
		DOT=23, AT=24, ADD=25, COMMA=26, QUOTE=27, AND=28, A=29, STRING_OR_VAR=30, 
		URI_VAR=31, STRINGOPERATOR=32, COMMENT=33, WS=34, URL=35, JSONPATH=36, 
		XMLPATH=37, QUERY_PART=38, GREATER_SYMBOL_QUERY=39, WS_QUERY=40, LESS_SYMBOL_QUERY=41, 
		STRING_OR_VAR_QUERY=42, URI_VAR_QUERY=43, WS_DECLARATION=44;
	public static final int
		QUERY_CONTENT=1, DECLARATION_CONTENT=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "QUERY_CONTENT", "DECLARATION_CONTENT"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "EXPRESSION", "UNION", 
			"JOIN", "MATCHER", "AS", "MATCHING", "QUERY_SET", "EXPRESSION_SET", "LESS_SYMBOL", 
			"GREATER_SYMBOL", "BRACKET_LEFT", "BRACKET_RIGHT", "PAREN_LEFT", "PAREN_RIGHT", 
			"BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "AT", "ADD", "COMMA", 
			"QUOTE", "AND", "A", "STRING_OR_VAR", "URI_VAR", "STRINGOPERATOR", "COMMENT", 
			"WS", "URL", "JSONPATH", "XMLPATH", "QUERY_PART", "GREATER_SYMBOL_QUERY", 
			"WS_QUERY", "LESS_SYMBOL_QUERY", "STRING_OR_VAR_QUERY", "URI_VAR_QUERY", 
			"WS_DECLARATION", "LETTER", "DIGIT", "ALLOWED_CHARACTERS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'PREFIX'", "'SOURCE'", "'QUERY'", "'ITERATOR'", "'FIELD'", "'EXPRESSION'", 
			"'UNION'", "'JOIN'", "'MATCHER'", "'AS'", "'MATCHING'", "'QUERY_SET'", 
			"'EXPRESSION_SET'", null, null, "'['", "']'", "'('", "')'", "'{'", "'}'", 
			"';'", "'.'", "'@'", "'+'", "','", "'\"'", null, "'a'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "EXPRESSION", 
			"UNION", "JOIN", "MATCHER", "AS", "MATCHING", "QUERY_SET", "EXPRESSION_SET", 
			"LESS_SYMBOL", "GREATER_SYMBOL", "BRACKET_LEFT", "BRACKET_RIGHT", "PAREN_LEFT", 
			"PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "AT", 
			"ADD", "COMMA", "QUOTE", "AND", "A", "STRING_OR_VAR", "URI_VAR", "STRINGOPERATOR", 
			"COMMENT", "WS", "URL", "JSONPATH", "XMLPATH", "QUERY_PART", "GREATER_SYMBOL_QUERY", 
			"WS_QUERY", "LESS_SYMBOL_QUERY", "STRING_OR_VAR_QUERY", "URI_VAR_QUERY", 
			"WS_DECLARATION"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u018d\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u00f2\n\35\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\7\37\u00fa\n\37\f\37\16\37\u00fd\13\37\3 \3 \3 \7 \u0102\n \f \16"+
		" \u0105\13 \3 \3 \3!\3!\3!\3!\3!\6!\u010e\n!\r!\16!\u010f\3!\3!\3\"\3"+
		"\"\7\"\u0116\n\"\f\"\16\"\u0119\13\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\5$\u012e\n$\3$\3$\3$\3$\3$\3$\3$\7$\u0137\n"+
		"$\f$\16$\u013a\13$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\6%\u014a"+
		"\n%\r%\16%\u014b\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\6&\u0159\n&\r&\16&\u015a"+
		"\3\'\3\'\3\'\6\'\u0160\n\'\r\'\16\'\u0161\3(\3(\3(\3(\3)\3)\3)\3)\3*\3"+
		"*\3*\3*\3+\3+\3+\3+\7+\u0174\n+\f+\16+\u0177\13+\3,\3,\3,\7,\u017c\n,"+
		"\f,\16,\u017f\13,\3,\3,\3-\3-\3-\3-\3.\5.\u0188\n.\3/\3/\3\60\3\60\2\2"+
		"\61\5\3\7\4\t\5\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37"+
		"\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36="+
		"\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]\2_\2a\2\5\2\3\4\7\4\2\f\f\17\17\5"+
		"\2\13\f\17\17\"\"\7\2C\\c|\u00c2\u00d8\u00da\u00f8\u00fa\u0101\3\2\62"+
		";\b\2%,.\61<<??AB]a\2\u01a7\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\3I\3\2\2\2\3K\3\2\2\2\3M\3\2\2\2\3O\3\2\2\2\3Q\3\2\2"+
		"\2\3S\3\2\2\2\4U\3\2\2\2\4W\3\2\2\2\4Y\3\2\2\2\4[\3\2\2\2\5c\3\2\2\2\7"+
		"l\3\2\2\2\tu\3\2\2\2\13{\3\2\2\2\r\u0086\3\2\2\2\17\u008e\3\2\2\2\21\u0099"+
		"\3\2\2\2\23\u009f\3\2\2\2\25\u00a4\3\2\2\2\27\u00ac\3\2\2\2\31\u00af\3"+
		"\2\2\2\33\u00b8\3\2\2\2\35\u00c2\3\2\2\2\37\u00d1\3\2\2\2!\u00d3\3\2\2"+
		"\2#\u00d5\3\2\2\2%\u00d7\3\2\2\2\'\u00d9\3\2\2\2)\u00db\3\2\2\2+\u00dd"+
		"\3\2\2\2-\u00df\3\2\2\2/\u00e1\3\2\2\2\61\u00e3\3\2\2\2\63\u00e5\3\2\2"+
		"\2\65\u00e7\3\2\2\2\67\u00e9\3\2\2\29\u00eb\3\2\2\2;\u00f1\3\2\2\2=\u00f3"+
		"\3\2\2\2?\u00f5\3\2\2\2A\u0103\3\2\2\2C\u0108\3\2\2\2E\u0113\3\2\2\2G"+
		"\u011c\3\2\2\2I\u012d\3\2\2\2K\u013b\3\2\2\2M\u014d\3\2\2\2O\u015f\3\2"+
		"\2\2Q\u0163\3\2\2\2S\u0167\3\2\2\2U\u016b\3\2\2\2W\u016f\3\2\2\2Y\u017d"+
		"\3\2\2\2[\u0182\3\2\2\2]\u0187\3\2\2\2_\u0189\3\2\2\2a\u018b\3\2\2\2c"+
		"d\7R\2\2de\7T\2\2ef\7G\2\2fg\7H\2\2gh\7K\2\2hi\7Z\2\2ij\3\2\2\2jk\b\2"+
		"\2\2k\6\3\2\2\2lm\7U\2\2mn\7Q\2\2no\7W\2\2op\7T\2\2pq\7E\2\2qr\7G\2\2"+
		"rs\3\2\2\2st\b\3\2\2t\b\3\2\2\2uv\7S\2\2vw\7W\2\2wx\7G\2\2xy\7T\2\2yz"+
		"\7[\2\2z\n\3\2\2\2{|\7K\2\2|}\7V\2\2}~\7G\2\2~\177\7T\2\2\177\u0080\7"+
		"C\2\2\u0080\u0081\7V\2\2\u0081\u0082\7Q\2\2\u0082\u0083\7T\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0085\b\5\2\2\u0085\f\3\2\2\2\u0086\u0087\7H\2\2\u0087"+
		"\u0088\7K\2\2\u0088\u0089\7G\2\2\u0089\u008a\7N\2\2\u008a\u008b\7F\2\2"+
		"\u008b\u008c\3\2\2\2\u008c\u008d\b\6\2\2\u008d\16\3\2\2\2\u008e\u008f"+
		"\7G\2\2\u008f\u0090\7Z\2\2\u0090\u0091\7R\2\2\u0091\u0092\7T\2\2\u0092"+
		"\u0093\7G\2\2\u0093\u0094\7U\2\2\u0094\u0095\7U\2\2\u0095\u0096\7K\2\2"+
		"\u0096\u0097\7Q\2\2\u0097\u0098\7P\2\2\u0098\20\3\2\2\2\u0099\u009a\7"+
		"W\2\2\u009a\u009b\7P\2\2\u009b\u009c\7K\2\2\u009c\u009d\7Q\2\2\u009d\u009e"+
		"\7P\2\2\u009e\22\3\2\2\2\u009f\u00a0\7L\2\2\u00a0\u00a1\7Q\2\2\u00a1\u00a2"+
		"\7K\2\2\u00a2\u00a3\7P\2\2\u00a3\24\3\2\2\2\u00a4\u00a5\7O\2\2\u00a5\u00a6"+
		"\7C\2\2\u00a6\u00a7\7V\2\2\u00a7\u00a8\7E\2\2\u00a8\u00a9\7J\2\2\u00a9"+
		"\u00aa\7G\2\2\u00aa\u00ab\7T\2\2\u00ab\26\3\2\2\2\u00ac\u00ad\7C\2\2\u00ad"+
		"\u00ae\7U\2\2\u00ae\30\3\2\2\2\u00af\u00b0\7O\2\2\u00b0\u00b1\7C\2\2\u00b1"+
		"\u00b2\7V\2\2\u00b2\u00b3\7E\2\2\u00b3\u00b4\7J\2\2\u00b4\u00b5\7K\2\2"+
		"\u00b5\u00b6\7P\2\2\u00b6\u00b7\7I\2\2\u00b7\32\3\2\2\2\u00b8\u00b9\7"+
		"S\2\2\u00b9\u00ba\7W\2\2\u00ba\u00bb\7G\2\2\u00bb\u00bc\7T\2\2\u00bc\u00bd"+
		"\7[\2\2\u00bd\u00be\7a\2\2\u00be\u00bf\7U\2\2\u00bf\u00c0\7G\2\2\u00c0"+
		"\u00c1\7V\2\2\u00c1\34\3\2\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4\7Z\2\2\u00c4"+
		"\u00c5\7R\2\2\u00c5\u00c6\7T\2\2\u00c6\u00c7\7G\2\2\u00c7\u00c8\7U\2\2"+
		"\u00c8\u00c9\7U\2\2\u00c9\u00ca\7K\2\2\u00ca\u00cb\7Q\2\2\u00cb\u00cc"+
		"\7P\2\2\u00cc\u00cd\7a\2\2\u00cd\u00ce\7U\2\2\u00ce\u00cf\7G\2\2\u00cf"+
		"\u00d0\7V\2\2\u00d0\36\3\2\2\2\u00d1\u00d2\7>\2\2\u00d2 \3\2\2\2\u00d3"+
		"\u00d4\7@\2\2\u00d4\"\3\2\2\2\u00d5\u00d6\7]\2\2\u00d6$\3\2\2\2\u00d7"+
		"\u00d8\7_\2\2\u00d8&\3\2\2\2\u00d9\u00da\7*\2\2\u00da(\3\2\2\2\u00db\u00dc"+
		"\7+\2\2\u00dc*\3\2\2\2\u00dd\u00de\7}\2\2\u00de,\3\2\2\2\u00df\u00e0\7"+
		"\177\2\2\u00e0.\3\2\2\2\u00e1\u00e2\7=\2\2\u00e2\60\3\2\2\2\u00e3\u00e4"+
		"\7\60\2\2\u00e4\62\3\2\2\2\u00e5\u00e6\7B\2\2\u00e6\64\3\2\2\2\u00e7\u00e8"+
		"\7-\2\2\u00e8\66\3\2\2\2\u00e9\u00ea\7.\2\2\u00ea8\3\2\2\2\u00eb\u00ec"+
		"\7$\2\2\u00ec:\3\2\2\2\u00ed\u00f2\7(\2\2\u00ee\u00ef\7C\2\2\u00ef\u00f0"+
		"\7P\2\2\u00f0\u00f2\7F\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00ee\3\2\2\2\u00f2"+
		"<\3\2\2\2\u00f3\u00f4\7c\2\2\u00f4>\3\2\2\2\u00f5\u00fb\5].\2\u00f6\u00fa"+
		"\5].\2\u00f7\u00fa\5_/\2\u00f8\u00fa\7a\2\2\u00f9\u00f6\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc@\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0102"+
		"\5].\2\u00ff\u0102\5_/\2\u0100\u0102\7a\2\2\u0101\u00fe\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2"+
		"\2\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106"+
		"\u0107\7<\2\2\u0107B\3\2\2\2\u0108\u010d\7$\2\2\u0109\u010e\5].\2\u010a"+
		"\u010e\5_/\2\u010b\u010e\5a\60\2\u010c\u010e\7\"\2\2\u010d\u0109\3\2\2"+
		"\2\u010d\u010a\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\u0112\7$\2\2\u0112D\3\2\2\2\u0113\u0117\7%\2\2\u0114\u0116\n\2\2\2\u0115"+
		"\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118\u011a\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\b\"\3\2\u011b"+
		"F\3\2\2\2\u011c\u011d\t\3\2\2\u011d\u011e\3\2\2\2\u011e\u011f\b#\3\2\u011f"+
		"H\3\2\2\2\u0120\u0121\7j\2\2\u0121\u0122\7v\2\2\u0122\u0123\7v\2\2\u0123"+
		"\u012e\7r\2\2\u0124\u0125\7j\2\2\u0125\u0126\7v\2\2\u0126\u0127\7v\2\2"+
		"\u0127\u0128\7r\2\2\u0128\u012e\7u\2\2\u0129\u012a\7h\2\2\u012a\u012b"+
		"\7k\2\2\u012b\u012c\7n\2\2\u012c\u012e\7g\2\2\u012d\u0120\3\2\2\2\u012d"+
		"\u0124\3\2\2\2\u012d\u0129\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\7<"+
		"\2\2\u0130\u0131\7\61\2\2\u0131\u0132\7\61\2\2\u0132\u0138\3\2\2\2\u0133"+
		"\u0137\5].\2\u0134\u0137\5_/\2\u0135\u0137\5a\60\2\u0136\u0133\3\2\2\2"+
		"\u0136\u0134\3\2\2\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136"+
		"\3\2\2\2\u0138\u0139\3\2\2\2\u0139J\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u013c\7l\2\2\u013c\u013d\7u\2\2\u013d\u013e\7q\2\2\u013e\u013f\7p\2\2"+
		"\u013f\u0140\7r\2\2\u0140\u0141\7c\2\2\u0141\u0142\7v\2\2\u0142\u0143"+
		"\7j\2\2\u0143\u0144\7<\2\2\u0144\u0145\7\"\2\2\u0145\u0149\3\2\2\2\u0146"+
		"\u014a\5].\2\u0147\u014a\5_/\2\u0148\u014a\5a\60\2\u0149\u0146\3\2\2\2"+
		"\u0149\u0147\3\2\2\2\u0149\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0149"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014cL\3\2\2\2\u014d\u014e\7z\2\2\u014e\u014f"+
		"\7r\2\2\u014f\u0150\7c\2\2\u0150\u0151\7v\2\2\u0151\u0152\7j\2\2\u0152"+
		"\u0153\7<\2\2\u0153\u0154\7\"\2\2\u0154\u0158\3\2\2\2\u0155\u0159\5]."+
		"\2\u0156\u0159\5_/\2\u0157\u0159\5a\60\2\u0158\u0155\3\2\2\2\u0158\u0156"+
		"\3\2\2\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a"+
		"\u015b\3\2\2\2\u015bN\3\2\2\2\u015c\u0160\5].\2\u015d\u0160\5_/\2\u015e"+
		"\u0160\5a\60\2\u015f\u015c\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u015e\3\2"+
		"\2\2\u0160\u0161\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0162\3\2\2\2\u0162"+
		"P\3\2\2\2\u0163\u0164\7@\2\2\u0164\u0165\3\2\2\2\u0165\u0166\b(\4\2\u0166"+
		"R\3\2\2\2\u0167\u0168\t\3\2\2\u0168\u0169\3\2\2\2\u0169\u016a\b)\3\2\u016a"+
		"T\3\2\2\2\u016b\u016c\7>\2\2\u016c\u016d\3\2\2\2\u016d\u016e\b*\5\2\u016e"+
		"V\3\2\2\2\u016f\u0175\5].\2\u0170\u0174\5].\2\u0171\u0174\5_/\2\u0172"+
		"\u0174\7a\2\2\u0173\u0170\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0172\3\2"+
		"\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176"+
		"X\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u017c\5].\2\u0179\u017c\5_/\2\u017a"+
		"\u017c\7a\2\2\u017b\u0178\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017a\3\2"+
		"\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"\u0180\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0181\7<\2\2\u0181Z\3\2\2\2\u0182"+
		"\u0183\t\3\2\2\u0183\u0184\3\2\2\2\u0184\u0185\b-\3\2\u0185\\\3\2\2\2"+
		"\u0186\u0188\t\4\2\2\u0187\u0186\3\2\2\2\u0188^\3\2\2\2\u0189\u018a\t"+
		"\5\2\2\u018a`\3\2\2\2\u018b\u018c\t\6\2\2\u018cb\3\2\2\2\33\2\3\4\u00f1"+
		"\u00f9\u00fb\u0101\u0103\u010d\u010f\u0117\u012d\u0136\u0138\u0149\u014b"+
		"\u0158\u015a\u015f\u0161\u0173\u0175\u017b\u017d\u0187\6\4\4\2\b\2\2\4"+
		"\2\2\4\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}