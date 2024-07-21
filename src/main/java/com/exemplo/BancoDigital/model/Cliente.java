package main.java.com.exemplo.BancoDigital.model;

import main.java.com.exemplo.BancoDigital.service.Conta;

public class Cliente {

    private String nome;
    private Endereco endereco;
    private int cpf;
    private Conta conta;

    public Cliente(String nome, Endereco endereco, int cpf, double saldo, int numero, int agencia, int senha, double divida, Banco banco) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.conta = tipoDeConta(numero, agencia, saldo, senha, divida, banco);
    }

    private Conta tipoDeConta(int numero, int agencia, double saldo, int senha, double divida, Banco banco) {
        if(saldo < 1000) {
            return new ContaSilver(numero, agencia, saldo, senha, divida, banco);
        } else if (saldo >= 1000 && saldo < 5000) {
            return new ContaGold(numero, agencia, saldo, senha, divida, banco);
        }else {
            return new ContaDiamond(numero, agencia, saldo, senha, divida, banco);
        }
    }

    public Conta getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }
}
