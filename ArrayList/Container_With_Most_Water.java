package ArrayList;

import java.util.ArrayList;

public class Container_With_Most_Water {
    public static int storeWater(ArrayList<Integer> height) {
        // O(n^2)
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int h = Math.min(height.get(i), height.get(j));
                int w = j - i;
                int currWater = h * w;
                maxWater = Math.max(maxWater, currWater);
            }
        }

        return maxWater;
        /*
         * in this approch you are gettinh O(n^2)
         * but there is an alternate approch for this question i,e O(n)
         */
    }

    public static int storeWater2(ArrayList<Integer> height) {
        // 2 pointer approch
        // O(n)
        int maxWater = 0;
        int lp = 0, rp = height.size() - 1;

        while (lp < rp) {
            // calculte water area
            int h = Math.min(height.get(lp), height.get(rp));
            int w = rp - lp;
            int currWater = h * w;
            maxWater = Math.max(maxWater, currWater);
            // update ptr
            if (height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        // 1,8,6,2,5,4,8,3,7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storeWater(height));
        System.out.println(storeWater2(height));

    }
}
