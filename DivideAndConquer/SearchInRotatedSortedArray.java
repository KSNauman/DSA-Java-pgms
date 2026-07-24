// package DivideAndConquer;

/**
 * Topic: Divide And Conquer
 * Problem: Search in a Rotated Sorted Array
 * 
 * Description: 
 * Given a sorted array that has been rotated around a pivot, find the index of a target element.
 * Return -1 if the element is not found.
 * 
 * Intuition:
 * Use a modified Binary Search. At any point, the array is divided into two parts by the `mid` element.
 * One of the parts (either the left half or the right half) MUST be strictly sorted.
 * Check if the target lies within the strictly sorted part. If it does, narrow the search to that part.
 * If not, search the other part.
 * 
 * Complexity: O(log N) Time, O(log N) Space for call stack (if using recursion).
 */
public class SearchInRotatedSortedArray {
    public static int searching(int[] arr, int tar, int si, int ei) {
        if (si > ei) {
            return -1; // Base case: Target not found
        }
        int mid = si + (ei - si) / 2;

        // Case: Found target
        if (arr[mid] == tar) {
            return mid;
        }

        // Check if mid is on Line 1 (Left part is sorted)
        if (arr[si] <= arr[mid]) {
            // Case a: Target is in the left sorted part
            if (arr[si] <= tar && tar <= arr[mid]) {
                return searching(arr, tar, si, mid - 1);
            } 
            // Case b: Target is in the right part
            else {
                return searching(arr, tar, mid + 1, ei);
            }
        } 
        // Check if mid is on Line 2 (Right part is sorted)
        else {
            // Case c: Target is in the right sorted part
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return searching(arr, tar, mid + 1, ei);
            } 
            // Case d: Target is in the left part
            else {
                return searching(arr, tar, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int tarIdx = searching(arr, target, 0, arr.length - 1);
        System.out.println("Index of target " + target + " is: " + tarIdx);
    }
}
