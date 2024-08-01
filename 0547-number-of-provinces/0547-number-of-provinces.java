class Solution {
    void dfs(int src, int[][] graph, boolean[] visited) {
        int nodesCnt = graph.length;
        for(int j = 0; j < nodesCnt; j++) {
            if (j != src && graph[src][j] == 1 && visited[j] == false) {
                visited[j] = true;
                dfs(j, graph, visited);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int nodeCnt = isConnected.length;
        boolean[] visited = new boolean[nodeCnt];
        int ans = 1;
        for (int i = 0; i < nodeCnt; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, isConnected, visited);
                for (int k = i; k < nodeCnt; k++) {
                    if (visited[k] == false) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}