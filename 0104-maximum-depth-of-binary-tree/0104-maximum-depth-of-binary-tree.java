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
    int getMaxDepth(TreeNode root, int level, int maxLevel) {
        if (root == null)
            return level-1;
        int d1 = getMaxDepth(root.left, level+1, maxLevel);
        int d2 = getMaxDepth(root.right, level+1, maxLevel);
        maxLevel = Math.max(d1, d2);
        return maxLevel;
    }
    
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root, 1, 1);
    }
}