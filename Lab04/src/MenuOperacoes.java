public enum MenuOperacoes {
	CADASTROS("Cadastros", new SubOperacoes[] {
        //Submenu de CADASTROS
        SubOperacoes.CADASTRAR_CLIENTE,
        SubOperacoes.CADASTRAR_VEICULO,
        SubOperacoes.CADASTRAR_SEGURADORA,
        SubOperacoes.VOLTAR
    }),
    LISTAR("Listar", new SubOperacoes[] {
        //Submenu de LISTAR
        SubOperacoes.LISTAR_CLIENTES_POR_SEG,
        SubOperacoes.LISTAR_SINISTROS_POR_SEG,
        SubOperacoes.LISTAR_SINISTROS_POR_CLI,
        SubOperacoes.LISTAR_VEICULOS_POR_SEG,
        SubOperacoes.LISTAR_VEICULOS_POR_CLI,
        SubOperacoes.VOLTAR
    }),
    EXCLUIR("Excluir", new SubOperacoes[] {
        //Submenu de EXCLUIR
        SubOperacoes.EXCLUIR_CLIENTE,
        SubOperacoes.EXCLUIR_VEICULO,
        SubOperacoes.EXCLUIR_SINISTRO,
        SubOperacoes.VOLTAR}),
    GERAR_SINISTRO("Gerar Sinistro", new SubOperacoes[] {SubOperacoes.VOLTAR}),
    TRANSFERIR_SEGURO("Transferir Seguro", new SubOperacoes[] {SubOperacoes.VOLTAR}),
    CALCULAR_RECEITA("Calcular Receita", new SubOperacoes[] {SubOperacoes.VOLTAR}),
    SAIR("Sair", new SubOperacoes[] {});

    //Atributos
    private final String descricao;
    private final SubOperacoes[] submenu;

    //Construtor
    MenuOperacoes(String descricao, SubOperacoes[] submenu){
        this.descricao = descricao;
        this.submenu = submenu;
    }

    //Getters
    public String getDescricao() {
        return descricao;
    }

    public SubOperacoes[] getSubmenu() {
        return submenu;
    }
}
