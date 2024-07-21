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
class Node implements Comparable<Node> {
    int level, value;
    Node (int level, int value) {
        this.level = level;
        this.value = value;
    }
    
    public int compareTo(Node other) {
        int levelComparison = Integer.compare(this.level, other.level);
        if (levelComparison != 0) {
            return levelComparison;
        }
        return Integer.compare(this.value, other.value);
    }
}

class Solution {
    void verticalOrder(TreeNode root, int level, int column, Map<Integer, ArrayList<Node>> hm,
                      int[] mini, int[] maxi) {
        if (root == null)
            return;
        if (hm.containsKey(column) == true) {
            ArrayList<Node> temp = new ArrayList<>(hm.get(column));
            temp.add(new Node(level, root.val));
            hm.put(column, temp);
        }
        else {
            ArrayList<Node> temp = new ArrayList<>();
            temp.add(new Node(level, root.val));
            hm.put(column, temp);
        }
        mini[0] = Math.min(mini[0], column);
        maxi[0] = Math.max(maxi[0], column);
        verticalOrder(root.left, level+1, column-1, hm, mini, maxi);
        verticalOrder(root.right, level+1, column+1, hm, mini, maxi);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, ArrayList<Node>> hm = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        int[] mini = new int[1];
        mini[0] = 1001;
        int[] maxi = new int[1];
        maxi[0] = -1001;
        verticalOrder(root, 0, 0, hm, mini, maxi);
        for (int i = mini[0]; i <= maxi[0]; i++) {
            ArrayList<Node> col = hm.get(i);
            ArrayList<Integer> temp = new ArrayList<>();
            Collections.sort(col);
            for (int j = 0; j < col.size(); j++)
                temp.add(col.get(j).value);
            ans.add(temp);
        }
        return (ans);
    }
}