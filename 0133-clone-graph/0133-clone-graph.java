/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    void dfs(Node node, Set<Node> vis, Node cpy, Map<Integer, Node> hm) {
        vis.add(node);
        for (Node neigh: node.neighbors) {
            if (hm.containsKey(neigh.val) == false)
                hm.put(neigh.val, new Node(neigh.val));
            cpy.neighbors.add(hm.get(neigh.val));
            if (!vis.contains(neigh))
                dfs(neigh, vis, hm.get(neigh.val), hm);
        }
    }
    
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Set<Node> vis = new HashSet<>();
        Map<Integer, Node> hm = new HashMap<>();
        hm.put(node.val, new Node(node.val));
        dfs(node, vis, hm.get(node.val), hm);
        return hm.get(node.val);
    }
}