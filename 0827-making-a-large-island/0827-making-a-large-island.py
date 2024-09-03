class DisjointSet:
    def __init__(self, n):
        self.parents = [i for i in range(n)]
        self.sizeOfSet = [1] * n
        
    def findParent(self, u):
        if u == self.parents[u]:
            return u
        self.parents[u] = self.findParent(self.parents[u])
        return self.parents[u]
    
    def unionBySize(self, u, v):
        upu, upv = self.findParent(u), self.findParent(v)
        if upu == upv:
            return
        upuSize, upvSize = self.sizeOfSet[upu], self.sizeOfSet[upv]
        if upuSize < upvSize:
            self.parents[upu] = upv
            self.sizeOfSet[upv] += self.sizeOfSet[upu]
        else:
            self.parents[upv] = upu
            self.sizeOfSet[upu] += self.sizeOfSet[upv]

class Solution:
    def largestIsland(self, grid: List[List[int]]) -> int:
        #DisjointSet using unionBySize
        #cell number (i,j) = i * c + j
        n = len(grid)
        djs = DisjointSet(n*n)
        dirs = [(-1,0), (0,1), (1,0), (0,-1)]
        ans = 0
        flag = False
        
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 1:
                    org = i * n + j
                    for dx, dy in dirs:
                        nx, ny = i+dx, j+dy
                        if ((nx>=0 and nx<=n-1) and (ny>=0 and ny<=n-1)):
                            if grid[nx][ny] == 1:
                                curr = nx * n + ny
                                djs.unionBySize(org, curr)
        for i in range(n):
            for j in range(n):
                if grid[i][j] == 0:
                    flag = True
                    compo = set()
                    for dx, dy in dirs:
                        nx, ny = i+dx, j+dy
                        if ((nx>=0 and nx<=n-1) and (ny>=0 and ny<=n-1)):
                            if grid[nx][ny] == 1:
                                curr = nx * n + ny
                                compo.add(djs.findParent(curr))
                    cnt = 1
                    for parent in compo:
                        cnt += djs.sizeOfSet[parent]
                    ans = max(ans, cnt)
        if flag == False:
            return djs.sizeOfSet[0]
        return ans
                    
        