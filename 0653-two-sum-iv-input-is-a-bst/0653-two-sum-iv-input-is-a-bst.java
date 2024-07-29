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
    boolean search(TreeNode root, int key, TreeNode a) {
        if (root == null)
            return false;
        if (root.val == key && a != root)
            return true;
        else if (root.val == key && a == root)
            return false;
        if (key < root.val)
            return search(root.left, key, a);
        else
            return search(root.right, key, a);
    }
    
    boolean dfs(TreeNode node, int k, TreeNode root) {
        if (node == null)
            return false;
        if (search(root, k-node.val, node)) return true;
        return (dfs(node.left, k, root) || dfs(node.right, k, root));
    }
    
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, root);
    }
}