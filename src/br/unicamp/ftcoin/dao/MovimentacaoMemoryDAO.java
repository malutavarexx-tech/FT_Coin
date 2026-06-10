package br.unicamp.ftcoin.dao;

import br.unicamp.ftcoin.model.Movimentacao;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação em memória para persistência de Movimentações.
 */
public class MovimentacaoMemoryDAO implements IMovimentacaoDAO {
    private static final List<Movimentacao> historicoEmMemoria = new ArrayList<>();

    @Override
    public void salvar(Movimentacao movimentacao) {
        historicoEmMemoria.add(movimentacao);
    }

    @Override
    public List<Movimentacao> listarPorCarteira(int idCarteira) {
        List<Movimentacao> filtradas = new ArrayList<>();
        for (Movimentacao m : historicoEmMemoria) {
            if (m.getCarteira() != null && m.getCarteira().getIdentificador() == idCarteira) {
                filtradas.add(m);
            }
        }
        return filtradas;
    }

    @Override
    public List<Movimentacao> listarTodas() {
        return new ArrayList<>(historicoEmMemoria);
    }
}
