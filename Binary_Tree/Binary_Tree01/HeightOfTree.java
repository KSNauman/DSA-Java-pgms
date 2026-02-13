package Binary_Tree01;

public class HeightOfTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static int height(Node root){
        // base case
        if(root == null){
            return 0;
        }
        // work
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }
    public static int count(Node root){
        // base 
        if (root == null) {
            return 0;
        }
        // work
        int lc = count(root.left);
        int rc = count(root.right);
        return (lc+rc+1);
    }
    public static int sum(Node root){
        // base case
        if (root == null) {
            return 0;
        }
        // int ls =sum(root.left);
        // int rs = sum(root.right);
        // return ls+rs+root.data;
        return sum(root.left)+sum(root.right)+root.data;
        // work
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left= new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right= new Node(5);
        root.right.right = new Node(6);
        // System.out.println(height(root));
        // System.out.println(count(root));
        System.out.println(sum(root));
    }
}
