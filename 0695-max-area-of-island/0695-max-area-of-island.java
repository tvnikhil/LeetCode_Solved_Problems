class Solution {
    void dfs(int x, int y, int[][] grid, int[][] vis, int[] area) {
        vis[x][y] = 1;
        area[0]++;
        // (0,0) T -1,0 B 1,0 R 0,1 L 0,-1
        int[] xD = new int[]{-1,1,0,0};
        int[] yD = new int[]{0,0,1,-1};
        for (int i = 0; i < 4; i++) {
            int delX = x+xD[i], delY = y+yD[i];
            if (delX < 0 || delX >= grid.length || delY < 0 || delY >= grid[0].length)
                continue;
            if (vis[delX][delY] == 0 && grid[delX][delY] == 1)
                dfs(delX, delY, grid, vis, area);
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    int[] area = new int[1];
                    dfs(i, j, grid, vis, area);
                    maxArea = Math.max(maxArea, area[0]);
                }
            }
        }
        return maxArea;
    }
}