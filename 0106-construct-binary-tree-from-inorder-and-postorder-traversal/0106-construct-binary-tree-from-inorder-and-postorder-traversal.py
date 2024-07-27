# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def construct(self, ino, post):
        if not ino or not post:
            return None
        root = TreeNode(post[-1])
        rootInoIdx = ino.index(post[-1])
        root.left = self.construct(ino[0:rootInoIdx], post[0:rootInoIdx])
        root.right = self.construct(ino[rootInoIdx+1:], post[rootInoIdx:-1])
        return root
    
    def buildTree(self, ino: List[int], post: List[int]) -> Optional[TreeNode]:
        return self.construct(ino, post)
        