grammar MiniJava;

/** The start rule; begin parsing here. */
prog:   main_class   ( class_decl )* 
	; 

main_class	:	'class' ID '{' 	
		'public' 'static' 'void' 'main' 
		'(' 'String' '[' ']' ID ')' 
		'{' stat '}' 
		'}'
		;
stat:
	'{' ( stat )* '}'
	|	'if' '(' expr ')' stat 'else' stat
	|	'while' '(' expr ')' stat
	|	'System.out.println' '(' expr ')' ';'
	|	ID '=' expr ';'
	|	ID '[' expr ']' '=' expr ';'
	;		

expr:   
	expr '*'  expr
	|expr ('+' | '-'  ) expr
	|expr ('<' ) expr
	|expr ( '&&' ) expr
	|	expr '[' expr ']'
	|	expr '.' 'length'
	|	expr '.' ID '(' ( expr ( ',' expr )* )? ')'
	|	INT
	|	'true'
	|	'false'
	|	ID
	|	'this'
	|	'new' 'int' '[' expr ']'
	|	'new' ID '(' ')'
	|	'!' expr
	|	'(' expr ')'
	;
	
class_decl	: 'class' ID ( 'extends' ID )? 
		'{' (var_decl)* ( method_decl )* '}'
		;

var_decl	:	type ID ';'	
	;
	
method_decl:	
	'public' type ID '(' ( type ID ( ',' type ID )* )? ')' 
	'{' (var_decl)* ( stat )* 'return' expr ';' '}'
	;
	
type	:	'int' '[' ']'
	|	'boolean'
	|	'int'
	|	ID
	;

SL_COMMENT
    : '//' .*?  '\n' -> skip  //������ע��,�����ɼ��α����İ�ĵ�181ҳ��12.1��
    ;

ID  :   [a-zA-Z_][a-zA-Z_0-9]* ;    // ƥ���ʶ��
INT :   [0-9]+ ;         // ƥ������
WS  :   [ \r\n\t]+ -> skip ; 		// ���˿հ׷�