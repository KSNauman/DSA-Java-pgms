// package Sorting;

/**
 * Topic: Sorting
 * Problem: Counting Sort
 * 
 * Description: 
 * Sort an array of non-negative integers using the Counting Sort algorithm.
 * 
 * Intuition:
 * Counting Sort works by counting the occurrences of each unique element in the array.
 * We find the maximum element to determine the size of our frequency/count array.
 * We populate the count array, then overwrite the original array by placing elements 
 * based on their counts. This works exceptionally well when the range of elements is small.
 * 
 * Complexity: 
 * Time: O(N + K) where N is the number of elements and K is the range (max element).
 * Space: O(K) for the count array.
 */
public class CountingSort {
    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Frequency array
        int[] count = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Reconstruct the sorted array
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 3, 2, 4, 3, 7};
        
        System.out.println("Original Array:");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        
        countingSort(arr);
        
        System.out.println("Sorted Array (Counting Sort):");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
