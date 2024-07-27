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
        leftIno = ino[0:leftLimit]
        rightIno = ino[leftLimit+1:]
        leftPre = pre[1:1+len(leftIno)]
        rightPre = pre[1+len(leftPre):]
        root.left = self.construct(leftPre, leftIno)
        root.right = self.construct(rightPre, rightIno)
        return root
    
    def buildTree(self, pre: List[int], ino: List[int]) -> Optional[TreeNode]:
        root = self.construct(pre, ino)
        return root
        