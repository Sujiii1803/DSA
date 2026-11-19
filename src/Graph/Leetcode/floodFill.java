package Graph.Leetcode;

//733
public class floodFill {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {

            int original = image[sr][sc];
            if( original == color ){
                return image;
            }

            dfs( image, sr, sc, original, color );

            return image;
        }
        public void dfs( int[][] image, int sr, int sc, int original, int color ){

            int m = image.length;
            int n = image[0].length;

            image[sr][sc] = color;

            int[] dr = { -1,1,0,0 };
            int[] dc = { 0,0,-1,1 };

            for( int i = 0; i < 4; i++ ){
                int r = sr + dr[i];
                int c = sc + dc[i];

                if( r >=0 && r < m && c >= 0 && c < n && image[r][c] == original ){
                    dfs( image, r, c, original, color );
                }
            }
        }
}
