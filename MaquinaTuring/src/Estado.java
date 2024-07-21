import java.util.ArrayList;

public class Estado {

    private ArrayList<Transicao> transicoes;
    
    private int numero;

    private boolean finaL;

    private static int quantidadeEstados = 0;

    public Estado(){
        numero = quantidadeEstados;
        finaL = false;
        transicoes = new ArrayList<>();
    }

    public void adicionarTransicao(Transicao transicao){
        transicoes.add(transicao);
    }

    public Transicao buscarTransicaoCompativel(char entrada){
        for (Transicao t: transicoes){
            if ( t.getSimboloEntrada() == entrada ){
                return t;
            }
        }
        return null;
    }

    public int getNumero() {
        return numero;
    }

    public boolean ehFinal(){
        return finaL;
    }

    public void setFinaL(boolean finaL) {
        this.finaL = finaL;
    }
}
