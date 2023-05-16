import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
    private double valorSeguro;
    private ArrayList<Veiculo> listaVeiculos;

    //Construtor
    public Cliente(String nome, String endereco) { 
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    //Método de adição de veículo
    public boolean adicionaVeiculo(Veiculo veiculo) {
        //Se o veículo já estiver cadastrado, retorna false e não acontece nada
        //Se não estiver, ele é adicionado à listaVeiculos e retorna true
        if (listaVeiculos.contains(veiculo)) { 
            System.out.println("O veiculo de placa " + veiculo.getPlaca() + " ja esta cadastrado!\n");
            return false;
        }
        else { 
            listaVeiculos.add(veiculo);
            System.out.println("Veiculo de placa " + veiculo.getPlaca() + " adicionado com sucesso!\n");
            return true;
        }
    }
    
    //Método para sobrecarga em CLientePF e ClientePJ. Não será chamado
    public Double calculaScore() {
        Double a = null;
        return a;
    }

    //Lista todos os veículos do cliente
    public void listaVeiculosPorCliente() {
        System.out.println("Lista de veiculos do cliente " + nome + ": ");
        for (Veiculo veiculo:listaVeiculos) {
            System.out.println(veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ") | ");
        }
    }
    
    //Método toString da classe Cliente para imprimir todos os dados
    public String toString() {
        String str = "Dados do cliente\nNome: " + nome + "\nEndereço: " + endereco + "\nValor do seguro: " + valorSeguro +
                        "\nLista de veiculos:";
        for (Veiculo i:listaVeiculos) {
            str = str + " " + i.getModelo() + " (placa " + i.getPlaca() + ") /";
        }
        return str;
    }
}