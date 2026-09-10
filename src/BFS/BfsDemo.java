package BFS;

import java.util.*;

class BFS{

    public void bfs( List<List<Integer>> graph, int start ){

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.size()];
        queue.add(start);
        visited[start] = true;

        while( !queue.isEmpty()){
            int node = queue.poll();

            System.out.print(node + " ");

            for( int neighbor : graph.get(node)){
                if( !visited[neighbor] ){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
public class BfsDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // Number of vertices
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        // Number of edges
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        //take edges
        System.out.print("Enter edges (u,v): ");
        for( int i = 0; i < e; i++ ){
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);

        }

        //starting vertex
        System.out.print("Enter start vertex: ");
        int start = sc.nextInt();

        //BFS
        BFS obj = new BFS();
        obj.bfs( graph,start );

        sc.close();
    }
}
