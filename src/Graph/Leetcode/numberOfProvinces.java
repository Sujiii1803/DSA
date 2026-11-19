package Graph.Leetcode;

//547
public class numberOfProvinces {
    public static int findCircleNum(int[][] isConnected){
        int n = isConnected.length;

        int count = 0;

        boolean[] visited = new boolean[n];

        for( int i = 0; i < n; i++ ){
            if( !visited[i] ){
                count++;
                dfs( visited, isConnected, i);
            }
        }
        return count;
    }
    public static void dfs( boolean[] visited, int[][] isConnected, int i){
        visited[i] = true;
        for( int j = 0; j < isConnected.length; j++ ){
            if( !visited[j] && isConnected[i][j] == 1 ){
                dfs( visited, isConnected, j);
            }
        }
    }
}
