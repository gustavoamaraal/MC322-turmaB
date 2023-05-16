import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    //Construtor
    public Seguradora(String nome, String telefone, String email, String endereco) { 
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaClientes = new ArrayList<Cliente>();
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    //Método de cadastramento do cliente
    public boolean cadastrarCliente(Cliente cliente) { 
        //Se o cliente já estiver cadastrado, retorna false e não acontece nada
        //Se não estiver, ele é adicionado à listaClientes e retorna true
        if (listaClientes.contains(cliente)) { 
            System.out.println("O(a) cliente " + cliente.getNome() + " ja esta cadastrado(a) na seguradora!\n");
            return false;
        }
        else { 
            listaClientes.add(cliente);
            System.out.println("Cliente " + cliente.getNome() + " adicionado(a) com sucesso!\n");
            return true;
        }
    }

    //Método de remoção de sinistros do cliente. É utilizado em removerCliente()
    public void removerSinistros(Cliente cliente) {
        //Remove de listaSinistros todos os sinistros associados a esse cliente
        for (int i = 0; i < listaSinistros.size(); i++) {
            if (listaSinistros.get(i).getCliente().equals(cliente)) {
                listaSinistros.remove(listaSinistros.get(i));
            }
        }
    }

    //Método de remoção de cliente
    public boolean removerCliente(String CPFouCNPJ) { 
        //Remove de listaSinistros todos os sinistros associados a esse cliente
        //Remove o cliente de listaClientes
        for (Cliente i:listaClientes) {
            if (i instanceof ClientePF) {
                if (CPFouCNPJ.equals(((ClientePF) i).getCpf())) {
                    removerSinistros(i); 
                    listaClientes.remove(i); 
                    return true;
                }
            }
            else if (i instanceof ClientePJ) {
                if (CPFouCNPJ.equals(((ClientePJ)i).getCnpj())) {
                    removerSinistros(i);
                    listaClientes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    //Método de listagem de clientes de um certo tipo
    public void listarClientes(String tipoCliente) {
        //Dado o tipo do cliente, imprime o nome e CPF/CNPJ de todos os clientes da seguradora que sejam do mesmo tipo
        if (tipoCliente.equals("PF")) {
            System.out.println("Lista de clientes do tipo PF da seguradora " + nome + ": ");
            for (Cliente i:listaClientes) {
                if (i instanceof ClientePF) {
                    System.out.println(i.getNome() + " (CPF: " + ((ClientePF) i).getCpf() + ")");
                }
            }
        }
        if (tipoCliente.equals("PJ")) {
            System.out.println("Lista de clientes do tipo PJ da seguradora " + nome + ": ");
            for (Cliente i:listaClientes) {
                if (i instanceof ClientePJ) {
                    System.out.println(i.getNome() + " (CNPJ: " + ((ClientePJ) i).getCnpj() + ")");
                }
            }
        }    
        System.out.print("\n");    
    }

    //Método de listagem de sinistros
    public void listarSinistros() {
        //Imprime os IDs de todos os sinistros da seguradora, junto com o nome do cliente envolvido
        System.out.println("Lista dos IDs dos sinistros da seguradora " + nome + ": ");
        for (Sinistro i:listaSinistros) {
                System.out.println(i.getId() + " (nome do cliente: " + i.getCliente().getNome() + ")");
        }       
        System.out.print("\n"); 
    }

    //Método de listagem de sinistros de um cliente dado
    public void listarSinistrosPorCliente(Cliente cliente) {
        //Imprime os IDs de todos os sinistros do cliente, junto com o nome do cliente envolvido
        System.out.println("Lista dos IDs dos sinistros do cliente " + cliente.getNome() + ": ");
        for (Sinistro sinistro:listaSinistros) {
            if (sinistro.getCliente().equals(cliente)) {
                System.out.println(sinistro.getId());
            }
        }
        System.out.print("\n");
    }

    //Método para gerar sinistro. (Futuramente terá, em vez de digitar nome do cliente e placa do veículo, um menu para selecionar o cliente e o veículo)
    public boolean gerarSinistro(Scanner scanner) {
        //Usa o System.in para receber dados de um sinistro

        System.out.println("Geracao de sinistro para a seguradora " + nome + ": ");
        //Data
        System.out.print("Digite o ANO da data do sinistro: ");
        String anoS = scanner.nextLine();
        System.out.print("Digite o MES da data do sinistro: ");
        String mesS = scanner.nextLine();
        System.out.print("Digite o DIA da data do sinistro: ");
        String diaS = scanner.nextLine();    
        LocalDate data = LocalDate.parse(anoS+"-"+mesS+"-"+diaS);
        //Endereço
        System.out.print("Digite o endereco do sinistro: ");
        String endereco = scanner.nextLine();
        //Nome do cliente
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        //Placa do veículo
        System.out.print("Digite a placa do veiculo: ");
        String placa = scanner.nextLine();

        //Busca cliente com esse nome e veiculo com essa placa. Verifica se esse sinistro já foi registrado e, caso não seja, o gera e adiciona em listaSinistros

        for (Cliente cliente:listaClientes) {
            for (Veiculo veiculo:cliente.getListaVeiculos()) { //BUG
                if (placa.equals(veiculo.getPlaca()) && nome.equals(cliente.getNome())) {
                    for (Sinistro k:listaSinistros) {
                        if ((data.equals(k.getData())) && (endereco.equals(k.getEndereco())) && (veiculo.equals(k.getVeiculo())) && (cliente.equals(k.getCliente()))) {
                            System.out.println("\nSinistro ja existente!\n");
                            return false;
                        }
                    }
                    Sinistro novoSinistro = new Sinistro(data, endereco, this, veiculo, cliente);
                    listaSinistros.add(novoSinistro);
                    System.out.println("\nSinistro adicionado!\n");
                    return true;
                }
            }
        } 
        System.out.println("\nCliente e/ou veiculo nao encontrado!\n");
        return false;
    }

    //Método de visualizacao do sinistro
    public boolean visualizarSinistro(String CPFouCNPJ) {
        //Dado o CPF/CNPJ do cliente, imprime os dados de todos os sinistros associados a esse cliente
        boolean a = false;
        for (Cliente i:listaClientes) {
            if ((i instanceof ClientePF) && (CPFouCNPJ).length() == 11) {
                if (CPFouCNPJ.equals(((ClientePF) i).getCpf())){
                    for (Sinistro j:listaSinistros) {
                        if (j.getCliente().equals(i)) {
                            System.out.println(j.toString());
                            a = true;
                        }
                    }
                }
            }
            else if ((i instanceof ClientePJ) && (CPFouCNPJ).length() == 14) {
                if (CPFouCNPJ.equals(((ClientePJ) i).getCnpj())){
                    for (Sinistro j:listaSinistros) {
                        if (j.getCliente().equals(i)) {
                            System.out.println(j.toString());
                            a = true;
                        }
                    }
                }
            }            
        }
        return a;
    }

    //Método de cálculo do preço do seguro do cliente. É a multiplicação do score do cliente pela (quantidade de sinistros + 1)
    public Double calcularPrecoSeguroCliente(Cliente cliente) {
        Double qtdeSinistros = 0.0;
        for (Sinistro sinistro:listaSinistros) {
            if (sinistro.getCliente().equals(cliente)) {
                qtdeSinistros = qtdeSinistros + 1;
            }
        }
        Double preco = cliente.calculaScore() * (qtdeSinistros + 1);
        cliente.setValorSeguro(preco);
        return preco;
    }

    //Método de cálculo da receita da seguradora. É a soma dos preços dos seguros de todos os clientes dessa seguradora
    public Double calcularReceita() {
        Double receita = 0.0;
        for (Cliente cliente:listaClientes) {
            receita = receita + this.calcularPrecoSeguroCliente(cliente);
        }
        return receita;
    }

    //Método toString da classe Seguradora para imprimir todos os dados
    public String toString() {
        String str = "Dados da seguradora\nNome: " + nome + "\nTelefone: " + telefone + "\nEmail: " + email +
                        "\nEndereco: " + endereco + "\nLista dos IDs dos sinistros:";
        for (Sinistro i:listaSinistros) {
            str = str + " ";
            str = str + String.valueOf(i.getId());
        }
        str = str + "\nLista dos CPFs/CNPJ dos clientes:";
        for (Cliente i:listaClientes) {
            if (i instanceof ClientePF) {
                str = str + " ";
                str = str + ((ClientePF) i).getCpf();
                str = str + " (CPF)";
            }
            if (i instanceof ClientePJ) {
                str = str + " ";
                str = str + ((ClientePJ) i).getCnpj();
                str = str + " (CNPJ)";
            }
        }
        str = str + "\n";
        return str;
    }
}