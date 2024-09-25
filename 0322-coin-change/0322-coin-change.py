class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        m, n = len(coins), amount+1
        dp = [0] * n
        curr = [0] * n
        
        for i in range(n):
            dp[i] = float("inf") if i % coins[0] != 0 else i // coins[0]
        
        for i in range(1, m):
            for j in range(1, n):
                # nonpick = dp[j]
                pick = float("inf")
                if j-coins[i] >= 0:
                    pick = 1 + curr[j-coins[i]]
                curr[j] = min(pick, dp[j])
            dp = curr
        
        return dp[amount] if dp[amount] != float("inf") else -1

# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         m, n = len(coins), amount+1
#         dp = [[0 for _ in range(n)] for _ in range(m)]
        
#         for i in range(n):
#             dp[0][i] = float("inf") if i % coins[0] != 0 else i // coins[0]
        
#         for i in range(1, m):
#             for j in range(1, n):
#                 nonpick = dp[i-1][j]
#                 pick = float("inf")
#                 if j-coins[i] >= 0:
#                     pick = 1 + dp[i][j-coins[i]]
#                 dp[i][j] = min(pick, nonpick)
        
#         return dp[m-1][amount] if dp[m-1][amount] != float("inf") else -1

# class Solution:
#     def dfs(self, idx, target, coins, dp): # has min coins to form target
#         if idx == 0:
#             if target % coins[idx] == 0:
#                 return target // coins[idx]
#             return float("inf")
        
#         pick = float("inf")
#         if target-coins[idx] >= 0:
#             pick = 1 + self.dfs(idx, target-coins[idx], coins, dp)
#         nonpick = self.dfs(idx-1, target, coins, dp)
#         dp[(idx, target)] = min(pick, nonpick)
        
#         return dp[(idx, target)]
    
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         dp = {}
#         ans = self.dfs(len(coins)-1, amount, coins, dp)
#         print(dp)
#         return ans if ans != float("inf") else -1

# class Solution:
#     def coinChange(self, coins: List[int], amount: int) -> int:
#         dp = {}
#         dp[0] = 0
        
#         for i in range(1, amount+1):
#             mini = float("inf")
#             for idx in range(0, len(coins)):
#                 if i-coins[idx] >= 0:
#                     mini = min(mini, dp[i-coins[idx]])
#             dp[i] = mini+1
        
#         return dp[amount] if dp[amount] != float("inf") else -1

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
        