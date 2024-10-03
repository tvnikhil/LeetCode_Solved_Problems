class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m, n = len(text1), len(text2)
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        
        for idx1 in range(1, m + 1):
            for idx2 in range(1, n + 1):
                if text1[idx1 - 1] == text2[idx2 - 1]:
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1]
                else:
                    dp[idx1][idx2] = max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1])
        
        return dp[m][n]
        

# class Solution:
#     def longestCommonSubsequence(self, text1: str, text2: str) -> int:
#         dp = {}
        
#         def dfs(idx1, idx2):
#             if idx1 == 0 or idx2 == 0:
#                 return 0
#             if (idx1, idx2) in dp:
#                 return dp[(idx1, idx2)]
#             if text1[idx1-1] == text2[idx2-1]:
#                 return 1 + dfs(idx1-1, idx2-1)
#             dp[(idx1,idx2)] = max(dfs(idx1-1, idx2), dfs(idx1,idx2-1))
#             return dp[(idx1,idx2)]
        
#         return dfs(len(text1), len(text2))
        