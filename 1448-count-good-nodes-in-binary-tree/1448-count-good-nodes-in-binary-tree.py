# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, src, grPath, ans):
        if not src:
            return
        #print(src.val, path, grPath)
        if src.val >= grPath: ans[0] += 1
        self.dfs(src.left, max(grPath, src.val), ans)
        self.dfs(src.right, max(grPath, src.val), ans)
    
    def goodNodes(self, root: TreeNode) -> int:
        ans = [0]
        self.dfs(root, float("-inf"), ans)
        return ans[0]
        