class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = {}
        dp[0] = 0
        
        for i in range(1, amount+1):
            mini = float("inf")
            for idx in range(0, len(coins)):
                if i-coins[idx] >= 0:
                    mini = min(mini, dp[i-coins[idx]])
            dp[i] = mini+1
        
        return dp[amount] if dp[amount] != float("inf") else -1

# class Solution:
#     def dfs(self, target, coins, dp):
#         if target == 0:
#             return 0
#         if target in dp:
#             return dp[target]
        
#         mini = float("inf")
#         for i in range(len(coins)):
#             if target-coins[i] >= 0:
#                 mini = min(mini, self.dfs(target-coins[i], coins, dp))
        
#         dp[target] = mini+1
#         return dp[target]
            
    
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         dp = {}
#         ans = self.dfs(amount, coins, dp)
#         print(dp)
#         return ans if ans != float("inf") else -1
        