class Solution:
    def scoreOfString(self, s: str) -> int:
        score = 0
        asciiDict = {}
        for i in range(ord("a"), ord("z") + 1):
            asciiDict[chr(i)] = i
        for i in range(len(s) - 1):
            score += abs(asciiDict[s[i]] - asciiDict[s[i + 1]])
        return score
        