// package DivideAndConquer;

/**
 * Topic: Divide And Conquer
 * Problem: Quick Sort
 * 
 * Description: 
 * Sort an array using the Quick Sort algorithm.
 * 
 * Intuition:
 * 1. Pick a pivot element (e.g., the last element).
 * 2. Partition the array such that all elements smaller than the pivot are on the left, 
 *    and elements greater are on the right.
 * 3. Recursively apply Quick Sort to the left and right sub-arrays.
 * 
 * Complexity: 
 * - Best and Average Case: O(N log N) Time (when pivot splits array evenly).
 * - Worst Case: O(N^2) Time (when array is already sorted, or pivot is extreme).
 * - Space Complexity: O(log N) Space due to recursion stack.
 */
public class QuickSort {
    public static void quick(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        // Partition array and get the pivot index
        int pIdx = partition(arr, si, ei);
        
        // Recursively sort left and right parts
        quick(arr, si, pIdx - 1);
        quick(arr, pIdx + 1, ei);
    }

    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei]; // Choosing last element as pivot
        int i = si - 1; // Index to keep track of smaller elements
        
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Place pivot in its correct sorted position
        i++;
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;
        
        return i; // Return pivot index
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 9, 8, 2, 5 };
        System.out.print("Original array: ");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        
        quick(arr, 0, arr.length - 1);
        
        System.out.print("Sorted array: ");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
