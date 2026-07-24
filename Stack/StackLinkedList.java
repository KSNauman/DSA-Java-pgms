// package Stack;

/**
 * Topic: Stack
 * Problem: Stack Implementation using Linked List
 * 
 * Description: 
 * Implementation of a Stack data structure using a Singly Linked List.
 * 
 * Intuition:
 * A Stack follows LIFO. We can implement it using a Linked List by always adding 
 * to the `head` (push) and removing from the `head` (pop). This ensures all operations 
 * are O(1).
 * 
 * Complexity: O(1) Time for push, pop, and peek. O(N) Space.
 */
public class StackLinkedList {
    public static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class CustomStack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top; 
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack (Linked List) elements:");
        while (!CustomStack.isEmpty()) {
            System.out.println(CustomStack.peek());
            CustomStack.pop();
        }
    }
}
