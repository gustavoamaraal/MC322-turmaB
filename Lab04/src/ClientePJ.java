import java.time.LocalDate;

public class ClientePJ extends Cliente {
    final String CNPJ;
    private LocalDate dataFundacao;
    private int qtdeFuncionarios;

    //Construtor
    public ClientePJ(String nome, String endereco, String CNPJ, LocalDate dataFundacao) {
        super(nome, endereco);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
    }

    //Getters e setters
    public String getCnpj() {
        return deixaCNPJarrumado(CNPJ);
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    //Retira todos os caracteres não numéricos do CNPJ
    public String deixaCNPJarrumado(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");
        return cnpj;
    }

    //Método de sobrecarga. Calcula o score do cliente, que será utilizado para calcular o preço do seguro
    public Double calculaScore() {
        Double score = (CalcSeguro.VALOR_BASE.getValor()) * (1 + (qtdeFuncionarios/100)) * (super.getListaVeiculos().size());
        return score;
    }

    //Método toString da classe ClientePJ para imprimir todos os dados
    public String toString() {
        String str = "Dados do ClientePJ\nNome: " + super.getNome() + "\nEndereco: " + super.getEndereco() + "\nCNPJ: " + deixaCNPJarrumado(CNPJ) + 
                        "\nData de fundacao: " + dataFundacao +  " (Ano-Mes-Dia)" + "\nValor do seguro: " + super.getValorSeguro() + "Lista de veiculos:";
        for (int i = 0; i < super.getListaVeiculos().size(); i++) {
            str = str + " " + ((Veiculo) (super.getListaVeiculos()).get(i)).getMarca() + " " + ((Veiculo) (super.getListaVeiculos()).get(i)).getModelo() + " (placa " + ((Veiculo) (super.getListaVeiculos()).get(i)).getPlaca() + ") |";
        }
        str = str + "\n";
            return str;
    }
}
