package Graphs;

import java.security.interfaces.EdECKey;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
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
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v , int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p){
            return this.cost-p.cost;
        }
    }
/**
 * This function calculates the minimum cost spanning tree of a given graph using Prim's algorithm.
 * It uses a priority queue to keep track of the vertices and their corresponding costs.
 * The total cost of the spanning tree is printed at the end.
 */
    public static void prims(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int totalCost = 0;
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                totalCost+=curr.cost;
                for(int i=0 ; i<graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.weight));
                }
            }
        }
        System.out.println("Total cost : "+totalCost);
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[4];
        createGraph(graph);
        prims(graph);
    }
}
