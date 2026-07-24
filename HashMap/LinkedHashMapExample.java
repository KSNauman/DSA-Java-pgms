// package HashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * Topic: Hashing
 * Problem: HashMap vs LinkedHashMap vs TreeMap
 * 
 * Description: 
 * Demonstrates the difference between different Map implementations in Java.
 * 
 * Intuition:
 * - HashMap: Stores elements in an arbitrary order (based on hash). O(1) ops.
 * - LinkedHashMap: Maintains the insertion order of elements using a doubly linked list. O(1) ops.
 * - TreeMap: Stores elements in sorted order of their keys using a Red-Black Tree. O(log N) ops.
 * 
 * Complexity: O(1) Time for HashMap/LinkedHashMap, O(log N) Time for TreeMap. Space: O(N).
 */
public class LinkedHashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        TreeMap<String, Integer> tm = new TreeMap<>();
        
        // HashMap: Order is not guaranteed
        hm.put("B", 20);
        hm.put("A", 10);
        hm.put("C", 30);

        // LinkedHashMap: Insertion order is maintained
        lhm.put("B", 20);
        lhm.put("A", 10);
        lhm.put("C", 30);
        
        // TreeMap: Sorted by key naturally
        tm.put("B", 20);
        tm.put("A", 10);
        tm.put("C", 30);

        System.out.println("HashMap Output (Arbitrary Order): " + hm);
        System.out.println("LinkedHashMap Output (Insertion Order): " + lhm);
        System.out.println("TreeMap Output (Sorted Order): " + tm);
    }
}
