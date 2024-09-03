import heapq

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
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        djs = DisjointSet(n)
        for u, v in connections:
            djs.unionBySize(u,v)
        
        rootSizes = {}
        currEdges = 0
        for i in djs.parents:
            par = djs.findParent(i)
            if par not in rootSizes:
                rootSizes[par] = djs.sizeOfSet[par]
                currEdges += rootSizes[par]-1
        
        nc = len(rootSizes)
        if len(connections) - currEdges >= nc-1:
            return nc-1
        return -1
        
        
        