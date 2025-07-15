package Strings;
import java.util.Arrays;
public class Anagram {
    public static void main(String[] args) {
        String str1 = "race";
        String str2 = "care";

        String strLower = str1.toLowerCase();
        char[] charStr = strLower.toCharArray();
        Arrays.sort(charStr);
        char[] charStr2 = str2.toLowerCase().toCharArray();
        Arrays.sort(charStr2);
        boolean result = Arrays.equals(charStr, charStr2);
        if (result) {
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
