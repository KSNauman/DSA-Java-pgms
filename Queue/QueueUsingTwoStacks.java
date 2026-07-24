// package Queue;

import java.util.Stack;

/**
 * Topic: Queue
 * Problem: Queue Using Two Stacks
 * 
 * Description: 
 * Implement a Queue using two Stacks.
 * 
 * Intuition:
 * To make a Queue (FIFO) out of Stacks (LIFO), we can make the `add` operation costly.
 * During `add`, we pop all elements from Stack 1 and push them to Stack 2.
 * Then we push the new element into Stack 1. Finally, we pop everything from Stack 2 
 * and push back to Stack 1. This ensures the oldest element is always at the top of Stack 1.
 * 
 * Complexity: O(N) Time for add. O(1) Time for remove/peek. O(N) Space.
 */
public class QueueUsingTwoStacks {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }
        
        // Add operation: Move all to s2, add new element to s1, move all back to s1
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            
            s1.push(data);
            
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // Remove operation: Simply pop from s1
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty");
                return -1;
            }
            return s1.pop();
        }

        // Peek operation: Simply peek s1
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("Removing elements from Queue (Implemented using 2 Stacks):");
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
