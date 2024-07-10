class Solution {
    boolean check(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    
    int traverse (int[][] grid, int sx, int sy, int ex, int ey, int cnt) {
        if (sx == ex && sy == ey) {
            if (check(grid)) cnt++;
            return cnt;
        }
        if (sx < 0 || sx >= grid.length || sy < 0 || sy >= grid[0].length)
            return cnt;
        if (grid[sx][sy] != 1 && grid[sx][sy] != 0)
            return cnt;
        grid[sx][sy] = 3;
        int c1 = traverse(grid, sx+1, sy, ex, ey, cnt);
        int c2 = traverse(grid, sx, sy-1, ex, ey, cnt);
        int c3 = traverse(grid, sx, sy+1, ex, ey, cnt);
        int c4 = traverse(grid, sx-1, sy, ex, ey, cnt);
        grid[sx][sy] = 0;
        return (c1+c2+c3+c4);
    }
    
    public int uniquePathsIII(int[][] grid) {
        int cnt = 0, n = grid.length, m = grid[0].length;
        int sx = 0, sy = 0, ex = 0, ey = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
                if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        cnt = traverse(grid, sx, sy, ex, ey, cnt);
        return cnt;
    }
}