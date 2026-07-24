// package Trie;

/**
 * Topic: Trie
 * Problem: Trie Implementation (Insert and Search)
 * 
 * Description: 
 * Implement a Trie (Prefix Tree) data structure with basic insert and search operations.
 * 
 * Intuition:
 * A Trie is a tree-like data structure where each node represents a character. 
 * Root is an empty entry point. Each node contains an array of 26 references to child nodes 
 * (for a-z) and a boolean `eow` (End of Word) marking word termination.
 * Nodes are created lazily (only when needed). Paths represent prefixes, not words themselves.
 * 
 * Complexity: 
 * Insert: O(L) Time (L = length of word), O(L) Space.
 * Search: O(L) Time, O(1) Space.
 */
public class TrieImplementation {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false; // End of Word

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    
    public static Node root = new Node();
    
    // Insert a word into the Trie
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    
    // Search a word in the Trie
    public static boolean search(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }
    
    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee"};
        
        System.out.println("Inserting words into Trie: ");
        for (String str : words) {
            insert(str);
            System.out.print(str + " ");
        }
        System.out.println("\n");
        
        System.out.println("Search 'there': " + search("there"));
        System.out.println("Search 'any': " + search("any"));
        System.out.println("Search 'an': " + search("an")); // prefix exists, but not a word
        System.out.println("Search 'thor': " + search("thor"));
    }
}