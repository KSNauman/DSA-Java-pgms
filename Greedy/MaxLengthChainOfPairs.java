// package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Topic: Greedy Algorithm
 * Problem: Maximum Length Chain of Pairs
 * 
 * Description: 
 * You are given n pairs of numbers. In every pair, the first number is always smaller than 
 * the second number. A pair (c, d) can follow another pair (a, b) if b < c. 
 * Find the longest chain which can be formed from a given set of pairs.
 * 
 * Intuition:
 * This problem is equivalent to the Activity Selection problem.
 * Sort the pairs based on their second elements (end values).
 * Greedily pick the next pair if its start value is strictly greater than the end value 
 * of the previously selected pair.
 * 
 * Complexity: O(N log N) Time due to sorting, O(1) Space (ignoring the space required for sorting).
 */
public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int[][] pairs = {
            {5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}
        };

        // Sort based on the second element (end of the pair)
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1; // Start with the first pair
        int chainEnd = pairs[0][1]; // Track the end of the last added pair

        for (int i = 1; i < pairs.length; i++) {
            // If the next pair starts after the previous pair ends, add it to the chain
            if (pairs[i][0] > chainEnd) {
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Maximum length of chain = " + chainLen);
    }
}