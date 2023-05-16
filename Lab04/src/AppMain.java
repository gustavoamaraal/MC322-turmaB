import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

class AppMain {

    //Mostra as seguradoras selecionáveis e retorna o índice dessa seguradora em listaSeguradora
    public static int selecionarSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        System.out.println("Selecione uma seguradora: ");
        int a = 1;
        for (Seguradora seguradora:listaSeguradora) {
            System.out.println(a + " - " + seguradora.getNome());
            a++;
        }
        int b = scanner.nextInt();
        return (b-1);
    }

    //Mostra os clientes selecionáveis e retorna o índice desse cliente em listaClientes
    public static int selecionarCliente(Scanner scanner, Seguradora seguradora) {
        System.out.println("Selecione um(a) cliente: ");
        int a = 1;
        for (Cliente cliente:seguradora.getListaClientes()) {
            System.out.println(a + " - " + cliente.getNome());
            a++;
        }
        int b = scanner.nextInt();
        return (b-1);
    }

    //Mostra os sinistros selecionáveis e retorna o índice desse sinistro em listaSinistros
    public static int selecionarSinistro(Scanner scanner, Seguradora seguradora) {
        System.out.println("Selecione um sinistro: ");
        int a = 1;
        for (Sinistro sinistro:seguradora.getListaSinistros()) {
            System.out.println(a + " - " + sinistro.getId() + ", de " + sinistro.getCliente().getNome() + " na data " + sinistro.getData() + "(ano-mes-dia)");
            a++;
        }
        int b = scanner.nextInt();
        return (b-1);
    }

    //Mostra os veículos selecionáveis e retorna o índice desse veiculo em listaVeiculos
    public static int selecionarVeiculo(Scanner scanner, Cliente cliente) {
        System.out.println("Selecione um veiculo: ");
        int a = 1;
        for (Veiculo veiculo:cliente.getListaVeiculos()) {
            System.out.println(a + " - " + veiculo.getModelo() + "(placa " + veiculo.getPlaca() + ")");
            a++;
        }
        int b = scanner.nextInt();
        return (b-1);        
    }

    //Cadastra clientePF
    public static ClientePF cadastrarClientePF(Scanner scanner, ArrayList<Seguradora> listaSeguradora, int indexSeguradora) {
        //Usa o System.in para receber dados de um clientePF e criá-lo

        System.out.println("Cadastro de Pessoa Fisica");
        //Nome
        String nome = "";
        boolean aux = true;
        while (aux) {
            System.out.print("Digite o nome do(a) cliente: ");
            nome = scanner.nextLine();
            if (Validacao.validarNome(nome))
                aux = false;
            else    
                System.out.print("Nome invalido! ");
        }
        //Endereço
        System.out.print("Digite o endereco do(a) cliente: ");
        String endereco = scanner.nextLine();
        //CPF
        String CPF = "";
        boolean aux2 = true;
        while (aux2) {
            System.out.print("Digite o CPF do(a) cliente: ");
            CPF = scanner.nextLine();
            if (Validacao.validarCPF(CPF))
                aux2 = false;
            else    
                System.out.print("CPF invalido! ");
        }
        //Gênero
        System.out.print("Digite o genero do(a) cliente: ");
        String genero = scanner.nextLine();
        //Data de licença
        System.out.print("Digite o ANO da data de licenca do(a) cliente: ");
        String anoL = scanner.nextLine();
        System.out.print("Digite o MES da data de licenca do(a) cliente: ");
        String mesL = scanner.nextLine();
        System.out.print("Digite o DIA da data de licenca do(a) cliente: ");
        String diaL = scanner.nextLine();    
        LocalDate dataLicenca = LocalDate.parse(anoL+"-"+mesL+"-"+diaL);
        //Educação
        System.out.print("Digite o nivel de educação do(a) cliente: ");
        String educacao = scanner.nextLine();
        //Data de Nascimento
        System.out.print("Digite o ANO da data de nascimento do(a) cliente: ");
        String anoN = scanner.nextLine();
        System.out.print("Digite o MES da data de nascimento do(a) cliente: ");
        String mesN = scanner.nextLine();
        System.out.print("Digite o DIA da data de nascimento do(a) cliente: ");
        String diaN = scanner.nextLine();    
        LocalDate dataNascimento = LocalDate.parse(anoN+"-"+mesN+"-"+diaN);
        //Classe econômica
        System.out.print("Digite a classe economica do(a) cliente: ");
        String classeEconomica = scanner.nextLine();
        System.out.print("\n");
        //Gera um clientePF
        ClientePF cliente = new ClientePF(nome, endereco, CPF, genero, dataLicenca, educacao, dataNascimento, classeEconomica);
        listaSeguradora.get(indexSeguradora).cadastrarCliente(cliente);
        //Retorna esse cliente
        return cliente;
    }

    //Cadastra clientePJ
    public static ClientePJ cadastrarClientePJ(Scanner scanner, ArrayList<Seguradora> listaSeguradora, int indexSeguradora) {
        //Usa o System.in para receber dados de um clientePJ e criá-lo

        System.out.println("Cadastro de Pessoa Juridica");
        //Nome
        String nome = "";
        boolean aux = true;
        while (aux) {
            System.out.print("Digite o nome do(a) cliente: ");
            nome = scanner.nextLine();
            if (Validacao.validarNome(nome))
                aux = false;
            else    
                System.out.print("Nome invalido! ");
        }
        //Endereco
        System.out.print("Digite o endereço do(a) cliente: ");
        String endereco = scanner.nextLine();
        //CNPJ
        String CNPJ = "";
        boolean aux2 = true;
        while (aux2) {
            System.out.print("Digite o CNPJ do(a) cliente: ");
            CNPJ = scanner.nextLine();
            if (Validacao.validarCNPJ(CNPJ))
                aux2 = false;
            else    
                System.out.print("CNPJ invalido! ");
        }
        //Data de fundação
        System.out.print("Digite o ANO da data de fundacao do(a) cliente: ");
        String anoF = scanner.nextLine();
        System.out.print("Digite o MES da data de fundacao do(a) cliente: ");
        String mesF = scanner.nextLine();
        System.out.print("Digite o DIA da data de fundacao do(a) cliente: ");
        String diaF = scanner.nextLine();    
        LocalDate dataFundacao = LocalDate.parse(anoF+"-"+mesF+"-"+diaF);
        System.out.print("\n");
        //Gera um clientePJ
        ClientePJ cliente = new ClientePJ(nome, endereco, CNPJ, dataFundacao);
        listaSeguradora.get(indexSeguradora).cadastrarCliente(cliente);
        //Retorna o cliente
        return cliente;
    }

    //Reune cadastrarClientePF e cadastrarClientePJ para cadastrar um cliente
    public static void cadastrarCliente(Scanner scanner, ArrayList<Seguradora> listaSeguradora, int indexSeguradora) {
        scanner.nextLine();
        System.out.print("Qual o tipo de cliente que deseja cadastrar? Responda apenas com 'PF' ou' PJ', sem as aspas: ");
        String tipo = scanner.nextLine();       
        if (tipo.equals("PF"))
            cadastrarClientePF(scanner, listaSeguradora, indexSeguradora);
        else if (tipo.equals("PJ"))
            cadastrarClientePJ(scanner, listaSeguradora, indexSeguradora);
    }

    //Cadastra uma seguradora
    public static Seguradora cadastrarSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        //Usa o System.in para receber dados de uma seguradora e criá-la

        System.out.println("Cadastro de Seguradora");
        scanner.nextLine();
        //Nome
        String nome = "";
        boolean aux = true;
        while (aux) {
            System.out.print("Digite o nome do(a) cliente: ");
            nome = scanner.nextLine();
            if (Validacao.validarNome(nome))
                aux = false;
            else    
                System.out.print("Nome invalido! ");
        }
        //Endereço
        System.out.print("Digite o endereco da seguradora: ");
        String endereco = scanner.nextLine();
        //Telefone
        System.out.print("Digite o telefone da seguradora: ");
        String telefone = scanner.nextLine();
        //Email
        System.out.print("Digite o email da seguradora: ");
        String email = scanner.nextLine();
        System.out.print("\n");
        //Cria a seguradora e a adiciona na lista de seguradoras
        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);
        listaSeguradora.add(seguradora);
        //Retorna a seguradora
        return seguradora;
    }

    //Cadastra um veiculo
    public static Veiculo cadastrarVeiculo(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = selecionarSeguradora(scanner, listaSeguradora);
        int b = selecionarCliente(scanner, listaSeguradora.get(a));

        //Usa o System.in para receber dados de um veículo e criá-lo

        System.out.println("Cadastro de Veiculo");
        scanner.nextLine();
        //Placa
        System.out.print("Digite a placa do veiculo: ");
        String placa = scanner.nextLine();
        //Marca
        System.out.print("Digite a marca do veiculo: ");
        String marca = scanner.nextLine();
        //Modelo
        System.out.print("Digite o modelo do veiculo: ");
        String modelo = scanner.nextLine();
        //Ano de fabricação
        System.out.print("Digite o ano de fabricacao do veiculo: ");
        int anoFabricacao = Integer.parseInt(scanner.nextLine());
        System.out.print("\n");
        //Cria um veiculo e o adiciona na lista de veículos do cliente
        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
        listaSeguradora.get(a).getListaClientes().get(b).adicionaVeiculo(veiculo);
        //Retorna o veiculo
        return veiculo;        
    }

    //Exclui todos os sinistros de um cliente. É chamado em excluirCliente
    public static void excluirTodosSinistros(Cliente cliente, ArrayList<Seguradora> listaSeguradora, int indexSeguradora) {
        for (int i = 0; i < listaSeguradora.get(indexSeguradora).getListaSinistros().size(); i++) {
            if (listaSeguradora.get(indexSeguradora).getListaSinistros().get(i).getCliente().equals(cliente)) {
                listaSeguradora.get(indexSeguradora).getListaSinistros().remove(i);
            }
        }
    }

    //Exclui um cliente
    public static boolean excluirCliente(Cliente cliente, ArrayList<Seguradora> listaSeguradora, int indexSeguradora) {
        for (Cliente i:listaSeguradora.get(indexSeguradora).getListaClientes()) {
            if (i.equals(cliente)) {
                excluirTodosSinistros(cliente, listaSeguradora, indexSeguradora);
                System.out.println("\nCliente " + cliente.getNome() + " removido!\n");
                listaSeguradora.get(indexSeguradora).getListaClientes().remove(cliente);
                return true;
            }
        }
        System.out.println("\nO cliente nao esta cadastrado nessa seguradora!\n");
        return false;
    }

    //Exclui um veiculo
    public static boolean excluirVeiculo(Veiculo veiculo, ArrayList<Seguradora> listaSeguradora, int indexSeguradora, int indexCliente) {
        for (Veiculo i:listaSeguradora.get(indexSeguradora).getListaClientes().get(indexCliente).getListaVeiculos()) {
            if (i.equals(veiculo)) {
                listaSeguradora.get(indexSeguradora).getListaClientes().get(indexCliente).getListaVeiculos().remove(veiculo);
                System.out.println("\nVeiculo removido!");
                return true;
            }
        }
        System.out.println("\nO veiculo nao esta cadastrado!");        
        return false;
    }

    //Tranfere os veiculos de um cliente para outro e exclui esse primeiro cliente
    public static void transferirSeguro(Scanner scanner, ArrayList<Seguradora> listaSeguradora, int indexSeguradora, int indexCliente1, int indexCliente2) {
        Double novoScore;
        for (Veiculo veiculo:listaSeguradora.get(indexSeguradora).getListaClientes().get(indexCliente1).getListaVeiculos()) {
            listaSeguradora.get(indexSeguradora).getListaClientes().get(indexCliente2).getListaVeiculos().add(veiculo);
        }
        if (listaSeguradora.get(indexSeguradora).getListaClientes().get(indexCliente2) instanceof ClientePF) {
            novoScore = ((ClientePF) listaSeguradora.get(indexSeguradora).getListaClientes().get(indexCliente2)).calculaScore();
        }
        else if (listaSeguradora.get(indexSeguradora).getListaClientes().get(indexCliente2) instanceof ClientePJ) {
            novoScore = ((ClientePJ) listaSeguradora.get(indexSeguradora).getListaClientes().get(indexCliente2)).calculaScore();
        }        
        System.out.print("\nSeguro transferido! ");
        excluirCliente(listaSeguradora.get(indexSeguradora).getListaClientes().get(indexCliente1), listaSeguradora, indexSeguradora);
    }

	//Exibe menu externo
	private static void exibirMenuExterno(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
		MenuOperacoes menuOperacoes[] = MenuOperacoes.values();
		System.out.println("Menu principal");
		for (MenuOperacoes op:menuOperacoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	//Exibe submenus
	private static void exibirSubmenu(MenuOperacoes op, Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
		SubOperacoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for (int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}
	
	//Lê opções do menu externo
	private static MenuOperacoes lerOpcaoMenuExterno(Scanner scanner) {
		int opUsuario;
		MenuOperacoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		} while (opUsuario < 0 || opUsuario > MenuOperacoes.values().length - 1);
		opUsuarioConst = MenuOperacoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	//Lê opções dos submenus
	private static SubOperacoes lerOpcaoSubmenu(MenuOperacoes op, Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
		int opUsuario;
		SubOperacoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		} while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	//Executa opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOperacoes op, Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op, scanner, listaSeguradora);
				break;
			case GERAR_SINISTRO:
                int a = selecionarSeguradora(scanner, listaSeguradora);
                listaSeguradora.get(a).gerarSinistro(scanner);
				break;
			case TRANSFERIR_SEGURO:
                int b = selecionarSeguradora(scanner, listaSeguradora);
                System.out.print("(Cliente que ira transferir o seguro) ");
                int c = selecionarCliente(scanner, listaSeguradora.get(b));
                System.out.print("(Cliente que ira receber o seguro) ");
                int d = selecionarCliente(scanner, listaSeguradora.get(b));
                transferirSeguro(scanner, listaSeguradora, b, c, d);
				break;
			case CALCULAR_RECEITA:
				int f = selecionarSeguradora(scanner, listaSeguradora);
                System.out.println("Receita da seguradora " + listaSeguradora.get(f).getNome() + ": " + listaSeguradora.get(f).calcularReceita());
				break;
			case SAIR:
                break;
		}
	}
	
    //Executa opções do submenu
	public static void executarOpcaoSubMenu(SubOperacoes opSubmenu, Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
            int o = selecionarSeguradora(scanner, listaSeguradora);
            cadastrarCliente(scanner, listaSeguradora, o);
			break;
		case CADASTRAR_VEICULO:
            cadastrarVeiculo(scanner, listaSeguradora);
			break;
		case CADASTRAR_SEGURADORA:
            cadastrarSeguradora(scanner, listaSeguradora);
			break;
		case LISTAR_CLIENTES_POR_SEG:
            int a = selecionarSeguradora(scanner, listaSeguradora);
            scanner.nextLine();
            System.out.print("Qual o tipo de clientes? Responda apenas com 'PF' ou' PJ', sem as aspas: ");
            String tipo = scanner.nextLine();
            listaSeguradora.get(a).listarClientes(tipo);
			break;
		case LISTAR_SINISTROS_POR_SEG:
            int b = selecionarSeguradora(scanner, listaSeguradora);
            listaSeguradora.get(b).listarSinistros();
			break;
		case LISTAR_SINISTROS_POR_CLI:
            int c = selecionarSeguradora(scanner, listaSeguradora);
            int d = selecionarCliente(scanner, listaSeguradora.get(c));
            listaSeguradora.get(c).listarSinistrosPorCliente(listaSeguradora.get(c).getListaClientes().get(d));
			break;
		case LISTAR_VEICULOS_POR_CLI:
            int e = selecionarSeguradora(scanner, listaSeguradora);
            int f = selecionarCliente(scanner, listaSeguradora.get(e));
            listaSeguradora.get(e).getListaClientes().get(f).listaVeiculosPorCliente();
			break;
        case LISTAR_VEICULOS_POR_SEG:
            int g = selecionarSeguradora(scanner, listaSeguradora);
            for (Cliente cliente:listaSeguradora.get(g).getListaClientes()) {
                cliente.listaVeiculosPorCliente();
            }
            break;
		case EXCLUIR_CLIENTE:
            int h = selecionarSeguradora(scanner, listaSeguradora);
            int i = selecionarCliente(scanner, listaSeguradora.get(h));
            excluirCliente(listaSeguradora.get(h).getListaClientes().get(i), listaSeguradora, h);
			break;
		case EXCLUIR_VEICULO:
            int j = selecionarSeguradora(scanner, listaSeguradora);
            int k = selecionarCliente(scanner, listaSeguradora.get(j));
            int l = selecionarVeiculo(scanner, listaSeguradora.get(j).getListaClientes().get(k));
            excluirVeiculo(listaSeguradora.get(j).getListaClientes().get(k).getListaVeiculos().get(l), listaSeguradora, j, k);
			break;
		case EXCLUIR_SINISTRO:
            int m = selecionarSeguradora(scanner, listaSeguradora);
            int n = selecionarSinistro(scanner, listaSeguradora.get(m));
            listaSeguradora.get(m).getListaSinistros().remove(listaSeguradora.get(m).getListaSinistros().get(n));
			break;
		case VOLTAR:
			break;
		}
	}
	
	//Executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOperacoes op, Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
		SubOperacoes opSubmenu;
		do {
			exibirSubmenu(op, scanner, listaSeguradora);
			opSubmenu = lerOpcaoSubmenu(op, scanner, listaSeguradora);
			executarOpcaoSubMenu(opSubmenu, scanner, listaSeguradora);
		} while(opSubmenu != SubOperacoes.VOLTAR);
	}

    public static void main(String[] args) {

        //Cria um objeto da classe Scanner, que será utilizado para realizar a leitura de dados
        Scanner scanner = new Scanner(System.in);

        //Cria uma lista com todas as seguradoras existentes
        ArrayList<Seguradora> listaSeguradora = new ArrayList<Seguradora>();

        //Instanciando um objeto da classe Seguradora
        Seguradora seguradora1 = new Seguradora("Seguradora 1", "19 98765-4321", "Email seg1", "Rua C");

        //Instanciando objetos das classes ClientePF e ClientePJ
        ClientePF clientePF1 = new ClientePF("Nome 1", "Rua A", "238.398.430-22", "Genero 1", LocalDate.parse("2021-12-12"), "Nivel 1", LocalDate.parse("1990-10-05"), "Classe 1");
        ClientePF clientePF2 = new ClientePF("Nome 2", "Rua B", "68TESTE8.73TESTE5.730-53", "Genero 2", LocalDate.parse("2019-04-13"), "Nivel 2", LocalDate.parse("2000-01-02"), "Classe 2");
        ClientePJ clientePJ1 = new ClientePJ("Nome 3", "Rua C", "56.094.270/0001-63", LocalDate.parse("2011-11-11"));
        ClientePJ clientePJ2 = new ClientePJ("Nome 4", "Rua A", "TESTE99569990/0001-40", LocalDate.parse("1970-10-07"));

        //Instanciando objetos da classe Veiculo
        Veiculo veiculo1 = new Veiculo("ABC1111", "Marca 1", "Modelo 11", 2019);
        Veiculo veiculo2 = new Veiculo("ABC2222", "Marca 1", "Modelo 12", 2018);
        Veiculo veiculo3 = new Veiculo("ABC3333", "Marca 4", "Modelo 44", 2017);
        Veiculo veiculo4 = new Veiculo("ABC4444", "Marca 5", "Modelo 51", 2016);
        Veiculo veiculo5 = new Veiculo("ABC5555", "Marca 2", "Modelo 23", 2015);
        Veiculo veiculo6 = new Veiculo("ABC6666", "Marca 3", "Modelo 33", 2014);
        Veiculo veiculo7 = new Veiculo("ABC7777", "Marca 3", "Modelo 35", 2013);
        Veiculo veiculo8 = new Veiculo("ABC8888", "Marca 2", "Modelo 23", 2012);
        Veiculo veiculo9 = new Veiculo("ABC9999", "Marca 6", "Modelo 61", 2011);

        //Adicionando os veiculos aos clientes
        clientePF1.adicionaVeiculo(veiculo1);
        clientePF2.adicionaVeiculo(veiculo2);
        clientePF2.adicionaVeiculo(veiculo3);
        clientePJ1.adicionaVeiculo(veiculo4);
        clientePJ2.adicionaVeiculo(veiculo5);
        clientePJ1.adicionaVeiculo(veiculo6);
        clientePF1.adicionaVeiculo(veiculo7);
        clientePF2.adicionaVeiculo(veiculo8);
        clientePJ1.adicionaVeiculo(veiculo9);

        //Cadastrando em seguradora1 os 4 clientes que já foram gerados
        seguradora1.cadastrarCliente(clientePF1);
        seguradora1.cadastrarCliente(clientePF2);
        seguradora1.cadastrarCliente(clientePJ1);
        seguradora1.cadastrarCliente(clientePJ2);

        //Listando os clientes de seguradora1
        seguradora1.listarClientes("PF");
        seguradora1.listarClientes("PJ");

        //Gerando 2 objetos da classe Sinistro (em algum dos sinistros, recomendo selecionar o clientePF1 pois depois será chamado um método para visualizar sinistros desse cliente)
        seguradora1.gerarSinistro(scanner);
        seguradora1.gerarSinistro(scanner);

        //Listando os clientes de seguradora1
        seguradora1.listarClientes("PF");
        seguradora1.listarClientes("PJ");

        //Listando os sinistros de seguradora1
        seguradora1.listarSinistros();

        //Visualizando sinistros de clientePF1 (chama o método toString dos sinistros associados a esse cliente)
        seguradora1.visualizarSinistro(clientePF1.getCpf());

        //Calculando o valor da receita e atualizando o atributo valorSeguro de cada cliente cadastrado na seguradora
        System.out.print("Receita atual da Seguradora 1: " + seguradora1.calcularReceita() + "\n");

        //Adicionando seguradora1 na lista de seguradoras
        listaSeguradora.add(seguradora1);

        //Chamando o menu de operações
        MenuOperacoes op;
		do {
			exibirMenuExterno(scanner, listaSeguradora);
			op = lerOpcaoMenuExterno(scanner);
			executarOpcaoMenuExterno(op, scanner, listaSeguradora);
		} while(op != MenuOperacoes.SAIR);
		System.out.println("Saiu do sistema\n");

    }
}

//Bugs para corrigir no lab05
// * exluir cliente nao ta removendo todos sinistros
// * digitar nomes com espaço dá invalido
// * errar data mata o programa
// * selecionar seguradora, cliente, etc. que nao estao nas opcoes mata o programa