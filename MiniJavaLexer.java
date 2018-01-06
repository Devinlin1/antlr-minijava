// Generated from MiniJava.g4 by ANTLR 4.7.1

	import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, SL_COMMENT=4, LEFT_BRACE=5, RIGHT_BRACE=6, RELATION_OP=7, 
		LOGIC_OP=8, ADD_OP=9, MUL_OP=10, EXTENDS=11, ID=12, INT=13, WS=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "SL_COMMENT", "LEFT_BRACE", "RIGHT_BRACE", "RELATION_OP", 
		"LOGIC_OP", "ADD_OP", "MUL_OP", "EXTENDS", "ID", "INT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'['", "']'", null, "'{'", "'}'", null, null, null, null, 
		"'extends'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "SL_COMMENT", "LEFT_BRACE", "RIGHT_BRACE", "RELATION_OP", 
		"LOGIC_OP", "ADD_OP", "MUL_OP", "EXTENDS", "ID", "INT", "WS"
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


	public MiniJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20j\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\5\3\5\7\5.\n\5\f\5\16\5\61\13\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bD\n\b\3\t\3\t\3"+
		"\t\3\t\5\tJ\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\7\rZ\n\r\f\r\16\r]\13\r\3\16\6\16`\n\16\r\16\16\16a\3\17\6\17e\n"+
		"\17\r\17\16\17f\3\17\3\17\3/\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\3\2\t\4\2>>@@\4\2--//\4\2,,\61\61\5\2"+
		"C\\aac|\6\2\62;C\\aac|\3\2\62;\5\2\13\f\17\17\"\"\2r\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5%\3\2\2\2\7\'\3\2\2\2\t)\3\2\2\2\13"+
		"\66\3\2\2\2\r8\3\2\2\2\17C\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2"+
		"\27O\3\2\2\2\31W\3\2\2\2\33_\3\2\2\2\35d\3\2\2\2\37 \7e\2\2 !\7n\2\2!"+
		"\"\7c\2\2\"#\7u\2\2#$\7u\2\2$\4\3\2\2\2%&\7]\2\2&\6\3\2\2\2\'(\7_\2\2"+
		"(\b\3\2\2\2)*\7\61\2\2*+\7\61\2\2+/\3\2\2\2,.\13\2\2\2-,\3\2\2\2.\61\3"+
		"\2\2\2/\60\3\2\2\2/-\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\f\2\2\63"+
		"\64\3\2\2\2\64\65\b\5\2\2\65\n\3\2\2\2\66\67\7}\2\2\67\f\3\2\2\289\7\177"+
		"\2\29\16\3\2\2\2:D\t\2\2\2;<\7>\2\2<D\7?\2\2=>\7@\2\2>D\7?\2\2?@\7?\2"+
		"\2@D\7?\2\2AB\7#\2\2BD\7?\2\2C:\3\2\2\2C;\3\2\2\2C=\3\2\2\2C?\3\2\2\2"+
		"CA\3\2\2\2D\20\3\2\2\2EF\7(\2\2FJ\7(\2\2GH\7~\2\2HJ\7~\2\2IE\3\2\2\2I"+
		"G\3\2\2\2J\22\3\2\2\2KL\t\3\2\2L\24\3\2\2\2MN\t\4\2\2N\26\3\2\2\2OP\7"+
		"g\2\2PQ\7z\2\2QR\7v\2\2RS\7g\2\2ST\7p\2\2TU\7f\2\2UV\7u\2\2V\30\3\2\2"+
		"\2W[\t\5\2\2XZ\t\6\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\32\3"+
		"\2\2\2][\3\2\2\2^`\t\7\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\34"+
		"\3\2\2\2ce\t\b\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2h"+
		"i\b\17\2\2i\36\3\2\2\2\t\2/CI[af\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}