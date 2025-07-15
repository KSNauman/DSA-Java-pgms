public class diagonalSum {

    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};
        int sum =0;
        /* 
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if (i == j) {
                    sum += arr[i][j];
                }else if (i+j == arr.length-1) {
                    sum += arr[i][j];
                }
            }
        }
            */
        for(int i=0;i<arr.length;i++){
            sum+= arr[i][i];
            if (i!=arr.length-1-i) {
                sum+= arr[i][arr.length-1-i];
            }
        }
        System.out.println(sum);
    }
}
/*
 * 1. In the first method, if you don't use an "if-else" statement, 
 *    the middle element of the matrix (for odd-sized matrices) might be added twice. 
 *    This happens because the middle element lies on both the main diagonal and the anti-diagonal.
 *
 * 2. To avoid this duplication, we can use the condition `i != arr.length - 1 - i` 
 *    when adding the anti-diagonal elements. 
 *    Here's why:
 *    - On the main diagonal, elements are added when `i == j`. 
 *    - On the anti-diagonal, the column index `j` can be expressed as `arr.length - 1 - i` 
 *      (since `i + j = n - 1` for anti-diagonal elements).
 *    - To skip the middle element in odd-sized matrices, we check `i != arr.length - 1 - i`.
 *
 * By avoiding the second nested loop, we reduce the time complexity from O(n^2) 
 * to O(n), making the algorithm more efficient. 
 * Using the derived equation for `j` directly (`j = arr.length - 1 - i`), 
 * we only need one loop to calculate the sum of both diagonals.
 */
