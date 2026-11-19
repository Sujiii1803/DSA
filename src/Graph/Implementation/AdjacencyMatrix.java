package Graph.Implementation;
import java.util.Arrays;

public class AdjacencyMatrix {
        public static void main(String[] args) {
            int n = 4;

            int[][] edges = {
                    {0, 1},
                    {0, 2},
                    {1, 3},
                    {2, 3}
            };

            // 1 based index --> we can use n + 1 as array size

            int[][] graph = new int[n][n];

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                graph[u][v] = 1;
                graph[v][u] = 1;
            }

            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(graph[i]));
            }
        }
}

