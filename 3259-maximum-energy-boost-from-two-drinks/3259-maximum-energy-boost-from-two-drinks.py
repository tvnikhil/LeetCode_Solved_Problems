class Solution:
    def dfs(self, idx, nextDrink, A, B, dp):
        if idx == 0:
            if nextDrink == 0:
                return A[idx]
            return B[idx]
        if (idx, nextDrink) in dp:
            return dp[(idx, nextDrink)]
        
        energy = A[idx] if nextDrink == 0 else B[idx]
        drink = energy + self.dfs(idx-1, nextDrink, A, B, dp)
        switch = self.dfs(idx-1, (not nextDrink), A, B, dp)
        dp[(idx, nextDrink)] = max(drink, switch)
        
        return dp[(idx, nextDrink)]
        
    
    def maxEnergyBoost(self, A: List[int], B: List[int]) -> int:
        dp = {}
        n = len(A)
        return max(self.dfs(n-1, 0, A, B, dp), self.dfs(n-1, 1, A, B, dp))
        