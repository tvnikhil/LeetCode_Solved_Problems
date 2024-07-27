# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def construct(self, pre, ino):
        if len(pre) == 0 or len(ino) == 0: return None
        root = TreeNode(pre[0])
        leftLimit = ino.index(pre[0])
        root.left = self.construct(pre[1:1+leftLimit], ino[0:leftLimit])
        root.right = self.construct(pre[1+leftLimit:], ino[leftLimit+1:])
        return root
    
    def buildTree(self, pre: List[int], ino: List[int]) -> Optional[TreeNode]:
        root = self.construct(pre, ino)
        return root
        