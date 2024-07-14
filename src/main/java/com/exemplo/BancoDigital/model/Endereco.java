package main.java.com.exemplo.BancoDigital.model;

public class Endereco {

    private String cidade;
    private String bairro;
    private String cep;
    private int numero;

    public Endereco(String cidade, String bairro, String cep, int numero) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", numero=" + numero +
                '}';
    }


}
