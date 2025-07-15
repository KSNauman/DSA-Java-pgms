package ArrayList;

import java.util.ArrayList;

public class MultiDimension {

    public static void multi() {
        /*
         * Goal:
         * list1: 1 2 3 4 5
         * list2: 2 4 6 8 10
         * list3: 3 6 9 12 15
         */

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();// this holds all the sub lists
        /*
         * // sub lists
         * ArrayList<Integer> list1 = new ArrayList<>();
         * list1.add(1);
         * list1.add(2);
         * list1.add(3);
         * list1.add(4);
         * list1.add(5);
         * 
         * ArrayList<Integer> list2 = new ArrayList<>();
         * list2.add(2);
         * list2.add(4);
         * list2.add(6);
         * list2.add(8);
         * list2.add(10);
         * 
         * ArrayList<Integer> list3 = new ArrayList<>();
         * list3.add(3);
         * list3.add(6);
         * list3.add(9);
         * list3.add(12);
         * list3.add(15);
         * 
         * 
         */
        /*
         * instead of doing the above step
         */
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list1.add(i);
            list2.add(i * 2);
            list3.add(i * 3);
        }

        // Adding the sublist to main list
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        // Traversing in the list
        for (int i = 0; i < mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for (int j = 0; j < currList.size(); j++) {
                System.out.print(currList.get(j) + " ");
            }
            System.out.println();
        }

        System.out.println(mainList);
    }

    public static void main(String[] args) {
        multi();
    }
}
