class Solution:
    def dfs(self, x, y, mat, vis, grid1, flag):
        vis[x][y] = 1
        if grid1[x][y] != 1:
            flag[0] = (flag[0] and False)
            
        ways = [(-1, 0), (1, 0), (0, 1), (0, -1)]
        
        for way in ways:
            xD, yD = x+way[0], y+way[1]
            if xD < 0 or xD >= len(mat) or yD < 0 or yD >= len(mat[0]):
                continue
            if vis[xD][yD] == 0 and mat[xD][yD] == 1:
                self.dfs(xD, yD, mat, vis, grid1, flag)
    
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        ans = 0
        m, n = len(grid1), len(grid1[0])
        vis = [[0]*n for _ in range(m)]
        
        for i in range(m):
            for j in range(n):
                if grid2[i][j] == 1 and vis[i][j] == 0:
                    flag = [True]
                    self.dfs(i, j, grid2, vis, grid1, flag)
                    if flag[0] == True:
                        ans += 1
        
        return ans