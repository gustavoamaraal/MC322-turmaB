class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Jorge", "529.982.247-25", "05/10/1998", "Rua Gato Laranja, 1848", 23);
        cliente1.setIdade(24);
        System.out.println(cliente1);
        if (cliente1.validarCPF(cliente1.getCpf()))
            System.out.println("O CPF de " + cliente1.getNome() + " é válido!");
        else
        System.out.println("O CPF de " + cliente1.getNome() + " é inválido!");

        Seguradora seguradora1 = new Seguradora("Barão Geraldo Seguros", "(19)991665616", "baraoseguros@mc322.com", "Rua Urso Verde, 123");
        seguradora1.setEmail("baraoseguros@mc322.com.br");
        System.out.println(seguradora1);

        Sinistro sinistro1 = new Sinistro("26/03/2023", "Rua Gambá Roxo, 540");
        sinistro1.setEndereco("Rua Gambá Rosa, 540");
        System.out.println(sinistro1);

        Veiculo veiculo1 = new Veiculo("ABC1D23", "Chevrolet", "Celta");
        veiculo1.setPlaca("POO3E22");
        veiculo1.setModelo("Celta 2000");
        System.out.println(veiculo1);
    }
}