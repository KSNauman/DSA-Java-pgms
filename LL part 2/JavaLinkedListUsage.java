// package LL_part2;

import java.util.LinkedList;

/**
 * Topic: Linked List
 * Problem: Java built-in LinkedList usage
 * 
 * Description: 
 * Demonstrates the usage of Java's built-in `java.util.LinkedList` class.
 * 
 * Intuition:
 * Java provides a robust implementation of a Doubly Linked List in the Collections framework.
 * It provides methods like `addFirst()`, `addLast()`, `removeFirst()`, and `removeLast()` 
 * that handle all pointer manipulations internally.
 * 
 * Complexity: O(1) Time for add/remove at ends, O(N) Space for storing elements.
 */
public class JavaLinkedListUsage {
    public static void main(String[] args) {
        // Create LinkedList. Note: Object types (e.g., Integer) must be used.
        LinkedList<Integer> ll = new LinkedList<>();

        // Add elements
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        
        // Output: [0, 1, 2]
        System.out.println("After additions: " + ll);

        // Remove elements
        ll.removeLast();
        ll.removeFirst();
        
        // Output: [1]
        System.out.println("After removals: " + ll);
    }
}
