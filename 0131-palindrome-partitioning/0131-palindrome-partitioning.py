class Solution:
    def dfs(self, s, palList, ans):
        if len(s) == 0:
            ans.append(list(palList))
            return
        for length in range(1, len(s)+1):
            left = s[0:length]
            right = s[length:]
            if left == left[::-1]:
                palList.append(str(left))
                self.dfs(right, palList, ans)
                palList.pop()
    
    def partition(self, s: str) -> List[List[str]]:
        ans = []
        palList = []
        self.dfs(s, palList, ans)
        return ans