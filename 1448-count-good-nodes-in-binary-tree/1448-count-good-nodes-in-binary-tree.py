# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, src, grPath):
        if not src:
            return 0
        isGood = 1 if src.val >= grPath else 0
        left = self.dfs(src.left, max(grPath, src.val))
        right = self.dfs(src.right, max(grPath, src.val))
        return isGood+left+right
    
    def goodNodes(self, root: TreeNode) -> int:
        return self.dfs(root, float("-inf"))
        