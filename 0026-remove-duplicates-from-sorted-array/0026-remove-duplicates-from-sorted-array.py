#[0,0,0,0,1,1,1,2,2,2,2,3,3,3,3,3,4,4,4,4,4]
#[1,2]

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        print(len(nums))
        i, j, cnt = 0, 0, 0
        while 1:
            while (i < len(nums) and j < len(nums)) and (nums[j] == nums[i]):
                j += 1
            # print("yes", i, j)
            if (j >= len(nums)):
                break
            nums[i+1] = nums[j]
            i += 1
            cnt += 1
            # print(i, j)
            # print(nums)
        return cnt+1
            
        