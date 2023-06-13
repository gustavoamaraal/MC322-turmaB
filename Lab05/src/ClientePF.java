import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private final String CPF;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento;
    private ArrayList<Veiculo> listaVeiculos;

    //Construtor
    public ClientePF(String nome, String endereco, String CPF, String telefone, String email, String genero, String educacao, LocalDate dataNascimento) {
        super(nome, telefone, endereco, email);
        this.CPF = CPF;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    //Getters e setters
    public String getCpf() {
        return deixaCPFarrumado(CPF);
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    //Retira todos os caracteres não numéricos do CPF
    public String deixaCPFarrumado(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf;
    }

    //Método de castro de veículo
    public boolean cadastrarVeiculo(Veiculo novo_veiculo) {
        for (Veiculo veiculo:listaVeiculos) {
            if (veiculo.equals(novo_veiculo))
                return false;
        }
        listaVeiculos.add(novo_veiculo);
        System.out.println("Veiculo " + novo_veiculo.getMarca() + " " + novo_veiculo.getModelo() + " (placa " + novo_veiculo.getPlaca()  + ") adicionado com sucesso!\n");
        return true;
    }

    //Método de remoção de veículo
    public boolean removerVeiculo(Veiculo veiculo) {
        listaVeiculos.remove(veiculo);
        return true;
    }


    //Método toString da classe ClientePF para imprimir todos os dados
    public String toString() {
        String str = "Dados do ClientePF\nNome: " + super.getNome() + "\nEndereco: " + super.getEndereco() + "\nCPF: " + deixaCPFarrumado(CPF) + 
                        "\nGenero: " + genero + "\nEducacao: " + educacao + "\nData de nascimento: " + dataNascimento + " (Ano-Mes-Dia)" 
                        + "\nTelefone: " + super.getTelefone() + "\nEmail: " + super.getEmail() + "\nLista de veiculos:\n";
        for (int i = 0; i < listaVeiculos.size(); i++) {
            str = str + listaVeiculos.get(i).getMarca() + " " + listaVeiculos.get(i).getModelo() + " (placa " +
             listaVeiculos.get(i).getPlaca() + ") |\n";
        }
        str = str + "\n";
        return str;
    }
}
