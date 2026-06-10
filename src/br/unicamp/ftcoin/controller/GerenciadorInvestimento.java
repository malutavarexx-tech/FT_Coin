package br.unicamp.ftcoin.controller;

import br.unicamp.ftcoin.dao.ICarteiraDAO;
import br.unicamp.ftcoin.dao.IMovimentacaoDAO;
import br.unicamp.ftcoin.model.Carteira;
import br.unicamp.ftcoin.model.Movimentacao;
import br.unicamp.ftcoin.model.TipoOperacao;

import java.util.List;

/**
 * Controlador responsável pelas regras de negócio e cálculos financeiros.
 */
public class GerenciadorInvestimento {
    private ICarteiraDAO carteiraDAO;
    private IMovimentacaoDAO movimentacaoDAO;

    // Polimorfismo: aceita qualquer implementação que siga o contrato das interfaces
    public GerenciadorInvestimento(ICarteiraDAO carteiraDAO, IMovimentacaoDAO movimentacaoDAO) {
        this.carteiraDAO = carteiraDAO;
        this.movimentacaoDAO = movimentacaoDAO;
    }

    // Calcula a quantidade líquida de moedas que a carteira possui
    public double calcularSaldoMoedas(int idCarteira) {
        List<Movimentacao> movimentacoes = movimentacaoDAO.listarPorCarteira(idCarteira);
        double saldo = 0.0;

        if (movimentacoes != null) {
            for (Movimentacao m : movimentacoes) {
                if (m.getTipo() == TipoOperacao.COMPRA) {
                    saldo += m.getQuantidade();
                } else if (m.getTipo() == TipoOperacao.VENDA) {
                    saldo -= m.getQuantidade();
                }
            }
        }
        return saldo;
    }

    // Regra de Negócio: Registrar Compra
    public void registrarCompra(Movimentacao mov) {
        movimentacaoDAO.salvar(mov);
    }

    // Regra de Negócio: Registrar Venda com Validação de Saldo
    public boolean registrarVenda(Movimentacao mov) {
        double saldoDisponivel = calcularSaldoMoedas(mov.getCarteira().getIdentificador());
        
        if (mov.getQuantidade() > saldoDisponivel) {
            // Se tentar vender mais do que tem, barra a operação
            return false; 
        }
        
        movimentacaoDAO.salvar(mov);
        return true;
    }
}
