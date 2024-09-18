class Solution:
#     def dfs(self, x, y, grid, dp):
#         if x < 0 or y < 0:
#             return float("inf")
#         if (x,y) in dp:
#             return dp[(x,y)]
        
#         top = self.dfs(x-1, y, grid, dp)
#         left = self.dfs(x, y-1, grid, dp)
#         dp[(x,y)] = min(top, left) + grid[x][y]
        
#         return dp[(x,y)]
        
    
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        
        dp = [[0 for _ in range(n)] for _ in range(m)]
        dp[0][0] = grid[0][0]
        # dp[i][j] -> the min sum required to get here 
        
        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue
                ans = float("inf")
                if i-1 >= 0:
                    ans = min(ans, dp[i-1][j])
                if j-1 >= 0:
                    ans = min(ans, dp[i][j-1])
                dp[i][j] = ans + grid[i][j]
                # print(i, j, dp[i][j])
        
        return dp[m-1][n-1]
        
#         dp = {}
#         dp[(0,0)] = grid[0][0]
        
#         return self.dfs(m-1, n-1, grid, dp)
        