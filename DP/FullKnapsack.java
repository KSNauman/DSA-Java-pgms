package DP;

public class FullKnapsack {
    // just a basic recursive funt
    // public int knap(int w , int[] val , int[] wt , int n){
    //     if(w == 0 || n == 0){
    //         return 0;
    //     }
    //     if(wt[n-1]  <= w){
    //         int res1 = val[n-1] + knap(w-wt[n-1] , val , wt , n );
    //         int res2 =  knap(w , val , wt , n-1 );
    //         return Math.max(res1 , res2);
    //     }else{
    //         return knap(w, val , wt , n-1 );
    //     }
    // }

    // With memoization
    // public int knap(int w , int[] val , int[] wt , int n ,int[][] dp){
    //     if(w == 0 || n == 0){
    //         return 0;
    //     }
    //     if (dp[n][w] != -1) {
    //         return dp[n][w];
    //     }
    //     if(wt[n-1]  <= w){
    //         int res1 = val[n-1] + knap(w-wt[n-1] , val , wt , n-1,dp );
    //         int res2 =  knap(w , val , wt , n-1 ,dp);
    //         dp[n][w] =  Math.max(res1 , res2);
    //         return dp[n][w];
    //     }else{
    //         dp[n][w] = knap(w, val , wt , n-1 ,dp);
    //         return dp[n][w];
    //     }
    // }

    // Tabulation
    public int knap(int W , int[] val , int[] wt){
        int n = val.length;
        int[][] dp = new int[n+1][W+1];
        // for(int i=0 ; i<dp.length ; i++){
        //     dp[i][0] = 0;
        // }
        // for(int j=0 ; j<dp[0].length ; j++){
        //     dp[0][j] = 0;
        // }

        for(int i=1 ; i<n+1 ; i++){
            for(int j=1 ; j<W+1 ; j++){
                int v = val[i-1];
                int w = wt[i-1];
                // here j is W (total weight)
                if (w <= j) {
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{
                    dp[i][j] = dp[i-1][j];

                }
            }
        }
        return dp[n][W];
    }
    // public int knapsack(int W, int val[], int wt[] , int[][] dp) {
    //     // code here
    //     return knap(W,val,wt,val.length , dp);
    // }
    public static void main(String[] args) {
        int W = 7;
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        // Memiozation
        int[][] dp = new int[val.length+1][W+1];
        for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        FullKnapsack kp = new FullKnapsack();
        // System.out.println(kp.knapsack(W,val,wt,dp));
        System.out.println(kp.knap(W, val, wt));
    }

}
