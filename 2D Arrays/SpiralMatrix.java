/**
 * Topic: 2D Arrays
 * Problem: Spiral Matrix
 * 
 * Description: 
 * Print a given matrix in spiral order (outer layer, then inner layers).
 * 
 * Intuition:
 * We define four boundaries: starting row, ending row, starting col, ending col.
 * We traverse the top row, right col, bottom row, and left col of the current boundary,
 * then shrink the boundary inwards and repeat.
 * We add conditions to avoid printing the same row/col twice in edge cases (e.g. non-square matrices).
 * 
 * Complexity: O(N*M) Time, O(1) Space.
 */
public class SpiralMatrix {
    public static void funt(int[][] ar){
        int sr = 0, sc = 0;
        int er = ar.length - 1;
        int ec = ar[0].length - 1;
        
        while (sr <= er && sc <= ec) {
            // Top row
            for(int j = sc; j <= ec; j++){
                System.out.print(ar[sr][j] + " ");
            }
            // Right column
            for(int i = sr + 1; i <= er; i++){
                System.out.print(ar[i][ec] + " ");
            }
            // Bottom row
            for(int i = ec - 1; i >= sc; i--){
                if (sr == er) return; // avoid duplicate print
                System.out.print(ar[er][i] + " ");
            }
            // Left column
            for(int i = er - 1; i >= sr + 1; i--){
                if (sc == ec) return; // avoid duplicate print
                System.out.print(ar[i][sc] + " ");
            }

            sr++;
            sc++;
            er--;
            ec--;
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12},
                       {13,14,15,16}};
        funt(arr);
    }
}
