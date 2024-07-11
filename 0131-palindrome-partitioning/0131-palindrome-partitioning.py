class Solution:
    def check(self, s):
        i, j = 0, len(s)-1
        while i <= j:
            if s[i] != s[j]:
                return False
            i, j = i+1, j-1
        return True
    
    def dfs(self, s, palList, ans):
        if len(s) == 0:
            ans.append(list(palList))
            return
        for length in range(1, len(s)+1):
            left = s[0:length]
            right = s[length:]
            if self.check(left):
                palList.append(str(left))
                self.dfs(right, palList, ans)
                palList.pop()
    
    def partition(self, s: str) -> List[List[str]]:
        ans = []
        palList = []
        self.dfs(s, palList, ans)
        return ans