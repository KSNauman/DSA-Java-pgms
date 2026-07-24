/**
 * Topic: Arrays (Part 2)
 * Problem: Trapping Rainwater
 * 
 * Description: 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 * 
 * Intuition:
 * The water trapped above any bar depends on the maximum height of bars to its left and right.
 * 1. Calculate Left Max Boundary (LMB) array.
 * 2. Calculate Right Max Boundary (RMB) array.
 * 3. Water level = min(LMB[i], RMB[i]). Trapped water = (Water level - height[i]) * width.
 * 
 * Complexity: O(N) Time, O(N) Space.
 */
public class TrappingRainwater {
    public static int TWF(int[] height) {
        int n = height.length;
        
        // Base cases
        if (n <= 2) {
            System.out.println("Oops, water spilled out");
            return 0;
        }

        // 1. Left max boundary array (LMB)
        int[] LMB = new int[n];
        LMB[0] = height[0];
        for (int i = 1; i < n; i++) {
            LMB[i] = Math.max(height[i], LMB[i - 1]);
        }

        // 2. Right max boundary array (RMB)
        int[] RMB = new int[n];
        RMB[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            RMB[i] = Math.max(height[i], RMB[i + 1]);
        }

        // 3. Calculate trapped water
        int tw = 0;
        for (int i = 0; i < n; i++) {
            int wl = Math.min(LMB[i], RMB[i]);
            tw += wl - height[i];
        }
        
        return tw;
    }

    public static void main(String[] args) {
        int[] he = {2, 3, 4, 5, 6, 7};
        System.out.println(TWF(he));
    }
}
