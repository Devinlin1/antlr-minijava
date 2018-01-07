grammar MiniJava;

/** The start rule; begin parsing here. */
prog:   main_class  
	; 

main_class	:	'class' ID '{' 	'}'
		;

ID  :   [a-zA-Z_][a-zA-Z_0-9]* ;      // match identifiers 