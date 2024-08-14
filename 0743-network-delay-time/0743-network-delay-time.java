class Pair implements Comparable<Pair> {
    int time, node;
    
    public Pair(int time, int node) {
        this.time = time;
        this.node = node;
    }
    
    @Override
    public int compareTo(Pair other) {
        if (this.time != other.time)
            return Integer.compare(this.time, other.time);
        return Integer.compare(this.node, other.node);
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] time : times) adj.get(time[0]-1).add(new int[]{time[1]-1, time[2]});
        int[] receiveTimes = new int[n];
        for (int i = 0; i < n; i++) receiveTimes[i] = Integer.MAX_VALUE;
        receiveTimes[k-1] = 0;
        PriorityQueue<Pair> pque = new PriorityQueue<>();
        pque.offer(new Pair(0, k-1));
        while (!pque.isEmpty()) {
            Pair curr = pque.poll();
            int currTime = curr.time, currNode = curr.node;
            for (int[] neigh: adj.get(currNode)) {
                int nextNode = neigh[0], nextTime = neigh[1];
                if (nextTime + currTime < receiveTimes[nextNode]) {
                    receiveTimes[nextNode] = nextTime + currTime;
                    pque.offer(new Pair(nextTime+currTime, nextNode));
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == k-1) continue;
            if (receiveTimes[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, receiveTimes[i]);
            //System.out.println(receiveTimes[i]);
        }
        return ans;
    }
}