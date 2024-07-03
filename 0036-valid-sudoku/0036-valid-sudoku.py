class Solution:
    def checkValidity(self, board, row, col):
        # check row
        num, n = board[row][col], len(board[0])
        for i in range(0, n):
            if i != col and num == board[row][i]:
                return False
        # check col
        m = len(board)
        for i in range(0, m):
            if i != row and num == board[i][col]:
                return False
        # check box
        startRow, startCol = 0, 0
        if col % 3 == 0: startCol = col
        elif col % 3 == 1: startCol = col-1
        else: startCol = col-2
        if row % 3 == 0: startRow = row
        elif row % 3 == 1: startRow = row-1
        else: startRow = row-2
        for i in range(startRow, startRow + 3):
            for j in range(startCol, startCol + 3):
                if i != row and j != col:
                    if board[i][j] == num:
                        return False
        return True
    
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        n, m = len(board), len(board[0])
        for i in range(n):
            for j in range(m):
                if board[i][j] != ".":
                    check = self.checkValidity(board, i, j)
                    if check == False:
                        return False
        return True
        