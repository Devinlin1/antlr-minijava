grammar MiniJava;
@header{
	import java.util.*;
}

@parser::members{
	enum VarScope{MEMBER,FUNC};   //������������
	
	//����ĳ�������,��������ڵĻ�����NULL
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
	( ('public'|'protected'|'private')? ('static')? var_list += var_decl SEMICOLON)*
	  (func_list += method_decl)*
	'}'
    ;
    
class_head_name:
	'class' class_name = ID ( EXTENDS parent_name = ID ) ?
	{
		//��������Ѿ�����,�������ʾ
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
    
var_decl
locals
[
	String type;
	String name;
	boolean is_static = false; //�Ƿ�Ϊ��̬����
	MiniJavaParser.VarScope scope 
]
	:var_type ID 
	{
		$ctx.type = $var_type.text;
		$ctx.name = $ID.text;
		
		ParserRuleContext parent =$ctx.getParent();
		if (parent instanceof Class_declContext) {  //�����Ա����
			$ctx.scope  = MiniJavaParser.VarScope.MEMBER;
			Class_declContext c =(Class_declContext)(parent);
			List<Var_declContext> var_list = c.var_list;
			
			//�ж��Ƿ��Ѿ���ͬ����Ա��������
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
			
			//����Ǻ�������������߱�������,Ҫ�ж��Ƿ��Ѿ���ͬ����������
			
			//���϶�λ���������ڵ�
			while (!(parent instanceof Method_declContext) ){
				parent = parent.getParent();
			}
			
			Method_declContext c =(Method_declContext)parent;
			List<Para_declContext> para_list = c.para_list;
			
			//�ж��Ƿ��Ѿ���ͬ����������
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
				//System.out.println("add new par: " + $ctx.name +" in function " + c.name + " successful");
			}	
		}
		else if (parent instanceof Method_declContext){  //����Ǻ����еľֲ����� 
			Method_declContext c =(Method_declContext)parent;
			List<Var_declContext> var_list = c.var_list;
			
			//�ж��Ƿ���ͬ����������
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
			
				//�ж��Ƿ��Ѿ���ͬ����������
				for(Para_declContext e: para_list) {
					ParaDeclContext t = (ParaDeclContext)e;
					Var_declContext v = t.var;
					if (v.name.equals($ID.text))
					{
						flag = false;
						//System.out.println("para " + $ID.text + " is refined " + "at line "+ $ID.line + ":" + $ID.pos);
						break;	
					}
				}
			}
			
			if (flag) {
				//System.out.println("add new var: " + $ctx.name +" in function " + c.name + " successful");
			}
		}
	}
	;
	
method_decl
locals[
	String name;     //��¼������
	String type;  //��¼����������
	boolean is_static //�Ƿ�Ϊ��̬����
]
:
	(a='public'|'protected'|'private')? (b='static')? 
	func_type ID LEFT_PARA (para_list += para_decl (',' para_list += para_decl)*)? RIGHT_PARA
	'{'
	 (var_list += var_decl SEMICOLON)*
	 (stat_list += stat)*	
	'}'
	{
		$ctx.name = $ID.text;
		$ctx.type = $func_type.text;
		$ctx.is_static = ($b.text != null); 
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
	{
		//���������м��,��ߵ�ID�������,���Һ��ұߵı��ʽ������һ��
				
	}
	|	ID '[' expr ']' '=' expr ';'
	{
		
	}
	;		

expr_list:
	expr(',' expr)*
	;

expr returns [String type]:      //type��¼���ʽ��������
	'(' a=expr ')'
	{
		$type = $a.type;
	}
	|	a = expr '[' expr ']'
	{
		int L=$a.type.length();
		$type = $a.type.substring(0,L-2);
	}
	|	expr '.' 'length'
	{
		$type = "int";
	}
	|   expr.ID '(' (expr_list)? ')'{
		
	}
	|	'new' basic_type  array_decl   //��ά���鶨��
	{
		$type = $basic_type.text+$array_decl.text;
	}  
	|	'new' ID '(' ')'              //����������
	{
		$type = $ID.text;
	}
	|	'!' expr
	{
		$type = "boolean";
	}
	| 	expr MUL_OP  expr
	{
		$type = "int";
	}
	| 	expr ADD_OP expr
	{
		$type = "int";
	}
	| 	expr RELATION_OP expr
	{
		$type = "boolean";
	}
	| 	expr LOGIC_OP expr
	{
		$type = "boolean";
	}
	|  INT
	{
		$type = "int";
	}
	|  ID
	{
		boolean found =false;
		
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
		//this������������������������
		//$type = "boolean";
	}
	;

array_decl:
	('[expr]')+
	;

ASSIGN_OP:
	 '+='|'-='|'*='|'/='
	|'+'|'-'|'*'|'/'
	;
		
SEMICOLON
	: ';'
	;
		
SL_COMMENT
    : '//' .*?  '\n' -> skip  //������ע��,�����ɼ��α����İ�ĵ�181ҳ��12.1��
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
	
ID  :   [a-zA-Z_][a-zA-Z_0-9]* ;    // ƥ���ʶ��

INT :   [0-9]+ ;         // ƥ������

WS  :   [ \r\n\t]+ -> skip ; 		// ���˿հ׷�	

