class Solution(object):
    def maxDepth(self, s):
        """
        :type s: str
        :rtype: int
        """
        depth = 0
        maxDepth = 0
        
        for i in s:
            if i == "(":
                depth += 1
            elif i == ")":
                depth -= 1
            else:
                continue
            maxDepth = max(maxDepth, depth)
        
        return maxDepth
        