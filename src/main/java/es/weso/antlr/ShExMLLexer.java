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
		PREFIX=1, SOURCE=2, QUERY=3, EXPRESSION=4, UNION=5, JOIN=6, LESS_SYMBOL=7, 
		GREATER_SYMBOL=8, DOLLAR=9, BRACKET_LEFT=10, BRACKET_RIGHT=11, BRACE_LEFT=12, 
		BRACE_RIGHT=13, SEMICOLON=14, DOT=15, AT=16, ADD=17, QUOTE=18, VAR=19, 
		NORMAL_VAR=20, URI_VAR=21, JSONPATH=22, XMLPATH=23, URL=24, STRINGOPERATOR=25, 
		WS=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PREFIX", "SOURCE", "QUERY", "EXPRESSION", "UNION", "JOIN", "LESS_SYMBOL", 
		"GREATER_SYMBOL", "DOLLAR", "BRACKET_LEFT", "BRACKET_RIGHT", "BRACE_LEFT", 
		"BRACE_RIGHT", "SEMICOLON", "DOT", "AT", "ADD", "QUOTE", "VAR", "NORMAL_VAR", 
		"URI_VAR", "JSONPATH", "XMLPATH", "URL", "STRINGOPERATOR", "WS", "LETTER", 
		"DIGIT", "ALLOWED_CHARACTERS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'PREFIX'", "'SOURCE'", "'QUERY'", "'EXPRESSION'", "'UNION'", "'JOIN'", 
		"'<'", "'>'", "'$'", "'['", "']'", "'{'", "'}'", "';'", "'.'", "'@'", 
		"'+'", "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PREFIX", "SOURCE", "QUERY", "EXPRESSION", "UNION", "JOIN", "LESS_SYMBOL", 
		"GREATER_SYMBOL", "DOLLAR", "BRACKET_LEFT", "BRACKET_RIGHT", "BRACE_LEFT", 
		"BRACE_RIGHT", "SEMICOLON", "DOT", "AT", "ADD", "QUOTE", "VAR", "NORMAL_VAR", 
		"URI_VAR", "JSONPATH", "XMLPATH", "URL", "STRINGOPERATOR", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00d4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\5\24"+
		"\u0082\n\24\3\25\3\25\3\25\3\25\7\25\u0088\n\25\f\25\16\25\u008b\13\25"+
		"\3\26\3\26\3\26\7\26\u0090\n\26\f\26\16\26\u0093\13\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\7\27\u009b\n\27\f\27\16\27\u009e\13\27\3\30\3\30\7\30"+
		"\u00a2\n\30\f\30\16\30\u00a5\13\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00b4\n\31\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u00bb\n\31\f\31\16\31\u00be\13\31\3\32\3\32\6\32\u00c2\n\32\r\32"+
		"\16\32\u00c3\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3"+
		"\36\3\36\5\36\u00d3\n\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\29\2;\2\3\2\6\5\2\13\f\17\17\"\"\4\2C\\c|\3\2\62"+
		";\n\2\'(*,.\61??AB]]__aa\2\u00df\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\3=\3\2\2\2\5D\3\2\2\2\7K\3\2\2\2\tQ\3\2\2\2\13\\\3\2\2\2\rb\3\2\2\2"+
		"\17g\3\2\2\2\21i\3\2\2\2\23k\3\2\2\2\25m\3\2\2\2\27o\3\2\2\2\31q\3\2\2"+
		"\2\33s\3\2\2\2\35u\3\2\2\2\37w\3\2\2\2!y\3\2\2\2#{\3\2\2\2%}\3\2\2\2\'"+
		"\u0081\3\2\2\2)\u0083\3\2\2\2+\u0091\3\2\2\2-\u0096\3\2\2\2/\u009f\3\2"+
		"\2\2\61\u00b3\3\2\2\2\63\u00bf\3\2\2\2\65\u00c7\3\2\2\2\67\u00cb\3\2\2"+
		"\29\u00cd\3\2\2\2;\u00d2\3\2\2\2=>\7R\2\2>?\7T\2\2?@\7G\2\2@A\7H\2\2A"+
		"B\7K\2\2BC\7Z\2\2C\4\3\2\2\2DE\7U\2\2EF\7Q\2\2FG\7W\2\2GH\7T\2\2HI\7E"+
		"\2\2IJ\7G\2\2J\6\3\2\2\2KL\7S\2\2LM\7W\2\2MN\7G\2\2NO\7T\2\2OP\7[\2\2"+
		"P\b\3\2\2\2QR\7G\2\2RS\7Z\2\2ST\7R\2\2TU\7T\2\2UV\7G\2\2VW\7U\2\2WX\7"+
		"U\2\2XY\7K\2\2YZ\7Q\2\2Z[\7P\2\2[\n\3\2\2\2\\]\7W\2\2]^\7P\2\2^_\7K\2"+
		"\2_`\7Q\2\2`a\7P\2\2a\f\3\2\2\2bc\7L\2\2cd\7Q\2\2de\7K\2\2ef\7P\2\2f\16"+
		"\3\2\2\2gh\7>\2\2h\20\3\2\2\2ij\7@\2\2j\22\3\2\2\2kl\7&\2\2l\24\3\2\2"+
		"\2mn\7]\2\2n\26\3\2\2\2op\7_\2\2p\30\3\2\2\2qr\7}\2\2r\32\3\2\2\2st\7"+
		"\177\2\2t\34\3\2\2\2uv\7=\2\2v\36\3\2\2\2wx\7\60\2\2x \3\2\2\2yz\7B\2"+
		"\2z\"\3\2\2\2{|\7-\2\2|$\3\2\2\2}~\7$\2\2~&\3\2\2\2\177\u0082\5)\25\2"+
		"\u0080\u0082\5+\26\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082(\3\2"+
		"\2\2\u0083\u0089\5\67\34\2\u0084\u0088\5\67\34\2\u0085\u0088\59\35\2\u0086"+
		"\u0088\7a\2\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2"+
		"\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a"+
		"*\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u0090\5\67\34\2\u008d\u0090\59\35"+
		"\2\u008e\u0090\7a\2\2\u008f\u008c\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u008e"+
		"\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7<\2\2\u0095,\3\2\2\2\u0096"+
		"\u0097\7&\2\2\u0097\u0098\7\60\2\2\u0098\u009c\3\2\2\2\u0099\u009b\5;"+
		"\36\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d.\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a3\7\61\2\2"+
		"\u00a0\u00a2\5;\36\2\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\60\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00a7\7j\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7v\2\2\u00a9\u00b4\7r\2\2"+
		"\u00aa\u00ab\7j\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7v\2\2\u00ad\u00ae"+
		"\7r\2\2\u00ae\u00b4\7u\2\2\u00af\u00b0\7h\2\2\u00b0\u00b1\7k\2\2\u00b1"+
		"\u00b2\7n\2\2\u00b2\u00b4\7g\2\2\u00b3\u00a6\3\2\2\2\u00b3\u00aa\3\2\2"+
		"\2\u00b3\u00af\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7<\2\2\u00b6\u00b7"+
		"\7\61\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00bc\3\2\2\2\u00b9\u00bb\5;\36\2"+
		"\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd"+
		"\3\2\2\2\u00bd\62\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c1\7$\2\2\u00c0"+
		"\u00c2\5;\36\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7$\2\2\u00c6"+
		"\64\3\2\2\2\u00c7\u00c8\t\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b\33\2"+
		"\2\u00ca\66\3\2\2\2\u00cb\u00cc\t\3\2\2\u00cc8\3\2\2\2\u00cd\u00ce\t\4"+
		"\2\2\u00ce:\3\2\2\2\u00cf\u00d3\5\67\34\2\u00d0\u00d3\59\35\2\u00d1\u00d3"+
		"\t\5\2\2\u00d2\u00cf\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"<\3\2\2\2\16\2\u0081\u0087\u0089\u008f\u0091\u009c\u00a3\u00b3\u00bc\u00c3"+
		"\u00d2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}