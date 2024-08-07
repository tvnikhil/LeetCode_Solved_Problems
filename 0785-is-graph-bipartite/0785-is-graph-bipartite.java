class Solution {
    boolean dfs(int src, int[][] graph, int[] colors, int col) {
        colors[src] = col;
        for (int child = 0; child < graph[src].length; child++) {
            int neigh = graph[src][child];
            if (colors[neigh] == -1) {
                if (dfs(neigh, graph, colors, 1-col) == false)
                    return false;
            }
            else if (colors[neigh] == col) return false;
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) colors[i] = -1;
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1)
                if (dfs(i, graph, colors, 0) == false)
                    return false;
        }
        return true;
    }
}