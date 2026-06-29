//Ryan Barber 6/27/26 Assignment 5.2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class DisplayWords {

    public static void main(String[] args) {

        TreeSet<String> words = new TreeSet<>();

        try {
            File file = new File("collection_of_words.txt");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                words.add(input.next().toLowerCase());
            }

            input.close();

            System.out.println("Words in Ascending Order:");
            for (String word : words) {
                System.out.println(word);
            }

            System.out.println("\nWords in Descending Order:");
            for (String word : words.descendingSet()) {
                System.out.println(word);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: collection_of_words.txt was not found.");
        }
    }
}