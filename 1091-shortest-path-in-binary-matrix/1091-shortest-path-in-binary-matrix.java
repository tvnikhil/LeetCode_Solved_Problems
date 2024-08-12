class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    boolean check(int x, int y, int n) {
        if ((x >= 0 && x <= n-1) && (y >= 0 && y <= n-1))
            return true;
        return false;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 1 && grid[0][0] == 0) return 1;
        if (grid[0][0] == 1) return -1;
        int level = 1;
        int[][] vis = new int[grid.length][grid[0].length];
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(0, 0));
        vis[0][0] = 1;
        int n = grid.length;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Pair node = que.poll();
                for (int xC = -1; xC <= 1; xC++) {
                    for (int yC = -1; yC <= 1; yC++) {
                        int delX = node.x + xC, delY = node.y + yC;
                        if (check(delX, delY, grid.length) 
                            && grid[delX][delY] == 0 
                            && vis[delX][delY] == 0) {
                            if (delX == n-1 && delY == n-1)
                                return level+1;
                            vis[delX][delY] = 1;
                            que.offer(new Pair(delX, delY));
                        }
                    }
                }
            }
            level += 1;
        }
        return -1;
    }
}