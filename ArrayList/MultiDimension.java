// package ArrayList;

import java.util.ArrayList;

/**
 * Topic: ArrayList
 * Problem: Multi-Dimensional ArrayList
 * 
 * Description: 
 * Demonstrates how to create, populate, and traverse a 2D ArrayList (ArrayList of ArrayLists).
 * 
 * Intuition:
 * Instead of storing primitive data types, the main ArrayList stores references to other ArrayLists.
 * This allows for jagged arrays (arrays with variable column sizes) and dynamic resizing of both rows and columns.
 * 
 * Complexity: O(N*M) Time, O(N*M) Space.
 */
public class MultiDimension {

    public static void multi() {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        
        for (int i = 1; i <= 5; i++) {
            list1.add(i);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        // Adding the sublists to main list
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        // Traversing the list
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        multi();
    }
}
