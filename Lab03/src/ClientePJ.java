import java.time.LocalDate;

public class ClientePJ extends Cliente {
    final String CNPJ;
    private LocalDate dataFundacao;

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

    //Funções para validação do CNPJ. Fica como leitura o site https://blog.dbins.com.br/como-funciona-a-logica-da-validacao-do-cnpj

    public String deixaCNPJarrumado(String cnpj) {
        //Retira todos os caracteres não numéricos do CNPJ
        cnpj = cnpj.replaceAll("[^0-9]", "");
        return cnpj;
    }

    public int calculaDigitoVerificador(int n, String cnpj) { 
        //Calcula os dígitos verificadores
        //Se quiser o primeiro digito verificador use n = 12. Caso queira o segundo use n = 13
        int dig;
        int soma = 0;
        int j = n - 7;
        for (int i = 0; i < n; i++) {
            soma = soma + (Character.getNumericValue(cnpj.charAt(i)))*j;
            j--;
            if (j == 1)
                j = 9;
        }
        int resto = soma % 11;
        if (resto == 0 || resto == 1)
            dig = 0;
        else 
            dig = 11 - resto; 
        return dig;
    }

    public Boolean validarCNPJ(String cnpj) {
        //Se o CNPJ for válido retorna true. Caso contrário retorna false
        cnpj = deixaCNPJarrumado(cnpj);

        //Verifica se há de fato 14 números
        if (cnpj.length() != 14) 
            return false;

        //Verifica se todos os números são iguais
        int somaComparacoes = 0; 
        for (int i = 1; i < cnpj.length(); i++) { 
            if (cnpj.charAt(i) == cnpj.charAt(0)) 
                somaComparacoes++;
        }
        if (somaComparacoes == 13) 
            return false;
        
        //Verifica se os dígitos verficadores concordam com os esperados
        int dig1Desejado = Character.getNumericValue(cnpj.charAt(12)); //Penúltimo número do CNPJ
        int dig2Desejado = Character.getNumericValue(cnpj.charAt(13)); //Último número do CNPJ
        int dig1 = calculaDigitoVerificador(12, cnpj); 
        int dig2 = calculaDigitoVerificador(13, cnpj);      
        if (dig1 != dig1Desejado || dig2 != dig2Desejado) 
            return false;

        return true; //Se não foi retornado false até agora, retorna true
    }

    public String seValidouOuNao() {
        //Imprime uma mensagem dizendo se o CNPJ é válido ou não
        String str;
        if (validarCNPJ(CNPJ))
            str = "O CNPJ de " + super.getNome() + " é válido!";
        else
            str = "O CNPJ de " + super.getNome() + " é inválido!";
        return str;
    }

    //Método toString da classe ClientePJ para imprimir todos os dados
    public String toString() {
        String str = "Dados do ClientePJ\nNome: " + super.getNome() + "\nEndereco: " + super.getEndereco() + "\nCNPJ: " + deixaCNPJarrumado(CNPJ) + 
                        "\nValidacao do CNPJ: " + seValidouOuNao() + "\nData de fundacao: " + dataFundacao + " (Ano-Mes-Dia)\n" + "Lista de veiculos:";
        for (int i = 0; i < super.getListaVeiculos().size(); i++) {
            str = str + " " + ((Veiculo) (super.getListaVeiculos()).get(i)).getMarca() + " " + ((Veiculo) (super.getListaVeiculos()).get(i)).getModelo() + " (placa " + ((Veiculo) (super.getListaVeiculos()).get(i)).getPlaca() + ") |";
        }
        str = str + "\n";
            return str;
    }
}
