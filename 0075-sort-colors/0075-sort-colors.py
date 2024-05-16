class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        z, o, t = 0, 0, 0
        for i in nums:
            if i == 0: z += 1
            elif i == 1: o += 1
            else: t += 1
        i = 0
        while z > 0:
            nums[i] = 0
            z -= 1
            i += 1
        while o > 0:
            nums[i] = 1
            o -= 1
            i += 1
        while t > 0:
            nums[i] = 2
            t -= 1
            i += 1
        