import java.util.Random; //biblioteca com funcao de obter um numero aleatorio

public class Sinistro {
    private int id;
    private String data;
    private String endereco;

    //construtor

    public Sinistro(String data, String endereco) { 
        this.data = data;
        this.endereco = endereco;
        setId();
    }

    //getters e setters

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setId() {
        Random numAleatorio = new Random();
        this.id = numAleatorio.nextInt(1000);
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String toString() {
        String str = "O seguro foi ativado no dia " + data + "; o id do evento eh " + String.valueOf(id) + " e ocorreu no endereco " + endereco;
        return str;
    }
}