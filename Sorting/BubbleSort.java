//package Sorting;

public class BubbleSort {
    public static int[] bubble(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
    public static int[] bubbleEnhanced(int[] arr){
         /*
        We are checking for swaps during the first pass, focusing specifically
        on the first element. If a swap occurs, it indicates that the array is
        not in the correct order and further sorting is required. 
        */
        for(int i=0;i<arr.length-1;i++){
            int isSwapped =0;
            for(int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=arr[j];
                    isSwapped= 1;
                   
                }
            }
            if (isSwapped ==0) {
                return arr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ara ={2,2,3,4,3,1,5};
        ara=bubble(ara);
        for (int i : ara) {
            System.out.print(i);
        }
    }
}
