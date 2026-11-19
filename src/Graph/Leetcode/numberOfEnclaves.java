package Graph.Leetcode;


import java.util.ArrayDeque;
import java.util.Queue;

public class numberOfEnclaves {
        class Pair{
            int row;
            int col;
            Pair( int row, int col ){
                this.row = row;
                this.col = col;
            }
        }
        public int numEnclaves(int[][] grid) {
            int n = grid.length;
            int m =  grid[0].length;

            Queue<Pair> q = new ArrayDeque<>();
            int[][] visited = new int[n][m];

            for( int i = 0; i < n; i++ ){
                for( int j = 0; j < m; j++ ){
                    if( i == 0 || j == 0 || i == n - 1 || j == m - 1 ){
                        if( grid[i][j] == 1 ){
                            q.offer( new Pair( i, j ));
                            visited[i][j] = 1;
                        }
                    }
                }
            }

            int[] del_row = {-1,1,0,0};
            int[] del_col = {0,0,-1,1};

            while( !q.isEmpty() ){
                Pair node = q.poll();
                int row = node.row;
                int col = node.col;

                for( int i = 0; i < 4; i++ ){
                    int new_r = row + del_row[i];
                    int new_c = col + del_col[i];

                    if( new_r >= 0 && new_c >=0 && new_r < n && new_c < m && ( grid[new_r][new_c] == 1 && visited[new_r][new_c] == 0 )){
                        q.offer( new Pair(new_r,new_c));
                        visited[new_r][new_c] = 1;
                    }
                }
            }

            int count = 0;
            for( int i = 0; i < n; i++ ){
                for( int j = 0; j < m; j++ ){
                    if( grid[i][j] == 1 && visited[i][j] == 0 ){
                        count++;
                    }
                }
            }

            return count;
        }
}
