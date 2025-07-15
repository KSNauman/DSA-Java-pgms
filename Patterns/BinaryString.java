public class BinaryString {
    public static void PBS(int n, int lp, String str) {
        // base
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // work
        if (lp == 0) {
            PBS(n - 1, 0, str + "0");
            PBS(n - 1, 1, str + "1");
        } else {
            PBS(n - 1, 0, str + "0");
        }
    }

    public static void main(String[] args) {
        PBS(3, 0, "");
    }
}
