// package Queue.Deque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Topic: Deque
 * Problem: Stack Using Deque
 * 
 * Description: 
 * Implement a Stack using Java's built-in Deque interface.
 * 
 * Intuition:
 * A Stack follows Last-In-First-Out (LIFO). A Deque allows insertion and removal at both ends.
 * We can implement a Stack by adding elements to the rear (addLast) and 
 * removing elements from the rear (removeLast).
 * 
 * Complexity: O(1) Time for push, pop, and peek. O(N) Space.
 */
public class StackUsingDeque {
    public static class Stack {
        Deque<Integer> dq = new LinkedList<>();
        
        public void push(int data) {
            dq.addLast(data); // Can also use addFirst
        }
        
        public int pop() {
            if (dq.isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }
            return dq.removeLast(); // If using addFirst, this should be removeFirst
        }
        
        public int peek() {
            if (dq.isEmpty()) {
                System.out.println("Empty Stack");
                return -1;
            }
            return dq.getLast(); // If using addFirst, this should be getFirst
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        
        System.out.println("Stack implementation using Deque:");
        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Peek: " + s.peek());
    }
}
