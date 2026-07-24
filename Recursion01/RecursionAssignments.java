// package Recursion01;

/**
 * Topic: Recursion
 * Problem: Recursion Assignments (Find Indices, Number to Words)
 * 
 * Description: 
 * Contains solutions to two common recursion assignments:
 * 1. Find all occurrences (indices) of a given key in an array.
 * 2. Convert a given number to its word representation (e.g., 1947 -> "one nine four seven").
 * 
 * Intuition:
 * 1. For finding indices: Traverse the array recursively. If the current element matches the key, print the index.
 * 2. For number to words: Extract the last digit using `% 10`, recursively call for the remaining number `n / 10`, 
 *    and then print the word for the extracted digit. This ensures digits are printed in the correct order (left to right).
 * 
 * Complexity: 
 * 1. O(N) Time and Space (N = array length).
 * 2. O(D) Time and Space (D = number of digits).
 */
public class RecursionAssignments {
    // Problem 1: Find all occurrences of a key
    public static void findAllOccurrences(int i, int[] arr, int key) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.print(i + " ");
        }
        findAllOccurrences(i + 1, arr, key);
    }
    
    static String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"}; 
    
    // Problem 2: Number to Words
    public static void printNumberToWords(int n) {
        if (n == 0) {
            return;
        }
        int lastDigit = n % 10;
        printNumberToWords(n / 10);
        System.out.print(digits[lastDigit] + " ");
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        System.out.print("Occurrences of 2: ");
        findAllOccurrences(0, arr, 2);
        System.out.println();
        
        System.out.print("Number 1947 in words: ");
        printNumberToWords(1947);
        System.out.println();
    }
}
