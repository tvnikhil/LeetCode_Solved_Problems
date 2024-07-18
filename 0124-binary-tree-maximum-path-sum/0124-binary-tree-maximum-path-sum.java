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
    int getMaxPathSum(TreeNode root, int[] pathSum) {
        if (root == null)
            return 0;
        int leftSum = getMaxPathSum(root.left, pathSum);
        int rightSum = getMaxPathSum(root.right, pathSum);
        leftSum = (leftSum < 0) ? 0: leftSum;
        rightSum = (rightSum < 0) ? 0: rightSum;
        pathSum[0] = Math.max(pathSum[0], root.val+leftSum+rightSum);
        return (root.val + Math.max(leftSum, rightSum));
    }
    
    public int maxPathSum(TreeNode root) {
        int[] pathSum = new int[1];
        pathSum[0] = Integer.MIN_VALUE;
        getMaxPathSum(root, pathSum);
        return (pathSum[0]);
    }
}