package br.unicamp.ftcoin.dao;

import br.unicamp.ftcoin.model.Carteira;
import java.util.ArrayList;
import java.util.List;

public class CarteiraMariaDBDAO implements ICarteiraDAO {
    @Override
    public void salvar(Carteira carteira) {
        System.out.println("[MariaDB] Simulação: Carteira salva no banco remoto.");
    }
    @Override
    public Carteira buscarPorId(int id) { return null; }
    @Override
    public List<Carteira> listarTodas() { return new ArrayList<>(); }
    @Override
    public void atualizar(Carteira carteira) {
        System.out.println("[MariaDB] Simulação: Carteira atualizada.");
    }
    @Override
    public void excluir(int id) {
        System.out.println("[MariaDB] Simulação: Carteira removida.");
    }
}
