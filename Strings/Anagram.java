// package Strings;

import java.util.Arrays;

/**
 * Topic: Strings
 * Problem: Anagram Check
 * 
 * Description: 
 * Check if two strings are anagrams of each other. 
 * Two strings are anagrams if they contain the same characters in the same frequency, 
 * but the order of characters can be different (e.g., "race" and "care").
 * 
 * Intuition:
 * 1. Convert both strings to lowercase.
 * 2. Convert both strings to character arrays.
 * 3. Sort both character arrays.
 * 4. Compare the sorted arrays. If they are equal, the strings are anagrams.
 * 
 * Complexity: O(N log N) Time due to sorting, O(N) Space for character arrays.
 */
public class Anagram {
    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "care";

        // Convert to lowercase and char array
        char[] charStr1 = str1.toLowerCase().toCharArray();
        char[] charStr2 = str2.toLowerCase().toCharArray();
        
        // Sort arrays
        Arrays.sort(charStr1);
        Arrays.sort(charStr2);
        
        // Compare arrays
        boolean isAnagram = Arrays.equals(charStr1, charStr2);
        
        if (isAnagram) {
            System.out.println("'" + str1 + "' and '" + str2 + "' are Anagrams.");
        } else {
            System.out.println("'" + str1 + "' and '" + str2 + "' are NOT Anagrams.");
        }
    }
}
