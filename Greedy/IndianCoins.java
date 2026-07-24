// package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Topic: Greedy Algorithm
 * Problem: Indian Coins (Coin Change)
 * 
 * Description: 
 * We are given an infinite supply of denominations [1, 2, 5, 10, 20, 50, 100, 500, 2000].
 * Find the minimum number of coins/notes needed to make change for a value V.
 * 
 * Intuition:
 * This problem can be solved greedily because the Indian coin denominations are canonical 
 * (the sum of smaller denominations is less than the next larger denomination).
 * Sort the coins in descending order and greedily pick the largest possible coin that is 
 * less than or equal to the remaining amount.
 * 
 * Complexity: O(N log N) Time due to sorting (or O(N) if already sorted), O(N) Space for answer array.
 */
public class IndianCoins {
    public static void main(String[] args) {
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        
        // Sort in descending order
        Arrays.sort(coins, Comparator.reverseOrder());
        
        int count = 0;
        int amount = 1059;
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    count++;
                    ans.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Total (minimum) coins used = " + count);
        System.out.print("Coins used: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
