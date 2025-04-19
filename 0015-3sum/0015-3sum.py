class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums = sorted(nums)
        ans = set()

        for i in range(0, len(nums)):
            hs = set()
            if i > 0 and nums[i-1] == nums[i]:
                continue
            for j in range(i+1, len(nums)):
                if -(nums[i] + nums[j]) in hs:
                    trip = sorted([nums[i], nums[j], -(nums[i]+nums[j])])
                    ans.add(tuple(trip))
                else:
                    hs.add(nums[j])
        
        return [list(t) for t in ans]