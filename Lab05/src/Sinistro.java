import java.time.LocalDate;
import java.util.Random; 

public class Sinistro {
    private final int ID;
    private LocalDate data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;

    //Construtor
    public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) { 
        this.data = data;
        this.endereco = endereco;
        Random numAleatorio = new Random();
        this.ID = numAleatorio.nextInt(1000);
        this.condutor = condutor;
        this.seguro = seguro;
    }

    //Getters e setters
    public int getId() {
        return ID;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    //Método toString da classe Sinistro para imprimir todos os dados
    public String toString() {
        String str = "Dados do sinistro\nData: " + data + " (Ano-Mes-Dia)" + "\nID: " + String.valueOf(ID) + "\nEndereco: " + endereco +
                        "\nCondutor: " + condutor.getNome() + " (CPF: " + condutor.getCpf() + ")\nID do seguro: " + seguro.getId() + "\n";
        return str;
    }
}