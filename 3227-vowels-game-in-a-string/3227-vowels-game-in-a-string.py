class Solution:
    def doesAliceWin(self, s: str) -> bool:
        vowels = ["a", "e", "i", "o", "u"]
        for i in s:
            if i in vowels:
                return True
        return False