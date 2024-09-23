class Solution:
    def dfs(self, idx, target, nums, dp):
        if target == 0:
            return True
        if idx == 0:
            return (nums[idx] == target)
        if (idx, target) in dp:
            return dp[(idx, target)]
        
        pick = self.dfs(idx-1, target-nums[idx], nums, dp)
        nonpick = self.dfs(idx-1, target, nums, dp)
        dp[(idx, target)] = pick or nonpick
        
        return dp[(idx, target)]
    
    def canPartition(self, nums: List[int]) -> bool:
        s = sum(nums)
        if s % 2 != 0:
            return False
        dp = {}
        return self.dfs(len(nums)-1, s//2, nums, dp)

# class Solution:
#     def dfs(self, idx, target, nums):
#         if target == 0:
#             return True
#         if idx == 0:
#             return (nums[idx] == target)
        
#         pick = self.dfs(idx-1, target-nums[idx], nums)
#         nonpick = self.dfs(idx-1, target, nums)
        
#         return (pick or nonpick)
    
#     def canPartition(self, nums: List[int]) -> bool:
#         s = sum(nums)
#         if s % 2 != 0:
#             return False
        
#         return self.dfs(len(nums)-1, s//2, nums)
        