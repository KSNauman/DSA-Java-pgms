package Binary_Tree01;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreesB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left= null;
            this.right=null;
        }
    }
    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left= buildTree(nodes);
            newNode.right=buildTree(nodes);

            return newNode;
        }
        public static void preorder(Node root){//O(n)
            if (root == null) {
                return ;
            }

            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root){
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        public static void levelOrder(Node root){
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
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
        public static int diameter(Node root){//O(n^2)
            if (root == null) {
                return 0;
            }

            int ld = diameter(root.left);
            int lh = height(root.left);
            int rd=  diameter(root.right);
            int rh= height(root.right);

            return Math.max(ld, Math.max(rd, lh+rh+1));
        }
    }
    // there is an enhanced way too just instead of calling the height function store it and return it 
    // how do u build the intution ?? like we perform recursion by the way in parallel process the height 
    // O(n)
    public static class Info{
        int dia;
        int height;
        public Info(int dia, int height){
            this.dia = dia;
            this.height = height;
        }
    }
    public static Info diameter2(Node root){
        // null values
        if (root == null) {
            return new Info(0, 0);
        }
        // work'
        Info linfo = diameter2(root.left);
        Info rinfo = diameter2(root.right);
        int fdia = Math.max(linfo.dia, Math.max(rinfo.dia, linfo.height+rinfo.height+1));
        int fheight = Math.max(linfo.height, rinfo.height)+1;

        return new Info(fdia, fheight);
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // System.out.println("Preorder: ");
        // tree.preorder(root);
        // System.out.println("\nInorder: ");
        // tree.inorder(root);
        // System.out.println("\nInorder: ");
        // tree.postorder(root);
        // System.out.println("\nLevel order: ");
        // tree.levelOrder(root);
        // System.out.println("\nDiameter of tree");
        // System.out.println(tree.diameter(root));
        
        System.out.println(diameter2(root).dia);

    }
}
