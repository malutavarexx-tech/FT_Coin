package br.unicamp.ftcoin.dao;

import br.unicamp.ftcoin.model.Carteira;
import java.util.List;

/**
 * Interface que define as operações de CRUD para a entidade Carteira.
 */
public interface ICarteiraDAO {
    void salvar(Carteira carteira);
    Carteira buscarPorId(int id);
    List<Carteira> listarTodas();
    void atualizar(Carteira carteira);
    void excluir(int id);
}
