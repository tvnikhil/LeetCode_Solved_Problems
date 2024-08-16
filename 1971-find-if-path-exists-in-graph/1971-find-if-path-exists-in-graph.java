class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        //System.out.println(adj);
        int[] vis = new int[n];
        Queue<Integer> que = new LinkedList<>();
        que.offer(source);
        vis[source] = 1;
        while (!que.isEmpty()) {
            int curr = que.poll();
            if (curr == destination)
                return true;
            for (int neigh: adj.get(curr)) {
                if (vis[neigh] != 1) {
                    vis[neigh] = 1;
                    que.offer(neigh);
                }
            }
        }
        return false;
    }
}