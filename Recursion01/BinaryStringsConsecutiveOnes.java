// package Recursion01;

/**
 * Topic: Recursion
 * Problem: Binary Strings Without Consecutive Ones
 * 
 * Description: 
 * Generate all binary strings of length N such that there are no consecutive 1s in the string.
 * 
 * Intuition:
 * We use recursion to build strings character by character. 
 * At any step, we can safely append '0'. We can append '1' ONLY IF the last appended character was not '1'.
 * We pass the last character added as a parameter (`lastPlace`) to check this condition.
 * 
 * Complexity: O(2^N) Time because at each step we make up to 2 recursive calls. O(N) Space for call stack.
 */
public class BinaryStringsConsecutiveOnes {
    public static void printBinaryStrings(int n, int lastPlace, String str) {
        // Base case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        
        // We can always append '0'
        printBinaryStrings(n - 1, 0, str + "0");
        
        // We can append '1' only if the last character was '0'
        if (lastPlace == 0) {
            printBinaryStrings(n - 1, 1, str + "1");
        }
    }
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Valid binary strings of length " + n + ":");
        printBinaryStrings(n, 0, "");
    }
}
