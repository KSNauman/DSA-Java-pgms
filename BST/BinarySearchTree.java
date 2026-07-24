// package BST;

/**
 * Topic: Binary Search Tree (BST)
 * Problem: BST Operations (Insert, Search, Delete, Inorder)
 * 
 * Description: 
 * Implementation of a Binary Search Tree (BST) supporting fundamental operations:
 * - Insertion of new nodes.
 * - Inorder traversal (which gives sorted output).
 * - Searching for a key.
 * - Deletion of a node (handling 3 cases: leaf node, single child, two children).
 * 
 * Intuition:
 * - Insert/Search: Compare value with root. If smaller, go left. If greater, go right.
 * - Delete: 
 *   - Case 1 (0 children): Return null.
 *   - Case 2 (1 child): Return the non-null child.
 *   - Case 3 (2 children): Replace node's value with its Inorder Successor 
 *     (smallest value in right subtree) and recursively delete the Inorder Successor.
 * 
 * Complexity: O(H) Time for Insert, Search, Delete (where H is the height of tree).
 * O(N) Time for Inorder traversal. O(H) Space for call stack.
 */
public class BinarySearchTree {
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

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val > root.data) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node deleteNode(Node root, int val) {
        if (root == null) return null;

        if (val > root.data) {
            root.right = deleteNode(root.right, val);
        } else if (val < root.data) {
            root.left = deleteNode(root.left, val);
        } else {
            // Case 1: No child (Leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            Node IS = findInOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        
        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();
        
        int key = 14;
        System.out.println("Search " + key + ": " + (search(root, key) ? "Found" : "Not Found"));
        
        System.out.println("Deleting 5...");
        root = deleteNode(root, 5);
        System.out.print("Inorder traversal after deletion: ");
        inorder(root);
        System.out.println();
    }
}
