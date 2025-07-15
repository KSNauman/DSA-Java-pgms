package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnap {
    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] weight = {10,20,30};
        int W = 50;

        double ratio[][] =  new double[val.length][2];
        // oth col => idx ; 1st col => ratio

        for(int i=0 ;i<val.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }
        // Ascending order

        for(int i=0 ; i<ratio.length; i++){
            for(int j=0 ; j<2   ;j++){
                System.out.print(ratio[i][j]);
            }
            System.out.println();
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalval =0;
        for(int i=ratio.length-1 ; i>=0;i--){
            int idx = (int)ratio[i][0];
            if (capacity >= weight[idx]) {
                finalval += val[idx];
                capacity -= weight[idx];
            }else{
                // fractional part
                finalval += (ratio[i][1] * capacity);
                capacity =0;
                break;
            }

        }
        System.out.println("Final value"+finalval);
    }
}
