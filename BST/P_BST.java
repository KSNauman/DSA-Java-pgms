package BST;

public class P_BST {
    static class Node{
        int data ;
        Node left ;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    // this is the code to insert the nodes 
    public static Node insert(Node root , int val){
        // if (root == null) {
        //     root = new Node(val);
        //     return root;
        // }
        // if (root.data > val) {
        //     root.left = insert(root.left, val);
        // }else{
        //     root.right = insert(root.right, val);
        // }
        // return root;
        if(root == null){
            root = new Node(val);
            return root;
        }
        if (val > root.data) {
            root.right = insert(root.right , val);
        }else{
            root.left = insert(root.left, val);
        }
        return root;
    }

    // inorder code to print
    public static void inorder(Node root){
        if (root == null) {
            return ;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    // TO search the code 
    // input :
    // output: 
    public static boolean search(Node root, int key){
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node findInOrderSuccessor(Node root){
        while (root.left != null) {
            root= root.left;
        }
        return root;
    }
    public static Node deleteNode(Node root , int val){
        // we are trying to find the root to delete first
        if (val > root.data) {
            root.right = deleteNode(root.right, val);
        }else if (val < root.data) {
            root.left = deleteNode(root.left, val);
            // after this we assume its found
        }else{
            // case 1 : no leaf 
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 : one leaf child
            if (root.left == null) {
                return root.right;
            }else if (root.right == null) {
                return root.left;
            }
            // case 3 : two child
            // here we attach the inorder successor i,e leftmost node in right subtree
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }
    
    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i=0;i<values.length;i++){
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        // if (search(root, 14)) {
        //     System.out.println("\nFound");
        // }else{
        //     System.out.println("\nNot found");
        // }
        // root = deleteNode(root, 10);
        // inorder(root);
    }
}
