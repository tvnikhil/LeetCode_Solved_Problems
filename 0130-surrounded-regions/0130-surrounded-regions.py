class Solution:
    def dfs(self, x, y, board, visited):
        if x >= len(board) or x < 0 or y >= len(board[0]) or y < 0:
            return
        if visited[x][y] != 0 or board[x][y] != "O":
            return
        visited[x][y] = -1
        self.dfs(x+1, y, board, visited)
        self.dfs(x-1, y, board, visited)
        self.dfs(x, y+1, board, visited)
        self.dfs(x, y-1, board, visited)
    
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        rows, cols = len(board), len(board[0])
        visited = []
        for i in range(0, rows):
            temp = []
            for j in range(0, cols):
                temp.append(0)
            visited.append(temp)
        for i in range(0, rows):
            for j in range(0, cols):
                visited[i][j] = 0
        for i in range(0, cols):
            if board[0][i] == "O" and visited[0][i] == 0:
                self.dfs(0, i, board, visited)
        for i in range(0, rows):
            if board[i][0] == "O" and visited[i][0] == 0:
                self.dfs(i, 0, board, visited)
        for i in range(0, cols):
            if board[rows-1][i] == "O" and visited[rows-1][i] == 0:
                self.dfs(rows-1, i, board, visited)
        for i in range(0, rows):
            if board[i][cols-1] == "O" and visited[i][cols-1] == 0:
                self.dfs(i, cols-1, board, visited)
        for i in range(0, rows):
            for j in range(0, cols):
                if visited[i][j] == -1:
                    continue
                board[i][j] = "X"
        