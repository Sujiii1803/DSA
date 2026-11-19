package Graph.BFS;
import java.util.*;

public class hasCycleDirected {
        public boolean isCycle(int V, int[][] edges) {

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            // Build adjacency list
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {

                if (!visited[i]) {

                    if (bfs(i, graph, visited)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean bfs(int start,
                            List<List<Integer>> adj,
                            boolean[] visited) {

            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{start, -1});
            visited[start] = true;

            while (!queue.isEmpty()) {

                int[] current = queue.poll();

                int node = current[0];
                int parent = current[1];

                for (int neighbor : adj.get(node)) {

                    if (!visited[neighbor]) {

                        visited[neighbor] = true;

                        queue.add(new int[]{neighbor, node});
                    }
                    else if (neighbor != parent) {
                        return true;
                    }
                }
            }

            return false;
        }
}
