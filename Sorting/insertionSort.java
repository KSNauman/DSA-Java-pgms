// package Sorting;

/**
 * Topic: Sorting
 * Problem: Insertion Sort
 * 
 * Description: 
 * Sort an array of integers using the Insertion Sort algorithm.
 * 
 * Intuition:
 * The array is virtually split into a sorted and an unsorted part. 
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 * We pick the `curr` element and compare it with the elements before it, shifting larger elements 
 * one position to the right to make space for the `curr` element.
 * 
 * Complexity: 
 * Time: O(N^2) in the worst/average cases. O(N) in the best case (already sorted).
 * Space: O(1).
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        // Start from the second element, assume first is sorted
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            
            // Shift elements of the sorted segment that are greater than `curr`
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            
            // Insert `curr` in its correct position
            arr[prev + 1] = curr;   
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 1, 2};
        
        System.out.println("Original Array:");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        
        insertionSort(arr);
        
        System.out.println("Sorted Array (Insertion Sort):");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}