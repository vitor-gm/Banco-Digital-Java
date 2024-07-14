package main.java.com.exemplo.BancoDigital.Main;

import main.java.com.exemplo.BancoDigital.model.Cliente;
import main.java.com.exemplo.BancoDigital.model.Endereco;
import main.java.com.exemplo.BancoDigital.service.Conta;
import main.java.com.exemplo.BancoDigital.service.ServicoConta;

public class Main {
    public static void main(String[] args) {

        Conta conta = new Conta(1458, 0001, 5d, 1234, 0d);
        Conta conta2 = new Conta(9857, 0001, 7d, 7894, 0d);
        ServicoConta transferir = new ServicoConta();
        transferir.transferir(2d, conta, conta2, 1234);
        transferir.transferir(2d, conta, conta2, 1234);
        Cliente cliente1 = new Cliente("João Carlos", new Endereco("Rio de Janeiro", "Realengo", "28986352", 251), 2563548, conta);

        System.out.println(Conta.getContas());

    }
}
