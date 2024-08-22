from collections import deque

class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1: return [0]
        degree = [0] * n
        for i in edges:
            degree[i[0]] += 1
            degree[i[1]] += 1
        adj = [[] for _ in range(n)]
        for i in edges:
            adj[i[0]].append(i[1])
            adj[i[1]].append(i[0])
        que = []
        for i in range(n):
            if degree[i] == 1:
                que.append(i)
        que = deque(que)
        rem = n
        while que:
            if rem <= 2:
                return que
            for i in range(len(que)):
                node = que.popleft()
                rem -= 1
                for neigh in adj[node]:
                    degree[neigh] -= 1
                    if degree[neigh] == 1:
                        que.append(neigh)
        return que
                