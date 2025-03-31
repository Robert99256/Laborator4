import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;



public class Main {
    public static void main(String[] args) {
        String file = "src/text.txt";
        Map<String, Integer> wordCount = new HashMap<>();
        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNext()) {
                String word = sc.next();
                word = word.toLowerCase();
                if (wordCount.containsKey(word)) {
                    wordCount.put(word, wordCount.get(word) + 1);
                } else {
                    wordCount.put(word, 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Nu s-a putut citi");
        }

        for (String word : wordCount.keySet()) {
            System.out.println(word + " " + wordCount.get(word));
        }
    }
}