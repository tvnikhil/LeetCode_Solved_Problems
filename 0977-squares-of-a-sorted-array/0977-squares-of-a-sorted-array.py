class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        r, i = [], 0
        for i in range(len(nums)):
            if nums[i] >=0: break
        if len(nums) - 1 == i and nums[i] < 0:
            while i >= 0:
                r.append(nums[i] * nums[i])
                i -= 1
            return r
        elif i == 0:
            for k in nums: r.append(k*k)
            return r
        else:
            j = i - 1
            while i < len(nums) and j >= 0:
                if (abs(nums[j]) < nums[i]):
                    r.append(nums[j] * nums[j])
                    j -= 1
                elif (abs(nums[j]) == nums[i]):
                    r.append(nums[i] * nums[i])
                    r.append(nums[i] * nums[i])
                    i += 1
                    j -= 1
                else:
                    r.append(nums[i] * nums[i])
                    i += 1
            if j >= 0:
                while j >= 0:
                    r.append(nums[j] * nums[j])
                    j -= 1
            if i < len(nums):
                while i < len(nums):
                    r.append(nums[i] * nums[i])
                    i += 1
        return r