class Solution:
    def dfs(self, src, adj, vis, ans):
        vis[src] = True

        prevSize, total = -1, 0
        flag = True
        for i in range(len(adj[src])):
            child = adj[src][i]
            if vis[child] == False:
                size = self.dfs(child, adj, vis, ans)
                total += size
                if prevSize != -1 and size != prevSize:
                    flag = False
                prevSize = size

        if flag == True: ans[0] += 1
        return 1 + total
        
    
    def countGoodNodes(self, edges: List[List[int]]) -> int:
        V = len(edges)+1
        adj = []
        vis = []
        for i in range(V):
            vis.append(False)
            adj.append([])
        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
        print(adj)
        ans = [0]
        self.dfs(0, adj, vis, ans)
        return ans[0]
        