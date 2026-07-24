// package Recursion01;

/**
 * Topic: Recursion
 * Problem: Tiling Problem
 * 
 * Description: 
 * Given a "2 x n" board and tiles of size "2 x 1", count the number of ways to tile 
 * the given board. A tile can either be placed horizontally or vertically.
 * 
 * Intuition:
 * If we place a tile vertically, it takes up a 2x1 space, leaving a 2x(n-1) board to fill.
 * If we place a tile horizontally, it takes up a 1x2 space. To fill the 2x2 section, 
 * we must place another horizontal tile below it. This leaves a 2x(n-2) board to fill.
 * Thus, total ways f(n) = f(n-1) + f(n-2). This is essentially the Fibonacci sequence.
 * 
 * Complexity: O(2^N) Time without memoization (can be O(N) with DP). O(N) Space.
 */
public class TilingProblem {
    public static int totalWays(int n) {
        // Base cases: 
        // 0 or 1 column left -> only 1 way to fill it (or nothing to fill)
        if (n == 0 || n == 1) {
            return 1;
        }
        
        // Case 1: Place vertically
        int waysVertical = totalWays(n - 1);
        
        // Case 2: Place horizontally
        int waysHorizontal = totalWays(n - 2);

        return waysVertical + waysHorizontal;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Total ways to fill a 2x" + n + " board: " + totalWays(n));
    }
}
