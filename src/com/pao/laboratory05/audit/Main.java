package com.pao.laboratory05.audit;

import java.util.Scanner;

/**
 * Exercise 4 (Bonus) — Audit Log
 *
 * Cerințele complete se află în:
 *   src/com/pao/laboratory05/Readme.md  →  secțiunea "Exercise 4 (Bonus) — Audit"
 *
 * Extinde soluția de la Exercise 3 cu un sistem de audit bazat pe record.
 * Creează fișierele de la zero în acest pachet, apoi rulează Main.java
 * pentru a verifica output-ul așteptat din Readme.
 */
public class Main {
    public static void main(String[] args) {
        AngajatService service = AngajatService.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Gestionare Angajati (cu Audit) =====");
            System.out.println("1. Adauga angajat");
            System.out.println("2. Listare dupa salariu");
            System.out.println("3. Cauta dupa departament");
            System.out.println("4. Afiseaza audit log");
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
                case 4:
                    System.out.println("--- Audit Log ---");
                    service.printAuditLog();
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
