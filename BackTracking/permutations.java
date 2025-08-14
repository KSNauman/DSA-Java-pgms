package BackTracking;

// permutations : for n length there exist n! permutations
public class permutations {
    public static void findPerpu(String str, String ans) {
        // base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        // work
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // "abcde" => "ab"+"de"
            String newStr = str.substring(0, i) + str.substring(i + 1);
            findPerpu(newStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        findPerpu("abc", " ");
    }
}