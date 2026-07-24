/**
 * Topic: 2D Arrays
 * Problem: Staircase Search (Search in a row-wise and column-wise sorted matrix)
 * 
 * Description: 
 * Search for a target key in an NxM matrix where every row and column is sorted in increasing order.
 * 
 * Intuition:
 * Start from the top-right corner.
 * If the current element is equal to the key, we found it.
 * If the key is smaller, move left (col--).
 * If the key is greater, move down (row++).
 * 
 * Complexity: O(N + M) Time, O(1) Space.
 */
public class StaircaseSearch {
    public static void Staircase(int[][] arr, int key) {
        int row = 0, col = arr[0].length - 1;
        while (row < arr.length && col >= 0) {
            if (key == arr[row][col]) {
                System.out.println("(" + row + "," + col + ")");
                return;
            }
            if (key < arr[row][col]) {
                col--;
            } else if (key > arr[row][col]) {
                row++;
            }
        }
        System.out.println("Element not found");
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12},
                       {13,14,15,16}};    
        Staircase(arr, 14);
    }
}