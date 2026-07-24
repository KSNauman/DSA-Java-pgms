/**
 * Topic: Arrays (Part 2)
 * Problem: Maximum Subarray Sum
 * 
 * Description:
 * Find the contiguous subarray (containing at least one number) which has the
 * largest sum and return its sum.
 * 
 * Intuition:
 * - Brute Force: Check all subarrays.
 * - Prefix Sum: Precompute the sum of elements from 0 to i to find sum of
 * subarray(i, j) in O(1).
 * - Kadane's Algorithm: Maintain a running sum (currentSum). If it drops below
 * 0, reset it to 0. Keep track of maxSum.
 * 
 * Complexity:
 * - Kadane's Algorithm: O(N) Time, O(1) Space.
 * - Prefix Sum: O(N^2) Time, O(N) Space.
 * - Brute Force: O(N^3) Time, O(1) Space.
 */
public class MaxSubArraySum {
    public static void maximumsumOfSubArrays(int[] arr) {
        // Brute force: O(n^3)
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxsum = Math.max(sum, maxsum);
            }
        }
        System.out.println("Max sum is " + maxsum);
    }

    public static void maximumsumOfSubArrays02(int[] arr) {
        // Prefix sum array: O(n^2)
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int maxsum = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                maxsum = Math.max(sum, maxsum);
            }
        }
        System.out.println("Max sum is " + maxsum);
    }

    /*
     * there is another method even with less complexity named as kadane's algo
     * where u just declare 2 var one is cur and ms
     * if the numbers are (larger +ve)+(larger +ve) its fine
     * if the numbers are (larger +ve)+(minor -ve) its fine
     * if the numbers are (lager -ve)+(larger -ve) then just use 0
     */
    public static void kadane(int[] arr) {
        // Kadane's Algorithm: O(n)
        int cs = 0, ms = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cs = cs + arr[i];
            if (cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println(ms);
    }

    public static void maxSubArray(int[] nums) {
        // Enhanced Kadane's for all-negative arrays
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        int[] arrr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        maxSubArray(arrr);
    }
}