# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, root):
        if not root:
            return (0, 0, 0)
        
        lst = self.dfs(root.left)
        rst = self.dfs(root.right)
        
        totalNodes = lst[0]+rst[0]+1
        totalSum = lst[1]+rst[1]+root.val
        totalCnt = lst[2]+rst[2]
        if totalSum // totalNodes == root.val:
            totalCnt += 1
        return (totalNodes, totalSum, totalCnt)
    
    def averageOfSubtree(self, root: TreeNode) -> int:
        return self.dfs(root)[2]
        