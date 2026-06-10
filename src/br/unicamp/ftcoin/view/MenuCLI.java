package br.unicamp.ftcoin.view;

import br.unicamp.ftcoin.controller.GerenciadorInvestimento;
import br.unicamp.ftcoin.dao.CarteiraMemoryDAO;
import br.unicamp.ftcoin.dao.MovimentacaoMemoryDAO;
import br.unicamp.ftcoin.model.Carteira;
import br.unicamp.ftcoin.model.Movimentacao;
import br.unicamp.ftcoin.model.TipoOperacao;

import java.util.Date;
import java.util.Scanner;

/**
 * Interface de Linha de Comando principal do FT_Coin.
 */
public class MenuCLI {
    public static void main(String[] args) {
        // Inicializando os componentes da arquitetura MVC
        CarteiraMemoryDAO carteiraDAO = new CarteiraMemoryDAO();
        MovimentacaoMemoryDAO movimentacaoDAO = new MovimentacaoMemoryDAO();
        GerenciadorInvestimento controlador = new GerenciadorInvestimento(carteiraDAO, movimentacaoDAO);
        RelatoriosView viewRelatorios = new RelatoriosView();

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        // Criando uma carteira padrão de testes para facilitar
        Carteira carteiraPadrao = new Carteira(1, "Malu Tavares", "FT_Corretora");
        carteiraDAO.salvar(carteiraPadrao);

        System.out.println(RelatoriosView.ANSI_CYAN + "Welcome to FT_Coin System! v1.0" + RelatoriosView.ANSI_RESET);

        while (opcao != 0) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Cadastrar Nova Carteira");
            System.out.println("2. Listar Todas as Carteiras");
            System.out.println("3. Registrar Operação de Compra");
            System.out.println("4. Registrar Operação de Venda");
            System.out.println("5. Ver Extrato e Saldo Atual");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(RelatoriosView.ANSI_RED + "Erro: Digite um número válido!" + RelatoriosView.ANSI_RESET);
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("ID da Carteira: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome do Titular: ");
                    String titular = scanner.nextLine();
                    System.out.print("Nome da Corretora: ");
                    String corretora = scanner.nextLine();
                    
                    carteiraDAO.salvar(new Carteira(id, titular, corretora));
                    System.out.println(RelatoriosView.ANSI_GREEN + "Carteira cadastrada com sucesso!" + RelatoriosView.ANSI_RESET);
                    break;

                case 2:
                    viewRelatorios.exibirTodasCarteiras(carteiraDAO.listarTodas());
                    break;

                case 3:
                    System.out.print("Quantidade de moedas para COMPRAR: ");
                    double qtdCompra = Double.parseDouble(scanner.nextLine());
                    
                    Movimentacao comp = new Movimentacao((int)(Math.random()*1000), new Date(), TipoOperacao.COMPRA, qtdCompra, carteiraPadrao);
                    controlador.registrarCompra(comp);
                    System.out.println(RelatoriosView.ANSI_GREEN + "Compra registrada!" + RelatoriosView.ANSI_RESET);
                    break;

                case 4:
                    System.out.print("Quantidade de moedas para VENDER: ");
                    double qtdVenda = Double.parseDouble(scanner.nextLine());
                    
                    Movimentacao vend = new Movimentacao((int)(Math.random()*1000), new Date(), TipoOperacao.VENDA, qtdVenda, carteiraPadrao);
                    boolean sucesso = controlador.registrarVenda(vend);
                    
                    if (sucesso) {
                        System.out.println(RelatoriosView.ANSI_GREEN + "Venda realizada com sucesso!" + RelatoriosView.ANSI_RESET);
                    } else {
                        System.out.println(RelatoriosView.ANSI_RED + "Erro: Saldo Insuficiente para realizar essa venda!" + RelatoriosView.ANSI_RESET);
                    }
                    break;

                case 5:
                    double saldo = controlador.calcularSaldoMoedas(carteiraPadrao.getIdentificador());
                    viewRelatorios.exibirExtrato(movimentacaoDAO.listarPorCarteira(carteiraPadrao.getIdentificador()), saldo);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema FT_Coin. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}
