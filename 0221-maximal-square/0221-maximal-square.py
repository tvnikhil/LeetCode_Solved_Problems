class Solution:
    def maximalSquare(self, mat: List[List[str]]) -> int:
        m, n = len(mat), len(mat[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        ans = 0
        for i in range(n):
            dp[0][i] = int(mat[0][i])
            ans = max(ans, dp[0][i])
        for i in range(m):
            dp[i][0] = int(mat[i][0])
            ans = max(ans, dp[i][0])
        
        for i in range(1, m):
            for j in range(1, n):
                if mat[i][j] == "0":
                    dp[i][j] = 0
                    continue
                pos = [dp[i-1][j], dp[i-1][j-1], dp[i][j-1]]
                if 0 in pos:
                    dp[i][j] = 1
                else:
                    dp[i][j] = min(pos) + 1
                ans = max(ans, dp[i][j])
        
        return ans**2

            
# class Solution:
#     def dfs(self, i, j, mat, dp):
#         if i >= len(mat) or j >= len(mat[0]):
#             return 0
#         if mat[i][j] == "0":
#             return 0
#         if (i,j) in dp:
#             return dp[(i,j)]
        
#         pos1 = self.dfs(i,j+1,mat,dp)
#         pos2 = self.dfs(i+1,j,mat,dp)
#         pos3 = self.dfs(i+1,j+1,mat,dp)
        
#         if 0 in [pos1,pos2,pos3]:
#             dp[(i,j)] = 1
#             return 1
#         dp[(i,j)] = min(pos1,pos2,pos3) + 1
#         return dp[(i,j)]
        
        
    
#     def maximalSquare(self, matrix: List[List[str]]) -> int:
#         m, n = len(matrix), len(matrix[0])
#         ans = 0
#         dp = {}
        
#         for i in range(m):
#             for j in range(n):
#                 if matrix[i][j] == "1":
#                     ans = max(ans, self.dfs(i, j, matrix, dp))
        
#         return ans**2