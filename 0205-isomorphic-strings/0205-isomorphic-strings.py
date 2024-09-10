class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        hm,mapped = {},set()
        
        for i in range(len(s)):
            a, b = s[i], t[i]
            if a in hm and hm[a] != b:
                return False
            if a not in hm and b in mapped:
                return False
            hm[a] = b
            mapped.add(b)
        
        return True
        