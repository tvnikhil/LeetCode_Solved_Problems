class Solution:
#     def dfs(self, src, adj, vis, path):
#         vis[src] = True
#         path[src] = True
#         for neigh in adj[src]:
#             if vis[neigh] == False:
#                 if self.dfs(neigh, adj, vis, path) == True:
#                     return True
#             elif path[neigh] == True:
#                 return True
#         path[src] = False
#         return False
    
#     def topo(self, src, adj, vis, stk):
#         vis[src] = True
#         for neigh in adj[src]:
#             if vis[neigh] == False:
#                 self.topo(neigh, adj, vis, stk)
#         stk.append(src)
        
    def topo(self, adj, V):
        indegree, que, ans = [], [], []
        for i in range(V): indegree.append(0)
        for i in range(V):
            for neigh in adj[i]:
                indegree[neigh] += 1
        for i in range(V):
            if indegree[i] == 0:
                que.append(i)
        while len(que) > 0:
            size = len(que)
            for i in range(size):
                src = que.pop(0)
                if indegree[src] == 0: ans.append(src)
                for neigh in adj[src]:
                    indegree[neigh] -= 1
                    if indegree[neigh] == 0: que.append(neigh)
        if len(ans) == V: return ans
        return []
    
    def findOrder(self, V: int, prerequisites: List[List[int]]) -> List[int]:
        # adj = []
        # for i in range(numCourses): adj.append([])
        # for pre in prerequisites:
        #     adj[pre[1]].append(pre[0])
        # print(adj)
        # vis, path = [], []
        # for i in range(numCourses):
        #     path.append(False)
        #     vis.append(False)
        # for i in range(numCourses):
        #     if vis[i] == False:
        #         if self.dfs(i, adj, vis, path) == True:
        #             return []
        # vis = []
        # stk = []
        # for i in range(numCourses): vis.append(False)
        # for i in range(numCourses):
        #     if vis[i] == False:
        #         self.topo(i, adj, vis, stk)
        # ans = []
        # while len(stk) > 0:
        #     ans.append(stk.pop())
        # return ans
        
        adj = []
        for i in range(V): adj.append([])
        for pre in prerequisites:
            adj[pre[1]].append(pre[0])
        return self.topo(adj, V)