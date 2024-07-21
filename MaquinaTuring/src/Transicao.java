public class Transicao {

    private Estado destino;

    private char simboloEntrada;

    private char simboloSaida;

    private Movimento movimento;

    public Transicao(Estado partida, Estado destino, char entrada, char saida, Movimento movimento){
        simboloEntrada = entrada;
        simboloSaida = saida;
        this.movimento = movimento;
        this.destino = destino;
    }

    public Estado getDestino() {
        return destino;
    }

    public char getSimboloEntrada() {
        return simboloEntrada;
    }

    public char getSimboloSaida() {
        return simboloSaida;
    }

    public Movimento getMovimento() {
        return movimento;
    }

}
