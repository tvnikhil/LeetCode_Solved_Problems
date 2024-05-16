class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numsDict = {}
        for i in range(0, len(nums)):
            if target - nums[i] in numsDict:
                return [i, numsDict[target - nums[i]]]
            else:
                numsDict[nums[i]] = i
        