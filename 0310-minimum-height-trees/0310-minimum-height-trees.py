from collections import deque

class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1: return [0]
        adj = [[] for _ in range(n)]
        que = deque()
        degree = [0] * n
        for st, end in edges:
            degree[st] += 1
            degree[end] += 1
            adj[st].append(end)
            adj[end].append(st)
        for i in range(n):
            if degree[i] == 1:
                que.append(i)
        rm = n
        while que:
            if rm <= 2:
                return que
            for i in range(len(que)):
                curr = que.popleft()
                degree[curr] -= 1
                rm -= 1
                for neigh in adj[curr]:
                    degree[neigh] -= 1
                    if degree[neigh] == 1:
                        que.append(neigh)
        return None