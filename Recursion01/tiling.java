package Recursion01;

public class tiling {
    public static int totalWays(int n) {// 2*n
        if (n == 0 || n == 1) {
            return 1;
        }
        // for vertical tile
        int fnm1 = totalWays(n - 1);
        // for horizontal tile
        int fnm2 = totalWays(n - 2);

        return fnm1 + fnm2;
    }

    public static void main(String[] args) {
        System.out.println(totalWays(6));
    }
}
