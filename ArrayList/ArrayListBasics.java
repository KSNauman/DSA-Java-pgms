// package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Topic: ArrayList
 * Problem: ArrayList Basics
 * 
 * Description: 
 * Demonstrates basic operations of an ArrayList in Java including 
 * adding, getting, setting, deleting, reversing, finding maximum, 
 * swapping, and sorting (ascending and descending).
 * 
 * Intuition:
 * ArrayList is a resizable array. It automatically grows its size when elements are added.
 * We can use Collections.sort() for sorting, and standard methods for basic array operations.
 * 
 * Complexity: O(N) Time for traversal/max/reverse, O(N log N) Time for sorting. Space varies.
 */
public class ArrayListBasics {
    public static void CreationAndOperations() {
        ArrayList<Integer> list = new ArrayList<>();
        // 1. Adding O(1) or O(N)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(1, 9);
        
        // 2. Get element O(1)
        int ele = list.get(2);
        
        // 3. Delete element O(N)
        list.remove(0);
        
        // 4. Set element O(1)
        list.set(0, 3);
        
        // 5. Contains element O(N)
        list.contains(3);
    }

    public static void sizeOf() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void Reverse() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);
        for (int i = (list.size() - 1); i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void Max() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2); list.add(5); list.add(9); list.add(3); list.add(6);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        System.out.println(max);
    }

    public static void Swap2Num() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2); list.add(5); list.add(9); list.add(3); list.add(6);
        
        int idx1 = 1, idx2 = 3;
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

        System.out.println(list);
    }

    public static void Sort() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2); list.add(5); list.add(9); list.add(3); list.add(6);
        
        Collections.sort(list); // Ascending
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder()); // Descending
        System.out.println(list);
    }

    public static void main(String[] args) {
        CreationAndOperations();
        sizeOf();
        Reverse();
        Max();
        Swap2Num();
        Sort();
    }
}
