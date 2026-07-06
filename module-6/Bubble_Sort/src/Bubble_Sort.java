// Ryan Barber 7/5/26 Assignment 6.2

import java.util.Comparator;

public class Bubble_Sort {

    public static void main(String[] args) {

        Integer[] numbers = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        String[] names = {"Ryan", "Paul", "Christa", "Sam", "Tom"};

        System.out.println("Comparable Bubble Sort Test");
        System.out.println("Before sorting:");
        printArray(numbers);

        bubbleSort(numbers);

        System.out.println("After sorting");
        printArray(numbers);

        System.out.println("\nComparator bubble Sort Test");
        System.out.println("Before sorting:");
        printArray(names);

        bubbleSort(names, Comparator.reverseOrder());

        System.out.println("After sorting in reverse order:");
        printArray(names);
    }

    // Comparable interface being used for Bubble sort
    // This method sorts objects based on their natural ordering
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {

        boolean swapped;

        do {
            swapped = false;

            for (int j = 0; j < list.length - 1; j++) {

                if (list[j].compareTo(list[j + 1]) > 0) {

                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    swapped = true;
                }
            }

        } while (swapped);
    }

    // Comparator interface being used for Bubble Sort
    // This method sorts objects using a comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {

        boolean swapped;

        do {
            swapped = false;

            for (int j = 0; j < list.length - 1; j++) {

                if (comparator.compare(list[j], list[j + 1]) > 0) {

                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Prints the contents of any generic array
    public static <E> void printArray(E[] arrayParam){

        System.out.print("\nArray={");

        for (E e : arrayParam){
            System.out.print("["+e+"]");
        }

        System.out.println("};\n");
    }
}