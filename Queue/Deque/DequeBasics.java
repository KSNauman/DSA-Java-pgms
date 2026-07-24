// package Queue.Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Topic: Deque
 * Problem: Deque Basics
 * 
 * Description: 
 * Demonstrates the basic operations of a Double Ended Queue (Deque) in Java.
 * 
 * Intuition:
 * A Deque is an interface that can be implemented by classes like LinkedList or ArrayDeque.
 * It provides methods to add, remove, and examine elements at both ends (front and rear).
 * Operations:
 * 1. addFirst()
 * 2. addLast()
 * 3. removeFirst()
 * 4. removeLast()
 * 5. getFirst()
 * 6. getLast()
 * 
 * Complexity: O(1) Time for insertion and removal at both ends. O(N) Space.
 */
public class DequeBasics {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        // Add elements
        deque.addFirst(1); // [1]
        deque.addLast(3);  // [1, 3]
        deque.addFirst(0); // [0, 1, 3]
        
        System.out.println("Deque after additions: " + deque);
        
        // Remove elements
        deque.removeFirst(); // [1, 3]
        System.out.println("Deque after removeFirst(): " + deque);
        
        deque.removeLast();  // [1]
        System.out.println("Deque after removeLast(): " + deque);
    }
}