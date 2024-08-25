class Solution:
    def dfs(self, node, graph, colors, color):
        colors[node] = color
        
        for neigh in graph[node]:
            if color == colors[neigh]:
                return False
            if colors[neigh] == -1:
                if self.dfs(neigh, graph, colors, 1-color) == False:
                    return False
        
        return True
        
    
    def isBipartite(self, graph: List[List[int]]) -> bool:
        V = len(graph)
        colors = [-1] * V
        for i in range(V):
            if colors[i] == -1:
                if self.dfs(i, graph, colors, 0) == False:
                    return False
        return True