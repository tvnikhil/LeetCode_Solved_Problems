# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        q = [root]
        res = ""
        while q:
            size = len(q)
            for i in range(size):
                node = q.pop(0)
                if node:
                    res += str(node.val) + ","
                    q.append(node.left)
                    q.append(node.right)
                else:
                    res += "null,"
        return res[0:-1]

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        nodes = data.split(",")
        print(nodes)
        if nodes[0] == "null":
            return None
        root = TreeNode(nodes[0])
        q = [root]
        i, choice = 1, 0
        node, left, right = None, None, None
        while (i < len(nodes)):
            if choice == 0:
                while q[0] == None:
                    q.pop(0)
                node = q.pop(0)
                choice += 1
            else:
                if choice == 1:
                    if nodes[i] != "null":
                        left = TreeNode(int(nodes[i]))
                    else:
                        left = None
                    q.append(left)
                    choice += 1
                else:
                    if nodes[i] != "null":
                        right = TreeNode(int(nodes[i]))
                    else:
                        right = None
                    q.append(right)
                    choice = 0
                    node.left = left
                    node.right = right
                i += 1
        return root

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))