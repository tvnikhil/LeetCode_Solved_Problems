class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        que, ans, indegree, V = [], [], [], len(graph)
        rev = []
        for i in range(V):
            indegree.append(0)
            rev.append([])
        for i in range(V):
            for neigh in graph[i]:
                rev[neigh].append(i)
        for i in range(V):
            for neigh in rev[i]:
                indegree[neigh] += 1
        safe = []
        for i in range(V):
            if indegree[i] == 0:
                que.append(i)
        while len(que) > 0:
            size = len(que)
            for i in range(size):
                src = que.pop(0)
                safe.append(src)
                for neigh in rev[src]:
                    indegree[neigh] -= 1
                    if indegree[neigh] == 0:
                        que.append(neigh)
        safe = sorted(safe)
        return safe        
        
        