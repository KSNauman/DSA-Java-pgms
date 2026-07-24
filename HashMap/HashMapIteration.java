// package HashMap;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Topic: Hashing
 * Problem: HashSet Iteration
 * 
 * Description: 
 * Iterate through the elements of a HashSet using an Iterator.
 * 
 * Intuition:
 * HashSets do not maintain insertion order (unless it's a LinkedHashSet).
 * An Iterator provides a way to traverse the elements sequentially without exposing 
 * the underlying representation.
 * 
 * Complexity: O(N) Time for iteration, O(N) Space to store elements.
 */
public class HashMapIteration {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");

        System.out.println("Iterating through HashSet:");
        Iterator<String> i = set.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}