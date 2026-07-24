// package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Topic: Queue
 * Problem: Stack Using Two Queues
 * 
 * Description: 
 * Implement a Stack using two Queues.
 * 
 * Intuition:
 * To make a Stack (LIFO) out of Queues (FIFO), we can make the `pop` operation costly.
 * During `pop`, we move all elements except the last one from the non-empty queue 
 * to the empty queue. The last element is then dequeued and returned as the popped element.
 * 
 * Complexity: O(1) Time for push. O(N) Time for pop/peek. O(N) Space.
 */
public class StackUsingTwoQueues {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();
        
        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // Push operation: Add to the non-empty queue
        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // Pop operation: Remove all but the last element to the other queue, then remove the last
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Empty");
                return -1;
            }
            int top = -1;
            
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break; // This is the last element (the 'top' of the stack)
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top); 
                }
            }
            return top;
        }

        // Peek operation: Similar to pop, but the last element is also pushed to the other queue
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty");
                return -1;
            }
            int top = -1;
            
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top); 
                }
            }
            return top;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Popping elements from Stack (Implemented using 2 Queues):");
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
