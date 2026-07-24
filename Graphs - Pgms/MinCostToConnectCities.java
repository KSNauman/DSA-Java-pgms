import java.util.PriorityQueue;

/**
 * Topic: Graphs
 * Problem: Minimum Cost to Connect All Cities
 * 
 * Description: 
 * You are given a 2D array representing the cost of connecting city i with city j.
 * Find the minimum cost to connect all cities such that there is at least one path between any two cities.
 * This is an application of Prim's Algorithm to find the Minimum Spanning Tree (MST) from an Adjacency Matrix.
 * 
 * Intuition:
 * We can model this as a graph where cities are vertices and costs are edge weights.
 * Using a Priority Queue, we always select the edge with the minimum cost that connects 
 * a visited city to an unvisited city.
 * 
 * Complexity: O(V^2 log V) Time because of Priority Queue operations on matrix, O(V) Space.
 */
public class MinCostToConnectCities {
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost; // Ascending order
        }
    }

    public static int minCost(int[][] cities) {
        boolean[] vis = new boolean[cities.length];
        int totalCost = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Start from city 0 with cost 0
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                totalCost += curr.cost;

                // Add neighbors
                for (int i = 0; i < cities[curr.dest].length; i++) {
                    // if cost is not 0 (meaning there's a path) and destination is not visited
                    if (cities[curr.dest][i] != 0 && !vis[i]) {
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[][] cities = {
            {0, 1, 2, 3, 4},
            {1, 0, 5, 0, 7},
            {2, 5, 0, 6, 0},
            {3, 0, 6, 0, 0},
            {4, 7, 0, 0, 0}
        };

        System.out.println("Minimum Cost to connect all cities: " + minCost(cities));
    }    
}
