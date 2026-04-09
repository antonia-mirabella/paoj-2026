package com.pao.laboratory07.exercise3;

// Vezi Readme.md pentru cerințe

import com.pao.laboratory07.exercise2.ActiuneComanda;
import com.pao.laboratory07.exercise2.Comanda;
import com.pao.laboratory07.exercise2.ComandaAbonament;
import com.pao.laboratory07.exercise2.ComandaStandard;
import com.pao.laboratory07.exercise2.Precomanda;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Comanda> comenzi = new ArrayList<>();
        comenzi.add(new ComandaStandard("1001", "Popescu", 250.0));
        comenzi.add(new Precomanda("1002", "Ionescu", 400.0, "2026-05-10"));
        comenzi.add(new ComandaAbonament("1003", "Georgescu", 120.0, 6));
        comenzi.add(new ComandaStandard("1004", "Enache", 300.0));
        comenzi.add(new Precomanda("1005", "Andrei", 150.0, "2025-01-01"));
        comenzi.add(new ComandaAbonament("1006", "Pop", 90.0, 12));
        comenzi.add(new ComandaStandard("1007", "Vasile", 500.0));

        System.out.println("=== 1. Media valorilor pe tip ===");
        Map<String, List<Comanda>> peType = comenzi.stream()
                .collect(Collectors.groupingBy(c -> ((ActiuneComanda) c).tipComanda()));
        for (Map.Entry<String, List<Comanda>> entry : peType.entrySet()) {
            double medie = entry.getValue().stream()
                    .mapToDouble(Comanda::getValoare).average().orElse(0);
            System.out.printf("Tip: %s | medie = %.2f lei | comenzi: %d%n",
                    entry.getKey(), medie, entry.getValue().size());
        }

        System.out.println();
        System.out.println("=== 2. Comenzi peste media generala ===");
        double medieGenerala = comenzi.stream().mapToDouble(Comanda::getValoare).average().orElse(0);
        System.out.printf("Media generala: %.2f lei%n", medieGenerala);
        comenzi.stream()
                .filter(c -> c.getValoare() > medieGenerala)
                .forEach(c -> System.out.println("  " + c));

        System.out.println();
        System.out.println("=== 3. Comenzi si statut special ===");
        for (Comanda c : comenzi) {
            ActiuneComanda ac = (ActiuneComanda) c;
            System.out.printf("  %s | speciala: %b%n", c, ac.esteSpeciala());
        }

        System.out.println();
        double prag = 200.0;
        System.out.println("=== 4. Comenzi cu valoarea >= " + prag + " lei ===");
        comenzi.stream()
                .filter(c -> c.getValoare() >= prag)
                .forEach(c -> System.out.println("  " + c));

        System.out.println();
        System.out.println("=== 5. Sortare dupa client, apoi dupa valoare desc ===");
        comenzi.stream()
                .sorted(Comparator.comparing(Comanda::getClient)
                        .thenComparing(Comparator.comparingDouble(Comanda::getValoare).reversed()))
                .forEach(c -> System.out.println("  " + c));

        System.out.println();
        System.out.println("=== 6. Workflow: precomenzI cu data livrare depasita ===");
        LocalDate azi = LocalDate.now();
        comenzi.stream()
                .filter(c -> c instanceof Precomanda)
                .map(c -> (Precomanda) c)
                .filter(p -> LocalDate.parse(p.getDataLivrare()).isBefore(azi))
                .forEach(p -> System.out.println("  NOTIFICARE: livrare depasita pentru " + p));

        System.out.println();
        System.out.println("=== 7. Tratarea cazurilor limita ===");
        try {
            Double.parseDouble("abc");
        } catch (NumberFormatException e) {
            System.out.println("  Eroare: valoare invalida — " + e.getMessage());
        }

        String[] inputNecunoscut = {"ALTFEL", "9999", "Test", "100.0"};
        String tipNecunoscut = inputNecunoscut[0];
        if (!tipNecunoscut.equals("STANDARD") && !tipNecunoscut.equals("PRECOMANDA") && !tipNecunoscut.equals("ABONAMENT")) {
            System.out.println("  Eroare: tip comanda necunoscut — " + tipNecunoscut);
        }

        List<Comanda> listaGoala = new ArrayList<>();
        OptionalDouble medieLista = listaGoala.stream().mapToDouble(Comanda::getValoare).average();
        System.out.println("  Media listei goale: " + (medieLista.isPresent() ? medieLista.getAsDouble() : "N/A (lista goala)"));
    }
}
