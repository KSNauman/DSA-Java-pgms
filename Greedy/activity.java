package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class activity {
    public static void main(String[] args) {//O(n)
        int[] start = {1,3,0,5,8,5};
        int[] end= {2,4,6,7,9,9};

        //Sorting for another questions
         int activities[][] = new int[start.length][3];
         for(int i=0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
         }
        //  lamda funtion -> shortform
        Arrays.sort(activities , Comparator.comparingDouble(o -> o[2] ));

        // end time basis sorted
        int maxAct = 0; //count
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1;i<start.length;i++){
            if (activities[i][1] >= lastEnd) {//Non overlapping
                //Activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max activities ="+maxAct);
        for(int i=0 ; i<ans.size();i++){
            System.out.println("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
