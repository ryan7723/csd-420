//Ryan Barber 6/21/16 Assignment 4.2

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraversalTest {

    public static void main(String[] args) {

        testLinkedList(50000);
        testLinkedList(500000);
    }

    public static void testLinkedList(int numberOfIntegers) {

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < numberOfIntegers; i++) {
            list.add(i);
        }

        System.out.println("Testing LinkedList with " + numberOfIntegers + " integers");
        System.out.println("Size: " + list.size());
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        long iteratorStartTime = System.nanoTime();

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            iterator.next();
        }

        long iteratorEndTime = System.nanoTime();
        long iteratorTime = iteratorEndTime - iteratorStartTime;

        long getStartTime = System.nanoTime();

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        long getEndTime = System.nanoTime();
        long getTime = getEndTime - getStartTime;

        System.out.println("Iterator traversal time; " + iteratorTime + " nanoseconds");
        System.out.println("get(index) traversal time: " + getTime + " nanoseconds");
        System.out.println("Difference: " + (getTime - iteratorTime) + " nanoseconds");
        System.out.println("-----------------------------------------");
    }
}