class Solution {
    void dfs(int x, int y, int[][] heights, int[][] vis) {
        vis[x][y] = 1;
        int[] xD = new int[]{-1,1,0,0};
        int[] yD = new int[]{0,0,1,-1};
        for (int i = 0; i < 4; i++) {
            int delX = x+xD[i], delY = y+yD[i];
            if (delX < 0 || delX >= heights.length || delY < 0 || delY >= heights[0].length)
                continue;
            if (vis[delX][delY] == 0 && heights[delX][delY] >= heights[x][y]) {
                dfs(delX, delY, heights, vis);
            }
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        int[][] pac = new int[m][n];
        int[][] atl = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (pac[0][i] == 0)
                dfs(0, i, heights, pac);
        }
        for (int i = 0; i < m; i++) {
            if (pac[i][0] == 0)
                dfs(i, 0, heights, pac);
        }
        for (int i = 0; i < n; i++) {
            if (atl[m-1][i] == 0)
                dfs(m-1, i, heights, atl);
        }
        for (int i = 0; i < m; i++) {
            if (atl[i][n-1] == 0)
                dfs(i, n-1, heights, atl);
        }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(pac[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // System.out.println();
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(atl[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] == 1 && atl[i][j] == 1) {
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