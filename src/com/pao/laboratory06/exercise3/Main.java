package com.pao.laboratory06.exercise3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Inginer[] ingineri = {
            new Inginer("Popescu", "Ion", "0701234567", 8000, 50000),
            new Inginer("Alexandrescu", "Maria", "0709876543", 12000, 80000),
            new Inginer("Barbu", "Andrei", null, 10000, 60000)
        };

        // sortare dupa nume
        Arrays.sort(ingineri);
        System.out.println("Sortare naturala (dupa nume):");
        for (Inginer i : ingineri) System.out.println("  " + i);

        // sortare salariu desc
        Arrays.sort(ingineri, new ComparatorInginerSalariu());
        System.out.println("Sortare dupa salariu descrescator:");
        for (Inginer i : ingineri) System.out.println("  " + i);

        // acces prin PlataOnline 
        PlataOnline po = ingineri[0];
        po.autentificare("user1", "pass1");
        System.out.println("Sold prin PlataOnline: " + po.consultareSold());
        System.out.println("Plata 1000: " + po.efectuarePlata(1000));

        // pers juridica prin Plata Online
        PersoanaJuridica pj1 = new PersoanaJuridica("Meow", "SRL", "0712345678", 100000);
        PersoanaJuridica pj2 = new PersoanaJuridica("Woof", "SRL", null, 50000);

        PlataOnlineSMS sms1 = pj1;
        System.out.println("trimite SMS Meow: " + sms1.trimiteSMS("Confirmare plata"));
        System.out.println("SMS mesaj gol: " + sms1.trimiteSMS(""));
        System.out.println("SMS fara telefon: " + ((PlataOnlineSMS) pj2).trimiteSMS("Test"));
        System.out.println("get SMS Meow: " + pj1.getSmsTrimise());

        // constante financiare din enum
        System.out.println("TVA: " + ConstanteFinanciare.TVA.getValoare());
        System.out.println("Salariu minim: " + ConstanteFinanciare.SALARIU_MINIM.getValoare());

        // edge case ul atunci cand incerci sa te autenfitific cu user null se arunca IllegalArgumentException
        try {
            po.autentificare(null, "pass");
        } catch (IllegalArgumentException e) {
            System.out.println("Eroare autentificare: " + e.getMessage());
        }
    }
}
