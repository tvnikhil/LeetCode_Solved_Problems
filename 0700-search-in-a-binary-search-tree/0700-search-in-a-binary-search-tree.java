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
    TreeNode search(TreeNode root, int val) {
        if (root == null)
            return null;
        TreeNode left = null, right = null;
        if (root.val == val) return root;
        else if (val < root.val) left = search(root.left, val);
        else right = search(root.right, val);
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
    
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }
}