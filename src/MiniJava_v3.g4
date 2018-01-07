grammar MiniJava;
@header{
	import java.util.*;
}
@parser::member{
	typedef Map<String,String> SymbolTable;
	typedef Map<String,SymbolTable> FunctionVarList;  //记录每个函数里的变量名列表
	typedef Map<String,FunctionVarList> MemberFunctions;  //记录每个类的函数成员列表
	typedef Map<String,SymbolTable> MemberVars;  //记录每个类的数据成员列表
	
	//static String class_name; //记录当前处理的类名
	//static String func_name; //当前的函数名	
}

program 
locals[
	String class_name 
]
: main_class  (class_decl )* 
	; 

main_class	:	'class' ID  class_body_start 	
		main_head 
		main_para 
		function_body 
		class_body_end
		;

class_decl	: class_head
		class_body
		;

main_head:
	'public' 'static' 'void' 'main'
	;
main_para:
	'(' 'String' '[' ']' ID ')'
	
	;

class_head:
	'class' class_name=ID ( 'extends' ID )?
	{
		
	}
	;

class_body:
	class_body_start (var_decl)* ( method_decl)* class_body_end
	;

class_body_start:LEFT_BRACE
	;
class_body_end:RIGHT_BRACE
	;

function:fucntion_head
		function_body
		;


arg_list:
	type ID ( ',' type ID )*
	;
fucntion_head:
	'public' type ID '(' ( type ID ( ',' type ID )* )? ')'
	;
	
function_body:
	function_body_start	
	(var_decl|stat)*
	function_body_end 
	;

function_body_start:LEFT_BRACE;
function_body_end:RIGHT_BRACE;

	

var_decl:	type ID ';'	
	;
	
method_decl:	
	'public' type ID '(' ( type ID ( ',' type ID )* )? ')' 
	'{' (var_decl)* ( stat )* 'return' expr ';' '}'
	;
		

stat:
	'{' ( stat )* '}'
	|	'if' '(' expr ')' stat 'else' stat
	|	'while' '(' expr ')' stat
	|	'System.out.println' '(' expr ')' ';'
	|	ID '=' expr ';'
	{
				
	}
	|	ID '[' expr ']' '=' expr ';'
	;		

expr_list:
	expr(',' expr)*
	;

expr:   
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


type	:	'int' '[' ']'
	|	'boolean'
	|	'int'
	|	ID
	;

SL_COMMENT
    : '//' .*?  '\n' -> skip  //过滤行注释,本技巧见课本中文版的第181页的12.1节
    ;
    
LEFT_BRACE:'{';    
RIGHT_BRACE:'}';

RELATION_OP:
	'<'|'>'|'<='|'>='|'=='|'!='
	;
	
LOGIC_OP:
	'&&'|'||';

ADD_OP :'+'|'-'
	;

MUL_OP	:'*'|'/'
	;

ID  :   [a-zA-Z_][a-zA-Z_0-9]* ;    // 匹配标识符

INT :   [0-9]+ ;         // 匹配数字

WS  :   [ \r\n\t]+ -> skip ; 		// 过滤空白符


