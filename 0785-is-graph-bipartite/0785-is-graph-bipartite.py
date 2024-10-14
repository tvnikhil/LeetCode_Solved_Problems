class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        V = len(graph)
        colors = [-1] * V
        
        def dfs(node, color):
            colors[node] = color
            
            for child in graph[node]:
                if colors[child] == color:
                    return False
                if colors[child] == -1:
                    if dfs(child, 1-color) == False:
                        return False
            
            return True
        
        for i in range(V):
            if colors[i] == -1:
                if dfs(i, 0) == False:
                    return False
        
        return True
        