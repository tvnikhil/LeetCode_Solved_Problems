class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = {}
        
        def dfs(idx1, idx2):
            if idx1 < 0 or idx2 < 0:
                return 0
            if (idx1, idx2) in dp:
                return dp[(idx1, idx2)]
            if text1[idx1] == text2[idx2]:
                return 1 + dfs(idx1-1, idx2-1)
            dp[(idx1,idx2)] = max(dfs(idx1-1, idx2), dfs(idx1,idx2-1))
            return dp[(idx1,idx2)]
        
        return dfs(len(text1)-1, len(text2)-1)
        