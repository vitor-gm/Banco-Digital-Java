package main.java.com.exemplo.BancoDigital.model;

import main.java.com.exemplo.BancoDigital.service.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private int agencia;
    private Endereco endereco;
    private double caixa;
    private List<Cliente> clientes;
    private int numDeContas;

    public Banco(String nome, int agencia, Endereco endereco, double caixa, int numDeContas) {
        this.nome = nome;
        this.agencia = agencia;
        this.endereco = endereco;
        this.caixa = caixa;
        this.clientes = new ArrayList<>();
        this.numDeContas = Conta.getContas();
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", agencia=" + agencia +
                ", endereco=" + endereco +
                ", caixa=" + caixa +
                '}';
    }

    public double getCaixa() {
        return caixa;
    }
}
