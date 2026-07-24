// package HashMap;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Topic: Hashing
 * Problem: Count Distinct Elements
 * 
 * Description: 
 * Given an array of integers, count the number of distinct elements.
 * 
 * Intuition:
 * A HashSet only stores unique elements. If we add all elements from the array into a HashSet,
 * the duplicates will be ignored, and the size of the HashSet will give the number of distinct elements.
 * 
 * Complexity: O(N) Time to traverse the array, O(N) Space for HashSet.
 */
public class CountDistinctElements {
    public static void main(String[] args) {
        int[] num = {4, 3, 3, 2, 3, 5, 1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 2, 1, 4, 5};
        
        HashSet<Integer> set = new HashSet<>();
        for (int i : num) {
            set.add(i);
        }
        
        System.out.println("Number of distinct elements: " + set.size());
        
        // Iteration using enhanced for-loop
        System.out.print("Distinct elements: ");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Iteration using Iterator
        System.out.print("Distinct elements using Iterator: ");
        Iterator<Integer> i = set.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }
}
