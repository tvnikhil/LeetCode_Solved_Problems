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
    boolean check(TreeNode x, TreeNode y) {
        if (x == null && y == null)
            return true;
        if (x == null)
            return false;
        if (y == null)
            return false;
        boolean c1, c2;
        c1 = check(x.left, y.right);
        c2 = check(x.right, y.left);
        return ((x.val == y.val) && c1 && c2);
    }
    
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
}