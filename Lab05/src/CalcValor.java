public enum CalcValor {
    //Definindo constantes
	VALOR_BASE (10.0),
	FATOR_0_30 (1.25),
	FATOR_30_60 (1.0),
	FATOR_60_90 (1.5);

    //Atributo
	private final Double valor;
    
    //Construtor
    CalcValor(double valor) {
		this.valor = valor;
	}

    //Getter
	public Double getValor() {
		return valor;
    }
}