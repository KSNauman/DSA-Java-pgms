import java.util.*;

/**
 * Topic: 2D Arrays
 * Problem: Matrix Basics
 * 
 * Description: 
 * Basic operations for declaring, taking input for, and printing a 2D matrix.
 * 
 * Intuition:
 * A 2D matrix in Java is essentially an array of arrays. We can use nested loops 
 * to traverse it row by row.
 * 
 * Complexity: O(N*M) Time, O(N*M) Space.
 */
public class MatrixBasics {
    public static void main(String[] args) {
        int mat[][] = new int[3][3];
        int n = mat.length;
        int m = mat[0].length;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Matrix:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
