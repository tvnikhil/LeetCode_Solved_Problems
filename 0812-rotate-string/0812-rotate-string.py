class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if s == goal:
            return True
        new = str(s)
        for i in range(len(s)):
            new = new[1:] + new[0]
            if new == goal:
                return True
        return False
        