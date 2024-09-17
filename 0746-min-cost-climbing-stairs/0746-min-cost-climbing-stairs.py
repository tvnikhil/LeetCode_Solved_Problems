class Solution:
    def dfs(self, idx, cost, dp):
        if idx < 0:
            return 0
        if idx in dp:
            return dp[idx]
        left = self.dfs(idx-1, cost, dp) + cost[idx-1]
        if idx-2 < 0:
            right = float("inf")
        else:
            right = self.dfs(idx-2, cost, dp) + cost[idx-2]
        dp[idx] = min(left, right)
        return dp[idx]
    
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        dp = {}
        dp[0] = 0
        stZ = self.dfs(len(cost), cost, dp)
        
        dp = {}
        dp[0] = 0
        stO = self.dfs(len(cost)-1, cost[1:], dp)
        
        return min(stZ, stO)
        