class Solution {
    public int minimumArea(int[][] grid) {
        int upper = 1001, lower = -1, left = 1001, right = -1;
        int n = grid.length, m = grid[0].length;
        //upper and lower
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    upper = Math.min(upper, i);
                    lower = Math.max(lower, i);
                }
            }
        }
        //left and right
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 1) {
                    left = Math.min(left, i);
                    right = Math.max(right, i);
                }
            }
        }
        return ((lower - upper + 1) * (right - left + 1));
    }
}