package com.pao.laboratory03.collections;

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

        // === PARTEA A: HashMap — frecvența cuvintelor ===
        System.out.println("=== PARTEA A: HashMap — frecvența cuvintelor ===");
        String[] words = {"java", "python", "java", "c++", "python", "java", "rust", "c++", "go"};

        java.util.Map<String, Integer> freq = new java.util.HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        System.out.println("Frecvență: " + freq);
        System.out.println("Conține 'rust'? " + freq.containsKey("rust"));
        System.out.println("Chei: " + freq.keySet());
        System.out.println("Valori: " + freq.values());
        for (java.util.Map.Entry<String, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // === PARTEA B: TreeMap — sortare automată ===
        System.out.println("\n=== PARTEA B: TreeMap — sortare automată ===");
        java.util.TreeMap<String, Integer> sorted = new java.util.TreeMap<>(freq);
        System.out.println("Sortat: " + sorted);
        System.out.println("Prima cheie: " + sorted.firstKey());
        System.out.println("Ultima cheie: " + sorted.lastKey());

        // === PARTEA C: Map cu obiecte ===
        System.out.println("\n=== PARTEA C: Map cu obiecte ===");
        java.util.Map<String, java.util.List<String>> courses = new java.util.HashMap<>();
        courses.put("PAOJ", new java.util.ArrayList<>(java.util.Arrays.asList("Ana", "Mihai", "Ion")));
        courses.put("BD", new java.util.ArrayList<>(java.util.Arrays.asList("Ana", "Elena")));

        System.out.println("Studenți la PAOJ: " + courses.get("PAOJ"));
        courses.get("BD").add("George");
        System.out.println("Studenți la BD (actualizat): " + courses.get("BD"));
    }
}

