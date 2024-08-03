class Solution:
    def minFlips(self, grid: List[List[int]]) -> int:
        rAns = 0
        for i in range(0, len(grid)):
            p, q = 0, len(grid[0])-1
            while p <= q:
                if grid[i][p] != grid[i][q]:
                    rAns += 1
                p += 1
                q -= 1
        cAns = 0
        for i in range(0, len(grid[0])):
            p, q = 0, len(grid)-1
            while p <= q:
                if grid[p][i] != grid[q][i]:
                    cAns += 1
                p += 1
                q -= 1
        return min(rAns, cAns)       