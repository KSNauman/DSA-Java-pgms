// package Stack;

import java.util.Stack;

/**
 * Topic: Stack
 * Problem: Basic Stack Problems (Push at Bottom, Reverse String, Reverse Stack)
 * 
 * Description: 
 * Contains solutions to common stack-based problems.
 * 
 * Intuition:
 * 1. Push at Bottom: Use recursion to pop all elements, push the target, and then push elements back.
 * 2. Reverse String: Push all characters onto the stack. Pop them to get the reversed string.
 * 3. Reverse Stack: Use recursion to extract the top element, recursively reverse the remaining stack, 
 *    and then push the extracted element at the bottom.
 * 
 * Complexity: 
 * 1. Push at Bottom: O(N) Time, O(N) Space.
 * 2. Reverse String: O(N) Time, O(N) Space.
 * 3. Reverse Stack: O(N^2) Time, O(N) Space.
 */
public class StackProblems {

    // Problem 1: Push an element at the bottom of a stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    
    // Problem 2: Reverse a String using a Stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        return result.toString();
    }

    // Problem 3: Reverse a Stack
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        
        System.out.println("Original Stack: " + s);
        pushAtBottom(s, 4);
        System.out.println("After pushing 4 at bottom: " + s);

        reverseStack(s);
        System.out.println("After reversing stack: " + s);

        String text = "hello";
        System.out.println("Reversed '" + text + "': " + reverseString(text));
    }
}
