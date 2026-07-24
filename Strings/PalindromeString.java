// package Strings;

/**
 * Topic: Strings
 * Problem: Palindrome Check
 * 
 * Description: 
 * Check if a given string is a palindrome. A string is a palindrome if it reads 
 * the same forwards and backwards.
 * 
 * Intuition:
 * Iterate through the first half of the string. Compare the character at index `i` 
 * with the character at index `n - 1 - i` (its mirrored position).
 * If any pair doesn't match, the string is not a palindrome.
 * 
 * Complexity: O(N) Time (iterates N/2 times), O(1) Space.
 */
public class PalindromeString {
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String str = "noommmn";
        
        if (isPalindrome(str)) {
            System.out.println("'" + str + "' is a Palindrome.");
        } else {
            System.out.println("'" + str + "' is NOT a Palindrome.");
        }
    }
}
