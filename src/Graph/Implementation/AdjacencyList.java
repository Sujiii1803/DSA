package Graph.Implementation;
import java.util.*;

public class AdjacencyList {
        public static void main(String[] args) {
            int n = 4;

            int[][] edges = {
                    {0, 1},
                    {0, 2},
                    {1, 3},
                    {2, 3}
            };

            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            for (int i = 0; i < n; i++) {
                System.out.println(i + " -> " + graph.get(i));
            }
        }
}
