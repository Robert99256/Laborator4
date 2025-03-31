import java.io.*;
import java.util.*;
public class Main {

    public static class Persoana{
        private String nume;

        public Persoana(String nume){
            this.nume = nume;
        }

        public String getNume(){
            return nume;
        }

        @Override
        public String toString(){
            return nume;
        }
    }
    public static void main(String[] args) {
        String file = "src/persoane.txt";
        List<Persoana> listaPersoane = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                String nume = sc.nextLine().trim();
                listaPersoane.add(new Persoana(nume));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit");
            return;
        }
        Map<String, Integer> numarAparitii = new HashMap<>();
        for (Persoana p : listaPersoane) {
            String nume = p.getNume();
            numarAparitii.put(nume, numarAparitii.getOrDefault(nume, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : numarAparitii.entrySet()) {
            if (entry.getValue() >= 3) {
                System.out.println(entry.getKey());
            }
        }
    }
}