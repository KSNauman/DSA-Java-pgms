// package Stack;

import java.util.Stack;

/**
 * Topic: Stack
 * Problem: Java Collections Framework Stack
 * 
 * Description: 
 * Demonstrates the use of the built-in `java.util.Stack` class.
 * 
 * Intuition:
 * Java provides a ready-to-use Stack class which extends Vector. It implements standard 
 * operations like push, pop, peek, and isEmpty natively.
 * 
 * Complexity: O(1) Time for push, pop, and peek. O(N) Space.
 */
public class StackJCF {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Built-in Stack elements:");
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
