// package Recursion01;

/**
 * Topic: Recursion
 * Problem: Friends Pairing Problem
 * 
 * Description: 
 * Given `n` friends, each can stay single or pair up with one other friend. 
 * Count the total number of unique ways they can pair up or stay single.
 * 
 * Intuition:
 * For the nth friend, there are two choices:
 * 1. Stay single: The problem reduces to finding ways for (n-1) friends.
 * 2. Pair up: The nth friend can pair with any of the (n-1) friends. Once paired, 
 *    the problem reduces to finding ways for the remaining (n-2) friends.
 * So, f(n) = f(n-1) + (n-1) * f(n-2).
 * 
 * Complexity: O(2^N) Time (can be optimized to O(N) using DP). O(N) Space.
 */
public class FriendsPairing {
    public static int countPairs(int n) {
        // Base cases: 
        // 1 friend -> 1 way (single)
        // 2 friends -> 2 ways (both single, or paired together)
        if (n == 1 || n == 2) {  
            return n;
        }

        // Case 1: nth person stays single
        int singleWays = countPairs(n - 1);

        // Case 2: nth person pairs with any of the (n-1) friends
        int pairedWays = (n - 1) * countPairs(n - 2);

        return singleWays + pairedWays;
    } 
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Total ways to pair " + n + " friends: " + countPairs(n)); 
    }
}
