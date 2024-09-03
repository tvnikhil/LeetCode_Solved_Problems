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
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        n = len(accounts)
        djs = DisjointSet(n)
        hm = {}
        merged = defaultdict(list)
        ans = []
        
        for i in range(n):
            for mail in accounts[i][1:]:
                if mail not in hm:
                    hm[mail] = i
                else:
                    djs.unionBySize(i, hm[mail])
                    hm[mail] = i
        for i in hm:
            iComp = djs.findParent(hm[i])
            merged[iComp].append(i)
        for i in merged:
            merged[i].sort()
            ans.append([accounts[i][0]])
            for mail in merged[i]:
                ans[len(ans)-1].append(mail)
        
        return ans
        