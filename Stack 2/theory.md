## Theory: Advanced Stack Patterns (Monotonic Stacks)

While basic stacks are utilized for standard Last-In-First-Out (LIFO) operations, advanced stack problems frequently necessitate a structural pattern known as the **Monotonic Stack**.

### Monotonic Stack Fundamentals

A monotonic stack is a variation where elements are maintained in a strictly **increasing** or strictly **decreasing** order.

*   **Monotonic Increasing Stack:** Elements are sorted in increasing order from the base to the top of the stack. This structure is typically deployed to ascertain the **Next Smaller Element**.
*   **Monotonic Decreasing Stack:** Elements are sorted in decreasing order from the base to the top of the stack. This structure is typically deployed to ascertain the **Next Greater Element**.

### Operational Mechanism

Consider the objective of identifying the "Next Greater Element" in a given array: `[2, 1, 5, 6, 2, 3]`.

During iteration, prior to pushing an element onto the stack, all elements inferior in value to the current element are **popped** from the stack. Consequently, the current element is confirmed as the "Next Greater Element" for those popped values.

This methodology optimizes a standard $O(N^2)$ exhaustive search into a linear **$O(N)$ time complexity**, as each element is subjected to exactly one push and one pop operation.

![Monotonic Stack Example](https://miro.medium.com/v2/resize:fit:1200/1*CpdE-eXzSgY2K3p5uO0Lqg.png)

### Essential Interview Applications

1.  **Next Greater Element (NGE)**: The foundational algorithmic challenge. Variations necessitate bidirectional scanning or application on circular arrays.
2.  **Next Smaller Element (NSE)**: Functionally identical to NGE, utilizing an increasing stack paradigm.
3.  **Stock Span Problem**: Calculating the maximum consecutive preceding duration where the evaluation metric was inferior or equal to the current metric.
4.  **Largest Rectangle in Histogram**: An advanced application utilizing NSE to determine optimal lateral boundaries for maximal area computation.
5.  **Trapping Rain Water**: Utilizing a Monotonic Decreasing Stack to efficiently compute bounded volumetric constraints.

---
