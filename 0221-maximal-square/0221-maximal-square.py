class Solution:
    def dfs(self, i, j, mat, dp):
        if i >= len(mat) or j >= len(mat[0]):
            return 0
        if mat[i][j] == "0":
            return 0
        if (i,j) in dp:
            return dp[(i,j)]
        
        pos1 = self.dfs(i,j+1,mat,dp)
        pos2 = self.dfs(i+1,j,mat,dp)
        pos3 = self.dfs(i+1,j+1,mat,dp)
        
        if 0 in [pos1,pos2,pos3]:
            dp[(i,j)] = 1
            return 1
        dp[(i,j)] = min(pos1,pos2,pos3) + 1
        return dp[(i,j)]
        
        
    
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        m, n = len(matrix), len(matrix[0])
        ans = 0
        dp = {}
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == "1":
                    ans = max(ans, self.dfs(i, j, matrix, dp))
        
        return ans**2
        