// package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Topic: Graphs
 * Problem: Dijkstra's Algorithm
 * 
 * Description: 
 * Find the shortest paths from a source vertex to all other vertices in a weighted graph.
 * 
 * Intuition:
 * Use a Priority Queue to always pick the vertex with the minimum known distance.
 * For the picked vertex, relax its neighbors (i.e., update their shortest distance if 
 * the path through the current vertex is shorter than the known distance). 
 * Greedy choice guarantees the shortest path for graphs with non-negative edge weights.
 * 
 * Complexity: O(E + V log V) Time using Priority Queue, O(V) Space.
 */
public class DijkstrasAlgorithm {
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

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        graph[3].add(new Edge(3, 5, 1));
    }
    
    static class Pair implements Comparable<Pair> {
        int node;
        int pathDistance;

        public Pair(int node, int pathDistance) {
            this.node = node;
            this.pathDistance = pathDistance;
        }

        @Override
        public int compareTo(Pair o) {
            return this.pathDistance - o.pathDistance; // Ascending order
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int[] dist = new int[graph.length];
        
        // Initialize all distances as Infinity
        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        boolean[] vis = new boolean[graph.length];

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            
            if (!vis[curr.node]) {
                vis[curr.node] = true;
                
                // Relaxation step
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }       
                }
            }
        }
        
        // Print shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("To node " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        
        dijkstra(graph, 0);
    }
}
