// package Strings;

/**
 * Topic: Strings
 * Problem: String Basics and Concepts
 * 
 * Description: 
 * Covers basic string concepts in Java: Substring extraction, String comparison, 
 * and using StringBuilder.
 * 
 * Intuition:
 * 1. Substring: Iterating from start index to end index and building a new string.
 * 2. Comparison: Using `.compareTo()` to compare strings lexicographically.
 *    (Negative if smaller, 0 if equal, Positive if greater).
 * 3. StringBuilder: Strings in Java are immutable. Any modification creates a new string 
 *    object (O(N^2) complexity for repeated concatenation). `StringBuilder` is mutable 
 *    and provides O(N) complexity for appending characters.
 * 
 * Complexity: 
 * O(N) for substring, O(N * length of string) for comparison, O(N) for StringBuilder append.
 */
public class StringBasics {
    
    // 1. Substring manually
    public static void printSubString(String str, int si, int ei) {
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i);
        }
        System.out.println("Manual Substring (" + si + "," + ei + "): " + substr);
    }  
    
    // 2. Lexicographical comparison
    public static void stringComparing() {
        String[] arr = {"apple", "banana", "mango"};
        String largest = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            // compareTo returns positive if the caller is lexicographically larger
            if (largest.compareTo(arr[i]) < 0) {
                largest = arr[i];
            }
        }
        System.out.println("Lexicographically largest string: " + largest);
    }
    
    // 3. StringBuilder Concept
    public static void stringBuilderConcept() {
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.println("StringBuilder result: " + sb.toString());
        System.out.println("StringBuilder length: " + sb.length());
    }
    
    public static void main(String[] args) {
        String word = "HELLO WORLD";
        System.out.println("Original String: " + word);
        
        printSubString(word, 0, 5);
        System.out.println("Inbuilt Substring: " + word.substring(0, 5));
        System.out.println();
        
        stringComparing();
        System.out.println();
        
        stringBuilderConcept();
    }
}
