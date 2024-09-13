class Solution:
    def compute(self, curr, n, memo):
        if curr > n:
            return 0
        if curr in memo:
            return memo[curr]
        memo[curr] = self.compute(curr+1, n, memo)+self.compute(curr+2, n, memo)
        return memo[curr]
    
    def climbStairs(self, n: int) -> int:
        memo = {}
        memo[n] = 1
        
        return self.compute(0, n, memo)
        