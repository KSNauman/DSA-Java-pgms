// package Binary_Tree01;

/**
 * Topic: Binary Tree
 * Problem: Height, Count, and Sum of Nodes
 * 
 * Description: 
 * Calculate three basic properties of a Binary Tree:
 * 1. Height: Longest path from root to a leaf node.
 * 2. Count: Total number of nodes in the tree.
 * 3. Sum: Sum of all node values in the tree.
 * 
 * Intuition:
 * Use post-order traversal logic (process left and right subtrees first, then root).
 * - Height = max(left_height, right_height) + 1
 * - Count = left_count + right_count + 1
 * - Sum = left_sum + right_sum + root.val
 * 
 * Complexity: O(N) Time, O(N) Space (for recursive call stack).
 */
public class HeightOfTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null; // Corrected from this.left = left;
            this.right = null; // Corrected from this.right = right;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return lc + rc + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + sum(root.right) + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        
        System.out.println("Height: " + height(root));
        System.out.println("Count: " + count(root));
        System.out.println("Sum: " + sum(root));
    }
}
