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
    void getParents(TreeNode root, Map<TreeNode, TreeNode> childParent, TreeNode[] src, int target) {
        if (root == null)
            return;
        if (root.val == target)
            src[0] = root;
        if (root.left != null)
            childParent.put(root.left, root);
        if (root.right != null)
            childParent.put(root.right, root);
        getParents(root.left, childParent, src, target);
        getParents(root.right, childParent, src, target);
    }
    
    int bfs(TreeNode src, Map<TreeNode, TreeNode> childParent, Map<TreeNode, Boolean> visited) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(src);
        int time = 0, visitedCnt = 0;
        while (q.isEmpty() != true) {
            int length = q.size();
            for (int i = 0; i < length; i++) {
                TreeNode temp = q.poll();
                visited.put(temp, true);
                visitedCnt++;
                if (temp.left != null && visited.containsKey(temp.left) == false)
                    q.offer(temp.left);
                if (temp.right != null && visited.containsKey(temp.right) == false)
                    q.offer(temp.right);
                if (childParent.get(temp) != null && visited.containsKey(childParent.get(temp)) == false)
                    q.offer(childParent.get(temp));
            }
            if (visitedCnt == childParent.size())
                return time;
            time++;
        }
        return 0;
    }
    
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> childParent = new HashMap<>();
        TreeNode[] src = new TreeNode[1];
        childParent.put(root, null);
        getParents(root, childParent, src, start);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        int time = bfs(src[0], childParent, visited);
        return time;
    }
}