package Graph.BFS;

import java.util.*;

public class bipartite {
        public boolean isBipartite(int[][] graph) {

            int n = graph.length;

            int[] color = new int[n];
            Arrays.fill(color, -1);

            Queue<Integer> q = new LinkedList<>();

            //for loop -> because used when a graph is not connected
            for (int i = 0; i < n; i++) {

                if (color[i] == -1) {

                    color[i] = 0;
                    q.add(i);

                    while (!q.isEmpty()) {

                        int node = q.poll();

                        for (int adj : graph[node]) {

                            if (color[adj] == -1) {

                                color[adj] = 1 - color[node];
                                q.add(adj);

                            } else if (color[adj] == color[node]) {

                                return false;
                            }
                        }
                    }
                }
            }

            return true;
        }
}

