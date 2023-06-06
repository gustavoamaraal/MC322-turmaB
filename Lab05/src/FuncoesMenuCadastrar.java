import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncoesMenuCadastrar {

    //Cadastra clientePF
    public static ClientePF cadastrarClientePF(Scanner scanner, ArrayList<Seguradora> listaSeguradora, int indexSeguradora) {
        //Usa o System.in para receber dados de um clientePF e criá-lo

        System.out.println("Cadastro de Pessoa Fisica");
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
        //Email
        System.out.print("Digite o email do(a) cliente: ");
        String email = scanner.nextLine();
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
        //Telefone
        System.out.print("Digite o telefone do(a) cliente: ");
        String telefone = scanner.nextLine();
        //Gera um clientePF
        ClientePF cliente = new ClientePF(nome, endereco, CPF, telefone, email, genero, educacao, dataNascimento);
        listaSeguradora.get(indexSeguradora).cadastrarCliente(cliente);
        //Retorna esse cliente
        return cliente;
    }

    //Cadastra clientePJ
    public static ClientePJ cadastrarClientePJ(Scanner scanner, ArrayList<Seguradora> listaSeguradora, int indexSeguradora) {
        //Usa o System.in para receber dados de um clientePJ e criá-lo

        System.out.println("Cadastro de Pessoa Juridica");
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
        //Telefone
        System.out.print("Digite o telefone do(a) cliente: ");
        String telefone = scanner.nextLine();
        //Email
        System.out.print("Digite o email do(a) cliente: ");
        String email = scanner.nextLine();
        System.out.print("\n");
        //Gera um clientePJ
        ClientePJ cliente = new ClientePJ(nome, endereco, telefone, email, CNPJ, dataFundacao);
        listaSeguradora.get(indexSeguradora).cadastrarCliente(cliente);
        //Retorna o cliente
        return cliente;
    }

    //Reune cadastrarClientePF e cadastrarClientePJ para cadastrar um cliente
    public static void cadastrarCliente(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        scanner.nextLine();
        System.out.print("Qual o tipo de cliente que deseja cadastrar? Responda apenas com 'PF' ou 'PJ', sem as aspas: ");
        String tipo = scanner.nextLine();       
        int indexSeguradora = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        if (tipo.equals("PF"))
            cadastrarClientePF(scanner, listaSeguradora, indexSeguradora);
        else if (tipo.equals("PJ"))
            cadastrarClientePJ(scanner, listaSeguradora, indexSeguradora);
        else {
            System.out.println("Resposta invalida.");
            cadastrarCliente(scanner, listaSeguradora);
        }
    }
    
    //Método de adição de veículo
    public static boolean cadastrarVeiculo(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarCliente(scanner, listaSeguradora.get(a));

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
        //Cria um veiculo e o adiciona na lista de veículos do cliente, caso ainda não esteja adicionado
        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao); 
        if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePF) {
            ((ClientePF) listaSeguradora.get(a).getListaClientes().get(b)).cadastrarVeiculo(veiculo);
            return true;
        }
        else if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePJ) {
            int c = AppMain.selecionarFrota(scanner, listaSeguradora.get(a).getListaClientes().get(b));
            ((ClientePJ) listaSeguradora.get(a).getListaClientes().get(b)).getListaFrotas().get(c).addVeiculo(veiculo);
        }
        return true;
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
            System.out.print("Digite o nome da seguradora: ");
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
        //CNPJ
        String CNPJ = "";
        boolean aux2 = true;
        while (aux2) {
            System.out.print("Digite o CNPJ da seguradora: ");
            CNPJ = scanner.nextLine();
            if (Validacao.validarCNPJ(CNPJ))
                aux2 = false;
            else    
                System.out.print("CNPJ invalido! ");
        }
        //Cria a seguradora e a adiciona na lista de seguradoras
        Seguradora seguradora = new Seguradora(nome, telefone, email, endereco, CNPJ);
        listaSeguradora.add(seguradora);
        System.out.println("\nSeguradora cadastrada com sucesso!\n");
        //Retorna a seguradora
        return seguradora;
    }

    //Cadastra um seguro
    public static void cadastrarSeguro(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        scanner.nextLine();
        listaSeguradora.get(a).gerarSeguro(scanner);
    }

    //Cadastra uma frota
    public static boolean cadastrarFrota(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        System.out.println("Cadastro de Frota:");
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarCliente(scanner, listaSeguradora.get(a));
        scanner.nextLine();
        if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePJ) {
            System.out.print("Digite o code da frota: ");
            String code = scanner.nextLine();
            Frota novaFrota = new Frota(code);
            for (Frota frota:((ClientePJ) listaSeguradora.get(a).getListaClientes().get(b)).getListaFrotas()) {
                if (frota.getCode().equals(novaFrota.getCode())) {
                    System.out.println("Uma frota com code " + novaFrota.getCode() + " já está cadastrada, tente novamente.");
                    cadastrarFrota(scanner, listaSeguradora);
                    return false;
                }
            }
            ((ClientePJ) listaSeguradora.get(a).getListaClientes().get(b)).getListaFrotas().add(novaFrota);
        }
        return true;
    }

    //Método para cadastrar condutor
    public static boolean cadastrarCondutor(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarSeguro(scanner, listaSeguradora.get(a));
        scanner.nextLine();
        //CPF
        String CPF = "";
        boolean aux = true;
        while (aux) {
            System.out.print("Digite o CPF do(a) condutor(a): ");
            CPF = scanner.nextLine();
            if (Validacao.validarCPF(CPF))
                aux = false;
            else    
                System.out.print("CPF invalido! ");
        }
        //Nome
        String nome = "";
        boolean aux2 = true;
        while (aux2) {
            System.out.print("Digite o nome do(a) condutor(a): ");
            nome = scanner.nextLine();
            if (Validacao.validarNome(nome))
                aux2 = false;
            else    
                System.out.print("Nome invalido! ");
        }
        //Telefone
        System.out.print("Digite o telefone do(a) condutor(a): ");
        String telefone = scanner.nextLine();
        //Endereco
        System.out.print("Digite o endereco do(a) condutor(a): ");
        String endereco = scanner.nextLine();        
        //Email
        System.out.print("Digite o email do(a) condutor(a): ");
        String email = scanner.nextLine();
        //Data de nascimento
        System.out.print("Digite o ANO da data de nascimento do(a) condutor(a): ");
        String ano = scanner.nextLine();
        System.out.print("Digite o MES da data de nascimento do(a) condutor(a): ");
        String mes = scanner.nextLine();
        System.out.print("Digite o DIA da data de nascimento do(a) condutor(a): ");
        String dia = scanner.nextLine();    
        LocalDate data = LocalDate.parse(ano+"-"+mes+"-"+dia);

        //Criando condutor e cadastrando
        Condutor novoCondutor = new Condutor(CPF, nome, telefone, endereco, email, data);
        if (listaSeguradora.get(a).getListaSeguros().get(b) instanceof SeguroPF)
            ((SeguroPF) listaSeguradora.get(a).getListaSeguros().get(b)).autorizarCondutor(novoCondutor);
        else if (listaSeguradora.get(a).getListaSeguros().get(b) instanceof SeguroPJ)
            ((SeguroPJ) listaSeguradora.get(a).getListaSeguros().get(b)).autorizarCondutor(novoCondutor);
        return true;
    }

}
