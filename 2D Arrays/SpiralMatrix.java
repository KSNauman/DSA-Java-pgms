public class SpiralMatrix {
    public static void funt(int[][] ar){
            int sr=0, sc=0;
            int er=ar.length-1;
            int ec=ar[0].length-1;
            while (sr <= er && sc<= ec) {
                // printing of first row traversing from sc to ec
                for(int j = sc;j<=ec;j++){
                    System.out.print(ar[sr][j]+" ");
                }
                // last column
                for(int i=sr+1;i<= er;i++){
                    System.out.print(ar[i][ec]+" ");
                }
                // last row
                for(int i=ec-1;i>= sc;i--){
                    if (sr == er) {
                        return;
                    }
                    System.out.print(ar[er][i]+" ");
                }
                // first column
                for(int i=er-1;i>=sr+1;i--){
                    if (sc == ec) {
                        return;                        
                    }
                    System.out.print(ar[i][sc]+" ");
                }
    
                sr++;
                sc++;
                er--;
                ec--;
            }
        }
        public static void main(String[] args) {
            int arr[][]={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
            funt(arr);
    }
}
/*
 * while (sr <= er && sc <= ec)
 * This condition is used because we need to handle matrices that may not be square 
 * (e.g., rectangular matrices with different numbers of rows and columns). 
 * Either the remaining rows or columns could determine when to stop the spiral traversal.
 * 
 * 2. Handling edge cases (e.g., non-square matrices):
 *    - When printing the **last row**, ensure that the current row (`sr`) is not the same as the
 *      bottom row (`er`). This avoids reprinting the same row when the matrix has only one row 
 *      remaining in a particular layer.
 *    - When printing the **first column**, ensure that the current column (`sc`) is not the same
 *      as the rightmost column (`ec`). This avoids reprinting the same column when only one 
 *      column remains.
 * 
 *    This ensures that each element of the matrix is printed only once, regardless of whether 
 *    the matrix is square or rectangular.
 */
