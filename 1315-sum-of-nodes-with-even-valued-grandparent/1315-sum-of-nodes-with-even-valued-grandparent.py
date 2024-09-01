# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # def findParents(self, root, parent, hm):
    #     if not root:
    #         return
    #     hm[root] = parent
    #     self.findParents(root.left, root, hm)
    #     self.findParents(root.right, root, hm)
    
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        hm = {}
        # self.findParents(root, None, hm)
        que = deque([root])
        ans = 0
        hm[root] = None
        
        while que:
            node = que.popleft()
            if node.left:
                que.append(node.left)
                gp = hm[node]
                if gp is not None and gp.val % 2 == 0:
                    ans += node.left.val
                hm[node.left] = node
            if node.right:
                que.append(node.right)
                gp = hm[node]
                if gp is not None and gp.val % 2 == 0:
                    ans += node.right.val
                hm[node.right] = node
        return ans
        