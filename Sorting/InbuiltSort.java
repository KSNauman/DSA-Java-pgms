// package Sorting;

import java.util.Arrays;
import java.util.Collections;

/**
 * Topic: Sorting
 * Problem: Inbuilt Sorting in Java
 * 
 * Description: 
 * Demonstrates how to use Java's built-in sorting methods `Arrays.sort()` for both 
 * ascending and descending order.
 * 
 * Intuition:
 * Java provides highly optimized sorting algorithms out of the box (e.g., Dual-Pivot Quicksort 
 * for primitives and TimSort for objects). We can use `Collections.reverseOrder()` to sort in 
 * descending order, but this requires an array of Objects (like `Integer`), not primitives (`int`).
 * 
 * Complexity: 
 * Time: O(N log N) average and worst-case performance.
 * Space: O(log N) or O(N) depending on the underlying sorting algorithm used.
 */
public class InbuiltSort {
    public static void main(String[] args) {
        // Must use Integer (Object), not int (primitive), to use Collections.reverseOrder()
        Integer[] arr = {4, 3, 5, 2, 1};
        
        // Default sort (Ascending)
        // Arrays.sort(arr);
        
        // Sort a specific range (from index 0 to 3 exclusive)
        // Arrays.sort(arr, 0, 3);

        // Sort in Descending Order
        Arrays.sort(arr, Collections.reverseOrder());
        
        System.out.println("Array sorted in descending order using Arrays.sort():");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
