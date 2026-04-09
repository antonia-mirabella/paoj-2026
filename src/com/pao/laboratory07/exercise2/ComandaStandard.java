package com.pao.laboratory07.exercise2;

public final class ComandaStandard extends Comanda implements ActiuneComanda {

    public ComandaStandard(String id, String client, double valoare) {
        super(id, client, valoare);
    }

    @Override
    public String toString() {
        return String.format("STANDARD: %s %s, valoare: %.2f lei", id, client, valoare);
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
        return "STANDARD";
    }
}
