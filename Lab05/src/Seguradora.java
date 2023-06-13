import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> listaSeguros;
    private ArrayList<Cliente> listaClientes;
    private final String cnpj;

    //Construtor
    public Seguradora(String nome, String telefone, String email, String endereco, String cnpj) { 
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
		this.listaSeguros = new ArrayList<Seguro>();
		this.listaClientes = new ArrayList<Cliente>();
        this.cnpj = cnpj;
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

    public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getCnpj() {
        return cnpj.replaceAll("[^0-9]", "");
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

    //Método de remoção de cliente
    public boolean removerCliente(Cliente cliente) { 
        //Remove o cliente de listaClientes
        for (Cliente i:listaClientes) {
            if (i.equals(cliente)) {
                listaClientes.remove(i); 
                return true;
            }
        }
        return false;
    }

    //Método de listagem de clientes de um certo tipo
    public void listarClientes(String tipoCliente) {
        //Dado o tipo do cliente, imprime o nome e CPF/CNPJ de todos os clientes da seguradora que sejam desse tipo
        if (tipoCliente.equals("PF") || tipoCliente.equals("'PF'")) {
            System.out.println("Lista de clientes do tipo PF da seguradora " + nome + ": ");
            for (Cliente i:listaClientes) {
                if (i instanceof ClientePF) {
                    System.out.println(i.getNome() + " (CPF: " + ((ClientePF) i).getCpf() + ")");
                }
            }
        }
        else if (tipoCliente.equals("PJ") || tipoCliente.equals("'PJ'")) {
            System.out.println("Lista de clientes do tipo PJ da seguradora " + nome + ": ");
            for (Cliente i:listaClientes) {
                if (i instanceof ClientePJ) {
                    System.out.println(i.getNome() + " (CNPJ: " + ((ClientePJ) i).getCnpj() + ")");
                }
            }
        }    
        System.out.print("\n");    
    }

    //
    public boolean gerarSeguro(Scanner scanner) {
        //Data de início
        System.out.print("Digite o ANO da data de inicio do seguro: ");
        String anoInicio = scanner.nextLine();
        System.out.print("Digite o MES da data de inicio do seguro: ");
        String mesInicio = scanner.nextLine();
        System.out.print("Digite o DIA da data de inicio do seguro: ");
        String diaInicio = scanner.nextLine();
        LocalDate dataInicio = LocalDate.parse(anoInicio+"-"+mesInicio+"-"+diaInicio);
        //Data de fim
        System.out.print("Digite o ANO da data de fim do seguro: ");
        String anoFim = scanner.nextLine();
        System.out.print("Digite o MES da data de fim do seguro: ");
        String mesFim = scanner.nextLine();
        System.out.print("Digite o DIA da data de fim do seguro: ");
        String diaFim = scanner.nextLine();
        LocalDate dataFim = LocalDate.parse(anoFim+"-"+mesFim+"-"+diaFim);
        //Cliente
        System.out.println("Selecione um(a) cliente: ");
        int a = 1;
        for (Cliente cliente:listaClientes) {
            System.out.println(a + " - " + cliente.getNome());
            a++;
        }
        int b = scanner.nextInt();
        //Veiculo/Frota
        if (listaClientes.get(b-1) instanceof ClientePF) {
            System.out.println("Selecione um veiculo: ");
            a = 1;
            for (Veiculo veiculo:((ClientePF) listaClientes.get(b-1)).getListaVeiculos()) {
                System.out.println(a + " - " + veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ")");
                a++;
            }
            int c = scanner.nextInt();
            Seguro seguro = new SeguroPF(dataInicio, dataFim, this, ((ClientePF) (listaClientes.get(b-1))).getListaVeiculos().get(c-1), ((ClientePF) (listaClientes.get(b-1))));
            listaSeguros.add(seguro);
            System.out.println("Seguro gerado.\n");
        }
        else if (listaClientes.get(b-1) instanceof ClientePJ) {
            System.out.println("Selecione uma frota: ");
            a = 1;
            for (Frota frota:((ClientePJ) listaClientes.get(b-1)).getListaFrotas()) {
                System.out.println(a + " - " + frota.getCode());
                a++;
            }
            int c = scanner.nextInt();  
            Seguro seguro = new SeguroPJ(dataInicio, dataFim, this, ((ClientePJ) listaClientes.get(b-1)).getListaFrotas().get(c-1), ((ClientePJ) listaClientes.get(b-1)));     
            listaSeguros.add(seguro);
            System.out.println("Seguro gerado.\n");
        }
        scanner.nextLine();
        return true;
    }

    //
    public boolean cancelarSeguro(Scanner scanner) {
        System.out.println("Selecione um seguro para cancelar:");
        int a = 1;
        for (Seguro seguro:listaSeguros) {
            if (seguro instanceof SeguroPF) {
                System.out.println(a + " - ID " + seguro.getId() + " | " + ((SeguroPF) seguro).getCliente().getNome() + " | " + ((SeguroPF) seguro).getVeiculo().getMarca()
                                    + " " + ((SeguroPF) seguro).getVeiculo().getModelo() + "(placa " + ((SeguroPF) seguro).getVeiculo().getPlaca() + ")"); 
            }
            else if (seguro instanceof SeguroPJ) {
                System.out.println(a + " - ID " + seguro.getId() + " | " + ((SeguroPJ) seguro).getCliente().getNome() + " | Frota " + ((SeguroPJ) seguro).getFrota().getCode());
            }
            a++;
        }
        int b = scanner.nextInt();
        listaSeguros.remove(b-1);
        return true;
    }

    public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente) {
        ArrayList<Seguro> segurosPorCliente = new ArrayList<Seguro>() ;
        for (Seguro seguro:listaSeguros) {
            if (seguro instanceof SeguroPF) {
                if ((((SeguroPF) seguro).getCliente()).equals(cliente)) {
                    segurosPorCliente.add(seguro);
                } 
            }
            else if (seguro instanceof SeguroPJ) {
                if ((((SeguroPJ) seguro).getCliente()).equals(cliente)) {
                    segurosPorCliente.add(seguro);
                }                 
            }
        }
        return segurosPorCliente;
    }

    public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente) {
        ArrayList<Sinistro> sinistrosPorCliente = new ArrayList<Sinistro>();
        for (Seguro seguro:listaSeguros) {
            if (seguro instanceof SeguroPF) {
                if ((((SeguroPF) seguro).getCliente()).equals(cliente)) {
                    for (Sinistro sinistro:seguro.getListaSinistros())
                        sinistrosPorCliente.add(sinistro);
                } 
            }
            else if (seguro instanceof SeguroPJ) {
                if ((((SeguroPJ) seguro).getCliente()).equals(cliente)) {
                    for (Sinistro sinistro:seguro.getListaSinistros())
                        sinistrosPorCliente.add(sinistro);
                }                 
            }            
        }
        return sinistrosPorCliente;
    }

    //Método de cálculo da receita da seguradora. É a soma dos preços dos seguros de todos os clientes dessa seguradora
    public Double calcularReceita() {
        Double receita = 0.0;
        for (Seguro seguro:listaSeguros) {
            receita += seguro.calcularValor();
        }
        return receita;
    }

    //Método toString da classe Seguradora para imprimir todos os dados
    public String toString() {
        String str = "Dados da seguradora\nCNPJ: " + cnpj + "\nNome: " + nome + "\nTelefone: " + telefone + "\nEmail: " + email +
                        "\nEndereco: " + endereco + "\nLista dos IDs e valores dos seguros:\n";
        for (Seguro i:listaSeguros) {
            str = str + "ID: " + String.valueOf(i.getId()) + " | Valor: " + String.valueOf(i.calcularValor()) + "\n";
        }
        str = str + "Lista dos CPFs/CNPJ dos clientes:\n";
        for (Cliente i:listaClientes) {
            if (i instanceof ClientePF) {
                str = str + ((ClientePF) i).getCpf() + " (CPF)\n";
            }
            if (i instanceof ClientePJ) {
                str = str + ((ClientePJ) i).getCnpj() + " (CNPJ)\n";
            }
        }
        str = str + "\n";
        return str;
    }
}