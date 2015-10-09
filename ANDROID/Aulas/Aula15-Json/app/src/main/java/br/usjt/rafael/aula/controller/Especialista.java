package br.usjt.rafael.aula.controller;


import java.util.ArrayList;
import java.util.TreeSet;

import br.usjt.rafael.aula.model.Voo;

public class Especialista {
    private static final ArrayList<Voo> voos = cadastroDeVoos();

    public Especialista() {

    }


    public TreeSet<Voo> listarMarcas(String origem, String destino,String data) {
        TreeSet<Voo> marcas = new TreeSet<Voo>();
        if (origem.length() > 0 && destino.length() > 0 && data.length() > 0) {
            marcas = buscarAmbos(origem, destino,data);
        } else if (origem.length() > 0 && destino.length() > 0 ) {
            marcas = buscarOrigemDestino(origem, destino);
        } else if (origem.length() > 0 && data.length() > 0) {
            marcas = buscarOrigemData(origem, data);
        } else if (destino.length() > 0 && data.length() > 0) {
            marcas = buscarDestinoData(destino, data);
        } else if (origem.length() > 0) {
            marcas = buscarOrigem(origem);
        } else if (destino.length() > 0) {
            marcas = buscarDestino(destino);
        } else if (data.length() > 0) {
            marcas = buscarData(data);
        } else {
            marcas = todos();
        }

        return marcas;
    }

    private TreeSet<Voo> buscarAmbos(String origem,String destino,String data){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if(voo.getOrigem().equals(origem)
                    && voo.getDestino().equals(destino)
                    && voo.getData().equals(data)
                    )lista.add(voo);
        }
        return lista;
    }
    private TreeSet<Voo> buscarOrigemDestino(String origem,String destino){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if(voo.getOrigem().equals(origem)
                    && voo.getDestino().equals(destino)
                    )lista.add(voo);
        }
        return lista;
    }
    private TreeSet<Voo> buscarDestinoData(String destino,String data){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if(voo.getDestino().equals(destino)
                    && voo.getData().equals(data)
                    )lista.add(voo);
        }
        return lista;
    }

    private TreeSet<Voo> buscarOrigemData(String origem,String data){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if(voo.getOrigem().equals(origem)
                    && voo.getData().equals(data)
                    )lista.add(voo);
        }
        return lista;
    }
    private TreeSet<Voo> buscarOrigem(String origem){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if(voo.getOrigem().equals(origem))lista.add(voo);
        }
        return lista;
    }

    private TreeSet<Voo> buscarDestino(String destino){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if(voo.getDestino().equals(destino))lista.add(voo);
        }
        return lista;
    }
    private TreeSet<Voo> buscarData(String data){
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if(voo.getData().equals(data))lista.add(voo);
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
        voos.add(new Voo("Gol Voo345 Congonhas Rango","Congonhas","Guarulhos","13/05/2016","marca1",1200.99));
        voos.add(new Voo("Tam Novo Voo123 Congonhas Rango","Congonhas","Guarulhos","13/05/2016","marca2",1600.99));
        voos.add(new Voo("Air Voo676 Congonhas Rango","Congonhas","Guarulhos","16/05/2016","marca3",1100.99));
        voos.add(new Voo("Boom Voo333 Congonhas","Congonhas","Guarulhos","18/05/2016","marca4",900.99));
        voos.add(new Voo("Cabo Voo777 t guar","Guarulhos","Congonhas","18/05/2016","marca1",800.99));
        voos.add(new Voo("DeVoo999 t congonhas","Guarulhos","Congonhas","18/05/2016","marca2",900.99));
        voos.add(new Voo("Eface Voo187 guar-congunheta ","Guarulhos","Congonhas","18/05/2016","marca3",910.99));
        voos.add(new Voo("Portation Voo913 porto ","Porto Alegre","Guarulhos","17/05/2016","marca2",900.99));
        voos.add(new Voo("Guarlu Voo7585 guarulhetos","Guarulhos","Porto Alegre","19/05/2016","marca3",910.99));
        voos.add(new Voo("Tam Congonhas","Congonhas","Campinas","14/05/2016","marca2",900.99));
        voos.add(new Voo("Airline Campinas","Campinas","Congonhas","15/05/2016","marca3",910.99));

        voos.add(new Voo("Gol Campinas","Congonhas","Campinas","14/05/2016","marca1",900.99));
        voos.add(new Voo("Gol Congonhas","Campinas","Congonhas","15/05/2016","marca1",910.99));

        voos.add(new Voo("Tam Campinas","Congonhas","Campinas","20/05/2016","marca2",900.99));
        voos.add(new Voo("Tamp Congonhas","Campinas","Congonhas","21/05/2016","marca2",910.99));

        voos.add(new Voo("Airline Campinas","Congonhas","Campinas","22/05/2016","marca3",900.99));
        voos.add(new Voo("Airline Congonhas","Campinas","Congonhas","23/05/2016","marca3",910.99));
        return voos;
    }
}
