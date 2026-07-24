/**
 * Topic: Arrays (Part 1)
 * Problem: Reverse an Array
 * 
 * Description: 
 * Reverse the elements of an array in-place.
 * 
 * Intuition:
 * Use a Two-Pointer approach. Maintain a pointer at the beginning and another at the end of the array.
 * Swap the elements at these pointers, then move the pointers towards the center until they meet or cross.
 * 
 * Complexity: O(N) Time, O(1) Space.
 */
public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        
        int f = 0; 
        int l = arr.length - 1;
        
        while (f < l) {
            // Swap elements
            int temp = arr[f];
            arr[f] = arr[l];
            arr[l] = temp;
            
            // Move pointers
            f++;
            l--;
        }
        
        // Print reversed array
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
