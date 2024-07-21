package br.com.java.poo.BancoDigital.model;

public class Extrato {

    private String operacao;
    private double saldo;
    private double valor;
    private double divida;

    public Extrato(String operacao, double valor, double saldo, double divida) {
        this.operacao = operacao;
        this.saldo = saldo;
        this.valor = valor;
        this.divida = divida;
    }

    public String getOperacao() {
        return operacao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getValor() {
        return valor;
    }

    public double getDivida() {
        return divida;
    }
}
