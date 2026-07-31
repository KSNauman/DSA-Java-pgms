## Theory: 2D Arrays & Matrices

A **2D Array** (or Matrix) constitutes a multi-dimensional array mapping data across specified rows and columns. Within the Java runtime, it is syntactically declared and instantiated as `int[][] matrix = new int[rows][cols]`.

Matrices represent a highly prioritized subject domain in technical evaluations, frequently necessitating complex non-linear traversal algorithms, optimized coordinate searching, or spatial manipulations (such as matrix rotations).

![2D Array Layout](https://media.geeksforgeeks.org/wp-content/uploads/20230302115124/Two-Dimensional-Array-in-C.png)

### Core Algorithmic Patterns

#### 1. Spiral Traversal
A foundational matrix simulation algorithm requiring perimeter traversal followed by iterative boundary constriction.
*   **Operational Logic**: Initialize state variables for `top`, `bottom`, `left`, and `right` indices. Execute sequential traversals across the superior row, the rightmost column, the inferior row, and the leftmost column. Upon completion of a full perimeter cycle, increment `top` and `left` coordinates, and decrement `bottom` and `right` coordinates. Terminate when boundaries intersect.

#### 2. Staircase Search (Search in a Sorted 2D Matrix)
If a matrix maintains ascending sort constraints across both rows and columns, target identification can be optimized to $O(N + M)$ time complexity rather than the exhaustive $O(N \times M)$.
*   **Operational Logic**: Initialize search coordinates at the superior-right (top-right) junction. 
    *   If `matrix[r][c] == target`, terminate and return.
    *   If `matrix[r][c] > target`, decrement column index (`c--`) as all inferior indices in the active column represent greater magnitudes.
    *   If `matrix[r][c] < target`, increment row index (`r++`) as all preceding indices in the active row represent lesser magnitudes.

#### 3. 2D Prefix Sums
Extrapolating from 1D logic, 2D prefix structures enable constant $O(1)$ querying of any sub-matrix sum subsequent to an initial $O(N \times M)$ precomputation phase.
*   `prefix[i][j]` encapsulates the cumulative sum of elements bounded within the rectangular coordinates `(0, 0)` to `(i, j)`.
*   Summation queries for arbitrary sub-matrices bounded by `(r1, c1)` and `(r2, c2)` require overlapping region reconciliation utilizing the mathematical Inclusion-Exclusion Principle.

### Essential Interview Applications

1.  **Spiral Matrix**: Primary evaluation of algorithmic state management and traversal logic.
2.  **Staircase Search (Search a 2D Matrix II)**: Assessment of greedy pathfinding algorithms on structurally sorted grids.
3.  **Diagonal Sum**: Coordinate-based mathematical indexing operations.
4.  **Rotate Image (Matrix)**: Complex spatial manipulation (typically resolved via matrix transposition followed by lateral row reversal).

---
