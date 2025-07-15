import Recursion01.rec;

public class FriendPair {
    public static int fp(int n) {
        // base : if n=1 or n=2
        if (n == 1 || n == 2) {
            return n;
        }
        /*
         * // work
         * int fnm1 = 1 * fp(n - 1);
         * 
         * // work 2
         * int fnm2 = 1 * (n - 1) * fp(n - 2);
         * int totalWays = fnm1 + fnm2;
         * return totalWays;
         */
        return fp(n - 1) + (n - 1) * fp(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fp(3));
    }
}
