package br.unicamp.ftcoin.model;

/**
 * Entidade que representa a Carteira de Moedas Virtuais.
 * Implementa Comparable para permitir a ordenação nativa por nome do titular.
 */
public class Carteira implements Comparable<Carteira> {
    private int identificador;
    private String nomeTitular;
    private String corretora;

    // Construtor padrão obrigatório
    public Carteira() {
    }

    // Construtor completo para facilitar a criação de objetos
    public Carteira(int identificador, String nomeTitular, String corretora) {
        this.identificador = identificador;
        this.nomeTitular = nomeTitular;
        this.corretora = corretora;
    }

    // Getters e Setters (Encapsulamento POO)
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCorretora() {
        return corretora;
    }

    public void setCorretora(String corretora) {
        this.corretora = corretora;
    }

    // Lógica de ordenação alfabética pelo nome do titular (para atender os relatórios)
    @Override
    public int compareTo(Carteira outra) {
        if (this.nomeTitular == null || outra.getNomeTitular() == null) {
            return 0;
        }
        return this.nomeTitular.compareToIgnoreCase(outra.getNomeTitular());
    }

    @Override
    public String toString() {
        return "ID: " + identificador + " | Titular: " + nomeTitular + " | Corretora: " + corretora;
    }
}
