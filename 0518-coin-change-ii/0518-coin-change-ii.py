class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m, n = len(coins), amount+1
        dp = [0] * n
        for i in range(n):
            dp[i] = 1 if i % coins[0] == 0 else 0
        dp[0] = 1
        curr = list(dp)
        
        for idx in range(1, m):
            for amt in range(1, n):
                pick = 0
                if amt-coins[idx] >= 0:
                    pick = curr[amt-coins[idx]]
                nonpick = dp[amt]
                curr[amt] = pick+nonpick
            dp = curr
        
        return dp[amount]

# class Solution:
#     def change(self, amount: int, coins: List[int]) -> int:
#         m, n = len(coins), amount+1
#         dp = [[0 for _ in range(n)] for _ in range(m)]
        
#         for i in range(n):
#             if i % coins[0] == 0:
#                 dp[0][i] = 1
#         for i in range(m):
#             dp[i][0] = 1
        
#         for idx in range(1, m):
#             for amt in range(0, n):
#                 pick = 0
#                 if amt-coins[idx] >= 0:
#                     pick = dp[idx][amt-coins[idx]]
#                 nonpick = dp[idx-1][amt]
#                 dp[idx][amt] = pick+nonpick
        
#         return dp[m-1][amount]

# class Solution:
#     def dfs(self, idx, amount, coins, dp):
#         if amount == 0:
#             return 1
#         if idx == 0:
#             return 1 if amount % coins[idx] == 0 else 0
#         if (idx, amount) in dp:
#             return dp[(idx, amount)]
        
#         nonpick = self.dfs(idx-1, amount, coins, dp)
#         pick = 0
#         if amount - coins[idx] >= 0:
#             pick = self.dfs(idx, amount-coins[idx], coins, dp)
        
#         dp[(idx, amount)] = pick+nonpick
#         return dp[(idx, amount)]
    
#     def change(self, amount: int, coins: List[int]) -> int:
#         dp = {}
#         m, n = len(coins), amount+1
        
#         return self.dfs(m-1, amount, coins, dp)
        