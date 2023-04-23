import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String endereco;
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

    public ArrayList getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
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

    //Método toString da classe Cliente para imprimir todos os dados
    public String toString() {
        String str = "Dados do cliente\nNome: " + nome + "\nEndereço: " + endereco + 
                        "\nLista de veiculos:";
        for (Veiculo i:listaVeiculos) {
            str = str + " " + i.getModelo() + " (placa " + i.getPlaca() + ") /";
        }
        return str;
    }
}