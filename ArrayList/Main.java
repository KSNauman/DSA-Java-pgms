package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void CreationAndOperations() {
        // syntax to define Arraylist
        // Classname obj = new Classname();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();
        // Operations
        // 1. Addinig O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        // O(n)
        list.add(1, 9);
        System.out.println(list);
        // 2. get element O(1)
        int ele = list.get(2);
        System.out.println(ele);

        // 3. Delete ele O(n)
        list.remove(0);
        System.out.println(list);

        // 4. set ele at index O(n)
        list.set(0, 3);
        System.out.println(list);

        // 5. Contains element O(n)
        System.out.println(list.contains(3));
        System.out.println(list.contains(11));
    }

    public static void sizeOf() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // this .size() is a function where as in array there was length attributes not
        // a function
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void Reverse() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        // just the simple method O(n)
        for (int i = (list.size() - 1); i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void Max() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            // if (list.get(i) > max) {
            // max = list.get(i);
            // }
            max = Math.max(max, list.get(i));
        }
        if (max != Integer.MIN_VALUE) {
            System.out.println(max);
        }
    }

    public static void Swap2Num() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        // Indices are given
        int idx1 = 1, idx2 = 3;
        /*
         * store idx1 value int temp
         * set idx1 value with idx2
         * set idx2 value with temp
         */
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

        System.out.println(list);
    }

    public static void Sort() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        System.out.println(list);
        /*
         * there is an inbuilt sorting method in Collections class
         * note : Collections not Collection as Collection is interface and Collections
         * is class
         */
        Collections.sort(list);

        System.out.println("Sorted in Ascending order");
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder());
        // Collections.reverseOrder() this is an comparator
        
        System.out.println("Sorted in Descending order");
        System.out.println(list);
    }

    public static void main(String[] args) {
        // CreationAndOperations();
        // sizeOf();
        // Reverse();
        // Max();
        // Swap2Num();
        Sort();

    }
}
