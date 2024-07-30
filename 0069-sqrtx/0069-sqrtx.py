class Solution:
    def mySqrt(self, x: int) -> int:
        low = 0
        high = x
        ans = -1
        while low <= high:
            mid = (low + high) // 2
            val = mid * mid
            if (val == x):
                return mid
            if (val < x):
                ans = mid
                low = mid + 1
            else:
                high = mid - 1
        return ans
        