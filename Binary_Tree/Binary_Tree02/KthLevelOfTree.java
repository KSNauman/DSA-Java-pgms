// package Binary_Tree02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Topic: Binary Tree
 * Problem: Elements at Kth Level
 * 
 * Description: 
 * Print all elements of a binary tree that are exactly at level K.
 * (Assuming root is at level 1).
 * 
 * Intuition:
 * 1. Recursive Approach (DFS): Traverse left and right, passing `level + 1`. 
 *    When `level == k`, print the node.
 * 2. Iterative Approach (BFS): Use Level Order Traversal with a Queue. 
 *    Keep track of levels using a `null` marker. Print when current level == k.
 * 
 * Complexity: O(N) Time, O(N) Space (for call stack or queue).
 */
public class KthLevelOfTree {
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

    // Iterative Approach (BFS)
    public static void IterKLevel(Node root, int startLevel, int k) {
        if (root == null) return;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int level = startLevel;

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
                level++;
            } else {
                if (level == k) {
                    System.out.print(curr.val + " ");
                }
                if (level < k) {
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

    // Recursive Approach (DFS)
    public static void KLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.val + " ");
            return;
        }
        KLevel(root.left, level + 1, k);
        KLevel(root.right, level + 1, k);
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

        int k = 3;
        System.out.print("Recursive Kth Level: ");
        KLevel(root, 1, k);
        System.out.println();
        
        System.out.print("Iterative Kth Level: ");
        IterKLevel(root, 1, k);
        System.out.println();
    }
}
