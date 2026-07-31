## Theory: Arrays (Part 2) & Advanced Patterns

Advanced technical evaluations frequently necessitate the optimization of brute-force $O(N^2)$ or $O(N^3)$ algorithms into linear $O(N)$ solutions utilizing sophisticated structural patterns.

### Core Algorithmic Patterns

#### 1. Prefix Sum Arrays
When evaluating the scalar sum of arbitrary subarrays `arr[i...j]`, isolated computation requires $O(N)$ complexity per query. 
By generating a **Prefix Sum Array** where `prefix[i] = prefix[i-1] + arr[i]`, any subarray sum can be resolved in constant **$O(1)$ time**:
`Sum(i, j) = prefix[j] - prefix[i-1]`

#### 2. Kadane's Algorithm (Maximum Subarray Sum)
A dynamic programming strategy utilized to resolve the maximum contiguous subarray sum within $O(N)$ time.
*   **Operational Logic**: Maintain a cumulative `current_sum` during linear traversal. Should `current_sum` depreciate below zero, it ceases positive contribution to subsequent sequences and must be reset to zero. Concurrently track the maximum sequence observed.

![Kadanes Algorithm](https://media.geeksforgeeks.org/wp-content/uploads/20240321111003/Kadane%E2%80%99s-Algorithm-1.webp)

#### 3. Trapping Rain Water (Two Pointers / Precomputation)
An advanced problem requiring boundary analysis. To calculate volumetric capacity above index `i`, algorithmic logic must ascertain the maximum boundary elevation to both the left and the right.
*   **Capacity Computation**: `Water at i = min(max_left, max_right) - height[i]`
*   This is typically resolved in $O(N)$ time with $O(N)$ auxiliary space via prefix structures, or optimized to $O(1)$ space utilizing an advanced Two-Pointer convergence technique.

#### 4. Best Time to Buy and Sell Stock
A fundamental state-tracking algorithm prioritizing temporal variance.
*   **Operational Logic**: Continuously update the minimum scalar observed and calculate the resultant delta (profit) against current iteration scalars.

### Essential Interview Applications (Part 2)

1.  **Max Subarray Sum**: Direct application of Kadane's Algorithm.
2.  **Trapping Rainwater**: Evaluation of advanced precomputation logic and spatial optimization.
3.  **Best Time to Buy and Sell Stock**: Temporal state assessment constraints.

---
