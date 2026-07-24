/**
 * Topic: Arrays (Part 1)
 * Problem: Print Subarrays
 * 
 * Description: 
 * Prints all possible subarrays of a given array and counts the total number of subarrays.
 * 
 * Intuition:
 * Use three nested loops. The outer loop selects the starting index (i). 
 * The middle loop selects the ending index (j). 
 * The inner loop iterates from i to j to print the subarray elements.
 * 
 * Complexity: O(N^3) Time, O(1) Space.
 */
public class PrintSubarrays {
    public static void sub(int[] arr) {
        int totalSubarrays = 0;
        
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = i; j <= arr.length - 1; j++) {
                // Print elements in the current subarray
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                totalSubarrays++;
                System.out.println();
            }
            System.out.println(); // Separate subarrays starting with different elements
        }
        
        System.out.println("Total Subarrays: " + totalSubarrays);
        // Can also be calculated mathematically as: n * (n + 1) / 2
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        sub(arr);
    }
}
