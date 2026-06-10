package br.unicamp.ftcoin.dao;

import br.unicamp.ftcoin.model.Movimentacao;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoMariaDBDAO implements IMovimentacaoDAO {
    @Override
    public void salvar(Movimentacao movimentacao) {
        System.out.println("[MariaDB] Simulação: Movimentação registrada.");
    }
    @Override
    public List<Movimentacao> listarPorCarteira(int idCarteira) { return new ArrayList<>(); }
    @Override
    public List<Movimentacao> listarTodas() { return new ArrayList<>(); }
}
