package Graph.Leetcode;
import java.util.*;

//1971
public class validPath {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            List<List<Integer>> graph = new ArrayList<>();

            for( int i = 0 ; i < n; i++ ){
                graph.add( new ArrayList<>() );
            }

            for( int[] edge : edges ){
                int u = edge[0];
                int v = edge[1];

                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            boolean[] visited = new boolean[n];
            Queue<Integer> q = new ArrayDeque<>();

            q.offer( source );
            visited[source] = true;

            while( !q.isEmpty() ){
                int node = q.poll();

                if( node == destination ){
                    return true;
                }

                for( int neighbor : graph.get(node) ){
                    if( !visited[neighbor] ){
                        visited[neighbor] = true;
                        q.offer( neighbor );
                    }
                }
            }
            return false;
        }
}
