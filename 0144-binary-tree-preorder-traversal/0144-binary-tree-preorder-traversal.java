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
    // void getPreOrder(TreeNode root, List<Integer> preOrder) {
    //     if (root == null)
    //         return;
    //     preOrder.add(root.val);
    //     getPreOrder(root.left, preOrder);
    //     getPreOrder(root.right, preOrder);
    // }
    
    // void getPreOrder(TreeNode root, List<Integer> preOrder) {
    //     Deque<TreeNode> dq = new LinkedList<>();
    //     dq.offerFirst(root);
    //     while (dq.size() > 0) {
    //         TreeNode node = dq.pollFirst();
    //         preOrder.add(node.val);
    //         if (node.right != null)
    //             dq.offerFirst(node.right);
    //         if (node.left != null)
    //             dq.offerFirst(node.left);
    //     }
    // }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        // if (root == null) return preOrder;
        // getPreOrder(root, preOrder);
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                preOrder.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr)
                    temp = temp.right;
                if (temp.right == null) {
                    preOrder.add(curr.val);
                    temp.right = curr;
                    curr = curr.left;
                }
                else {
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        return preOrder;
    }
}