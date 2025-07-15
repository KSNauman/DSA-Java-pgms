//package 2D Arrays;
import java.util.*;
public class matrix {
    public static void main(String[] args) {
        int mat[][]= new int[3][3];
        int n=mat.length;
        int m=mat[0].length;
        Scanner sc =  new Scanner(System.in);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+' ');
            }
            System.out.println();
        }
    }
}
