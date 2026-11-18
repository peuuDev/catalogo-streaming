import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreABB arvoreDeTitulos = new ArvoreABB();
        PilhaHistorico pilhaDoHistorico = new PilhaHistorico();
        FilaAssistirMaisTarde filaParaAssistirMaisTarde = new FilaAssistirMaisTarde();

        Scanner leitorDeTeclado = new Scanner(System.in);

        int opcaoDoMenu = -1;

        while (opcaoDoMenu != 0) {
            System.out.println("\n=== CATALOGO DE STREAMING ===");
            System.out.println("1 - Cadastrar titulo");
            System.out.println("2 - Buscar titulo por codigo");
            System.out.println("3 - Excluir titulo");
            System.out.println("4 - Listar acervo (em-ordem)");
            System.out.println("5 - Listar acervo (pre-ordem)");
            System.out.println("6 - Listar acervo (pos-ordem)");
            System.out.println("7 - Assistir titulo");
            System.out.println("8 - Ver historico");
            System.out.println("9 - Adicionar a lista Assistir mais tarde");
            System.out.println("10 - Assistir proximo da lista");
            System.out.println("11 - Ver lista Assistir mais tarde");
            System.out.println("12 - Remover da lista Assistir mais tarde");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            try {
                String textoDigitado = leitorDeTeclado.nextLine();
                opcaoDoMenu = Integer.parseInt(textoDigitado);
            } catch (NumberFormatException erroDeConversao) {
                opcaoDoMenu = -1;
            }

            if (opcaoDoMenu == 1) {
                System.out.print("Codigo: ");
                int codigoDigitado = Integer.parseInt(leitorDeTeclado.nextLine());
                System.out.print("Nome: ");
                String nomeDigitado = leitorDeTeclado.nextLine();
                System.out.print("Tipo (Filme/Serie): ");
                String tipoDigitado = leitorDeTeclado.nextLine();
                System.out.print("Ano: ");
                int anoDigitado = Integer.parseInt(leitorDeTeclado.nextLine());

                Titulo novoTitulo = new Titulo(codigoDigitado, nomeDigitado, tipoDigitado, anoDigitado);
                arvoreDeTitulos.inserirTitulo(novoTitulo);
            } else if (opcaoDoMenu == 2) {
                System.out.print("Codigo: ");
                int codigoDigitado = Integer.parseInt(leitorDeTeclado.nextLine());

                Titulo tituloEncontrado = arvoreDeTitulos.buscarTituloPorCodigo(codigoDigitado);

                if (tituloEncontrado == null) {
                    System.out.println("Titulo nao encontrado.");
                } else {
                    System.out.println(tituloEncontrado);
                }
            } else if (opcaoDoMenu == 3) {
                System.out.print("Codigo: ");
                int codigoDigitado = Integer.parseInt(leitorDeTeclado.nextLine());

                Titulo tituloParaExcluir = arvoreDeTitulos.buscarTituloPorCodigo(codigoDigitado);

                if (tituloParaExcluir == null) {
                    System.out.println("Titulo nao encontrado.");
                } else {
                    arvoreDeTitulos.excluirTitulo(codigoDigitado);
                    filaParaAssistirMaisTarde.removerTituloPorCodigo(codigoDigitado);
                    pilhaDoHistorico.removerTituloPorCodigo(codigoDigitado);
                    System.out.println("Titulo excluido.");
                }
            } else if (opcaoDoMenu == 4) {
                arvoreDeTitulos.percorrerEmOrdem();
            } else if (opcaoDoMenu == 5) {
                arvoreDeTitulos.percorrerPreOrdem();
            } else if (opcaoDoMenu == 6) {
                arvoreDeTitulos.percorrerPosOrdem();
            } else if (opcaoDoMenu == 7) {
                System.out.print("Codigo: ");
                int codigoDigitado = Integer.parseInt(leitorDeTeclado.nextLine());

                Titulo tituloParaAssistir = arvoreDeTitulos.buscarTituloPorCodigo(codigoDigitado);

                if (tituloParaAssistir == null) {
                    System.out.println("Titulo nao encontrado.");
                } else {
                    pilhaDoHistorico.empilharTitulo(tituloParaAssistir);
                    filaParaAssistirMaisTarde.removerTituloPorCodigo(tituloParaAssistir.getCodigo());
                    System.out.println("Assistindo: " + tituloParaAssistir.getNome());
                }
            } else if (opcaoDoMenu == 8) {
                pilhaDoHistorico.listarTitulosDoHistorico();
            } else if (opcaoDoMenu == 9) {
                System.out.print("Codigo: ");
                int codigoDigitado = Integer.parseInt(leitorDeTeclado.nextLine());

                Titulo tituloParaAdicionarNaFila = arvoreDeTitulos.buscarTituloPorCodigo(codigoDigitado);

                if (tituloParaAdicionarNaFila == null) {
                    System.out.println("Titulo nao encontrado.");
                } else {
                    filaParaAssistirMaisTarde.enfileirarTitulo(tituloParaAdicionarNaFila);
                }
            } else if (opcaoDoMenu == 10) {
                Titulo tituloDoInicioDaFila = filaParaAssistirMaisTarde.desenfileirarTitulo();

                if (tituloDoInicioDaFila == null) {
                    System.out.println("Lista vazia.");
                } else {
                    pilhaDoHistorico.empilharTitulo(tituloDoInicioDaFila);
                    System.out.println("Assistindo: " + tituloDoInicioDaFila.getNome());
                }
            } else if (opcaoDoMenu == 11) {
                filaParaAssistirMaisTarde.listarTitulosDaFila();
            } else if (opcaoDoMenu == 12) {
                System.out.print("Codigo: ");
                int codigoDigitado = Integer.parseInt(leitorDeTeclado.nextLine());

                boolean tituloFoiRemovido = filaParaAssistirMaisTarde.removerTituloPorCodigo(codigoDigitado);

                if (tituloFoiRemovido) {
                    System.out.println("Removido da lista.");
                } else {
                    System.out.println("Titulo nao esta na lista.");
                }
            } else if (opcaoDoMenu != 0) {
                System.out.println("Opcao invalida.");
            }
        }

        System.out.println("Ate logo!");
        leitorDeTeclado.close();
    }
}
