public enum SubOperacoes {
    //Definindo constantes
	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	LISTAR_CLIENTES_POR_SEG("Listar cliente por seguradora"),
	LISTAR_SINISTROS_POR_SEG("Listar sinistros por seguradora"),
	LISTAR_SINISTROS_POR_CLI("Listar sinistros por cliente"),
	LISTAR_VEICULOS_POR_SEG("Listar veiculo por seguradora"),
	LISTAR_VEICULOS_POR_CLI("Listar veiculo por cliente"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veiculo"),
	EXCLUIR_SINISTRO("Excluir sinistro"),
	VOLTAR("Voltar");
	
	//Atributo
	private final String descricao;
	
	//Construtor
	SubOperacoes(String descricao){
		this.descricao = descricao;
	}
	
	//Getter
	public String getDescricao() {
		return descricao;
	}
}
