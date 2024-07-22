package maquina;
public enum Movimento {
    
    DIREITA("direita"),
    ESQUERDA("esquerda"),
    PARADO("parado");

    private String movimento;

    private Movimento(String movimento){
        this.movimento = movimento;
    }

    @Override
    public String toString() {
        return movimento;
    }
}
