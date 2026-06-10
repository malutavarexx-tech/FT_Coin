package br.unicamp.ftcoin.view;

import br.unicamp.ftcoin.model.Carteira;
import br.unicamp.ftcoin.model.Movimentacao;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsável por formatar e exibir dados tabulares no terminal.
 */
public class RelatoriosView {
    // Cores ANSI para o terminal
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public void exibirExtrato(List<Movimentacao> movimentacoes, double saldoAtual) {
        System.out.println("\n" + ANSI_CYAN + "=== EXTRATO DE MOVIMENTAÇÕES ===" + ANSI_RESET);
        if (movimentacoes == null || movimentacoes.isEmpty()) {
            System.out.println("Nenhuma operação registrada ainda.");
            return;
        }

        for (Movimentacao m : movimentacoes) {
            String cor = (m.getTipo().toString().equals("COMPRA")) ? ANSI_GREEN : ANSI_RED;
            System.out.printf("ID: %d | Tipo: %s%s%s | Qtd: %.4f\n", 
                m.getIdentificadorMovimento(), cor, m.getTipo(), ANSI_RESET, m.getQuantidade());
        }
        
        System.out.println("--------------------------------");
        System.out.printf("Saldo Líquido Atual: " + ANSI_GREEN + "%.4f moedas\n" + ANSI_RESET, saldoAtual);
    }

    public void exibirTodasCarteiras(List<Carteira> carteiras) {
        System.out.println("\n" + ANSI_CYAN + "=== CARTEIRAS CADASTRADAS (Ordem Alfabética) ===" + ANSI_RESET);
        if (carteiras.isEmpty()) {
            System.out.println("Nenhuma carteira encontrada.");
            return;
        }

        // Ordenação nativa usando o compareTo que você implementou na Carteira!
        Collections.sort(carteiras);

        for (Carteira c : carteiras) {
            System.out.println(c.toString());
        }
    }
}
