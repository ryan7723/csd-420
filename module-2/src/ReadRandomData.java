// Ryan Barber 6/14/26 Assignment 2.2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadRandomData {

    public static void main(String[] args) {

        String fileName = "barberdatafile.dat";

        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);

            System.out.println("Contents of " + fileName + ":");
            System.out.println();

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());

            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}