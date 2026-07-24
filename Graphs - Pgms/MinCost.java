import java.util.PriorityQueue;

import Recursion01.rec;

public class MinCost {
    static class Edge implements Comparable<Edge>{
        int dest;
        int cost;
        public Edge(int dest , int cost){
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }
    public static int minCst(int[][] cities){
        boolean[] vis = new boolean[cities.length];
        int totalCost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                totalCost += curr.cost;

                for(int i=0 ; i< cities[dest].length)
            }
        }


        return totalCost;
    }
    public static void main(String[] args) {
        int cities[] [] = {{0, 1, 2, 3, 4},
                            {1, 0, 5,0,7},
                            {2, 5, 0, 6, 0},
                            {3, 0, 6, 0, 0},
                            {4, 7, 0, 0, 0}};
    }    
}
