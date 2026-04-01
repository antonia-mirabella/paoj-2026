package com.pao.laboratory03.exercise3.service;

import com.pao.laboratory03.exercise3.model.Angajat;
import java.util.ArrayList;
import java.util.List;

/**
 * Completează cele 3 metode.
 * Folosește ArrayList — nu mai e nevoie de redimensionare manuală.
 */
public class AngajatService {
    private List<Angajat> angajati;

    public AngajatService() {
        this.angajati = new ArrayList<>();
    }

    /** angajati.add(a); println("Angajat adăugat: " + a.getName()); */
    public void addAngajat(Angajat a) {
        angajati.add(a);
        System.out.println("Angajat adăugat: " + a.getName());
    }

    /** dacă goală → mesaj; altfel parcurge cu index și afișează (i+1) + ". " + angajat */
    public void listAll() {
        if (angajati.isEmpty())
        {  
            System.out.println("Nu exista angajati in sistem.");
            return;
        }
        for (int i = 0 ; i < angajati.size(); i++)
        {
            System.out.println((i+1) + ". " + angajati.get(i));
        }
    }

    /**  parcurge lista, sumează a.salariuTotal(), returnează totalul. */
    public double totalSalarii() {
        int sum = 0;
        for (Angajat angajat : angajati)
            sum += angajat.salariuTotal();
        return sum;
    }
}
