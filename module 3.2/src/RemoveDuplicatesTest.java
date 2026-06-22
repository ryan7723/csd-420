//Ryan Barber Module 3.2 Assignment 7/21/26

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {

        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        for (int i =0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        System.out.println("Original List;");
        System.out.println(originalList);

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("\nList Without Duplicates:");
        System.out.println(uniqueList);

    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> newList = new ArrayList();

        for (E element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}
