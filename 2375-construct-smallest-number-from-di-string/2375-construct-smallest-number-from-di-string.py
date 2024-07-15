class Solution:
    def check(self, curr, pat):
        for i in range(0, len(curr)-1):
            if pat[i] == "I" and int(curr[i]) < int(curr[i+1]):
                continue
            elif pat[i] == "D" and int(curr[i]) > int(curr[i+1]):
                continue
            else:
                return False
        return True
    
    def dfs(self, pattern, currString, used, mini):
        if len(currString) == len(pattern) + 1:
            if self.check(currString, pattern):
                if currString < mini[0]:
                    mini[0] = currString
            return
        for i in range(1, 10):
            if used[str(i)] == 0:
                used[str(i)] = 1
                self.dfs(pattern, currString+str(i), used, mini)
                if mini[0] != "999999999":
                    return
                used[str(i)] = 0
    
    def smallestNumber(self, pattern: str) -> str:
        used = {str(i): 0 for i in range(1, 10)}
        mini = ["999999999"]
        self.dfs(pattern, "", used, mini)
        return mini[0]