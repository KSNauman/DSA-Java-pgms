## Theory: Arrays (Part 1) & Foundational Patterns

An **Array** is a primary data structure comprising a collection of items stored at contiguous memory allocations. This structural architecture permits efficient data storage and random access via indexing operations.

In the Java language environment, arrays are dynamically allocated objects characterized by a fixed, immutable size post-instantiation.

![Array Memory Representation](https://media.geeksforgeeks.org/wp-content/uploads/20230302133108/Arrays-in-Java.png)

### Core Characteristics
- **Time Complexity for Access**: $O(1)$ - Contiguous memory allocation ensures immediate pointer arithmetic resolution.
- **Time Complexity for Search**: $O(N)$ for exhaustive linear search, $O(\log N)$ for Binary Search on a pre-sorted array structure.
- **Fixed Size Constraint**: Array boundaries cannot be dynamically expanded or contracted.

### Foundational Algorithmic Patterns

#### 1. The Two-Pointer Technique
The **Two-Pointer** paradigm is an essential optimization strategy for array operations. It replaces redundant nested iteration with synchronized traversal utilizing two independent index variables (`left` and `right`).

**Standard Applications:**
- **In-Place Array Reversal**: Symmetrical swapping of `array[left]` and `array[right]` while incrementing bounds toward the center.
- **Pair Identification (e.g., Two Sum on Sorted Arrays)**: Iterative boundary adjustment based on comparative sum evaluation against a target scalar.

#### 2. Binary Search 
On a **sorted** array domain, specific elements can be located in logarithmic $O(\log N)$ time through continuous bisection of the search space.
*   **Operational Logic**: Evaluate the central index. Terminate the subset containing values mathematically incapable of matching the target condition.

### Essential Interview Applications (Part 1)

1.  **Reverse Array in-place**: Assessment of basic Two-Pointer boundary conditions.
2.  **Binary Search Implementation**: Fundamental evaluation or requisite sub-operation for advanced search algorithms.
3.  **Pairs in Arrays**: Pair-sum evaluations.
4.  **Printing Subarrays**: Combinatorial generation of all contiguous structural subsets ($O(N^2)$ indices constraint).

---
