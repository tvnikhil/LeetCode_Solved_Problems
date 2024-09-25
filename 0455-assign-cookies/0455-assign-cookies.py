class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        p, q = 0, 0
        g = sorted(g)
        s = sorted(s)
        ans = 0
        
        while p < len(s) and q < len(g):
            if s[p] >= g[q]:
                ans += 1
                p += 1
                q += 1
            else:
                p += 1
        
        return ans
        