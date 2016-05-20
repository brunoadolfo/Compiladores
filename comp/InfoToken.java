package comp;

/*
* Classe auxiliar para a construção da Tabela de Símbolos
* categoria: 0-variavel ou 1-constante
* tipo: 0-int; 1-float ou 2-bool
* valor: valor da constante ou variavel
*/
public class InfoToken {
    private int categoria;
    private int tipo;
    private double valor;

    public InfoToken(int categoria, int tipo, double valor) {
        this.categoria = categoria;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
   
}
