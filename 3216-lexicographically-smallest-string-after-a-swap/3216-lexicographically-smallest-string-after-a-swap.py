class Solution:
    def getSmallestString(self, s: str) -> str:
        ans = [s]
        n = len(s)
        i, j = 0, 1
        while j < n:
            a, b = int(s[i]), int(s[j])
            if a % 2 == b % 2:
                newString = s[:i] + s[j] + s[i] + s[j+1:]
                ans.append(newString)
            i, j = i+1, j+1
        return min(ans)
        