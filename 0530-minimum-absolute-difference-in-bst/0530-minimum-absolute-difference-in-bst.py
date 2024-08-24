# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, root, ino):
        if not root: 
            return
        self.inorder(root.left, ino)
        ino.append(root.val)
        self.inorder(root.right, ino)
        
    
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        ino = []
        self.inorder(root, ino)
        i, j = 0, 1
        ans = float("inf")
        while j < len(ino):
            ans = min(ans, abs(ino[i]-ino[j]))
            i += 1
            j += 1
        return ans
        