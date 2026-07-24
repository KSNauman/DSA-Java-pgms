// package Recursion01;

/**
 * Topic: Recursion
 * Problem: Remove Duplicates from String
 * 
 * Description: 
 * Remove duplicate characters from a lowercase English string (e.g., "appnnacollege" -> "apncolge").
 * 
 * Intuition:
 * Maintain a boolean array `map` of size 26 to keep track of characters we have already seen.
 * Process the string recursively character by character. 
 * If the current character is already in the map, skip it.
 * Otherwise, append it to the new string, mark it in the map, and recurse.
 * 
 * Complexity: O(N) Time where N is the length of the string. O(N) Space for the call stack and StringBuilder.
 */
public class RemoveDuplicatesString {
    public static void removeDuplicates(String str, StringBuilder newStr, int idx, boolean[] map) {
        // Base case: Reached the end of the string
        if (idx == str.length()) {
            System.out.println("Resulting String: " + newStr);
            return;
        }

        char curr = str.charAt(idx); 

        // If the character is already seen, skip it
        if (map[curr - 'a']) {
            removeDuplicates(str, newStr, idx + 1, map);
        } else {
            // Otherwise, mark it as seen and append to new string
            map[curr - 'a'] = true;
            removeDuplicates(str, newStr.append(curr), idx + 1, map);
        }
    }
    
    public static void main(String[] args) {
        String str = "appnnacollege";
        System.out.println("Original String: " + str);
        removeDuplicates(str, new StringBuilder(""), 0, new boolean[26]); 
    }
}
