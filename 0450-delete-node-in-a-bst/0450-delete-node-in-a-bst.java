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
    TreeNode delete(TreeNode root, int key) {
        if (root == null)
            return root;
        if (key > root.val)
            root.right = delete(root.right, key);
        else if (key < root.val)
            root.left = delete(root.left, key);
        else {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left != null && root.right == null)
                return root.left;
            else if (root.left == null && root.right != null)
                return root.right;
            else {
                TreeNode succ = root.right;
                while (succ.left != null)
                    succ = succ.left;
                root.val = succ.val;
                root.right = delete(root.right, succ.val);
            }
        }
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
}