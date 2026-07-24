// package Recursion01;

/**
 * Topic: Recursion
 * Problem: Recursion Basics
 * 
 * Description: 
 * Contains several basic recursion problems:
 * 1. Print numbers from 1 to N.
 * 2. Check if an array is sorted in strictly increasing order.
 * 3. Find the first occurrence of an element in an array.
 * 4. Find the last occurrence of an element in an array.
 * 5. Calculate x^n (optimized).
 * 
 * Intuition:
 * 1. Print: Recurse first, then print (unwinding phase).
 * 2. Sorted: Check current adjacent pair, then recurse for the rest of the array.
 * 3. First Occurrence: Check current index, if matched return, else recurse forward.
 * 4. Last Occurrence: Recurse to the end first. Check matches on the way back.
 * 5. Power: Use x^n = x^(n/2) * x^(n/2). If n is odd, multiply by x one more time.
 * 
 * Complexity: 
 * Time: O(N) for array problems, O(log N) for optimized power.
 * Space: O(N) or O(log N) due to recursive call stack.
 */
public class RecursionBasics {
    // 1. Print numbers from 1 to N
    public static void printIncreasing(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printIncreasing(n - 1);
        System.out.print(n + " ");
    }

    // 2. Check if an array is sorted
    public static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    // 3. Find first occurrence
    public static int firstOccurrence(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurrence(arr, key, i + 1);
    }

    // 4. Find last occurrence
    public static int lastOccurrence(int[] arr, int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurrence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    // 5. Optimized Power (O(log n))
    public static int powerOptimized(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int half = powerOptimized(x, n / 2);
        int halfSquared = half * half;
        
        // If n is odd
        if (n % 2 != 0) {
            halfSquared = x * halfSquared;
        }
        return halfSquared;
    }

    public static void main(String[] args) {
        System.out.print("Increasing numbers: ");
        printIncreasing(5);
        System.out.println();
        
        int[] arr = { 1, 2, 3, 3, 4 };
        System.out.println("Is Sorted: " + isSorted(arr, 0));
        System.out.println("First occurrence of 3: " + firstOccurrence(arr, 3, 0));
        System.out.println("Last occurrence of 3: " + lastOccurrence(arr, 3, 0));
        System.out.println("2^5: " + powerOptimized(2, 5));
    }
}
