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
    void getPostOrder(TreeNode root, List<Integer> postOrder) {
        if (root == null)
            return;
        getPostOrder(root.left, postOrder);
        getPostOrder(root.right, postOrder);
        postOrder.add(root.val);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        getPostOrder(root, postOrder);
        return postOrder;
    }
}