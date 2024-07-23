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
    void getParents(TreeNode root, Map<TreeNode, TreeNode> childParent) {
        if (root == null)
            return;
        if (root.left != null)
            childParent.put(root.left, root);
        if (root.right != null)
            childParent.put(root.right, root);
        getParents(root.left, childParent);
        getParents(root.right, childParent);
    }
    
    void dfs(TreeNode src, int currDis, int dist, 
             List<Integer> ans, Map<TreeNode, TreeNode> childParent, 
             Map<TreeNode, Boolean> visited) {
        if (src == null)
            return;
        if (visited.containsKey(src) == true)
            return;
        if (currDis == dist) {
            ans.add(src.val);
            return;
        }
        visited.put(src, true);
        dfs(src.left, currDis+1, dist, ans, childParent, visited);
        dfs(src.right, currDis+1, dist, ans, childParent, visited);
        dfs(childParent.get(src), currDis+1, dist, ans, childParent, visited);
        visited.remove(src);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, TreeNode> childParent = new HashMap<>();
        childParent.put(root, null);
        getParents(root, childParent);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        dfs(target, 0, k, ans, childParent, visited);
        return ans;
    }
}