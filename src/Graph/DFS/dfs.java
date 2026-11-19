package Graph.DFS;
import java.util.*;

public class dfs {

        //recursive method
        public static void dfs( List<List<Integer>> graph, int node, boolean[] visited) {

            visited[node] = true;
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    dfs(graph, neighbor, visited);
                }
            }
        }

        //interative
        public static List<Integer> dfsIterative( List<List<Integer>> graph, int start) {

            boolean[] visited = new boolean[graph.size()];
            Stack<Integer> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();

            stack.push(start);

            while (!stack.isEmpty()) {
                int node = stack.pop();

                if (visited[node]) {
                    continue;
                }

                visited[node] = true;
                result.add(node);

                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int n = 6;

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            int[][] edges = {
                    {0, 1},
                    {1, 2},
                    {2, 3},
                    {1, 4},
                    {4, 5}
            };

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            boolean[] visited = new boolean[n];

            dfs(graph, 0, visited);
        }
}
