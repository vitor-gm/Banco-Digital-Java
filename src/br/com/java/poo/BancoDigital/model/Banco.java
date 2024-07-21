package br.com.java.poo.BancoDigital.model;

import br.com.java.poo.BancoDigital.service.Conta;

import java.io.*;
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
        carregarCaixa();
    }

    public void depositar(double valorDoDeposito) {
        this.caixa += valorDoDeposito;
        salvarCaixa();
    }

    public void sacar(double valorDoSaque) {
        this.caixa -= valorDoSaque;
        salvarCaixa();
    }


    public double getCaixa() {
        return caixa;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void salvarCaixa() {
        String arquivoBanco = "caixaBanco.txt";
        try(BufferedWriter salvar = new BufferedWriter(new FileWriter(arquivoBanco))) {
            salvar.write(this.caixa + ",");
        }catch (IOException e) {
            System.out.println("Erro ao salvar caixa : " + e.getMessage());
        }
    }

    public void carregarCaixa() {
        String arquivoBanco = "caixaBanco.txt";
        try (BufferedReader ler = new BufferedReader(new FileReader(arquivoBanco))) {
            String linha = ler.readLine();
            if (linha != null) {
                String[] partes = linha.split(",", 0);
                this.caixa = Double.parseDouble(partes[0]);
            }
        }catch (IOException e) {
            System.out.println("Erro ao carregar caixa: " + e.getMessage());
        }
    }
}
