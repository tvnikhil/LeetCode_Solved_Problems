class Solution {
    void dfs(int[][] graph, int sr, int sc, int newColor, int oldColor, int[][] visited) {
        if (sr < 0 || sr >= graph.length || sc < 0 || sc >= graph[0].length)
            return;
        if (visited[sr][sc] == 1) return;
        if (oldColor != graph[sr][sc]) return;
        visited[sr][sc] = 1;
        graph[sr][sc] = newColor;
        dfs(graph, sr+1, sc, newColor, oldColor, visited);
        dfs(graph, sr, sc+1, newColor, oldColor, visited);
        dfs(graph, sr, sc-1, newColor, oldColor, visited);
        dfs(graph, sr-1, sc, newColor, oldColor, visited);
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] visited = new int[image.length][image[0].length];
        dfs(image, sr, sc, color, image[sr][sc], visited);
        return image;
    }
}