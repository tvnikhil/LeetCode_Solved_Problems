class Solution:
    def returnfloor(self, arr, target):
        low, high = 0, len(arr) - 1
        ans = -1
        while low <= high:
            mid = (low + high) // 2
            if arr[mid] < target:
                ans = mid
                low = mid + 1
            else:
                high = mid - 1
        return ans
    
    def clearDigits(self, s: str) -> str:
        ans = ""
        chars, digits = [], []
        for i in range(0, len(s)):
            if ord(s[i]) >= ord("a") and ord(s[i]) <= ord("z"):
                chars.append(i)
            else:
                digits.append(i)
        for i in digits:
            leftCharIdx = self.returnfloor(chars, i)
            chars.pop(leftCharIdx)
        for i in chars:
            ans += s[i]
        return ans
        
                
            