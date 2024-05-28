class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleaned = ""
        for i in range(len(s)):
            if (ord(s[i]) >= 97 and ord(s[i]) <= 122) or (ord(s[i]) >= 65 and ord(s[i]) <= 90) or (ord(s[i]) >= 48 and ord(s[i]) <= 57):
                cleaned += s[i].lower()
        if cleaned[::-1] == cleaned:
            return True
        return False
            