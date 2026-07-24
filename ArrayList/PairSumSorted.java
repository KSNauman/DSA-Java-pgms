// package ArrayList;

import java.util.ArrayList;

/**
 * Topic: ArrayList
 * Problem: Pair Sum in Sorted ArrayList
 * 
 * Description: 
 * Find if any pair in a sorted ArrayList has a target sum.
 * 
 * Intuition:
 * Use a Two-Pointer approach since the array is already sorted.
 * Start with left pointer at the beginning (smallest) and right at the end (largest).
 * If sum < target, increment left pointer to increase the sum.
 * If sum > target, decrement right pointer to decrease the sum.
 * 
 * Complexity: O(N) Time, O(1) Space.
 */
public class PairSumSorted {
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        // Brute Force: O(n^2)
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        // Optimized Two-Pointer: O(n)
        int lp = 0, rp = list.size() - 1;

        while (lp < rp) {
            int currentSum = list.get(lp) + list.get(rp);
            
            if (currentSum == target) {
                return true;
            } else if (currentSum < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // Sorted ArrayList: 1, 2, 3, 4, 5, 6
        int[] arr = {1, 2, 3, 4, 5, 6};
        for (int x : arr) list.add(x);
        
        int target = 5;

        System.out.println("Brute Force: " + pairSum1(list, target));
        System.out.println("Optimized: " + pairSum2(list, target));
    }
}