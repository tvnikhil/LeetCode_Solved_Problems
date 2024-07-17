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
    void getPreOrder(TreeNode root, List<Integer> preOrder) {
        if (root == null)
            return;
        preOrder.add(root.val);
        getPreOrder(root.left, preOrder);
        getPreOrder(root.right, preOrder);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        getPreOrder(root, preOrder);
        return preOrder;
    }
}