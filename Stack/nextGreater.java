import java.util.*;
public class nextGreater {
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];    

        for(int i=arr.length-1;i>=0;i--){
            //1 while "Pop until the top is greater."
            while (!s.isEmpty() && arr[i] >=arr[s.peek()]) {
                /*
                 * If arr[i] is greater than or equal to the element at the top of the stack, it means that the element at s.peek() cannot be the "next greater" for arr[i].
                 */
                s.pop();
            }
            // 2 if-else
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }
            //3 push in stack
            s.push(i);
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
    }   
}

/*
 * 1. next greater right 
 * 3. next greater left: change for loop
 * 2. next smaller left change for loop and condition
 * 4. next smaller right change condition
 */


 