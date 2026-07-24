// package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Topic: Greedy Algorithm
 * Problem: Activity Selection
 * 
 * Description: 
 * You are given n activities with their start and finish times. Select the maximum number 
 * of activities that can be performed by a single person, assuming that a person can only 
 * work on a single activity at a time.
 * 
 * Intuition:
 * The greedy choice is to always pick the next activity whose finish time is least among 
 * the remaining activities and the start time is more than or equal to the finish time 
 * of previously selected activity. We sort the activities based on their finish times.
 * 
 * Complexity: O(N log N) Time due to sorting, O(N) Space for tracking activities.
 */
public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        // Create a 2D array to store activities: index, start, end
        int[][] activities = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Sort based on end times (column index 2)
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // Select the first activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        
        for (int i = 1; i < start.length; i++) {
            // If this activity starts at or after the previous activity ends
            if (activities[i][1] >= lastEnd) {
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2]; // Update the end time
            }
        }
        
        System.out.println("Maximum activities = " + maxAct);
        System.out.print("Activities chosen: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}
