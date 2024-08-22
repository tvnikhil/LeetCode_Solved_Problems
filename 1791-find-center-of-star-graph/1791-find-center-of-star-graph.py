class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        V = len(edges)+1
        graph = []
        for i in range(V): graph.append(0)
        for i in edges:
            graph[i[0]-1] += 1
            graph[i[1]-1] += 1
        for i in range(V):
            if graph[i] == V-1:
                return i+1
        return 0
        