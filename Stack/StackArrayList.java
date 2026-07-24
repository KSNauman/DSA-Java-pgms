// package Stack;

import java.util.ArrayList;

/**
 * Topic: Stack
 * Problem: Stack Implementation using ArrayList
 * 
 * Description: 
 * Implementation of a Stack data structure using Java's built-in ArrayList.
 * 
 * Intuition:
 * An ArrayList can be used to model a Stack. The end of the ArrayList represents the top 
 * of the Stack. `push` appends an element, `pop` removes the last element, and `peek` 
 * retrieves the last element.
 * 
 * Complexity: O(1) Amortized Time for push, pop, and peek. O(N) Space.
 */
public class StackArrayList {
    static class CustomStack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CustomStack.push(1);
        CustomStack.push(2);
        CustomStack.push(3);

        System.out.println("Stack (ArrayList) elements:");
        while (!CustomStack.isEmpty()) {
            System.out.println(CustomStack.peek());
            CustomStack.pop();
        }
    }
}