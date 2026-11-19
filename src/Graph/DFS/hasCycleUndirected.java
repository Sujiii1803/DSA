package Graph.DFS;
import java.util.*;

import java.util.*;

class hasCycleUndirected{

    public static boolean isCycle(int V, List<List<Integer>> adj) {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(int node, int parent, boolean[] visited,  List<List<Integer>> adj) {

        visited[node] = true;

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {

                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }

            } else if (neighbor != parent) {

                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 4;

        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3}
        };

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for( int[] edge : edges ){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean ans = isCycle( n, adj);
        System.out.println(ans);
    }
}