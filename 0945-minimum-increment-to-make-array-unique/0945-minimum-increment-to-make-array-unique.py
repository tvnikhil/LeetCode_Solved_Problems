class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:
        ans = 0
        nums = sorted(nums)
        num = nums[0]
        for i in range(0, len(nums)):
            if nums[i] == num:
                num += 1
                continue
            elif nums[i] > num:
                num = nums[i] + 1
                continue
            else:
                ans += num - nums[i]
                num += 1
        return ans