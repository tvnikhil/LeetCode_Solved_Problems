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
    int getDepth(TreeNode root, boolean flag) {
        TreeNode node = root;
        int depth = 0;
        while (node != null) {
            if (flag == true)
                node = node.left;
            else
                node = node.right;
            depth++;
        }
        return depth;
    }
    
    int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = getDepth(root, true);
        int rightDepth = getDepth(root, false);
        if (leftDepth == rightDepth)
            return (int) (Math.pow(2, leftDepth) - 1);
        return 1 + dfs(root.left) + dfs(root.right);
    }
    
    public int countNodes(TreeNode root) {
        return dfs(root);
    }
}