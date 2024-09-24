class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        ans = float("inf")
        st, end = 0, 0
        total = 0
        while end < len(nums):
            while end < len(nums) and total < target:
                total += nums[end]
                end += 1
            while st < len(nums) and total >= target:
                ans = min(ans, end-st)
                total -= nums[st]
                st += 1
        
        return ans if ans != float("inf") else 0
                
        