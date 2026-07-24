/**
 * Topic: Patterns
 * Problem: Butterfly Pattern
 * 
 * Description: 
 * Print a butterfly pattern using stars.
 * Example for n = 4:
 * *      *
 * **    **
 * ***  ***
 * ********
 * ********
 * ***  ***
 * **    **
 * *      *
 * 
 * Intuition:
 * Divide the pattern into two parts: upper half and lower half.
 * For each row `i` in the upper half:
 * - Print `i` stars
 * - Print `2 * (n - i)` spaces
 * - Print `i` stars
 * The lower half is the exact mirror of the upper half, so loop `i` from `n` down to 1.
 * 
 * Complexity: O(N^2) Time, O(1) Space.
 */
public class ButterflyPattern {
    public static void main(String[] args) {
        int n = 5;
        
        System.out.println("Butterfly Pattern:");
        // Upper part
        for (int i = 1; i <= n; i++) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Lower part
        for (int i = n; i >= 1; i--) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
