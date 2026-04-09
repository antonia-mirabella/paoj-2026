package com.pao.laboratory07.exercise2;

public final class ComandaAbonament extends Comanda implements ActiuneComanda {
    private int nrLuni;

    public ComandaAbonament(String id, String client, double valoare, int nrLuni) {
        super(id, client, valoare);
        this.nrLuni = nrLuni;
    }

    public int getNrLuni() { return nrLuni; }

    @Override
    public String toString() {
        return String.format("ABONAMENT: %s %s, valoare: %.2f lei, luni: %d", id, client, valoare, nrLuni);
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
        return "ABONAMENT";
    }

    @Override
    public boolean esteSpeciala() {
        return true;
    }
}
