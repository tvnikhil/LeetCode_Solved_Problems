# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Pair:
    def __init__(self, TreeNode, idx=0):
        self.idx = idx
        self.node = TreeNode

class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        p = Pair(root)
        queue = [p]
        maxWidth = 0
        while len(queue):
            maxWidth = max(maxWidth, queue[-1].idx-queue[0].idx+1)
            currSize = len(queue)
            for i in range(currSize):
                curr = queue[0]
                queue.pop(0)
                if curr.node.left:
                    queue.append(Pair(curr.node.left, 2 * (curr.idx) + 1))
                if curr.node.right:
                    queue.append(Pair(curr.node.right, 2 * (curr.idx) + 2))
        return maxWidth
        