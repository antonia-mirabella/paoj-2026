package com.pao.laboratory07.exercise1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Vezi Readme.md pentru cerințe
        Scanner scanner = new Scanner(System.in);
        StareComanda stare = StareComanda.valueOf(scanner.nextLine().trim());
        Deque<StareComanda> istoric = new ArrayDeque<>();
        boolean ultimaIntrareInFinala = false;
        System.out.println(stare);
        while (scanner.hasNextLine()) {
            String comanda = scanner.nextLine().trim();
            if (comanda.equals("QUIT")) {
                if (stare.esteFinala() && ultimaIntrareInFinala) {
                    System.out.println("Comanda este in stare finala.");
                }
                break;
            }
            if (comanda.equals("undo")) {
                ultimaIntrareInFinala = false;
                if (!istoric.isEmpty()) {
                    stare = istoric.pop();
                }
                System.out.println(stare);
            } else if (stare.esteFinala()) {
                ultimaIntrareInFinala = false;
                System.out.println("Comanda este in stare finala.");
            } else {
                StareComanda noua = comanda.equals("next") ? stare.next() : StareComanda.ANULATA;
                istoric.push(stare);
                stare = noua;
                System.out.println(stare);
                ultimaIntrareInFinala = stare.esteFinala();
            }
        }
    }
}
