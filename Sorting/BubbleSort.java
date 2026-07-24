// package Sorting;

/**
 * Topic: Sorting
 * Problem: Bubble Sort
 * 
 * Description: 
 * Sort an array of integers using the Bubble Sort algorithm.
 * 
 * Intuition:
 * The core idea is to repeatedly swap adjacent elements if they are in the wrong order.
 * In each pass, the largest unsorted element "bubbles up" to its correct position at the end.
 * An optimization is added where if no swaps occur in a full pass, the array is already sorted,
 * and we can terminate early.
 * 
 * Complexity: 
 * Time: O(N^2) in the worst and average cases. O(N) in the best case (already sorted).
 * Space: O(1).
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapped = true;
                }
            }
            // If no swaps occurred, the array is sorted
            if (!isSwapped) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 3, 1, 5};
        
        System.out.println("Original Array:");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        
        arr = bubbleSort(arr);
        
        System.out.println("Sorted Array (Bubble Sort):");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
