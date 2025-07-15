package LinkedList;

public class LinkedList {
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

    public void addFirst(int data) {
        // O(1)
        // 1
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // 2
        newNode.next = head;

        // 3
        head = newNode;
        /*
         * creating Node
         * add first
         * 1. create a Node
         * 2. new node's next = head
         * 3. head = newNode
         */
    }

    public void addLast(int data) {
        // O(1)
        // 1
        Node newNode = new Node(data);
        size++;
        // edge case
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // 2
        tail.next = newNode;
        // 3
        tail = newNode;

        /*
         * add last
         * 1. create a node
         * 2. tail.next = newNode
         * 3. tail = newNode
         */
    }

    public void print() {
        // O(n)
        if (head == null) {
            System.out.println("LL is empty ");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void addInMid(int index, int data) {
        int i = 0;
        Node newNode = new Node(data); // Create a new node with the provided data
        if (index == 0) {
            addFirst(data); // If the index is 0, just add at the beginning
            return;
        }
        size++;
        Node temp = head;
        while (i < index - 1) { // Traverse until the node right before the target index
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next; // Set the new node's next to the next of temp
        temp.next = newNode; // Insert the new node after temp
        /*
         * The function inserts a new node at the specified index in the linked list.
         * Important changes:
         * - Utilize a simple approach to traverse the list and insert the node.
         * - Size of the list is incremented before insertion.
         */
    }

    public int removeFirst() {
        if (head == null) {
            System.out.println("Empty"); // List is empty
            return Integer.MIN_VALUE;
        } else if (head.next == null) {
            int val = head.data; // Only one node exists, store its value
            head = tail = null; // Reset head and tail to null
            size = 0; // Reset the size of the list
            return val;
        }
        int val = head.data;
        head = head.next; // effectively removing the first node
        size--; // Decrement the size of the list
        return val;
        /*
         * remove first
         * 1.head = head.next
         */
        /*
         * The function removes the first node from the linked list and returns its
         * value.
         * Important changes:
         * - Handles an empty list by printing "Empty" and returning Integer.MIN_VALUE.
         * - Correctly resets head, tail, and size when only one node is present.
         * - Decrements the size of the list when a node is removed.
         */
    }

    public int removeLast() {
        if (head == null) {
            System.out.println("Empty"); // List is empty
            return Integer.MIN_VALUE;
        }

        // prev : will point to the node at index (size - 2)
        Node prev = head;
        while (prev.next != tail) { // Traverse until the node just before tail
            prev = prev.next;
        }
        int val = tail.data; // Store the value of the tail node
        prev.next = null; // Remove the tail by setting the second last node's next to null
        tail = prev; // Update tail to point to the new last node
        size--; // Decrement the size of the list
        return val;
        /*
         * The function removes the last node from the linked list and returns its
         * value.
         * Important changes:
         * - Handles the empty list scenario.
         * - Traverses to find the node before tail (prev node).
         * - Adjusts pointers to remove the tail and update the tail reference.
         * - Decrements the size of the list.
         */
    }

    public int iterativeSearch(int ele) {
        // O(n)
        Node temp = head;
        int i = 0;
        while (temp != tail.next) {
            if (ele == temp.data) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        // O(N): Recursive search for the key in the list.
        if (head == null) {
            return -1; // End of list reached without finding the key.
        }
        if (head.data == key) {
            return 0; // Key found at the current node.
        }
        int idx = helper(head.next, key); // Recursively search in the rest of the list.
        if (idx == -1) {
            return -1; // Propagate -1 if key is not found in the remaining list.
        }
        return idx + 1; // Add 1 to the index to account for the current node.
    }

    public int recSearch(int key) {
        return helper(head, key); // Start the recursive search from the head of the list.
        /*
         * The functions perform a recursive search for a key in the linked list and
         * return its exact index.
         * Important details:
         * - helper() returns the index of the key relative to the current node.
         * - When the key is found, it returns 0; as recursion unwinds, each level adds
         * 1 to this value.
         * - This accumulation ensures that the final value represents the correct
         * absolute index from the head.
         * - recSearch() starts the search from the head of the list.
         */

    }

    public void reverse() {
        // O(N): Linear time complexity
        // 3 variables 4 steps (3:4)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next; // Save the next node
            curr.next = prev; // Reverse the link: point current node to previous node
            prev = curr; // Move previous pointer to current node
            curr = next; // Move current pointer to next node
        }
        head = prev; // Update head to the new front of the list (prev now holds the new head)

        /*
         * The function reverses the linked list.
         * Important changes:
         * - Uses three pointers: prev, curr, and next.
         * - Iteratively reverses the direction of the links.
         * - After completion, 'prev' is the new head of the list.
         */
    }

    public void deleteNthFromEnd(int n) {
        // O(N)
        if (n == size) {
            head = head.next; // If n equals the size, the nth node from the end is the head node; remove it.
            return;
        }

        int i = 1;
        Node temp = head;
        while (i < size - n) { // Traverse until reaching the node just before the target node
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next; // Bypass the target node to remove it from the list
        return;
        /*
         * The function deletes the nth node from the end of the linked list.
         * Important changes:
         * - If n equals the list size, it removes the head node.
         * - Otherwise, it traverses to the node immediately before the target node and
         * adjusts pointers.
         */
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        /*
         * fast != null for even sized LL
         * fast.next != null for odd sized LL
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow pointer now points to the middle node
        /*
         * LL is palindrome
         * 2 methods , one is you can copy it into any other ds like arrayList
         * or strings then you can compare
         * 
         * second will be Slow Fast approch
         * 1. find midNode
         * 2. 2nd half reverse
         * 3. check if 1st half == 2nd half
         */
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true; // An empty list or a single node list is a palindrome
        }

        // 1. find mid: locate the middle node of the linked list
        Node midNode = findMid(head);

        // 2. reverse 2nd half: reverse the second half of the list starting from
        // midNode
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next; // Store the next node
            curr.next = prev; // Reverse the current node's pointer
            prev = curr; // Move prev to current node
            curr = next; // Move to the next node
        }
        // 'prev' now points to the head of the reversed second half (right half)
        Node right = prev;
        Node left = head;

        // 3. check if 1st half == 2nd half: compare the nodes from the left and right
        // halves
        while (right != null) {
            if (left.data != right.data) {
                return false; // Mismatch found, not a palindrome
            }
            left = left.next;
            right = right.next;
        }
        return true; // All nodes matched; the linked list is a palindrome
        /*
         * Multi-line Comment (For Revision):
         * - The findMid() function uses the slow-fast pointer approach to determine the
         * middle node of the list.
         * - The checkPalindrome() function works as follows:
         * 1. It finds the mid-node of the linked list.
         * 2. It reverses the second half of the list starting from the mid-node.
         * 3. It compares nodes from the first half and the reversed second half.
         * - If all corresponding nodes match, the linked list is a palindrome.
         */
    }

    public boolean isCycle() {
        // same slow fast approch but in cycle slow shld meed fast at d distance
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // Cycle detected if both pointers meet
                return true;
            }
        }
        return false; // No cycle found if fast pointer reaches the end of the list
        /*
         * The function checks if the linked list contains a cycle using the slow-fast
         * pointer technique.
         * Important changes:
         * - Utilizes two pointers moving at different speeds.
         * - If they meet, a cycle exists; otherwise, no cycle is present.
         */
    }

    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        Node prev = null;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        // find meeting point
        slow = head;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // remove cycle -> last.next = null
        prev.next = null;

        /*
         * there is an catch for last line
         * if the cycle it self starts from head i,e the starting node it self is the
         * last node then eventually the loop where we are taking the prev Node counter
         * that wont start that exactly means prev is still holding the null as assigned
         * at creation so that creates the null pointer exception
         * so use a simple loop again which in turn increases complexity but u know how
         * to reduce it (treat it as edge case )
         * // Step 2: Find the start of the cycle
         * slow = head;
         * if (slow == fast) {
         * // Special case: Cycle starts at head
         * while (fast.next != slow) {
         * fast = fast.next; // Move fast to last node in cycle
         * }
         * } else {
         * // Normal case: Find the cycle start
         * while (slow.next != fast.next) {
         * slow = slow.next;
         * fast = fast.next;
         * }
         * }
         */
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
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

    public Node MergeSort(Node head) {
        // O(nlogn)
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // finding the mid
        Node mid = getMid(head);
        // seperating left nd right
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = MergeSort(head);
        Node newRight = MergeSort(rightHead);
        // merge
        return merge(newLeft, newRight);
    }

    public void zigZaz() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node mid = slow;

        // reverse 2nd half
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

        Node right = prev;
        Node left = head;
        // alt merge (zigzag merge)
        Node nextL, nextR;
        while (left != null && right != null) {
            // zigzag
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            // updating
            left = nextL;
            right = nextR;

        }
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        /*
         * ll.addFirst(1);
         * ll.addLast(2);
         * ll.addLast(3);
         * ll.addLast(4);
         * ll.addLast(5);
         * 
         * System.out.println(ll.iterativeSearch(3));
         * System.out.println(ll.recSearch(10));
         * 
         * ll.print();
         * ll.deleteNthFromEnd(3);
         * ll.print();
         */

        /*
         * ll.addLast(1);
         * ll.addLast(2);
         * ll.addLast(2);
         * ll.addLast(1);
         * 
         * System.out.println(ll.checkPalindrome());
         */

         /*
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;

        System.out.println(ll.isCycle());
        removeCycle();
        System.out.println(ll.isCycle()); 
        */

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        // 5->4->3->2->1

        ll.print();

        ll.head = ll.MergeSort(head);
        ll.print();
        // 1->2->3->4->5
        ll.zigZaz();
        ll.print();
    }
}
