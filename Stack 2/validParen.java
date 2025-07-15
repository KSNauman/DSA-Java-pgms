import java.util.Stack;
/*
 * Valid Parenthesis Checker - Two-Step Approach:
 * 1. Push each opening parenthesis onto the stack.
 * 2. For each closing parenthesis:
 *    - If the stack is not empty and the top matches, pop the stack.
 *    - If mismatched or the stack is empty, return false (invalid sequence).
 * 
 * Edge Cases Considered:
 * 1. Sequence with only closing brackets: 
 *    - Since no opening brackets are pushed, the stack remains empty.
 *    - Attempting to match will result in an immediate mismatch, ensuring proper handling.
 * 2. Unbalanced sequences: 
 *    - If extra opening brackets remain after processing, it is invalid.
 */

public class validParen {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
            // closing
            // stack is empty invalid case as no opening parenthesis is pushed
            if (s.isEmpty()) {
                return false;
            }
            //cmp for matching pair
            if ((s.peek() == '(' && ch == ')') ||
                    (s.peek() == '{' && ch == '}') ||
                    (s.peek() == '[' && ch == ']')) {
                s.pop();
            }else{
                return false;//mismatched bracket i,e not in order
            }

            }
        }
        // if (s.isEmpty()) {
        //     return true;
        // }else{
        //     return false;
        // }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println(isValid(str));
    }
}