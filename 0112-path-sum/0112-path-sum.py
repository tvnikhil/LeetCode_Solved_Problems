# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, root, target, curr):
        if not root:
            return False
        if not root.left and not root.right:
            if curr + root.val == target:
                return True
            else:
                return False
        if root.left:
            if self.dfs(root.left, target, curr+root.val):
                return True
        if root.right:
            if self.dfs(root.right, target, curr+root.val):
                return True
        return False
    
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        total = 0
        return self.dfs(root, targetSum, 0)
        