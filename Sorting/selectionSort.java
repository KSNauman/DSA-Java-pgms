// package Sorting;

/**
 * Topic: Sorting
 * Problem: Selection Sort
 * 
 * Description: 
 * Sort an array of integers using the Selection Sort algorithm.
 * 
 * Intuition:
 * Unlike Bubble Sort which does multiple swaps per pass, Selection Sort finds the index 
 * of the minimum element in the unsorted portion of the array and swaps it with the first 
 * element of the unsorted portion. This reduces the total number of swaps to at most N-1.
 * 
 * Complexity: 
 * Time: O(N^2) in all cases (best, average, worst).
 * Space: O(1).
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            // Find the minimum element in the unsorted array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    } 
    
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1};
        
        System.out.println("Original Array:");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        
        selectionSort(arr);
        
        System.out.println("Sorted Array (Selection Sort):");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }   
}
