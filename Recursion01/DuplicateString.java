package Recursion01;

public class DuplicateString {
    public static void rmdp(String str, StringBuilder newStr, int idx, boolean[] map) {
        // Base case: If the index reaches the end of the string, print the result
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char curr = str.charAt(idx); // Get the current character of the string

        // Check if the current character is already marked as duplicate in the map
        if (map[curr - 'a']) {
            // If true, skip the current character and move to the next character in the
            // string
            rmdp(str, newStr, idx + 1, map);
        } else {
            // If the current character is not a duplicate:
            // Mark it as duplicate in the map
            map[curr - 'a'] = true;
            // Append the current character to the new string
            rmdp(str, newStr.append(curr), idx + 1, map);
        }
    }

    public static void main(String[] args) {
        String str = "appnnacollege"; // Input string
        rmdp(str, new StringBuilder(""), 0, new boolean[26]); // Start recursion with an empty StringBuilder and a
                                                              // boolean array for duplicate tracking
    }
}
