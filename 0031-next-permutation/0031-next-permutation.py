class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # 2,1,5,4,3,0,0
        
        if len(nums) == 1:
            return
        
        bp = len(nums)-1
        while bp >= 0:
            if nums[bp] <= nums[bp-1]:
                bp -= 1
                continue
            else:
                break
        bp -= 1
        if bp == -1:
            nums.reverse()
        else:
            justGreater = len(nums)-1
            while justGreater >= 0 and nums[justGreater] <= nums[bp]:
                justGreater -= 1
            nums[justGreater], nums[bp] = nums[bp], nums[justGreater]
            p, q = bp+1, len(nums)-1
            while p <= q:
                nums[p], nums[q] = nums[q], nums[p]
                p += 1
                q -= 1
        