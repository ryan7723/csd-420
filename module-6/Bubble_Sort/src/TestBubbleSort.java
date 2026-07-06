// Ryan Barber 7/5/26 Assignment 6.2

import java.util.Comparator;

public class TestBubbleSort {
    public static void main(String[] args) {

        // Test 1 - Comparable Bubble Sort with integers
        Integer[] numbers = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        System.out.println("========== Comparable Bubble Sort Test ==========");
        System.out.println("Before Sorting:");
        Bubble_Sort.printArray(numbers);

        Bubble_Sort.bubbleSort(numbers);

        System.out.println("After Sorting");
        Bubble_Sort.printArray(numbers);

        // Test 2 - Comparator Bubble Sort with Strings
        String[] names = {"Ryan", "Paul", "Christa", "Sam", "Tom"};

        System.out.println("\n========== Comparator Bubble Sort Test ==========");
        System.out.println("Before Sorting:");
        Bubble_Sort.printArray(names);

        Bubble_Sort.bubbleSort(names, Comparator.reverseOrder());

        System.out.println("After Reverse Sorting");
        Bubble_Sort.printArray(names);
    }
}
