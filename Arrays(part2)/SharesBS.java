public class SharesBS {
    public static int BuyAndSell(int prizes[]){
        int buyprize = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prizes.length;i++){
            if (buyprize < prizes[i]) {
                int profit = prizes[i]-buyprize;
                maxProfit = Math.max(maxProfit,profit);
            }else{
                buyprize = prizes[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] prizes = {7,1,5,3,6,4};
        System.out.println(BuyAndSell(prizes));
    }
}
