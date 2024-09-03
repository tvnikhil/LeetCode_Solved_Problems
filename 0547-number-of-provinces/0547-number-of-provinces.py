class DisjointSet:
    def __init__(self, n):
        self.rank = [0] * n
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
     
    def unionByRank(self, u, v):
        upu, upv = self.findParent(u), self.findParent(v)
        if upu == upv:
            return
        upuRank, upvRank = self.rank[upu], self.rank[upv]
        
        if upuRank == upvRank:
            self.rank[upu] += 1
            self.parents[upv] = upu
        else:
            if upuRank < upvRank:
                self.parents[upu] = upv
            else:
                self.parents[upv] = upu    

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        edges = []
        n = len(isConnected)
        for i in range(n):
            for j in range(i+1, n):
                if isConnected[i][j] == 1:
                    edges.append((i, j))
        # using union find
        djs = DisjointSet(n)
        for u, v in edges:
            djs.unionBySize(u, v)

        parSet = set()
        for i in range(n):
            parSet.add(djs.findParent(i))
        
        return len(parSet)
        