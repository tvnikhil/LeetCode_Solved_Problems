class Solution:
    def countVowelStrings(self, n: int) -> int:
        #a=1,e=2,i=3,o=4,u=5
        r, c = n+1, 6
        dp = [[0 for _ in range(c)] for _ in range(r)]
        
        for i in range(1, c):
            dp[n][i] = 1
        
        for i in range(n-1, 0, -1):
            for j in range(1,c):
                for k in range(j, 6):
                    dp[i][j] += dp[i+1][k]
        for i in range(1,c):
            dp[0][0] += dp[1][i]
        
        return dp[0][0]

# class Solution:
#     def countVowelStrings(self, n: int) -> int:
#         #a=1,e=2,i=3,o=4,u=5
#         dp = {}
        
#         def dfs(size, curr):
#             if size == n:
#                 return 1
#             if size == 0:
#                 ans = 0
#                 for i in range(1,6):
#                     ans += dfs(size+1, i)
#                 return ans
#             if (size, curr) in dp:
#                 return dp[(size, curr)]

#             ans = 0
#             for i in range(curr, 6):
#                 ans += dfs(size+1, i)
#             dp[(size, curr)] = ans
#             return ans
        
#         return dfs(0, 0)
        