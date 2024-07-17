package main.java.com.exemplo.BancoDigital.model;

import main.java.com.exemplo.BancoDigital.service.Conta;

public class ContaSilver extends Conta {

    public ContaSilver(int numero, int agencia, double saldo, int senha, double divida, Banco banco) {
        super(numero, agencia, saldo, senha, divida, banco);
    }
}
