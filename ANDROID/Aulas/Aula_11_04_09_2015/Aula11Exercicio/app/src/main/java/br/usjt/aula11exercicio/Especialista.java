package br.usjt.aula11exercicio;


import java.util.ArrayList;
import java.util.TreeSet;

public class Especialista {
    private static final ArrayList<Voo> voos = cadastroDeVoos();

    public Especialista() {

    }

    public TreeSet<Voo> listarVoos(String origem, String destino,String data) {
        TreeSet<Voo> voos = new TreeSet<Voo>();

        if (origem.length() > 0 && destino.length() > 0  && data.length() > 0) {
            voos = buscarOrigemDestinoData(origem, destino,data);
        } else if (origem.length() > 0 & destino.length() > 0) {
            voos = buscarOrigemDestino(origem,destino);
        } else if (destino.length() > 0 && data.length() > 0) {
            voos = buscarDestinoData(destino,data);
        }
        else if (origem.length() > 0 && data.length() > 0) {
            voos = buscarOrigemData(destino,data);
        }
        else if (data.length() > 0) {
            voos = buscarData(data);
        }
        else if (origem.length() > 0) {
            voos = buscarOrigem(origem);
        }
        else if (destino.length() > 0) {
            voos = buscarDestino(destino);
        }
        else {
            voos = todos();
        }
        return voos;
    }
    private TreeSet<Voo> buscarOrigemDestinoData(String origem, String destino,String data) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (origem.equals(voo.getOrigem())
                    && destino.equals(voo.getDestino())
                    && data.equals(voo.getData())) {
                lista.add(voo);
            }
        }
        return lista;
    }
    private TreeSet<Voo> buscarOrigemDestino(String origem, String destino) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (origem.equals(voo.getOrigem())
                    && destino.equals(voo.getDestino())
                    ) {
                lista.add(voo);
            }
        }
        return lista;
    }
    private TreeSet<Voo> buscarOrigemData(String origem,String data) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (origem.equals(voo.getOrigem()) && data.equals(voo.getData())) {
                lista.add(voo);
            }
        }
        return lista;
    }
    private TreeSet<Voo> buscarDestinoData(String destino,String data) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (destino.equals(voo.getDestino()) && data.equals(voo.getData())) {
                lista.add(voo);
            }
        }
        return lista;
    }
    private TreeSet<Voo> buscarOrigem(String origem) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (origem.equals(voo.getOrigem())) {
                lista.add(voo);
            }
        }
        return lista;
    }
    private TreeSet<Voo> buscarDestino(String destino) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (destino.equals(voo.getDestino())) {
                lista.add(voo);
            }
        }
        return lista;
    }
    private TreeSet<Voo> buscarData(String data) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (data.equals(voo.getData())) {
                lista.add(voo);
            }
        }
        return lista;
    }


    private TreeSet<Voo> todos() {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            lista.add(voo);
        }
        return lista;
    }

    private static ArrayList<Voo> cadastroDeVoos() {
        ArrayList<Voo> voos = new ArrayList<Voo>();
        voos.add(new Voo("Congonhas", "Guarulhos","13/02/2016"));
        voos.add(new Voo("Congonhas", "Guarulhos","14/02/2016"));
        voos.add(new Voo("Congonhas", "Guarulhos","15/02/2016"));
        voos.add(new Voo("Congonhas", "Guarulhos","16/02/2016"));

        voos.add(new Voo("Guarulhos", "Congonhas","14/02/2016"));
        voos.add(new Voo("Guarulhos", "Congonhas","15/02/2016"));
        return voos;
    }
}