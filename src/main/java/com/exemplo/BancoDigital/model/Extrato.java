package main.java.com.exemplo.BancoDigital.model;

public class Extrato {

    private String operacao;
    private double saldo;
    private double valor;

    public Extrato(String operacao, double saldo, double valor) {
        this.operacao = operacao;
        this.saldo = saldo;
        this.valor = valor;
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

    @Override
    public String toString() {
        return "Extrato{" +
                "operacao='" + operacao + '\'' +
                ", saldo=" + saldo +
                ", valor=" + valor +
                '}';
    }
}
