class Solution:
    def dfs(self, grid, x, y, visited):
        if (x >= len(grid) or x < 0) or (y >= len(grid[0]) or y < 0):
            return
        if grid[x][y] == "0" or visited[x][y] == 1: return
        visited[x][y] = 1
        self.dfs(grid, x+1, y, visited)
        self.dfs(grid, x, y+1, visited)
        self.dfs(grid, x-1, y, visited)
        self.dfs(grid, x, y-1, visited)
    
    def numIslands(self, grid: List[List[str]]) -> int:
        m,n = len(grid),len(grid[0])
        visited = []
        for i in range(m):
            l = []
            for j in range(n):
                l.append(0)
            visited.append(l)
        ans = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1" and visited[i][j] == 0:
                    ans += 1
                    self.dfs(grid, i, j, visited)
        return ans
                    
        