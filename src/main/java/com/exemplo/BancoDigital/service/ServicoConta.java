package main.java.com.exemplo.BancoDigital.service;

public interface ServicoConta {

    double cartãoDeCredito(double valorDaCompra, int parcelas, int senha);

    double emprestimo(double valorEmprestimo, int parcelas, int senha);

    double investimentos(double valorAInvestir, int senha);




}
