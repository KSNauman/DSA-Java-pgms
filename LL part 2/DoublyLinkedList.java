// package LL_part2;

/**
 * Topic: Linked List
 * Problem: Doubly Linked List Implementation
 * 
 * Description: 
 * Implementation of a Doubly Linked List from scratch. 
 * Supports adding/removing at the front and end, printing, and reversing.
 * 
 * Intuition:
 * Unlike a Singly Linked List, each Node in a Doubly Linked List has a `prev` pointer 
 * in addition to the `next` pointer. This allows traversal in both directions and 
 * makes removing the last node an O(1) operation if we maintain a tail pointer.
 * Reversing a Doubly Linked List involves swapping the `next` and `prev` pointers of all nodes.
 * 
 * Complexity: O(1) Time for addFirst/addLast/removeFirst/removeLast. O(N) Time for reverse/print. O(N) Space.
 */
public class DoublyLinkedList {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Add at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Remove from the beginning
    public int removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        if (size == 1) {
            head = tail = null;
            size--;
            return val;
        }
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // Remove from the end
    public int removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        int val = tail.data;
        size--;
        if (head == tail) {
            head = tail = null;
            return val;
        }
        tail = tail.prev;
        tail.next = null;
        return val;
    }

    // Print the list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Reverse the Doubly Linked List
    public void reverse() {
        Node curr = head;
        Node prevNode = null;
        Node nextNode;
        
        while (curr != null) {
            nextNode = curr.next;
            // Swap next and prev pointers
            curr.next = prevNode;
            curr.prev = nextNode;

            prevNode = curr;
            curr = nextNode;
        }
        // Update head to the last processed node
        head = prevNode;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        
        System.out.println("Original Doubly Linked List:");
        dll.print();
        System.out.println("Size: " + size);
        
        System.out.println("Reversed Doubly Linked List:");
        dll.reverse();
        dll.print();
    }
}
