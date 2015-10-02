package br.usjt.rafael.aula13;

import java.io.Serializable;

public class Voo implements Comparable<Voo>, Serializable{
    private String origem;
    private String imagem;
    private double preco;
    private String destino;
    private String data;

    public static final String NAO_ENCONTRADA = "Não encontrada.";

    public Voo(String origem, String destino, String data, String imagem, double preco) {
        this.origem = origem;
        this.imagem = imagem;
        this.preco = preco;
        this.destino = destino;
        this.data = data;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int compareTo(Voo voo) {
        if (voo.equals(this)){
            return 0;
        }
        return 1;
    }
}
