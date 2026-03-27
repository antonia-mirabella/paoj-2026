package com.pao.laboratory05.angajati;

import java.util.Scanner;

/**
 * Exercise 3 — Angajați
 *
 * Cerințele complete se află în:
 *   src/com/pao/laboratory05/Readme.md  →  secțiunea "Exercise 3 — Angajați"
 *
 * Creează fișierele de la zero în acest pachet, apoi rulează Main.java
 * pentru a verifica output-ul așteptat din Readme.
 */
public class Main {
    public static void main(String[] args) {
        AngajatService service = AngajatService.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Gestionare Angajati =====");
            System.out.println("1. Adauga angajat");
            System.out.println("2. Listare dupa salariu");
            System.out.println("3. Cauta dupa departament");
            System.out.println("0. Iesire");
            System.out.print("Optiune: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Nume: ");
                    String nume = scanner.next();
                    System.out.print("Departament (nume): ");
                    String numeDept = scanner.next();
                    System.out.print("Departament (locatie): ");
                    String locatie = scanner.next();
                    System.out.print("Salariu: ");
                    double salariu = scanner.nextDouble();
                    service.addAngajat(new Angajat(nume, new Departament(numeDept, locatie), salariu));
                    break;
                case 2:
                    System.out.println("--- Angajati dupa salariu (descrescator) ---");
                    service.listBySalary();
                    break;
                case 3:
                    System.out.print("Departament: ");
                    String dept = scanner.next();
                    System.out.println("--- Angajati din " + dept + " ---");
                    service.findByDepartament(dept);
                    break;
                case 0:
                    System.out.println("La revedere!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida. Incearca din nou.");
            }
        }
    }
}
