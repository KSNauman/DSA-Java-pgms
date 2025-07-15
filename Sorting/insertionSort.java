//package Sorting;
// we create two spaces one is sorted another is unsorted take the element from unsort 
// compare it to sorted array then plaace accodingly
public class insertionSort {
    public static void insertion(int[] arr){
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            while (prev>=0 && arr[prev]>curr) {
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=curr;   
        }
    }
    public static void main(String[] args) {
        int[] ara={4,3,5,1,2};
        insertion(ara);
        for (int i : ara) {
            System.out.print(i);
        }
    }
}
/*we are using arr.length not length-1 because we are taking the last element of unsorted
 * array and also comparing in the sorted part
 */