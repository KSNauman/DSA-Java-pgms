// package DP;

/**
 * Topic: Dynamic Programming (DP)
 * Problem: Climbing Stairs
 * 
 * Description: 
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1, 2, or 3 steps. In how many distinct ways can you climb to the top?
 * 
 * Intuition:
 * This is a variation of the Fibonacci sequence. The number of ways to reach step `n` is the 
 * sum of ways to reach `n-1`, `n-2`, and `n-3`. We use an array `dp` to memoize the results 
 * of overlapping subproblems to optimize the recursive approach.
 * 
 * Complexity: O(N) Time (due to memoization), O(N) Space (for dp array and call stack).
 */
public class ClimbingStairs {
    public static int rec(int n, int[] dp) {
        if (n == 0) {
            dp[n] = 1;
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = rec(n - 1, dp) + rec(n - 2, dp) + rec(n - 3, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        System.out.println("Ways to climb " + n + " stairs: " + rec(n, dp));
    }
}
