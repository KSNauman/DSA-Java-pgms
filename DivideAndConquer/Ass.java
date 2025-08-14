package DivideAndConquer;

public class Ass {
    public static void merge(String arr[], int si, int mid, int ei) {
        // Create a temporary array to hold merged elements
        String temp[] = new String[ei - si + 1];
        // (ei - si + 1) calculates the total number of elements from index si to ei
        // (inclusive)
        // This ensures the temporary array is large enough to hold the merged subarray.
        int i = si; // idx for first sorted part
        int j = mid + 1; // idx for second sorted part
        int k = 0; // idx for temporary array

        // Merge the two sorted parts into the temp array
        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) <= 0) {
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

    public static void sort(String arr[], int si, int ei) {
        if (si >= ei) {
            return; // Base case: array is of length 1 or invalid range
        }
        int mid = si + (ei - si) / 2; // Calculate mid to avoid potential overflow
        sort(arr, si, mid); // Recursively sort the first half
        sort(arr, mid + 1, ei); // Recursively sort the second half

        merge(arr, si, mid, ei); // Merge the two sorted halves
    }

    // Ass2 majorityelement start
    public int major(int[] nums, int lo, int hi) {
        // base case : single element in slice
        if (lo == hi)
            return nums[lo];
        // work
        // dividing part : calc mid and just divide
        int mid = lo + (hi - lo) / 2;
        int left = major(nums, lo, mid);
        int right = major(nums, mid + 1, hi);
        // conquering part : check the majority if disagreements count in the parent
        // sliced part
        // agreed
        if (left == right)
            return left;
        // disagreed
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }

    // CountInRange a helper function which just counts the num in array
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            // checks the each element in the array
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        return major(nums, 0, nums.length - 1);
    }

    // majorityelement end
    public static int count = 0;

    public static int invert(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    // merge sort
    public static void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    // merge
    public static void merge(int[] nums, int lo, int mid, int hi) {
        int[] temp = new int[hi-lo+1];

        int i = lo, j = mid + 1, k = 0;
        while (i <= mid && j <= hi) {
            if (nums[i] > nums[j]) {
                temp[k] = nums[j];
                // we need the count only of left terms
                count += (mid - i + 1);
                j++;
            } else {
                temp[k] = nums[i];
                i++;
            }
            k++;
            // System.out.println("i:"+i+" j:"+j+"k:"+k);
        }
        // rest elements
        if (i > mid) {
            for (int l = j; l <= hi; l++) {
                // System.out.println(" j:"+j);
                // System.out.print(j);
                // System.out.print("k:"+k);
                temp[k] = nums[j];
                k++;
                j++;
            }
        } else {
            for (int l = i; l <= mid; l++) {
                // System.out.println("i:"+i);
                // System.out.print("k:"+k);
                temp[k] = nums[i];
                k++;
                i++;
            }
        }
        // copying
        k = 0;
        for (int l = lo; l <= hi;k++, l++) {
            nums[l] = temp[k];
        }

    }

    public static void main(String[] args) {
        // Q1
        // String[] arr = { "sun", "earth", "mars", "mercury"};
        // sort(arr, 0, arr.length-1);
        // for (String str : arr) {
        // System.out.print(str+" , ");
        // }
        // Q2
        // int[] nums = { 3, 2, 3 };
        // Ass Ass = new Ass();
        // System.out.println(Ass.majorityElement(nums));

        int[] nums = { 2,3,4,5,6 };
        System.out.println(invert(nums));
        // merge(nums, 0, 2, 4);
    }
}
