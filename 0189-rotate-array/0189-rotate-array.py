class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 1,2,3,4,5,6,7
        # 7,6,5,4,3,2,1
        # 5,6,7,1,2,3,4

        k = k%len(nums)
        nums.reverse()
        nums[:k] = reversed(nums[:k])
        nums[k:] = reversed(nums[k:])
        