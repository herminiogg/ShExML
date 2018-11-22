// Generated from ShExML.g4 by ANTLR 4.7.1

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
		T__0=1, T__1=2, T__2=3, PREFIX=4, SOURCE=5, QUERY=6, ITERATOR=7, FIELD=8, 
		EXPRESSION=9, UNION=10, JOIN=11, MATCHER=12, AS=13, MATCHING=14, QUERY_SET=15, 
		EXPRESSION_SET=16, LESS_SYMBOL=17, GREATER_SYMBOL=18, BRACKET_LEFT=19, 
		BRACKET_RIGHT=20, PAREN_LEFT=21, PAREN_RIGHT=22, BRACE_LEFT=23, BRACE_RIGHT=24, 
		SEMICOLON=25, DOT=26, AT=27, ADD=28, COMMA=29, QUOTE=30, STRING_OR_VAR=31, 
		URI_VAR=32, URL=33, STRINGOPERATOR=34, JSONPATH=35, XMLPATH=36, COMMENT=37, 
		WS=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", 
		"EXPRESSION", "UNION", "JOIN", "MATCHER", "AS", "MATCHING", "QUERY_SET", 
		"EXPRESSION_SET", "LESS_SYMBOL", "GREATER_SYMBOL", "BRACKET_LEFT", "BRACKET_RIGHT", 
		"PAREN_LEFT", "PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", 
		"DOT", "AT", "ADD", "COMMA", "QUOTE", "STRING_OR_VAR", "URI_VAR", "URL", 
		"STRINGOPERATOR", "JSONPATH", "XMLPATH", "COMMENT", "WS", "LETTER", "DIGIT", 
		"ALLOWED_CHARACTERS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'..'", "'^'", "'/'", "'PREFIX'", "'SOURCE'", "'QUERY'", "'ITERATOR'", 
		"'FIELD'", "'EXPRESSION'", "'UNION'", "'JOIN'", "'MATCHER'", "'AS'", "'MATCHING'", 
		"'QUERY_SET'", "'EXPRESSION_SET'", "'<'", "'>'", "'['", "']'", "'('", 
		"')'", "'{'", "'}'", "';'", "'.'", "'@'", "'+'", "','", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "PREFIX", "SOURCE", "QUERY", "ITERATOR", "FIELD", 
		"EXPRESSION", "UNION", "JOIN", "MATCHER", "AS", "MATCHING", "QUERY_SET", 
		"EXPRESSION_SET", "LESS_SYMBOL", "GREATER_SYMBOL", "BRACKET_LEFT", "BRACKET_RIGHT", 
		"PAREN_LEFT", "PAREN_RIGHT", "BRACE_LEFT", "BRACE_RIGHT", "SEMICOLON", 
		"DOT", "AT", "ADD", "COMMA", "QUOTE", "STRING_OR_VAR", "URI_VAR", "URL", 
		"STRINGOPERATOR", "JSONPATH", "XMLPATH", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "ShExML.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u014a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \7 \u00e3"+
		"\n \f \16 \u00e6\13 \3!\3!\3!\7!\u00eb\n!\f!\16!\u00ee\13!\3!\3!\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00ff\n\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\7\"\u0108\n\"\f\"\16\"\u010b\13\"\3#\3#\3#\3#\6#\u0111"+
		"\n#\r#\16#\u0112\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\6$\u0125"+
		"\n$\r$\16$\u0126\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\6%\u0134\n%\r%\16%\u0135"+
		"\3&\3&\7&\u013a\n&\f&\16&\u013d\13&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3)\3)"+
		"\3*\3*\2\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O\2Q\2S\2\3\2\7\4\2\f\f\17\17\5\2\13\f"+
		"\17\17\"\"\t\2C\\c|\u00e3\u00e3\u00eb\u00eb\u00ef\u00ef\u00f5\u00f5\u00fc"+
		"\u00fc\3\2\62;\13\2%(*,.\61<<??AB]]__aa\2\u015b\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\3U\3\2\2\2\5X\3\2\2\2\7Z\3\2\2\2\t\\\3\2\2\2\13c\3\2\2\2"+
		"\rj\3\2\2\2\17p\3\2\2\2\21y\3\2\2\2\23\177\3\2\2\2\25\u008a\3\2\2\2\27"+
		"\u0090\3\2\2\2\31\u0095\3\2\2\2\33\u009d\3\2\2\2\35\u00a0\3\2\2\2\37\u00a9"+
		"\3\2\2\2!\u00b3\3\2\2\2#\u00c2\3\2\2\2%\u00c4\3\2\2\2\'\u00c6\3\2\2\2"+
		")\u00c8\3\2\2\2+\u00ca\3\2\2\2-\u00cc\3\2\2\2/\u00ce\3\2\2\2\61\u00d0"+
		"\3\2\2\2\63\u00d2\3\2\2\2\65\u00d4\3\2\2\2\67\u00d6\3\2\2\29\u00d8\3\2"+
		"\2\2;\u00da\3\2\2\2=\u00dc\3\2\2\2?\u00de\3\2\2\2A\u00ec\3\2\2\2C\u00fe"+
		"\3\2\2\2E\u010c\3\2\2\2G\u0116\3\2\2\2I\u0128\3\2\2\2K\u0137\3\2\2\2M"+
		"\u0140\3\2\2\2O\u0144\3\2\2\2Q\u0146\3\2\2\2S\u0148\3\2\2\2UV\7\60\2\2"+
		"VW\7\60\2\2W\4\3\2\2\2XY\7`\2\2Y\6\3\2\2\2Z[\7\61\2\2[\b\3\2\2\2\\]\7"+
		"R\2\2]^\7T\2\2^_\7G\2\2_`\7H\2\2`a\7K\2\2ab\7Z\2\2b\n\3\2\2\2cd\7U\2\2"+
		"de\7Q\2\2ef\7W\2\2fg\7T\2\2gh\7E\2\2hi\7G\2\2i\f\3\2\2\2jk\7S\2\2kl\7"+
		"W\2\2lm\7G\2\2mn\7T\2\2no\7[\2\2o\16\3\2\2\2pq\7K\2\2qr\7V\2\2rs\7G\2"+
		"\2st\7T\2\2tu\7C\2\2uv\7V\2\2vw\7Q\2\2wx\7T\2\2x\20\3\2\2\2yz\7H\2\2z"+
		"{\7K\2\2{|\7G\2\2|}\7N\2\2}~\7F\2\2~\22\3\2\2\2\177\u0080\7G\2\2\u0080"+
		"\u0081\7Z\2\2\u0081\u0082\7R\2\2\u0082\u0083\7T\2\2\u0083\u0084\7G\2\2"+
		"\u0084\u0085\7U\2\2\u0085\u0086\7U\2\2\u0086\u0087\7K\2\2\u0087\u0088"+
		"\7Q\2\2\u0088\u0089\7P\2\2\u0089\24\3\2\2\2\u008a\u008b\7W\2\2\u008b\u008c"+
		"\7P\2\2\u008c\u008d\7K\2\2\u008d\u008e\7Q\2\2\u008e\u008f\7P\2\2\u008f"+
		"\26\3\2\2\2\u0090\u0091\7L\2\2\u0091\u0092\7Q\2\2\u0092\u0093\7K\2\2\u0093"+
		"\u0094\7P\2\2\u0094\30\3\2\2\2\u0095\u0096\7O\2\2\u0096\u0097\7C\2\2\u0097"+
		"\u0098\7V\2\2\u0098\u0099\7E\2\2\u0099\u009a\7J\2\2\u009a\u009b\7G\2\2"+
		"\u009b\u009c\7T\2\2\u009c\32\3\2\2\2\u009d\u009e\7C\2\2\u009e\u009f\7"+
		"U\2\2\u009f\34\3\2\2\2\u00a0\u00a1\7O\2\2\u00a1\u00a2\7C\2\2\u00a2\u00a3"+
		"\7V\2\2\u00a3\u00a4\7E\2\2\u00a4\u00a5\7J\2\2\u00a5\u00a6\7K\2\2\u00a6"+
		"\u00a7\7P\2\2\u00a7\u00a8\7I\2\2\u00a8\36\3\2\2\2\u00a9\u00aa\7S\2\2\u00aa"+
		"\u00ab\7W\2\2\u00ab\u00ac\7G\2\2\u00ac\u00ad\7T\2\2\u00ad\u00ae\7[\2\2"+
		"\u00ae\u00af\7a\2\2\u00af\u00b0\7U\2\2\u00b0\u00b1\7G\2\2\u00b1\u00b2"+
		"\7V\2\2\u00b2 \3\2\2\2\u00b3\u00b4\7G\2\2\u00b4\u00b5\7Z\2\2\u00b5\u00b6"+
		"\7R\2\2\u00b6\u00b7\7T\2\2\u00b7\u00b8\7G\2\2\u00b8\u00b9\7U\2\2\u00b9"+
		"\u00ba\7U\2\2\u00ba\u00bb\7K\2\2\u00bb\u00bc\7Q\2\2\u00bc\u00bd\7P\2\2"+
		"\u00bd\u00be\7a\2\2\u00be\u00bf\7U\2\2\u00bf\u00c0\7G\2\2\u00c0\u00c1"+
		"\7V\2\2\u00c1\"\3\2\2\2\u00c2\u00c3\7>\2\2\u00c3$\3\2\2\2\u00c4\u00c5"+
		"\7@\2\2\u00c5&\3\2\2\2\u00c6\u00c7\7]\2\2\u00c7(\3\2\2\2\u00c8\u00c9\7"+
		"_\2\2\u00c9*\3\2\2\2\u00ca\u00cb\7*\2\2\u00cb,\3\2\2\2\u00cc\u00cd\7+"+
		"\2\2\u00cd.\3\2\2\2\u00ce\u00cf\7}\2\2\u00cf\60\3\2\2\2\u00d0\u00d1\7"+
		"\177\2\2\u00d1\62\3\2\2\2\u00d2\u00d3\7=\2\2\u00d3\64\3\2\2\2\u00d4\u00d5"+
		"\7\60\2\2\u00d5\66\3\2\2\2\u00d6\u00d7\7B\2\2\u00d78\3\2\2\2\u00d8\u00d9"+
		"\7-\2\2\u00d9:\3\2\2\2\u00da\u00db\7.\2\2\u00db<\3\2\2\2\u00dc\u00dd\7"+
		"$\2\2\u00dd>\3\2\2\2\u00de\u00e4\5O(\2\u00df\u00e3\5O(\2\u00e0\u00e3\5"+
		"Q)\2\u00e1\u00e3\7a\2\2\u00e2\u00df\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5@\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00eb\5O(\2\u00e8\u00eb"+
		"\5Q)\2\u00e9\u00eb\7a\2\2\u00ea\u00e7\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7<\2\2\u00f0"+
		"B\3\2\2\2\u00f1\u00f2\7j\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7v\2\2\u00f4"+
		"\u00ff\7r\2\2\u00f5\u00f6\7j\2\2\u00f6\u00f7\7v\2\2\u00f7\u00f8\7v\2\2"+
		"\u00f8\u00f9\7r\2\2\u00f9\u00ff\7u\2\2\u00fa\u00fb\7h\2\2\u00fb\u00fc"+
		"\7k\2\2\u00fc\u00fd\7n\2\2\u00fd\u00ff\7g\2\2\u00fe\u00f1\3\2\2\2\u00fe"+
		"\u00f5\3\2\2\2\u00fe\u00fa\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\7<"+
		"\2\2\u0101\u0102\7\61\2\2\u0102\u0103\7\61\2\2\u0103\u0109\3\2\2\2\u0104"+
		"\u0108\5O(\2\u0105\u0108\5Q)\2\u0106\u0108\5S*\2\u0107\u0104\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010aD\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u0110"+
		"\7$\2\2\u010d\u0111\5O(\2\u010e\u0111\5Q)\2\u010f\u0111\5S*\2\u0110\u010d"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\7$"+
		"\2\2\u0115F\3\2\2\2\u0116\u0117\7l\2\2\u0117\u0118\7u\2\2\u0118\u0119"+
		"\7q\2\2\u0119\u011a\7p\2\2\u011a\u011b\7r\2\2\u011b\u011c\7c\2\2\u011c"+
		"\u011d\7v\2\2\u011d\u011e\7j\2\2\u011e\u011f\7<\2\2\u011f\u0120\7\"\2"+
		"\2\u0120\u0124\3\2\2\2\u0121\u0125\5O(\2\u0122\u0125\5Q)\2\u0123\u0125"+
		"\5S*\2\u0124\u0121\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0123\3\2\2\2\u0125"+
		"\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127H\3\2\2\2"+
		"\u0128\u0129\7z\2\2\u0129\u012a\7r\2\2\u012a\u012b\7c\2\2\u012b\u012c"+
		"\7v\2\2\u012c\u012d\7j\2\2\u012d\u012e\7<\2\2\u012e\u012f\7\"\2\2\u012f"+
		"\u0133\3\2\2\2\u0130\u0134\5O(\2\u0131\u0134\5Q)\2\u0132\u0134\5S*\2\u0133"+
		"\u0130\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2"+
		"\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136J\3\2\2\2\u0137\u013b"+
		"\7%\2\2\u0138\u013a\n\2\2\2\u0139\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2"+
		"\2\2\u013e\u013f\b&\2\2\u013fL\3\2\2\2\u0140\u0141\t\3\2\2\u0141\u0142"+
		"\3\2\2\2\u0142\u0143\b\'\2\2\u0143N\3\2\2\2\u0144\u0145\t\4\2\2\u0145"+
		"P\3\2\2\2\u0146\u0147\t\5\2\2\u0147R\3\2\2\2\u0148\u0149\t\6\2\2\u0149"+
		"T\3\2\2\2\21\2\u00e2\u00e4\u00ea\u00ec\u00fe\u0107\u0109\u0110\u0112\u0124"+
		"\u0126\u0133\u0135\u013b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}