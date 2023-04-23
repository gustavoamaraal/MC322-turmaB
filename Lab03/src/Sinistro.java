import java.util.Random; 

public class Sinistro {
    final int ID;
    private String data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    //Construtor
    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) { 
        this.data = data;
        this.endereco = endereco;
        Random numAleatorio = new Random();
        this.ID = numAleatorio.nextInt(1000);
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    //Getters e setters
    public int getId() {
        return ID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //Método toString da classe Sinistro para imprimir todos os dados
    public String toString() {
        String str = "Dados do sinistro\nData: " + data + "\nID: " + String.valueOf(ID) + "\nEndereco: " + endereco +
                        "\nSeguradora: " + seguradora.getNome() + "\nPlaca do veiculo: " + veiculo.getPlaca() + "\nCliente: " + 
                        cliente.getNome();
        if (cliente instanceof ClientePF) {
            str = str + " (CPF " + ((ClientePF) cliente).getCpf() + ")\n";
        }
        else if (cliente instanceof ClientePJ) {
            str = str + " (CNPJ " + ((ClientePJ) cliente).getCnpj() + ")\n";
        }
        return str;
    }
}