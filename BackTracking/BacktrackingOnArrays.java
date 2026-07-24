// package BackTracking;

/**
 * Topic: Backtracking
 * Problem: Backtracking on Arrays
 * 
 * Description: 
 * A simple demonstration of backtracking on an array. We populate the array during 
 * the recursive calls, print it at the base case, and then modify (backtrack) the 
 * values while returning from the recursive stack.
 * 
 * Intuition:
 * As we go deeper into recursion (moving forward), we assign a value to the current index.
 * Upon hitting the base case (end of array), we start returning. During this return phase 
 * (backtracking), we modify the array element again. This demonstrates how state changes 
 * can be undone/modified after exploring a path.
 * 
 * Complexity: O(N) Time, O(N) Space (for call stack).
 */
public class BacktrackingOnArrays {
    public static void changeArr(int[] arr, int i, int val) {
        // Base case
        if (i == arr.length) {
            printarr(arr);
            return;
        }
        
        // Forward operation (Assign value)
        arr[i] = val;
        
        // Recursive call
        changeArr(arr, i + 1, val + 1);
        
        // Backtracking operation (Modify value on return)
        arr[i] = arr[i] - 2;
    }

    public static void printarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr, 0, 1);
        printarr(arr);
    }
}
