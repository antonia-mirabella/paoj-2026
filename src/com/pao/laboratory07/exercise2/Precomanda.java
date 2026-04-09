package com.pao.laboratory07.exercise2;

public final class Precomanda extends Comanda implements ActiuneComanda {
    private String dataLivrare;

    public Precomanda(String id, String client, double valoare, String dataLivrare) {
        super(id, client, valoare);
        this.dataLivrare = dataLivrare;
    }

    public String getDataLivrare() { return dataLivrare; }

    @Override
    public String toString() {
        return String.format("PRECOMANDA: %s %s, valoare: %.2f lei, livrare: %s", id, client, valoare, dataLivrare);
    }

    @Override
    public void procesare() {
        afiseaza();
    }

    @Override
    public void proceseaza() {
        procesare();
    }

    @Override
    public void afiseaza() {
        System.out.println(this);
    }

    @Override
    public String tipComanda() {
        return "PRECOMANDA";
    }

    @Override
    public boolean esteSpeciala() {
        return true;
    }
}
