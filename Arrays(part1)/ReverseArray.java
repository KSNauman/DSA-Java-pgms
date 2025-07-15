//package Arrays(part1);

public class ReverseArray {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int f =0,l=arr.length-1;
        while (f<l) {
            int temp = arr[f];
            arr[f]=arr[l];
            arr[l]=temp;
            f++;l--;
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
// mid = high - (high - low) / 2;
// Why it works:

// (high - low) is the distance between the two indices → smaller and safe.

// Then divide by 2 → half the distance.

// Add low → gives the actual middle index.

