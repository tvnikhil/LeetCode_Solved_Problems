# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Pair:
    def __init__(self, TreeNode, level=0):
        self.level = level
        self.node = TreeNode

class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        p = Pair(root)
        queue = [p]
        maxWidth = 0
        while len(queue):
            level = []
            currSize = len(queue)
            for i in range(currSize):
                curr = queue[0]
                queue.pop(0)
                level.append(curr)
                if curr.node.left:
                    queue.append(Pair(curr.node.left, 2 * (curr.level) + 1))
                if curr.node.right:
                    queue.append(Pair(curr.node.right, 2 * (curr.level) + 2))
            maxWidth = max(maxWidth, level[-1].level-level[0].level+1)
        return maxWidth
        