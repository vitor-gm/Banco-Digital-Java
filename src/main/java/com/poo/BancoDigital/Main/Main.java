package main.java.com.poo.BancoDigital.Main;

import main.java.com.exemplo.BancoDigital.model.*;
import main.java.com.poo.BancoDigital.model.Banco;
import main.java.com.poo.BancoDigital.model.Cliente;
import main.java.com.poo.BancoDigital.model.Endereco;


public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("F Bank", 9050, new Endereco("Rio de Janeiro", "Madureira", 300), 1000000d);

        banco.getClientes().add(new Cliente("João Carlos", new Endereco("Rio de Janeiro", "28986348", 251), 2516448, 500d, 1563, 0001, 1234, 0d, banco));
        banco.getClientes().add(new Cliente("Pedro Silva", new Endereco("Rio de Janeiro", "28568352", 255), 2539848, 10000d, 2689, 0001, 9865, 0d, banco));
        banco.getClientes().add(new Cliente("Julianna Alves", new Endereco("Rio de Janeiro", "28986367", 250), 2853548, 4000d, 3652, 0001, 5417, 0d, banco));

        banco.getClientes().get(0).getConta().emprestimo(100d, 1234);
        banco.getClientes().get(0).getConta().depositar(100d);
        banco.getClientes().get(0).getConta().sacar(10d, 1234);
        banco.getClientes().get(0).getConta().contaExtrato();







    }
}
