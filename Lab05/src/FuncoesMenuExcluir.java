import java.util.ArrayList;
import java.util.Scanner;

public class FuncoesMenuExcluir {

    public static void excluirCliente(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarCliente(scanner, listaSeguradora.get(a));
        for (int i = 0; i < listaSeguradora.get(a).getListaSeguros().size(); i++) {
            if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePF && listaSeguradora.get(a).getListaSeguros().get(i) instanceof SeguroPF && listaSeguradora.get(a).getListaClientes().get(b).equals(((SeguroPF) listaSeguradora.get(a).getListaSeguros().get(i)).getCliente()))
                listaSeguradora.get(a).getListaSeguros().remove(listaSeguradora.get(a).getListaSeguros().get(i));
            else if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePJ && listaSeguradora.get(a).getListaSeguros().get(i) instanceof SeguroPJ && listaSeguradora.get(a).getListaClientes().get(b).equals(((SeguroPJ) listaSeguradora.get(a).getListaSeguros().get(i)).getCliente()))
                listaSeguradora.get(a).getListaSeguros().remove(listaSeguradora.get(a).getListaSeguros().get(i));
        }
        System.out.println("\nCliente " + listaSeguradora.get(a).getListaClientes().get(b).getNome() + " removido(a) com sucesso!\n");
        listaSeguradora.get(a).getListaClientes().remove(b);
    }

    public static void excluirVeiculo(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarCliente(scanner, listaSeguradora.get(a));
        int d;
        if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePF) {
            System.out.println("Selecione um veiculo: ");
            int aux = 1;
            for (Veiculo veiculo:((ClientePF) listaSeguradora.get(a).getListaClientes().get(b)).getListaVeiculos()) {
                System.out.println(aux + " - " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ")");
                aux++;
            }
            d = scanner.nextInt();
            for (Seguro seguro:listaSeguradora.get(a).getListaSeguros()) {
                if (seguro instanceof SeguroPF && ((SeguroPF) seguro).getVeiculo().equals(((ClientePF) listaSeguradora.get(a).getListaClientes().get(b)).getListaVeiculos().get(d)))
                    listaSeguradora.get(a).getListaSeguros().remove(seguro);
            }
            ((ClientePF) listaSeguradora.get(a).getListaClientes().get(b)).removerVeiculo(((ClientePF) listaSeguradora.get(a).getListaClientes().get(b)).getListaVeiculos().get(d));
        }
        else if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePJ) {
            int c = AppMain.selecionarFrota(scanner, listaSeguradora.get(a).getListaClientes().get(b));
            System.out.println("Selecione um veiculo: ");
            int aux = 1;
            for (Veiculo veiculo:((ClientePF) listaSeguradora.get(a).getListaClientes().get(b)).getListaVeiculos()) {
                System.out.println(aux + " - " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ")");
                aux++;
            }
            d = scanner.nextInt();
            ((ClientePJ) listaSeguradora.get(a).getListaClientes().get(b)).getListaFrotas().get(c).getListaVeiculos().remove(d);
        }
        System.out.println("\nVeiculo removido com sucesso!\n");
    }

    public static void excluirSinistro(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarSeguro(scanner, listaSeguradora.get(a));
        int c = AppMain.selecionarCondutor(scanner, listaSeguradora.get(a).getListaSeguros().get(b));
        int d = AppMain.selecionarSinistro(scanner, listaSeguradora.get(a).getListaSeguros().get(b).getListaCondutores().get(c));
        for (Sinistro sinistro:listaSeguradora.get(a).getListaSeguros().get(b).getListaSinistros()) {
            if (sinistro.equals(listaSeguradora.get(a).getListaSeguros().get(b).getListaCondutores().get(c).getListaSinistros().get(d)))
                listaSeguradora.get(a).getListaSeguros().get(b).getListaSinistros().remove(sinistro);
        }
        listaSeguradora.get(a).getListaSeguros().get(b).getListaCondutores().get(c).getListaSinistros().remove(listaSeguradora.get(a).getListaSeguros().get(b).getListaCondutores().get(c).getListaSinistros().get(d));
        System.out.println("\nSinistro removido com sucesso!\n");
    }

    public static void excluirSeguro(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarSeguro(scanner, listaSeguradora.get(a));
        listaSeguradora.get(a).getListaSeguros().remove(b);
        System.out.println("\nSeguro removido com sucesso!\n");
    }

    public static void excluirFrota(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarCliente(scanner, listaSeguradora.get(a));
        if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePJ) {
            int c = AppMain.selecionarFrota(scanner, listaSeguradora.get(a).getListaClientes().get(b));
            for (int i = 0; i < listaSeguradora.get(a).getListaSeguros().size(); i++) {
                if (listaSeguradora.get(a).getListaSeguros().get(i) instanceof SeguroPJ) {
                    if (((SeguroPJ) listaSeguradora.get(a).getListaSeguros().get(i)).getFrota().equals(((ClientePJ) listaSeguradora.get(a).getListaClientes().get(b)).getListaFrotas().get(c)))
                        listaSeguradora.get(a).getListaSeguros().remove(listaSeguradora.get(a).getListaSeguros().get(i));
                }
            }
            ((ClientePJ) listaSeguradora.get(a).getListaClientes().get(b)).getListaFrotas().remove(c);
            System.out.println("\nFrota removida com sucesso!\n");
        }
    }

    public static void excluirCondutor(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarSeguro(scanner, listaSeguradora.get(a));
        if (listaSeguradora.get(a).getListaSeguros().get(b) instanceof SeguroPF)   
            ((SeguroPF) listaSeguradora.get(a).getListaSeguros().get(b)).desautorizarCondutor(scanner);
        else if (listaSeguradora.get(a).getListaSeguros().get(b) instanceof SeguroPJ)   
            ((SeguroPJ) listaSeguradora.get(a).getListaSeguros().get(b)).desautorizarCondutor(scanner);  
        System.out.println("\nCondutor(a) removido(a) com sucesso!\n");      
    }
}
