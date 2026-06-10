package br.unicamp.ftcoin.model;

import java.util.Date;

/**
 * Entidade que representa os registros de Compra e Venda.
 * Possui uma associação direta com a Carteira correspondente.
 */
public class Movimentacao {
    private int identificadorMovimento;
    private Date dataOperacao;
    private TipoOperacao tipo; // COMPRA ou VENDA
    private double quantidade;
    private Carteira carteira; // Associação/Composição

    // Construtor padrão
    public Movimentacao() {
    }

    // Construtor completo
    public Movimentacao(int identificadorMovimento, Date dataOperacao, TipoOperacao tipo, double quantidade, Carteira carteira) {
        this.identificadorMovimento = identificadorMovimento;
        this.dataOperacao = dataOperacao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.carteira = carteira;
    }

    // Getters e Setters
    public int getIdentificadorMovimento() {
        return identificadorMovimento;
    }

    public void setIdentificadorMovimento(int identificadorMovimento) {
        this.identificadorMovimento = identificadorMovimento;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantity;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    @Override
    public String toString() {
        return "Movimento ID: " + identificadorMovimento + " | " + tipo + " | Qtd: " + quantidade + " | Carteira ID: " + (carteira != null ? carteira.getIdentificador() : "N/A");
    }
}
