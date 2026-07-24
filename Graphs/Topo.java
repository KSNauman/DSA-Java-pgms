package Graphs;

import java.util.*;
public class Topo {
    static class Edge {
        int src;
        int dest;
        int weight;
        public Edge(int src , int dest , int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0 ; i<graph.length ; i++){
            graph[i]=new ArrayList<>();
        }
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 1, 1));
    }
    public static void topologicalSort(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0 ; i<graph.length ; i++){
            if (!vis[i]) {
                topologicalSortUtil(graph,vis,i,stk);
            }
        }
        while (!stk.isEmpty()) {
            System.out.println(stk.pop()+" ");
        }
    }
    public static void topologicalSortUtil(ArrayList<Edge>[] graph , boolean[] vis,int curr , Stack<Integer> stk){
        vis[curr] = true;
        for(int i=0 ; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topologicalSortUtil(graph,vis,e.dest,stk);
            }
        }
        stk.push(curr);
    }
    public static void kahn(ArrayList<Edge>[] graph){
        // Topological Sorting using BFS
        Queue<Integer> q = new LinkedList<>();
        // step 1 : calc inorder
        int[] inorder = new int[graph.length];
        calcInorder(graph, inorder);
        // step 2 : add inorder 0 values to queue
        for(int i=0;i<graph.length;i++){
            if (inorder[i] == 0) {
                q.add(i);
            }
        }
        // step 3 : process queue (bfs) add and removing from queue
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr+" ");
            for(int i=0;i<graph[curr].size() ; i++){
                Edge e = graph[curr].get(i);
                inorder[e.dest]--;
                if (inorder[e.dest]==0) {
                    q.add(e.dest);
                }
            }
        }
    }
    // Helper function for Kahn algo (topo using BFS)
    public static void calcInorder(ArrayList<Edge>[] graph , int[] inorder){
        for(int i=0 ; i<graph.length ; i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                inorder[e.dest]++;
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        kahn(graph);
    }
}
