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
    def removeStones(self, stones: List[List[int]]) -> int:
        n = len(stones)
        djs = DisjointSet(n)
        rows,cols = {},{}
        
        for i in range(n):
            r, c = stones[i][0], stones[i][1]
            if r not in rows and c not in cols:
                rows[r], cols[c] = i, i
            elif r in rows and c in cols:
                rComp, cComp = djs.findParent(rows[r]), djs.findParent(cols[c])
                djs.unionBySize(i, rows[r])
                djs.unionBySize(rComp, cComp)
            elif r in rows and c not in cols:
                rComp = djs.findParent(rows[r])
                cols[c] = rComp
                djs.unionBySize(rComp, i)
            elif r not in rows and c in cols:
                cComp = djs.findParent(cols[c])
                rows[r] = cComp
                djs.unionBySize(cComp, i)
        
        ans = 0
        for i in range(n):
            if i == djs.parents[i]:
                ans += 1
        return n-ans
        