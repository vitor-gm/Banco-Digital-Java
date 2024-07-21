package br.com.java.poo.BancoDigital.model;

public class Endereco {

    private String cidade;

    private String cep;
    private int numero;

    public Endereco(String cidade, String cep, int numero) {
        this.cidade = cidade;

        this.cep = cep;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cidade='" + cidade + '\'' +
                 '\'' +
                ", cep='" + cep + '\'' +
                ", numero=" + numero +
                '}';
    }


}
