public class StariCase {
    public static void Staircase(int[][] arr,int key){
        int row =0,col=arr[0].length-1;
        while (row< arr.length && col >=0) {
            if (key == arr[row][col]) {
                System.out.println("("+row+","+col+")");
                return;
            }
            if (key <arr[row][col]) {
                col--;
            }
            if (key > arr[row][col]) {
                row++;
            }
        }
        System.out.println("Element not found");
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}};    
        Staircase(arr, 14);
    }
}
/*
 * time complexity is O(n+m)
 * it has to travel n row and m column in its worst position 
 * 
 * and if n>>>m then O(n)
 * if m>>>n then O(m)
 */