package DivideAndConquer;

public class MergeSort {
    public static void merge(int arr[], int si, int mid, int ei) {
        // Create a temporary array to hold merged elements
        int temp[] = new int[ei - si + 1];
        // (ei - si + 1) calculates the total number of elements from index si to ei (inclusive)
    // This ensures the temporary array is large enough to hold the merged subarray.
        int i = si; // idx for first sorted part
        int j = mid + 1; // idx for second sorted part
        int k = 0; // idx for temporary array

        // Merge the two sorted parts into the temp array
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // for left over elements of left sorted part
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
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
            return; // Base case: array is of length 1 or invalid range
        }
        int mid = si + (ei - si) / 2; // Calculate mid to avoid potential overflow
        sort(arr, si, mid); // Recursively sort the first half
        sort(arr, mid + 1, ei); // Recursively sort the second half

        merge(arr, si, mid, ei); // Merge the two sorted halves
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 9 };
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

/*
 * Multi-line Comment (For Revision):
 * - merge() function:
 * Merges two sorted subarrays: one from index 'si' to 'mid', and the other from
 * 'mid+1' to 'ei'.
 * Uses a temporary array to store merged elements and then copies them back.
 * - sort() function:
 * Recursively divides the array into two halves.
 * Merges sorted halves using the merge() function.
 * - Overall, this implementation of MergeSort achieves O(n log n) time
 * complexity.
 * - main() demonstrates sorting a sample array.
 */
