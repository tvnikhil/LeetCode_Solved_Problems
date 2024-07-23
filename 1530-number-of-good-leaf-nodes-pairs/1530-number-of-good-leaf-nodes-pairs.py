# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, root, ans, distance):
        if root == None:
            return []
        if root.left == None and root.right == None:
            return [1]
        left = self.dfs(root.left, ans, distance)
        right = self.dfs(root.right, ans, distance)
        for i in left:
            for j in right:
                if i+j <= distance:
                    ans[0] += 1
        leftRight = left + right
        return [i + 1 for i in leftRight]
    
    def countPairs(self, root: TreeNode, distance: int) -> int:
        ans = [0]
        self.dfs(root, ans, distance)
        return ans[0]