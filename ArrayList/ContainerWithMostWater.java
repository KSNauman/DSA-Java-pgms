// package ArrayList;

import java.util.ArrayList;

/**
 * Topic: ArrayList
 * Problem: Container With Most Water
 * 
 * Description: 
 * Given an array of heights, find two lines that together with the x-axis form a container, 
 * such that the container contains the most water.
 * 
 * Intuition:
 * Use a Two-Pointer approach. Start with the maximum width (lp at 0, rp at end).
 * Calculate the area. Move the pointer pointing to the shorter line inward, 
 * as the height of the container is limited by the shorter line, and moving it 
 * is the only way to potentially find a taller line to compensate for the reduced width.
 * 
 * Complexity: O(N) Time, O(1) Space.
 */
public class ContainerWithMostWater {
    public static int storeWater(ArrayList<Integer> height) {
        // Brute Force: O(n^2)
        int maxWater = 0;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int h = Math.min(height.get(i), height.get(j));
                int w = j - i;
                maxWater = Math.max(maxWater, h * w);
            }
        }
        return maxWater;
    }

    public static int storeWater2(ArrayList<Integer> height) {
        // Two-Pointer Approach: O(n)
        int maxWater = 0;
        int lp = 0, rp = height.size() - 1;

        while (lp < rp) {
            int h = Math.min(height.get(lp), height.get(rp));
            int w = rp - lp;
            maxWater = Math.max(maxWater, h * w);
            
            // Move the pointer of the smaller height
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
        // Heights: 1, 8, 6, 2, 5, 4, 8, 3, 7
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        for (int h : arr) {
            height.add(h);
        }
        System.out.println("Brute Force: " + storeWater(height));
        System.out.println("Optimized: " + storeWater2(height));
    }
}
