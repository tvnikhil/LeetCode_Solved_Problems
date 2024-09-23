class Solution:
    def maxEnergyBoost(self, A: List[int], B: List[int]) -> int:
        m, n = len(A), 2
        dpA, dpB = A[0], B[0]
        
        for i in range(1, m):
            tempA = max(A[i]+dpA, dpB)
            tempB = max(B[i]+dpB, dpA)
            dpA, dpB = tempA, tempB
        
        return max(dpA, dpB)

# class Solution:
#     def maxEnergyBoost(self, A: List[int], B: List[int]) -> int:
#         m, n = len(A), 2
#         dp = [[0 for _ in range(n)] for _ in range(m)]
#         dp[0][0],dp[0][1] = A[0],B[0]
        
#         for i in range(1, m):
#             for j in range(n):
#                 energy = A[i] if j == 0 else B[i]
#                 dp[i][j] = max(energy+dp[i-1][j], dp[i-1][(not j)])

#         return max(dp[m-1][0], dp[m-1][1])

# class Solution:
#     def dfs(self, idx, nextDrink, A, B, dp):
#         if idx == 0:
#             if nextDrink == 0:
#                 return A[idx]
#             return B[idx]
#         if (idx, nextDrink) in dp:
#             return dp[(idx, nextDrink)]
        
#         energy = A[idx] if nextDrink == 0 else B[idx]
#         drink = energy + self.dfs(idx-1, nextDrink, A, B, dp)
#         switch = self.dfs(idx-1, (not nextDrink), A, B, dp)
#         dp[(idx, nextDrink)] = max(drink, switch)
        
#         return dp[(idx, nextDrink)]
        
    
#     def maxEnergyBoost(self, A: List[int], B: List[int]) -> int:
#         dp = {}
#         n = len(A)
#         return max(self.dfs(n-1, 0, A, B, dp), self.dfs(n-1, 1, A, B, dp))
        