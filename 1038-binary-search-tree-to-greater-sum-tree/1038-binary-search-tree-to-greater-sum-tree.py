# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, root, prevSum):
        if not root:
            return
        self.helper(root.right, prevSum)
        temp = root.val
        root.val += prevSum[0]
        prevSum[0] += temp
        self.helper(root.left, prevSum)
    
    def bstToGst(self, root: TreeNode) -> TreeNode:
        prevSum = [0]
        self.helper(root, prevSum);
        return root
        