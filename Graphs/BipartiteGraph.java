// package Graphs;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Topic: Graphs
 * Problem: Bipartite Graph Checking
 * 
 * Description: 
 * Determine whether a given graph is Bipartite or not. A bipartite graph is a graph 
 * whose vertices can be divided into two disjoint and independent sets such that every 
 * edge connects a vertex in one set to one in the other set (i.e. can be colored using 2 colors).
 * 
 * Intuition:
 * Use BFS (or DFS) to color the graph using two colors (0 and 1).
 * For each node, color all its neighbors with the opposite color.
 * If we find a neighbor that is already colored with the SAME color as the current node,
 * then the graph is NOT bipartite. (This implies it contains an odd-length cycle).
 * 
 * Complexity: O(V + E) Time, O(V) Space.
 */
public class BipartiteGraph {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        
        // Initialize all as uncolored
        for (int i = 0; i < graph.length; i++) {
            col[i] = -1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        // Handle disconnected components
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0; // Color with 0 (e.g., Yellow)
                
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        
                        // If neighbor is uncolored, assign opposite color
                        if (col[e.dest] == -1) {
                            col[e.dest] = (col[curr] == 1) ? 0 : 1;
                            q.add(e.dest);
                        } 
                        // If neighbor has the same color, not bipartite
                        else if (col[curr] == col[e.dest]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        
        System.out.println("Is the graph bipartite? " + isBipartite(graph));
    }
}
