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
    void helper(TreeNode root, TreeNode[] toSwap, TreeNode[] prev) {
        if (root == null)
            return;
        helper(root.left, toSwap, prev);
        if (prev[0] != null && root.val < prev[0].val) {
            if (toSwap[0] == null) {
                toSwap[0] = prev[0];
                toSwap[1] = root;
            }
            else {
                toSwap[1] = root;
            }
        }
        prev[0] = root;
        helper(root.right, toSwap, prev);
    }
    
    public void recoverTree(TreeNode root) {
        TreeNode[] toSwap = new TreeNode[2];
        toSwap[0] = null;
        toSwap[1] = null;
        TreeNode[] prev = new TreeNode[1];
        prev[0] = null;
        helper(root, toSwap, prev);
        int temp = toSwap[0].val;
        toSwap[0].val = toSwap[1].val;
        toSwap[1].val = temp;
    }
}