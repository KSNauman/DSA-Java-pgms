// package Queue.Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Topic: Deque
 * Problem: Queue Using Deque
 * 
 * Description: 
 * Implement a Queue using Java's built-in Deque interface.
 * 
 * Intuition:
 * A Queue follows First-In-First-Out (FIFO). A Deque allows insertion and removal at both ends.
 * We can implement a Queue by adding elements to the rear of the Deque (addLast) and 
 * removing elements from the front of the Deque (removeFirst).
 * 
 * Complexity: O(1) Time for add, remove, and peek. O(N) Space.
 */
public class QueueUsingDeque {
    static class Queue {
        Deque<Integer> dq = new LinkedList<>();

        public void add(int data) {
            dq.addLast(data);
        }

        public int remove() {
            if (dq.isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return dq.removeFirst();
        }

        public int peek() {
            if (dq.isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return dq.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        
        System.out.println("Queue implementation using Deque:");
        System.out.println("Peek: " + q.peek());
        System.out.println("Remove: " + q.remove());
        System.out.println("Peek: " + q.peek());
    }
}