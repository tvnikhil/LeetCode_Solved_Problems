# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def check(self, root, subRoot):
        if not root and not subRoot:
            return True
        if root and subRoot:
            return (root.val == subRoot.val) and self.check(root.left, subRoot.left) and self.check(root.right, subRoot.right)
        return False
        
    
    def dfs(self, root, subRoot):
        if not root:
            return False
        if root.val == subRoot.val:
            if self.check(root, subRoot) == True:
                return True
        if self.dfs(root.left, subRoot):
            return True
        if self.dfs(root.right, subRoot):
            return True
        return False
    
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        return self.dfs(root, subRoot)
        