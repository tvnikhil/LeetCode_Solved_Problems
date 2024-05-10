#[0,1,2,2,3,0,4,2]
#[0,1,-1,-1,3,0,4,-1]

#[4,5,4,4]
#[-1,5,-1,-1]

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        cnt = 0
        for i in range(len(nums)):
            if nums[i] == val:
                nums[i] = -1
                cnt += 1
        i, j = 0, len(nums) - 1
        while (1):
            while i < len(nums) and nums[i]>= 0:
                i += 1
            while j >= 0 and nums[j] == -1:
                j -= 1
            print(i, j)
            if (i > j): break
            nums[i], nums[j] = nums[j], nums[i]
        print(nums)
        return len(nums) - cnt        
                
        