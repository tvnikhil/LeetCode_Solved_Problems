class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        s = sum(nums)
        if s % 2 != 0:
            return False
        
        m, n = len(nums), (s//2)+1
        dp = [[False for _ in range(n)] for _ in range(m)]
        for i in range(m):
            dp[i][0] = True
        if nums[0] <= s//2:
            dp[0][nums[0]] = True
        
        for idx in range(1, m):
            for target in range(1, (s//2)+1):
                pick = False
                if target-nums[idx]>=0:
                    pick = dp[idx-1][target-nums[idx]]
                nonpick = dp[idx-1][target]
                dp[idx][target] = (pick or nonpick)

        return dp[m-1][n-1]

# class Solution:
#     def dfs(self, idx, target, nums, dp):
#         if target == 0:
#             return True
#         if idx == 0:
#             return (nums[idx] == target)
#         if (idx, target) in dp:
#             return dp[(idx, target)]
        
#         pick = self.dfs(idx-1, target-nums[idx], nums, dp)
#         nonpick = self.dfs(idx-1, target, nums, dp)
#         dp[(idx, target)] = pick or nonpick
        
#         return dp[(idx, target)]
    
#     def canPartition(self, nums: List[int]) -> bool:
#         s = sum(nums)
#         if s % 2 != 0:
#             return False
#         dp = {}
#         return self.dfs(len(nums)-1, s//2, nums, dp)

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
        