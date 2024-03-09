class Solution {
    public int dfs(int[][] grid, int sr, int sc, int[][] dir) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        grid[sr][sc] = 0;
        for (int d = 0; d < dir.length; d++) {
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];
            if (nr < n && nc < m && nr >= 0 && nc >= 0 && grid[nr][nc] == 1) {
                count += dfs(grid, nr, nc, dir);
            }
        }
        return count + 1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        // r d l u
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, dir);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}
