class Solution:
    def generate(self, currString, currLen, maxLen, nums):
        if currLen == maxLen:
            if currString not in nums:
                return str(currString)
            return ""
        absent1 = self.generate(currString+"0", currLen+1, maxLen, nums)
        if absent1 != "": return absent1
        absent2 = self.generate(currString+"1", currLen+1, maxLen, nums)
        if absent2 != "": return absent2
        return ""
    
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        d = dict()
        for i in range(0, len(nums)):
            d[nums[i]] = 1
        absent = self.generate("", 0, len(nums[0]), d)
        return absent
        