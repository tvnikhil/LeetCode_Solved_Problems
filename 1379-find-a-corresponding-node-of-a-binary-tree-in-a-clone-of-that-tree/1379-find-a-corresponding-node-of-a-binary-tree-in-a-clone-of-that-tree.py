# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def search(self, root, target):
        if not root or root.val == target.val:
            return root
        left = self.search(root.left, target)
        right = self.search(root.right, target)
        if left: return left
        if right: return right
        return None
    
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        return self.search(cloned, target)
        