// package PriorityQueue;

import java.util.PriorityQueue;

/**
 * Topic: Priority Queue
 * Problem: Priority Queue with Custom Objects
 * 
 * Description: 
 * Demonstrate how to use a Priority Queue with custom objects by implementing 
 * the Comparable interface.
 * 
 * Intuition:
 * By default, PriorityQueue in Java uses a Min-Heap. For custom objects, Java doesn't know 
 * how to compare them. We must implement the Comparable interface and override the `compareTo` 
 * method to define the sorting logic (e.g., sorting students by their rank).
 * 
 * Complexity: O(log N) Time for insertion and removal. O(N) Space.
 */
public class PriorityQueueObjects {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            // Ascending order based on rank
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        
        pq.add(new Student("Nauman", 2));
        pq.add(new Student("KS", 1));
        pq.add(new Student("Ahmed", 3));
        
        System.out.println("Students ordered by Rank (Priority Queue):");
        while (!pq.isEmpty()) {
            Student curr = pq.peek();
            System.out.println(curr.name + " -> Rank " + curr.rank);
            pq.remove();
        }
    }
}