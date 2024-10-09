class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        m, n = len(text1), len(text2)
        prev = [0 for _ in range(n+1)]
        curr = list(prev)
        
        for idx1 in range(1, m + 1):
            for idx2 in range(1, n + 1):
                if text1[idx1 - 1] == text2[idx2 - 1]:
                    curr[idx2] = 1 + prev[idx2-1]
                else:
                    curr[idx2] = max(prev[idx2], curr[idx2 - 1])
            prev = list(curr)
        
        return curr[n]
    
    def longestPalindromeSubseq(self, s: str) -> int:
        return self.longestCommonSubsequence(s, s[::-1])
    
    def minInsertions(self, s: str) -> int:
        return len(s) - self.longestPalindromeSubseq(s)
        