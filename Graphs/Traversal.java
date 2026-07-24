package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    static class Edge{
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
    //     0
    //    / \
    //   /   \
    //  1     2
    //   \   / \
    //    \ /    \
    //     3 ----- 4
    //     |
    //     |
    //     5
    //     |
    //     |
    //     6
        for(int i=0 ; i<graph.length ; i++){
            graph[i]=new ArrayList<>();
        }
        //  0 Node
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        //  1 Node
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 Node
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 3, 1));

        //  3 Node
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 5, 1));

        //  4 Node
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5 Node
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6 Node
        graph[6].add(new Edge(6, 5, 1));
    }
    public static void createGraphDir(ArrayList<Edge>[] graph){
        for(int i=0 ; i<graph.length ; i++){
            graph[i]=new ArrayList<>();
        }
        // Nodes 
        // graph[1].add(new Edge(1, 0, 1));
        // graph[0].add(new Edge(0, 2, 1));
        // graph[3].add(new Edge(3, 2, 1));
        // graph[2].add(new Edge(2, 2, 1));

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 5, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if (!vis[i]) {
                bfsUtil(graph,vis,i);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph,boolean[] vis,int source){
        System.out.println("BFS: TC : O(L)");
        Queue<Integer> q = new LinkedList<>();

        q.add(source);//Added source 
        while (!q.isEmpty()) {
            int curr = q.remove();
            // print it first or visit it
            if (!vis[curr]) {
                System.out.println(curr+" ");
                vis[curr]=true;
                for(int i=0 ; i<graph[curr].size() ; i++){
                    // add its neighbours
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                    // q.add(grapgh[curr].get(i).dest);
                }
            }
        }

    }
    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            if (!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }
    public static void dfsUtil(ArrayList<Edge>[] grapgh , int curr , boolean[] vis){
        System.out.println(curr+" ");
        vis[curr]=true;
        for(int i=0 ; i<grapgh[curr].size() ; i++){
            Edge e =  grapgh[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(grapgh, e.dest, vis);
            }
        }
    }
    
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        // this is for undirected
        boolean[] vis = new boolean[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            if (!vis[i]) {
                if(detectCycleUtil(graph,vis,i,-1))
                    return true;
            }
        }
        return false;
    } 
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,boolean[] vis, int curr , int par){
        vis[curr]=true;
        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            // case 3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest,curr)) {
                    return true;
                }
                // case 1
            }else if(vis[e.dest] && e.dest != par )return true;
            // Case 2 -> when its parent do ntg
        }
        return false;
    }

    public static boolean detectCycleDir(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        boolean[] stk = new boolean[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            if (!vis[i] && detectCycleDirUtil(graph,vis,stk,i)) {
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycleDirUtil(
        ArrayList<Edge>[] graph , 
        boolean[] vis, 
        boolean[] stk, 
        int curr){
            vis[curr] = true;
            stk[curr] = true;
            for(int i = 0 ; i<graph[curr].size() ; i++){
                Edge e = graph[curr].get(i);
                if (stk[e.dest]) {
                    return true;
                }else if(!vis[e.dest] && detectCycleDirUtil(graph, vis, stk, e.dest)){
                    return true;
                }
            }
            stk[curr] = false;
            return false;
    } 
    
    
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraphDir(graph);
        // bfs(graph);
        // dfs(graph);
        System.out.println("Topo"); 
    }
}


// DFS And BFS for single component
// public static void dfs(ArrayList<Edge>[] grapgh , int curr , boolean[] vis){
//         System.out.println(curr+" ");
//         vis[curr]=true;
//         for(int i=0 ; i<grapgh[curr].size() ; i++){
//             Edge e =  grapgh[curr].get(i);
//             if (!vis[e.dest]) {
//                 dfs(grapgh, e.dest, vis);
//             }
//         }
//     }
// public static void bfs(ArrayList<Edge>[] grapgh){
//         System.out.println("BFS: TC : O(L)");
//         Queue<Integer> q = new LinkedList<>();
//         boolean[] vis= new boolean[7];

//         q.add(0);//Added source 
//         while (!q.isEmpty()) {
//             int curr = q.remove();
//             // print it first or visit it
//             if (!vis[curr]) {
//                 System.out.println(curr+" ");
//                 vis[curr]=true;
//                 for(int i=0 ; i<grapgh[curr].size() ; i++){
//                     // add its neighbours
//                     Edge e = grapgh[curr].get(i);
//                     q.add(e.dest);
//                     // q.add(grapgh[curr].get(i).dest);
//                 }
//             }
//         }

//     }