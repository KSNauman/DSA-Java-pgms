// package HashMap;

import java.util.HashMap;
import java.util.Set;

/**
 * Topic: Hashing
 * Problem: HashMap Basics
 * 
 * Description: 
 * Basic operations of a HashMap: Insertion, Retrieval, and Iteration.
 * 
 * Intuition:
 * HashMap stores elements in Key-Value pairs. Keys are unique, and each key maps to exactly one value.
 * We can iterate over a HashMap by retrieving its KeySet and then getting the value for each key.
 * 
 * Complexity: O(1) Time average for put/get. O(N) Space for storing elements.
 */
public class HashMapBasics {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        // Insertion
        hm.put("A", 10);
        hm.put("B", 20);
        hm.put("C", 300);
        hm.put("D", 40);
        
        System.out.println("HashMap: " + hm);

        // Iteration
        Set<String> st = hm.keySet();
        for (String s : st) {
            System.out.println("Key: " + s + ", Value: " + hm.get(s));   
        }
    }   
}
