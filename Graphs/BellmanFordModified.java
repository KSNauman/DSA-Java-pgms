// package Graphs;

import java.util.ArrayList;

/**
 * Topic: Graphs
 * Problem: Bellman-Ford Algorithm (Using Edge List)
 * 
 * Description: 
 * Find the shortest paths from a single source vertex to all other vertices in a weighted graph.
 * This version uses a direct Edge List instead of an Adjacency List array for a more 
 * straightforward edge relaxation step.
 * 
 * Intuition:
 * Relax all edges V-1 times. A simple shortest path from src to any other vertex can have 
 * at most V-1 edges. Relaxing V-1 times guarantees the shortest path.
 * 
 * Complexity: O(V * E) Time, O(V) Space for distance array.
 */
public class BellmanFordModified {
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
    
    public static void createGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }
    
    public static void bellmanford(ArrayList<Edge> graph, int src, int V) {
        int[] dist = new int[V];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        
        // Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);
                int u = e.src;
                int v = e.dest;
                int weight = e.weight;
                
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("To node " + i + " -> " + dist[i]);
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        int V = 5;
        createGraph(graph);
        bellmanford(graph, 0, V);
    }
}
