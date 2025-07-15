/*
 * Algo:Maximum length chain
 * this is used to form a chain using the pairs given forming the longest chain not overlapping 
 * using greedy approch by selecting less distances with the help of the method of sorting to the chainend
 */
package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLenChain {
    public static void main(String[] args) { //O(nlogn)
        int [][] pairs = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainlen =1;  //this for tracking answer
        int chainend = pairs[0][1];  // this for getting the end part of chain

        for(int i=1; i<pairs.length;i++){
            if (pairs[i][0] > chainend) {
                chainlen++;
                chainend = pairs[i][1];
            }
        }
        System.out.println("max len of chain ="+chainlen);

    }
}
// to print the pairs u can do it by storing in 3d matrix and applyinh sorrting to the index