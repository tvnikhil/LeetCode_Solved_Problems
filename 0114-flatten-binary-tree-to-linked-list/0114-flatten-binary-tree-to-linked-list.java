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
    void flat(TreeNode root) {
        if (root == null)
            return;
        flat(root.left);
        flat(root.right);
        if (root.left == null && root.right == null)
            return;
        if (root.left != null && root.right != null) {
            TreeNode node = root.left;
            while (node.right != null)
                node = node.right;
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
        }
    }
    
    public void flatten(TreeNode root) {
        flat(root);
    }
}