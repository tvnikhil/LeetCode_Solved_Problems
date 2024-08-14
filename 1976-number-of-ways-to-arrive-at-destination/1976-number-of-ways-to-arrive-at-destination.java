class Pair implements Comparable<Pair> {
    public long time;
    public long node;
    
    public Pair(long t, long n) {
        this.node = n;
        this.time = t;
    }
    
    @Override
    public int compareTo(Pair other) {
        if (this.time != other.time)
            return Long.compare(this.time, other.time);
        return Long.compare(this.node, other.node);
    }
}

class Solution {
//     void dfs(int src, List<List<int[]>> adj, int[] vis, int currTime, int[] ans, int minTime) {
//         //System.out.println(src);
//         if (currTime > minTime) return;
//         if (src == adj.size()-1 && currTime == minTime) {
//             ans[0]++;
//             return;
//         }
//         if (src == adj.size()-1) return;
//         vis[src] = 1;
//         for (int[] road: adj.get(src)) {
//             int neigh = road[0], time = road[1];
//             if (vis[neigh] == 0) {
//                 vis[neigh] = 1;
//                 dfs(neigh, adj, vis, currTime + time, ans, minTime);
//                 vis[neigh] = 0;
//             }
//         }
        
//     }
    
    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] road : roads) {
            adj.get(road[0]).add(new long[]{road[1], road[2]});
            adj.get(road[1]).add(new long[]{road[0], road[2]});
        }
        // for (int i = 0; i < adj.size(); i++) {
        //     System.out.println(i);
        //     for (int j = 0; j < adj.get(i).size(); j++) {
        //         System.out.println(adj.get(i).get(j)[0] + " " + adj.get(i).get(j)[1]);
        //     }
        // }
        long[] travelTimes = new long[n];
        long[] ways = new long[n];
        ways[0] = 1;
        for (int i = 0; i < n; i++) travelTimes[i] = Long.MAX_VALUE;
        travelTimes[0] = 0;
        PriorityQueue<Pair> pque = new PriorityQueue<>();
        pque.offer(new Pair(0, 0));
        int mod = (int) (1e9 + 7);
        while (!pque.isEmpty()) {
            Pair curr = pque.poll();
            long currNode = curr.node, currTime = curr.time;
            if (currNode == n - 1)
                break;
            for (long[] road : adj.get((int) currNode)) {
                long neigh = road[0], t = road[1];
                if (t + currTime < travelTimes[(int) neigh]) {
                    travelTimes[(int) neigh] = t + currTime;
                    pque.offer(new Pair(travelTimes[(int) neigh], neigh));
                    ways[(int) neigh] = ways[(int) currNode];
                } else if (t + currTime == travelTimes[(int) neigh]) {
                    ways[(int) neigh] = (ways[(int) neigh] + ways[(int) currNode]) % mod;
                }
            }
        }
        return (int) (ways[n - 1] % mod);
    }
}