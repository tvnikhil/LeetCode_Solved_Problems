class Solution:
    def dfs(self, s, idx, currString, ans):
        if idx >= len(s):
            ans.append(str(currString))
            return
        self.dfs(s, idx+1, currString+s[idx], ans)
        if s[idx] >= "A" and s[idx] <= "Z":
            char = chr(ord(s[idx]) + 32)
            self.dfs(s, idx+1, currString+char, ans)
        elif s[idx] >= "a" and s[idx] <= "z":
            char = chr(ord(s[idx]) - 32)
            self.dfs(s, idx+1, currString+char, ans)
    
    def letterCasePermutation(self, s: str) -> List[str]:
        ans = []
        self.dfs(s, 0, "", ans)
        return ans
        