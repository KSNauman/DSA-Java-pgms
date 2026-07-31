## Theory: Understanding Stacks

A **Stack** is a linear data structure governed by the **Last In, First Out (LIFO)** or **First In, Last Out (FILO)** principle. Operations are strictly confined to a single end, commonly referred to as the "top" of the stack.

![Stack Data Structure](https://upload.wikimedia.org/wikipedia/commons/b/b4/Lifo_stack.png)

### Core Operations

*   **`push(item)`**: Inserts an element at the top of the stack. (Time Complexity: $O(1)$)
*   **`pop()`**: Removes and returns the element at the top of the stack. (Time Complexity: $O(1)$)
*   **`peek()`** or **`top()`**: Retrieves the element at the top of the stack without removing it. (Time Complexity: $O(1)$)
*   **`isEmpty()`**: Evaluates whether the stack contains any elements. (Time Complexity: $O(1)$)

### Implementations

Stacks can be implemented via:
1.  **Arrays**: Static or dynamic size capacity. Optimal for fixed-size requirements.
2.  **Linked Lists**: Dynamic size capacity, unrestricted by fixed contiguous memory allocation.
3.  **Java Collections Framework**: `java.util.Stack` or preferably `java.util.Deque` (e.g., `ArrayDeque`).

### Essential Interview Applications

*   **Valid Parentheses**: Utilizing a stack to validate structural symmetry and enclosure matching.
*   **Implement Queue using Stacks**: Utilizing two stacks to simulate First-In-First-Out (FIFO) behavior.
*   **Min Stack**: Architecting a stack that supports `push`, `pop`, `top`, and minimum element retrieval in $O(1)$ constant time.

---
