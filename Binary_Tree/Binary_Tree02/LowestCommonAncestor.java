// package Binary_Tree02;

import java.util.ArrayList;

/**
 * Topic: Binary Tree
 * Problem: Lowest Common Ancestor (LCA)
 * 
 * Description: 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * Intuition:
 * 1. Approach 1 (Path saving): Find root-to-node paths for both nodes. Compare paths 
 *    until they diverge. The last matching node is the LCA. Requires O(N) space for paths.
 * 2. Approach 2 (Recursive): If current node is one of the nodes, return it. 
 *    Recursively search left and right subtrees. If one subtree returns null, 
 *    the LCA is in the other. If both return non-null, the current node is the LCA.
 * 
 * Complexity:
 * - Approach 1: O(N) Time, O(N) Space (for arrays).
 * - Approach 2: O(N) Time, O(N) Space (for call stack).
 */
public class LowestCommonAncestor {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Approach 1 Helper: Get path from root to target node
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
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
        path.remove(path.size() - 1); // backtrack
        return false;
    }

    // Approach 1: Path array based LCA
    public static Node leastCommonAncestor(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);
        
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i - 1);
        return lca;
    }

    // Approach 2: Recursive LCA (Optimized Space)
    public static Node lca2(Node root, int n1, int n2) {
        if (root == null || root.val == n1 || root.val == n2) {
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
        return root; // Both left and right are not null, so this is the LCA
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
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 7;
        Node result1 = leastCommonAncestor(root, n1, n2);
        Node result2 = lca2(root, n1, n2);
        
        System.out.println("LCA (Path Method): " + result1.val);
        System.out.println("LCA (Recursive Method): " + result2.val);
    }
}
