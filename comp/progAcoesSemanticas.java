package comp;

import java.util.Iterator;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;



public class progAcoesSemanticas extends progBaseListener {
    progParser parser;
    public progAcoesSemanticas(progParser parser) {
        this.parser = parser;
    }

    public void exitTipo(progParser.TipoContext ctx) { 
        if (ctx.getText().equals("int"))
            ctx.val = 0;
        else if (ctx.getText().equals("float"))
            ctx.val = 1;
        else ctx.val = 2; // bool
    }

    public void exitDeclVar(progParser.DeclVarContext ctx) { 
        for (int i=0; i<ctx.listaIds().ID().size(); i++){
            if (!parser.memory.containsKey(ctx.listaIds().ID(i).getText()))
                parser.memory.put(ctx.listaIds().ID(i).getText(),new InfoToken(0, ctx.tipo().val,0.0));
            else {
                System.err.println("Erro: identificador ja declarado! "+ctx.listaIds().ID(i).getText());
                System.exit(0);            }

        }
    }
    public void exitDeclConst(progParser.DeclConstContext ctx) { 
        if (!parser.memory.containsKey(ctx.ID().getText()))
            parser.memory.put(ctx.ID().getText(), new InfoToken(1, ctx.tipo().val, Double.parseDouble(ctx.NUM().getText())));
        else {
            System.out.println("Erro: identificador ja declarado! "+ctx.ID().getText());
            System.exit(0);
        }
    }
    public void exitImpressao(progParser.ImpressaoContext ctx) {
        if(ctx.getText().contains("All")){            
            Iterator it = parser.memory.keySet().iterator();
            while (it.hasNext()){
                Object ob = it.next();
                InfoToken info = parser.memory.get(ob);
                System.out.println(ob+"="+info.getValor());
            }
        }else{
            Iterator it = ctx.listaIds().ID().iterator();
            while (it.hasNext()){
                String ob = ((TerminalNodeImpl)it.next()).getText();
                if (parser.memory.containsKey(ob)) 
                    System.out.println(ob+"="+parser.memory.get(ob).getValor());
                else {
                    System.out.println("Erro: identificador nao declarado! "+ob);
                    System.exit(0);
                }
            }
        }        
    }
    public void exitExpr(progParser.ExprContext ctx) {
        if (ctx.op != null) {
            if (ctx.op.getText().equals("+"))
                ctx.val = ctx.termo().val + ctx.expr().val;
            else if (ctx.op.getText().equals("-"))
                ctx.val = ctx.termo().val - ctx.expr().val;
            else {
                System.out.println("Erro: operador invalido! "+ctx.op.getText());
                System.exit(0);
            }
        } else ctx.val = ctx.termo().val;
    }  
    
    public void exitTermo(progParser.TermoContext ctx) {
        if (ctx.op != null) {
            if (ctx.op.getText().equals("*"))
                ctx.val = ctx.fator().val * ctx.termo().val;
            else if (ctx.op.getText().equals("/"))
                ctx.val = ctx.fator().val / ctx.termo().val;
            else {
                System.out.println("Erro: operador invalido! "+ctx.op.getText());
                System.exit(0);
            }
        } else ctx.val = ctx.fator().val;
    }
    public void exitFator(progParser.FatorContext ctx) {
        if (ctx.ID() != null) {
            if (parser.memory.containsKey(ctx.ID().getText()))
                ctx.val = parser.memory.get(ctx.ID().getText()).getValor();
            else {
                System.out.println("Erro: identificador nao declarado! "+ctx.ID().getText());
                System.exit(0);
            }                
        } else if (ctx.NUM()!= null) {
            ctx.val = Double.parseDouble(ctx.NUM().getText());
        } else 
            ctx.val = ctx.expr().val;
    }
    public void exitAtrib(progParser.AtribContext ctx) { 
        if (parser.memory.containsKey(ctx.ID().getText())) {
            InfoToken tok = parser.memory.get(ctx.ID().getText());
            if(tok.getCategoria() == 1){
                System.out.println("Erro: A variavel e constante!");
                return;
            }
            tok.setValor(ctx.expr().val);
            parser.memory.put(ctx.ID().getText(), tok);
        }
        else {
            System.out.println("Erro: identificador nao declarado! "+ctx.ID().getText());
            System.exit(0);
        }                    
    }
}
