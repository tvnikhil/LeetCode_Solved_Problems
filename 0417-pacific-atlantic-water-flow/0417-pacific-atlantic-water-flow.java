class Solution {
    void dfs(int x, int y, int[][] heights, int[] pac, int[] atl, int[][] vis, int[][] memo) {
        if (x == 0) pac[0] = 1;
        if (x == heights.length-1) atl[0] = 1;
        if (y == 0) pac[0] = 1;
        if (y == heights[0].length-1) atl[0] = 1;
        vis[x][y] = 1;
        int[] xD = new int[]{-1,1,0,0};
        int[] yD = new int[]{0,0,1,-1};
        for (int i = 0; i < 4; i++) {
            int delX = x+xD[i], delY = y+yD[i];
            if (delX < 0 || delX >= heights.length || delY < 0 || delY >= heights[0].length)
                continue;
            if (vis[delX][delY] == 0 && heights[delX][delY] <= heights[x][y]) {
                if (memo[delX][delY] != 0) {
                    if (memo[delX][delY] == -1) pac[0] = 1;
                    else if (memo[delX][delY] == -2) atl[0] = 1;
                    else {
                        pac[0] = 1;
                        atl[0] = 1;
                    }
                }
                else dfs(delX, delY, heights, pac, atl, vis, memo);
            }
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] pac = new int[1];
                int[] atl = new int[1];
                int[][] vis = new int[m][n];
                dfs(i, j, heights, pac, atl, vis, memo);
                if (pac[0] == 1 && atl[0] == 1) {
                    memo[i][j] = -3;
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    ans.add(res);
                }
                else if (pac[0] == 1)
                    memo[i][j] = -1;
                else if (atl[0] == 1)
                    memo[i][j] = -2;
                else
                    memo[i][j] = 0;
            }
        }
        return ans;
    }
}