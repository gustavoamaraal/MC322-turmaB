public enum CalcSeguro {
    //Definindo constantes
	VALOR_BASE (100.0),
	FATOR_18_30 (1.2),
	FATOR_30_60 (1.0),
	FATOR_60_90 (1.5);

    //Atributo
	private final Double valor;
    
    //Construtor
    CalcSeguro(double valor) {
		this.valor = valor;
	}

    //Getter
	public Double getValor() {
		return valor;
    }
}