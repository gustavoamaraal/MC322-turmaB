import java.time.LocalDate;
import java.time.temporal.*;

public class ClientePF extends Cliente {
    final String CPF;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;

    //Construtor
    public ClientePF(String nome, String endereco, String CPF, String genero, LocalDate dataLicenca, String educacao, LocalDate dataNascimento, String classeEconomica) {
        super(nome, endereco);
        this.CPF = CPF;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
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

    public LocalDate getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
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

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    //Método de sobrecarga. Calcula o score do cliente, que será utilizado para calcular o preço do seguro
	public Double calculaScore() {
		Double score = null;
		long idade1 = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
        int idade = Math.toIntExact(idade1);
		if (idade <= 30) {
			score = (CalcSeguro.VALOR_BASE.getValor()) * (CalcSeguro.FATOR_18_30.getValor()) * (super.getListaVeiculos().size());
			
		}
		else if (idade > 30 && idade <= 60) {
			score = (CalcSeguro.VALOR_BASE.getValor()) * (CalcSeguro.FATOR_30_60.getValor()) * (super.getListaVeiculos().size());

		}
		else if (idade > 60) {
			score = (CalcSeguro.VALOR_BASE.getValor()) * (CalcSeguro.FATOR_60_90.getValor()) * (super.getListaVeiculos().size());

		}
		return score;
	}


    //Retira todos os caracteres não numéricos do CPF
    static public String deixaCPFarrumado(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf;
    }

    //Método toString da classe ClientePF para imprimir todos os dados
    public String toString() {
        String str = "Dados do ClientePF\nNome: " + super.getNome() + "\nEndereco: " + super.getEndereco() + "\nCPF: " + deixaCPFarrumado(CPF) + 
                        "\nGenero: " + genero + "\nData de licenca: " + dataLicenca + " (Ano-Mes-Dia)" + "\nEducacao: " + 
                        educacao + "\nData de nascimento: " + dataNascimento + " (Ano-Mes-Dia)" + "\nClasse economica: " + classeEconomica +
                        "\nValor do seguro: " + super.getValorSeguro() + "\nLista de veiculos:";
        for (int i = 0; i < super.getListaVeiculos().size(); i++) {
            str = str + " " + ((Veiculo) (super.getListaVeiculos()).get(i)).getMarca() + " " + ((Veiculo) (super.getListaVeiculos()).get(i)).getModelo() + " (placa " +
             ((Veiculo) (super.getListaVeiculos()).get(i)).getPlaca() + ") |";
        }
        str = str + "\n";
            return str;
    }
}
