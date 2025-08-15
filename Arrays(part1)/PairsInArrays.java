public class PairsInArrays {
    public static void pairs(int[] arr){
        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+curr+","+arr[j]+")");
            }
            System.out.println();
        }
    }
    public static void subArrays(int[] arr){
        for(int i=0;i<arr.length;i++){//this for loop to iterate the starting ele 
            for(int j=i;j<arr.length;j++){// this for loop to get the last ele of sub array
                for(int k=i;k<=j;k++){//this array to print the ele in between st and lst
                    System.out.print(arr[k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void sumOfSubArrays(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;//needs to be reinitialized to zero after a sum of single subarray
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]);
                    sum+=arr[k];
                }
                System.out.print("    sum is :"+sum);
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int ar[]={1,2,3,4,5};
        //pairs(ar);
        //subArrays(ar);
        //sumOfSubArrays(ar);
    }
}
/*
 * to calculate the number of pairs 
 * use formula n(n-1)/2
 */

 /*
 * This program demonstrates three important array-related operations:
 * 
 * 1. pairs(int[] arr)
 *    - Prints all possible unique pairs of elements from the array.
 *    - Uses two nested loops:
 *        Outer loop fixes the first element.
 *        Inner loop picks the second element from the remaining array elements.
 *    - Example (for arr = {1, 2, 3}):
 *        (1,2) (1,3)
 *        (2,3)
 *        (3)
 *    - Number of pairs can be calculated using the formula: n(n-1)/2
 * 
 * 2. subArrays(int[] arr)
 *    - Prints all possible subarrays of the given array.
 *    - Uses three nested loops:
 *        Outer loop chooses the starting index (i).
 *        Middle loop chooses the ending index (j).
 *        Inner loop prints elements from i to j (the subarray).
 *    - Example (for arr = {1, 2}):
 *        1
 *        12
 *
 *        2
 *
 * 3. sumOfSubArrays(int[] arr)
 *    - Prints all subarrays along with their sum.
 *    - Similar to subArrays method but keeps a 'sum' variable to accumulate the sum of each subarray.
 *    - 'sum' is reinitialized to 0 for each subarray to avoid carrying over values.
 *    - Example (for arr = {1, 2}):
 *        1    sum is: 1
 *        12   sum is: 3
 *
 *        2    sum is: 2
 * 
 * main method:
 *    - Initializes an array {1, 2, 3, 4, 5}.
 *    - Calls one of the methods (currently all method calls are commented out).
 *    - Uncomment a method call to see its output.
 */
