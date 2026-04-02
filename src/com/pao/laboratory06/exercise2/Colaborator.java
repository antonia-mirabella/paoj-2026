package com.pao.laboratory06.exercise2;

public abstract class Colaborator implements IOperatiiCitireScriere {
    protected String nume;
    protected String prenume;
    protected double venitBrutLunar;

    public abstract double calculeazaVenitNetAnual();
    public abstract TipColaborator getTip();

    @Override
    public String toString() {
        return String.format("%s: %s %s, venit net anual: %.2f lei",tipContract(), nume, prenume, calculeazaVenitNetAnual());
    }

    @Override
    public void afiseaza() {
        System.out.println(this);
    }
}
