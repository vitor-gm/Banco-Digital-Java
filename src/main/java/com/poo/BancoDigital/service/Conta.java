package main.java.com.poo.BancoDigital.service;

import main.java.com.poo.BancoDigital.model.Banco;
import main.java.com.poo.BancoDigital.model.Extrato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    private int numero;
    private int agencia;
    private double saldo;
    private final int senha;
    private static int contas = 0;
    private double divida;
    private Banco banco;
    private List<Extrato> extrato;

    public Conta(int numero, int agencia, double saldo, int senha, double divida, Banco banco) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.senha = senha;
        this.banco = banco;
        this.extrato = new ArrayList<>();
        carregarSaldoEDivida();
        contas++;
    }


    public abstract void emprestimo(double valorEmprestimo, int senha);

    public static int getContas() {

        return contas;
    }

    public void sacar(double valorSaque, int senha) {
        if(this.senha == senha) {
            if(this.saldo < valorSaque) {
                System.out.println("Saldo insuficiente!");
            }else {
                this.saldo -= valorSaque;
            }
            this.extrato.add(new Extrato("Saque", valorSaque, this.saldo, this.divida));
            salvarSaldoEDivida();
        }else {
            System.out.println("Senha incorreta!");
        }
    }

    public void depositar(double valorDeposito) {

        if(this.divida > 0) {
            double desconto = valorDeposito * 0.20;
            if(desconto >= this.divida) {
                valorDeposito -= this.divida;
                banco.depositar(this.divida);
                this.saldo += valorDeposito;
                this.divida = 0;
            }else {
                this.divida -= desconto;
                this.saldo += (valorDeposito - desconto);
                banco.depositar(desconto);
            }

        }else {
            this.saldo += valorDeposito;
        }
        this.extrato.add(new Extrato("Depósito", valorDeposito, this.saldo, this.divida));
        salvarSaldoEDivida();
    }

    public void transferir(Conta contaDestino, double valorTransferencia, int senha) {

        if (this.senha == senha) {
            this.sacar(valorTransferencia, senha);
            contaDestino.depositar(valorTransferencia);
        } else {
            System.out.println("Senha inválida!");
        }
        this.extrato.add(new Extrato("Transferência", this.saldo, valorTransferencia, this.divida));
        salvarSaldoEDivida();

    }

    public void contaExtrato() {
        System.out.println("========");
        System.out.println("Extrato");
        System.out.println("========");
        this.extrato.forEach(n -> {
            System.out.println("Operação: " + n.getOperacao());
            System.out.println("Valor: " + n.getValor());
            System.out.println("Saldo: " + n.getSaldo());
            System.out.println("Divida: " + n.getDivida());
            System.out.println(" ");
        });

    }

    public void pagarDivida(double valorDoBanco) {
        banco.depositar(valorDoBanco);
    }

    public void somarDivida(double emprestimo) {
        this.divida += emprestimo;
    }

    public void depositarEmprestimo(double valorEmprestimo) {
        this.saldo += valorEmprestimo;
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
                    .append(",")
                    .append(e.getDivida())
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
                        if (atributosExtrato.length == 4) {
                            this.extrato.add(new Extrato(atributosExtrato[0], Double.parseDouble(atributosExtrato[1]), Double.parseDouble(atributosExtrato[2]), Double.parseDouble(atributosExtrato[3])));
                        }


                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar saldo e divida: " + e.getMessage());
        }
    }



    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getSenha() {
        return senha;
    }

    public double getDivida() {
        return divida;
    }

    public Banco getBanco() {
        return banco;
    }

    public List<Extrato> getExtrato() {
        return extrato;
    }

    public void setDivida(double divida) {
        this.divida = divida;
    }


}
