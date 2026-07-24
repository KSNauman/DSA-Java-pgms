// package Patterns;

/**
 * Topic: Recursion / Patterns
 * Problem: Friends Pairing Problem
 * 
 * Description: 
 * Given N friends, each one can remain single or can be paired up with some other friend. 
 * Each friend can be paired only once. Find out the total number of ways in which friends 
 * can remain single or can be paired up.
 * 
 * Intuition:
 * For the nth person, there are two choices:
 * 1. Stay single: Then we need to find the number of ways to pair the remaining (n-1) friends.
 * 2. Pair up: The nth person can pair with any of the remaining (n-1) friends. Once paired, 
 *    we need to find the ways to pair the remaining (n-2) friends.
 * Total ways = ways(n-1) + (n-1) * ways(n-2)
 * 
 * Complexity: O(2^N) Time (can be optimized to O(N) using DP). O(N) Space for call stack.
 */
public class FriendsPairingProblem {
    public static int friendsPairing(int n) {
        // Base case: 1 friend (1 way), 2 friends (2 ways: single or paired)
        if (n == 1 || n == 2) {
            return n;
        }
        
        // Choice 1: nth friend remains single -> f(n-1)
        int singleWays = friendsPairing(n - 1);
        
        // Choice 2: nth friend pairs up with any of the (n-1) friends -> (n-1) * f(n-2)
        int pairedWays = (n - 1) * friendsPairing(n - 2);
        
        return singleWays + pairedWays;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Total number of ways to pair " + n + " friends: " + friendsPairing(n));
    }
}
