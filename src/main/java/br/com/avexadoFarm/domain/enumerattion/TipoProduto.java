package br.com.avexadoFarm.domain.enumerattion;

public enum TipoProduto {

    FIBRA_GRAO("Fibra"),
    PROTEINA("Proteína"),
    TERMOGENICO("Termogênico");

    private String tipo;

    private TipoProduto(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
