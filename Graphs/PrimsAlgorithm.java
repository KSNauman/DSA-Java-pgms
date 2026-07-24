// package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Topic: Graphs
 * Problem: Prim's Algorithm (Minimum Spanning Tree)
 * 
 * Description: 
 * Find the Minimum Spanning Tree (MST) of a connected, undirected graph with weighted edges.
 * 
 * Intuition:
 * Start from an arbitrary node and add it to the MST. At each step, pick the cheapest edge 
 * that connects a node in the MST to a node outside the MST. We use a Priority Queue to 
 * efficiently find the minimum weight edge.
 * 
 * Complexity: O(E log V) Time, O(V) Space for priority queue.
 */
public class PrimsAlgorithm {
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

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Undirected edges
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost - p.cost; // Ascending order
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int totalCost = 0;
        
        // Start from node 0
        pq.add(new Pair(0, 0));
        
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                totalCost += curr.cost;
                
                // Add all unvisited neighbors to PQ
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }
        System.out.println("Total Cost of Minimum Spanning Tree: " + totalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        
        prims(graph);
    }
}
