package main.java.com.poo.BancoDigital.model;

import main.java.com.poo.BancoDigital.service.Conta;
import main.java.com.poo.BancoDigital.service.ServicoConta;

public class ContaDiamond extends Conta {

    public ContaDiamond(int numero, int agencia, double saldo, int senha, double divida, Banco banco) {
        super(numero, agencia, saldo, senha, divida, banco);
    }

    @Override
    public void emprestimo(double valorEmprestimo, int senha) {
        if (valorEmprestimo > getSaldo() * 0.8 || getDivida() > 0) {
            System.out.println("Empréstimo negado!");
        } else {
            System.out.println("Empréstimo aprovado!");
            getBanco().sacar(valorEmprestimo);
            depositarEmprestimo(valorEmprestimo);
            somarDivida(valorEmprestimo * 1.2);
            getExtrato().add(new Extrato("Empréstimo", valorEmprestimo, this.getSaldo(), this.getDivida()));
            salvarSaldoEDivida();

        }
    }
}