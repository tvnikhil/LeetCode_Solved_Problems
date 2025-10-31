class Solution:
    def isPalindrome(self, x: int) -> bool:
        # 123321
        # 12332, 1; 1233, 12; 123, 123 -- palindrome

        # 123124
        # 12312, 4; 1231, 42; 123, 421

        # 12321; 1232, 1; 123, 12; 12, 123

        if x < 0:
            return False
        if x == 0:
            return True
        if x % 10 == 0:
            return False
        
        reverted_number = 0

        while x > reverted_number:
            reverted_number = reverted_number * 10 + x % 10
            x = x // 10
        
        if reverted_number == x or reverted_number // 10 == x:
            return True
        
        return False
        