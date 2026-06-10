package br.unicamp.ftcoin.dao;

import br.unicamp.ftcoin.model.Carteira;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementação em memória para persistência de Carteiras.
 */
public class CarteiraMemoryDAO implements ICarteiraDAO {
    private static final List<Carteira> bancoEmMemoria = new ArrayList<>();

    @Override
    public void salvar(Carteira carteira) {
        bancoEmMemoria.add(carteira);
    }

    @Override
    public Carteira buscarPorId(int id) {
        for (Carteira c : bancoEmMemoria) {
            if (c.getIdentificador() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Carteira> listarTodas() {
        return new ArrayList<>(bancoEmMemoria);
    }

    @Override
    public void atualizar(Carteira carteira) {
        Carteira existente = buscarPorId(carteira.getIdentificador());
        if (existente != null) {
            existente.setNomeTitular(carteira.getNomeTitular());
            existente.setCorretora(carteira.getCorretora());
        }
    }

    @Override
    public void excluir(int id) {
        Carteira c = buscarPorId(id);
        if (c != null) {
            bancoEmMemoria.remove(c);
        }
    }
}
