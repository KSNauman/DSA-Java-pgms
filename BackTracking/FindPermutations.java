// package BackTracking;

/**
 * Topic: Backtracking
 * Problem: Find Permutations
 * 
 * Description: 
 * Find and print all permutations of a given string.
 * For a string of length N, there are N! permutations.
 * 
 * Intuition:
 * Use backtracking. At each step, pick one character from the remaining string, 
 * add it to the current answer, and recursively find permutations for the rest of the string.
 * The remaining string is constructed by removing the chosen character.
 * 
 * Complexity: O(N * N!) Time, O(N) Space for call stack.
 */
public class FindPermutations {
    public static void findPerpu(String str, String ans) {
        // Base case: No characters left to pick
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        
        // Try picking each character one by one
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            
            // Remaining string after removing the character at index i
            String newStr = str.substring(0, i) + str.substring(i + 1);
            
            // Recursive call
            findPerpu(newStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        findPerpu("abc", "");
    }
}