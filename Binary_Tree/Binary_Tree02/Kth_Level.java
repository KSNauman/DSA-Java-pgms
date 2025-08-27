package Binary_Tree02;

import java.util.LinkedList;
import java.util.Queue;
// import Binary_Tree.Node;
// import Node;
public class Kth_Level {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right=null;
        }
    }
    public static void IterKLevel(Node root, int level , int k){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
                level++;
            }else{
                if (level == k) {   
                    System.out.print(curr.val+" ");
                }
                if (level<k) {
                    
                    if (curr.left != null) {   
                        q.add(curr.left);
                    }
                    if (curr.right != null) {   
                        q.add(curr.right);
                    }
                }
            }
        }
    }
    public static void KLevel(Node root,int level,int k){
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.val+" ");
            return;
        }
        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }
    public static void main(String[] args) {
         /*
         *              1
         *             / \
         *            2   3
         *           / \ / \
         *          4  5 6 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.left = new Node(6);
        root.right.right= new Node(7);

        int k = 2;
        // KLevel(root, 1, k);
        IterKLevel(root, 1, k);
    }
}
