class Solution:
#     def dfs(self, x, y, m, n):
#         if x == m-1 and y == n-1:
#             return 1
#         if x >= m or y >= n:
#             return 0
        
#         down = self.dfs(x+1,y,m,n)
#         right = self.dfs(x,y+1,m,n)
        
#         return right+down
    
    # def dfs(self, x, y, dp):
    #     if x < 0 or y < 0:
    #         return 0
    #     if (x,y) in dp:
    #         return dp[(x,y)]
    #     dp[(x,y)] = self.dfs(x-1,y,dp) + self.dfs(x, y-1,dp)
    #     return dp[(x,y)]
    
    def uniquePaths(self, m: int, n: int) -> int:
        # return self.dfs(0, 0, m, n)
        # dp = {}
        # dp[(0,0)] = 1
        # return self.dfs(m-1,n-1,dp)
        
        dp = [[0 for _ in range(n)] for _ in range(m)]
        dp[0][0] = 1
        
        for i in range(0, m):
            for j in range(0, n):
                top,left = i-1,j-1
                if top >= 0:
                    dp[i][j] += dp[top][j]
                if left >= 0:
                    dp[i][j] += dp[i][left]
        
        return dp[m-1][n-1]
        