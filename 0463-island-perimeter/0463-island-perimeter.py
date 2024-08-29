class Solution:
    def dfs(self, x, y, grid, vis):
        if x >= len(grid) or y >= len(grid[0]) or x < 0 or y < 0:
            return 1
        if grid[x][y] == 0:
            return 1
        if vis[x][y] == 1:
            return 0
        
        cnt = 0
        vis[x][y] = 1
        cnt += self.dfs(x+1,y,grid,vis)
        cnt += self.dfs(x-1,y,grid,vis)
        cnt += self.dfs(x,y+1,grid,vis)
        cnt += self.dfs(x,y-1,grid,vis)
        return cnt
    
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        vis = [[0] * n for _ in range(m)]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    return self.dfs(i, j, grid, vis)

        return 0