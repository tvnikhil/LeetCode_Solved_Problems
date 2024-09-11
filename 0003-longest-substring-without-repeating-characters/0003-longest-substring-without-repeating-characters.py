class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        ans = 1
        
        for st in range(len(s)):
            hs = set()
            for end in range(st, len(s)):
                if s[end] in hs:
                    break
                hs.add(s[end])
                # print(s[st:end+1], end-st+1)
                ans = max(ans, end-st+1)
        
        return ans