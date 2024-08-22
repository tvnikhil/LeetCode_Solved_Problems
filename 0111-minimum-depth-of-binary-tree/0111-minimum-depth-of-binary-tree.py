# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        que = deque([root])
        level = 1
        while que:
            size = len(que)
            for i in range(size):
                node = que.popleft()
                if not node.left and not node.right:
                    return level
                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)
            level += 1
        return 0
            
        