class Solution:
#     def dfs(self, x, y, tri,dp):
#         if x < 0 or y < 0 or y > x:
#             return float("inf")
#         if (x,y) in dp:
#             return dp[(x,y)]
        
#         dp[(x,y)] = min(self.dfs(x-1,y,tri,dp), self.dfs(x-1,y-1,tri,dp)) + tri[x][y]
        
#         return dp[(x,y)]
    
#     def dfs(self, x, y, tri, dp):
#         # f(x,y) -> has the min time to go from that position to the last row
#         if x == len(tri)-1:
#             return tri[x][y]
#         if (x,y) in dp:
#             return dp[(x,y)]
#         left = self.dfs(x+1,y,tri,dp)
#         right = self.dfs(x+1,y+1,tri,dp)
        
#         dp[(x,y)] = min(left, right) + tri[x][y]
#         return dp[(x,y)]
    
    def minimumTotal(self, tri: List[List[int]]) -> int:
        m = len(tri)
        dp = [[0 for j in range(i+1)] for i in range(len(tri))]
        
        for i in range(m-1,-1,-1):
            for j in range(0,i+1):
                if i == m-1:
                    dp[i][j] = tri[i][j]
                else:
                    dp[i][j] = tri[i][j] + min(dp[i+1][j], dp[i+1][j+1])
        # print(dp)
        return dp[0][0]
        
        # dp = {}
        # return self.dfs(0,0,tri,dp)
        
#         dp = [[0 for j in range(i+1)] for i in range(len(tri))]
#         dp[0][0] = tri[0][0]
        
#         for i in range(1,len(dp)):
#             for j in range(i+1):
#                 pos1, pos2 = float("inf"), float("inf")
#                 if j <= i-1:
#                     pos1 = min(pos1, dp[i-1][j])
#                 if j-1 >= 0:
#                     pos2 = min(pos2, dp[i-1][j-1])
#                 dp[i][j] = min(pos1, pos2) + tri[i][j]
        
#         return min(dp[len(dp)-1])
                
        
#         ans = float("inf")
#         dp = {}
#         dp[(0,0)] = tri[0][0]
        
#         for i in range(m):
#             ans = min(ans, self.dfs(m-1, i, tri, dp))
        
#         return ans
        