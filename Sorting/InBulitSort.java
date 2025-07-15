//package Sorting;
import java.util.Arrays;
import java.util.Collections;
public class InBulitSort {
    public static void main(String[] args) {
        Integer arr[]={4,3,5,2,1};
        //Arrays.sort(arr);
        //Arrays.sort(arr,0,3);

        Arrays.sort(arr,Collections.reverseOrder());
        for (int i : arr) {
            System.out.println(i);
        }

    }
}
