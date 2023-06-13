import java.time.LocalDate;
import java.util.Scanner;
import java.time.temporal.*;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;
    
    //Construtor
    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
    }

    //Getters e setters
    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }
    
    //Método para desautorizar condutor
    public boolean desautorizarCondutor(Scanner scanner) {
    //Os condutores são listados e o usuário seleciona um para remove-lo de listaCondutores 
        System.out.println("Selecione o(a) condutor(a): ");
        int a = 1;
        for (Condutor condutor:super.getListaCondutores()) {
            System.out.println(a + " - " + condutor.getNome() + " (CPF " + condutor.getCpf() + ")");
            a++;
        }
        int b = scanner.nextInt();
        for (int i = 0; i < super.getListaSinistros().size(); i++) {
            if (super.getListaSinistros().get(i).getCondutor().equals(super.getListaCondutores().get(b-1)))
                super.getListaSinistros().remove(super.getListaSinistros().get(i));
        }
        System.out.println("\nCondutor " + super.getListaCondutores().get(b-1).getNome() + " desautorizado(a)!\n");
        super.getListaCondutores().remove(b-1);
        calcularValor();
        return true;
    }

    //Método para adicionar sinistro
    public void gerarSinistro(Scanner scanner) {

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
        //Condutor
        System.out.println("Selecione um(a) condutor(a): ");
        int a = 1;
        for (Condutor condutor:super.getListaCondutores()) {
            System.out.println(a + " - " + condutor.getNome() + " (CPF " + condutor.getCpf() + ")");
            a++;
        }
        int b = scanner.nextInt();

        //Criando e adicionando em listaSinistros do seguro e do condutor
        Sinistro novoSinistro = new Sinistro(data, endereco, super.getListaCondutores().get(b-1), this);
        super.getListaSinistros().add(novoSinistro); 
        super.getListaCondutores().get(b-1).getListaSinistros().add(novoSinistro);
        calcularValor();
        System.out.println("\nSinistro adicionado!\n");   
        scanner.nextLine();      
    }

    //Método para autorizar condutor
    public boolean autorizarCondutor(Condutor novo_condutor) {
        for (Condutor condutor:super.getListaCondutores()) {
            if (condutor.equals(novo_condutor))
                return false;
        }
        super.getListaCondutores().add(novo_condutor);
        calcularValor();
        System.out.println("\nCondutor " + novo_condutor.getNome() + " autorizado(a)!\n");
        return true;
    }

    //
    public double calcularValor() {  
        long idade = ChronoUnit.YEARS.between(cliente.getDataFundacao(), LocalDate.now());
        int AnosPosFundacao = Math.toIntExact(idade);
        int qtdeSinistrosCondutores = 0;//Quantidade de sinistros de todos os condutores do seguro
        int qtdeSinistrosCliente = super.getListaSinistros().size(); //Quantidade de sinistros do cliente
        for (Condutor condutor:super.getListaCondutores()) {
            qtdeSinistrosCondutores += condutor.getListaSinistros().size();
        }

        double valor = CalcValor.VALOR_BASE.getValor() * (10 + super.getListaCondutores().size()/10) * (1 + 1/(frota.getListaVeiculos().size()+2)) *
                            (1 + 1/(AnosPosFundacao+2)) * (2 + qtdeSinistrosCliente/10) * (5 + qtdeSinistrosCondutores/10);
        super.setValorMensal(valor);
        return valor;
    }  

    //Método toString para a classe SeguroPJ
    public String toString() {
        String str = super.toString() + "\nFrota " + frota.getCode() + ":\n";
        for (Veiculo veiculo:frota.getListaVeiculos()) 
            str = str + veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ") |\n";
        str = str + "Cliente: " + cliente.getNome() + " (CNPJ: " + cliente.getCnpj() + ")\n";
        return str;
    }
}