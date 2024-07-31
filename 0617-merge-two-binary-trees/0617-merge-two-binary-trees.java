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
    void dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return;
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
        }
        boolean flag1 = false, flag2 = false;
        if (root1.left == null && root2.left != null) {
            root1.left = root2.left;
            flag1 = true;
        }
        if (root1.right == null && root2.right != null) {
            root1.right = root2.right;
            flag2 = true;
        }
        if (flag1 == false)
            dfs(root1.left, root2.left);
        if (flag2 == false)
            dfs(root1.right, root2.right);
    }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        dfs(root1, root2);
        return root1;
    }
}