package main.java.com.exemplo.BancoDigital.service;

import main.java.com.exemplo.BancoDigital.model.Banco;

import java.util.List;

public class Conta {

    private int numero;
    private int agencia;
    private double saldo;
    private final int senha;
    private static int contas = 0;
    private double divida;
    private Banco banco;
    private List<Double> extrato;


    public static int getContas() {

        return contas;
    }

    public Conta(int numero, int agencia, double saldo, int senha, double divida, Banco banco) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.senha = senha;
        this.divida = divida;
        this.banco = banco;

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

    public void transferir(Conta contaDestino, double valorTransferencia, int senha) {

        if(this.senha == senha) {
            this.sacar(valorTransferencia);
            contaDestino.depositar(valorTransferencia);
        }else {
            System.out.println("Senha inválida!");
        }

    }

    public void extrato() {


    }



    protected int senha() {
        return this.senha;
    }

    public double getSaldo() {
        return saldo;
    }
}
