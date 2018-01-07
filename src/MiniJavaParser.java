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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, MEMBER_OP=23, ASSIGN_OP=24, 
		SEMICOLON=25, SL_COMMENT=26, LEFT_BRACE=27, RIGHT_BRACE=28, LEFT_PARA=29, 
		RIGHT_PARA=30, RELATION_OP=31, LOGIC_OP=32, ADD_OP=33, MUL_OP=34, EXTENDS=35, 
		ID=36, INT=37, WS=38;
	public static final int
		RULE_prog = 0, RULE_class_decl = 1, RULE_class_head_name = 2, RULE_var_decl = 3, 
		RULE_method_decl = 4, RULE_func_head_name = 5, RULE_para_decl = 6, RULE_func_type = 7, 
		RULE_var_type = 8, RULE_basic_type = 9, RULE_array_type = 10, RULE_class_body_start = 11, 
		RULE_class_body_end = 12, RULE_stat = 13, RULE_expr_list = 14, RULE_expr = 15, 
		RULE_array_index = 16;
	public static final String[] ruleNames = {
		"prog", "class_decl", "class_head_name", "var_decl", "method_decl", "func_head_name", 
		"para_decl", "func_type", "var_type", "basic_type", "array_type", "class_body_start", 
		"class_body_end", "stat", "expr_list", "expr", "array_index"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'public'", "'protected'", "'private'", "'static'", "'class'", "','", 
		"'void'", "'int'", "'boolean'", "'['", "']'", "'return'", "'if'", "'else'", 
		"'while'", "'System.out.println'", "'length'", "'new'", "'!'", "'true'", 
		"'false'", "'this'", "'.'", null, "';'", null, "'{'", "'}'", "'('", "')'", 
		null, null, null, null, "'extends'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "MEMBER_OP", 
		"ASSIGN_OP", "SEMICOLON", "SL_COMMENT", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_PARA", 
		"RIGHT_PARA", "RELATION_OP", "LOGIC_OP", "ADD_OP", "MUL_OP", "EXTENDS", 
		"ID", "INT", "WS"
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


		public enum Scope{MEMBER,FUNC};   //变量的作用域
		
		public static boolean isArrayType(String a)	{
			return (a!= null && a.indexOf("[]") != -1);
		}
		
		public static void checkArrayType(String a,Token op)	{
			if(!isArrayType(a)) {
				System.out.println("type mismatched :need an array name at line " +
					op.getLine() +":" + op.getCharPositionInLine()
				);
			}
		}
		
		public static boolean isRequireType(String a,String type){
			return (a!=null && a.equals(type));
		}
		
		public static void checkType(String a,Token op,String type){
			if (!(isRequireType(a,type))){
				System.out.println("type mismatched :need " + type+ " at line " +
					op.getLine() +":" + op.getCharPositionInLine()
				);
			}
		}

		//检查两个操作数的类型是否符合要求	
		public static void checkType(String a,String b, Token op,String type)
		{
			if (a== null || !(a.equals(type))){
				System.out.println("type mismatched in arg1 of expression at line " +
					op.getLine() +":" + op.getCharPositionInLine()
				);
			}
			if (b == null || !(b.equals(type))){
				System.out.println("type mismatched in arg2 of expression at line " +
					op.getLine() +":" + op.getCharPositionInLine()
				);
			}
		}
		
		//判断某个id是否和关键字重合了
		public static boolean isKeyWord(String id)
		{
			List<String> keys = new ArrayList<String>();
			keys.add("int");
			keys.add("boolean");
			keys.add("void");
			keys.add("if");
			keys.add("while");
			keys.add("else");
			keys.add("public");
			keys.add("protected");
			keys.add("default");
			keys.add("private");
			keys.add("extends");
			keys.add("class");
			keys.add("return");
			keys.add("true");
			keys.add("false");
			keys.add("this");
			keys.add("super");
			return keys.contains(id);
		}
		
		//查找某个类对象,如果不存在的话返回NULL
		public static Class_declContext findClass(ProgContext prog, String class_name){
			Class_declContext v =null;
			List<Class_declContext> class_list = prog.class_list;
			for(Class_declContext e:class_list)	{
				if (e.name.equals(class_name)){
					v = e;
					break;				
				}			 
			}
			return v;
		}
		
		public static boolean isClassExists(ProgContext prog, String class_name){
			return findClass(prog, class_name) != null;	
		}
		
		//在类的成员列表里找到某个变量名
		public static Var_declContext findVar(Class_declContext classdecl, String var_name){
			Var_declContext v =null;
			List<Var_declContext> var_list = classdecl.var_list;
			for(Var_declContext e:var_list)	{
				if (e.name.equals(var_name)){
					v = e;
					break;				
				}			 
			}
			return v;
		}
		
		public static boolean isVarExists(Class_declContext obj, String class_name){
			return findVar(obj, class_name) != null;	
		}

		//从某个表达式所在的作用域开始想上查找某个变量名
		public static Var_declContext findVar(ExprContext expr, String var_name){
			Var_declContext v =null;
			ParserRuleContext parent = expr.getParent();
			while (!(parent instanceof Method_declContext)){
				parent = parent.getParent();
			}
			
			Method_declContext func = (Method_declContext)parent;
			v = findVar(func,var_name);
			if (v==null){
				v = findPara(func,var_name);
			}
			if (v==null){
				Class_declContext c=(Class_declContext)(func.getParent());
				v = findVar(c,var_name);
			}
			return v;
		}
			
		//在函数的变量列表里查找某个变量名
		public static Var_declContext findVar(Method_declContext func, String var_name){
			Var_declContext v =null;
			List<Var_declContext> var_list = func.var_list;
			for(Var_declContext e:var_list)	{
				if (e.name.equals(var_name)){
					v = e;
					break;				
				}			 
			}
			return v;
		}
		
		public static boolean isVarExists(Method_declContext func, String var_name){
			return findVar(func,var_name) != null; 
		}
		
		//在函数的参数列表里查找某个变量名
		public static Var_declContext findPara(Method_declContext func, String para_name){
			Var_declContext v =null;
			List<Para_declContext> para_list = func.para_list;
			for(Para_declContext e: para_list) {
					ParaDeclContext t = (ParaDeclContext)e;
					Var_declContext s = t.var;
					if (s.name.equals(para_name)) {
						v = s;
						break;
					}
			}			
			return v;
		}
		
		//判断某个参数名是否已经存在
		public static boolean isParaExists(Method_declContext func, String para_name){
			return findPara(func,para_name) != null; 
		}
		
		//判断两个函数声明是否完全一致,也就是名字和参数列表完全一样
		public static boolean isEqual(Method_declContext fun1,Method_declContext fun2) 
		{
			boolean flag = (fun1.name.equals(fun2.name) && fun1.para_list.size()==fun2.para_list.size());
			if(flag){
				for(int i=0;i<fun1.para_list.size();++i)
				{
					ParaDeclContext t1 = (ParaDeclContext)(fun1.para_list.get(i));
					ParaDeclContext t2 = (ParaDeclContext)(fun2.para_list.get(i));
					
					String type1 = t1.var.type;
					String type2 = t2.var.type;
					if (!(type1.equals(type2)))
					{
						flag = false;
						break;
					}
				}
			}
			return flag;
		}
		
		//判断类中是否已经有相同函数
		public static boolean isFuncExists(Class_declContext obj,Method_declContext fun) 
		{
			boolean flag = false;
			for(Method_declContext e:obj.func_list)
			{
				if (isEqual(e,fun))
				{
					flag =true;
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
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				((ProgContext)_localctx).class_decl = class_decl();
				((ProgContext)_localctx).class_list.add(((ProgContext)_localctx).class_decl);
				}
				}
				setState(37); 
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
		public List<Method_declContext> method_decl() {
			return getRuleContexts(Method_declContext.class);
		}
		public Method_declContext method_decl(int i) {
			return getRuleContext(Method_declContext.class,i);
		}
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
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
			setState(39);
			class_head_name();
			setState(40);
			match(LEFT_BRACE);
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(49);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__0:
					case T__1:
					case T__2:
					case T__3:
						{
						setState(42);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) {
							{
							setState(41);
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

						{
						setState(44);
						match(T__3);
						setState(45);
						((Class_declContext)_localctx).var_decl = var_decl(true,MiniJavaParser.Scope.MEMBER);
						((Class_declContext)_localctx).var_list.add(((Class_declContext)_localctx).var_decl);
						}
						}
						break;
					case T__7:
					case T__8:
					case ID:
						{
						{
						setState(46);
						((Class_declContext)_localctx).var_decl = var_decl(false,MiniJavaParser.Scope.MEMBER);
						((Class_declContext)_localctx).var_list.add(((Class_declContext)_localctx).var_decl);
						}
						setState(47);
						match(SEMICOLON);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << ID))) != 0)) {
				{
				{
				setState(54);
				((Class_declContext)_localctx).method_decl = method_decl();
				((Class_declContext)_localctx).func_list.add(((Class_declContext)_localctx).method_decl);
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
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
			setState(62);
			match(T__4);
			setState(63);
			((Class_head_nameContext)_localctx).class_name = match(ID);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(64);
				match(EXTENDS);
				setState(65);
				((Class_head_nameContext)_localctx).parent_name = match(ID);
				}
			}


					//如果类名已经存在,则给出提示
					Class_declContext parent =(Class_declContext) (_localctx.getParent());
					parent.name = (((Class_head_nameContext)_localctx).class_name!=null?((Class_head_nameContext)_localctx).class_name.getText():null);
					
					ProgContext prog =(ProgContext) (parent.getParent());
					
					if (MiniJavaParser.isClassExists(prog,parent.name))
						System.out.println("class name: " + parent.name + " is refined " + "at line " 
								+ (((Class_head_nameContext)_localctx).class_name!=null?((Class_head_nameContext)_localctx).class_name.getLine():0) + ":" + (((Class_head_nameContext)_localctx).class_name!=null?((Class_head_nameContext)_localctx).class_name.getCharPositionInLine():0)
							);
					else
						System.out.println("add new class name:" + parent.name + " to class name list");	
				
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
		public boolean static_flag;
		public MiniJavaParser.Scope var_scope;
		public String type;
			String name;
			boolean is_static = false; 
			MiniJavaParser.Scope scope;
		public Var_typeContext var_type;
		public Token ID;
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Var_declContext(ParserRuleContext parent, int invokingState, boolean static_flag, MiniJavaParser.Scope var_scope) {
			super(parent, invokingState);
			this.static_flag = static_flag;
			this.var_scope = var_scope;
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

	public final Var_declContext var_decl(boolean static_flag,MiniJavaParser.Scope var_scope) throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState(), static_flag, var_scope);
		enterRule(_localctx, 6, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			((Var_declContext)_localctx).var_type = var_type();
			setState(71);
			((Var_declContext)_localctx).ID = match(ID);

					String var_name = (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null);
					_localctx.type = (((Var_declContext)_localctx).var_type!=null?_input.getText(((Var_declContext)_localctx).var_type.start,((Var_declContext)_localctx).var_type.stop):null);
					_localctx.name = (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null);
					_localctx.scope = _localctx.var_scope;
					_localctx.is_static = _localctx.static_flag;
					
					ParserRuleContext parent = _localctx.getParent();
					if (parent instanceof Class_declContext) {  //是类成员变量
						Class_declContext c =(Class_declContext)(parent);
						Var_declContext var = MiniJavaParser.findVar(c,var_name);
						
						if (var != null && var.is_static == _localctx.static_flag){
							System.out.println("var " + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null) + " is refined " + "at line " 
								+ (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getLine():0) + ":" + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getCharPositionInLine():0)
								);
						}
						else {
							System.out.println("add new member var: " + _localctx.name + 
								" in class " + c.name + " successful"
							);
						}
					}
					else if (parent instanceof Para_declContext)
					{ 
						//如果是函数参数定义
						
						//向上定位到函数父节点
						while (!(parent instanceof Method_declContext) ){
							parent = parent.getParent();
						}
									
						Method_declContext c =(Method_declContext)parent;
						
						if (MiniJavaParser.isParaExists(c,var_name))
						{
							System.out.println("para " + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null)+" in function" + c.name + " is refined " + "at line " 
								+ (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getLine():0) + ":" + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getCharPositionInLine():0)
								);
						}
						else {
							System.out.println("add new par: " + _localctx.name +" in function " + c.name + " successful");
						}	
					}
					
					else if (parent instanceof Method_declContext){  
						//如果是函数中的局部变量
						Method_declContext c = (Method_declContext)parent;
						
						if (MiniJavaParser.isVarExists(c,var_name))
						{
							System.out.println("var " + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null) +" in function" + c.name + " is refined " + "at line " 
								+ (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getLine():0) + ":" + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getCharPositionInLine():0)
							);
						}
						else if (MiniJavaParser.isParaExists(c,var_name))
						{
							System.out.println("var " + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null) +" in function " + c.name 
							 + " has same name with some para " + "at line "+ (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getLine():0) + ":" + (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getCharPositionInLine():0));
						}
						else 
						{
							System.out.println("add new var: " + _localctx.name 
								+" in function " + c.name + " successful"
							);
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
			boolean is_static;
		public Token b;
		public Token LEFT_PARA;
		public Para_declContext para_decl;
		public List<Para_declContext> para_list = new ArrayList<Para_declContext>();
		public Var_declContext var_decl;
		public List<Var_declContext> var_list = new ArrayList<Var_declContext>();
		public StatContext stat;
		public List<StatContext> stat_list = new ArrayList<StatContext>();
		public Func_head_nameContext func_head_name() {
			return getRuleContext(Func_head_nameContext.class,0);
		}
		public TerminalNode LEFT_PARA() { return getToken(MiniJavaParser.LEFT_PARA, 0); }
		public TerminalNode RIGHT_PARA() { return getToken(MiniJavaParser.RIGHT_PARA, 0); }
		public List<Para_declContext> para_decl() {
			return getRuleContexts(Para_declContext.class);
		}
		public Para_declContext para_decl(int i) {
			return getRuleContext(Para_declContext.class,i);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
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
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) {
				{
				setState(74);
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

			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(77);
				((Method_declContext)_localctx).b = match(T__3);
				}
			}

			setState(80);
			func_head_name();
			setState(81);
			((Method_declContext)_localctx).LEFT_PARA = match(LEFT_PARA);
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
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(101);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case T__3:
						{
						{
						setState(94);
						match(T__3);
						setState(95);
						((Method_declContext)_localctx).var_decl = var_decl(true,MiniJavaParser.Scope.FUNC);
						((Method_declContext)_localctx).var_list.add(((Method_declContext)_localctx).var_decl);
						setState(96);
						match(SEMICOLON);
						}
						}
						break;
					case T__7:
					case T__8:
					case ID:
						{
						{
						setState(98);
						((Method_declContext)_localctx).var_decl = var_decl(false,MiniJavaParser.Scope.FUNC);
						((Method_declContext)_localctx).var_list.add(((Method_declContext)_localctx).var_decl);
						setState(99);
						match(SEMICOLON);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << LEFT_BRACE) | (1L << ID))) != 0)) {
				{
				{
				setState(106);
				((Method_declContext)_localctx).stat = stat();
				((Method_declContext)_localctx).stat_list.add(((Method_declContext)_localctx).stat);
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(112);
			match(RIGHT_BRACE);

					_localctx.is_static = ((((Method_declContext)_localctx).b!=null?((Method_declContext)_localctx).b.getText():null)!=null);
					//检查函数是否可以重载
					Class_declContext parent =(Class_declContext) (_localctx.getParent());
					if (MiniJavaParser.isFuncExists(parent,_localctx))
					{
						System.out.println("overload function:" + _localctx.name + " in class "+ parent.name + "failed"
						+ " at line " + (((Method_declContext)_localctx).LEFT_PARA!=null?((Method_declContext)_localctx).LEFT_PARA.getLine():0) + ":" + (((Method_declContext)_localctx).LEFT_PARA!=null?((Method_declContext)_localctx).LEFT_PARA.getCharPositionInLine():0)	
						);
					}
					else {
						System.out.println("add function:" + _localctx.name + " to class " + parent.name + " success");		
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

	public static class Func_head_nameContext extends ParserRuleContext {
		public Func_typeContext func_type;
		public Token ID;
		public Func_typeContext func_type() {
			return getRuleContext(Func_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public Func_head_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_head_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFunc_head_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFunc_head_name(this);
		}
	}

	public final Func_head_nameContext func_head_name() throws RecognitionException {
		Func_head_nameContext _localctx = new Func_head_nameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_func_head_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			((Func_head_nameContext)_localctx).func_type = func_type();
			setState(116);
			((Func_head_nameContext)_localctx).ID = match(ID);

					//记录函数名和返回类型名
					Method_declContext c =(Method_declContext)(_localctx.getParent()); 
					c.name = (((Func_head_nameContext)_localctx).ID!=null?((Func_head_nameContext)_localctx).ID.getText():null);
					c.type = (((Func_head_nameContext)_localctx).func_type!=null?_input.getText(((Func_head_nameContext)_localctx).func_type.start,((Func_head_nameContext)_localctx).func_type.stop):null);
				
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
		enterRule(_localctx, 12, RULE_para_decl);
		try {
			_localctx = new ParaDeclContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			((ParaDeclContext)_localctx).var = var_decl(false,MiniJavaParser.Scope.FUNC);
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
		enterRule(_localctx, 14, RULE_func_type);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(T__6);
				}
				break;
			case T__7:
			case T__8:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
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
		enterRule(_localctx, 16, RULE_var_type);
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				array_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
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
		enterRule(_localctx, 18, RULE_basic_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
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
		enterRule(_localctx, 20, RULE_array_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			basic_type();
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				match(T__9);
				setState(133);
				match(T__10);
				}
				}
				setState(136); 
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
		enterRule(_localctx, 22, RULE_class_body_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
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
		enterRule(_localctx, 24, RULE_class_body_end);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(MiniJavaParser.ASSIGN_OP, 0); }
		public Array_indexContext array_index() {
			return getRuleContext(Array_indexContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_stat);
		int _la;
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(LEFT_BRACE);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << LEFT_BRACE) | (1L << ID))) != 0)) {
					{
					{
					setState(143);
					stat();
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				match(RIGHT_BRACE);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__11);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << LEFT_PARA) | (1L << ID) | (1L << INT))) != 0)) {
					{
					setState(151);
					expr(0);
					}
				}

				setState(154);
				match(SEMICOLON);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				match(T__12);
				setState(156);
				match(LEFT_PARA);
				setState(157);
				expr(0);
				setState(158);
				match(RIGHT_PARA);
				setState(159);
				stat();
				setState(160);
				match(T__13);
				setState(161);
				stat();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				match(T__14);
				setState(164);
				match(LEFT_PARA);
				setState(165);
				expr(0);
				setState(166);
				match(RIGHT_PARA);
				setState(167);
				stat();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 5);
				{
				setState(169);
				match(T__15);
				setState(170);
				match(LEFT_PARA);
				setState(171);
				expr(0);
				setState(172);
				match(RIGHT_PARA);
				setState(173);
				match(SEMICOLON);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(175);
				match(ID);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(176);
					array_index();
					}
				}

				setState(179);
				match(ASSIGN_OP);
				setState(180);
				expr(0);
				setState(181);
				match(SEMICOLON);

						//对辅助语句进行检查,左边的ID必须存在,并且和右边的表达式类型名一致
					
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
		enterRule(_localctx, 28, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			expr(0);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(187);
				match(T__5);
				setState(188);
				expr(0);
				}
				}
				setState(193);
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
		public Array_indexContext array_index;
		public Token ID;
		public Token op;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Array_indexContext array_index() {
			return getRuleContext(Array_indexContext.class,0);
		}
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode MUL_OP() { return getToken(MiniJavaParser.MUL_OP, 0); }
		public TerminalNode ADD_OP() { return getToken(MiniJavaParser.ADD_OP, 0); }
		public TerminalNode RELATION_OP() { return getToken(MiniJavaParser.RELATION_OP, 0); }
		public TerminalNode LOGIC_OP() { return getToken(MiniJavaParser.LOGIC_OP, 0); }
		public TerminalNode MEMBER_OP() { return getToken(MiniJavaParser.MEMBER_OP, 0); }
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(195);
				match(LEFT_PARA);
				setState(196);
				((ExprContext)_localctx).a = expr(0);
				setState(197);
				match(RIGHT_PARA);

						((ExprContext)_localctx).type =  ((ExprContext)_localctx).a.type;
					
				}
				break;
			case 2:
				{
				setState(200);
				match(T__17);
				setState(201);
				((ExprContext)_localctx).basic_type = basic_type();
				setState(202);
				((ExprContext)_localctx).array_index = array_index();

						((ExprContext)_localctx).type =  (((ExprContext)_localctx).basic_type!=null?_input.getText(((ExprContext)_localctx).basic_type.start,((ExprContext)_localctx).basic_type.stop):null)+(((ExprContext)_localctx).array_index!=null?_input.getText(((ExprContext)_localctx).array_index.start,((ExprContext)_localctx).array_index.stop):null);
					
				}
				break;
			case 3:
				{
				setState(205);
				match(T__17);
				setState(206);
				((ExprContext)_localctx).basic_type = basic_type();
				setState(207);
				match(LEFT_PARA);
				setState(208);
				match(RIGHT_PARA);

						((ExprContext)_localctx).type =  (((ExprContext)_localctx).basic_type!=null?_input.getText(((ExprContext)_localctx).basic_type.start,((ExprContext)_localctx).basic_type.stop):null);
					
				}
				break;
			case 4:
				{
				setState(211);
				match(T__18);
				setState(212);
				((ExprContext)_localctx).a = expr(10);

						((ExprContext)_localctx).type =  "boolean";
					
				}
				break;
			case 5:
				{
				setState(215);
				match(INT);

						((ExprContext)_localctx).type =  "int";
					
				}
				break;
			case 6:
				{
				setState(217);
				((ExprContext)_localctx).ID = match(ID);

						String var_name = (((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getText():null);
						if(MiniJavaParser.isKeyWord(var_name))   //检查是否用关键字做ID
						{
							System.out.println("error: keword: " +var_name + " is used as an ID "+ " at " +(((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getLine():0) + ":"+(((ExprContext)_localctx).ID!=null?((ExprContext)_localctx).ID.getCharPositionInLine():0));
						}
						
						Var_declContext v = MiniJavaParser.findVar(_localctx,var_name);
						if (v!=null)
							((ExprContext)_localctx).type =  v.type;
					
				}
				break;
			case 7:
				{
				setState(219);
				match(T__19);

						((ExprContext)_localctx).type =  "boolean";
					
				}
				break;
			case 8:
				{
				setState(221);
				match(T__20);

						((ExprContext)_localctx).type =  "boolean";
					
				}
				break;
			case 9:
				{
				setState(223);
				match(T__21);

						//this对象的类型名是所在类的类名
						ParserRuleContext parent=_localctx.getParent();
						while(!(parent instanceof Class_declContext)) {
							parent=parent.getParent();
						}
						Class_declContext c=(Class_declContext)parent;
						((ExprContext)_localctx).type =  c.name;
					
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(266);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(228);
						((ExprContext)_localctx).op = match(MUL_OP);
						setState(229);
						((ExprContext)_localctx).b = expr(10);

						          		//检查两个操作数的类型是否都为int
						          		MiniJavaParser.checkType(((ExprContext)_localctx).a.type,((ExprContext)_localctx).b.type,((ExprContext)_localctx).op,"int");
						          		((ExprContext)_localctx).type =  "int";
						          	
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(232);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(233);
						((ExprContext)_localctx).op = match(ADD_OP);
						setState(234);
						((ExprContext)_localctx).b = expr(9);

						          		MiniJavaParser.checkType(((ExprContext)_localctx).a.type,((ExprContext)_localctx).b.type,((ExprContext)_localctx).op,"int");
						          		((ExprContext)_localctx).type =  "int";
						          	
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(237);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(238);
						((ExprContext)_localctx).op = match(RELATION_OP);
						setState(239);
						((ExprContext)_localctx).b = expr(8);

						          		MiniJavaParser.checkType(((ExprContext)_localctx).a.type,((ExprContext)_localctx).b.type,((ExprContext)_localctx).op,"int");
						          		((ExprContext)_localctx).type =  "boolean";
						          	
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(243);
						((ExprContext)_localctx).op = match(LOGIC_OP);
						setState(244);
						((ExprContext)_localctx).b = expr(7);

						          		MiniJavaParser.checkType(((ExprContext)_localctx).a.type,((ExprContext)_localctx).b.type,((ExprContext)_localctx).op,"boolean");
						          		((ExprContext)_localctx).type =  "boolean";
						          	
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(248);
						((ExprContext)_localctx).op = match(T__9);
						setState(249);
						((ExprContext)_localctx).b = expr(0);
						setState(250);
						match(T__10);

						          		MiniJavaParser.checkArrayType(((ExprContext)_localctx).a.type,((ExprContext)_localctx).op);
						          		MiniJavaParser.checkType(((ExprContext)_localctx).b.type,((ExprContext)_localctx).op,"int");
						          		if (MiniJavaParser.isArrayType(((ExprContext)_localctx).a.type)){
						          			int L =((ExprContext)_localctx).a.type.length();
						          			((ExprContext)_localctx).type =  ((ExprContext)_localctx).a.type.substring(0,L-2);
						          		}
						          	
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(254);
						((ExprContext)_localctx).op = match(MEMBER_OP);
						setState(255);
						match(T__16);

						          		MiniJavaParser.checkArrayType(((ExprContext)_localctx).a.type,((ExprContext)_localctx).op);
						          		((ExprContext)_localctx).type =  "int";
						          	
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(258);
						((ExprContext)_localctx).op = match(MEMBER_OP);
						setState(259);
						((ExprContext)_localctx).ID = match(ID);
						setState(260);
						match(LEFT_PARA);
						setState(262);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << LEFT_PARA) | (1L << ID) | (1L << INT))) != 0)) {
							{
							setState(261);
							expr_list();
							}
						}

						setState(264);
						match(RIGHT_PARA);

						          		
						          	
						}
						break;
					}
					} 
				}
				setState(270);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class Array_indexContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Array_indexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterArray_index(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitArray_index(this);
		}
	}

	public final Array_indexContext array_index() throws RecognitionException {
		Array_indexContext _localctx = new Array_indexContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_array_index);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(275); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(271);
					match(T__9);
					setState(272);
					expr(0);
					setState(273);
					match(T__10);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(277); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		case 15:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u011a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\6\2&\n\2\r\2\16\2\'\3\3\3\3\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\3\3\7\3"+
		"\64\n\3\f\3\16\3\67\13\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\5\4E\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\5\6N\n\6\3\6\5\6Q\n\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6X\n\6\f\6\16\6[\13\6\5\6]\n\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\3\6\7\6n\n\6\f\6\16\6q\13\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\5\t~\n\t\3\n\3\n\5\n\u0082"+
		"\n\n\3\13\3\13\3\f\3\f\3\f\6\f\u0089\n\f\r\f\16\f\u008a\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\7\17\u0093\n\17\f\17\16\17\u0096\13\17\3\17\3\17\3\17\5"+
		"\17\u009b\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b4"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00bb\n\17\3\20\3\20\3\20\7\20\u00c0"+
		"\n\20\f\20\16\20\u00c3\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e4\n\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\5\21\u0109\n\21\3\21\3\21\7\21\u010d\n\21\f"+
		"\21\16\21\u0110\13\21\3\22\3\22\3\22\3\22\6\22\u0116\n\22\r\22\16\22\u0117"+
		"\3\22\2\3 \23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\4\3\2\3\5\4"+
		"\2\n\13&&\2\u0132\2%\3\2\2\2\4)\3\2\2\2\6@\3\2\2\2\bH\3\2\2\2\nM\3\2\2"+
		"\2\fu\3\2\2\2\16y\3\2\2\2\20}\3\2\2\2\22\u0081\3\2\2\2\24\u0083\3\2\2"+
		"\2\26\u0085\3\2\2\2\30\u008c\3\2\2\2\32\u008e\3\2\2\2\34\u00ba\3\2\2\2"+
		"\36\u00bc\3\2\2\2 \u00e3\3\2\2\2\"\u0115\3\2\2\2$&\5\4\3\2%$\3\2\2\2&"+
		"\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\3\3\2\2\2)*\5\6\4\2*\65\7\35\2\2+-\t"+
		"\2\2\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\6\2\2/\64\5\b\5\2\60\61\5\b\5"+
		"\2\61\62\7\33\2\2\62\64\3\2\2\2\63,\3\2\2\2\63\60\3\2\2\2\64\67\3\2\2"+
		"\2\65\63\3\2\2\2\65\66\3\2\2\2\66;\3\2\2\2\67\65\3\2\2\28:\5\n\6\298\3"+
		"\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7\36\2\2?\5"+
		"\3\2\2\2@A\7\7\2\2AD\7&\2\2BC\7%\2\2CE\7&\2\2DB\3\2\2\2DE\3\2\2\2EF\3"+
		"\2\2\2FG\b\4\1\2G\7\3\2\2\2HI\5\22\n\2IJ\7&\2\2JK\b\5\1\2K\t\3\2\2\2L"+
		"N\t\2\2\2ML\3\2\2\2MN\3\2\2\2NP\3\2\2\2OQ\7\6\2\2PO\3\2\2\2PQ\3\2\2\2"+
		"QR\3\2\2\2RS\5\f\7\2S\\\7\37\2\2TY\5\16\b\2UV\7\b\2\2VX\5\16\b\2WU\3\2"+
		"\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2\\T\3\2\2\2\\]\3"+
		"\2\2\2]^\3\2\2\2^_\7 \2\2_i\7\35\2\2`a\7\6\2\2ab\5\b\5\2bc\7\33\2\2ch"+
		"\3\2\2\2de\5\b\5\2ef\7\33\2\2fh\3\2\2\2g`\3\2\2\2gd\3\2\2\2hk\3\2\2\2"+
		"ig\3\2\2\2ij\3\2\2\2jo\3\2\2\2ki\3\2\2\2ln\5\34\17\2ml\3\2\2\2nq\3\2\2"+
		"\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\36\2\2st\b\6\1\2t\13\3"+
		"\2\2\2uv\5\20\t\2vw\7&\2\2wx\b\7\1\2x\r\3\2\2\2yz\5\b\5\2z\17\3\2\2\2"+
		"{~\7\t\2\2|~\5\22\n\2}{\3\2\2\2}|\3\2\2\2~\21\3\2\2\2\177\u0082\5\26\f"+
		"\2\u0080\u0082\5\24\13\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\23"+
		"\3\2\2\2\u0083\u0084\t\3\2\2\u0084\25\3\2\2\2\u0085\u0088\5\24\13\2\u0086"+
		"\u0087\7\f\2\2\u0087\u0089\7\r\2\2\u0088\u0086\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\27\3\2\2\2\u008c\u008d"+
		"\7\35\2\2\u008d\31\3\2\2\2\u008e\u008f\7\36\2\2\u008f\33\3\2\2\2\u0090"+
		"\u0094\7\35\2\2\u0091\u0093\5\34\17\2\u0092\u0091\3\2\2\2\u0093\u0096"+
		"\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u00bb\7\36\2\2\u0098\u009a\7\16\2\2\u0099\u009b\5"+
		" \21\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u00bb\7\33\2\2\u009d\u009e\7\17\2\2\u009e\u009f\7\37\2\2\u009f\u00a0"+
		"\5 \21\2\u00a0\u00a1\7 \2\2\u00a1\u00a2\5\34\17\2\u00a2\u00a3\7\20\2\2"+
		"\u00a3\u00a4\5\34\17\2\u00a4\u00bb\3\2\2\2\u00a5\u00a6\7\21\2\2\u00a6"+
		"\u00a7\7\37\2\2\u00a7\u00a8\5 \21\2\u00a8\u00a9\7 \2\2\u00a9\u00aa\5\34"+
		"\17\2\u00aa\u00bb\3\2\2\2\u00ab\u00ac\7\22\2\2\u00ac\u00ad\7\37\2\2\u00ad"+
		"\u00ae\5 \21\2\u00ae\u00af\7 \2\2\u00af\u00b0\7\33\2\2\u00b0\u00bb\3\2"+
		"\2\2\u00b1\u00b3\7&\2\2\u00b2\u00b4\5\"\22\2\u00b3\u00b2\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\7\32\2\2\u00b6\u00b7\5"+
		" \21\2\u00b7\u00b8\7\33\2\2\u00b8\u00b9\b\17\1\2\u00b9\u00bb\3\2\2\2\u00ba"+
		"\u0090\3\2\2\2\u00ba\u0098\3\2\2\2\u00ba\u009d\3\2\2\2\u00ba\u00a5\3\2"+
		"\2\2\u00ba\u00ab\3\2\2\2\u00ba\u00b1\3\2\2\2\u00bb\35\3\2\2\2\u00bc\u00c1"+
		"\5 \21\2\u00bd\u00be\7\b\2\2\u00be\u00c0\5 \21\2\u00bf\u00bd\3\2\2\2\u00c0"+
		"\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\37\3\2\2"+
		"\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\b\21\1\2\u00c5\u00c6\7\37\2\2\u00c6"+
		"\u00c7\5 \21\2\u00c7\u00c8\7 \2\2\u00c8\u00c9\b\21\1\2\u00c9\u00e4\3\2"+
		"\2\2\u00ca\u00cb\7\24\2\2\u00cb\u00cc\5\24\13\2\u00cc\u00cd\5\"\22\2\u00cd"+
		"\u00ce\b\21\1\2\u00ce\u00e4\3\2\2\2\u00cf\u00d0\7\24\2\2\u00d0\u00d1\5"+
		"\24\13\2\u00d1\u00d2\7\37\2\2\u00d2\u00d3\7 \2\2\u00d3\u00d4\b\21\1\2"+
		"\u00d4\u00e4\3\2\2\2\u00d5\u00d6\7\25\2\2\u00d6\u00d7\5 \21\f\u00d7\u00d8"+
		"\b\21\1\2\u00d8\u00e4\3\2\2\2\u00d9\u00da\7\'\2\2\u00da\u00e4\b\21\1\2"+
		"\u00db\u00dc\7&\2\2\u00dc\u00e4\b\21\1\2\u00dd\u00de\7\26\2\2\u00de\u00e4"+
		"\b\21\1\2\u00df\u00e0\7\27\2\2\u00e0\u00e4\b\21\1\2\u00e1\u00e2\7\30\2"+
		"\2\u00e2\u00e4\b\21\1\2\u00e3\u00c4\3\2\2\2\u00e3\u00ca\3\2\2\2\u00e3"+
		"\u00cf\3\2\2\2\u00e3\u00d5\3\2\2\2\u00e3\u00d9\3\2\2\2\u00e3\u00db\3\2"+
		"\2\2\u00e3\u00dd\3\2\2\2\u00e3\u00df\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u010e\3\2\2\2\u00e5\u00e6\f\13\2\2\u00e6\u00e7\7$\2\2\u00e7\u00e8\5 "+
		"\21\f\u00e8\u00e9\b\21\1\2\u00e9\u010d\3\2\2\2\u00ea\u00eb\f\n\2\2\u00eb"+
		"\u00ec\7#\2\2\u00ec\u00ed\5 \21\13\u00ed\u00ee\b\21\1\2\u00ee\u010d\3"+
		"\2\2\2\u00ef\u00f0\f\t\2\2\u00f0\u00f1\7!\2\2\u00f1\u00f2\5 \21\n\u00f2"+
		"\u00f3\b\21\1\2\u00f3\u010d\3\2\2\2\u00f4\u00f5\f\b\2\2\u00f5\u00f6\7"+
		"\"\2\2\u00f6\u00f7\5 \21\t\u00f7\u00f8\b\21\1\2\u00f8\u010d\3\2\2\2\u00f9"+
		"\u00fa\f\21\2\2\u00fa\u00fb\7\f\2\2\u00fb\u00fc\5 \21\2\u00fc\u00fd\7"+
		"\r\2\2\u00fd\u00fe\b\21\1\2\u00fe\u010d\3\2\2\2\u00ff\u0100\f\20\2\2\u0100"+
		"\u0101\7\31\2\2\u0101\u0102\7\23\2\2\u0102\u010d\b\21\1\2\u0103\u0104"+
		"\f\17\2\2\u0104\u0105\7\31\2\2\u0105\u0106\7&\2\2\u0106\u0108\7\37\2\2"+
		"\u0107\u0109\5\36\20\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010a"+
		"\3\2\2\2\u010a\u010b\7 \2\2\u010b\u010d\b\21\1\2\u010c\u00e5\3\2\2\2\u010c"+
		"\u00ea\3\2\2\2\u010c\u00ef\3\2\2\2\u010c\u00f4\3\2\2\2\u010c\u00f9\3\2"+
		"\2\2\u010c\u00ff\3\2\2\2\u010c\u0103\3\2\2\2\u010d\u0110\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f!\3\2\2\2\u0110\u010e\3\2\2\2"+
		"\u0111\u0112\7\f\2\2\u0112\u0113\5 \21\2\u0113\u0114\7\r\2\2\u0114\u0116"+
		"\3\2\2\2\u0115\u0111\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118#\3\2\2\2\34\',\63\65;DMPY\\gio}\u0081\u008a\u0094"+
		"\u009a\u00b3\u00ba\u00c1\u00e3\u0108\u010c\u010e\u0117";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}