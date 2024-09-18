class Solution:
    def dfs(self, x, y, grid,dp):
        if x < 0 or y < 0:
            return 0
        if grid[x][y] == 1:
            return 0
        if (x,y) in dp:
            return dp[(x,y)]
        
        top = self.dfs(x-1,y,grid,dp)
        left = self.dfs(x,y-1,grid,dp)
        dp[(x,y)] = top+left
        
        return dp[(x,y)]
    
    def uniquePathsWithObstacles(self, grid: List[List[int]]) -> int:
        m,n = len(grid),len(grid[0])
        if grid[0][0] == 1 or grid[m-1][n-1] == 1:
            return 0
        dp = {}
        dp[(0,0)] = 1
        
        return self.dfs(m-1,n-1,grid,dp)
        