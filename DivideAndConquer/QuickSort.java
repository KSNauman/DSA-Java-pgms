package DivideAndConquer;

public class QuickSort {
    public static void quick(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pIdx = partition(arr, si, ei);
        quick(arr, si, pIdx - 1);
        quick(arr, pIdx + 1, ei);
    }

    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        // for traversing ele less thn pivot
        // int i=-1;//not always negative as its recurdive it maybe diff
        int i = si - 1;
        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;// replacing the pivot
        int temp = arr[ei];
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 3, 9, 8, 2, 5 };
        quick(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

// Summary:
// QuickSort is a Divide and Conquer algorithm that works as follows:
// 1. It picks a pivot element (here, the last element in the subarray).
// 2. The `partition` function rearranges the array so that:
// - All elements smaller than or equal to the pivot are on the left.
// - All elements greater than the pivot are on the right.
// - The pivot is placed in its correct sorted position.
// 3. Recursively applies QuickSort to the subarrays to the left and right of
// the pivot.
//
// Complexity:
// - Best and Average Case: O(n log n) (when the pivot splits the array into two
// equal parts).
// - Worst Case: O(n^2) (when the pivot is always the smallest or largest
// element, e.g., sorted arrays).
// - Space Complexity: O(log n) due to recursive calls.
//
// Notes:
// - The algorithm is not stable, meaning it may not preserve the relative order
// of equal elements.
// - It's efficient for large datasets and often faster in practice than other
// algorithms like MergeSort.
