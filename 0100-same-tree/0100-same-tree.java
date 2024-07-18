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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        boolean left, right;
        if (p != null && q != null)
            left = isSameTree(p.left, q.left);
        else
            return false;
        if (p != null && q != null)
            right = isSameTree(p.right, q.right);
        else
            return false;
        return ((p.val == q.val) && left && right);
    }
}