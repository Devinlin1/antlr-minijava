grammar MiniJava;
@header{
	import java.util.*;
}

@parser::members{
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
}

prog
:   (class_list += class_decl)+
;

class_decl
locals[
	String name    
]
/* List of symbols defined within this block */
    : 
    // 'class' class_name = ID ( EXTENDS ID ) ?
    class_head_name 
    '{'
	  ( ('public'|'protected'|'private')? 
	  	('static' var_list  += var_decl[true,MiniJavaParser.Scope.MEMBER])
	  	|
	  	(var_list  += var_decl[false,MiniJavaParser.Scope.MEMBER])
	  	SEMICOLON
	  )*
	   (func_list += method_decl)*
	'}'
    ;
    
class_head_name:
	'class' class_name = ID ( EXTENDS parent_name = ID ) ?
	{
		//如果类名已经存在,则给出提示
		Class_declContext parent =(Class_declContext) ($ctx.getParent());
		parent.name = $class_name.text;
		
		ProgContext prog =(ProgContext) (parent.getParent());
		
		if (MiniJavaParser.isClassExists(prog,parent.name))
			System.out.println("class name: " + parent.name + " is refined " + "at line " 
					+ $class_name.line + ":" + $class_name.pos
				);
		else
			System.out.println("add new class name:" + parent.name + " to class name list");	
	}
	;    
    
var_decl[boolean static_flag,MiniJavaParser.Scope var_scope]
locals
[
	String type;
	String name;
	boolean is_static = false; 
	MiniJavaParser.Scope scope 
]
	:var_type ID 
	{
		String var_name = $ID.text;
		$ctx.type = $var_type.text;
		$ctx.name = $ID.text;
		$ctx.scope = $var_scope;
		$ctx.is_static = $static_flag;
		
		ParserRuleContext parent = $ctx.getParent();
		if (parent instanceof Class_declContext) {  //是类成员变量
			Class_declContext c =(Class_declContext)(parent);
			Var_declContext var = MiniJavaParser.findVar(c,var_name);
			
			if (var != null && var.is_static == $static_flag){
				System.out.println("var " + $ID.text + " is refined " + "at line " 
					+ $ID.line + ":" + $ID.pos
					);
			}
			else {
				System.out.println("add new member var: " + $ctx.name + 
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
				System.out.println("para " + $ID.text+" in function" + c.name + " is refined " + "at line " 
					+ $ID.line + ":" + $ID.pos
					);
			}
			else {
				System.out.println("add new par: " + $ctx.name +" in function " + c.name + " successful");
			}	
		}
		
		else if (parent instanceof Method_declContext){  
			//如果是函数中的局部变量
			Method_declContext c = (Method_declContext)parent;
			
			if (MiniJavaParser.isVarExists(c,var_name))
			{
				System.out.println("var " + $ID.text +" in function" + c.name + " is refined " + "at line " 
					+ $ID.line + ":" + $ID.pos
				);
			}
			else if (MiniJavaParser.isParaExists(c,var_name))
			{
				System.out.println("var " + $ID.text +" in function " + c.name 
				 + " has same name with some para " + "at line "+ $ID.line + ":" + $ID.pos);
			}
			else 
			{
				System.out.println("add new var: " + $ctx.name 
					+" in function " + c.name + " successful"
				);
			} 
		}
	}
	;
	
method_decl
locals[
	String name;     //记录函数名
	String type;  //记录返回类型名
	boolean is_static //是否为静态方法
]
:
	('public'|'protected'|'private')? (b='static')? 
	func_head_name LEFT_PARA (para_list += para_decl (',' para_list += para_decl)*)? RIGHT_PARA
	'{'
	 (
	 	('static' var_list += var_decl[true,MiniJavaParser.Scope.FUNC] SEMICOLON)
	 	|
	 	(var_list += var_decl[false,MiniJavaParser.Scope.FUNC] SEMICOLON) 
	 )*
	 (stat_list += stat)*
	'}'
	
	{
		$ctx.is_static = ($b.text!=null);
		//检查函数是否可以重载
		Class_declContext parent =(Class_declContext) ($ctx.getParent());
		if (MiniJavaParser.isFuncExists(parent,$ctx))
		{
			System.out.println("overload function:" + $ctx.name + " in class "+ parent.name + "failed"
			+ " at line " + $LEFT_PARA.line + ":" + $LEFT_PARA.pos	
			);
		}
		else {
			System.out.println("add function:" + $ctx.name + " to class " + parent.name + " success");		
		}
	} 
	;
	
func_head_name:
	func_type ID
	{
		//记录函数名和返回类型名
		Method_declContext c =(Method_declContext)($ctx.getParent()); 
		c.name = $ID.text;
		c.type = $func_type.text;
	}
	;	
	
para_decl:
	var=var_decl[false,MiniJavaParser.Scope.FUNC]
	#ParaDecl
	;

func_type:
	'void'|var_type
	;


var_type:
	array_type
	|basic_type
	;

basic_type:
	'int'
	|'boolean'
	|ID
	;
		
array_type:
	basic_type ('['']')+ 
	;	

class_body_start:LEFT_BRACE
	;
	
class_body_end:RIGHT_BRACE
	;

stat:
	'{' (stat)* '}'
	|'return' (expr)? ';'
	|	'if' '(' expr ')' stat 'else' stat
	|	'while' '(' expr ')' stat
	|	'System.out.println' '(' expr ')' ';'
	|	ID (array_index)? ASSIGN_OP expr ';'
	{
		//对辅助语句进行检查,左边的ID必须存在,并且和右边的表达式类型名一致
	}
	;		

expr_list:
	expr(',' expr)*
	;

expr returns [String type]:      //type记录表达式的类型名
	'(' a=expr ')'
	{
		$type = $a.type;
	}
	|	a = expr  op='[' b= expr ']'
	{
		MiniJavaParser.checkArrayType($a.type,$op);
		MiniJavaParser.checkType($b.type,$op,"int");
		if (MiniJavaParser.isArrayType($a.type)){
			int L =$a.type.length();
			$type = $a.type.substring(0,L-2);
		}
	}
	|	a=expr op=MEMBER_OP 'length'
	{
		MiniJavaParser.checkArrayType($a.type,$op);
		$type = "int";
	}
	|   a=expr op=MEMBER_OP ID '(' (expr_list)? ')'{
		
	}
	|	'new' basic_type array_index   //多维数组定义
	{
		$type = $basic_type.text+$array_index.text;
	}  
	|	'new' basic_type '(' ')'              //单变量定义
	{
		$type = $basic_type.text;
	}
	|	'!' a=expr
	{
		$type = "boolean";
	}
	| 	a=expr op=MUL_OP  b=expr
	{
		//检查两个操作数的类型是否都为int
		MiniJavaParser.checkType($a.type,$b.type,$op,"int");
		$type = "int";
	}
	| 	a=expr op=ADD_OP b=expr
	{
		MiniJavaParser.checkType($a.type,$b.type,$op,"int");
		$type = "int";
	}
	| 	a=expr op=RELATION_OP b=expr
	{
		MiniJavaParser.checkType($a.type,$b.type,$op,"int");
		$type = "boolean";
	}
	| 	a=expr op=LOGIC_OP b=expr
	{
		MiniJavaParser.checkType($a.type,$b.type,$op,"boolean");
		$type = "boolean";
	}
	|  INT
	{
		$type = "int";
	}
	|  ID
	{
		String var_name = $ID.text;
		if(MiniJavaParser.isKeyWord(var_name))   //检查是否用关键字做ID
		{
			System.out.println("error: keword: " +var_name + " is used as an ID "+ " at " +$ID.line + ":"+$ID.pos);
		}
		
		Var_declContext v = MiniJavaParser.findVar($ctx,var_name);
		if (v!=null)
			$type = v.type;
	}
	|  'true'
	{
		$type = "boolean";
	}
	|  'false'
	{
		$type = "boolean";
	}
	|  'this'
	{
		//this对象的类型名是所在类的类名
		ParserRuleContext parent=$ctx.getParent();
		while(!(parent instanceof Class_declContext)) {
			parent=parent.getParent();
		}
		Class_declContext c=(Class_declContext)parent;
		$type = c.name;
	}
	;

array_index:
	('[' expr ']')+
	;

MEMBER_OP:
	'.'
	;

ASSIGN_OP:
	 '+='|'-='|'*='|'/='|'='
	;
		
SEMICOLON
	: ';'
	;
		
SL_COMMENT
    : '//' .*?  '\n' -> skip  //过滤行注释,本技巧见课本中文版的第181页的12.1节
    ;
    
LEFT_BRACE:'{';    
RIGHT_BRACE:'}';

LEFT_PARA:'(';    
RIGHT_PARA:')';


RELATION_OP:
	'<'|'>'|'<='|'>='|'=='|'!='
	;
	
LOGIC_OP:
	'&&'|'||';

ADD_OP :'+'|'-'
	;

MUL_OP	:'*'|'/'
	;

EXTENDS:
	'extends'
	;
	
ID  :   [a-zA-Z_][a-zA-Z_0-9]* ;    // 匹配标识符

INT :   [0-9]+ ;         // 匹配数字

WS  :   [ \r\n\t]+ -> skip ; 		// 过滤空白符	

