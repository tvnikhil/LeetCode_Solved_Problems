class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
#         ans = 1
        
#         for st in range(len(s)):
#             hs = set()
#             for end in range(st, len(s)):
#                 if s[end] in hs:
#                     break
#                 hs.add(s[end])
#                 # print(s[st:end+1], end-st+1)
#                 ans = max(ans, end-st+1)
        
#         return ans
        
        left, right = 0, 0
        hm = {}
        ans = 1
        
        while right < len(s):
            if s[right] in hm:
                if hm[s[right]] >= left:
                    left = hm[s[right]] + 1
                hm[s[right]] = right
            else:
                hm[s[right]] = right
            ans = max(ans, right-left+1)
            right += 1
        
        return ans
            