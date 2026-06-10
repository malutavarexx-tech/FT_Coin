package br.unicamp.ftcoin.model;

import java.util.Date;

/**
 * Entidade que armazena os valores obtidos através do Oráculo.
 */
public class Cotacao {
    private String siglaMoeda; // Ex: BTC, ETH
    private double valorEmReais;
    private Date dataLeitura;

    public Cotacao() {
    }

    public Cotacao(String siglaMoeda, double valorEmReais, Date dataLeitura) {
        this.siglaMoeda = siglaMoeda;
        this.valorEmReais = valorEmReais;
        this.dataLeitura = dataLeitura;
    }

    public String getSiglaMoeda() {
        return siglaMoeda;
    }

    public void setSiglaMoeda(String siglaMoeda) {
        this.siglaMoeda = siglaMoeda;
    }

    public double getValorEmReais() {
        return valorEmReais;
    }

    public void setValorEmReais(double valorEmReais) {
        this.valorEmReais = valorEmReais;
    }

    public Date getDataLeitura() {
        return dataLeitura;
    }

    public void setDataLeitura(Date dataLeitura) {
        this.dataLeitura = dataLeitura;
    }

    @Override
    public String toString() {
        return "Moeda: " + siglaMoeda + " | Valor: R$ " + valorEmReais;
    }
}
