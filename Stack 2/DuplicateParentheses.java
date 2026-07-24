// package Stack2;

import java.util.Stack;

/**
 * Topic: Stack
 * Problem: Duplicate Parentheses
 * 
 * Description: 
 * Given a balanced expression, find if it contains duplicate parentheses. 
 * A set of parentheses are duplicate if the same sub-expression is surrounded by multiple parentheses.
 * Input is guaranteed to be a valid expression.
 * 
 * Intuition:
 * Use a stack to push characters until a closing bracket ')' is encountered.
 * When ')' is encountered, pop characters until an opening bracket '(' is found.
 * If the number of characters popped between '(' and ')' is 0, it means the parentheses are duplicate 
 * (e.g., `((a+b))` -> inner pops `a+b` (length>0), outer pops nothing).
 * 
 * Complexity: O(N) Time, O(N) Space.
 */
public class DuplicateParentheses {
    public static boolean hasDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If closing bracket
            if (ch == ')') {
                int count = 0;
                // Pop until opening bracket
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                
                // If nothing was inside, it's a duplicate
                if (count < 1) {
                    return true; // duplicate found
                } else {
                    s.pop(); // pop the opening pair '('
                }
            } else {
                // Push everything else
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "(((a+b)+(c)))";
        String str2 = "(a+b)";
        
        System.out.println(str1 + " has duplicate? " + hasDuplicate(str1));
        System.out.println(str2 + " has duplicate? " + hasDuplicate(str2));
    }
}