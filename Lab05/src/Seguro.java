import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random; 

abstract class Seguro {
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;

    //Construtor
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
        Random random = new Random();
        this.id = random.nextInt(1000);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = 0.0;
    }

    //Getters e setters
    public int getId() {
        return id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }
    
    //Método para sobrecarga
    public void desautorizarCondutor() {
    }

    //Método para sobrecarga
    public void autorizarCondutor() {
    }

    //Método para sobrecarga
    public void gerarSinistro() {  
    }

    //Método para sobrecarga
    public double calcularValor() {  
        return 0.0;
    }    

    //Método toString da classe Seguro
    public String toString() {
        String str = "Dados do seguro:\nId: " + id + "\nData de inicio: " + dataInicio + " (Ano-Mes-Dia)\nData final: " + dataFim +
                        "\nSeguradora: " + seguradora.getNome() + "\nValor mensal: " + valorMensal + "\nLista de IDs dos sinistros:";
        for (Sinistro sinistro:listaSinistros) 
            str = str + " " + sinistro.getId() + " |";
        str = str + "\nLista de condutores: ";
        for (Condutor condutor:listaCondutores)
            str = str + " " + condutor.getNome() + " |";
        return str;
    }
}
