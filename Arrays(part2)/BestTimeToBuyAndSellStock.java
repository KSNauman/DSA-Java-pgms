/**
 * Topic: Arrays (Part 2)
 * Problem: Best Time to Buy and Sell Stock
 * 
 * Description: 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * 
 * Intuition:
 * Maintain the minimum price seen so far (buy price). If the current price is greater, 
 * calculate the potential profit and update max profit. Otherwise, update the buy price.
 * 
 * Complexity: O(N) Time, O(1) Space.
 */
public class BestTimeToBuyAndSellStock {
    public static int BuyAndSell(int prizes[]) {
        int bp = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int i : prizes) {
            if (bp < i) {
                // Calculate profit when price is greater than buyPrize
                maxProfit = Math.max(maxProfit, i - bp);
            } else {
                // We found a better (lower) price to buy
                bp = i;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prizes = {7, 1, 5, 3, 6, 4};
        System.out.println(BuyAndSell(prizes));
    }
}
