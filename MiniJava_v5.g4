grammar MiniJava;
@header{
	import java.util.*;
}

prog
:   (class_list += class_decl)+
;

class_decl
/* List of symbols defined within this block */
    : head += class_head body +=class_body 
    ;
    
class_head :
	'class' name += ID ( EXTENDS ID ) ?
	{
		ProgContext prog =(ProgContext) ($ctx.getParent().getParent());
		List<Class_declContext> class_list = prog.class_list;
		
		Token n = $ctx.name.get(0);
		String class_name = n.getText();
		
		//判断类名是否存在	
		boolean flag = true;	
		for(Class_declContext e:class_list)	{
			Token t = e.head.get(0).name.get(0);
			if (t.getText().equals(class_name)){
				flag = false;				
				System.out.println("class " + class_name + " refined " + "at line " 
					+ n.getLine() + ":" + n.getCharPositionInLine()
				);
			}			
		}
		if (flag) {
			System.out.println("add new class " + class_name + " successful");	
		}
    }
	;
	
class_body:
	class_body_start 
	(vars  += class_var_decl)*
	(funcs += method_decl)*
	class_body_end
	;

class_var_decl:
	('public'|'protected'|'private')? ('static')? vars += var_decl
	;

var_decl:
	var_type += type name+= ID SEMICOLON
	{
		
	}
	;
method_decl:
	('public'|'protected'|'private')? ('static')? 
	head += function_head
	body += function_body 
	;

function_head:
	type ID LEFT_PARA (type paras += ID (',' type paras += ID)*)? RIGHT_PARA 
	;
	
function_body:
	'{'
	(vars += var_decl)*
	(stat)*
	'}'
	;

type:  ID ('[' ']')?
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

