import java.util.ArrayList;

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

    //Método de gerar sinistro
    public boolean gerarSinistro(String data, String endereco, Veiculo veiculo, Cliente cliente) {
        //Recebe os dados do sinistro, verifica se esse sinistro já foi registrado e, caso não seja, o adiciona em listaSinistros
        Sinistro novoSinistro = new Sinistro(data, endereco, this, veiculo, cliente);
        for (Sinistro i:listaSinistros) {
            if ((data.equals(i.getData())) && (endereco.equals(i.getEndereco())) && (veiculo.equals(i.getVeiculo())) && (cliente.equals(i.getCliente()))) {
                return false;
            }
        }
        listaSinistros.add(novoSinistro);
        return true;
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
                str = str + " " + ((ClientePF) i).getCpf() + " (CPF) |";
            }
            if (i instanceof ClientePJ) {
                str = str + " " + ((ClientePJ) i).getCnpj() + " (CNPJ) |";
            }
        }
        str = str + "\n";
        return str;
    }
}