class Tuple implements Comparable<Tuple> {
    int diff, x, y;
    public Tuple(int diff, int x, int y) {
        this.diff = diff;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Tuple other) {
        return Integer.compare(this.diff, other.diff);
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        PriorityQueue<Tuple> que = new PriorityQueue<>();
        que.offer(new Tuple(0,0,0));
        while (!que.isEmpty()) {
            Tuple curr = que.poll();
            int currDiff = curr.diff;
            int x = curr.x, y = curr.y;
            if (x == n-1 && y == m-1) return currDiff;
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i], ny = y+dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int nVal = heights[nx][ny];
                int val = heights[x][y];
                int newDiff = Math.max(currDiff, Math.abs(nVal-val));
                if (newDiff < dist[nx][ny]) {
                    dist[nx][ny] = newDiff;
                    que.offer(new Tuple(newDiff, nx, ny));
                }
            }
        }
        return 0;
    }
}