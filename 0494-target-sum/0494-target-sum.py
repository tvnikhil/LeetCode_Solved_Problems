class Solution:
    def dfs(self, idx, target, nums, dp):
        if idx == 0:
            if target+nums[idx] == 0 and target-nums[idx] == 0:
                return 2
            if target+nums[idx] == 0 or target-nums[idx] == 0:
                return 1
            return 0
        if (idx, target) in dp:
            return dp[(idx, target)]
        plus = self.dfs(idx-1, target+nums[idx], nums, dp)
        minus = self.dfs(idx-1, target-nums[idx], nums, dp)
        dp[(idx, target)] = plus + minus
        
        return dp[(idx, target)]
    
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        dp = {}
        return self.dfs(len(nums)-1, target, nums, dp)
        