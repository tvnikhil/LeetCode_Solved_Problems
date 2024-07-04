class Solution:
    def helper(self, board, idx, word, i, j, path):
        if idx == len(word):
            return True
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return False
        if (i, j) in path or board[i][j] != word[idx]:
            return False
        path.add((i, j))
        if (self.helper(board, idx + 1, word, i + 1, j, path) or
            self.helper(board, idx + 1, word, i - 1, j, path) or
            self.helper(board, idx + 1, word, i, j + 1, path) or
            self.helper(board, idx + 1, word, i, j - 1, path)):
            return True
        path.remove((i, j))
        return False
    
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if self.helper(board, 0, word, i, j, set()) == True:
                    return True
        return False