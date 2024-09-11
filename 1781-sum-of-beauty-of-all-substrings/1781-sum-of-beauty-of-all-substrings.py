class Solution:
    def beautySum(self, s: str) -> int:
        ans = 0
        
        for st in range(len(s)):
            hm = defaultdict(int)
            for end in range(st, len(s)):
                hm[s[end]] += 1
                mf, lf = max(hm.values()), min(hm.values())
                ans += mf-lf
        
        return ans