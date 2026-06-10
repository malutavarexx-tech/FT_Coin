package br.unicamp.ftcoin.dao;

import br.unicamp.ftcoin.model.Movimentacao;
import java.util.List;

/**
 * Interface que define as operações de persistência para as Movimentações.
 */
public interface IMovimentacaoDAO {
    void salvar(Movimentacao movimentacao);
    List<Movimentacao> listarPorCarteira(int idCarteira);
    List<Movimentacao> listarTodas();
}
