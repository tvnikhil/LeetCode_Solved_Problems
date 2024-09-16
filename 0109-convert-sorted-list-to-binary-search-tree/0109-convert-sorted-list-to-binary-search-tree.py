# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def convert(self, low):
        if low == None:
            return low
        if low.next == None:
            return TreeNode(low.val)
        
        prev, slow, fast = None, low, low
        while (fast != None and fast.next != None):
            prev = slow
            slow = slow.next
            fast = fast.next.next
        root = TreeNode(slow.val)
        nextLow = slow.next
        slow.next = None
        prev.next = None
        
        root.left = self.convert(low)
        root.right = self.convert(nextLow)
        
        return root
    
    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        if not head:
            return head
        return self.convert(head)
        