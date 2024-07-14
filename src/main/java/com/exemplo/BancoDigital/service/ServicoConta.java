package main.java.com.exemplo.BancoDigital.service;

public class ServicoConta {



    public void transferir(double valorTranferencia, Conta contaOrigem, Conta contaDestino, int senha) {

        if(contaOrigem.senha() == senha) {
            contaOrigem.sacar(valorTranferencia);
            contaDestino.depositar(valorTranferencia);
            System.out.println("Transação concluida! Novo saldo: " + contaDestino.getSaldo());
        }else {
            System.out.println("Senha incorreta!");
        }
    }
}
