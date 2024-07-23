/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // boolean searchNode(TreeNode root, TreeNode target, List<TreeNode> path) {
    //     if (root == null)
    //         return false;
    //     path.add(root);
    //     if (root.equals(target)) return true;
    //     if (searchNode(root.left, target, path) || searchNode(root.right, target, path))
    //         return true;
    //     path.remove(path.size()-1);
    //     return false;
    // }
    
    TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.equals(p) || root.equals(q))
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        if (left == null)
            return right;
        return left;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
        
        // List<TreeNode> pPath = new ArrayList<>();
        // searchNode(root, p, pPath);
        // List<TreeNode> qPath = new ArrayList<>();
        // searchNode(root, q, qPath);
        // // for (int i = 0; i < pPath.size(); i++) {
        // //     System.out.print(pPath.get(i).val + " ");
        // // }
        // // for (int i = 0; i < qPath.size(); i++) {
        // //     System.out.print(qPath.get(i).val + " ");
        // // }
        // int i = 0, j = 0;
        // TreeNode ans = null;
        // while (i < pPath.size() && j < qPath.size()) {
        //     if (pPath.get(i) == qPath.get(j))
        //         ans = pPath.get(i);
        //     else
        //         break;
        //     i++;
        //     j++;
        // }
        // return ans;
    }
}