package main.java.com.exemplo.BancoDigital.Main;

import main.java.com.exemplo.BancoDigital.model.Banco;
import main.java.com.exemplo.BancoDigital.model.Cliente;
import main.java.com.exemplo.BancoDigital.model.ContaSilver;
import main.java.com.exemplo.BancoDigital.model.Endereco;
import main.java.com.exemplo.BancoDigital.service.Conta;
import main.java.com.exemplo.BancoDigital.service.ServicoConta;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("F Bank", 9050, new Endereco("Rio de Janeiro", "Madureira", 300), 1000000d);
        Conta conta = new Conta(1458, 0001, 5d, 1235, 0d, banco);
        Conta conta2 = new Conta(9857, 0001, 7d, 7894, 0d, banco);





        ContaSilver contaSilver = new ContaSilver(002, 001, 10d, 4321, 0d, banco);
        banco.getClientes().add(new Cliente("João Carlos", new Endereco("Rio de Janeiro", "28986348", 251), 2516448, conta));
        banco.getClientes().add(new Cliente("Pedro Silva", new Endereco("Rio de Janeiro", "28568352", 255), 2539848, contaSilver));
        banco.getClientes().add(new Cliente("Julianna Alves", new Endereco("Rio de Janeiro", "28986367", 250), 2853548, conta));
        banco.getClientes().forEach(n -> {
            System.out.println(n.getNome());
            System.out.println(n.getConta().getSaldo());
        });



        System.out.println(Conta.getContas());

    }
}
