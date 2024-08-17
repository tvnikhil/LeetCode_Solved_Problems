class Solution {
    void dfs(int x, int y, int[][] heights, int[] pac, int[] atl, int[][] vis) {
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
                dfs(delX, delY, heights, pac, atl, vis);
            }
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] pac = new int[1];
                int[] atl = new int[1];
                int[][] vis = new int[m][n];
                dfs(i, j, heights, pac, atl, vis);
                if (pac[0] == 1 && atl[0] == 1) {
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                    ans.add(res);
                }
            }
        }
        return ans;
    }
}