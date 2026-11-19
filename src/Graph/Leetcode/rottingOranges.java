package Graph.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

//994
public class rottingOranges {
        class Pair{
            int row;
            int col;
            Pair( int row,int col){
                this.row = row;
                this.col = col;
            }
        }
        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            Queue<Pair> q = new ArrayDeque<>();
            int fresh = 0;

            for( int i = 0; i < n; i++ ){
                for( int j = 0; j < m; j++ ){
                    if( grid[i][j] == 1 ){
                        fresh++;
                    }
                    else if( grid[i][j] == 2 ){
                        q.offer( new Pair(i,j));
                    }
                }
            }



            int[] delrow = { -1,1,0,0 };
            int[] delcol = {0,0,-1,1};
            int mins = 0;

            while( !q.isEmpty() && fresh > 0  ){
                int size = q.size();

                for( int i = 0; i < size; i++ ){
                    Pair p = q.poll();
                    for( int d = 0; d < 4; d++ ){
                        int newRow = p.row + delrow[d];
                        int newCol = p.col + delcol[d];

                        if (newRow >= 0 && newRow < n &&
                                newCol >= 0 && newCol < m &&
                                grid[newRow][newCol] == 1) {

                            grid[newRow][newCol] = 2;

                            fresh--;

                            q.offer(new Pair(newRow, newCol));
                        }
                    }
                }
                mins++;

            }
            return fresh == 0 ? mins : -1;
        }
}
