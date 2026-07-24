package DP;

public class ClimbingStairs {
    public static int rec(int n , int[] dp){
        if (n == 0) {
            dp[n] = 1;
            return 1;
        }
        if (n < 0)
            return 0;
        if(dp[n] == 0)
        dp[n]=rec(n - 1,dp) + rec(n - 2,dp)+ rec(n - 3,dp);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        System.out.println(rec(n,dp));   
    } 
}
