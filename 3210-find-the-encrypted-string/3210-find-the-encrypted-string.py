class Solution:
    def getEncryptedString(self, s: str, k: int) -> str:
        ans = ""
        l = len(s)
        for i in range(0, l):
            r = (i + k) % l
            ans += s[r]
        return ans