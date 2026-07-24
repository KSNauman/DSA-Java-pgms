// package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Topic: Queue
 * Problem: Queue Basic Implementation (Linked List) & Java Framework Usage
 * 
 * Description: 
 * Demonstrates how to implement a Queue from scratch using a Linked List, 
 * as well as how to use the built-in Queue interface in Java (via ArrayDeque).
 * 
 * Intuition:
 * A Queue follows the First-In-First-Out (FIFO) principle.
 * We can implement it using a Linked List by maintaining `head` (front) and `tail` (rear) pointers.
 * Adding an element appends it to the `tail`. Removing an element removes it from the `head`.
 * 
 * Complexity: O(1) Time for add/remove/peek. O(N) Space for N elements.
 */
public class QueueBasic {
    // Node class for Linked List Implementation
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Custom Queue using Linked List
    static class CustomQueue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // Add to rear
        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // Remove from front
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int front = head.data;
            // Single element
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }
        
        // Peek front
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty");
                return -1;
            }
            return head.data;
        }
    }
    
    public static void main(String[] args) {
        // Using built-in Java Queue (ArrayDeque is generally faster than LinkedList)
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("Using built-in ArrayDeque:");
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

        // Using Custom Queue
        CustomQueue.add(10);
        CustomQueue.add(20);
        CustomQueue.add(30);

        System.out.println("Using Custom Queue:");
        while (!CustomQueue.isEmpty()) {
            System.out.println(CustomQueue.peek());
            CustomQueue.remove();
        }
    }
}
