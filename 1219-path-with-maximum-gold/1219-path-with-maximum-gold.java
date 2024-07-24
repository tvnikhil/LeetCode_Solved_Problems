class Solution {
    int dfs(int[][] grid, int i, int j, int gold) {
        if ((i >= grid.length || i < 0) || (j >= grid[0].length || j < 0)) return gold;
        if (grid[i][j] == 0 || grid[i][j] == -1) return gold;
        int temp = grid[i][j];
        gold += grid[i][j];
        grid[i][j] = -1;
        int choice1 = dfs(grid, i, j+1, gold);
        int choice2 = dfs(grid, i+1, j, gold);
        int choice3 = dfs(grid, i-1, j, gold);
        int choice4 = dfs(grid, i, j-1, gold);
        gold -= temp;
        grid[i][j] = temp;
        return Math.max(Math.max(choice1, choice2), Math.max(choice3, choice4));
    }
    
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxGold = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    int gold = dfs(grid, i, j, 0);
                    maxGold = Math.max(maxGold, gold);
                }
            }
        }
        return maxGold;
    }
}