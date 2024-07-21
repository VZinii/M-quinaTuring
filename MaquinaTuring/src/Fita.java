import java.util.Arrays;

public class Fita {

    private char[] fita;

    private int posicaoCabecote;

    private final int tamanhoFita = 10000;

    private final int tamanhoTrecho = 120;

    public Fita(){
        // Criando uma fita com infinitos símbolos B (representando o símbolo branco)
        fita = new char[tamanhoFita];
        Arrays.fill(fita, 'B');
        // O cabeçote começa no início da fita:
        posicaoCabecote = 0;
    }

    /**
     * Função utilizada para tentar realizar uma transição
     * @return o símbolo lido na posição atual do cabeçote da fita.
     */
    public char lerSimbolo(){
        return fita[posicaoCabecote];
    }

    /**
     * Tenta mover o cabeçote para a direita, teoricamente seria sempre possível, mas para evitar
     * erros de execução, verifico se não se atingiu o limite da fita.
     * @return True se foi possível realizar o movimento. False, caso contrário.
     */
    private boolean moverDireita(){
        if ( posicaoCabecote < tamanhoFita ){
            posicaoCabecote++;
            return true;
        }
        return false;
    }

    /**
     * Tenta mover o cabeçote para a esquerda. Considerando a máquina de turing padrão. Ela é infinita apenas para a direita.
     * Sendo assim, não pode ir para a esquerda se estiver na posição inicial. Além disso, não existe posição negativa em um vetor.
     * @return True se foi possível realizar o movimento. False, caso contrário.
     */
    private boolean moverEsquerda(){
        if ( posicaoCabecote > 0 ){
            posicaoCabecote--;
            return true;
        }
        return false;
    }

    public void input(String palavraEntrada){
        for (int i=0; i < palavraEntrada.length(); i++){
            fita[i+1] = palavraEntrada.charAt(i);
        }
    }

    /**
     * Essa função tenta realizar uma transição na fita.
     * @param transicao transição a ser realizada
     * @return True, se o símbolo atual da fita corresponder com o símbolo a ser lido da transição. False, caso a máquina trave.
     */
    public boolean realizarTransicao(Transicao transicao){
        char entrada = transicao.getSimboloEntrada();
        char saida = transicao.getSimboloSaida();
        Movimento movimento = transicao.getMovimento();

        // Se não travar:
        if ( lerSimbolo() == entrada ){
            // Troco o símbolo:
            fita[posicaoCabecote] = saida;

            if ( movimento == Movimento.DIREITA ){
                moverDireita();
            }
            else if ( movimento == Movimento.ESQUERDA ){
                moverEsquerda();
            }
            // transição realizada com sucesso;
            return true;
        }
        // máquina travou:
        return false;
    }

    /**
     * 
     * @return a representação de uma parte da fita no momento atual
     */
    public String getTrechoFita(){
        // Primeiro vou mostrar ao usuário a posição do cabeçote de leitura a partir de uma setinha:
        String trechoFita = "";
        for (int i=0; i < posicaoCabecote; i++ ){
            trechoFita += " ";
        }
        trechoFita += "V\n"; // *Setinha para baixo*
        // Agora, adiciono a própria fita:
        for (int i=0; i < tamanhoTrecho; i++){
            trechoFita += fita[i];
        }
        return trechoFita + "\n";
    }

}
