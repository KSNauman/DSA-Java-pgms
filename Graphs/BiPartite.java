package Graphs;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BiPartite {
    static class Edge{
        int src;
        int dest;
        Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        // 0 edge
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 1 edge
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        
        // 2 edge
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        
        //  3 edge
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        // 4 edge
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBiPartite(ArrayList<Edge>[] graph){
        // color array
        int[] col = new int[graph.length];

        for(int i=0 ; i<graph.length ; i++){
            col[i] = -1;// no color    
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<graph.length ; i++){
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0; // Yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0 ; j<graph[curr].size() ;j++){
                        Edge e = graph[curr].get(j);
                        if (col[e.dest]==-1 ) {
                            col[e.dest]= col[curr]==1?0:1;
                            q.add(e.dest);
                        }else if(col[curr] == col[e.dest]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[5];
        createGraph(graph);
        System.out.println(isBiPartite(graph));
    }
}
