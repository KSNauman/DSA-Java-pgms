package Recursion01;

public class Consecutive1s {
    public static void printBinStr(int n,int lastplace, String str){
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // main work
        printBinStr(n-1, 0, str+"0");
        if (lastplace == 0) {
            printBinStr(n-1, 1, str+="1");
        }
    }
    public static void main(String[] args) {
        printBinStr(3, 0, "");
    }
}
