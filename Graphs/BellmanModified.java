package Graphs;

import java.util.ArrayList;

public class BellmanModified{
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int src,int dest,int weight ){
            this.src=src;
            this.dest = dest;
            this.weight=weight;
        }
    }
    public static void create(ArrayList<Edge> graph){
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }
    public static void bellmanford(ArrayList<Edge> graph,int src, int V){
        // TC is O(VE) , V is vertices and E is edges 
        int[] dist = new int[V];
        for(int i=0 ; i<dist.length ; i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src] = 0;
        for(int i=0 ; i<V-1;i++){
            for(int j=0 ;j<graph.size() ; j++){
                    Edge e = graph.get(j);
                    int u=e.src;
                    int v = e.dest;
                    int weight = e.weight;
                    if (dist[u]!= Integer.MAX_VALUE&&dist[u]+weight < dist[v]) {
                        dist[v] = dist[u]+weight;
                }
            }
        }
        System.out.println("Distances:");
        for(int i=0 ; i<dist.length; i++){
            System.out.println(dist[i]);
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        create(graph);
        bellmanford(graph,0,5);
    }
}
