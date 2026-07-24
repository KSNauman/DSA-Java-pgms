// package Graphs;

import java.util.ArrayList;

/**
 * Topic: Graphs
 * Problem: Bellman-Ford Algorithm (Using Adjacency List)
 * 
 * Description: 
 * Find the shortest paths from a single source vertex to all other vertices in a weighted graph.
 * Unlike Dijkstra's, it works for graphs with negative weight edges and can detect negative weight cycles.
 * 
 * Intuition:
 * Relax all edges V-1 times. A simple shortest path from src to any other vertex can have 
 * at most V-1 edges. Relaxing V-1 times guarantees the shortest path.
 * If we can still relax edges on the Vth iteration, a negative weight cycle exists.
 * 
 * Complexity: O(V * E) Time, O(V) Space for distance array.
 */
public class BellmanFord {
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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }
    
    public static void bellmanford(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;
        
        // Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int weight = e.weight;
                    
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }
        
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("To node " + i + " -> " + dist[i]);
        }
    }
    
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        bellmanford(graph, 0);
    }
}
