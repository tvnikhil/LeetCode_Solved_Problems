class Solution:
    def checkValid(self, ip):
        l = ip.split(".")
        for numStr in l:
            if numStr == "" or numStr == " ":
                return False
            num = int(numStr)
            if len(numStr) > 1 and numStr[0] == "0" and num >= 0:
                return False
            if num > 255:
                return False
        return True
    
    def placeDot(self, currIp):
        if currIp[-1] == "0" and currIp[len(currIp) - 1] == ".":
            return True
        l = currIp.split(".")
        if len(l[-1]) > 3:
            return True
    
    def generate(self, s, idx, currIp, dotCnt, ans):
        if dotCnt == 3 and self.checkValid(currIp + s[idx:]):
            ans.append(str(currIp + s[idx:]))
            return
        if dotCnt > 3 or idx >= len(s):
            return
        currIp += s[idx]
        if self.placeDot(currIp):
            self.generate(s, idx+1, currIp+".", dotCnt+1, ans)
        else:
            self.generate(s, idx+1, currIp+".", dotCnt+1, ans)
            self.generate(s, idx+1, currIp, dotCnt, ans)
    
    def restoreIpAddresses(self, s: str) -> List[str]:
        ans = []
        idx = 0
        currIp = ""
        dotCnt = 0
        self.generate(s, idx, currIp, dotCnt, ans)
        return ans