package com.pao.laboratory06.exercise2;

import java.util.Scanner;

public class PFAColaborator extends PersoanaFizica {
    private double cheltuieliLunare;
    private static final double SAL_MIN_LUNAR = 4050.0;

    @Override
    public void citeste(Scanner in) {
        this.nume = in.next();
        this.prenume = in.next();
        this.venitBrutLunar = in.nextDouble();
        this.cheltuieliLunare = in.nextDouble();
    }

    @Override
    public double calculeazaVenitNetAnual() {
        double vn = (venitBrutLunar - cheltuieliLunare) * 12;
        double impozit = vn * 0.10;
        double cass = calculeazaCASS(vn);
        double cas = calculeazaCAS(vn);
        return vn - impozit - cass - cas;
    }

    // diff fata de readme
    private double calculeazaCASS(double vn) {
        double x = 6 * SAL_MIN_LUNAR;
        double y = 72 * SAL_MIN_LUNAR;
        if (vn < x) return 0.10 * x;
        if (vn <= y) return 0.10 * vn;
        return 0.10 * y;
    }
// diff fata de readme
    private double calculeazaCAS(double vn) {
        double x = 12 * SAL_MIN_LUNAR;
        double y = 24 * SAL_MIN_LUNAR;
        if (vn < x) return 0;
        if (vn <= y) return 0.25 * x;
        return 0.25 * y;
    }

    @Override
    public TipColaborator getTip() {
        return TipColaborator.PFA;
    }

    @Override
    public String tipContract() {
        return "PFA";
    }
}
