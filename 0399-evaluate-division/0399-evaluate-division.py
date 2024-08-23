from collections import deque

class Solution:
    def bfs(self, src, dest, adj):
        n = len(adj)
        res = 1
        vis = {}
        for i in adj: vis[i] = False
        que = deque()
        que.append([src, 1])
        vis[src] = True
        while que:
            node = que.popleft()
            if node[0] == dest: return node[1]
            for neigh, wt in adj[node[0]]:
                if vis[neigh] == False:
                    vis[neigh] = True
                    que.append([neigh, node[1]*wt])
        return -1
            
    
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        
        adj = {}
        
        for i in equations:
            if i[0] not in adj: adj[i[0]] = []
            if i[1] not in adj: adj[i[1]] = []
        
        for i in range(len(equations)):
            adj[equations[i][0]].append((equations[i][1], values[i]))
            adj[equations[i][1]].append((equations[i][0], 1/values[i]))
        
        n = len(adj)
        
        ans = []
        for que in queries:
            src = que[0]
            dest = que[1]
            if src not in adj or dest not in adj:
                ans.append(-1)
            else:
                ans.append(self.bfs(src, dest, adj))

        return ans