// Generated from ShExMLLexer.g4 by ANTLR 4.7.1

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
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PREFIX=1, SOURCE=2, QUERY=3, ITERATOR=4, FIELD=5, EXPRESSION=6, UNION=7, 
		JOIN=8, MATCHER=9, AS=10, MATCHING=11, QUERY_SET=12, EXPRESSION_SET=13, 
		LESS_SYMBOL=14, GREATER_SYMBOL=15, BRACKET_LEFT=16, BRACKET_RIGHT=17, 
		PAREN_LEFT=18, PAREN_RIGHT=19, BRACE_LEFT=20, BRACE_RIGHT=21, SEMICOLON=22, 
		DOT=23, AT=24, ADD=25, COMMA=26, QUOTE=27, STRING_OR_VAR=28, URI_VAR=29, 
		STRINGOPERATOR=30, COMMENT=31, WS=32, URL=33, JSONPATH=34, XMLPATH=35, 
		QUERY_PART=36, GREATER_SYMBOL_QUERY=37, WS_QUERY=38, LESS_SYMBOL_QUERY=39, 
		STRING_OR_VAR_QUERY=40, URI_VAR_QUERY=41, WS_DECLARATION=42;
	public static final int
		QUERY_CONTENT=1, DECLARATION_CONTENT=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "QUERY_CONTENT", "DECLARATION_CONTENT"
	};

	public static final String[] ruleNames = {
		"PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "EXPRESSION", "UNION", 
		"JOIN", "MATCHER", "AS", "MATCHING", "QUERY_SET", "EXPRESSION_SET", "LESS_SYMBOL", 
		"GREATER_SYMBOL", "BRACKET_LEFT", "BRACKET_RIGHT", "PAREN_LEFT", "PAREN_RIGHT", 
		"BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "AT", "ADD", "COMMA", 
		"QUOTE", "STRING_OR_VAR", "URI_VAR", "STRINGOPERATOR", "COMMENT", "WS", 
		"URL", "JSONPATH", "XMLPATH", "QUERY_PART", "GREATER_SYMBOL_QUERY", "WS_QUERY", 
		"LESS_SYMBOL_QUERY", "STRING_OR_VAR_QUERY", "URI_VAR_QUERY", "WS_DECLARATION", 
		"LETTER", "DIGIT", "ALLOWED_CHARACTERS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'PREFIX'", "'SOURCE'", "'QUERY'", "'ITERATOR'", "'FIELD'", "'EXPRESSION'", 
		"'UNION'", "'JOIN'", "'MATCHER'", "'AS'", "'MATCHING'", "'QUERY_SET'", 
		"'EXPRESSION_SET'", null, null, "'['", "']'", "'('", "')'", "'{'", "'}'", 
		"';'", "'.'", "'@'", "'+'", "','", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", "EXPRESSION", 
		"UNION", "JOIN", "MATCHER", "AS", "MATCHING", "QUERY_SET", "EXPRESSION_SET", 
		"LESS_SYMBOL", "GREATER_SYMBOL", "BRACKET_LEFT", "BRACKET_RIGHT", "PAREN_LEFT", 
		"PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", "DOT", "AT", 
		"ADD", "COMMA", "QUOTE", "STRING_OR_VAR", "URI_VAR", "STRINGOPERATOR", 
		"COMMENT", "WS", "URL", "JSONPATH", "XMLPATH", "QUERY_PART", "GREATER_SYMBOL_QUERY", 
		"WS_QUERY", "LESS_SYMBOL_QUERY", "STRING_OR_VAR_QUERY", "URI_VAR_QUERY", 
		"WS_DECLARATION"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u017f\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\35\3\35\7\35\u00ee\n\35\f\35\16\35\u00f1\13\35\3\36\3\36\3\36"+
		"\7\36\u00f6\n\36\f\36\16\36\u00f9\13\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\6\37\u0101\n\37\r\37\16\37\u0102\3\37\3\37\3 \3 \7 \u0109\n \f \16 \u010c"+
		"\13 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\5\"\u0121\n\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u012a\n\"\f\"\16\""+
		"\u012d\13\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\6#\u013d\n#\r#\16"+
		"#\u013e\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\6$\u014c\n$\r$\16$\u014d\3%\3"+
		"%\3%\6%\u0153\n%\r%\16%\u0154\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3("+
		"\3)\3)\3)\3)\7)\u0167\n)\f)\16)\u016a\13)\3*\3*\3*\7*\u016f\n*\f*\16*"+
		"\u0172\13*\3*\3*\3+\3+\3+\3+\3,\3,\3-\3-\3.\3.\2\2/\5\3\7\4\t\5\13\6\r"+
		"\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)"+
		"\25+\26-\27/\30\61\31\63\32\65\33\67\349\35;\36=\37? A!C\"E#G$I%K&M\'"+
		"O(Q)S*U+W,Y\2[\2]\2\5\2\3\4\7\4\2\f\f\17\17\5\2\13\f\17\17\"\"\t\2C\\"+
		"c|\u00e3\u00e3\u00eb\u00eb\u00ef\u00ef\u00f5\u00f5\u00fc\u00fc\3\2\62"+
		";\n\2%(*,.\61<<??AB]]_a\2\u0197\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2"+
		"\3E\3\2\2\2\3G\3\2\2\2\3I\3\2\2\2\3K\3\2\2\2\3M\3\2\2\2\3O\3\2\2\2\4Q"+
		"\3\2\2\2\4S\3\2\2\2\4U\3\2\2\2\4W\3\2\2\2\5_\3\2\2\2\7h\3\2\2\2\tq\3\2"+
		"\2\2\13w\3\2\2\2\r\u0082\3\2\2\2\17\u008a\3\2\2\2\21\u0095\3\2\2\2\23"+
		"\u009b\3\2\2\2\25\u00a0\3\2\2\2\27\u00a8\3\2\2\2\31\u00ab\3\2\2\2\33\u00b4"+
		"\3\2\2\2\35\u00be\3\2\2\2\37\u00cd\3\2\2\2!\u00cf\3\2\2\2#\u00d1\3\2\2"+
		"\2%\u00d3\3\2\2\2\'\u00d5\3\2\2\2)\u00d7\3\2\2\2+\u00d9\3\2\2\2-\u00db"+
		"\3\2\2\2/\u00dd\3\2\2\2\61\u00df\3\2\2\2\63\u00e1\3\2\2\2\65\u00e3\3\2"+
		"\2\2\67\u00e5\3\2\2\29\u00e7\3\2\2\2;\u00e9\3\2\2\2=\u00f7\3\2\2\2?\u00fc"+
		"\3\2\2\2A\u0106\3\2\2\2C\u010f\3\2\2\2E\u0120\3\2\2\2G\u012e\3\2\2\2I"+
		"\u0140\3\2\2\2K\u0152\3\2\2\2M\u0156\3\2\2\2O\u015a\3\2\2\2Q\u015e\3\2"+
		"\2\2S\u0162\3\2\2\2U\u0170\3\2\2\2W\u0175\3\2\2\2Y\u0179\3\2\2\2[\u017b"+
		"\3\2\2\2]\u017d\3\2\2\2_`\7R\2\2`a\7T\2\2ab\7G\2\2bc\7H\2\2cd\7K\2\2d"+
		"e\7Z\2\2ef\3\2\2\2fg\b\2\2\2g\6\3\2\2\2hi\7U\2\2ij\7Q\2\2jk\7W\2\2kl\7"+
		"T\2\2lm\7E\2\2mn\7G\2\2no\3\2\2\2op\b\3\2\2p\b\3\2\2\2qr\7S\2\2rs\7W\2"+
		"\2st\7G\2\2tu\7T\2\2uv\7[\2\2v\n\3\2\2\2wx\7K\2\2xy\7V\2\2yz\7G\2\2z{"+
		"\7T\2\2{|\7C\2\2|}\7V\2\2}~\7Q\2\2~\177\7T\2\2\177\u0080\3\2\2\2\u0080"+
		"\u0081\b\5\2\2\u0081\f\3\2\2\2\u0082\u0083\7H\2\2\u0083\u0084\7K\2\2\u0084"+
		"\u0085\7G\2\2\u0085\u0086\7N\2\2\u0086\u0087\7F\2\2\u0087\u0088\3\2\2"+
		"\2\u0088\u0089\b\6\2\2\u0089\16\3\2\2\2\u008a\u008b\7G\2\2\u008b\u008c"+
		"\7Z\2\2\u008c\u008d\7R\2\2\u008d\u008e\7T\2\2\u008e\u008f\7G\2\2\u008f"+
		"\u0090\7U\2\2\u0090\u0091\7U\2\2\u0091\u0092\7K\2\2\u0092\u0093\7Q\2\2"+
		"\u0093\u0094\7P\2\2\u0094\20\3\2\2\2\u0095\u0096\7W\2\2\u0096\u0097\7"+
		"P\2\2\u0097\u0098\7K\2\2\u0098\u0099\7Q\2\2\u0099\u009a\7P\2\2\u009a\22"+
		"\3\2\2\2\u009b\u009c\7L\2\2\u009c\u009d\7Q\2\2\u009d\u009e\7K\2\2\u009e"+
		"\u009f\7P\2\2\u009f\24\3\2\2\2\u00a0\u00a1\7O\2\2\u00a1\u00a2\7C\2\2\u00a2"+
		"\u00a3\7V\2\2\u00a3\u00a4\7E\2\2\u00a4\u00a5\7J\2\2\u00a5\u00a6\7G\2\2"+
		"\u00a6\u00a7\7T\2\2\u00a7\26\3\2\2\2\u00a8\u00a9\7C\2\2\u00a9\u00aa\7"+
		"U\2\2\u00aa\30\3\2\2\2\u00ab\u00ac\7O\2\2\u00ac\u00ad\7C\2\2\u00ad\u00ae"+
		"\7V\2\2\u00ae\u00af\7E\2\2\u00af\u00b0\7J\2\2\u00b0\u00b1\7K\2\2\u00b1"+
		"\u00b2\7P\2\2\u00b2\u00b3\7I\2\2\u00b3\32\3\2\2\2\u00b4\u00b5\7S\2\2\u00b5"+
		"\u00b6\7W\2\2\u00b6\u00b7\7G\2\2\u00b7\u00b8\7T\2\2\u00b8\u00b9\7[\2\2"+
		"\u00b9\u00ba\7a\2\2\u00ba\u00bb\7U\2\2\u00bb\u00bc\7G\2\2\u00bc\u00bd"+
		"\7V\2\2\u00bd\34\3\2\2\2\u00be\u00bf\7G\2\2\u00bf\u00c0\7Z\2\2\u00c0\u00c1"+
		"\7R\2\2\u00c1\u00c2\7T\2\2\u00c2\u00c3\7G\2\2\u00c3\u00c4\7U\2\2\u00c4"+
		"\u00c5\7U\2\2\u00c5\u00c6\7K\2\2\u00c6\u00c7\7Q\2\2\u00c7\u00c8\7P\2\2"+
		"\u00c8\u00c9\7a\2\2\u00c9\u00ca\7U\2\2\u00ca\u00cb\7G\2\2\u00cb\u00cc"+
		"\7V\2\2\u00cc\36\3\2\2\2\u00cd\u00ce\7>\2\2\u00ce \3\2\2\2\u00cf\u00d0"+
		"\7@\2\2\u00d0\"\3\2\2\2\u00d1\u00d2\7]\2\2\u00d2$\3\2\2\2\u00d3\u00d4"+
		"\7_\2\2\u00d4&\3\2\2\2\u00d5\u00d6\7*\2\2\u00d6(\3\2\2\2\u00d7\u00d8\7"+
		"+\2\2\u00d8*\3\2\2\2\u00d9\u00da\7}\2\2\u00da,\3\2\2\2\u00db\u00dc\7\177"+
		"\2\2\u00dc.\3\2\2\2\u00dd\u00de\7=\2\2\u00de\60\3\2\2\2\u00df\u00e0\7"+
		"\60\2\2\u00e0\62\3\2\2\2\u00e1\u00e2\7B\2\2\u00e2\64\3\2\2\2\u00e3\u00e4"+
		"\7-\2\2\u00e4\66\3\2\2\2\u00e5\u00e6\7.\2\2\u00e68\3\2\2\2\u00e7\u00e8"+
		"\7$\2\2\u00e8:\3\2\2\2\u00e9\u00ef\5Y,\2\u00ea\u00ee\5Y,\2\u00eb\u00ee"+
		"\5[-\2\u00ec\u00ee\7a\2\2\u00ed\u00ea\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0<\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f6\5Y,\2\u00f3\u00f6"+
		"\5[-\2\u00f4\u00f6\7a\2\2\u00f5\u00f2\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5"+
		"\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2"+
		"\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\7<\2\2\u00fb"+
		">\3\2\2\2\u00fc\u0100\7$\2\2\u00fd\u0101\5Y,\2\u00fe\u0101\5[-\2\u00ff"+
		"\u0101\5].\2\u0100\u00fd\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2"+
		"\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0104"+
		"\3\2\2\2\u0104\u0105\7$\2\2\u0105@\3\2\2\2\u0106\u010a\7%\2\2\u0107\u0109"+
		"\n\2\2\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a"+
		"\u010b\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e\b "+
		"\3\2\u010eB\3\2\2\2\u010f\u0110\t\3\2\2\u0110\u0111\3\2\2\2\u0111\u0112"+
		"\b!\3\2\u0112D\3\2\2\2\u0113\u0114\7j\2\2\u0114\u0115\7v\2\2\u0115\u0116"+
		"\7v\2\2\u0116\u0121\7r\2\2\u0117\u0118\7j\2\2\u0118\u0119\7v\2\2\u0119"+
		"\u011a\7v\2\2\u011a\u011b\7r\2\2\u011b\u0121\7u\2\2\u011c\u011d\7h\2\2"+
		"\u011d\u011e\7k\2\2\u011e\u011f\7n\2\2\u011f\u0121\7g\2\2\u0120\u0113"+
		"\3\2\2\2\u0120\u0117\3\2\2\2\u0120\u011c\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\7<\2\2\u0123\u0124\7\61\2\2\u0124\u0125\7\61\2\2\u0125\u012b\3"+
		"\2\2\2\u0126\u012a\5Y,\2\u0127\u012a\5[-\2\u0128\u012a\5].\2\u0129\u0126"+
		"\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012cF\3\2\2\2\u012d\u012b\3\2\2\2"+
		"\u012e\u012f\7l\2\2\u012f\u0130\7u\2\2\u0130\u0131\7q\2\2\u0131\u0132"+
		"\7p\2\2\u0132\u0133\7r\2\2\u0133\u0134\7c\2\2\u0134\u0135\7v\2\2\u0135"+
		"\u0136\7j\2\2\u0136\u0137\7<\2\2\u0137\u0138\7\"\2\2\u0138\u013c\3\2\2"+
		"\2\u0139\u013d\5Y,\2\u013a\u013d\5[-\2\u013b\u013d\5].\2\u013c\u0139\3"+
		"\2\2\2\u013c\u013a\3\2\2\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013fH\3\2\2\2\u0140\u0141\7z\2\2\u0141"+
		"\u0142\7r\2\2\u0142\u0143\7c\2\2\u0143\u0144\7v\2\2\u0144\u0145\7j\2\2"+
		"\u0145\u0146\7<\2\2\u0146\u0147\7\"\2\2\u0147\u014b\3\2\2\2\u0148\u014c"+
		"\5Y,\2\u0149\u014c\5[-\2\u014a\u014c\5].\2\u014b\u0148\3\2\2\2\u014b\u0149"+
		"\3\2\2\2\u014b\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014b\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014eJ\3\2\2\2\u014f\u0153\5Y,\2\u0150\u0153\5[-\2\u0151"+
		"\u0153\5].\2\u0152\u014f\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0151\3\2\2"+
		"\2\u0153\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155L"+
		"\3\2\2\2\u0156\u0157\7@\2\2\u0157\u0158\3\2\2\2\u0158\u0159\b&\4\2\u0159"+
		"N\3\2\2\2\u015a\u015b\t\3\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b\'\3\2"+
		"\u015dP\3\2\2\2\u015e\u015f\7>\2\2\u015f\u0160\3\2\2\2\u0160\u0161\b("+
		"\5\2\u0161R\3\2\2\2\u0162\u0168\5Y,\2\u0163\u0167\5Y,\2\u0164\u0167\5"+
		"[-\2\u0165\u0167\7a\2\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2"+
		"\2\2\u0169T\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016f\5Y,\2\u016c\u016f"+
		"\5[-\2\u016d\u016f\7a\2\2\u016e\u016b\3\2\2\2\u016e\u016c\3\2\2\2\u016e"+
		"\u016d\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2"+
		"\2\2\u0171\u0173\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0174\7<\2\2\u0174"+
		"V\3\2\2\2\u0175\u0176\t\3\2\2\u0176\u0177\3\2\2\2\u0177\u0178\b+\3\2\u0178"+
		"X\3\2\2\2\u0179\u017a\t\4\2\2\u017aZ\3\2\2\2\u017b\u017c\t\5\2\2\u017c"+
		"\\\3\2\2\2\u017d\u017e\t\6\2\2\u017e^\3\2\2\2\31\2\3\4\u00ed\u00ef\u00f5"+
		"\u00f7\u0100\u0102\u010a\u0120\u0129\u012b\u013c\u013e\u014b\u014d\u0152"+
		"\u0154\u0166\u0168\u016e\u0170\6\4\4\2\b\2\2\4\2\2\4\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}