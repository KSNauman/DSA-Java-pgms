// package BackTracking;

/**
 * Topic: Backtracking
 * Problem: Grid Ways
 * 
 * Description: 
 * Find the number of ways to reach from the top-left corner (0,0) to the bottom-right 
 * corner (n-1, m-1) of an N x M grid. You can only move right or down.
 * 
 * Intuition:
 * Use recursion to explore two choices from any cell (i, j): move right to (i, j+1) 
 * or move down to (i+1, j). Base cases are reaching the target (1 way) or 
 * going out of bounds (0 ways).
 * 
 * Complexity: O(2^(N+M)) Time, O(N+M) Space for call stack. 
 * (Note: This can be optimized to O(N*M) with DP or O(N) using Combinatorics).
 */
public class GridWays {
    public static int gridways(int i, int j, int n, int m) {
        // Base case: Reached the destination
        if (i == n - 1 && j == m - 1) {
            return 1;
        } 
        // Base case: Out of bounds
        else if (i == n || j == m) {
            return 0;
        }
        
        // Choice 1: Move down
        int w1 = gridways(i + 1, j, n, m);
        // Choice 2: Move right
        int w2 = gridways(i, j + 1, n, m);
        
        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(gridways(0, 0, n, m));
    }
}
