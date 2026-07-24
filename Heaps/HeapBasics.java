// package Heaps;

import java.util.ArrayList;

/**
 * Topic: Heaps
 * Problem: Min Heap Implementation
 * 
 * Description: 
 * Implement a Min Heap data structure using an ArrayList. It should support 
 * insertion, peeking at the minimum element, and removing the minimum element.
 * 
 * Intuition:
 * A Heap is a Complete Binary Tree represented as an array. 
 * For any node at index i:
 * - Left child is at (2*i) + 1
 * - Right child is at (2*i) + 2
 * - Parent is at (i - 1) / 2
 * In a Min Heap, every parent node is smaller than its children.
 * When inserting, we add at the end and 'bubble up' (heapify-up).
 * When removing, we swap the root with the last element, remove the last, and 'bubble down' (heapify-down).
 * 
 * Complexity: O(log N) Time for insert/remove, O(1) for peek. O(N) Space.
 */
public class HeapBasics {
    static class MinHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);
            int child = arr.size() - 1;
            int par = (child - 1) / 2;

            // Heapify-up (Bubble up)
            while (child > 0 && arr.get(child) < arr.get(par)) {
                // Swap
                int temp = arr.get(par);
                arr.set(par, arr.get(child));
                arr.set(child, temp);
                
                // Move up
                child = par;
                par = (child - 1) / 2;
            }
        }

        public int peek() {
            if (arr.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;
            int minVal = i;

            if (left < arr.size() && arr.get(left) < arr.get(minVal)) {
                minVal = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(minVal)) {
                minVal = right;
            }
            if (minVal != i) {
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minVal));
                arr.set(minVal, temp);

                // Recursively heapify the affected sub-tree
                heapify(minVal);
            }
        }

        public int remove() {
            if (arr.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            
            int data = arr.get(0);

            // Step 1: Swap root with last element
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            
            // Step 2: Delete the last element
            arr.remove(arr.size() - 1);
            
            // Step 3: Heapify-down (Bubble down)
            if (!arr.isEmpty()) {
                heapify(0);
            }
            
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        MinHeap hp = new MinHeap();
        hp.add(3);
        hp.add(1);
        hp.add(7);
        hp.add(5);
        
        System.out.println("Elements removed in ascending order (Heap Sort property):");
        while (!hp.isEmpty()) {
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}
