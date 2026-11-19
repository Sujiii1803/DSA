package Graph.DFS;

import java.util.List;

public class hasCycleDirected {

        public boolean isCycle(int V, List<List<Integer>> adj) {

            boolean[] visited = new boolean[V];
            boolean[] pathVisited = new boolean[V];

            for (int i = 0; i < V; i++) {

                if (!visited[i]) {

                    if (dfs(i, visited, pathVisited, adj)) {
                        return true;
                    }
                }
            }

            return false;
        }

        public boolean dfs(int node,
                           boolean[] visited,
                           boolean[] pathVisited,
                           List<List<Integer>> adj) {

            visited[node] = true;
            pathVisited[node] = true;

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {

                    if (dfs(neighbor, visited, pathVisited, adj)) {
                        return true;
                    }

                } else if (pathVisited[neighbor]) {

                    return true;
                }
            }

            pathVisited[node] = false;

            return false;
        }
}
