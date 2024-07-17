package main.java.com.exemplo.BancoDigital.model;

import main.java.com.exemplo.BancoDigital.service.Conta;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private int banco;
    private Endereco endereco;
    private double caixa;
    private List<Cliente> clientes;
    private int numDeContas;

    public Banco(String nome, int banco, Endereco endereco, double caixa) {
        this.nome = nome;
        this.banco = banco;
        this.endereco = endereco;
        this.caixa = caixa;
        this.clientes = new ArrayList<>();
        this.numDeContas = Conta.getContas();
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", banco=" + banco +
                ", endereco=" + endereco +
                ", caixa=" + caixa +
                '}';
    }

    public double getCaixa() {
        return caixa;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
