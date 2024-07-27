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
    // void getInOrder(TreeNode root, List<Integer> inOrder) {
    //     // if (root == null)
    //     //     return;
    //     // getInOrder(root.left, inOrder);
    //     // inOrder.add(root.val);
    //     // getInOrder(root.right, inOrder);
    //     Stack<TreeNode> stk = new Stack<>();
    //     TreeNode node = root;
    //     while (true) {
    //         if (node != null) {
    //             stk.push(node);
    //             node = node.left;
    //         }
    //         else if (node == null && stk.isEmpty() == true)
    //             break;
    //         else {
    //             node = stk.pop();
    //             inOrder.add(node.val);
    //             node = node.right;
    //         }
    //     }
    // }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        // getInOrder(root, inOrder);
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inOrder.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                else {
                    inOrder.add(curr.val);
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        return inOrder;
    }
}