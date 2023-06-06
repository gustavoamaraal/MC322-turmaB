import java.util.Scanner;
import java.util.ArrayList;

public class FuncoesMenu {

    //Exibe menu externo
	public static void exibirMenuExterno(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
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
	public static MenuOperacoes lerOpcaoMenuExterno(Scanner scanner) {
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
	public static void executarOpcaoMenuExterno(MenuOperacoes op, Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op, scanner, listaSeguradora);
				break;
			case GERAR_SINISTRO:
                int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
                int b = AppMain.selecionarSeguro(scanner, listaSeguradora.get(a));
				scanner.nextLine();
				if (listaSeguradora.get(a).getListaSeguros().get(b) instanceof SeguroPF) {
                	((SeguroPF) listaSeguradora.get(a).getListaSeguros().get(b)).gerarSinistro(scanner);
				}
				else if (listaSeguradora.get(a).getListaSeguros().get(b) instanceof SeguroPJ) {
					((SeguroPJ) listaSeguradora.get(a).getListaSeguros().get(b)).gerarSinistro(scanner);
				}
				break;
			case CALCULAR_RECEITA:
				int f = AppMain.selecionarSeguradora(scanner, listaSeguradora);
                System.out.println("Receita da seguradora " + listaSeguradora.get(f).getNome() + ": " + listaSeguradora.get(f).calcularReceita());
				break;
			case ATUALIZAR_FROTA:
				int c = AppMain.selecionarSeguradora(scanner, listaSeguradora);
				int d = AppMain.selecionarCliente(scanner, listaSeguradora.get(c));
				if (listaSeguradora.get(c).getListaClientes().get(d) instanceof ClientePJ) 
					((ClientePJ) listaSeguradora.get(c).getListaClientes().get(d)).atualizarFrota(scanner);
				break;
			case SAIR:
                break;
		}
	}
	
    //Executa opções do submenu
	public static void executarOpcaoSubMenu(SubOperacoes opSubmenu, Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE:
            FuncoesMenuCadastrar.cadastrarCliente(scanner, listaSeguradora);
			break;
		case CADASTRAR_VEICULO:
            FuncoesMenuCadastrar.cadastrarVeiculo(scanner, listaSeguradora);
			break;
		case CADASTRAR_SEGURADORA:
            FuncoesMenuCadastrar.cadastrarSeguradora(scanner, listaSeguradora);
			break;
		case CADASTRAR_SEGURO:
			FuncoesMenuCadastrar.cadastrarSeguro(scanner, listaSeguradora);
			break;
		case CADASTRAR_FROTA:
			FuncoesMenuCadastrar.cadastrarFrota(scanner, listaSeguradora);
			break;
		case CADASTRAR_CONDUTOR:
			FuncoesMenuCadastrar.cadastrarCondutor(scanner, listaSeguradora);
			break;
		case LISTAR_CLIENTES_POR_SEG:
            FuncoesMenuListar.listarClientesSeguradora(scanner, listaSeguradora);
			break;
		case LISTAR_SINISTROS_POR_SEG:
            FuncoesMenuListar.listarSinistrosSeguradora(scanner, listaSeguradora);
			break;
		case LISTAR_SINISTROS_POR_SEGURO:
            FuncoesMenuListar.listarSinistrosSeguro(scanner, listaSeguradora);
			break;
		case LISTAR_VEICULOS_POR_CLI:
            FuncoesMenuListar.listarVeiculosCliente(scanner, listaSeguradora);
			break;
        case LISTAR_VEICULOS_POR_SEG:
            FuncoesMenuListar.listarVeiculosSeguradora(scanner, listaSeguradora);
            break;
		case LISTAR_SEGUROS_POR_CLI:
			FuncoesMenuListar.listarSegurosCliente(scanner, listaSeguradora);
			break;
		case LISTAR_SEGUROS_POR_SEG:
			FuncoesMenuListar.listarSegurosSeguradora(scanner, listaSeguradora);
			break;
		case LISTAR_FROTAS_POR_SEG:
			FuncoesMenuListar.listarFrotasSeguradora(scanner, listaSeguradora);
			break;
		case LISTAR_FROTAS_POR_CLI:
			FuncoesMenuListar.listarFrotasCliente(scanner, listaSeguradora);
			break;
		case LISTAR_CONDUTORES_POR_SEG:
			FuncoesMenuListar.listarCondutoresSeguradora(scanner, listaSeguradora);
			break;
		case LISTAR_CONDUTORES_POR_SEGURO:
			FuncoesMenuListar.listarCondutoresSeguro(scanner, listaSeguradora);
			break;
		case EXCLUIR_CLIENTE:
            FuncoesMenuExcluir.excluirCliente(scanner, listaSeguradora);
			break;
		case EXCLUIR_VEICULO:
			FuncoesMenuExcluir.excluirVeiculo(scanner, listaSeguradora);
			break;
		case EXCLUIR_SINISTRO:
			FuncoesMenuExcluir.excluirSinistro(scanner, listaSeguradora);
			break;
		case EXCLUIR_SEGURO:
			FuncoesMenuExcluir.excluirSeguro(scanner, listaSeguradora);
			break;
		case EXCLUIR_FROTA:
			FuncoesMenuExcluir.excluirFrota(scanner, listaSeguradora);
			break;
		case EXCLUIR_CONDUTOR:
			FuncoesMenuExcluir.excluirCondutor(scanner, listaSeguradora);
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
    
}
