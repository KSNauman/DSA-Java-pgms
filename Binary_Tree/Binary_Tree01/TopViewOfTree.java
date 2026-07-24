// package Binary_Tree01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Topic: Binary Tree
 * Problem: Top View of Binary Tree
 * 
 * Description: 
 * Print the nodes of a binary tree as seen from the top. The top view is the set of 
 * nodes visible when the tree is viewed from the top.
 * 
 * Intuition:
 * Use Level Order Traversal (BFS) and assign a horizontal distance (hd) to each node. 
 * Root has hd = 0. Left child has hd - 1, and right child has hd + 1. 
 * Use a HashMap to store the first node encountered at each horizontal distance. 
 * Since we do BFS, the first node at any 'hd' will be the topmost node at that distance.
 * 
 * Complexity: O(N) Time, O(N) Space (for Queue and HashMap).
 */
public class TopViewOfTree {
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

    static class Info {
        Node node;
        int hd;

        Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void tpview(Node root) {
        if (root == null) return;
        
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info(root, 0));
        q.add(null);
        
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                // If this is the first time we see this horizontal distance, add to map
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        
        // Print the top view
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
         *          1 
         *         / \
         *        2   3
         *       / \ / \
         *      4  5 6  7
         */        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);    
        root.left.right = new Node(5);    
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        System.out.print("Top View: ");
        tpview(root);
    }
}
