// package Patterns;

/**
 * Topic: Recursion / Patterns
 * Problem: Binary Strings without Consecutive Ones
 * 
 * Description: 
 * Generate all binary strings of length N such that there are no consecutive 1s in the string.
 * 
 * Intuition:
 * We use recursion. At each step, we can append a '0' to the string. We can append a '1' 
 * ONLY IF the last appended character was not '1'. We pass the last character added as a 
 * parameter to keep track of this condition.
 * 
 * Complexity: O(2^N) Time because at each step we make up to 2 recursive calls. O(N) Space for call stack.
 */
public class BinaryStringWithoutConsecutiveOnes {
    public static void printBinaryStrings(int n, int lastPlace, String str) {
        // Base case: if length becomes 0, we found a valid string
        if (n == 0) {
            System.out.println(str);
            return;
        }
        
        // If the last character was '0', we can append either '0' or '1'
        if (lastPlace == 0) {
            printBinaryStrings(n - 1, 0, str + "0");
            printBinaryStrings(n - 1, 1, str + "1");
        } else {
            // If the last character was '1', we can only append '0'
            printBinaryStrings(n - 1, 0, str + "0");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Binary strings of length " + n + " without consecutive 1s:");
        printBinaryStrings(n, 0, "");
    }
}
