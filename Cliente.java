public class Cliente {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String endereco;
    private int idade;

    //construtor

    public Cliente(String nome, String cpf, String dataNascimento, String endereco, int idade) { 
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.idade = idade;
    }

    //getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //funcao de validacao do CPF 

    public Boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) //verificando se temos de fato 11 numeros
            return false;
        int somaComparacoes = 0; //
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) == cpf.charAt(0)) //se a comparacao der numeros iguais
                somaComparacoes++;
        }
        if (somaComparacoes == 10) //se todas comparacoes derem numeros iguais
            return false;
        int dig1Desejado = Character.getNumericValue(cpf.charAt(9)); //penultimo numero do cpf
        int dig2Desejado = Character.getNumericValue(cpf.charAt(10)); //ultimo numero do cpf
        int dig1, dig2; //serao calculados posteriormente e comparados com os Desejado
        int soma1 = 0, soma2 = 0;
        int j = 10, k = 11;
        for (int i = 0; i < 9; i++) {
            soma1 = soma1 + (Character.getNumericValue(cpf.charAt(i)))*j;
            j--;
        }
        int resto1 = soma1 % 11;
        if (resto1 == 0 || resto1 == 1) //se o resto da divisao for 0 ou 1, o primeiro digito verificador vale 0
            dig1 = 0;
        else //se nao ele é o proprio resto
            dig1 = 11 - resto1;
        for (int l = 0; l < 10; l++) {
            soma2 = soma2 + (Character.getNumericValue(cpf.charAt(l)))*k;
            k--;
        }
        int resto2 = soma2 % 11;
        if (resto2 == 0 || resto2 == 1) //se o resto da divisao for 0 ou 1, o segundo digito verificador vale 0
            dig2 = 0;
        else //se nao ele é o proprio resto
            dig2 = 11 - resto2;      
        if (dig1 != dig1Desejado || dig2 != dig2Desejado) //comparando os digitos calculados com os desejados
            return false;
        return true; //se nao retornamos false ate agora, entao podemos retornar true
    }

    public String toString() {
        String str = "O nome do cliente eh " + nome + "; seu CPF eh " + cpf + "; sua data de nascimento eh " + dataNascimento + "; seu endereço eh " + endereco + "; e sua idade eh " + String.valueOf(idade);
        return str;
    }
}