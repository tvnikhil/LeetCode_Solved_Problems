class Solution:
    def expand(self, s, l, r):
        while l >= 0 and r <= len(s)-1 and s[l] == s[r]:
            l,r = l-1,r+1
        return s[l+1:r]
    
    def longestPalindrome(self, s: str) -> str:
#         ansLen, ans = 0, ""
        
#         for st in range(len(s)):
#             for end in range(st, len(s)):
#                 if s[st:end+1] == s[st:end+1][::-1]:
#                     if end-st > ansLen:
#                         ansLen = end-st
#                         ans = s[st:end+1]

#         return ans
        ans = s[0]
    
        for i in range(len(s)):
            oddLen, evenLen = self.expand(s, i, i), self.expand(s, i, i+1)
            if len(oddLen) > len(ans):
                ans = oddLen
            if len(evenLen) > len(ans):
                ans = evenLen

        return ans
        