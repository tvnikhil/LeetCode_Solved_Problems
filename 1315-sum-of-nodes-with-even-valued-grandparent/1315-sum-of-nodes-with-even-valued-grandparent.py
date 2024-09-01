# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findParents(self, root, parent, hm):
        if not root:
            return
        hm[root] = parent
        self.findParents(root.left, root, hm)
        self.findParents(root.right, root, hm)
    
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        hm = {}
        self.findParents(root, None, hm)
        que = deque([root])
        ans = 0
        while que:
            node = que.popleft()
            p = hm[node]
            if p is not None:
                gp = hm[p]
                if gp is not None and gp.val % 2 == 0:
                    ans += node.val
            if node.left:
                que.append(node.left)
            if node.right:
                que.append(node.right)
        return ans
        