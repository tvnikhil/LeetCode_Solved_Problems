class Solution:
    def dfs(self, matchsticks, sides, idx, sideLength):
        if idx == len(matchsticks):
            return sides[0] == sides[1] == sides[2] == sides[3]
        for i in range(4):
            if sides[i] + matchsticks[idx] <= sideLength:
                sides[i] += matchsticks[idx]
                if self.dfs(matchsticks, sides, idx + 1, sideLength):
                    return True
                sides[i] -= matchsticks[idx]
            if sides[i] == 0:
                break
        return False
    
    def makesquare(self, matchsticks: List[int]) -> bool:
        if len(matchsticks) < 4: return False
        matchsticks = sorted(matchsticks, reverse=True)
        total = 0
        for i in range(0, len(matchsticks)):
            total += matchsticks[i]
        if total % 2 != 0: return False
        sideMax = total//4
        sides = [0] * 4
        ans = self.dfs(matchsticks, sides, 0, sideMax)
        return ans