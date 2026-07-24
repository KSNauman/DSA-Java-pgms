// package Binary_Tree01;

/**
 * Topic: Binary Tree
 * Problem: Subtree of Another Tree
 * 
 * Description: 
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree 
 * of root with the same structure and node values of subRoot and false otherwise.
 * 
 * Intuition:
 * 1. Find a node in the main tree that matches the root of the subRoot tree.
 * 2. If a match is found, check if the trees starting from both roots are identical.
 * 3. If not identical, recursively search in the left and right subtrees.
 * 
 * Complexity: O(N * M) Time in worst case (N = nodes in root, M = nodes in subRoot), 
 * O(N) Space (for recursive call stack).
 */
public class SubtreeOfAnotherTree {

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        /*
         * Main Tree:
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
        
        /*
         * Sub Tree:
         *              2
         *             / \
         *            4   5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println("Is Subtree: " + isSubtree(root, subRoot));
    }
}
