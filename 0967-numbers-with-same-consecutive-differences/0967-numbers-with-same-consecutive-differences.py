class Solution:
    def dfs(self, n, k, curr, ans):
        if len(curr) >= n:
            ans.append(int(curr))
            return
        for i in range(0, 10):
            if len(curr) == 0 and i != 0:
                self.dfs(n, k, curr+str(i), ans)
            elif len(curr) > 0 and abs(int(curr[-1]) - i) == k:
                self.dfs(n, k, curr+str(i), ans)
    
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        curr = ""
        ans = []
        self.dfs(n, k, curr, ans)
        return ans
        