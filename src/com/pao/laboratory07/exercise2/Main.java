package com.pao.laboratory07.exercise2;

// Placeholder for Main.java. Implement according to the Readme and test cases.

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Vezi Readme.md pentru cerințe
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Comanda> comenzi = new ArrayList<>();
        LinkedHashMap<String, double[]> statistici = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split(" ");
            String tip = parts[0];
            String id = parts[1];
            String client = parts[2];
            double valoare = Double.parseDouble(parts[3]);

            Comanda comanda;
            if (tip.equals("STANDARD")) {
                comanda = new ComandaStandard(id, client, valoare);
            } else if (tip.equals("PRECOMANDA")) {
                comanda = new Precomanda(id, client, valoare, parts[4]);
            } else {
                comanda = new ComandaAbonament(id, client, valoare, Integer.parseInt(parts[4]));
            }
            comenzi.add(comanda);
            statistici.putIfAbsent(tip, new double[]{0.0, 0});
            statistici.get(tip)[0] += valoare;
            statistici.get(tip)[1]++;
        }

        comenzi.sort((a, b) -> {
            if (a instanceof ComandaAbonament && b instanceof ComandaAbonament) {
                return Integer.compare(((ComandaAbonament) b).getNrLuni(), ((ComandaAbonament) a).getNrLuni());
            }
            return Double.compare(b.getValoare(), a.getValoare());
        });

        for (Comanda c : comenzi) {
            c.procesare();
        }

        System.out.println();
        System.out.println("Comanda cu valoarea maximă: " + comenzi.get(0));
        System.out.println();
        System.out.println("Sume și număr comenzi pe tip:");
        for (String tip : statistici.keySet()) {
            double[] vals = statistici.get(tip);
            System.out.printf("%s: suma = %.2f lei, număr = %d%n", tip, vals[0], (int) vals[1]);
        }
    }
}

