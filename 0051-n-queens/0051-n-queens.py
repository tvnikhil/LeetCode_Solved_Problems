class Solution:
    def convertBoard(self, board):
        ans = []
        for i in range(0, len(board)):
            row = ""
            for j in board[i]:
                row += j
            ans.append(row)
        return ans
    
    def checkValidity(self, board, n, row, col):
        # check row
        for i in range(0, n):
            if i != col and board[row][i] == "Q":
                return False
        # check cols
        for i in range(0, n):
            if i != row and board[i][col] == "Q":
                return False
        # check 4 diagonals
        i, j = row, col
        while (i >= 0 and i < n) and (j >= 0 and j < n):
            if i != row and j != col and board[i][j] == "Q":
                return False
            i, j = i + 1, j + 1
        
        i, j = row, col
        while (i >= 0 and i < n) and (j >= 0 and j < n):
            if i != row and j != col and board[i][j] == "Q":
                return False
            i, j = i + 1, j - 1
            
        i, j = row, col
        while (i >= 0 and i < n) and (j >= 0 and j < n):
            if i != row and j != col and board[i][j] == "Q":
                return False
            i, j = i - 1, j + 1
        
        i, j = row, col
        while (i >= 0 and i < n) and (j >= 0 and j < n):
            if i != row and j != col and board[i][j] == "Q":
                return False
            i, j = i - 1, j - 1
        
        return True
    
    def placeQueens(self, n, queensCnt, board, rowCnt, ans):
        if rowCnt == n and queensCnt == n:
            strBoard = self.convertBoard(board)
            ans.append(list(strBoard))
        if rowCnt == n:
            return
        for i in range(0, n):
            board[rowCnt][i] = "Q"
            queensCnt += 1
            if self.checkValidity(board, n, rowCnt, i):
                self.placeQueens(n, queensCnt, board, rowCnt+1, ans)
            board[rowCnt][i] = "."
            queensCnt -= 1
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        if n == 1:
            return [["Q"]]
        if n == 2 or n == 3:
            return []
        ans = []
        board = []
        for i in range(0, n):
            row = []
            for i in range(0, n):
                row.append(".")
            board.append(row)
        self.placeQueens(n, 0, board, 0, ans)
        return ans
        