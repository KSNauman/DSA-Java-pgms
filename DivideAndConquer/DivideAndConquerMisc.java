// package DivideAndConquer;

/**
 * Topic: Divide And Conquer
 * Problem: Miscellaneous Problems (Merge Sort on Strings, Majority Element, Inversion Count)
 * 
 * Description: 
 * Assorted problems solved using Divide and Conquer:
 * 1. Sorting an array of Strings using Merge Sort.
 * 2. Finding the Majority Element (element that appears > n/2 times) using Divide & Conquer.
 * 3. Counting Inversions in an array (how many pairs satisfy i < j and arr[i] > arr[j]).
 * 
 * Intuition:
 * - String Sort: Same as Merge Sort but using String.compareTo().
 * - Majority Element: If an array is divided, the overall majority element must be a majority 
 *   in at least one of its halves. Calculate recursively and verify.
 * - Inversion Count: piggyback on Merge Sort. When left[i] > right[j], all remaining elements 
 *   in the left half also form an inversion with right[j].
 * 
 * Complexity: 
 * - String Sort: O(N log N * L) Time (L=max string length), O(N) Space.
 * - Majority Element: O(N log N) Time, O(log N) Space (can be O(N) Time with Boyer-Moore).
 * - Inversion Count: O(N log N) Time, O(N) Space.
 */
public class DivideAndConquerMisc {

    // 1. Merge Sort on Strings
    public static void mergeStrings(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int i = si, j = mid + 1, k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= ei) temp[k++] = arr[j++];

        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void sortStrings(String arr[], int si, int ei) {
        if (si >= ei) return;
        int mid = si + (ei - si) / 2;
        sortStrings(arr, si, mid);
        sortStrings(arr, mid + 1, ei);
        mergeStrings(arr, si, mid, ei);
    }

    // 2. Majority Element
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }

    public int major(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];
        int mid = lo + (hi - lo) / 2;
        int left = major(nums, lo, mid);
        int right = major(nums, mid + 1, hi);

        if (left == right) return left;
        
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return major(nums, 0, nums.length - 1);
    }

    // 3. Inversion Count
    public static int count = 0;

    public static void mergeInts(int[] nums, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int i = lo, j = mid + 1, k = 0;
        
        while (i <= mid && j <= hi) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
                count += (mid - i + 1); // Crucial step for inversion count
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= hi) temp[k++] = nums[j++];
        
        for (k = 0, i = lo; i <= hi; k++, i++) {
            nums[i] = temp[k];
        }
    }

    public static void mergeSortInts(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSortInts(nums, lo, mid);
        mergeSortInts(nums, mid + 1, hi);
        mergeInts(nums, lo, mid, hi);
    }

    public static int invert(int[] nums) {
        count = 0;
        mergeSortInts(nums, 0, nums.length - 1);
        return count;
    }

    public static void main(String[] args) {
        // String array sorting
        String[] arr = { "sun", "earth", "mars", "mercury" };
        sortStrings(arr, 0, arr.length - 1);
        System.out.print("Sorted strings: ");
        for (String str : arr) System.out.print(str + " ");
        System.out.println();

        // Inversion count
        int[] nums = { 2, 3, 4, 5, 6 };
        System.out.println("Inversion Count: " + invert(nums));
    }
}
