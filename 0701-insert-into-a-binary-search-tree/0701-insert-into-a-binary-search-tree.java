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
    TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val > root.val)
            root.right = insert(root.right, val);
        else
            root.left = insert(root.left, val);
        return root;
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }
}