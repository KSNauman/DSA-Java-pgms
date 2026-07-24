package Graphs;

import java.util.ArrayList;

public class Bellmann {
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
    public static void create(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length ; i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));
    }
    public static void bellmanford(ArrayList<Edge>[] graph){
        // TC is O(VE) , V is vertices and E is edges 
        int[] dist = new int[graph.length];
        for(int i=0 ; i<dist.length ; i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[0] = 0;
        int V = dist.length;
        for(int i=0 ; i<V-1;i++){
            for(int j=0 ;j<V ; j++){
                for(int k=0;k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    int u=e.src;
                    int v = e.dest;
                    int weight = e.weight;
                    if (dist[u]!= Integer.MAX_VALUE&&dist[u]+weight < dist[v]) {
                        dist[v] = dist[u]+weight;
                    }
                }
            }
        }
        System.out.println("Distances:");
        for(int i=0 ; i<dist.length; i++){
            System.out.println(dist[i]);
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        create(graph);
        bellmanford(graph);
    }
}
