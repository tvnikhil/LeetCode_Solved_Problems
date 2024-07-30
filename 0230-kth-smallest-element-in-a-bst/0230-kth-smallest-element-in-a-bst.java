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
    int inorder(TreeNode root, int k, int[] i) {
        if (root == null)
            return -1;
        int a = inorder(root.left, k, i);
        i[0]++;
        if (i[0] == k) return root.val;
        int b = inorder(root.right, k, i);
        if (a != -1) return a;
        if (b != -1) return b;
        return -1;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        int[] i = new int[1];
        return inorder(root, k, i);
    }
}