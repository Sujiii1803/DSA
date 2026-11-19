package Graph.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

//542
public class matrix01 {
        class Pair{
            int row;
            int col;
            Pair( int row, int col ){
                this.row = row;
                this.col = col;
            }
        }
        public int[][] updateMatrix(int[][] mat) {

            int n =  mat.length;
            int m = mat[0].length;

            int[][] dist = new int[n][m];
            Queue<Pair> q = new ArrayDeque<>();

            for( int i = 0; i < n; i++ ){
                for( int j = 0; j < m; j++ ){
                    if( mat[i][j] == 0 ){
                        dist[i][j] = 0;
                        q.offer( new Pair( i,j ));
                    }
                    else{
                        dist[i][j] = -1;
                    }
                }
            }
            int[] dr = { -1,1,0,0 };
            int[] dc = { 0,0,-1,1 };

            while( !q.isEmpty() ){
                Pair node = q.poll();

                for( int i = 0; i < 4; i++ ){
                    int new_R = dr[i] + node.row;
                    int new_C = dc[i] + node.col;

                    if( new_R >=0 && new_R < n && new_C >=0 && new_C < m && ( dist[new_R][new_C] == -1)){
                        dist[new_R][new_C] = dist[ node.row][node.col] + 1;
                        q.offer( new Pair( new_R, new_C));
                    }
                }
            }
            return dist;

        }
}
