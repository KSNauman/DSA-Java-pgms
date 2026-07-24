// package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Topic: Queue
 * Problem: Reverse a Queue
 * 
 * Description: 
 * Given a queue of integers, reverse the order of elements in it.
 * 
 * Intuition:
 * A Stack follows Last-In-First-Out (LIFO) order, which naturally reverses the order of elements.
 * We can dequeue all elements from the queue and push them onto a stack.
 * Then, we pop all elements from the stack and enqueue them back to the queue.
 * 
 * Complexity: O(N) Time, O(N) Space (for the Stack used to reverse).
 */
public class QueueReverse {

    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();

        // Push all elements from Queue to Stack
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        
        // Pop all elements from Stack and add back to Queue
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            q.add(i);
        }

        System.out.println("Original Queue: " + q);
        reverse(q);
        System.out.println("Reversed Queue: " + q);
    }
}
