grammar MiniJava;
@header{
	import java.util.*;
}

prog
locals [
    List<String> class_names = new ArrayList<String>()
]
:   (class_decl)+
;

class_decl
locals [
	
]
/* List of symbols defined within this block */
    :   class_head class_body
    ;

class_head:'class' class_name=ID ( EXTENDS ID ) ?
	{
		
		ProgContext prog =(ProgContext) ($ctx.getParent().getParent());
		List<String> class_names = prog.class_names;
		String class_name = $class_name.text;
		if(class_names.contains(class_name)) {
			System.out.println("class " + class_name + " refined " + "at line " + $class_name.line + ":" + $class_name.pos);					
		}
		else {
			System.out.println("add new class " + class_name);
			class_names.add(class_name);				
		}
    }
	;
	
class_body:
	class_body_start 
	(var_decl|method_decl)*
	class_body_end
	;

var_decl:
	type ID;
method_decl:
	ID;

type	
	:	ID '[' ']'
	|	ID
	;

class_body_start:LEFT_BRACE
	;
	
class_body_end:RIGHT_BRACE
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

EXTENDS:
	'extends'
	;
	
ID  :   [a-zA-Z_][a-zA-Z_0-9]* ;    // 匹配标识符

INT :   [0-9]+ ;         // 匹配数字

WS  :   [ \r\n\t]+ -> skip ; 		// 过滤空白符	

