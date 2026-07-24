// package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Topic: Queue
 * Problem: First Non-Repeating Letter in a Stream
 * 
 * Description: 
 * Given a stream of characters, find the first non-repeating character for each new character added.
 * 
 * Intuition:
 * Maintain a frequency array for the characters. Use a Queue to keep track of the order of characters.
 * As characters arrive, add them to the queue and increment their frequency.
 * If the front of the queue has a frequency > 1, it's repeating, so we remove it.
 * Repeat this until the queue is empty or the front character has a frequency of 1.
 * 
 * Complexity: O(N) Time since each character is enqueued and dequeued at most once. O(1) Space (Queue size bounded by 26).
 */
public class FirstNonRepeatingLetter {
    public static void printNonRepeating(String str) {
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            // Remove all characters from the front of the queue that are repeating
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // The front of the queue is the first non-repeating character
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        String str = "aabccxb";
        System.out.print("Stream: " + str + "\nFirst non-repeating: ");
        printNonRepeating(str);
    }
}