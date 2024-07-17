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
    void getInOrder(TreeNode root, List<Integer> inOrder) {
        if (root == null)
            return;
        getInOrder(root.left, inOrder);
        inOrder.add(root.val);
        getInOrder(root.right, inOrder);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);
        return inOrder;
    }
}