// package Graphs;

import java.util.ArrayList;

/**
 * Topic: Graphs
 * Problem: Graph Representation using Adjacency List
 * 
 * Description: 
 * Implement a Graph using an Adjacency List and traverse its immediate neighbors.
 * 
 * Intuition:
 * An Adjacency List is an array of Lists (or ArrayLists). Each array index represents a vertex,
 * and the list at that index contains all the edges originating from that vertex.
 * This is an efficient way to represent sparse graphs compared to an Adjacency Matrix.
 * 
 * Complexity: O(V + E) Space, O(V) Time to find neighbors of a specific vertex.
 */
public class GraphBasics {
    static class Edge {
        int src;
        int dest;
        int weight;
        
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        // Array of ArrayLists
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        
        // Initialize ArrayList for each vertex
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 0 vertex
        graph[0].add(new Edge(0, 1, 5));
        
        // 1 vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        
        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // 3 vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 2, 1));

        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));

        // Print neighbours of vertex 2
        System.out.println("Neighbors of vertex 2:");
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println("Edge from " + e.src + " to " + e.dest + " with weight " + e.weight);
        }
    }    
}
