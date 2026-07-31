## Theory: Binary Trees (Part 2) & Advanced Patterns

Once fundamental traversals and construction algorithms are mastered, advanced technical evaluations assess the ability to utilize DFS and BFS recursively to solve complex structural queries.

### Core Algorithmic Patterns

#### 1. Lowest Common Ancestor (LCA)
The LCA of two nodes, `n1` and `n2`, is defined as the lowest node in the tree hierarchy that possesses both `n1` and `n2` as structural descendants (where a node is permitted to be a descendant of itself).
*   **Operational Logic**: Traverse the tree utilizing a bottom-up DFS approach. If the current node matches either `n1` or `n2`, return the current node. Concurrently recursively evaluate the left and right subtrees. If both subtrees return non-null references, the current intersection node is definitively the LCA.

#### 2. Tree Diameter
The diameter of a binary tree is defined as the length of the longest continuous path connecting any two nodes within the structure. Crucially, this optimal path may or may not traverse through the absolute root node.
*   **Operational Logic**: The diameter calculation necessitates a specialized $O(N)$ DFS traversal. At any given node, the maximum possible path passing through it is the sum of the maximum depth of its left subtree and the maximum depth of its right subtree. The algorithm must continuously update a global maximum diameter metric while simultaneously returning subtree depth data to parent nodes.

#### 3. Subtree Validation
Ascertaining whether a smaller tree structure `S` exists as a strictly identical structural and value-based match within a larger tree structure `T`.
*   **Operational Logic**: Implement a dual-phase recursive evaluation. First, initiate a DFS to locate a node within `T` that exhibits value parity with the root of `S`. Upon structural intersection, initiate a secondary recursive function to enforce strict structural and value-based identicality across all descending hierarchical levels.

#### 4. Top View (and general vertical traversals)
The top view represents the set of nodes visible when the hierarchical structure is evaluated from a strictly superior vertical orientation.
*   **Operational Logic**: Necessitates a BFS level-order traversal coupled with coordinate-based state management. Each node is assigned a horizontal displacement metric (Horizontal Distance, HD), where the root is 0, a left child is `HD - 1`, and a right child is `HD + 1`. A HashMap tracks the first node encountered for every unique HD scalar.

### Essential Interview Applications (Part 2)

1.  **Lowest Common Ancestor**: A fundamental assessment of bottom-up recursive data propagation.
2.  **Diameter of Binary Tree**: Evaluates the capacity to extract disparate metric data (diameter) during a standard depth calculation traversal.
3.  **Top View / Vertical Order Traversal**: Advanced spatial mapping requiring synchronized coordinate management during traversal protocols.

---
