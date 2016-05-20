package comp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class MainApp {

    public static void main(String args[]) throws FileNotFoundException, IOException {
        //abertura/leitura arquivo de entrada 
        String inputFile = "C:/Users/rodolfo/Documents/7 PERIODO/CONSTRUCAO DE COMPILADORES/Atividade comp/comp/input1.txt";
        InputStream is = new FileInputStream (inputFile);
        ANTLRInputStream  input = new ANTLRInputStream(is);
        
        //Lexico
        progLexer lexer = new progLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        //Parse
        progParser parser = new progParser(tokens);
        ParseTree tree = parser.prog();
               
        //acoes semanticas, atraves de listener
        progAcoesSemanticas listener = new progAcoesSemanticas(parser);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, tree);
        
        //MostrarTabSimb(parser);

        //System.out.println(tree.toStringTree(parser));    
        
    }

    public static void MostrarTabSimb(progParser parser) {
        //impressao Tabela de Simbolos
        System.out.println("Tabela de Simbolos");
        Iterator it = parser.memory.keySet().iterator();
        while (it.hasNext()){
            Object ob = it.next();
            InfoToken info = parser.memory.get(ob);
            System.out.println(ob+"->"+info.getCategoria()+","+info.getTipo()+","+info.getValor());
        }
    }
}
