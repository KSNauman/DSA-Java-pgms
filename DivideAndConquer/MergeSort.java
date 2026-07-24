// package DivideAndConquer;

/**
 * Topic: Divide And Conquer
 * Problem: Merge Sort
 * 
 * Description: 
 * Sort an array using the Merge Sort algorithm.
 * 
 * Intuition:
 * 1. Divide: Recursively divide the array into two halves until each subarray contains a single element.
 * 2. Conquer: Merge the two sorted halves back together into a single sorted array.
 * 3. Use a temporary array during the merge step to hold the sorted elements before copying them back.
 * 
 * Complexity: 
 * O(N log N) Time for all cases (Best, Average, Worst).
 * O(N) Space due to the temporary array used in the merge step.
 */
public class MergeSort {
    public static void merge(int arr[], int si, int mid, int ei) {
        // Create a temporary array to hold merged elements
        int temp[] = new int[ei - si + 1];
        
        int i = si;       // idx for first sorted part
        int j = mid + 1;  // idx for second sorted part
        int k = 0;        // idx for temporary array

        // Merge the two sorted parts into the temp array
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        // Add left over elements of left sorted part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        // Merge remaining elements of right sorted part, if any
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        
        // Copy the merged elements back into the original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void sort(int arr[], int si, int ei) {
        if (si >= ei) {
            return; // Base case
        }
        int mid = si + (ei - si) / 2; // Calculate mid to avoid overflow
        sort(arr, si, mid); // Sort first half
        sort(arr, mid + 1, ei); // Sort second half
        merge(arr, si, mid, ei); // Merge them
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 9, 5, 2, 8 };
        System.out.print("Original array: ");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        
        sort(arr, 0, arr.length - 1);
        
        System.out.print("Sorted array: ");
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
