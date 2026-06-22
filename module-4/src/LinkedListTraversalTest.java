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

// When I ran the program, the list containing 50,000 integers, the iterator traversal completed in around 7.38 million nanoseconds.
// The get(index) traversal required around 861 million nanoseconds.
// Which means that the get(index) approach took 854 million nanoseconds longer to finish.
// Running the 500,000 integer list, the Iterator traversal completed in around 6.90 million nanoseconds.
// The get(index) traversal completed in 241.9 billion nanoseconds.
// Making the difference around 241.9 billion nanoseconds.
// This shows there was a dramatic increase in execution time.
// The LinkedList stored the data in nodes that are connected together.
// The Iterator has the program move from one node to the next, resulting in O(n) time complexity for traversing the entire list.
// But, when using get(index), the LinkedList must start at the beginning or end of the list and move through nodes to find the requested index.
// This process repeats for every element results in O(n2) time complexity.
// These results show that Iterator traversal is more efficient for LinkedLists, especially as the size of the list increases.
// Both methods did work correctly, but the performance gap is noticeable with larger datasets.