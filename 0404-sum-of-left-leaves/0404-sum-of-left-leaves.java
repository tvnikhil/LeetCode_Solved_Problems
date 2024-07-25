/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int returnSum(TreeNode root, TreeNode parent) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            if (parent.left == root) return root.val;
            return 0;
        }
        parent = root;
        int left = returnSum(root.left, parent);
        int right = returnSum(root.right, parent);
        return left + right;
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        return returnSum(root, root);
    }
}