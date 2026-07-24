// package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Topic: Queue
 * Problem: Interleave Two Halves of a Queue
 * 
 * Description: 
 * Given a queue of integers of even length, rearrange the elements by interleaving 
 * the first half of the queue with the second half of the queue.
 * 
 * Intuition:
 * 1. Find the size of the queue.
 * 2. Dequeue the first half of the elements and enqueue them into a temporary queue `firstHalf`.
 * 3. While the `firstHalf` queue is not empty, alternately dequeue an element from `firstHalf` 
 *    and enqueue it to the original queue, then dequeue an element from the original queue 
 *    (which belongs to the second half) and enqueue it back to the original queue.
 * 
 * Complexity: O(N) Time, O(N) Space (for the temporary queue storing half the elements).
 */
public class InterleaveTwoHalvesOfQueue {

    public static void interleave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        
        // Step 1: Push first half of the queue to a temporary queue
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        // Step 2: Interleave elements from firstHalf and the remaining queue
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
        
        System.out.println("Original Queue: " + q);
        interleave(q);
        System.out.println("Interleaved Queue: " + q);
    }
}
