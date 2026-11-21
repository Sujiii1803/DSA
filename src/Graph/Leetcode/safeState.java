package Graph.Leetcode;

import java.util.*;

//802
public class safeState {
        //returns true if it is unsafe
        public boolean dfs( int node, int[] visited, int[] pathVisited, int[] isSafe,int[][] graph){
            visited[node]  = 1;
            pathVisited[node] = 1;
            isSafe[node] = 0;
            for( int neigh : graph[node] ){
                if( visited[neigh] == 0 ){
                    //if neighbours are unsafe then node is also unsafe
                    if( dfs( neigh, visited, pathVisited, isSafe, graph ) ){
                        return true;
                    }
                }
                else if( pathVisited[neigh] == 1 ){
                    return true;
                }
            }
            isSafe[node] = 1;
            pathVisited[node] = 0;
            return false;
        }
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            int[] visited = new int[n];
            int[] pathVisited  = new int[n];
            int[] isSafe = new int[n];

            for( int i = 0; i < n; i++ ){
                if( visited[i] == 0 ){
                    dfs( i, visited, pathVisited, isSafe, graph );
                }
            }

            List<Integer> result = new ArrayList<>();
            for( int i = 0; i < n; i++ ){
                if( isSafe[i] == 1 ){
                    result.add( i );
                }
            }
            return result;
        }
}
