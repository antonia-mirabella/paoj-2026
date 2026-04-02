package com.pao.laboratory04.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Exercițiul 1 — Colecții: HashMap și TreeMap
 *
 * Creează în acest main:
 *
 * PARTEA A — HashMap (frecvența cuvintelor)
 * 1. Declară un array de String-uri:
 *    String[] words = {"java", "python", "java", "c++", "python", "java", "rust", "c++", "go"};
 * 2. Creează un HashMap<String, Integer> care contorizează de câte ori apare fiecare cuvânt.
 *    - Parcurge array-ul și folosește put() + getOrDefault() pentru a incrementa contorul.
 * 3. Afișează map-ul.
 * 4. Verifică dacă există cheia "rust" cu containsKey().
 * 5. Afișează DOAR cheile (keySet()), apoi DOAR valorile (values()).
 * 6. Parcurge map-ul cu entrySet() și afișează "cheia -> valoarea" pentru fiecare intrare.
 *
 * PARTEA B — TreeMap (sortare automată)
 * 7. Creează un TreeMap<String, Integer> din același HashMap (constructor cu argument).
 * 8. Afișează TreeMap-ul — observă ordinea alfabetică a cheilor.
 * 9. Folosește firstKey() și lastKey() pentru a afișa prima și ultima cheie.
 *
 * PARTEA C — Map cu obiecte
 * 10. Creează un HashMap<String, List<String>> care asociază materii cu liste de studenți.
 *     Exemplu: "PAOJ" -> ["Ana", "Mihai", "Ion"], "BD" -> ["Ana", "Elena"]
 * 11. Afișează toți studenții de la materia "PAOJ".
 * 12. Adaugă un student nou la "BD" și afișează lista actualizată.
 *
 * Output așteptat (orientativ — ordinea HashMap poate varia):
 *
 * === PARTEA A: HashMap — frecvența cuvintelor ===
 * Frecvență: {python=2, c++=2, java=3, rust=1, go=1}
 * Conține 'rust'? true
 * Chei: [python, c++, java, rust, go]
 * Valori: [2, 2, 3, 1, 1]
 * python -> 2
 * c++ -> 2
 * java -> 3
 * rust -> 1
 * go -> 1
 *
 * === PARTEA B: TreeMap — sortare automată ===
 * Sortat: {c++=2, go=1, java=3, python=2, rust=1}
 * Prima cheie: c++
 * Ultima cheie: rust
 *
 * === PARTEA C: Map cu obiecte ===
 * Studenți la PAOJ: [Ana, Mihai, Ion]
 * Studenți la BD (actualizat): [Ana, Elena, George]
 */
public class Main {
    public static void main(String[] args) {
        // TODO: implementează cele 3 părți de mai sus
        String[] words = {"java", "python", "java", "c++", "python", "java", "rust", "c++", "go"};
        HashMap<String, Integer> numWords = new HashMap<>();
        for (String word : words)
        {
            // if (numWords.containsKey(word))
            //     numWords.replace(word, numWords.get(word) + 1);
            // else
            //     numWords.put(word, 0); 
            numWords.put(word, (numWords.getOrDefault(word, 0) + 1));
        }

        System.out.println("Map complet: " + numWords);
        System.out.println("Exista rust ? " + numWords.containsKey("rust"));
        System.out.println("Chei: " + numWords.keySet());
        System.out.println("Valori: " + numWords.values());

        System.out.println("Parcurgere cu entryset: ");
        for (Map.Entry<String, Integer>entry : numWords.entrySet())
        {
            System.out.println("  " + entry.getKey() + " => " + entry.getValue());
        }

        TreeMap<String, Integer> sortedWords = new TreeMap<>(numWords);
        System.out.println("Sortat: " + sortedWords);
        System.out.println("Prima cheie: " + sortedWords.firstKey());
        System.out.println("Ultima cheie: " + sortedWords.lastKey());
    
        HashMap<String, List<String>> studentiMaterie = new HashMap<>();
        studentiMaterie.put("PAOJ", new ArrayList<>(Arrays.asList("Ana", "Mihai", "Ion")));
        studentiMaterie.put("BD", new ArrayList<>(Arrays.asList("Ana", "Elena")));

        System.out.println("Studenti la PAOJ: " + studentiMaterie.get("PAOJ"));
        studentiMaterie.get("BD").add("George");
        System.out.println("Studenti la BD (actualizat): " + studentiMaterie.get("BD"));
    
    }
}

