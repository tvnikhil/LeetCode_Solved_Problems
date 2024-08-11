class Solution:
    def topo(self, adj, V):
        indegree, que = [], []
        for i in range(V): indegree.append(0)
        for i in range(V):
            for neigh in adj[i]:
                indegree[neigh] += 1
        for i in range(V):
            if indegree[i] == 0:
                que.append(i)
        cnt = 0
        while len(que) > 0:
            size = len(que)
            for i in range(size):
                src = que.pop(0)
                if indegree[src] == 0: cnt += 1
                for neigh in adj[src]:
                    indegree[neigh] -= 1
                    if indegree[neigh] == 0: que.append(neigh)
        if cnt == V: return True
        return False
    
    def canFinish(self, V: int, prerequisites: List[List[int]]) -> bool:
        adj = []
        for i in range(V): adj.append([])
        for pre in prerequisites:
            adj[pre[1]].append(pre[0])
        return self.topo(adj, V)
        