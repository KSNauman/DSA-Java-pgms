package Binary_Tree02;

public class MinDist {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static Node lca(Node root , int n1 , int n2){
        if (root == null|| root.val == n1|| root.val == n2) {
            return root;
        }

        Node llca = lca(root.left, n1, n2);
        Node rlca = lca(root.right, n1, n2);

        if (llca == null) {
            return rlca;
        }
        if (rlca == null) {
            return llca;
        }
        return root;
    }
    public static int minDistance(Node root , int n){
        if (root == null) {
            return -1;
        }
        if (root.val == n) {
            return 0;
        }
        int leftMinDist = minDistance(root.left , n);
        int rightMinDist = minDistance(root.right , n);
        
        if (leftMinDist==-1&&rightMinDist==-1) {
            return -1;
        }else if (leftMinDist == -1) {
            return rightMinDist+1;
        }else{
            return leftMinDist+1;
        }
    }
    public static int distance(Node root, int n1 , int n2){
        Node lcaNode = lca(root, n1, n2);
        int leftDist = minDistance(lcaNode, n1);
        int rightDist = minDistance(lcaNode, n2);
        return leftDist+rightDist;
        

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
        int n1 = 4 , n2 = 6;
        System.out.println(distance(root, n1, n2));
    }
}
/*
 * fr this problem we need to find lca because if the node exist 
 * then is true that the distance shld pass through the lca
 */