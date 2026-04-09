package com.pao.laboratory07.exercise2;

public abstract sealed class Comanda permits ComandaStandard, Precomanda, ComandaAbonament {
    protected String id;
    protected String client;
    protected double valoare;

    public Comanda(String id, String client, double valoare) {
        this.id = id;
        this.client = client;
        this.valoare = valoare;
    }

    public abstract void procesare();

    public String getId() { return id; }
    public String getClient() { return client; }
    public double getValoare() { return valoare; }
}
