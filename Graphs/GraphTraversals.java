// package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Topic: Graphs
 * Problem: Graph Traversals and Cycle Detection
 * 
 * Description: 
 * Implementation of basic graph traversal algorithms:
 * 1. Breadth-First Search (BFS)
 * 2. Depth-First Search (DFS)
 * 3. Cycle Detection in Undirected Graph
 * 4. Cycle Detection in Directed Graph
 * 
 * Intuition:
 * - BFS uses a Queue to visit nodes level by level.
 * - DFS uses recursion (implicitly a Stack) to visit nodes as deep as possible.
 * - Undirected Cycle: A cycle exists if we visit an already visited node that is NOT the parent.
 * - Directed Cycle: A cycle exists if a visited node is also present in the current recursion stack.
 * 
 * Complexity: 
 * O(V + E) Time for BFS/DFS/Cycle Detection.
 * O(V) Space for visited array, queue, and recursion stack.
 */
public class GraphTraversals {
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

    public static void createGraphDir(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 5, 1));
    }

    // 1. Breadth-First Search (BFS)
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                bfsUtil(graph, vis, i);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis, int source) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // 2. Depth-First Search (DFS)
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }
    
    // 3. Detect Cycle in Undirected Graph
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1))
                    return true;
            }
        }
        return false;
    } 

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (vis[e.dest] && e.dest != par) {
                return true;
            }
        }
        return false;
    }

    // 4. Detect Cycle in Directed Graph
    public static boolean detectCycleDir(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stk = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i] && detectCycleDirUtil(graph, vis, stk, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycleDirUtil(ArrayList<Edge>[] graph, boolean[] vis, boolean[] stk, int curr) {
        vis[curr] = true;
        stk[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stk[e.dest]) {
                return true;
            } else if (!vis[e.dest] && detectCycleDirUtil(graph, vis, stk, e.dest)) {
                return true;
            }
        }
        stk[curr] = false;
        return false;
    } 
    
    public static void main(String[] args) {
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraphDir(graph);
        
        System.out.print("BFS Traversal: ");
        bfs(graph);
        System.out.println();
        
        System.out.print("DFS Traversal: ");
        dfs(graph);
        System.out.println();
        
        System.out.println("Contains Directed Cycle? " + detectCycleDir(graph));
    }
}