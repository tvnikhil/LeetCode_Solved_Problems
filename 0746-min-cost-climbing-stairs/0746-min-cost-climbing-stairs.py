class Solution:
    # def dfs(self, idx, cost, dp):
    #     if idx < 0:
    #         return 0
    #     if idx in dp:
    #         return dp[idx]
    #     left = self.dfs(idx-1, cost, dp) + cost[idx-1]
    #     if idx-2 < 0:
    #         right = float("inf")
    #     else:
    #         right = self.dfs(idx-2, cost, dp) + cost[idx-2]
    #     dp[idx] = min(left, right)
    #     return dp[idx]
    
    def compute(self, cost):
        dp = [0 for _ in range(len(cost)+1)]
        
        for i in range(1, len(cost)+1):
            left = dp[i-1] + cost[i-1]
            right = float("inf") if i-2 < 0 else dp[i-2]+cost[i-2]
            dp[i] = min(left, right)
        
        return dp[len(cost)]
        
    
    def minCostClimbingStairs(self, cost: List[int]) -> int:
#         dp = {}
#         dp[0] = 0
#         stZ = self.dfs(len(cost), cost, dp)
        
#         dp = {}
#         dp[0] = 0
#         stO = self.dfs(len(cost)-1, cost[1:], dp)
#         return min(stZ, stO)
        
        
        stZ = self.compute(cost)
        stO = self.compute(cost[1:])
        
        return min(stZ, stO)