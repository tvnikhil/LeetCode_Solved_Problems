# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def dfs(self, root, stk, mini):
        if root == None:
            return
        if root.left == None and root.right == None:
            char = chr(root.val+97)
            if mini[0] == "":
                mini[0] = char+stk
                return
            mini[0] = min(char+stk, mini[0])
            return
        char = chr(root.val+97)
        self.dfs(root.left, char+stk, mini)
        self.dfs(root.right, char+stk, mini)
    
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        mini = [""]
        stk = ""
        self.dfs(root, stk, mini)
        return mini[0]
        