class Solution:
#     def dfs(self, idx, nums, dp):
#         if idx < 0:
#             return 0
#         if idx in dp:
#             return dp[idx]
        
#         pick = nums[idx] + self.dfs(idx-2, nums, dp)
#         nonPick = self.dfs(idx-1, nums, dp)
        
#         dp[idx] = max(pick, nonPick)
#         return dp[idx]
    
    def rob(self, nums: List[int]) -> int:
        # dp = {}
        # dp[0] = nums[0]
        # return self.dfs(len(nums)-1, nums, dp)
        
        dp = [0 for _ in range(len(nums))]
        dp[0] = nums[0]
        
        for i in range(1, len(nums)):
            pickIdx, nonPickIdx = i-2, i-1
            pick = nums[i] + (0 if pickIdx < 0 else dp[pickIdx])
            nonPick = dp[nonPickIdx]
            dp[i] = max(pick, nonPick)
        
        return dp[len(nums)-1]
            
        