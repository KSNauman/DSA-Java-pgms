// package Graphs;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Topic: Graphs
 * Problem: Topological Sort (DFS & Kahn's Algorithm)
 * 
 * Description: 
 * Perform Topological Sort on a Directed Acyclic Graph (DAG). It is a linear ordering of vertices 
 * such that for every directed edge U -> V, vertex U comes before V in the ordering.
 * 
 * Intuition:
 * 1. DFS Approach: Perform DFS and when a node's children are fully processed, push the node onto a stack. 
 *    Finally, pop elements from the stack to get the ordering.
 * 2. BFS Approach (Kahn's Algorithm): Calculate in-degree of all nodes. Enqueue nodes with 0 in-degree. 
 *    Pop a node, print it, and reduce the in-degree of its neighbors by 1. If a neighbor's in-degree 
 *    becomes 0, enqueue it.
 * 
 * Complexity: O(V + E) Time, O(V) Space for both approaches.
 */
public class TopologicalSort {
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
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
    }

    // 1. DFS based Topological Sort
    public static void topologicalSortDFS(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> stk = new Stack<>();
        
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSortUtil(graph, vis, i, stk);
            }
        }
        
        while (!stk.isEmpty()) {
            System.out.print(stk.pop() + " ");
        }
    }

    private static void topologicalSortUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, Stack<Integer> stk) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topologicalSortUtil(graph, vis, e.dest, stk);
            }
        }
        stk.push(curr); // Push node to stack only after all its dependencies are visited
    }

    // 2. BFS based Topological Sort (Kahn's Algorithm)
    public static void topologicalSortBFS(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] inorder = new int[graph.length];
        
        // Step 1: Calculate In-degree
        calcInorder(graph, inorder);
        
        // Step 2: Add nodes with 0 in-degree to queue
        for (int i = 0; i < graph.length; i++) {
            if (inorder[i] == 0) {
                q.add(i);
            }
        }
        
        // Step 3: Process Queue
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inorder[e.dest]--;
                if (inorder[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
    }

    private static void calcInorder(ArrayList<Edge>[] graph, int[] inorder) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inorder[e.dest]++;
            }
        }
    }
    
    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        
        System.out.print("Topological Sort (DFS): ");
        topologicalSortDFS(graph);
        System.out.println();
        
        System.out.print("Topological Sort (BFS Kahn's): ");
        topologicalSortBFS(graph);
        System.out.println();
    }
}
