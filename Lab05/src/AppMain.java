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
    public static int selecionarSinistro(Scanner scanner, Condutor condutor) {
        System.out.println("Selecione um sinistro: ");
        int a = 1;
        for (Sinistro sinistro:condutor.getListaSinistros()) {
            System.out.println(a + " - " + sinistro.getId() + ", de " + sinistro.getCondutor().getNome() + " na data " + sinistro.getData() + "(ano-mes-dia)");
            a++;
        }
        int b = scanner.nextInt();
        return (b-1);
    }

    //Mostra os condutores selecionáveis e retorna o índice desse condutor em listaCondutores
    public static int selecionarCondutor(Scanner scanner, Seguro seguro) {
        System.out.println("Selecione um condutor: ");
        int a = 1;
        for (Condutor condutor:seguro.getListaCondutores()) {
            System.out.println(a + " - " + condutor.getNome() + " | CPF " + condutor.getCpf());
            a++;
        }
        int b = scanner.nextInt();
        return (b-1);
    }    

    //Mostra os veículos selecionáveis e retorna o índice desse veiculo em listaVeiculos
    public static int selecionarVeiculo(Scanner scanner, Cliente cliente) {
        System.out.println("Selecione um veiculo: ");
        int a = 1;
        if (cliente instanceof ClientePF) {
            for (Veiculo veiculo:((ClientePF) cliente).getListaVeiculos()) {
                System.out.println(a + " - " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ")");
            }
            a++;
        }
        else if (cliente instanceof ClientePJ) {
            int b = selecionarFrota(scanner, cliente);
            for (Veiculo veiculo:((ClientePJ) cliente).getListaFrotas().get(b).getListaVeiculos()) {
                System.out.println(a + " - " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ")");
            }
        }
        int c = scanner.nextInt();
        return (c-1);        
    }

    //Mostra as frotas selecionáveis e retorna o índice dessa frota em listaFrota
    public static int selecionarFrota(Scanner scanner, Cliente cliente) {
        System.out.println("Selecione uma frota: ");
        int a = 1;
        for (Frota frota:((ClientePJ) cliente).getListaFrotas()) {
            System.out.println(a + " - " + frota.getCode());
            a++;
        }
        int b = scanner.nextInt();
        return (b-1);        
    }    

    //Mostra os seguros selecionáveis e retorna o índice desse seguro em listaCondutores
    public static int selecionarSeguro(Scanner scanner, Seguradora seguradora) {
        System.out.println("Selecione um seguro: ");
        int a = 1;
        for (Seguro seguro:seguradora.getListaSeguros()) {
            if (seguro instanceof SeguroPF) {
                System.out.println(a + " - ID " + seguro.getId() + " | Nome " + ((SeguroPF) seguro).getCliente().getNome() + " | CPF " + ((SeguroPF) seguro).getCliente().getCpf());
            }
            else if (seguro instanceof SeguroPJ) {
                System.out.println(a + " - ID " + seguro.getId() + " | Nome " + ((SeguroPJ) seguro).getCliente().getNome() + " | CNPJ " + ((SeguroPJ) seguro).getCliente().getCnpj());
            }
            a++;
        }
        int b = scanner.nextInt();
        return (b-1);        
    }        


    public static void main(String[] args) {

        //Cria um objeto da classe Scanner, que será utilizado para realizar a leitura de dados
        Scanner scanner = new Scanner(System.in);

        //Cria uma lista com todas as seguradoras existentes
        ArrayList<Seguradora> listaSeguradora = new ArrayList<Seguradora>();

        //Instanciando um objeto da classe Seguradora
        Seguradora seguradora1 = new Seguradora("Seguradora 1", "19 98765-4321", "Email seg1", "Rua C", "98.293.157/0001-57");

        //Instanciando objetos das classes ClientePF e ClientePJ
        ClientePF clientePF1 = new ClientePF("Nome 1", "Rua A", "238.398.430-22", "19 9986419346", "Email 1", "Genero 1", "Nivel 1", LocalDate.parse("1990-10-05"));
        ClientePF clientePF2 = new ClientePF("Nome 2", "Rua B", "68TESTE8.73TESTE5.730-53", "11 93012321321", "Email 2", "Genero 2", "Nivel 2", LocalDate.parse("2000-01-02"));
        ClientePJ clientePJ1 = new ClientePJ("Nome 3", "Rua C", "19 9413265911", "Email 3", "56.094.270/0001-63", LocalDate.parse("2011-11-11"));
        ClientePJ clientePJ2 = new ClientePJ("Nome 4", "Rua A", "14 9532468713", "Email 4", "TESTE99569990/0001-40", LocalDate.parse("1970-10-07"));

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

        //Instanciado objetos da classe Frota
        Frota frota1 = new Frota("Code 1");
        Frota frota2 = new Frota("Code 2");
        Frota frota3 = new Frota("Code 3");

        //Adicionando os veiculos/frotas aos clientes
        clientePJ1.cadastrarFrota(frota1);
        clientePJ1.cadastrarFrota(frota2);
        clientePJ2.cadastrarFrota(frota3);
        clientePF1.cadastrarVeiculo(veiculo1);
        clientePF2.cadastrarVeiculo(veiculo2);
        clientePF2.cadastrarVeiculo(veiculo3);
        clientePF1.cadastrarVeiculo(veiculo7);
        clientePF2.cadastrarVeiculo(veiculo8);
        frota1.addVeiculo(veiculo4);
        frota1.addVeiculo(veiculo6);
        frota2.addVeiculo(veiculo9);
        frota3.addVeiculo(veiculo5);

        //Cadastrando em seguradora1 os 4 clientes que já foram gerados
        seguradora1.cadastrarCliente(clientePF1);
        seguradora1.cadastrarCliente(clientePF2);
        seguradora1.cadastrarCliente(clientePJ1);
        seguradora1.cadastrarCliente(clientePJ2);

        //Instanciando objetos da classe Seguro
        seguradora1.gerarSeguro(scanner); //Recomendo que selecione ClientePF1 (Nome 1) como dono
        seguradora1.gerarSeguro(scanner); //Recomendo que selecione ClientePF2 (Nome 2) como dono
        seguradora1.gerarSeguro(scanner); //Recomendo que selecione ClientePJ1 (Nome 3) como dono

        //Instranciando objetos da classe Condutor
        Condutor condutor1 = new Condutor(clientePF1.getCpf(), clientePF1.getNome(), clientePF1.getTelefone(), clientePF1.getEndereco(), clientePF1.getEmail(), clientePF1.getDataNascimento());
        Condutor condutor2 = new Condutor(clientePF2.getCpf(), clientePF2.getNome(), clientePF2.getTelefone(), clientePF2.getEndereco(), clientePF2.getEmail(), clientePF2.getDataNascimento());
        Condutor condutor3 = new Condutor("951.417.880-75", "Nome 5", "19 50438501424", "Rua F", "Email 5", LocalDate.parse("1999-11-17"));
        Condutor condutor4 = new Condutor("051.258.800-78", "Nome 6", "19 92147124144", "Rua A", "Email 6", LocalDate.parse("2004-01-05"));
        Condutor condutor5 = new Condutor("917.173.120-20", "Nome 7", "19 91235614613", "Rua B", "Email 7", LocalDate.parse("1984-12-14"));
        Condutor condutor6 = new Condutor("109.321.550-06", "Nome 8", "19 97245626256", "Rua C", "Email 8", LocalDate.parse("2003-11-15"));
        Condutor condutor7 = new Condutor("661.328.940-04", "Nome 9", "19 91111111111", "Rua A", "Email 9", LocalDate.parse("2001-06-01"));
        Condutor condutor8 = new Condutor("019.869.680-90", "Nome 10", "19 92423532529", "Rua A", "Email 10", LocalDate.parse("1990-04-27"));

        //Adicionando condutores aos seguros
        ((SeguroPF) seguradora1.getListaSeguros().get(0)).autorizarCondutor(condutor1); //Dono do seguro, caso tenha seguido a recomendação anteriormente
        ((SeguroPF) seguradora1.getListaSeguros().get(1)).autorizarCondutor(condutor2); //Dono do seguro, caso tenha seguido a recomendação anteriormente
        ((SeguroPF) seguradora1.getListaSeguros().get(0)).autorizarCondutor(condutor3);
        ((SeguroPF) seguradora1.getListaSeguros().get(1)).autorizarCondutor(condutor4);
        ((SeguroPF) seguradora1.getListaSeguros().get(1)).autorizarCondutor(condutor5);
        ((SeguroPJ) seguradora1.getListaSeguros().get(2)).autorizarCondutor(condutor6);
        ((SeguroPJ) seguradora1.getListaSeguros().get(2)).autorizarCondutor(condutor7);
        ((SeguroPJ) seguradora1.getListaSeguros().get(2)).autorizarCondutor(condutor8);

        //Gerando sinistros
        ((SeguroPF) seguradora1.getListaSeguros().get(0)).gerarSinistro(scanner);
        ((SeguroPF) seguradora1.getListaSeguros().get(1)).gerarSinistro(scanner);
        ((SeguroPJ) seguradora1.getListaSeguros().get(2)).gerarSinistro(scanner);

        //Listando os clientes de seguradora1
        seguradora1.listarClientes("PF");
        seguradora1.listarClientes("PJ");

        //Calculando o valor da receita e atualizando o atributo valorSeguro de cada cliente cadastrado na seguradora
        System.out.println("Receita atual da Seguradora 1: " + seguradora1.calcularReceita() + "\n");

        //Imprimindo os dados de diversos objetos pelo método toString()
        System.out.println(clientePF1);
        System.out.println(clientePJ1);
        System.out.println(condutor1);
        System.out.println(frota1);
        System.out.println(seguradora1);
        System.out.println(seguradora1.getListaSeguros().get(0));
        System.out.println(seguradora1.getListaSeguros().get(2));
        System.out.println(seguradora1.getListaSeguros().get(0).getListaSinistros().get(0));
        System.out.println(veiculo1);

        //Adicionando seguradora1 na lista de seguradoras
        listaSeguradora.add(seguradora1);

        //Chamando o menu de operações
        MenuOperacoes op;
		do {
			FuncoesMenu.exibirMenuExterno(scanner, listaSeguradora);
			op = FuncoesMenu.lerOpcaoMenuExterno(scanner);
			FuncoesMenu.executarOpcaoMenuExterno(op, scanner, listaSeguradora);
		} while(op != MenuOperacoes.SAIR);
		System.out.println("Saiu do sistema\n");

    }
}

/* Sugestão para entradas antes de chamar o menu
2023
05
06
2024
05
06
1
1
2020
12
12
2023
12
12
2
1
2018
09
08
2023
09
08
3
1
2023
01
01
Rua A
1
2023
02
02
Rua B
1
2023
03
03
Rua C
1

 */