// package Strings;

/**
 * Topic: Strings
 * Problem: Capitalize First Letter of Each Word
 * 
 * Description: 
 * Given a string, capitalize the first letter of each word (Title Case).
 * 
 * Intuition:
 * Use a `StringBuilder` to build the new string efficiently.
 * Capitalize the very first character. Then, iterate through the string.
 * If a space is encountered, append it, and capitalize the next character.
 * Otherwise, append the current character as lowercase (or as is).
 * 
 * Complexity: O(N) Time, O(N) Space.
 */
public class CapitalizeFirstLetter {
    public static String toTitleCase(String str) {
        if (str == null || str.length() == 0) return "";
        
        StringBuilder sb = new StringBuilder("");
        // Capitalize the first character
        sb.append(Character.toUpperCase(str.charAt(0)));
        
        for (int i = 1; i < str.length(); i++) {
            // If previous character was a space, capitalize current
            if (str.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(str.charAt(i)));
            }
        }
        return sb.toString();
    }  
    
    public static void main(String[] args) {
        String st = "hi, my name is NAUMAN";
        System.out.println("Original: " + st);
        System.out.println("Title Case: " + toTitleCase(st));
    }  
}
