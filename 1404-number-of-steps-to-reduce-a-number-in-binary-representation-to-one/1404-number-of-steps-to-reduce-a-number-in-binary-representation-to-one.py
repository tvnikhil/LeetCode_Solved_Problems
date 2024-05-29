class Solution:
    def addOne(self, s):
        ans = ""
        i = len(s) - 1
        while (i >= 0 and s[i] == "1"):
            ans = "0" + ans
            i -= 1
        if i >= 0:
            ans = "1" + ans
            ans = s[:i] + ans
            return ans
        ans = "1" + ans
        return ans
    
    def numSteps(self, s: str) -> int:
        count = 0
        while (s != "1"):
            if s[len(s) - 1] == "1":
                s = self.addOne(s)
            else:
                s = s[:len(s) - 1]
            count += 1
        return count
                
        