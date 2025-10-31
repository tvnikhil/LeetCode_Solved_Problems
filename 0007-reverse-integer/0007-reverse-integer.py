class Solution:
    def reverse(self, x: int) -> int:
        MAX_INT = 2**31 - 1 # 2147483647
        MIN_INT = -2**31 #-2147483648

        rev = 0
        y = abs(x)
        while y != 0:
            digit = y % 10
            if x < 0:
                if rev > abs(MIN_INT) // 10 or (rev == abs(MIN_INT) // 10 and digit > 8):
                    return 0
            if x >= 0:
                if (rev > MAX_INT // 10) or (rev == MAX_INT // 10 and digit > 7):
                    return 0
            
            rev = rev * 10 + digit
            y = y // 10
        
        return rev if x >= 0 else -rev