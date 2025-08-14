package Recursion01;

public class FriendsPair {
    public static int Pairs(int n){
        // Base cases:
        // If there's 1 friend → only 1 way (stay single)
        // If there are 2 friends → 2 ways (both single, or pair together)
        if (n == 1 || n == 2) {  
            return n;
        }

        // Case 1: nth person stays single → count ways for remaining (n-1)
        int fnm1 = Pairs(n - 1);

        // Case 2: nth person pairs with any of the (n-1) friends → (n-1 choices)
        // For each pair, count ways to arrange remaining (n-2)
        int fnm2 = (n - 1) * Pairs(n - 2);

        // Total ways = single + paired options
        return fnm1 + fnm2;
    } 
    
    public static void main(String[] args) {
        System.out.println(Pairs(3)); // Output: 4
    }
}

// ====================================
// Friends Pairing Problem (Recursion)
// Pattern: Recursion + Combinatorics
// Description: Given `n` friends, each can stay single or pair up. Count total unique ways.
// Approach:
// - Base case:
//   - n = 1 → 1 way (stay single)
//   - n = 2 → 2 ways (both single, or pair)
// - Recursive case:
//   - nth friend stays single → solve for (n - 1)
//   - nth friend pairs with (n - 1) others → for each, solve for (n - 2)
//   - Total = f(n - 1) + (n - 1) * f(n - 2)
// Tricky:
// - It's tempting to treat it like permutations, but order doesn't matter in pairings
// - Easy to miss the multiplication part `(n - 1)` in the pairing case
// Time: 30–45 mins
// Confidence: 8/10
// ====================================
