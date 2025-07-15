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