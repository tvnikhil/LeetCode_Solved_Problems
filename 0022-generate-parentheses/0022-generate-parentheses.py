class Solution:
    def generateBrackets(self, n, n1, n2, curr, ans):
        if (n1 > n or n2 > n):
            return
        if (n1 == n and n2 == n):
            ans.append(str(curr))
            return
        if (n1 == n2):
            self.generateBrackets(n, n1+1, n2, curr+"(", ans)
        else:
            self.generateBrackets(n, n1+1, n2, curr+"(", ans)
            self.generateBrackets(n, n1, n2+1, curr+")", ans)
    
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        self.generateBrackets(n, 0, 0, "", ans)
        return ans