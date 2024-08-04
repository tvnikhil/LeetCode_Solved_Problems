class Pair {
    public int x, y;
    public Pair (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    boolean checkRange(int x, int y, int X, int Y) {
        if (x < 0 || x >= X) return false;
        if (y < 0 || y >= Y) return false;
        return true;
    }
    
    void bfs(int x, int y, int[][] mat, int[][] res, Queue<Pair> que,
            boolean[][] visited) {
        int dist = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Pair src = que.poll();
                if (mat[src.x][src.y] == 1)
                    res[src.x][src.y] = dist-1;
                if (checkRange(src.x+1, src.y, mat.length, mat[0].length) 
                    && visited[src.x+1][src.y] == false) {
                    visited[src.x+1][src.y] = true;
                    que.offer(new Pair(src.x+1, src.y));
                }
                if (checkRange(src.x-1, src.y, mat.length, mat[0].length) 
                    && visited[src.x-1][src.y] == false) {
                    visited[src.x-1][src.y] = true;
                    que.offer(new Pair(src.x-1, src.y));
                }   
                if (checkRange(src.x, src.y+1, mat.length, mat[0].length) 
                    && visited[src.x][src.y+1] == false) {
                    visited[src.x][src.y+1] = true;
                    que.offer(new Pair(src.x, src.y+1));
                }   
                if (checkRange(src.x, src.y-1, mat.length, mat[0].length) 
                    && visited[src.x][src.y-1] == false) {
                    visited[src.x][src.y-1] = true;
                    que.offer(new Pair(src.x, src.y-1));
                }
            }
            dist++;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] res = new int[rows][cols];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    que.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        bfs(0, 0, mat, res, que, visited);
        return res;
    }
}