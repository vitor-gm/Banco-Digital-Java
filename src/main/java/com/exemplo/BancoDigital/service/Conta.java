package main.java.com.exemplo.BancoDigital.service;

public class Conta {

    private int numero;
    private int agencia;
    private double saldo;
    private final int senha;
    private static int contas = 0;
    private double divida;


    public static int getContas() {

        return contas;
    }

    public Conta(int numero, int agencia, double saldo, int senha, double divida) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.senha = senha;
        this.divida = divida;
        contas++;
    }

    public double sacar(double valorSaque) {
        if(this.saldo < valorSaque) {
            System.out.println("Saldo insuficiente!");
        }else {
            this.saldo -= valorSaque;
        }
        return valorSaque;

    }

    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
    }



    protected int senha() {
        return this.senha;
    }

    public double getSaldo() {
        return saldo;
    }
}
