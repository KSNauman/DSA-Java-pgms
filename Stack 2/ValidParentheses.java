// package Stack2;

import java.util.Stack;

/**
 * Topic: Stack
 * Problem: Valid Parentheses
 * 
 * Description: 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * Intuition:
 * 1. Push each opening parenthesis onto the stack.
 * 2. For each closing parenthesis, check if the stack is non-empty and the top of the stack matches 
 *    the corresponding opening parenthesis. If yes, pop. If no (mismatch or empty), return false.
 * 3. At the end, if the stack is empty, the string is valid.
 * 
 * Complexity: O(N) Time, O(N) Space.
 */
public class ValidParentheses {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // If it's a closing bracket but stack is empty -> invalid
                if (s.isEmpty()) {
                    return false;
                }
                
                // Check for matching pair
                if ((s.peek() == '(' && ch == ')') ||
                    (s.peek() == '{' && ch == '}') ||
                    (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false; // Mismatched bracket
                }
            }
        }
        
        // If stack is empty, all brackets were matched
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println("Is '" + str + "' valid? " + isValid(str));
        
        String str2 = "({)}";
        System.out.println("Is '" + str2 + "' valid? " + isValid(str2));
    }
}