package main.java.com.exemplo.BancoDigital.service;

import main.java.com.exemplo.BancoDigital.model.Banco;
import main.java.com.exemplo.BancoDigital.model.Extrato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Conta {

    private int numero;
    private int agencia;
    private double saldo;
    private final int senha;
    private static int contas = 0;
    private double divida;
    private Banco banco;
    private List<Extrato> extrato;


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
        this.extrato = new ArrayList<>();
        carregarSaldoEDivida();

        contas++;
    }

    public double sacar(double valorSaque) {
        if (this.saldo < valorSaque) {
            System.out.println("Saldo insuficiente!");
        } else {
            this.saldo -= valorSaque;
        }
        this.extrato.add(new Extrato("Saque", this.saldo, valorSaque));
        salvarSaldoEDivida();
        return valorSaque;

    }

    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
        this.extrato.add(new Extrato("Depósito", this.saldo, valorDeposito));
        salvarSaldoEDivida();


    }

    public void transferir(Conta contaDestino, double valorTransferencia, int senha) {

        if (this.senha == senha) {
            this.sacar(valorTransferencia);
            contaDestino.depositar(valorTransferencia);
        } else {
            System.out.println("Senha inválida!");
        }
        this.extrato.add(new Extrato("Transferência", this.saldo, valorTransferencia));
        salvarSaldoEDivida();



    }

    protected void contaExtrato() {

    }


    public void salvarSaldoEDivida() {
        String arquivo = "dadosConta" + this.numero + ".txt";
        StringBuilder extratoSerializado = new StringBuilder();
        for (Extrato e : this.extrato) {
            extratoSerializado.append(e.getOperacao())
                    .append(",")
                    .append(e.getValor())
                    .append(",")
                    .append(e.getSaldo())
                    .append(";");

        }
        try (BufferedWriter salvar = new BufferedWriter(new FileWriter(arquivo))) {
            salvar.write(this.saldo + "," + this.divida + "," + extratoSerializado);
        } catch (IOException e) {
            System.out.println("Erro ao salvar saldo e dívida: " + e.getMessage());
        }
    }

    public void carregarSaldoEDivida() {
        String arquivo = "dadosConta" + this.numero + ".txt";
        try (BufferedReader ler = new BufferedReader(new FileReader(arquivo))) {
            String linha = ler.readLine();
            if (linha != null) {
                String[] partes = linha.split(",", 3);
                this.saldo = Double.parseDouble(partes[0]);
                this.divida = Double.parseDouble(partes[1]);
                this.extrato = new ArrayList<>();
                if (partes.length > 2) {

                    String[] extratosSerializados = partes[2].split(";");
                    for (String ex : extratosSerializados) {
                        String[] atributosExtrato = ex.split(",");
                        if (atributosExtrato.length == 3) {
                            this.extrato.add(new Extrato(atributosExtrato[0], Double.parseDouble(atributosExtrato[1]), Double.parseDouble(atributosExtrato[2])));
                        }


                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar saldo e divida: " + e.getMessage());
        }
    }


    public List<Extrato> getExtrato() {
        return extrato;
    }

    public double getSaldo() {
        return saldo;
    }
}
