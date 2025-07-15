public class printSub {
    public static void sub(int[] arr){
        int ts=0;
        for(int i=0;i<=arr.length-1;i++){
            for(int j=i;j<=arr.length-1;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
            ts++;
            System.out.println();
            }
        }
        System.out.println(ts);
    }
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10};
        sub(arr);
        // System.out.println(arr.length*(arr.length+1)/2);
    }
}
