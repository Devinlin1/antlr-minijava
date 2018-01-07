// Generated from MiniJava.g4 by ANTLR 4.7.1

	import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		ASSIGN_OP=25, SEMICOLON=26, SL_COMMENT=27, LEFT_BRACE=28, RIGHT_BRACE=29, 
		LEFT_PARA=30, RIGHT_PARA=31, RELATION_OP=32, LOGIC_OP=33, ADD_OP=34, MUL_OP=35, 
		EXTENDS=36, ID=37, INT=38, WS=39;
	public static final int
		RULE_prog = 0, RULE_class_decl = 1, RULE_class_head_name = 2, RULE_var_decl = 3, 
		RULE_method_decl = 4, RULE_para_decl = 5, RULE_func_type = 6, RULE_var_type = 7, 
		RULE_basic_type = 8, RULE_array_type = 9, RULE_class_body_start = 10, 
		RULE_class_body_end = 11, RULE_stat = 12, RULE_expr_list = 13, RULE_expr = 14, 
		RULE_array_decl = 15;
	public static final String[] ruleNames = {
		"prog", "class_decl", "class_head_name", "var_decl", "method_decl", "para_decl", 
		"func_type", "var_type", "basic_type", "array_type", "class_body_start", 
		"class_body_end", "stat", "expr_list", "expr", "array_decl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'public'", "'protected'", "'private'", "'static'", "'class'", "','", 
		"'void'", "'int'", "'boolean'", "'['", "']'", "'if'", "'else'", "'while'", 
		"'System.out.println'", "'='", "'.'", "'length'", "'new'", "'!'", "'true'", 
		"'false'", "'this'", "'[expr]'", null, "';'", null, "'{'", "'}'", "'('", 
		"')'", null, null, null, null, "'extends'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "ASSIGN_OP", "SEMICOLON", "SL_COMMENT", "LEFT_BRACE", "RIGHT_BRACE", 
		"LEFT_PARA", "RIGHT_PARA", "RELATION_OP", "LOGIC_OP", "ADD_OP", "MUL_OP", 
		"EXTENDS", "ID", "INT", "WS"
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

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		//判断某个类名是否已经存在
		public static boolean isExists(ProgContext prog, String class_name){
			boolean flag = false;
			List<Class_declContext> class_list = prog.class_list;
			for(Class_declContext e:class_list)	{
				if (e.name.equals(class_name)){
					flag = true;
					break;				
				}			 
			}
			return flag;	
		}

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public Class_declContext class_decl;
		public List<Class_declContext> class_list = new ArrayList<Class_declContext>();
		public List<Class_declContext> class_decl() {
			return getRuleContexts(Class_declContext.class);
		}
		public Class_declContext class_decl(int i) {
			return getRuleContext(Class_declContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				((ProgContext)_localctx).class_decl = class_decl();
				((ProgContext)_localctx).class_list.add(((ProgContext)_localctx).class_decl);
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
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

	public static class Class_declContext extends ParserRuleContext {
		public String name;
		public Var_declContext var_decl;
		public List<Var_declContext> var_list = new ArrayList<Var_declContext>();
		public Method_declContext method_decl;
		public List<Method_declContext> func_list = new ArrayList<Method_declContext>();
		public Class_head_nameContext class_head_name() {
			return getRuleContext(Class_head_nameContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniJavaParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniJavaParser.SEMICOLON, i);
		}
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<Method_declContext> method_decl() {
			return getRuleContexts(Method_declContext.class);
		}
		public Method_declContext method_decl(int i) {
			return getRuleContext(Method_declContext.class,i);
		}
		public Class_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClass_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClass_decl(this);
		}
	}

	public final Class_declContext class_decl() throws RecognitionException {
		Class_declContext _localctx = new Class_declContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_decl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			class_head_name();
			setState(38);
			match(LEFT_BRACE);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) {
						{
						setState(39);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
					}

					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__3) {
						{
						setState(42);
						match(T__3);
						}
					}

					setState(45);
					((Class_declContext)_localctx).var_decl = var_decl();
					((Class_declContext)_localctx).var_list.add(((Class_declContext)_localctx).var_decl);
					setState(46);
					match(SEMICOLON);
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << ID))) != 0)) {
				{
				{
				setState(53);
				((Class_declContext)_localctx).method_decl = method_decl();
				((Class_declContext)_localctx).func_list.add(((Class_declContext)_localctx).method_decl);
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(RIGHT_BRACE);
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

	public static class Class_head_nameContext extends ParserRuleContext {
		public Token class_name;
		public Token parent_name;
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public TerminalNode EXTENDS() { return getToken(MiniJavaParser.EXTENDS, 0); }
		public Class_head_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_head_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClass_head_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClass_head_name(this);
		}
	}

	public final Class_head_nameContext class_head_name() throws RecognitionException {
		Class_head_nameContext _localctx = new Class_head_nameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_head_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__4);
			setState(62);
			((Class_head_nameContext)_localctx).class_name = match(ID);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(63);
				match(EXTENDS);
				setState(64);
				((Class_head_nameContext)_localctx).parent_name = match(ID);
				}
			}


					Class_declContext parent =(Class_declContext) (_localctx.getParent());
					parent.name = (((Class_head_nameContext)_localctx).class_name!=null?((Class_head_nameContext)_localctx).class_name.getText():null);
					
					ProgContext prog =(ProgContext) (parent.getParent());
					
					if (MiniJavaParser.isExists(prog,parent.name))
						System.out.println("class name: " + parent.name + " is refined " + "at line " 
								+ (((Class_head_nameContext)_localctx).class_name!=null?((Class_head_nameContext)_localctx).class_name.getLine():0) + ":" + (((Class_head_nameContext)_localctx).class_name!=null?((Class_head_nameContext)_localctx).class_name.getCharPositionInLine():0)
							);
					else
						System.out.println("add new class name:" + _localctx.name + " to class name list");	
				
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

	public static class Var_declContext extends ParserRuleContext {
		public String type;
			String name;
		public Var_typeContext var_type;
		public Token ID;
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			((Var_declContext)_localctx).var_type = var_type();
			setState(70);
			((Var_declContext)_localctx).ID = match(ID);

					_localctx.type = (((Var_declContext)_localctx).var_type!=null?_input.getText(((Var_declContext)_localctx).var_type.start,((Var_declContext)_localctx).var_type.stop):null);
					_localctx.name = (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null);
					
					ParserRuleContext parent =_localctx.getParent();
					if (parent instanceof Class_declContext) {  //是类成员变量
						Class_declContext c =(Class_declContext)(parent);
						List<Var_declContext> var_list = c.var_list;
						
						//判断是否已经有同名成员变量存在
						boolean flag = true;
						for(Var_declContext e: var_list) {
							if (e.name.equals((((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null)))
							{
								flag = false;
								System.out.println("var " + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null) + " is refined " + "at line " 
								+ (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getLine():0) + ":" + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getCharPositionInLine():0)
								);
								break;	
							}
						}
						if (flag) {
							System.out.println("add new member var: " + _localctx.name + " successful");
						}
					}
					else if (parent instanceof Para_declContext)
					{ 
						//如果是函数参数定义或者变量定义,要判断是否已经有同名参数存在
						
						//向上定位到函数父节点
						while (!(parent instanceof Method_declContext) ){
							parent = parent.getParent();
						}
						
						Method_declContext c =(Method_declContext)parent;
						List<Para_declContext> para_list = c.para_list;
						
						//判断是否已经有同名参数存在
						boolean flag = true;
						for(Para_declContext e: para_list) {
							ParaDeclContext t = (ParaDeclContext)e;
							Var_declContext v = t.var;
							if (v.name.equals((((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null)))
							{
								flag = false;
								System.out.println("para " + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null) + " is refined " + "at line " 
								+ (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getLine():0) + ":" + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getCharPositionInLine():0)
								);
								break;	
							}
						}
						
						if (flag) {
							//System.out.println("add new par: " + _localctx.name +" in function " + c.name + " successful");
						}	
					}
					else if (parent instanceof Method_declContext){  //如果是函数中的局部变量 
						Method_declContext c =(Method_declContext)parent;
						List<Var_declContext> var_list = c.var_list;
						
						//判断是否有同名变量存在
						boolean flag = true;
						for(Var_declContext e: var_list) {
							if (e.name.equals((((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null)))
							{
								flag = false;
								System.out.println("var " + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null) + " is refined " + "at line " 
								+ (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getLine():0) + ":" + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getCharPositionInLine():0)
								);
								break;	
							}
						}
						if (flag)
						{
							List<Para_declContext> para_list = c.para_list;
						
							//判断是否已经有同名参数存在
							for(Para_declContext e: para_list) {
								ParaDeclContext t = (ParaDeclContext)e;
								Var_declContext v = t.var;
								if (v.name.equals((((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null)))
								{
									flag = false;
									//System.out.println("para " + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null) + " is refined " + "at line "+ (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getLine():0) + ":" + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getCharPositionInLine():0));
									break;	
								}
							}
						}
						
						if (flag) {
							//System.out.println("add new var: " + _localctx.name +" in function " + c.name + " successful");
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

	public static class Method_declContext extends ParserRuleContext {
		public String name;     
			String type;
		public Func_typeContext func_type;
		public Token ID;
		public Para_declContext para_decl;
		public List<Para_declContext> para_list = new ArrayList<Para_declContext>();
		public Var_declContext var_decl;
		public List<Var_declContext> var_list = new ArrayList<Var_declContext>();
		public StatContext stat;
		public List<StatContext> stat_list = new ArrayList<StatContext>();
		public Func_typeContext func_type() {
			return getRuleContext(Func_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode LEFT_PARA() { return getToken(MiniJavaParser.LEFT_PARA, 0); }
		public TerminalNode RIGHT_PARA() { return getToken(MiniJavaParser.RIGHT_PARA, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniJavaParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniJavaParser.SEMICOLON, i);
		}
		public List<Para_declContext> para_decl() {
			return getRuleContexts(Para_declContext.class);
		}
		public Para_declContext para_decl(int i) {
			return getRuleContext(Para_declContext.class,i);
		}
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethod_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethod_decl(this);
		}
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_method_decl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) {
				{
				setState(73);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(76);
				match(T__3);
				}
			}

			setState(79);
			((Method_declContext)_localctx).func_type = func_type();
			setState(80);
			((Method_declContext)_localctx).ID = match(ID);
			setState(81);
			match(LEFT_PARA);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << ID))) != 0)) {
				{
				setState(82);
				((Method_declContext)_localctx).para_decl = para_decl();
				((Method_declContext)_localctx).para_list.add(((Method_declContext)_localctx).para_decl);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(83);
					match(T__5);
					setState(84);
					((Method_declContext)_localctx).para_decl = para_decl();
					((Method_declContext)_localctx).para_list.add(((Method_declContext)_localctx).para_decl);
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(92);
			match(RIGHT_PARA);
			setState(93);
			match(LEFT_BRACE);
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94);
					((Method_declContext)_localctx).var_decl = var_decl();
					((Method_declContext)_localctx).var_list.add(((Method_declContext)_localctx).var_decl);
					setState(95);
					match(SEMICOLON);
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << LEFT_BRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(102);
				((Method_declContext)_localctx).stat = stat();
				((Method_declContext)_localctx).stat_list.add(((Method_declContext)_localctx).stat);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(RIGHT_BRACE);

					_localctx.name = (((Method_declContext)_localctx).ID!=null?((Method_declContext)_localctx).ID.getText():null);
					_localctx.type=(((Method_declContext)_localctx).func_type!=null?_input.getText(((Method_declContext)_localctx).func_type.start,((Method_declContext)_localctx).func_type.stop):null);
				
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

	public static class Para_declContext extends ParserRuleContext {
		public Para_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para_decl; }
	 
		public Para_declContext() { }
		public void copyFrom(Para_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParaDeclContext extends Para_declContext {
		public Var_declContext var;
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public ParaDeclContext(Para_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterParaDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitParaDecl(this);
		}
	}

	public final Para_declContext para_decl() throws RecognitionException {
		Para_declContext _localctx = new Para_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_para_decl);
		try {
			_localctx = new ParaDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			((ParaDeclContext)_localctx).var = var_decl();
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

	public static class Func_typeContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Func_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFunc_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFunc_type(this);
		}
	}

	public final Func_typeContext func_type() throws RecognitionException {
		Func_typeContext _localctx = new Func_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_func_type);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(T__6);
				}
				break;
			case T__7:
			case T__8:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				var_type();
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

	public static class Var_typeContext extends ParserRuleContext {
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterVar_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitVar_type(this);
		}
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_type);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				array_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				basic_type();
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

	public static class Basic_typeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public Basic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBasic_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBasic_type(this);
		}
	}

	public final Basic_typeContext basic_type() throws RecognitionException {
		Basic_typeContext _localctx = new Basic_typeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_basic_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << ID))) != 0)) ) {
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

	public static class Array_typeContext extends ParserRuleContext {
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterArray_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitArray_type(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_array_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			basic_type();
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				match(T__9);
				setState(125);
				match(T__10);
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__9 );
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

	public static class Class_body_startContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(MiniJavaParser.LEFT_BRACE, 0); }
		public Class_body_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_body_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClass_body_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClass_body_start(this);
		}
	}

	public final Class_body_startContext class_body_start() throws RecognitionException {
		Class_body_startContext _localctx = new Class_body_startContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_class_body_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(LEFT_BRACE);
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

	public static class Class_body_endContext extends ParserRuleContext {
		public TerminalNode RIGHT_BRACE() { return getToken(MiniJavaParser.RIGHT_BRACE, 0); }
		public Class_body_endContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_body_end; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClass_body_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClass_body_end(this);
		}
	}

	public final Class_body_endContext class_body_end() throws RecognitionException {
		Class_body_endContext _localctx = new Class_body_endContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_class_body_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(RIGHT_BRACE);
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

	public static class StatContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(MiniJavaParser.ASSIGN_OP, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stat);
		int _la;
		try {
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(LEFT_BRACE);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << LEFT_BRACE) | (1L << ID))) != 0)) {
					{
					{
					setState(135);
					stat();
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(RIGHT_BRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142);
				match(T__11);
				setState(143);
				match(LEFT_PARA);
				setState(144);
				expr(0);
				setState(145);
				match(RIGHT_PARA);
				setState(146);
				stat();
				setState(147);
				match(T__12);
				setState(148);
				stat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(T__13);
				setState(151);
				match(LEFT_PARA);
				setState(152);
				expr(0);
				setState(153);
				match(RIGHT_PARA);
				setState(154);
				stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				match(T__14);
				setState(157);
				match(LEFT_PARA);
				setState(158);
				expr(0);
				setState(159);
				match(RIGHT_PARA);
				setState(160);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
				match(ID);
				setState(163);
				match(ASSIGN_OP);
				setState(164);
				expr(0);
				setState(165);
				match(SEMICOLON);

						//辅助语句进行检查,左边的ID必须存在,并且和右边的表达式类型名一致
								
					
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
				match(ID);
				setState(169);
				match(T__9);
				setState(170);
				expr(0);
				setState(171);
				match(T__10);
				setState(172);
				match(T__15);
				setState(173);
				expr(0);
				setState(174);
				match(SEMICOLON);

						
					
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

	public static class Expr_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitExpr_list(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			expr(0);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(180);
				match(T__5);
				setState(181);
				expr(0);
				}
				}
				setState(186);
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

	public static class ExprContext extends ParserRuleContext {
		public String type;
		public ExprContext a;
		public Basic_typeContext basic_type;
		public Array_declContext array_decl;
		public Token ID;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Array_declContext array_decl() {
			return getRuleContext(Array_declContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TerminalNode MUL_OP() { return getToken(MiniJavaParser.MUL_OP, 0); }
		public TerminalNode ADD_OP() { return getToken(MiniJavaParser.ADD_OP, 0); }
		public TerminalNode RELATION_OP() { return getToken(MiniJavaParser.RELATION_OP, 0); }
		public TerminalNode LOGIC_OP() { return getToken(MiniJavaParser.LOGIC_OP, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(188);
				match(LEFT_PARA);
				setState(189);
				((ExprContext)_localctx).a = expr(0);
				setState(190);
				match(RIGHT_PARA);

						((ExprContext)_localctx).type =  ((ExprContext)_localctx).a.type;
					
				}
				break;
			case 2:
				{
				setState(193);
				match(T__18);
				setState(194);
				((ExprContext)_localctx).basic_type = basic_type();
				setState(195);
				((ExprContext)_localctx).array_decl = array_decl();

						((ExprContext)_localctx).type =  (((ExprContext)_localctx).basic_type!=null?_input.getText(((ExprContext)_localctx).basic_type.start,((ExprContext)_localctx).basic_type.stop):null)+(((ExprContext)_localctx).array_decl!=null?_input.getText(((ExprContext)_localctx).array_decl.start,((ExprContext)_localctx).array_decl.stop):null);
					
				}
				break;
			case 3:
				{
				setState(198);
				match(T__18);
				setState(199);
				((ExprContext)_localctx).ID = match(ID);
				setState(200);
				match(LEFT_PARA);
				setState(201);
				match(RIGHT_PARA);

						((ExprContext)_localctx).type =  (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null);
					
				}
				break;
			case 4:
				{
				setState(203);
				match(T__19);
				setState(204);
				expr(10);

						((ExprContext)_localctx).type =  "boolean";
					
				}
				break;
			case 5:
				{
				setState(207);
				match(INT);

						((ExprContext)_localctx).type =  "int";
					
				}
				break;
			case 6:
				{
				setState(209);
				((ExprContext)_localctx).ID = match(ID);

						boolean found =false;
						
					
				}
				break;
			case 7:
				{
				setState(211);
				match(T__20);

						((ExprContext)_localctx).type =  "boolean";
					
				}
				break;
			case 8:
				{
				setState(213);
				match(T__21);

						((ExprContext)_localctx).type =  "boolean";
					
				}
				break;
			case 9:
				{
				setState(215);
				match(T__22);

						//this对象的类型名是所在类的类名
						//((ExprContext)_localctx).type =  "boolean";
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(219);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(220);
						match(MUL_OP);
						setState(221);
						expr(10);

						          		((ExprContext)_localctx).type =  "int";
						          	
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(225);
						match(ADD_OP);
						setState(226);
						expr(9);

						          		((ExprContext)_localctx).type =  "int";
						          	
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(230);
						match(RELATION_OP);
						setState(231);
						expr(8);

						          		((ExprContext)_localctx).type =  "boolean";
						          	
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(235);
						match(LOGIC_OP);
						setState(236);
						expr(7);

						          		((ExprContext)_localctx).type =  "boolean";
						          	
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(240);
						match(T__9);
						setState(241);
						expr(0);
						setState(242);
						match(T__10);

						          		int L=((ExprContext)_localctx).a.type.length();
						          		((ExprContext)_localctx).type =  ((ExprContext)_localctx).a.type.substring(0,L-2);
						          	
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(246);
						match(T__16);
						setState(247);
						match(T__17);

						          		((ExprContext)_localctx).type =  "int";
						          	
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(250);
						matchWildcard();
						setState(251);
						((ExprContext)_localctx).ID = match(ID);
						setState(252);
						match(LEFT_PARA);
						setState(254);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << LEFT_PARA) | (1L << ID) | (1L << INT))) != 0)) {
							{
							setState(253);
							expr_list();
							}
						}

						setState(256);
						match(RIGHT_PARA);

						          		
						          	
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class Array_declContext extends ParserRuleContext {
		public Array_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterArray_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitArray_decl(this);
		}
	}

	public final Array_declContext array_decl() throws RecognitionException {
		Array_declContext _localctx = new Array_declContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_array_decl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(263);
					match(T__23);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(266); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u010f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\6\2$\n"+
		"\2\r\2\16\2%\3\3\3\3\3\3\5\3+\n\3\3\3\5\3.\n\3\3\3\3\3\3\3\7\3\63\n\3"+
		"\f\3\16\3\66\13\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\5\4D\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\5\6M\n\6\3\6\5\6P\n\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\7\6X\n\6\f\6\16\6[\13\6\5\6]\n\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6d\n\6\f\6\16\6g\13\6\3\6\7\6j\n\6\f\6\16\6m\13\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\5\bv\n\b\3\t\3\t\5\tz\n\t\3\n\3\n\3\13\3\13\3\13\6\13\u0081\n"+
		"\13\r\13\16\13\u0082\3\f\3\f\3\r\3\r\3\16\3\16\7\16\u008b\n\16\f\16\16"+
		"\16\u008e\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b4\n\16"+
		"\3\17\3\17\3\17\7\17\u00b9\n\17\f\17\16\17\u00bc\13\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00dc\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0101\n\20\3\20\3\20"+
		"\7\20\u0105\n\20\f\20\16\20\u0108\13\20\3\21\6\21\u010b\n\21\r\21\16\21"+
		"\u010c\3\21\2\3\36\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\4\3\2"+
		"\3\5\4\2\n\13\'\'\2\u0125\2#\3\2\2\2\4\'\3\2\2\2\6?\3\2\2\2\bG\3\2\2\2"+
		"\nL\3\2\2\2\fq\3\2\2\2\16u\3\2\2\2\20y\3\2\2\2\22{\3\2\2\2\24}\3\2\2\2"+
		"\26\u0084\3\2\2\2\30\u0086\3\2\2\2\32\u00b3\3\2\2\2\34\u00b5\3\2\2\2\36"+
		"\u00db\3\2\2\2 \u010a\3\2\2\2\"$\5\4\3\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2"+
		"\2%&\3\2\2\2&\3\3\2\2\2\'(\5\6\4\2(\64\7\36\2\2)+\t\2\2\2*)\3\2\2\2*+"+
		"\3\2\2\2+-\3\2\2\2,.\7\6\2\2-,\3\2\2\2-.\3\2\2\2./\3\2\2\2/\60\5\b\5\2"+
		"\60\61\7\34\2\2\61\63\3\2\2\2\62*\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2"+
		"\64\65\3\2\2\2\65:\3\2\2\2\66\64\3\2\2\2\679\5\n\6\28\67\3\2\2\29<\3\2"+
		"\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7\37\2\2>\5\3\2\2\2?@\7"+
		"\7\2\2@C\7\'\2\2AB\7&\2\2BD\7\'\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2\2\2EF\b"+
		"\4\1\2F\7\3\2\2\2GH\5\20\t\2HI\7\'\2\2IJ\b\5\1\2J\t\3\2\2\2KM\t\2\2\2"+
		"LK\3\2\2\2LM\3\2\2\2MO\3\2\2\2NP\7\6\2\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2"+
		"QR\5\16\b\2RS\7\'\2\2S\\\7 \2\2TY\5\f\7\2UV\7\b\2\2VX\5\f\7\2WU\3\2\2"+
		"\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2\\T\3\2\2\2\\]\3\2"+
		"\2\2]^\3\2\2\2^_\7!\2\2_e\7\36\2\2`a\5\b\5\2ab\7\34\2\2bd\3\2\2\2c`\3"+
		"\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fk\3\2\2\2ge\3\2\2\2hj\5\32\16\2i"+
		"h\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7\37\2\2"+
		"op\b\6\1\2p\13\3\2\2\2qr\5\b\5\2r\r\3\2\2\2sv\7\t\2\2tv\5\20\t\2us\3\2"+
		"\2\2ut\3\2\2\2v\17\3\2\2\2wz\5\24\13\2xz\5\22\n\2yw\3\2\2\2yx\3\2\2\2"+
		"z\21\3\2\2\2{|\t\3\2\2|\23\3\2\2\2}\u0080\5\22\n\2~\177\7\f\2\2\177\u0081"+
		"\7\r\2\2\u0080~\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\25\3\2\2\2\u0084\u0085\7\36\2\2\u0085\27\3\2\2\2"+
		"\u0086\u0087\7\37\2\2\u0087\31\3\2\2\2\u0088\u008c\7\36\2\2\u0089\u008b"+
		"\5\32\16\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2"+
		"\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u00b4"+
		"\7\37\2\2\u0090\u0091\7\16\2\2\u0091\u0092\7 \2\2\u0092\u0093\5\36\20"+
		"\2\u0093\u0094\7!\2\2\u0094\u0095\5\32\16\2\u0095\u0096\7\17\2\2\u0096"+
		"\u0097\5\32\16\2\u0097\u00b4\3\2\2\2\u0098\u0099\7\20\2\2\u0099\u009a"+
		"\7 \2\2\u009a\u009b\5\36\20\2\u009b\u009c\7!\2\2\u009c\u009d\5\32\16\2"+
		"\u009d\u00b4\3\2\2\2\u009e\u009f\7\21\2\2\u009f\u00a0\7 \2\2\u00a0\u00a1"+
		"\5\36\20\2\u00a1\u00a2\7!\2\2\u00a2\u00a3\7\34\2\2\u00a3\u00b4\3\2\2\2"+
		"\u00a4\u00a5\7\'\2\2\u00a5\u00a6\7\33\2\2\u00a6\u00a7\5\36\20\2\u00a7"+
		"\u00a8\7\34\2\2\u00a8\u00a9\b\16\1\2\u00a9\u00b4\3\2\2\2\u00aa\u00ab\7"+
		"\'\2\2\u00ab\u00ac\7\f\2\2\u00ac\u00ad\5\36\20\2\u00ad\u00ae\7\r\2\2\u00ae"+
		"\u00af\7\22\2\2\u00af\u00b0\5\36\20\2\u00b0\u00b1\7\34\2\2\u00b1\u00b2"+
		"\b\16\1\2\u00b2\u00b4\3\2\2\2\u00b3\u0088\3\2\2\2\u00b3\u0090\3\2\2\2"+
		"\u00b3\u0098\3\2\2\2\u00b3\u009e\3\2\2\2\u00b3\u00a4\3\2\2\2\u00b3\u00aa"+
		"\3\2\2\2\u00b4\33\3\2\2\2\u00b5\u00ba\5\36\20\2\u00b6\u00b7\7\b\2\2\u00b7"+
		"\u00b9\5\36\20\2\u00b8\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3"+
		"\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\35\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd"+
		"\u00be\b\20\1\2\u00be\u00bf\7 \2\2\u00bf\u00c0\5\36\20\2\u00c0\u00c1\7"+
		"!\2\2\u00c1\u00c2\b\20\1\2\u00c2\u00dc\3\2\2\2\u00c3\u00c4\7\25\2\2\u00c4"+
		"\u00c5\5\22\n\2\u00c5\u00c6\5 \21\2\u00c6\u00c7\b\20\1\2\u00c7\u00dc\3"+
		"\2\2\2\u00c8\u00c9\7\25\2\2\u00c9\u00ca\7\'\2\2\u00ca\u00cb\7 \2\2\u00cb"+
		"\u00cc\7!\2\2\u00cc\u00dc\b\20\1\2\u00cd\u00ce\7\26\2\2\u00ce\u00cf\5"+
		"\36\20\f\u00cf\u00d0\b\20\1\2\u00d0\u00dc\3\2\2\2\u00d1\u00d2\7(\2\2\u00d2"+
		"\u00dc\b\20\1\2\u00d3\u00d4\7\'\2\2\u00d4\u00dc\b\20\1\2\u00d5\u00d6\7"+
		"\27\2\2\u00d6\u00dc\b\20\1\2\u00d7\u00d8\7\30\2\2\u00d8\u00dc\b\20\1\2"+
		"\u00d9\u00da\7\31\2\2\u00da\u00dc\b\20\1\2\u00db\u00bd\3\2\2\2\u00db\u00c3"+
		"\3\2\2\2\u00db\u00c8\3\2\2\2\u00db\u00cd\3\2\2\2\u00db\u00d1\3\2\2\2\u00db"+
		"\u00d3\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d7\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00dc\u0106\3\2\2\2\u00dd\u00de\f\13\2\2\u00de\u00df\7%\2\2\u00df"+
		"\u00e0\5\36\20\f\u00e0\u00e1\b\20\1\2\u00e1\u0105\3\2\2\2\u00e2\u00e3"+
		"\f\n\2\2\u00e3\u00e4\7$\2\2\u00e4\u00e5\5\36\20\13\u00e5\u00e6\b\20\1"+
		"\2\u00e6\u0105\3\2\2\2\u00e7\u00e8\f\t\2\2\u00e8\u00e9\7\"\2\2\u00e9\u00ea"+
		"\5\36\20\n\u00ea\u00eb\b\20\1\2\u00eb\u0105\3\2\2\2\u00ec\u00ed\f\b\2"+
		"\2\u00ed\u00ee\7#\2\2\u00ee\u00ef\5\36\20\t\u00ef\u00f0\b\20\1\2\u00f0"+
		"\u0105\3\2\2\2\u00f1\u00f2\f\21\2\2\u00f2\u00f3\7\f\2\2\u00f3\u00f4\5"+
		"\36\20\2\u00f4\u00f5\7\r\2\2\u00f5\u00f6\b\20\1\2\u00f6\u0105\3\2\2\2"+
		"\u00f7\u00f8\f\20\2\2\u00f8\u00f9\7\23\2\2\u00f9\u00fa\7\24\2\2\u00fa"+
		"\u0105\b\20\1\2\u00fb\u00fc\f\17\2\2\u00fc\u00fd\13\2\2\2\u00fd\u00fe"+
		"\7\'\2\2\u00fe\u0100\7 \2\2\u00ff\u0101\5\34\17\2\u0100\u00ff\3\2\2\2"+
		"\u0100\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7!\2\2\u0103\u0105"+
		"\b\20\1\2\u0104\u00dd\3\2\2\2\u0104\u00e2\3\2\2\2\u0104\u00e7\3\2\2\2"+
		"\u0104\u00ec\3\2\2\2\u0104\u00f1\3\2\2\2\u0104\u00f7\3\2\2\2\u0104\u00fb"+
		"\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"\37\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010b\7\32\2\2\u010a\u0109\3\2\2"+
		"\2\u010b\u010c\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d!"+
		"\3\2\2\2\31%*-\64:CLOY\\ekuy\u0082\u008c\u00b3\u00ba\u00db\u0100\u0104"+
		"\u0106\u010c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}