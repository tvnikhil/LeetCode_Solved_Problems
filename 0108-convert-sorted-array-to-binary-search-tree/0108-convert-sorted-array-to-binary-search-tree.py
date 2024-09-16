# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def convert(self, nums, low, high):
        if low > high or high < low:
            return None
        if low == high:
            return TreeNode(nums[low])
        mid = (low+high) // 2
        root = TreeNode(nums[mid]) # 0 # -10 
        root.left = self.convert(nums, low, mid-1) #[-10, -3]
        root.right = self.convert(nums, mid+1, high) #[5,9]
        return root
    
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        # [-10,-3] [0] [5,9] 0 asks for left child root and right child root
        # [-10] [-3] -10 asks for left and right child roots if low=high return nums[low]
        # [5] [9]
        
        root = self.convert(nums, 0, len(nums)-1)
        return root