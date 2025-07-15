public class CircularLL {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next = null;
        }
    }
    static Node addToEmpty(Node last, int data) {
        if (last != null) {
            return last;
        }
        last = new Node(data);
        last.next=last;
        return last;
    }
    static Node addFront(Node last, int data) {
        if (last == null){
            return addToEmpty(last, data);
        } 
        Node newNode = new Node(data);
        
    }
}
