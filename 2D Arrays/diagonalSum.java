/**
 * Topic: 2D Arrays
 * Problem: Diagonal Sum
 * 
 * Description: 
 * Calculate the sum of elements on the main diagonal and the anti-diagonal of an NxN matrix.
 * 
 * Intuition:
 * The main diagonal elements have indices where i == j.
 * The anti-diagonal elements have indices where i + j == N - 1, which means j = N - 1 - i.
 * To avoid adding the center element twice in an odd-sized matrix, we ensure i != j for the anti-diagonal.
 * 
 * Complexity: O(N) Time, O(1) Space.
 */
public class DiagonalSum {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12},
                       {13,14,15,16}};
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            // Add primary diagonal element
            sum += arr[i][i];
            
            // Add secondary diagonal element, avoiding double counting the center element
            if (i != arr.length - 1 - i) {
                sum += arr[i][arr.length - 1 - i];
            }
        }
        System.out.println(sum);
    }
}
