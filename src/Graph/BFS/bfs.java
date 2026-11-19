package Graph.BFS;
import java.util.*;

public class bfs {

        public static List<Integer> bfs( List<List<Integer>> graph, int start) {

            int n = graph.size();

            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            List<Integer> result = new ArrayList<>();

            visited[start] = true;
            queue.offer(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                result.add(node);

                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }

            return result;
        }

        public static void main(String[] args) {
            int n = 7;

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            graph.get(0).add(1);
            graph.get(0).add(2);

            graph.get(1).add(0);
            graph.get(1).add(3);
            graph.get(1).add(4);

            graph.get(2).add(0);
            graph.get(2).add(5);
            graph.get(2).add(6);

            graph.get(3).add(1);
            graph.get(4).add(1);
            graph.get(5).add(2);
            graph.get(6).add(2);

            System.out.println(bfs(graph, 0));
        }
}
