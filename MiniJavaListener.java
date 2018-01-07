// Generated from MiniJava.g4 by ANTLR 4.7.1

	import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MiniJavaParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MiniJavaParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void enterClass_decl(MiniJavaParser.Class_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void exitClass_decl(MiniJavaParser.Class_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#class_head_name}.
	 * @param ctx the parse tree
	 */
	void enterClass_head_name(MiniJavaParser.Class_head_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#class_head_name}.
	 * @param ctx the parse tree
	 */
	void exitClass_head_name(MiniJavaParser.Class_head_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(MiniJavaParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(MiniJavaParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void enterMethod_decl(MiniJavaParser.Method_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void exitMethod_decl(MiniJavaParser.Method_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#func_head_name}.
	 * @param ctx the parse tree
	 */
	void enterFunc_head_name(MiniJavaParser.Func_head_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#func_head_name}.
	 * @param ctx the parse tree
	 */
	void exitFunc_head_name(MiniJavaParser.Func_head_nameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParaDecl}
	 * labeled alternative in {@link MiniJavaParser#para_decl}.
	 * @param ctx the parse tree
	 */
	void enterParaDecl(MiniJavaParser.ParaDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParaDecl}
	 * labeled alternative in {@link MiniJavaParser#para_decl}.
	 * @param ctx the parse tree
	 */
	void exitParaDecl(MiniJavaParser.ParaDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#func_type}.
	 * @param ctx the parse tree
	 */
	void enterFunc_type(MiniJavaParser.Func_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#func_type}.
	 * @param ctx the parse tree
	 */
	void exitFunc_type(MiniJavaParser.Func_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(MiniJavaParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(MiniJavaParser.Var_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void enterBasic_type(MiniJavaParser.Basic_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#basic_type}.
	 * @param ctx the parse tree
	 */
	void exitBasic_type(MiniJavaParser.Basic_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#array_type}.
	 * @param ctx the parse tree
	 */
	void enterArray_type(MiniJavaParser.Array_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#array_type}.
	 * @param ctx the parse tree
	 */
	void exitArray_type(MiniJavaParser.Array_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#class_body_start}.
	 * @param ctx the parse tree
	 */
	void enterClass_body_start(MiniJavaParser.Class_body_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#class_body_start}.
	 * @param ctx the parse tree
	 */
	void exitClass_body_start(MiniJavaParser.Class_body_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#class_body_end}.
	 * @param ctx the parse tree
	 */
	void enterClass_body_end(MiniJavaParser.Class_body_endContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#class_body_end}.
	 * @param ctx the parse tree
	 */
	void exitClass_body_end(MiniJavaParser.Class_body_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(MiniJavaParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(MiniJavaParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(MiniJavaParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(MiniJavaParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MiniJavaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MiniJavaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#array_index}.
	 * @param ctx the parse tree
	 */
	void enterArray_index(MiniJavaParser.Array_indexContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#array_index}.
	 * @param ctx the parse tree
	 */
	void exitArray_index(MiniJavaParser.Array_indexContext ctx);
}