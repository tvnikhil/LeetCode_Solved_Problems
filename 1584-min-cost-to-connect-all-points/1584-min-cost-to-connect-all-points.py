import heapq as pq

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
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        # MST using kruskal's algorithm
        
        que = []
        n = len(points)
        for p1 in range(n):
            for p2 in range(p1+1, n):
                wt = abs(points[p1][0]-points[p2][0]) + abs(points[p1][1]-points[p2][1])
                pq.heappush(que, (wt, p1, p2))
        ans = 0
        cnt = 0
        djs = DisjointSet(n)
        
        while que and cnt < n-1:
            edge = pq.heappop(que)
            wt, u, v = edge[0], edge[1], edge[2]
            uComp, vComp = djs.findParent(u), djs.findParent(v)
            
            if uComp == vComp:
                continue
            else:
                ans += wt
                cnt += 1
                djs.unionBySize(u, v)
        
        return ans
            
        