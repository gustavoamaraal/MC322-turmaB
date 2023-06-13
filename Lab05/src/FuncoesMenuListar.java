import java.util.ArrayList;
import java.util.Scanner;

public class FuncoesMenuListar {

    //Lista os clientes de uma seguradora
    public static void listarClientesSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        System.out.print("Qual o tipo de cliente que deseja listar? Responda apenas com 'PF' ou 'PJ', sem as aspas: ");
        scanner.nextLine();
        String tipo = scanner.nextLine();       
        if (tipo.equals("PF"))
            listaSeguradora.get(a).listarClientes("PF");
        else if (tipo.equals("PJ"))
            listaSeguradora.get(a).listarClientes("PJ"); 
        else {
            listaSeguradora.get(a).listarClientes("PF");
            listaSeguradora.get(a).listarClientes("PJ"); 
        }      
    }

    //Lista os sinistros de uma seguradora
    public static void listarSinistrosSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        System.out.println("Lista dos sinistros da seguradora " + listaSeguradora.get(a).getNome());
        for (Seguro seguro:listaSeguradora.get(a).getListaSeguros()) {
            for (Sinistro sinistro:seguro.getListaSinistros()) {
                System.out.println("ID " + sinistro.getId() + " | Nome: " + sinistro.getCondutor().getNome() + " (CPF " + sinistro.getCondutor().getCpf() + 
                                    ") | Data: " + sinistro.getData() + " |");
            }
        }
        System.out.print("\n");
    }

    //Lista os sinistros de um seguro
    public static void listarSinistrosSeguro(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarSeguro(scanner, listaSeguradora.get(a));
        System.out.println("Lista dos sinistros do seguro " + listaSeguradora.get(a).getListaSeguros().get(b).getId());
        for (Sinistro sinistro:listaSeguradora.get(a).getListaSeguros().get(b).getListaSinistros()) 
            System.out.println("ID " + sinistro.getId() + " | Nome: " + sinistro.getCondutor().getNome() + " (CPF " + sinistro.getCondutor().getCpf() + 
            ") | Data: " + sinistro.getData() + " |");
        System.out.print("\n");
    }

    //Lista os veiculos de um cliente
    public static void listarVeiculosCliente(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarCliente(scanner, listaSeguradora.get(a));   
        System.out.println("Lista dos veiculos do cliente " + listaSeguradora.get(a).getListaClientes().get(b).getNome()); 
        if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePF) {
            for (Veiculo veiculo:((ClientePF) listaSeguradora.get(a).getListaClientes().get(b)).getListaVeiculos())
                System.out.println(veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ") |");
        }   
        else if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePJ) {
            for (Frota frota:((ClientePJ) listaSeguradora.get(a).getListaClientes().get(b)).getListaFrotas()) {
                for (Veiculo veiculo:frota.getListaVeiculos()) 
                    System.out.println(veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ") |");
            }
        } 
        System.out.print("\n");
    }

    //Lista os veiculos de uma seguradora
    public static void listarVeiculosSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        System.out.println("Lista dos veiculos da seguradora " + listaSeguradora.get(a).getNome()); 
        for (Cliente cliente:listaSeguradora.get(a).getListaClientes()) {
            if (cliente instanceof ClientePF) {
                System.out.println(cliente.getNome() + " (CPF " + ((ClientePF) cliente).getCpf() + ")");
                for (Veiculo veiculo:((ClientePF) cliente).getListaVeiculos())
                    System.out.println(veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ") |");
            }
            else if (cliente instanceof ClientePJ) {
                System.out.println(cliente.getNome() + " (CNPJ " + ((ClientePJ) cliente).getCnpj() + ")");
                for (Frota frota:((ClientePJ) cliente).getListaFrotas()) {
                    for (Veiculo veiculo:frota.getListaVeiculos())
                        System.out.println(veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ") |");
                }
            }
        }
        System.out.print("\n");
    }

    //Lista os seguros de um cliente
    public static void listarSegurosCliente(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarCliente(scanner, listaSeguradora.get(a));
        System.out.println("Lista dos seguros do cliente " + listaSeguradora.get(a).getListaClientes().get(b).getNome()); 
        if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePF) {
            for (Seguro seguro:listaSeguradora.get(a).getListaSeguros()) {
                if (seguro instanceof SeguroPF) {
                    if (((SeguroPF) seguro).getCliente().equals(listaSeguradora.get(a).getListaClientes().get(b))) 
                        System.out.println(seguro.getId() + " | " + ((SeguroPF) seguro).getCliente().getNome() + " | " + ((SeguroPF) seguro).getVeiculo().getMarca() +
                                            " " + ((SeguroPF) seguro).getVeiculo().getModelo() + " (placa " + ((SeguroPF) seguro).getVeiculo().getPlaca() + ")");
                }
            }
        }
        else if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePJ) {
            for (Seguro seguro:listaSeguradora.get(a).getListaSeguros()) {
                if (seguro instanceof SeguroPJ) {
                    if (((SeguroPJ) seguro).getCliente().equals(listaSeguradora.get(a).getListaClientes().get(b))) 
                        System.out.print(seguro.getId() + " | " + ((SeguroPJ) seguro).getCliente().getNome() + " | Frota " + ((SeguroPJ) seguro).getFrota().getCode());
                }
            }            
        }
        System.out.print("\n");
    }

    //Lista os seguros de uma seguradora
    public static void listarSegurosSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        System.out.println("Lista dos seguros da seguradora " + listaSeguradora.get(a).getNome()); 
        for (Seguro seguro:listaSeguradora.get(a).getListaSeguros()) {
            if (seguro instanceof SeguroPF) {
                System.out.println(seguro.getId() + " | " + ((SeguroPF) seguro).getCliente().getNome() + " | " + ((SeguroPF) seguro).getVeiculo().getMarca() +
                                        " " + ((SeguroPF) seguro).getVeiculo().getModelo() + " (placa " + ((SeguroPF) seguro).getVeiculo().getPlaca() + ")");
            }
            else if (seguro instanceof SeguroPJ) {
                System.out.print(seguro.getId() + " | " + ((SeguroPJ) seguro).getCliente().getNome() + " | Frota " + ((SeguroPJ) seguro).getFrota().getCode());
            }
        }
        System.out.print("\n\n");
    }

    //Lista as frotas de uma seguradora
    public static void listarFrotasSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        System.out.println("Lista das frotas da seguradora " + listaSeguradora.get(a).getNome()); 
        for (Cliente cliente:listaSeguradora.get(a).getListaClientes()) {
            if (cliente instanceof ClientePJ) {
                for (Frota frota:((ClientePJ) cliente).getListaFrotas()) {
                    System.out.println("Cliente " + cliente.getNome() + " - Frota " + frota.getCode() + ":");
                    for (Veiculo veiculo:frota.getListaVeiculos()) 
                        System.out.println(veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ") |");
                }
            }
        }
        System.out.print("\n");
    }

    //Lista as frotas de um cliente
    public static void listarFrotasCliente(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarCliente(scanner, listaSeguradora.get(a));
        System.out.println("Lista das frotas do cliente " + listaSeguradora.get(a).getListaClientes().get(b).getNome()); 
        if (listaSeguradora.get(a).getListaClientes().get(b) instanceof ClientePJ) {
            for (Frota frota:((ClientePJ) listaSeguradora.get(a).getListaClientes().get(b)).getListaFrotas()) {
                System.out.println("Frota " + frota.getCode() + ":");
                for (Veiculo veiculo:frota.getListaVeiculos()) 
                    System.out.println(veiculo.getMarca() + " " + veiculo.getModelo() + " (placa " + veiculo.getPlaca() + ") |");
            }
        }
        System.out.print("\n");
    }

    //Lista os condutores de uma seguradora
    public static void listarCondutoresSeguradora(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);  
        System.out.println("Lista dos condutores da seguradora " + listaSeguradora.get(a).getNome());  
        for (Seguro seguro:listaSeguradora.get(a).getListaSeguros()) {
            for (Condutor condutor:seguro.getListaCondutores()) {
                System.out.println(condutor.getNome() + " | CPF " + condutor.getCpf() + " |");
            }
        }  
        System.out.print("\n");
    }

    //Lista os condutores de um seguro
    public static void listarCondutoresSeguro(Scanner scanner, ArrayList<Seguradora> listaSeguradora) {
        int a = AppMain.selecionarSeguradora(scanner, listaSeguradora);
        int b = AppMain.selecionarSeguro(scanner, listaSeguradora.get(a));
        System.out.println("Lista dos condutores do seguro " + listaSeguradora.get(a).getListaSeguros().get(b).getId());  
        for (Condutor condutor:listaSeguradora.get(a).getListaSeguros().get(b).getListaCondutores()) {
            System.out.println(condutor.getNome() + " | CPF " + condutor.getCpf() + " |");
        } 
        System.out.print("\n");
    }

}
