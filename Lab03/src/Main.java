import java.time.LocalDate;
import java.util.Scanner;

class Main {

    public static ClientePF gerarClientePF(Scanner scanner) {
        //Usa o System.in para receber dados de um clientePF e criá-lo

        System.out.println("Cadastro de Pessoa Fisica");
        //Nome
        System.out.print("Digite o nome do(a) cliente: ");
        String nome = scanner.nextLine();
        //Endereço
        System.out.print("Digite o endereco do(a) cliente: ");
        String endereco = scanner.nextLine();
        //CPF
        System.out.print("Digite o CPF do(a) cliente: ");
        String CPF = scanner.nextLine();
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
        //Retorna esse cliente
        return cliente;
    }

    public static ClientePJ gerarClientePJ(Scanner scanner) {
        //Usa o System.in para receber dados de um clientePJ e criá-lo

        System.out.println("Cadastro de Pessoa Juridica");
        //Nome
        System.out.print("Digite o nome do(a) cliente: ");
        String nome = scanner.nextLine();
        //Endereco
        System.out.print("Digite o endereço do(a) cliente: ");
        String endereco = scanner.nextLine();
        //CNPJ
        System.out.print("Digite o CNPJ do cliente: ");
        String CNPJ = scanner.nextLine();
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
        //Retorna o cliente
        return cliente;
    }

    public static Seguradora gerarSeguradora(Scanner scanner) {
        //Usa o System.in para receber dados de uma seguradora e criá-la

        System.out.println("Cadastro de Seguradora");
        //Nome
        System.out.print("Digite o nome da seguradora: ");
        String nome = scanner.nextLine();
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
        //Gera uma seguradora
        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco);
        //Retorna a seguradora
        return seguradora;
    }

    public static Veiculo gerarVeiculo(Scanner scanner) {
        //Usa o System.in para receber dados de um veículo e criá-lo

        System.out.println("Cadastro de Veiculo");
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
        //Gera um veiculo
        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
        //Retorna o veiculo
        return veiculo;        
    }

    public static void main(String[] args) {

        //Cria um objeto da classe Scanner, que será utilizado para realizar a leitura de dados
        Scanner scanner = new Scanner(System.in);

        //Gerando uma seguradora com uso do System.in
        Seguradora seguradora1 = gerarSeguradora(scanner);

        //Gerando um cliente PF e outro PJ com uso do System.in
        ClientePF clientePF1 = gerarClientePF(scanner);
        ClientePJ clientePJ1 = gerarClientePJ(scanner);

        //Gerando dois clientes PF e dois PJ apenas com uso dos construtores
        ClientePF clientePF2 = new ClientePF("Nome 2", "Rua 2", "238.398.430-22", "Genero 2", LocalDate.parse("2021-12-12"), "Nivel 2", LocalDate.parse("1990-10-05"), "Classe 2");
        ClientePF clientePF3 = new ClientePF("Nome 3", "Rua 3", "68TESTE8.73TESTE5.730-53", "Genero 3", LocalDate.parse("2019-04-13"), "Nivel 3", LocalDate.parse("2000-01-02"), "Classe 3");
        ClientePJ clientePJ2 = new ClientePJ("Nome 4", "Rua 2", "56.094.270/0001-63", LocalDate.parse("2011-11-11"));
        ClientePJ clientePJ3 = new ClientePJ("Nome 5", "Rua 4", "TESTE99569990/0001-40", LocalDate.parse("1970-10-07"));

        //Gerando um veículo com uso do System.in
        Veiculo veiculo1 = gerarVeiculo(scanner);

        //Gerando nove veiculos apenas com uso dos construtores
        Veiculo veiculo2 = new Veiculo("ABC2222", "Marca 2", "Modelo 2", 2019);
        Veiculo veiculo3 = new Veiculo("ABC3333", "Marca 3", "Modelo 3", 2018);
        Veiculo veiculo4 = new Veiculo("ABC4444", "Marca 4", "Modelo 4", 2017);
        Veiculo veiculo5 = new Veiculo("ABC5555", "Marca 5", "Modelo 5", 2016);
        Veiculo veiculo6 = new Veiculo("ABC6666", "Marca 6", "Modelo 6", 2015);
        Veiculo veiculo7 = new Veiculo("ABC7777", "Marca 7", "Modelo 7", 2014);
        Veiculo veiculo8 = new Veiculo("ABC8888", "Marca 8", "Modelo 8", 2013);
        Veiculo veiculo9 = new Veiculo("ABC9999", "Marca 9", "Modelo 9", 2012);
        Veiculo veiculo10 = new Veiculo("ABC0000", "Marca 10", "Modelo 10", 2011);

        //Adicionando os veiculos aos clientes
        clientePF1.adicionaVeiculo(veiculo1);
        clientePF2.adicionaVeiculo(veiculo2);
        clientePF3.adicionaVeiculo(veiculo3);
        clientePJ1.adicionaVeiculo(veiculo4);
        clientePJ2.adicionaVeiculo(veiculo5);
        clientePJ3.adicionaVeiculo(veiculo6);
        clientePF1.adicionaVeiculo(veiculo7);
        clientePF2.adicionaVeiculo(veiculo8);
        clientePJ1.adicionaVeiculo(veiculo9);
        clientePJ2.adicionaVeiculo(veiculo10);

        //Gerando dez sinistros nem seguradora1
        seguradora1.gerarSinistro("2023-01-12", "Rua 1", veiculo1, clientePF1);
        seguradora1.gerarSinistro("2023-06-13", "Rua 2", veiculo2, clientePF2);
        seguradora1.gerarSinistro("2023-04-12", "Rua 3", veiculo3, clientePF3);
        seguradora1.gerarSinistro("2023-04-13", "Rua 4", veiculo4, clientePJ1);
        seguradora1.gerarSinistro("2023-09-12", "Rua 5", veiculo5, clientePJ2);
        seguradora1.gerarSinistro("2023-12-14", "Rua 2", veiculo6, clientePJ3);
        seguradora1.gerarSinistro("2023-11-12", "Rua 3", veiculo7, clientePF1);
        seguradora1.gerarSinistro("2023-04-13", "Rua 4", veiculo8, clientePF2);
        seguradora1.gerarSinistro("2023-04-15", "Rua 5", veiculo9, clientePJ1);
        seguradora1.gerarSinistro("2023-04-11", "Rua 6", veiculo10, clientePJ2);

        //Cadastrando em seguradora1 os 6 clientes que já foram gerados
        seguradora1.cadastrarCliente(clientePF1);
        seguradora1.cadastrarCliente(clientePF1); //Como esse cliente já foi adicionado, não será cadastrado outra vez
        seguradora1.cadastrarCliente(clientePF2);
        seguradora1.cadastrarCliente(clientePF3);
        seguradora1.cadastrarCliente(clientePJ1);
        seguradora1.cadastrarCliente(clientePJ2);
        seguradora1.cadastrarCliente(clientePJ3);

        //Listando os clientes de seguradora1
        seguradora1.listarClientes("PF");
        seguradora1.listarClientes("PJ");

        //Listando os sinistros de seguradora1
        seguradora1.listarSinistros();

        //Removendo clientePF3 e clientePJ3 de seguradora1
        seguradora1.removerCliente(clientePF3.getCpf());
        seguradora1.removerCliente(clientePJ3.getCnpj());

        //Listando, após as remoções, os clientes de seguradora1
        seguradora1.listarClientes("PF");
        seguradora1.listarClientes("PJ");

        //Listando, após as remoções, os sinistros de seguradora1
        seguradora1.listarSinistros();

        //Visualizando sinistros de clientePF1 (chama o método toString dos sinistros associados a esse cliente)
        seguradora1.visualizarSinistro(clientePF1.getCpf());

        //Chamando o método toString de clientePF1 e clientePJ1
        System.out.println(clientePF1);
        System.out.println(clientePJ1);

        //Chamando o método toString de veiculo1
        System.out.println(veiculo1);

        //Chamando o método toString de seguradora1
        System.out.println(seguradora1);

    }
}