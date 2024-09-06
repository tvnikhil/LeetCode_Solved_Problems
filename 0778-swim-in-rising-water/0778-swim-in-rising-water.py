# in the least cost path, max ele is answer - djikstra
# binary search with bfs or dfs
import heapq as pq

class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        # dijkstra (maxEle, node, pathCost)
        n = len(grid)
        dirs = [(-1,0), (0,1), (1,0), (0,-1)]
        que = []
        vis = set()
        pq.heappush(que, (grid[0][0], 0, 0))
        vis.add((0,0))
        
        while len(que)>0:
            maxEle, x, y = pq.heappop(que)
            if x == n-1 and y == n-1:
                return maxEle
            
            for dx, dy in dirs:
                nx, ny = x+dx, y+dy
                if ((nx>=0 and nx<=n-1) and (ny>=0 and ny<=n-1)) and (nx,ny) not in vis:
                    vis.add((nx,ny))
                    nMaxEle = max(maxEle, grid[nx][ny])
                    pq.heappush(que, (nMaxEle, nx, ny))
        
        return 0
            
        
        