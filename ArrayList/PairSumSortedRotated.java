// package ArrayList;

import java.util.ArrayList;

/**
 * Topic: ArrayList
 * Problem: Pair Sum in Sorted and Rotated ArrayList
 * 
 * Description: 
 * Find if any pair in a sorted and rotated ArrayList has a target sum.
 * 
 * Intuition:
 * Use a Two-Pointer approach. First, find the pivot (the largest element where 
 * the next element is the smallest). Set the left pointer (lp) to the smallest 
 * element (pivot + 1) and right pointer (rp) to the largest element (pivot).
 * Use modular arithmetic to increment/decrement the pointers since the array is rotated.
 * 
 * Complexity: O(N) Time, O(1) Space.
 */
public class PairSumSortedRotated {
    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int n = list.size();
        int pivot = -1;
        
        // Find the pivot
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && list.get(i) > list.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        
        int lp = (pivot + 1) % n; // smallest
        int rp = pivot;           // largest
        
        while (lp != rp) {
            int currentSum = list.get(lp) + list.get(rp);
            
            if (currentSum == target) {
                return true;
            }
            
            if (currentSum < target) {
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // Rotated Array: 11, 15, 6, 8, 9, 10
        int[] arr = {11, 15, 6, 8, 9, 10};
        for (int x : arr) list.add(x);
        
        int target = 16;
        System.out.println(pairSum2(list, target));
    }
}