// package BackTracking;

/**
 * Topic: Backtracking
 * Problem: Find Subsets
 * 
 * Description: 
 * Find and print all subsets of a given string.
 * For a string of length N, there are 2^N subsets.
 * 
 * Intuition:
 * Use backtracking. For every character in the string, we have two choices:
 * 1. Include the character in the subset (Yes choice).
 * 2. Exclude the character from the subset (No choice).
 * Explore both choices recursively until we reach the end of the string.
 * 
 * Complexity: O(N * 2^N) Time, O(N) Space for call stack.
 */
public class FindSubsets {
    public static void findSubsets(String str, int i, String ans) {
        // Base case: Reached the end of the string
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        
        // Choice 1: Include the current character
        findSubsets(str, i + 1, ans + str.charAt(i));
        
        // Choice 2: Exclude the current character
        findSubsets(str, i + 1, ans);
    }

    public static void main(String[] args) {
        findSubsets("abc", 0, "");
    }
}
