class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        ans = []
        minRows = []
        for i in matrix:
            minRows.append(min(i))
        maxCols = []
        for i in range(0, len(matrix[0])):
            maxi = matrix[0][i]
            for j in range(1, len(matrix)):
                maxi = max(maxi, matrix[j][i])
            maxCols.append(maxi)
        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                if matrix[i][j] == minRows[i] and matrix[i][j] == maxCols[j]:
                    ans.append(matrix[i][j])
        return ans
        