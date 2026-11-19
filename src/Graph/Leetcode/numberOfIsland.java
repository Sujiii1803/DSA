package Graph.Leetcode;

//200
public class numberOfIsland {
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (grid[i][j] == '1') {
                        count++;

                        dfs(grid, i, j);
                    }
                }
            }

            return count;
        }
        public void dfs(char[][] grid, int r, int c) {
            if (r < 0 || c < 0 ||
                    r >= grid.length || c >= grid[0].length) {
                return;
            }

            if (grid[r][c] == '0') {
                return;
            }

            grid[r][c] = '0';

            dfs(grid, r - 1, c); // Up
            dfs(grid, r + 1, c); // Down
            dfs(grid, r, c - 1); // Left
            dfs(grid, r, c + 1); // Right
        }
}
