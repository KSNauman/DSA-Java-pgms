package ArrayList;

import java.util.ArrayList;

public class Pair {
    public static boolean pairSum1(ArrayList<Integer> list, int target) {
        // 0(n^2)
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairSum2(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size() - 1;

        while (lp != rp) {
            // case1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 1,2,3,4,5,6
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target = 50;

        System.out.println(pairSum1(list, target));
        System.out.println(pairSum2(list, target));
    }
}
/* 
 * find if any pair in SORTED Arraylist has a target sum 
 */