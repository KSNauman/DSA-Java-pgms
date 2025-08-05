package Recursion01;

public class tiling {
    public static int totalWays(int n) {// 2*n
        if (n == 0 || n == 1) {
            return 1;
        }
        // for vertical tile
        int fnm1 = totalWays(n - 1);
        // for horizontal tile
        int fnm2 = totalWays(n - 2);

        return fnm1 + fnm2;
    }

    public static void main(String[] args) {
        System.out.println(totalWays(4));
    }
}

// ====================================
// Tiling Problem (2×n board using 2×1 tiles)
// Pattern: Recursion (Fibonacci-style recurrence)
// Description: Count number of ways to fill a 2×n board using 2×1 tiles.
// Approach:
// - Place tile vertically → solve for (n - 1)
// - Place tile horizontally (takes 2 columns) → solve for (n - 2)
// - Total ways = ways(n - 1) + ways(n - 2)
// - Base cases: 
//   - n == 0 → 1 way (no tile)
//   - n == 1 → 1 way (only one tile vertically)
// Tricky:
// - Mixing of vertical and horizontal tilings handled naturally via recursion
// - Misunderstanding that recursion favors one side (but it explores all paths)
// - Hard to trace initially without drawing the tree
// Time: 1 hour
// Confidence: 6.5/10
// ====================================
