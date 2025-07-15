//package Sorting;
//in the bubble sort technique we encountered lot of swapping what this 
// type of sort does is avoids the multiple sorting , finds the min index of the ele
// then swap it
public class selectionSort {
    public static void selection(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if (arr[j] < arr[i]) {
                    min =j;
                }
            }
            int temp =arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    } 
    public static void main(String[] args) {
        int[] ara={5,2,3,4,1};
        selection(ara);
        for (int i : ara) {
            System.out.print(i);
        }
    }   
}
