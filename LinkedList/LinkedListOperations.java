// package LinkedList;

/**
 * Topic: Linked List
 * Problem: Linked List Operations (Add, Remove, Search, Reverse, Palindrome, Cycle, MergeSort, ZigZag)
 * 
 * Description: 
 * Implement various operations on a Singly Linked List from scratch without using Java's built-in LinkedList.
 * Operations include adding elements, removing elements, searching, reversing the list, finding palindromes,
 * detecting and removing cycles, merge sorting, and re-arranging in zigzag fashion.
 * 
 * Intuition:
 * A Singly Linked List consists of Nodes where each Node has a data part and a reference to the next Node.
 * - Add/Remove: O(1) for ends (with tail pointer), O(N) for middle.
 * - Reverse: Iteratively switch the direction of the `next` pointers.
 * - Palindrome & ZigZag: Use the slow-fast pointer approach to find the middle, reverse the second half, 
 *   and perform operations (matching or alternating).
 * - Cycle Detection: Use Floyd's Cycle-Finding Algorithm (slow and fast pointers).
 * - Merge Sort: Divide the list into halves, recursively sort, and merge the sorted halves.
 * 
 * Complexity: 
 * - Space: mostly O(1) for pointer manipulations (O(log N) stack space for Merge Sort recursion).
 * - Time: Varies per operation. O(N) for Search/Reverse/Palindrome/Cycle. O(N log N) for Merge Sort.
 */
public class LinkedListOperations {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Print the linked list
    public void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add node in the middle
    public void addInMid(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove first node
    public int removeFirst() {
        if (head == null) {
            System.out.println("Empty");
            return Integer.MIN_VALUE;
        } else if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // Remove last node
    public int removeLast() {
        if (head == null) {
            System.out.println("Empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Iterative Search
    public int iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (key == temp.data) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Recursive Search helper
    private int helper(Node node, int key) {
        if (node == null) {
            return -1;
        }
        if (node.data == key) {
            return 0;
        }
        int idx = helper(node.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    // Recursive Search
    public int recSearch(int key) {
        return helper(head, key);
    }

    // Reverse the Linked List
    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Delete Nth node from the end
    public void deleteNthFromEnd(int n) {
        if (n == size) {
            head = head.next;
            return;
        }
        int i = 1;
        Node temp = head;
        while (i < size - n) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }

    // Find the middle node
    private Node findMid(Node headNode) {
        Node slow = headNode;
        Node fast = headNode;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Check if the Linked List is a Palindrome
    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // 1. Find mid
        Node midNode = findMid(head);

        // 2. Reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // Head of reversed 2nd half
        Node left = head;

        // 3. Compare 1st and 2nd halves
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // Detect Cycle in Linked List
    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; // Cycle detected
            }
        }
        return false;
    }

    // Remove Cycle in Linked List
    public static void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        
        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (!cycle) {
            return;
        }
        
        // Find meeting point and node before cycle starts
        slow = head;
        Node prev = null;
        if (slow == fast) { // Cycle starts at head
            while (fast.next != slow) {
                fast = fast.next;
            }
            prev = fast;
        } else {
            while (slow != fast) {
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        // Remove cycle
        prev.next = null;
    }

    // Helper for Merge Sort to find mid
    private Node getMidForMergeSort(Node headNode) {
        Node slow = headNode;
        Node fast = headNode.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper for Merge Sort to merge two sorted lists
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    // Merge Sort a Linked List
    public Node mergeSort(Node headNode) {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }
        Node mid = getMidForMergeSort(headNode);
        Node rightHead = mid.next;
        mid.next = null;
        
        Node newLeft = mergeSort(headNode);
        Node newRight = mergeSort(rightHead);
        
        return merge(newLeft, newRight);
    }

    // Rearrange the Linked List in Zig-Zag fashion (L1 -> Ln -> L2 -> Ln-1 -> ...)
    public void zigZag() {
        if (head == null || head.next == null) return;
        
        // 1. Find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // 2. Reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Alternate merge (Zig-Zag)
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
    }
    
    public static void main(String[] args) {
        LinkedListOperations ll = new LinkedListOperations();
        
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        System.out.println("Original Linked List:");
        ll.print();

        ll.head = ll.mergeSort(head);
        System.out.println("After Merge Sort:");
        ll.print();
        
        ll.zigZag();
        System.out.println("After Zig-Zag Rearrangement:");
        ll.print();
    }
}
