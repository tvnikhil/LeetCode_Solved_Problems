# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, root, ans, prev):
        if not root: return
        self.inorder(root.left, ans, prev)
        if prev[0] != -1: 
            ans[0] = min(ans[0], root.val-prev[0])
        prev[0] = root.val
        self.inorder(root.right, ans, prev)
    
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        prev = [-1]
        ans = [float("inf")]
        self.inorder(root, ans, prev)
        return ans[0]
        