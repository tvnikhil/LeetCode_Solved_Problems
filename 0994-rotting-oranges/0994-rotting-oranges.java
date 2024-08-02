class Pair {
    public int x, y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    void addDiffs(List<Pair> diffs) {
        diffs.add(new Pair(1, 0));
        diffs.add(new Pair(-1, 0));
        diffs.add(new Pair(0, +1));
        diffs.add(new Pair(0, -1));
    }
    
    public int orangesRotting(int[][] grid) {
        Queue<Pair> que = new LinkedList<>();
        int time = 0, emptyCnt = 0, freshCnt = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) emptyCnt++;
                else if (grid[i][j] == 2) que.offer(new Pair(i, j));
                else freshCnt++;
            }
        }
        if (freshCnt == m * n) return -1;
        if (emptyCnt == m * n) return 0;
        List<Pair> diffs = new ArrayList<>();
        addDiffs(diffs);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Pair rotten = que.poll();
                for (int d = 0; d < 4; d++) {
                    Pair diff = diffs.get(d);
                    int delX = diff.x + rotten.x;
                    int delY = diff.y + rotten.y;
                    if ((delX >= 0 && delX < m) && (delY >= 0 && delY < n) 
                            && grid[delX][delY] == 1) {
                        freshCnt--;
                        grid[delX][delY] = 2;
                        que.offer(new Pair(delX, delY));
                    }
                }
            }
            time++;
        }
        if (freshCnt != 0) return -1;
        return time-1;
    }
}