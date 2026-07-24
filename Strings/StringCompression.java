// package Strings;

/**
 * Topic: Strings
 * Problem: String Compression
 * 
 * Description: 
 * Compress a string by replacing consecutive duplicate characters with the character 
 * followed by the count of duplicates. (e.g., "aaabbbccd" -> "a3b3c2d").
 * 
 * Intuition:
 * Iterate through the string. For each character, count how many times it repeats 
 * consecutively. Append the character to a `StringBuilder`, and if the count > 1, 
 * append the count.
 * 
 * Complexity: O(N) Time, O(N) Space.
 */
public class StringCompression {
    public static String compress(String str) {
        StringBuilder sb = new StringBuilder("");
        
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            
            // Count consecutive duplicates
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            
            sb.append(str.charAt(i));
            
            // Only append count if > 1
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaabbbccd";
        System.out.println("Original: " + str);
        System.out.println("Compressed: " + compress(str));
    }
}
