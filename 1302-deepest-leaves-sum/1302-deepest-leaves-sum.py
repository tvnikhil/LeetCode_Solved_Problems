# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque

class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        que = deque([root])
        total = 0
        while que:
            total = 0
            for _ in range(len(que)):
                node = que.popleft()
                if not node.left and not node.right:
                    total += node.val
                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)
        return total
        