// package Patterns;

/**
 * Topic: Patterns
 * Problem: Character Half Pyramid
 * 
 * Description: 
 * Print a half pyramid pattern using continuous characters.
 * Example for n = 4:
 * A
 * BC
 * DEF
 * GHIJ
 * 
 * Intuition:
 * Use two nested loops. The outer loop dictates the number of rows (i from 1 to n).
 * The inner loop dictates the number of columns in each row (j from 1 to i).
 * Maintain a character variable, print it, and increment it in every iteration.
 * 
 * Complexity: O(N^2) Time, O(1) Space.
 */
public class HalfPyramidPattern {
    public static void main(String[] args) {
        int n = 4;
        char c = 'A';
        
        System.out.println("Character Half Pyramid:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(c);
                c++;
            }
            System.out.println();
        }
    }
}
