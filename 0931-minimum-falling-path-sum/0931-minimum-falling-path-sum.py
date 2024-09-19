class Solution:
    def dfs(self, x, y, mat, dp):
        if y < 0 or x >= len(mat) or y >= len(mat[0]):
            return float("inf")
        if x == len(mat)-1:
            return mat[x][y]
        if (x,y) in dp:
            return dp[(x,y)]
        leftDg = self.dfs(x+1,y-1,mat,dp)
        rightDg = self.dfs(x+1,y+1,mat,dp)
        down = self.dfs(x+1,y,mat,dp)
        
        dp[(x,y)] = min(leftDg, rightDg, down) + mat[x][y]
        
        return dp[(x,y)]
    
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp = {}
        m, n = len(matrix), len(matrix[0])
        
        ans = float("inf")
        for i in range(n):
            ans = min(ans, self.dfs(0, i, matrix, dp))

        return ans
        