// package DP;

/**
 * Topic: Dynamic Programming (DP)
 * Problem: 0/1 Knapsack
 * 
 * Description: 
 * Given weights and values of n items, put these items in a knapsack of capacity W 
 * to get the maximum total value in the knapsack. You cannot break an item, either pick 
 * the complete item or don't pick it (0/1 property).
 * 
 * Intuition:
 * For each item, we have two choices:
 * 1. Include it (if its weight <= current capacity): Profit = value + max_profit of remaining items with reduced capacity.
 * 2. Exclude it: Profit = max_profit of remaining items with the same capacity.
 * 
 * We solve this using Tabulation (Bottom-Up DP) where `dp[i][j]` represents the maximum 
 * profit for `i` items and `j` capacity.
 * 
 * Complexity: O(N * W) Time, O(N * W) Space.
 */
public class Knapsack01 {
    // Tabulation Approach
    public int knap(int W, int[] val, int[] wt) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        
        // Base case initialization is default 0 in Java
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                
                // If the item can fit in the knapsack
                if (w <= j) {
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    // Item cannot fit, exclude it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int W = 7;
        int[] val = {15, 14, 10, 45, 30};
        int[] wt = {2, 5, 1, 3, 4};
        
        Knapsack01 kp = new Knapsack01();
        System.out.println("Maximum Profit: " + kp.knap(W, val, wt));
    }
}
