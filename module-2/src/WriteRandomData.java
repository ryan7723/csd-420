//Ryan Barber 6/14/26 Assignment 2.2

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;

public class WriteRandomData {

    public static void main(String[] args) {

        String fileName = "barberdatafile.dat";
        Random random = new Random();

        try (PrintWriter output = new PrintWriter(new FileWriter(fileName, true))) {

            output.println("Random Integers:");

            for (int i = 0; i < 5; i++) {
                int num = random.nextInt(100);
                output.print(num + " ");
            }

            output.println();
            output.println("Random Doubles:");

            for (int i = 0; i < 5; i++) {
                double num = random.nextDouble() * 100;
                output.printf("%.2f ", num);
            }

            output.println();
            output.println("----------------------");

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}