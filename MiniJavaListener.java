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
	 * Enter a parse tree produced by {@link MiniJavaParser#class_head}.
	 * @param ctx the parse tree
	 */
	void enterClass_head(MiniJavaParser.Class_headContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#class_head}.
	 * @param ctx the parse tree
	 */
	void exitClass_head(MiniJavaParser.Class_headContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#class_body}.
	 * @param ctx the parse tree
	 */
	void enterClass_body(MiniJavaParser.Class_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#class_body}.
	 * @param ctx the parse tree
	 */
	void exitClass_body(MiniJavaParser.Class_bodyContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniJavaParser.TypeContext ctx);
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
}