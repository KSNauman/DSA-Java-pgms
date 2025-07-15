public class DoubleLL {
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

    // add
    public void addFirst(int data) {
        //O(1)
        // create node
        /*
         * newNode.next =head;
         * head.prev=newNode;
         * head=newNode ;
         */

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

    public int removeFirst(){
        //O(1)
        if (head == null    ) {
            System.out.println("Empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail =null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;

        /*
         * for single node head.prev throws NullPointerException
         * why??
         * above the step head is now null 
         * null.prev is invalid operation 
         * null do not have any attributes or methods so NullPointerException
         */
    }

    public void addLast(int data) {
        // O(1)
        Node newNode = new Node(data);
        size++;
        // edge case
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev=tail;
        tail = newNode;
    }
    public int removeLast() {
        //O(1)
        if (head == null) {
            System.out.println("Empty"); // List is empty
            return Integer.MIN_VALUE;
        }
        int val = tail.data;
        size--; 
        if (head == tail) {
            head = tail = null;
            return val;
        }
        
        tail = tail.prev;
        tail.next =null ;
        return val;
        
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void reverse(){
        Node curr = head;
        Node prev =null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next=prev;

            curr.prev=next;

            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.print();
        System.out.println(dll.size);
        // dll.removeFirst();
        // dll.removeLast();
        // dll.print();
        dll.reverse();
        dll.print();
    }
}
