import java.time.LocalDate;

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

    //Funções para validação do CPF. Fica como leitura o site https://blog.dbins.com.br/como-funciona-a-logica-da-validacao-do-cpf

    public String deixaCPFarrumado(String cpf) {
        //Retira todos os caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf;
    }

    public int calculaDigitoVerificador(int n, String cpf) {
        //Calcula os dígitos verificadores
        //Se quiser o primeiro digito verificador use n = 9. Caso queira o segundo use n = 10
        int dig;
        int soma = 0;
        int j = n + 1;
        for (int i = 0; i < n; i++) {
            soma = soma + (Character.getNumericValue(cpf.charAt(i)))*j;
            j--;
        }
        int resto = soma % 11;
        if (resto == 0 || resto == 1)
            dig = 0;
        else 
            dig = 11 - resto; 
        return dig;
    }

    public Boolean validarCPF(String cpf) {
        //Se o CPF for válido retorna true. Caso contrário retorna false
        cpf = deixaCPFarrumado(cpf);

        //Verifica se há de fato 11 números
        if (cpf.length() != 11) 
            return false;
            
        //Verifica se todos os números são iguais
        int somaComparacoes = 0; 
        for (int i = 1; i < cpf.length(); i++) { 
            if (cpf.charAt(i) == cpf.charAt(0)) 
                somaComparacoes++;
        }
        if (somaComparacoes == 10) 
            return false;
        
        //Verifica se os dígitos verficadores concordam com os esperados
        int dig1Desejado = Character.getNumericValue(cpf.charAt(9)); //Penúltimo numero do CPF
        int dig2Desejado = Character.getNumericValue(cpf.charAt(10)); //Último numero do CPF
        int dig1 = calculaDigitoVerificador(9, cpf); 
        int dig2 = calculaDigitoVerificador(10, cpf);      
        if (dig1 != dig1Desejado || dig2 != dig2Desejado) 
            return false;

        return true; //Se não foi retornado false até agora, retorna true
    }

    public String seValidouOuNao() {
        //Imprime uma mensagem dizendo se o CPF é válido ou não
        String str;
        if (validarCPF(CPF))
            str = "O CPF de " + super.getNome() + " é válido!";
        else
            str = "O CPF de " + super.getNome() + " é inválido!";
        return str;
    }

    //Método toString da classe ClientePF para imprimir todos os dados
    public String toString() {
        String str = "Dados do ClientePF\nNome: " + super.getNome() + "\nEndereco: " + super.getEndereco() + "\nCPF: " + deixaCPFarrumado(CPF) + 
                        "\nValidacao do CPF: " + seValidouOuNao() + "\nGenero: " + genero + "\nData de licenca: " + dataLicenca + " (Ano-Mes-Dia)" + "\nEducacao: " + 
                        educacao + "\nData de nascimento: " + dataNascimento + " (Ano-Mes-Dia)" + "\nClasse economica: " + classeEconomica +
                        "\nLista de veiculos:";
        for (int i = 0; i < super.getListaVeiculos().size(); i++) {
            str = str + " " + ((Veiculo) (super.getListaVeiculos()).get(i)).getMarca() + " " + ((Veiculo) (super.getListaVeiculos()).get(i)).getModelo() + " (placa " + ((Veiculo) (super.getListaVeiculos()).get(i)).getPlaca() + ") |";
        }
        str = str + "\n";
            return str;
    }
}
