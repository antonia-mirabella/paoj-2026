package com.pao.laboratory06.exercise2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Colaborator> colaboratori = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String tip = scanner.next();
            Colaborator c = switch (tip) {
                case "CIM" -> new CIMColaborator();
                case "PFA" -> new PFAColaborator();
                case "SRL" -> new SRLColaborator();
                default -> throw new IllegalArgumentException("Tip necunoscut: " + tip);
            };
            c.citeste(scanner);
            colaboratori.add(c);
        }
        colaboratori.sort(Comparator.comparingDouble(Colaborator::calculeazaVenitNetAnual).reversed());
        for (Colaborator c : colaboratori) {
            c.afiseaza();
        }
        System.out.println();
        System.out.print("Colaborator cu venit net maxim: ");
        colaboratori.get(0).afiseaza();
        System.out.println();
        System.out.println("Colaboratori persoane juridice:");
        for (Colaborator c : colaboratori) {
            if (c instanceof PersoanaJuridica) {
                c.afiseaza();
            }
        }
        System.out.println();
        System.out.println("Sume si numar colaboratori pe tip:");
        for (TipColaborator tip : TipColaborator.values()) {
            double suma = 0;
            int numar = 0;
            for (Colaborator c : colaboratori) {
                if (c.getTip() == tip) {
                    suma += c.calculeazaVenitNetAnual();
                    numar++;
                }
            }
            if (numar > 0) {
                System.out.printf("%s: suma = %.2f lei, numar = %d%n", tip, suma, numar);
            }
        }
    }
}
