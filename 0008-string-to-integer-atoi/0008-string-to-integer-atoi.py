class Solution:
    def convert(self, s, i, ans):
        if i == len(s) or s[i].isnumeric() == False:
            return ans
        ans = ans * 10 + int(s[i])
        return self.convert(s, i + 1, ans)
    
    def skipSpaces(self, s, i):
        if i == len(s) or s[i] != " ":
            return i
        return self.skipSpaces(s, i + 1)
    
    def getSign(self, s, i):
        if i >= len(s):
            return 1, i
        if i < len(s) and s[i] not in ["-", "+"]:
            return 1, i
        if i < len(s) and s[i] in ["-", "+"]:
            if s[i] == "-": return -1, i + 1
            else: return 1, i + 1
        return self.getSign(s, i + 1)
        
    def myAtoi(self, s: str) -> int:
        if len(s) == 0:
            return 0
        idx = self.skipSpaces(s, 0)
        sign, idx = self.getSign(s, idx)
        maxi = 2**31
        ans = sign * self.convert(s, idx, 0)
        if ans >= maxi - 1: return maxi - 1
        elif ans <= -maxi: return -maxi
        return ans
        