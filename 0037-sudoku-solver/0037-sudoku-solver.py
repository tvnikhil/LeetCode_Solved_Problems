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
    
    def helper(self, board, row, col):
        if (row == 9):
            return True
        if col == 9:
            return self.helper(board, row+1, 0)
        if board[row][col] != ".":
            return self.helper(board, row, col + 1)
        else:
            for i in range(1, 10):
                board[row][col] = str(i)
                check = self.checkValidity(board, row, col)
                if check == True:
                    if self.helper(board, row, col + 1):
                        return True
                board[row][col] = "."
        return False
                        
    
    def solveSudoku(self, board) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.helper(board, 0, 0)