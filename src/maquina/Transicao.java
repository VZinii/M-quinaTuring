package maquina;
public class Transicao {

    private Estado partida;

    private Estado destino;

    private char simboloEntrada;

    private char simboloSaida;

    private Movimento movimento;

    public Transicao(Estado partida, Estado destino, char entrada, char saida, Movimento movimento){
        simboloEntrada = entrada;
        simboloSaida = saida;
        this.movimento = movimento;
        this.partida = partida;
        this.destino = destino;
    }

    public Estado getPartida() {
        return partida;
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

    @Override
    public String toString() {
        return "(q" + partida.getNumero() + ", q" + destino.getNumero() + ", lê[" + simboloEntrada + "], escreve[" + simboloSaida + "], " + movimento.toString() + ")"; 
    }

}
