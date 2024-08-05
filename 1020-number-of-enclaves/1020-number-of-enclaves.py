class Solution:
    def dfs(self, x, y, grid, visited):
        if x >= len(grid) or x < 0 or y < 0 or y >= len(grid[0]):
            return
        if visited[x][y] != 0 or grid[x][y] != 1:
            return
        visited[x][y] = -1
        self.dfs(x+1, y, grid, visited)
        self.dfs(x-1, y, grid, visited)
        self.dfs(x, y-1, grid, visited)
        self.dfs(x, y+1, grid, visited)
    
    def numEnclaves(self, grid: List[List[int]]) -> int:
        visited = []
        rows, cols = len(grid), len(grid[0])
        for i in range(rows):
            temp = []
            for j in range(cols):
                temp.append(0)
            visited.append(temp)
        for i in range(0, cols):
            if grid[0][i] == 1 and visited[0][i] == 0:
                self.dfs(0, i, grid, visited)
        for i in range(0, rows):
            if grid[i][0] == 1 and visited[i][0] == 0:
                self.dfs(i, 0, grid, visited)
        for i in range(0, cols):
            if grid[rows-1][i] == 1 and visited[rows-1][i] == 0:
                self.dfs(rows-1, i, grid, visited)
        for i in range(0, rows):
            if grid[i][cols-1] == 1 and visited[i][cols-1] == 0:
                self.dfs(i, cols-1, grid, visited)
        ans = 0
        for i in range(0, rows):
            for j in range(0, cols):
                if visited[i][j] == -1:
                    continue
                if grid[i][j] == 1:
                    ans += 1
        return ans