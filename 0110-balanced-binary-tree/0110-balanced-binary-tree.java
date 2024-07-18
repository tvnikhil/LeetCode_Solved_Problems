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
    int checkIsBalanced(TreeNode root, boolean[] a) {
        if (root == null)
            return -1;
        int lh = checkIsBalanced(root.left, a);
        int rh = checkIsBalanced(root.right, a);
        a[0] = (a[0] && (lh - rh <= 1 && lh - rh >= -1));
        return (1 + Math.max(lh, rh));
    }
    
    public boolean isBalanced(TreeNode root) {
        boolean[] a = new boolean[1];
        a[0] = true;
        checkIsBalanced(root, a);
        return a[0];
    }
}