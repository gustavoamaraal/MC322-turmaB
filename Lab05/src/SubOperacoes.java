public enum SubOperacoes {
    //Definindo constantes
	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	CADASTRAR_SEGURO("Cadastrar seguro"),
	CADASTRAR_FROTA("Cadastrar frota"),
	CADASTRAR_CONDUTOR("Cadastrar condutor"),
	LISTAR_CLIENTES_POR_SEG("Listar cliente por seguradora"),
	LISTAR_SINISTROS_POR_SEG("Listar sinistros por seguradora"),
	LISTAR_SINISTROS_POR_SEGURO("Listar sinistros por seguro"),
	LISTAR_VEICULOS_POR_SEG("Listar veiculo por seguradora"),
	LISTAR_VEICULOS_POR_CLI("Listar veiculo por cliente"),
	LISTAR_SEGUROS_POR_SEG("Listar seguros por seguradora"),
	LISTAR_SEGUROS_POR_CLI("Listar seguros por cliente"),
	LISTAR_FROTAS_POR_SEG("Listar frotas por seguradora"),
	LISTAR_FROTAS_POR_CLI("Listar frotas por cliente"),
	LISTAR_CONDUTORES_POR_SEG("Listar condutores por seguradora"),
	LISTAR_CONDUTORES_POR_SEGURO("Listar condutores por seguro"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veiculo"),
	EXCLUIR_SINISTRO("Excluir sinistro"),
	EXCLUIR_SEGURO("Excluir seguro"),
	EXCLUIR_FROTA("Excluir frota"),
	EXCLUIR_CONDUTOR("Excluir condutor"),
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
