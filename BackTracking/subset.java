package BackTracking;

public class subset {
    public static void findSubsets(String str, int i, String ans) {
        // base case
        if (i == str.length()) {
            System.out.println(ans);
            return;
        }
        // yes choice
        findSubsets(str, i + 1, ans + str.charAt(i));
        // no choice
        findSubsets(str, i + 1, ans);
    }

    public static void main(String[] args) {
        findSubsets("abc", 0, " ");
    }
}
