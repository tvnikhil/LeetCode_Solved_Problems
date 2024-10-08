class Solution:
#     def dfs(self, x, y, mat, dp):
#         if y < 0 or x >= len(mat) or y >= len(mat[0]):
#             return float("inf")
#         if x == len(mat)-1:
#             return mat[x][y]
#         if (x,y) in dp:
#             return dp[(x,y)]
#         leftDg = self.dfs(x+1,y-1,mat,dp)
#         rightDg = self.dfs(x+1,y+1,mat,dp)
#         down = self.dfs(x+1,y,mat,dp)
        
#         dp[(x,y)] = min(leftDg, rightDg, down) + mat[x][y]
        
#         return dp[(x,y)]
    
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # dp = {}
        n = len(matrix)
        
        # ans = float("inf")
        # for i in range(n):
        #     ans = min(ans, self.dfs(0, i, matrix, dp))
        
        dp = [[0 for _ in range(n)] for _ in range(n)]
        
        for i in range(n-1, -1, -1):
            for j in range(n):
                if i == n-1:
                    dp[i][j] = matrix[i][j]
                    continue
                ans = float("inf")
                if j-1 >= 0:
                    ans = min(ans, dp[i+1][j-1])
                if j+1 <= n-1:
                    ans = min(ans, dp[i+1][j+1])
                ans = min(ans, dp[i+1][j])
                dp[i][j] = ans + matrix[i][j]
        
        return min(dp[0])
        