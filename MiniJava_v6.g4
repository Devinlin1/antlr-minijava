grammar MiniJava;
@header{
	import java.util.*;
}

prog
:   (class_list += class_decl)+
;

class_decl
locals[
	String name    
]
/* List of symbols defined within this block */
    :  'class' class_name = ID ( EXTENDS ID ) ? 
    '{'
	( ('public'|'protected'|'private')? ('static')? var_list += var_decl SEMICOLON)*
	  (func_list += method_decl)*
	'}'
	
    {	//动作处理部分
		ProgContext prog =(ProgContext) ($ctx.getParent());
		List<Class_declContext> class_list = prog.class_list;
		
		$ctx.name = $class_name.text;
		
		//判断类名是否存在	
		boolean flag = true;	
		for(Class_declContext e:class_list)	{
			if (e.name.equals($ctx.name)){
				flag = false;				
				System.out.println("class name: " + $ctx.name + "is refined " + "at line " 
					+ $class_name.line + ":" + $class_name.pos
				);
			}			 
		}
		if (flag) {
			System.out.println("add new class name:" + $ctx.name + " to class name list");	
		}
    }
    ;
   

var_decl
locals
[
	String type;
	String name
]
	:var_type ID 
	{
		$ctx.type = $var_type.text;
		$ctx.name = $ID.text;
		
		ParserRuleContext parent =$ctx.getParent();
		if (parent instanceof Class_declContext) {  //是类成员变量
			Class_declContext c =(Class_declContext)(parent);
			List<Var_declContext> var_list = c.var_list;
			
			//判断是否已经有同名成员变量存在
			boolean flag = true;
			for(Var_declContext e: var_list) {
				if (e.name.equals($ID.text))
				{
					flag = false;
					System.out.println("var " + $ID.text + " is refined " + "at line " 
					+ $ID.line + ":" + $ID.pos
					);
					break;	
				}
			}
			if (flag) {
				System.out.println("add new member var: " + $ctx.name + " successful");
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
				if (v.name.equals($ID.text))
				{
					flag = false;
					System.out.println("para " + $ID.text + " is refined " + "at line " 
					+ $ID.line + ":" + $ID.pos
					);
					break;	
				}
			}
			
			if (flag) {
				System.out.println("add new par: " + $ctx.name +" in function " + 
					c.name + " successful"
				);
			}	
		}
		else if (parent instanceof Method_declContext){  //如果是函数中的局部变量 
			Method_declContext c =(Method_declContext)parent;
			List<Var_declContext> var_list = c.var_list;
			
			//判断是否有同名变量存在
			boolean flag = true;
			for(Var_declContext e: var_list) {
				if (e.name.equals($ID.text))
				{
					flag = false;
					System.out.println("var " + $ID.text + " is refined " + "at line " 
					+ $ID.line + ":" + $ID.pos
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
					if (v.name.equals($ID.text))
					{
						flag = false;
						System.out.println("para " + $ID.text + " is refined " + "at line " 
						+ $ID.line + ":" + $ID.pos
						);
						break;	
					}
				}
			}
			
			if (flag) {
				System.out.println("add new var: " + $ctx.name +" in function " + 
					c.name + " successful"
				);
			}
		}
	}
	;
	
method_decl
locals[
	String name;     //记录函数名
	String type  //记录返回类型名
	]
:
	('public'|'protected'|'private')? ('static')? 
	func_type ID LEFT_PARA (para_list += para_decl (',' para_list += para_decl)*)? RIGHT_PARA
	'{'
	 (var_list += var_decl SEMICOLON)*
	 (stat_list += stat)*	
	'}'
	{
		$ctx.name = $ID.text;
		$ctx.type=$func_type.text;
	} 
	;
	
para_decl:
	var=var_decl
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
	|	'if' '(' expr ')' stat 'else' stat
	|	'while' '(' expr ')' stat
	|	'System.out.println' '(' expr ')' ';'
	|	ID ASSIGN_OP expr ';'
	|	ID '[' expr ']' '=' expr ';'
	;		

expr_list:
	expr(',' expr)*
	;

expr returns [String t]:   
	'(' expr ')'
	|	expr '[' expr ']'
	|	expr '.' 'length'
	|   expr.ID '(' (expr_list)? ')'
	|	'new' 'int' '[' expr ']'  
	|	'new' ID '(' ')'
	|	'!' expr
	| 	expr MUL_OP  expr
	| 	expr ADD_OP expr
	| 	expr RELATION_OP expr
	| 	expr LOGIC_OP expr
	|  INT
	|  ID
	|  'true'
	|  'false'
	|  'this'
	;

ASSIGN_OP:
	 '+='|'-='|'*='|'/='
	|'+'|'-'|'*'|'/'
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

