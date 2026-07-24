// package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Topic: Greedy Algorithm
 * Problem: Fractional Knapsack
 * 
 * Description: 
 * Given weights and values of n items, we need to put these items in a knapsack of capacity W 
 * to get the maximum total value in the knapsack. We can break items for maximizing the total value 
 * (fractional property).
 * 
 * Intuition:
 * Calculate the ratio (value / weight) for each item and sort them in descending order of this ratio.
 * Take as much of the item with the highest ratio as possible. If an item cannot fit completely, 
 * take a fraction of it to fill the remaining capacity.
 * 
 * Complexity: O(N log N) Time due to sorting, O(N) Space for storing ratios.
 */
public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;

        // 0th col => index; 1st col => ratio
        double[][] ratio = new double[val.length][2];

        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // Sort in ascending order based on ratio
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;
        
        // Traverse from end to get highest ratio first
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // Take fractional part
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("Maximum value in knapsack: " + finalVal);
    }
}
