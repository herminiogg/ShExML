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
		DOT=23, AT=24, ADD=25, COMMA=26, QUOTE=27, A=28, STRING_OR_VAR=29, URI_VAR=30, 
		STRINGOPERATOR=31, COMMENT=32, WS=33, URL=34, JSONPATH=35, XMLPATH=36, 
		QUERY_PART=37, GREATER_SYMBOL_QUERY=38, WS_QUERY=39, LESS_SYMBOL_QUERY=40, 
		STRING_OR_VAR_QUERY=41, URI_VAR_QUERY=42, WS_DECLARATION=43;
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
			"QUOTE", "A", "STRING_OR_VAR", "URI_VAR", "STRINGOPERATOR", "COMMENT", 
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
			"';'", "'.'", "'@'", "'+'", "','", "'\"'", "'a'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "EXPRESSION", 
			"UNION", "JOIN", "MATCHER", "AS", "MATCHING", "QUERY_SET", "EXPRESSION_SET", 
			"LESS_SYMBOL", "GREATER_SYMBOL", "BRACKET_LEFT", "BRACKET_RIGHT", "PAREN_LEFT", 
			"PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "AT", 
			"ADD", "COMMA", "QUOTE", "A", "STRING_OR_VAR", "URI_VAR", "STRINGOPERATOR", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0183\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00f2\n\36\f\36\16\36\u00f5\13\36"+
		"\3\37\3\37\3\37\7\37\u00fa\n\37\f\37\16\37\u00fd\13\37\3\37\3\37\3 \3"+
		" \3 \3 \6 \u0105\n \r \16 \u0106\3 \3 \3!\3!\7!\u010d\n!\f!\16!\u0110"+
		"\13!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u0125"+
		"\n#\3#\3#\3#\3#\3#\3#\3#\7#\u012e\n#\f#\16#\u0131\13#\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\6$\u0141\n$\r$\16$\u0142\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\6%\u0150\n%\r%\16%\u0151\3&\3&\3&\6&\u0157\n&\r&\16&\u0158"+
		"\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\7*\u016b\n*\f*\16"+
		"*\u016e\13*\3+\3+\3+\7+\u0173\n+\f+\16+\u0176\13+\3+\3+\3,\3,\3,\3,\3"+
		"-\3-\3.\3.\3/\3/\2\2\60\5\3\7\4\t\5\13\6\r\7\17\b\21\t\23\n\25\13\27\f"+
		"\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27/\30\61\31\63\32\65"+
		"\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[\2]\2_\2\5\2\3\4\7"+
		"\4\2\f\f\17\17\5\2\13\f\17\17\"\"\n\2C\\c|\u00a3\u00a3\u00ab\u00ab\u00af"+
		"\u00af\u00b5\u00b5\u00bc\u00bc\u00c5\u00c5\3\2\62;\t\2%(*,.\61<<??AB]"+
		"a\2\u019b\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\3"+
		"I\3\2\2\2\3K\3\2\2\2\3M\3\2\2\2\3O\3\2\2\2\3Q\3\2\2\2\4S\3\2\2\2\4U\3"+
		"\2\2\2\4W\3\2\2\2\4Y\3\2\2\2\5a\3\2\2\2\7j\3\2\2\2\ts\3\2\2\2\13y\3\2"+
		"\2\2\r\u0084\3\2\2\2\17\u008c\3\2\2\2\21\u0097\3\2\2\2\23\u009d\3\2\2"+
		"\2\25\u00a2\3\2\2\2\27\u00aa\3\2\2\2\31\u00ad\3\2\2\2\33\u00b6\3\2\2\2"+
		"\35\u00c0\3\2\2\2\37\u00cf\3\2\2\2!\u00d1\3\2\2\2#\u00d3\3\2\2\2%\u00d5"+
		"\3\2\2\2\'\u00d7\3\2\2\2)\u00d9\3\2\2\2+\u00db\3\2\2\2-\u00dd\3\2\2\2"+
		"/\u00df\3\2\2\2\61\u00e1\3\2\2\2\63\u00e3\3\2\2\2\65\u00e5\3\2\2\2\67"+
		"\u00e7\3\2\2\29\u00e9\3\2\2\2;\u00eb\3\2\2\2=\u00ed\3\2\2\2?\u00fb\3\2"+
		"\2\2A\u0100\3\2\2\2C\u010a\3\2\2\2E\u0113\3\2\2\2G\u0124\3\2\2\2I\u0132"+
		"\3\2\2\2K\u0144\3\2\2\2M\u0156\3\2\2\2O\u015a\3\2\2\2Q\u015e\3\2\2\2S"+
		"\u0162\3\2\2\2U\u0166\3\2\2\2W\u0174\3\2\2\2Y\u0179\3\2\2\2[\u017d\3\2"+
		"\2\2]\u017f\3\2\2\2_\u0181\3\2\2\2ab\7R\2\2bc\7T\2\2cd\7G\2\2de\7H\2\2"+
		"ef\7K\2\2fg\7Z\2\2gh\3\2\2\2hi\b\2\2\2i\6\3\2\2\2jk\7U\2\2kl\7Q\2\2lm"+
		"\7W\2\2mn\7T\2\2no\7E\2\2op\7G\2\2pq\3\2\2\2qr\b\3\2\2r\b\3\2\2\2st\7"+
		"S\2\2tu\7W\2\2uv\7G\2\2vw\7T\2\2wx\7[\2\2x\n\3\2\2\2yz\7K\2\2z{\7V\2\2"+
		"{|\7G\2\2|}\7T\2\2}~\7C\2\2~\177\7V\2\2\177\u0080\7Q\2\2\u0080\u0081\7"+
		"T\2\2\u0081\u0082\3\2\2\2\u0082\u0083\b\5\2\2\u0083\f\3\2\2\2\u0084\u0085"+
		"\7H\2\2\u0085\u0086\7K\2\2\u0086\u0087\7G\2\2\u0087\u0088\7N\2\2\u0088"+
		"\u0089\7F\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\6\2\2\u008b\16\3\2\2\2"+
		"\u008c\u008d\7G\2\2\u008d\u008e\7Z\2\2\u008e\u008f\7R\2\2\u008f\u0090"+
		"\7T\2\2\u0090\u0091\7G\2\2\u0091\u0092\7U\2\2\u0092\u0093\7U\2\2\u0093"+
		"\u0094\7K\2\2\u0094\u0095\7Q\2\2\u0095\u0096\7P\2\2\u0096\20\3\2\2\2\u0097"+
		"\u0098\7W\2\2\u0098\u0099\7P\2\2\u0099\u009a\7K\2\2\u009a\u009b\7Q\2\2"+
		"\u009b\u009c\7P\2\2\u009c\22\3\2\2\2\u009d\u009e\7L\2\2\u009e\u009f\7"+
		"Q\2\2\u009f\u00a0\7K\2\2\u00a0\u00a1\7P\2\2\u00a1\24\3\2\2\2\u00a2\u00a3"+
		"\7O\2\2\u00a3\u00a4\7C\2\2\u00a4\u00a5\7V\2\2\u00a5\u00a6\7E\2\2\u00a6"+
		"\u00a7\7J\2\2\u00a7\u00a8\7G\2\2\u00a8\u00a9\7T\2\2\u00a9\26\3\2\2\2\u00aa"+
		"\u00ab\7C\2\2\u00ab\u00ac\7U\2\2\u00ac\30\3\2\2\2\u00ad\u00ae\7O\2\2\u00ae"+
		"\u00af\7C\2\2\u00af\u00b0\7V\2\2\u00b0\u00b1\7E\2\2\u00b1\u00b2\7J\2\2"+
		"\u00b2\u00b3\7K\2\2\u00b3\u00b4\7P\2\2\u00b4\u00b5\7I\2\2\u00b5\32\3\2"+
		"\2\2\u00b6\u00b7\7S\2\2\u00b7\u00b8\7W\2\2\u00b8\u00b9\7G\2\2\u00b9\u00ba"+
		"\7T\2\2\u00ba\u00bb\7[\2\2\u00bb\u00bc\7a\2\2\u00bc\u00bd\7U\2\2\u00bd"+
		"\u00be\7G\2\2\u00be\u00bf\7V\2\2\u00bf\34\3\2\2\2\u00c0\u00c1\7G\2\2\u00c1"+
		"\u00c2\7Z\2\2\u00c2\u00c3\7R\2\2\u00c3\u00c4\7T\2\2\u00c4\u00c5\7G\2\2"+
		"\u00c5\u00c6\7U\2\2\u00c6\u00c7\7U\2\2\u00c7\u00c8\7K\2\2\u00c8\u00c9"+
		"\7Q\2\2\u00c9\u00ca\7P\2\2\u00ca\u00cb\7a\2\2\u00cb\u00cc\7U\2\2\u00cc"+
		"\u00cd\7G\2\2\u00cd\u00ce\7V\2\2\u00ce\36\3\2\2\2\u00cf\u00d0\7>\2\2\u00d0"+
		" \3\2\2\2\u00d1\u00d2\7@\2\2\u00d2\"\3\2\2\2\u00d3\u00d4\7]\2\2\u00d4"+
		"$\3\2\2\2\u00d5\u00d6\7_\2\2\u00d6&\3\2\2\2\u00d7\u00d8\7*\2\2\u00d8("+
		"\3\2\2\2\u00d9\u00da\7+\2\2\u00da*\3\2\2\2\u00db\u00dc\7}\2\2\u00dc,\3"+
		"\2\2\2\u00dd\u00de\7\177\2\2\u00de.\3\2\2\2\u00df\u00e0\7=\2\2\u00e0\60"+
		"\3\2\2\2\u00e1\u00e2\7\60\2\2\u00e2\62\3\2\2\2\u00e3\u00e4\7B\2\2\u00e4"+
		"\64\3\2\2\2\u00e5\u00e6\7-\2\2\u00e6\66\3\2\2\2\u00e7\u00e8\7.\2\2\u00e8"+
		"8\3\2\2\2\u00e9\u00ea\7$\2\2\u00ea:\3\2\2\2\u00eb\u00ec\7c\2\2\u00ec<"+
		"\3\2\2\2\u00ed\u00f3\5[-\2\u00ee\u00f2\5[-\2\u00ef\u00f2\5].\2\u00f0\u00f2"+
		"\7a\2\2\u00f1\u00ee\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2"+
		"\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4>\3\2\2\2"+
		"\u00f5\u00f3\3\2\2\2\u00f6\u00fa\5[-\2\u00f7\u00fa\5].\2\u00f8\u00fa\7"+
		"a\2\2\u00f9\u00f6\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00f8\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\7<\2\2\u00ff@\3\2\2\2\u0100\u0104"+
		"\7$\2\2\u0101\u0105\5[-\2\u0102\u0105\5].\2\u0103\u0105\5_/\2\u0104\u0101"+
		"\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\7$"+
		"\2\2\u0109B\3\2\2\2\u010a\u010e\7%\2\2\u010b\u010d\n\2\2\2\u010c\u010b"+
		"\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\b!\3\2\u0112D\3\2\2\2\u0113"+
		"\u0114\t\3\2\2\u0114\u0115\3\2\2\2\u0115\u0116\b\"\3\2\u0116F\3\2\2\2"+
		"\u0117\u0118\7j\2\2\u0118\u0119\7v\2\2\u0119\u011a\7v\2\2\u011a\u0125"+
		"\7r\2\2\u011b\u011c\7j\2\2\u011c\u011d\7v\2\2\u011d\u011e\7v\2\2\u011e"+
		"\u011f\7r\2\2\u011f\u0125\7u\2\2\u0120\u0121\7h\2\2\u0121\u0122\7k\2\2"+
		"\u0122\u0123\7n\2\2\u0123\u0125\7g\2\2\u0124\u0117\3\2\2\2\u0124\u011b"+
		"\3\2\2\2\u0124\u0120\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\7<\2\2\u0127"+
		"\u0128\7\61\2\2\u0128\u0129\7\61\2\2\u0129\u012f\3\2\2\2\u012a\u012e\5"+
		"[-\2\u012b\u012e\5].\2\u012c\u012e\5_/\2\u012d\u012a\3\2\2\2\u012d\u012b"+
		"\3\2\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130H\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\7l\2\2\u0133"+
		"\u0134\7u\2\2\u0134\u0135\7q\2\2\u0135\u0136\7p\2\2\u0136\u0137\7r\2\2"+
		"\u0137\u0138\7c\2\2\u0138\u0139\7v\2\2\u0139\u013a\7j\2\2\u013a\u013b"+
		"\7<\2\2\u013b\u013c\7\"\2\2\u013c\u0140\3\2\2\2\u013d\u0141\5[-\2\u013e"+
		"\u0141\5].\2\u013f\u0141\5_/\2\u0140\u013d\3\2\2\2\u0140\u013e\3\2\2\2"+
		"\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143"+
		"\3\2\2\2\u0143J\3\2\2\2\u0144\u0145\7z\2\2\u0145\u0146\7r\2\2\u0146\u0147"+
		"\7c\2\2\u0147\u0148\7v\2\2\u0148\u0149\7j\2\2\u0149\u014a\7<\2\2\u014a"+
		"\u014b\7\"\2\2\u014b\u014f\3\2\2\2\u014c\u0150\5[-\2\u014d\u0150\5].\2"+
		"\u014e\u0150\5_/\2\u014f\u014c\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u014e"+
		"\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"L\3\2\2\2\u0153\u0157\5[-\2\u0154\u0157\5].\2\u0155\u0157\5_/\2\u0156"+
		"\u0153\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157\u0158\3\2"+
		"\2\2\u0158\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159N\3\2\2\2\u015a\u015b"+
		"\7@\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b\'\4\2\u015dP\3\2\2\2\u015e\u015f"+
		"\t\3\2\2\u015f\u0160\3\2\2\2\u0160\u0161\b(\3\2\u0161R\3\2\2\2\u0162\u0163"+
		"\7>\2\2\u0163\u0164\3\2\2\2\u0164\u0165\b)\5\2\u0165T\3\2\2\2\u0166\u016c"+
		"\5[-\2\u0167\u016b\5[-\2\u0168\u016b\5].\2\u0169\u016b\7a\2\2\u016a\u0167"+
		"\3\2\2\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016dV\3\2\2\2\u016e\u016c\3\2\2\2"+
		"\u016f\u0173\5[-\2\u0170\u0173\5].\2\u0171\u0173\7a\2\2\u0172\u016f\3"+
		"\2\2\2\u0172\u0170\3\2\2\2\u0172\u0171\3\2\2\2\u0173\u0176\3\2\2\2\u0174"+
		"\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2\2\2\u0176\u0174\3\2"+
		"\2\2\u0177\u0178\7<\2\2\u0178X\3\2\2\2\u0179\u017a\t\3\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u017c\b,\3\2\u017cZ\3\2\2\2\u017d\u017e\t\4\2\2\u017e\\"+
		"\3\2\2\2\u017f\u0180\t\5\2\2\u0180^\3\2\2\2\u0181\u0182\t\6\2\2\u0182"+
		"`\3\2\2\2\31\2\3\4\u00f1\u00f3\u00f9\u00fb\u0104\u0106\u010e\u0124\u012d"+
		"\u012f\u0140\u0142\u014f\u0151\u0156\u0158\u016a\u016c\u0172\u0174\6\4"+
		"\4\2\b\2\2\4\2\2\4\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}