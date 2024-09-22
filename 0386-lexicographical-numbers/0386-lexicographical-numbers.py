class Solution:
    def dfs(self, curr, n, ans):
        if curr != 0:
            ans.append(curr)
        st = 0
        if curr == 0: st = 1
        for i in range(st, 10):
            if curr*10+i <= n:
                self.dfs(curr*10+i, n, ans)
            else:
                break
    
    def lexicalOrder(self, n: int) -> List[int]:
        ans = []
        
        self.dfs(0, n, ans)
        
        return ans
        