// package Greedy;

import java.util.Arrays;

/**
 * Topic: Greedy Algorithm
 * Problem: Minimum Absolute Difference Pairs
 * 
 * Description: 
 * Given two arrays A and B of equal length, pair elements from A and B such that 
 * the sum of their absolute differences is minimized. Return the minimum sum.
 * 
 * Intuition:
 * To minimize the absolute difference between pairs, the smallest number in A should be paired 
 * with the smallest number in B, the second smallest with the second smallest, and so on.
 * Sorting both arrays and pairing elements at the same indices gives the optimal result.
 * 
 * Complexity: O(N log N) Time due to sorting, O(1) Space.
 */
public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int[] A = {4, 1, 8, 7};
        int[] B = {2, 3, 6, 5};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println("Minimum absolute difference is: " + minDiff);
    }
}
