class Solution:
    def generateStrings(self, currLen, n, currString, ans):
        if currLen == n:
            ans.append(str(currString))
            return
        if currLen > 0:
            if currString[-1] == "1":
                self.generateStrings(currLen+1, n, currString+"0", ans)
                self.generateStrings(currLen+1, n, currString+"1", ans)
            else:
                self.generateStrings(currLen+1, n, currString+"1", ans)
        else:
            self.generateStrings(currLen+1, n, currString+"0", ans)
            self.generateStrings(currLen+1, n, currString+"1", ans)

    def validStrings(self, n: int) -> List[str]:
        ans = []
        self.generateStrings(0, n, "", ans)
        return ans
        