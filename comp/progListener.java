// Generated from C:\Users\rodolfo\Documents\7 PERIODO\CONSTRUCAO DE COMPILADORES\Atividade comp\comp\prog.g4 by ANTLR 4.4

   package comp;
   import java.util.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link progParser}.
 */
public interface progListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link progParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(@NotNull progParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(@NotNull progParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull progParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull progParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#declVar}.
	 * @param ctx the parse tree
	 */
	void enterDeclVar(@NotNull progParser.DeclVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#declVar}.
	 * @param ctx the parse tree
	 */
	void exitDeclVar(@NotNull progParser.DeclVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#declConst}.
	 * @param ctx the parse tree
	 */
	void enterDeclConst(@NotNull progParser.DeclConstContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#declConst}.
	 * @param ctx the parse tree
	 */
	void exitDeclConst(@NotNull progParser.DeclConstContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull progParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull progParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#impressao}.
	 * @param ctx the parse tree
	 */
	void enterImpressao(@NotNull progParser.ImpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#impressao}.
	 * @param ctx the parse tree
	 */
	void exitImpressao(@NotNull progParser.ImpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#atrib}.
	 * @param ctx the parse tree
	 */
	void enterAtrib(@NotNull progParser.AtribContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#atrib}.
	 * @param ctx the parse tree
	 */
	void exitAtrib(@NotNull progParser.AtribContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(@NotNull progParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(@NotNull progParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull progParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull progParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(@NotNull progParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(@NotNull progParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(@NotNull progParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(@NotNull progParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link progParser#listaIds}.
	 * @param ctx the parse tree
	 */
	void enterListaIds(@NotNull progParser.ListaIdsContext ctx);
	/**
	 * Exit a parse tree produced by {@link progParser#listaIds}.
	 * @param ctx the parse tree
	 */
	void exitListaIds(@NotNull progParser.ListaIdsContext ctx);
}