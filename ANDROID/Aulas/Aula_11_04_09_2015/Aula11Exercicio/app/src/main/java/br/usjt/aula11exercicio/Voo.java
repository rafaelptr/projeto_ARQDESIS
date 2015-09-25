package br.usjt.aula11exercicio;


import java.util.Date;

public class Voo implements Comparable<Voo>{
    private String origem;
    private String destino;
    private String data;

    public static final String NAO_ENCONTRADA = "Não encontrado.";

    public Voo(String origem, String destino,String data  ) {
        this.origem = origem;
        this.destino = destino;
        this.data = data;
    }
    public String  getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getOrigem() {
        return origem;
    }
    public String getDestino() {
        return destino;
    }


    @Override
    public String toString() {
        return "br.usjt.aula11exercicio{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", data='" + data.toString() + '\'' +
                '}';
    }
    public String toStringLinha(){
        return  ""+origem+" : "+destino+" ["+data+"]"  ;
    }

    @Override
    public int compareTo(Voo voo) {
        if (origem.equals(voo.getOrigem())
                && destino.equals(voo.getDestino())
                  && data.equals(voo.getData()))
                {
            return 0;
        }
        return 1;
    }
}
