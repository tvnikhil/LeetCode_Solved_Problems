class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        dp = [0 for _ in range(len(nums))]
        dp[0] = nums[0]
        
        for i in range(1, len(nums)-1):
            pickIdx, nonPickIdx = i-2, i-1
            pick = nums[i] + (0 if pickIdx < 0 else dp[pickIdx])
            nonPick = dp[nonPickIdx]
            dp[i] = max(pick, nonPick)
        
        ans1 = dp[len(nums)-2]
        
        dp = [0 for _ in range(len(nums))]
        dp[1] = nums[1]
        
        for i in range(2, len(nums)):
            pickIdx, nonPickIdx = i-2, i-1
            pick = nums[i] + (0 if pickIdx < 0 else dp[pickIdx])
            nonPick = dp[nonPickIdx]
            dp[i] = max(pick, nonPick)
        
        ans2 = dp[len(nums)-1]
        
        return max(ans1, ans2)
        