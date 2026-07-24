// package Binary_Tree;

/**
 * Topic: Binary Tree
 * Problem: Binary Tree Node Structure
 * 
 * Description: 
 * A fundamental class representing a single node in a Binary Tree.
 * Each node contains a data value and references to its left and right child nodes.
 * 
 * Intuition:
 * Used as the building block for all Binary Tree algorithms.
 * 
 * Complexity: 
 * Time: O(1) to create a node.
 * Space: O(1) space overhead per node.
 */
public class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}