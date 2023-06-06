import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNascimento;
    private ArrayList<Sinistro> listaSinistros;

    //Construtor
    public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = new ArrayList<Sinistro>();
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return deixaCPFarrumado(cpf);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    

    //Retira todos os caracteres não numéricos do CPF
    public String deixaCPFarrumado(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf;
    }

    //Método para adicionar sinistro
    public void adicionarSinistro(Scanner scanner, Seguro seguro) {

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

        //Criando e adicionando
        Sinistro novoSinistro = new Sinistro(data, endereco, this, seguro);
        listaSinistros.add(novoSinistro);
        seguro.getListaSinistros().add(novoSinistro);
        seguro.calcularValor();
        System.out.println("\nSinistro adicionado!\n");        
    }


    //Método toString para imprimir os dados do condutor
    public String toString() {
        String str = "Dados do Condutor\nNome: " + nome + "\nEndereco: " + endereco + "\nCPF: " + deixaCPFarrumado(cpf) + 
                "\nData de nascimento: " + dataNascimento + " (Ano-Mes-Dia)" + "\nTelefone: " + telefone + "\nEmail: " + email + "\nLista de sinistros:";
        for (int i = 0; i < listaSinistros.size(); i++) {
            str = str + " " + listaSinistros.get(i).getId() + " |";
        }
        str = str + "\n";
        return str;
    }
}
