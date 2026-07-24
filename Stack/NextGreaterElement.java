// package Stack;

import java.util.Stack;

/**
 * Topic: Stack
 * Problem: Next Greater Element (Right)
 * 
 * Description: 
 * For every element in an array, find the first element to its right that is strictly greater.
 * If no such element exists, output -1.
 * 
 * Intuition:
 * We traverse the array from right to left and maintain a stack of indices.
 * For each element `arr[i]`, we pop all elements from the stack that are smaller than 
 * or equal to `arr[i]`. If the stack becomes empty, there is no greater element to the right. 
 * Otherwise, the top of the stack is the index of the next greater element. 
 * Finally, we push the current index `i` onto the stack.
 * 
 * Complexity: O(N) Time (each element is pushed and popped at most once). O(N) Space.
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int[] nextGreater = new int[arr.length];    

        // Traverse backwards
        for (int i = arr.length - 1; i >= 0; i--) {
            // Pop smaller or equal elements
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            
            // If stack is empty, no greater element exists
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            
            // Push current index
            s.push(i);
        }

        System.out.println("Next Greater Elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();
    }   
}