package main.java.com.exemplo.BancoDigital.model;

import main.java.com.exemplo.BancoDigital.service.Conta;

public class Cliente {

    private String nome;
    private Endereco endereco;
    private int cpf;
    private Conta conta;

    public Cliente(String nome, Endereco endereco, int cpf, Conta conta) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.conta = conta;

    }

    public Conta getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }
}
