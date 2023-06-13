public class Validacao {
    
    //Funções para validação do CPF. Fica como leitura o site https://blog.dbins.com.br/como-funciona-a-logica-da-validacao-do-cpf

    static public String deixaCPFarrumado(String cpf) {
        //Retira todos os caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf;
    }

    static public int calculaDigitoVerificadorCPF(int n, String cpf) {
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

    static public Boolean validarCPF(String cpf) {
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
        int dig1 = calculaDigitoVerificadorCPF(9, cpf); 
        int dig2 = calculaDigitoVerificadorCPF(10, cpf);      
        if (dig1 != dig1Desejado || dig2 != dig2Desejado) 
            return false;

        return true; //Se não foi retornado false até agora, retorna true
    }

    //Funções para validação do CNPJ. Fica como leitura o site https://blog.dbins.com.br/como-funciona-a-logica-da-validacao-do-cnpj

    static public String deixaCNPJarrumado(String cnpj) {
        //Retira todos os caracteres não numéricos do CNPJ
        cnpj = cnpj.replaceAll("[^0-9]", "");
        return cnpj;
    }

    static public int calculaDigitoVerificadorCNPJ(int n, String cnpj) { 
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

    static public Boolean validarCNPJ(String cnpj) {
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
        int dig1 = calculaDigitoVerificadorCNPJ(12, cnpj); 
        int dig2 = calculaDigitoVerificadorCNPJ(13, cnpj);      
        if (dig1 != dig1Desejado || dig2 != dig2Desejado) 
            return false;

        return true; //Se não foi retornado false até agora, retorna true
    }

    //Função para validação do nome do cliente
    static public boolean validarNome(String nome) {
        boolean a = nome.matches("^[ A-Za-z]+$");
        return a;
    }

}