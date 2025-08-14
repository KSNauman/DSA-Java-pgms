package Recursion01;

public class Assignment {
    // Ass1
    // Question 1 : For a given integer array of size N. You have to find all the
    // occurrences
    // (indices) of a given element (Key) and print them. Use a recursive function
    // to solve this
    // problem.
    public static void Ass1(int i, int[] arr, int key) {
        // base case
        if (i == arr.length) {
            return;
        }
        // work to be done
        if (arr[i] == key) {
            System.out.print(i + " ");
        }
        Ass1(i + 1, arr, key);
    }
    static String[] digits = {"zero","one","two","three","four","five","six","seven","eight","nine"}; 
    public static void Ass2(int n){
        // base case
        if (n == 0) {
            return;
        }
        // work 
        int ld = n%10;
        Ass2(n/10);
        System.out.print(digits[ld]+" ");
    }
    public static void main(String[] args) {
        Ass1(0, new int[]{3, 2, 4, 5, 6, 2, 7, 2, 2}, 2);
        Ass2(1947);
    }
}
