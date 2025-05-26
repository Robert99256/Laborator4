
import java.io.*;
import java.util.*;

public class Main {
    public static class Persoana {
        private String nume;


        public Persoana(String nume) {
            this.nume = nume;
        }

        public String getNume() {
            return nume;
        }

        @Override
        public String toString() {
            return nume;
        }
    }

    public static void main(String[] args) {
        String file = "src/persoane.txt";

        List<Persoana> listaPersoane = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                String nume = sc.nextLine().trim(); // elimină spațiile din jur
                listaPersoane.add(new Persoana(nume)); // adaugă în listă
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit");
            return;
        }

        // Creează un map pentru a ține evidența de câte ori apare fiecare nume
        Map<String, Integer> numarAparitii = new HashMap<>();

        for (Persoana p : listaPersoane) {
            String nume = p.getNume();
            // Dacă numele există deja, îl incrementează cu 1; dacă nu, îl pune cu valoarea 1
            numarAparitii.put(nume, numarAparitii.getOrDefault(nume, 0) + 1);
        }

        // Parcurge map-ul și afișează doar numele care apar de cel puțin 3 ori
        for (Map.Entry<String, Integer> entry : numarAparitii.entrySet()) {
            if (entry.getValue() >= 3) {
                System.out.println(entry.getKey());
            }
        }
    }
}
