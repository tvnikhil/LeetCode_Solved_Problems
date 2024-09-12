"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        
        temp = root
        que = deque([root])
        
        while que:
            #level = []
            prev = None
            for i in range(len(que)):
                node = que.popleft()
                
                if not prev:
                    prev = node
                else:
                    prev.next = node
                    prev = node
                
                # level.append(node)
                if node.left:
                    que.append(node.left)
                if node.right:
                    que.append(node.right)
            # i = 1
            # while i < len(level):
            #     level[i-1].next = level[i]
            #     i += 1
        
        return temp
        