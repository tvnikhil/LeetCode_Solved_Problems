class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    adj[i][j] = 0;
                    adj[j][i] = 0;
                }
                else adj[i][j] = (int) 1e9;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            adj[edges[i][0]][edges[i][1]] = edges[i][2];
            adj[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        
        int cntAns = Integer.MAX_VALUE, cntCity = -1;
        
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][via] + adj[via][j]);
                }
            }
        }
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(adj[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++)
                if (i != j && adj[i][j] <= distanceThreshold) cnt++;
            if (cnt <= cntAns) {
                cntAns = cnt;
                cntCity = i;
            }
        }
        return cntCity;
    }
}