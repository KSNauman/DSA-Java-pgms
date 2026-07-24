// package LL_part2;

/**
 * Topic: Linked List
 * Problem: Circular Linked List Basics
 * 
 * Description: 
 * Implementation of a Circular Linked List where the last node points back to the first node.
 * This class demonstrates basic insertion at the front and adding to an empty list.
 * 
 * Intuition:
 * In a Circular Linked List, the tail node's next pointer points to the head node.
 * We can maintain just a 'last' pointer to efficiently add elements at the front and back.
 * The head is simply `last.next`.
 * 
 * Complexity: O(1) Time for addFront and addToEmpty. O(N) Space for N elements.
 */
public class CircularLinkedList {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Add to an empty list
    static Node addToEmpty(Node last, int data) {
        if (last != null) {
            return last;
        }
        last = new Node(data);
        last.next = last; // Points to itself
        return last;
    }
    
    // Add at the front of the list
    static Node addFront(Node last, int data) {
        if (last == null) {
            return addToEmpty(last, data);
        }
        Node newNode = new Node(data);
        newNode.next = last.next; // New node points to head
        last.next = newNode;      // Last node points to new node
        return last;
    }
}
