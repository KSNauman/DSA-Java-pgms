package Binary_Tree02;

import java.util.ArrayList;

public class LCA {
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
    public static boolean getPath(Node root , int n,ArrayList<Node> path){
        // tc: O(n) => n+n+n = 3n => n
        // but space complexity is n
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.val == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);
        if (foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public static Node leastCommonAncestor(Node root,int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);
        int i=0;
        for(;i<path1.size()&&i<path2.size();i++){
            if (path1.get(i)!=path2.get(i)) {
                break;
            }
        }
        Node lca = path1.remove(i-1);
        return lca;
    }
    
    public static Node lca2(Node root,int n1, int n2){
        if (root == null || root.val == n1||root.val==n2) {
            return root;
        }
        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        if (leftlca == null) {
            return rightlca;
        }
        if (rightlca == null) {
            return leftlca;
        }
        return root;
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
        int n1 = 4 , n2 = 7;
        // Node result = leastCommonAncestor(root, n1, n2);
        Node result = lca2(root, n1, n2);
        System.out.println(result.val);
    }
}
